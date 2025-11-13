package com.assettec.api.integration.CLIENTES.Excel.Modulos;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import com.assettec.api.integration.CLIENTES.Excel.CaminhoArquivoGUI;
import com.assettec.api.integration.CLIENTES.Excel.StyledLabel;
import com.assettec.api.integration.CLIENTES.Excel.WorkOrderCreationService;
import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.users.ApiUserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import org.apache.commons.lang3.StringEscapeUtils;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TrackingDataCreator {

	private ApiUserService apiUserService;

	private WorkOrderCreationService workOrderCreationService;

	public TrackingDataCreator(ApiUserService apiUserService, WorkOrderCreationService workOrderCreationService, JLabel resultadoLabel, CaminhoArquivoGUI caminhoArquivoGUI, JProgressBar progressBar) {
		this.apiUserService = apiUserService;
		this.workOrderCreationService = workOrderCreationService;
		this.resultadoLabel = resultadoLabel;
		this.progressBar = progressBar;

	}


	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public void updateProgress(int progress) {
		if (progressBar != null) {
			SwingUtilities.invokeLater(() -> {
				progressBar.setValue(progress);
				if (SwingUtilities.isEventDispatchThread()) {
					System.out.println("Está na EDT!");
				} else {
					System.out.println("Não está na EDT!");
				}
			});
		}
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
	private JLabel resultadoLabel;
	private JTextField tenantTextField;
	private JButton selecionarButton;
	private JButton executarButton;
	private JButton salvarInformacoesButton;
	private String caminhoPlanilha;

	private JProgressBar progressBar;

	public void createTrackingData(String token, String caminhoPlanilha, String selectedGuia) {
		try {


			ApiUser apiUser = apiUserService.findByToken(token);

			FileInputStream file = new FileInputStream(new File(caminhoPlanilha));
			Workbook workbook;

			// Use HSSFWorkbook para arquivos no formato .xls e XSSFWorkbook para arquivos no formato .xlsx/.xlsm
			if (caminhoPlanilha.toLowerCase().endsWith(".xls")) {
				workbook = new HSSFWorkbook(file);
			} else if (caminhoPlanilha.toLowerCase().endsWith(".xlsx") || caminhoPlanilha.toLowerCase().endsWith(".xlsm")) {
				workbook = new XSSFWorkbook(file);
			} else {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						resultadoLabel.setForeground(Color.RED);
						resultadoLabel.setText("Formato de arquivo não suportado.");
					}
				});
				return;
			}

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
			if (headerRow == null) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						resultadoLabel.setForeground(Color.RED);
						resultadoLabel.setText("Cabeçalho (linha 1) não encontrado na aba selecionada.");
					}
				});
				return;
			}
			for (int i = 0; i < headerRow.getLastCellNum(); i++) {
				Cell cell = headerRow.getCell(i);
				String columnName = dataFormatter.formatCellValue(cell).trim();
				if (!columnName.isEmpty()) {
					columnIndexMap.put(columnName, i);
					// Também mapear o nome-base antes de um hífen ("-") para suportar cabeçalhos como
					// "TKD_PROMPTDATA1 - Descrição" => "TKD_PROMPTDATA1"
					int dashIdx = columnName.indexOf('-');
					if (dashIdx > 0) {
						String base = columnName.substring(0, dashIdx).trim();
						if (!base.isEmpty()) {
							columnIndexMap.putIfAbsent(base, i);
						}
					}
				}
			}

			// Dimensionamento de progresso: para folhas muito grandes, evite pré-contagem completa
			int lastRowNum = sheet.getLastRowNum();
			int totalToProcess;
			boolean useEstimateOnly = lastRowNum > 10000; // limiar para não fazer segunda passada
			if (useEstimateOnly) {
				totalToProcess = Math.max(lastRowNum, 1);
			} else {
				int count = 0;
				for (int i = 1; i <= lastRowNum; i++) {
					Row row = sheet.getRow(i);
					if (rowHasAnyData(row, headerRow.getLastCellNum(), dataFormatter)) {
						count++;
					}
				}
				totalToProcess = Math.max(count, 1);
			}

			final int totalRowsForProgress = totalToProcess;
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					progressBar.setIndeterminate(false);
					progressBar.setMinimum(0);
					progressBar.setMaximum(100);
					progressBar.setValue(0);
				}
			});

			int processed = 0;
			int lastPercent = 0;
			for (int i = 1; i <= lastRowNum; i++) {
				Row row = sheet.getRow(i);

				// Considera linha válida se houver qualquer dado em alguma coluna conhecida do cabeçalho
				boolean hasData = rowHasAnyData(row, headerRow.getLastCellNum(), dataFormatter);

				if (hasData) {
					String TRANSID = getColumnValue(row, columnIndexMap, "TKD_TRANSID", dataFormatter);
					String TRANSCODE = getColumnValue(row, columnIndexMap, "TKD_TRANS", dataFormatter);
					if (TRANSCODE == null || TRANSCODE.isEmpty()) {
						TRANSCODE = "M201"; // valor padrão quando não vier na planilha
					}
					String PROMPTDATA1 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA1", dataFormatter));
					String PROMPTDATA2 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA2", dataFormatter));
					String PROMPTDATA3 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA3", dataFormatter));
					String PROMPTDATA4 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA4", dataFormatter));
					String PROMPTDATA5 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA5", dataFormatter));
					String PROMPTDATA6 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA6", dataFormatter));
					String PROMPTDATA7 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA7", dataFormatter));
					String PROMPTDATA8 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA8", dataFormatter));
					String PROMPTDATA9 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA9", dataFormatter));
					String PROMPTDATA10 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA10", dataFormatter));
					String PROMPTDATA11 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA11", dataFormatter));
					String PROMPTDATA12 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA12", dataFormatter));
					String PROMPTDATA13 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA13", dataFormatter));
					String PROMPTDATA14 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA14", dataFormatter));
					String PROMPTDATA15 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA15", dataFormatter));
					String PROMPTDATA16 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA16", dataFormatter));
					String PROMPTDATA17 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA17", dataFormatter));
					String PROMPTDATA18 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA18", dataFormatter));
					String PROMPTDATA19 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA19", dataFormatter));
					String PROMPTDATA20 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA20", dataFormatter));
					String PROMPTDATA21 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA21", dataFormatter));
					String PROMPTDATA22 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA22", dataFormatter));
					String PROMPTDATA23 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA23", dataFormatter));
					String PROMPTDATA24 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA24", dataFormatter));
					String PROMPTDATA25 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA25", dataFormatter));
					String PROMPTDATA26 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA26", dataFormatter));
					String PROMPTDATA27 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA27", dataFormatter));
					String PROMPTDATA28 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA28", dataFormatter));
					String PROMPTDATA29 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA29", dataFormatter));
					String PROMPTDATA30 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA30", dataFormatter));
					String PROMPTDATA31 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA31", dataFormatter));
					String PROMPTDATA32 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA32", dataFormatter));
					String PROMPTDATA33 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA33", dataFormatter));
					String PROMPTDATA34 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA34", dataFormatter));
					String PROMPTDATA35 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA35", dataFormatter));
					String PROMPTDATA36 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA36", dataFormatter));
					String PROMPTDATA37 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA37", dataFormatter));
					String PROMPTDATA38 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA38", dataFormatter));
					String PROMPTDATA39 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA39", dataFormatter));
					String PROMPTDATA40 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA40", dataFormatter));
					String PROMPTDATA41 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA41", dataFormatter));
					String PROMPTDATA42 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA42", dataFormatter));
					String PROMPTDATA43 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA43", dataFormatter));
					String PROMPTDATA44 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA44", dataFormatter));
					String PROMPTDATA45 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA45", dataFormatter));
					String PROMPTDATA46 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA46", dataFormatter));
					String PROMPTDATA47 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA47", dataFormatter));
					String PROMPTDATA48 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA48", dataFormatter));
					String PROMPTDATA49 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA49", dataFormatter));
					String PROMPTDATA50 = StringEscapeUtils.escapeXml10(getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA50", dataFormatter));
					String PROMPTDATA51 = getColumnValue(row, columnIndexMap, "TKD_PROMPTDATA51", dataFormatter);

					String result = workOrderCreationService.postTrackingData(
							apiUser, TRANSID, TRANSCODE, PROMPTDATA1, PROMPTDATA2, PROMPTDATA3, PROMPTDATA4, PROMPTDATA5, PROMPTDATA6, PROMPTDATA7, PROMPTDATA8, PROMPTDATA9, PROMPTDATA10, PROMPTDATA11, PROMPTDATA12, PROMPTDATA13, PROMPTDATA14, PROMPTDATA15, PROMPTDATA16, PROMPTDATA17,  PROMPTDATA18,  PROMPTDATA19,  PROMPTDATA20,  PROMPTDATA21,  PROMPTDATA22,  PROMPTDATA23,  PROMPTDATA24,  PROMPTDATA25,  PROMPTDATA26,  PROMPTDATA27,  PROMPTDATA28,  PROMPTDATA29,  PROMPTDATA30,  PROMPTDATA31,  PROMPTDATA32,  PROMPTDATA33,  PROMPTDATA34,  PROMPTDATA35,  PROMPTDATA36,  PROMPTDATA37,  PROMPTDATA38,  PROMPTDATA39,  PROMPTDATA40,  PROMPTDATA41,  PROMPTDATA42,  PROMPTDATA43,  PROMPTDATA44,  PROMPTDATA45,  PROMPTDATA46,  PROMPTDATA47,  PROMPTDATA48,  PROMPTDATA49,  PROMPTDATA50,  PROMPTDATA51
					);

					processed++;
					final int percent = (int) Math.round((processed * 100.0) / totalRowsForProgress);
					if (percent != lastPercent) {
						lastPercent = percent;
						final int uiPercent = percent;
						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								progressBar.setValue(uiPercent);
							}
						});
					}

					final String uiResult = result;
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							resultadoLabel.setForeground(Color.RED);
							resultadoLabel.setText("<html>" + uiResult.replace("\n", "<br>") + "</html>");
						}
					});

					System.out.println("Resultado da criação da tabela: " + ("<html>" + result.replace("\n", "<br>") + "</html>"));
				}
			}

			final int totalProcessed = processed;
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					progressBar.setValue(100);
				}
			});

			if (totalProcessed == 0) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						resultadoLabel.setForeground(Color.ORANGE);
						resultadoLabel.setText("Nenhuma linha válida encontrada (verifique se há dados após o cabeçalho).");
					}
				});
			} else {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						resultadoLabel.setForeground(Color.GREEN);
						resultadoLabel.setText("Processamento de TrackingData concluído. Linhas enviadas: " + totalProcessed);
					}
				});
			}

		}   catch (Exception ex) {
			ex.printStackTrace(System.out);
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					resultadoLabel.setForeground(Color.RED);
					String errorMessage = "Erro: " + ex.getMessage();
					resultadoLabel.setText("<html>" + errorMessage + "</html>");
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
		return "";
	}

	private boolean rowHasAnyData(Row row, short headerLastCellNum, DataFormatter dataFormatter) {
		if (row == null) return false;
		for (int i = 0; i < headerLastCellNum; i++) {
			Cell cell = row.getCell(i);
			if (cell != null && !dataFormatter.formatCellValue(cell).trim().isEmpty()) {
				return true;
			}
		}
		return false;
	}
}