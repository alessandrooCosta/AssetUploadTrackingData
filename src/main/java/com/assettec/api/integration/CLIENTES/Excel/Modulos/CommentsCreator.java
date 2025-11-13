package com.assettec.api.integration.CLIENTES.Excel.Modulos;

import com.assettec.api.integration.CLIENTES.Excel.CaminhoArquivoGUI;
import com.assettec.api.integration.CLIENTES.Excel.StyledLabel;
import com.assettec.api.integration.CLIENTES.Excel.WorkOrderCreationService;
import com.assettec.api.internal.core.entities.asset.AssetService;
import com.assettec.api.internal.core.entities.orders.workorder.WorkOrderService;
import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.users.ApiUserService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.swing.*;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class CommentsCreator {

    private ApiUserService apiUserService;
    private WorkOrderCreationService workOrderCreationService;

    public CommentsCreator(ApiUserService apiUserService, WorkOrderCreationService workOrderCreationService, JLabel resultadoLabel, CaminhoArquivoGUI caminhoArquivoGUI) {
        this.apiUserService = apiUserService;
        this.workOrderCreationService = workOrderCreationService;
        this.resultadoLabel = resultadoLabel;
    }

    private AssetService assetService;

    private WorkOrderService workOrderService;

    private StyledLabel styledLabel;
    private JTextField caminhoTextField;
    private JComboBox<String> guiaDropdown;
    private JTextField tokenTextField;
    private JTextField serverTextField;
    private JTextField portTextField;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JTextField organizationTextField;
    private JLabel  resultadoLabel;
    private JTextField tenantTextField;
    private JButton selecionarButton;
    private JButton executarButton;
    private JButton salvarInformacoesButton;
    private String caminhoPlanilha;
    public void createComments(String token, String caminhoPlanilha, String selectedGuia) {
            try {
                ApiUser apiUser = apiUserService.findByToken(token);

                FileInputStream file = new FileInputStream(new File(caminhoPlanilha));
                Workbook workbook = new XSSFWorkbook(file);
                Sheet sheet = workbook.getSheet(selectedGuia);
                if (sheet == null) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            resultadoLabel.setForeground(Color.RED);
                            resultadoLabel.setText("Guia não encontrada na planilha.");
                        }
                    });
                    return;
                }

                DataFormatter dataFormatter = new DataFormatter();
                Map<String, Integer> columnIndexMap = new HashMap<>();

                // Read the header row to determine column names and indices
                Row headerRow = sheet.getRow(0);
                for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                    Cell cell = headerRow.getCell(i);
                    String columnName = dataFormatter.formatCellValue(cell).trim(); // Remove quaisquer espaços iniciais ou finais
                    columnIndexMap.put(columnName, i);
                }
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);

                    // Verifica se a primeira célula da linha não está vazia
                    if (row != null && row.getCell(0) != null && !row.getCell(0).toString().isEmpty()) {
                        String OS = getColumnValue(row, columnIndexMap, "OS", dataFormatter);
                        String language = getColumnValue(row, columnIndexMap, "Language", dataFormatter);
                        String comment = getColumnValue(row, columnIndexMap, "Comment", dataFormatter);
                        String print = getColumnValue(row, columnIndexMap, "Print", dataFormatter);


                        System.out.println("OS Code: " + OS);
                        System.out.println("language: " + language);
                        System.out.println("comment: " + comment);
                        System.out.println("print: " + print);


                        String result = workOrderCreationService.postComment(
                                apiUser, OS, language, comment, print
                        );

                        if (result != null) {
                            resultadoLabel.setText("<html>" + result.replace("\n", "<br>") + "</html>");
                        } else {
                            resultadoLabel.setText("<html>Comentário Registrado com sucesso!</html>");
                            result = "Comentário Registrado com sucesso!"; // Defina um valor padrão se "result" for nulo
                        }



                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("Atualizando resultadoLabel");
                                resultadoLabel.setForeground(Color.RED); // Define a cor do texto para vermelho

                            }
                        });

                        System.out.println("Resultado da criação do comentário: " + ("<html>" + result.replace("\n", "<br>") + "</html>"));
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        resultadoLabel.setForeground(Color.RED); // Define a cor do texto para vermelho
                        resultadoLabel.setText("Erro ao executar ação: " + ex.getMessage());
                    }
                });
            }
        }
        private String getColumnValue(Row row, Map<String, Integer> columnIndexMap, String columnName, DataFormatter dataFormatter) {
            Integer columnIndex = columnIndexMap.get(columnName);
            if (columnIndex != null) {
                Cell cell = row.getCell(columnIndex);
                if (cell != null) {
                    return dataFormatter.formatCellValue(cell);
                }
            }
            // Return an empty string or handle the missing column as needed
            return "";
        }
    }


