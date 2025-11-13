package com.assettec.api.integration.CLIENTES.Excel.Modulos;

import com.assettec.api.integration.CLIENTES.Activity.ActivityService;
import com.assettec.api.integration.CLIENTES.Excel.CaminhoArquivoGUI;
import com.assettec.api.integration.CLIENTES.Excel.StyledLabel;
import com.assettec.api.integration.CLIENTES.Excel.WorkOrderCreationService;
import com.assettec.api.internal.core.entities.asset.AssetService;
import com.assettec.api.internal.core.entities.asset.equipment.AssetEquipment;
import com.assettec.api.internal.core.entities.orders.workorder.WorkOrderService;
import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.users.ApiUserService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ActivityCreator {

    private ApiUserService apiUserService;

    private WorkOrderCreationService workOrderCreationService;

    public ActivityCreator(ApiUserService apiUserService, WorkOrderCreationService workOrderCreationService, JLabel resultadoLabel, CaminhoArquivoGUI caminhoArquivoGUI) {
        this.apiUserService = apiUserService;
        this.workOrderCreationService = workOrderCreationService;
        this.resultadoLabel = resultadoLabel;
    }

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

    public void createActivitys(String token, String caminhoPlanilha, String selectedGuia) {
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
                    String ActivityCode = getColumnValue(row, columnIndexMap, "ActivityCode", dataFormatter);
                    String Nivel = getColumnValue(row, columnIndexMap, "Nivel", dataFormatter);
                    String PERSONS = getColumnValue(row, columnIndexMap, "PeopleRequired", dataFormatter);
                    String ESTIMATEDHOURS = getColumnValue(row, columnIndexMap, "EstimatedHours", dataFormatter);
                    String activityStartDate = getColumnValue(row, columnIndexMap, "StartDate", dataFormatter);
                    String activityEndDate = getColumnValue(row, columnIndexMap, "EndDate", dataFormatter);


                    System.out.println("OS Code: " + OS);
                    System.out.println("ActivityCode: " + ActivityCode);
                    System.out.println("Nivel: " + Nivel);
                    System.out.println("PeopleRequired: " + PERSONS);
                    System.out.println("EstimatedHours: " + ESTIMATEDHOURS);
                    System.out.println("PeopleRequired: " + activityStartDate);
                    System.out.println("EstimatedHours: " + activityEndDate);



                    String result = workOrderCreationService.postActivity(
                            apiUser, OS, ActivityCode, Nivel, PERSONS, ESTIMATEDHOURS, activityStartDate, activityEndDate
                    );

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Atualizando resultadoLabel");
                            resultadoLabel.setForeground(Color.RED); // Define a cor do texto para vermelho
                            resultadoLabel.setText("<html>" + result.replace("\n", "<br>") + "</html>"); // Imprime mensagem do resultado na interface.
                        }
                    });

                    System.out.println("Resultado da criação da Atividade: " + ("<html>" + result.replace("\n", "<br>") + "</html>"));
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