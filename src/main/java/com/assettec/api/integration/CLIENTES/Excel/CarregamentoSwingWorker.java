package com.assettec.api.integration.CLIENTES.Excel;

import com.sun.media.sound.InvalidFormatException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CarregamentoSwingWorker extends SwingWorker<Void, Integer> {
    private JProgressBar progressBar;
    private String caminhoPlanilha;
    private String selectedGuia;

    public CarregamentoSwingWorker(JProgressBar progressBar, String caminhoPlanilha, String selectedGuia) {
        this.progressBar = progressBar;
        this.caminhoPlanilha = caminhoPlanilha;
        this.selectedGuia = selectedGuia;
    }

    public static int calcularTotalLinhas(String caminhoPlanilha, String selectedGuia) throws IOException {
        try (FileInputStream fileStream = new FileInputStream(new File(caminhoPlanilha))) {
            Workbook workbook = WorkbookFactory.create(fileStream);
            Sheet sheet = workbook.getSheet(selectedGuia);

            if (sheet != null) {
                return sheet.getPhysicalNumberOfRows();
            } else {
                throw new IllegalArgumentException("Folha não encontrada na planilha.");
            }
        } catch (InvalidFormatException e) {
            throw new RuntimeException("Erro ao calcular o total de linhas", e);
        }
    }

    @Override
    protected Void doInBackground() throws Exception {
        try (FileInputStream fileStream = new FileInputStream(new File(caminhoPlanilha))) {
            Workbook workbook;
            if (caminhoPlanilha.toLowerCase().endsWith(".xls")) {
                workbook = new HSSFWorkbook(fileStream);
            } else if (caminhoPlanilha.toLowerCase().endsWith(".xlsx") || caminhoPlanilha.toLowerCase().endsWith(".xlsm")) {
                workbook = new XSSFWorkbook(fileStream);
            } else {
                JOptionPane.showMessageDialog(null, "Formato de arquivo não suportado.", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            int totalRows = calcularTotalLinhas(caminhoPlanilha, selectedGuia);

            int currentRow = 0;

            Sheet sheet = workbook.getSheet(selectedGuia);
            if (sheet != null) {
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext() && !isCancelled()) {
                    rowIterator.next();
                    currentRow++;
                    int progress = (int) ((double) currentRow / Math.max(totalRows, 1) * 100);
                    publish(progress);
                    Thread.sleep(10);
                }
            }

        } catch (InvalidFormatException | InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void process(List<Integer> chunks) {
        // Atualiza a barra de progresso com o último valor publicado
        for (Integer progress : chunks) {
            progressBar.setValue(progress);
        }
    }

    @Override
    protected void done() {
        // Tarefa concluída, você pode realizar ações pós-carregamento aqui
    }
}