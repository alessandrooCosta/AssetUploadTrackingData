package com.assettec.api.integration.CLIENTES.Excel.Modulos;

import com.assettec.api.integration.CLIENTES.Excel.CaminhoArquivoGUI;
import com.assettec.api.integration.CLIENTES.Excel.StyledLabel;
import com.assettec.api.integration.CLIENTES.Excel.WorkOrderCreationService;
import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.users.ApiUserService;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartsDataCreator {
    private ApiUserService apiUserService;
    private WorkOrderCreationService workOrderCreationService;
    public PartsDataCreator(ApiUserService apiUserService, WorkOrderCreationService workOrderCreationService, JLabel resultadoLabel, CaminhoArquivoGUI caminhoArquivoGUI) {
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
    private JLabel resultadoLabel;
    private JTextField tenantTextField;
    private JButton selecionarButton;
    private JButton executarButton;
    private JButton salvarInformacoesButton;
    private String caminhoPlanilha;

    public void createPartsData(String token, String caminhoPlanilha, String selectedGuia) {
        try {
            ApiUser apiUser = apiUserService.findByToken(token);

            FileInputStream file = new FileInputStream(new File(caminhoPlanilha));
            Workbook workbook;

            // Use HSSFWorkbook para arquivos no formato .xls e XSSFWorkbook para arquivos no formato .xlsx
            if (caminhoPlanilha.toLowerCase().endsWith(".xls")) {
                workbook = new HSSFWorkbook(file);
            } else if (caminhoPlanilha.toLowerCase().endsWith(".xlsx")) {
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
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                Cell cell = headerRow.getCell(i);
                String columnName = dataFormatter.formatCellValue(cell).trim(); // Remove quaisquer espaços iniciais ou finais
                columnIndexMap.put(columnName, i);
            }
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                // Verifica se a linha não está vazia e se pelo menos uma das colunas relevantes não está vazia
                boolean hasData = false;
                if (row != null) {
                    for (String columnName : Arrays.asList("partCode")) {
                        String columnValue = getColumnValue(row, columnIndexMap, columnName, dataFormatter);
                        if (!columnValue.isEmpty()) {
                            hasData = true;
                            break;
                        }
                    }
                }
                if (hasData) {

                    String partCode = getColumnValue(row, columnIndexMap, "PAR_CODE", dataFormatter);
                    String organizationCode = getColumnValue(row, columnIndexMap, "PAR_ORG", dataFormatter);
                    String descriptionCode = getColumnValue(row, columnIndexMap, "PAR_DESC", dataFormatter);
                    String classCode = getColumnValue(row, columnIndexMap, "PAR_CLASS", dataFormatter);
                    String classOrganization = getColumnValue(row, columnIndexMap, "PAR_CLASS_ORG", dataFormatter);
                    String descriptionClass = getColumnValue(row, columnIndexMap, "DESC_CLASS", dataFormatter);
                    String categoryCode = getColumnValue(row, columnIndexMap, "PAR_CATEGORY", dataFormatter);
                    String categoryDescription = getColumnValue(row, columnIndexMap, "CATEGORY_DESC", dataFormatter);
                    String uomCode = getColumnValue(row, columnIndexMap, "PAR_UOM", dataFormatter);
                    String toolCode = getColumnValue(row, columnIndexMap, "PAR_TOOL", dataFormatter);
                    String toolOrganization = getColumnValue(row, columnIndexMap, "TOOL_ORG", dataFormatter);
                    String toolDescription = getColumnValue(row, columnIndexMap, "TOOL_DESC", dataFormatter);
                    String commodityCode = getColumnValue(row, columnIndexMap, "PAR_COMMODITY", dataFormatter);
                    String commodityOrganization = getColumnValue(row, columnIndexMap, "COMMODITY_ORG", dataFormatter);
                    String secondaryCommodityCode = getColumnValue(row, columnIndexMap, "PAR_SUBCOMMODITY", dataFormatter);
                    String secondaryCommodityOrganization = getColumnValue(row, columnIndexMap, "PAR_TAX", dataFormatter);
                    String secondaryCommodityDescription = getColumnValue(row, columnIndexMap, "PAR_SUBCOMMODITY", dataFormatter);
                    String methodCode = getColumnValue(row, columnIndexMap, "PAR_INSMETHOD", dataFormatter);
                    String taxCode = getColumnValue(row, columnIndexMap, "PAR_TAX", dataFormatter);
                    String taxOrganization = getColumnValue(row, columnIndexMap, "PAR_TAX_ORG", dataFormatter);
                    String taxDescription = getColumnValue(row, columnIndexMap, "TAX_DESC", dataFormatter);
                    String trackMethodTypeCode = getColumnValue(row, columnIndexMap, "PAR_TRACKTYPE", dataFormatter);
                    String partCodeStructure = getColumnValue(row, columnIndexMap, "PAR_CODESTRUCTURE", dataFormatter);
                    String userCode = getColumnValue(row, columnIndexMap, "PAR_USER_CODE", dataFormatter);
                    String supplierCode = getColumnValue(row, columnIndexMap, "PAR_PREFSUP", dataFormatter);
                    String supplierOrganization = getColumnValue(row, columnIndexMap, "PAR_PREFSUP_ORG", dataFormatter);
                    String supplierDescription = getColumnValue(row, columnIndexMap, "PAR_PREFSUP", dataFormatter);
                    String currencyCode = getColumnValue(row, columnIndexMap, "CURRENCY_CODE", dataFormatter);
                    String supplierUOM = getColumnValue(row, columnIndexMap, "PAR_PREFUOM", dataFormatter);
                    String commodityDescription = getColumnValue(row, columnIndexMap, "PAR_COMMODITY", dataFormatter);
                    String conversionFactor = getColumnValue(row, columnIndexMap, "PAR_STDPRICE", dataFormatter);
                    String UDFCHAR01 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR01", dataFormatter);
                    String UDFCHAR02 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR02", dataFormatter);
                    String UDFCHAR03 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR03", dataFormatter);
                    String UDFCHAR04 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR04", dataFormatter);
                    String UDFCHAR05 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR05", dataFormatter);
                    String UDFCHAR06 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR06", dataFormatter);
                    String UDFCHAR07 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR07", dataFormatter);
                    String UDFCHAR08 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR08", dataFormatter);
                    String UDFCHAR09 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR09", dataFormatter);
                    String UDFCHAR10 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR10", dataFormatter);
                    String UDFCHAR11 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR11", dataFormatter);
                    String UDFCHAR12 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR12", dataFormatter);
                    String UDFCHAR13 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR13", dataFormatter);
                    String UDFCHAR14 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR14", dataFormatter);
                    String UDFCHAR15 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR15", dataFormatter);
                    String UDFCHAR16 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR16", dataFormatter);
                    String UDFCHAR17 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR17", dataFormatter);
                    String UDFCHAR18 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR18", dataFormatter);
                    String UDFCHAR19 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR19", dataFormatter);
                    String UDFCHAR20 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR20", dataFormatter);
                    String UDFCHAR21 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR21", dataFormatter);
                    String UDFCHAR22 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR22", dataFormatter);
                    String UDFCHAR23 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR23", dataFormatter);
                    String UDFCHAR24 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR24", dataFormatter);
                    String UDFCHAR25 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR25", dataFormatter);
                    String UDFCHAR26 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR26", dataFormatter);
                    String UDFCHAR27 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR27", dataFormatter);
                    String UDFCHAR28 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR28", dataFormatter);
                    String UDFCHAR29 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR29", dataFormatter);
                    String UDFCHAR30 = getColumnValue(row, columnIndexMap, "PAR_UDFCHAR30", dataFormatter);
                    String objectCode = getColumnValue(row, columnIndexMap, "PAR_OBJECT_CODE", dataFormatter);
                    String profileOrganization = getColumnValue(row, columnIndexMap, "PAR_PROFILE_ORG", dataFormatter);
                    String profileDescription = getColumnValue(row, columnIndexMap, "PAR_PROFILE_DESC", dataFormatter);
                    String typeCode = getColumnValue(row, columnIndexMap, "PAR_TYPE_CODE", dataFormatter);
                    String classIdCode = getColumnValue(row, columnIndexMap, "PAR_CLASS_ID_CODE", dataFormatter);
                    String classIdOrganization = getColumnValue(row, columnIndexMap, "PAR_CLASS_ID_ORG", dataFormatter);
                    String classIdDescription = getColumnValue(row, columnIndexMap, "PAR_CLASS_ID_DESC", dataFormatter);
                    String statusCode = getColumnValue(row, columnIndexMap, "PAR_STATUS_CODE", dataFormatter);
                    String departmentCode = getColumnValue(row, columnIndexMap, "PAR_DEPARTMENT_CODE", dataFormatter);
                    String departmentOrganization = getColumnValue(row, columnIndexMap, "PAR_DEPARTMENT_ORG", dataFormatter);
                    String departmentDescription = getColumnValue(row, columnIndexMap, "PAR_DEPARTMENT_DESC", dataFormatter);
                    String categoryIdCode = getColumnValue(row, columnIndexMap, "PAR_CATEGORY_ID_CODE", dataFormatter);
                    String costCode = getColumnValue(row, columnIndexMap, "PAR_COST_CODE", dataFormatter);
                    String costOrganization = getColumnValue(row, columnIndexMap, "PAR_COST_ORG", dataFormatter);
                    String storeCode = getColumnValue(row, columnIndexMap, "PAR_STORE_CODE", dataFormatter);
                    String storeOrganization = getColumnValue(row, columnIndexMap, "PAR_STORE_ORG", dataFormatter);
                    String storeDescription = getColumnValue(row, columnIndexMap, "PAR_STORE_DESC", dataFormatter);
                    String partIdCode = getColumnValue(row, columnIndexMap, "PAR_PART_ID_CODE", dataFormatter);
                    String partIdOrganization = getColumnValue(row, columnIndexMap, "PAR_PART_ID_ORG", dataFormatter);
                    String partIdDescription = getColumnValue(row, columnIndexMap, "PAR_PART_ID_DESC", dataFormatter);
                    String meterUnit = getColumnValue(row, columnIndexMap, "PAR_METER_UNIT", dataFormatter);
                    String manufacturerCode = getColumnValue(row, columnIndexMap, "PAR_MANUFACTURER_CODE", dataFormatter);
                    String serialNumber = getColumnValue(row, columnIndexMap, "PAR_SERIAL_NUMBER", dataFormatter);
                    String model = getColumnValue(row, columnIndexMap, "PAR_MODEL", dataFormatter);
                    String modelRevision = getColumnValue(row, columnIndexMap, "PAR_MODEL_REVISION", dataFormatter);
                    String cnNumber = getColumnValue(row, columnIndexMap, "PAR_CN_NUMBER", dataFormatter);
                    String propertyCode = getColumnValue(row, columnIndexMap, "PAR_PROPERTY_CODE", dataFormatter);
                    String propertyLabel = getColumnValue(row, columnIndexMap, "PAR_PROPERTY_LABEL", dataFormatter);
                    String UserDefinedClassCode = getColumnValue(row, columnIndexMap, "PAR_USER_DEFINED_CLASS_CODE", dataFormatter);
                    String UserDefinedClassOrg = getColumnValue(row, columnIndexMap, "PAR_USER_DEFINED_CLASS_ORG", dataFormatter);
                    String UserDefinedClassDescription = getColumnValue(row, columnIndexMap, "PAR_USER_DEFINED_CLASS_DESC", dataFormatter);
                    String priceType = getColumnValue(row, columnIndexMap, "PAR_PRICE_TYPE", dataFormatter);
                    String byAsset = getColumnValue(row, columnIndexMap, "PAR_BY_ASSET", dataFormatter);
                    String byLot = getColumnValue(row, columnIndexMap, "PAR_BY_LOT", dataFormatter);
                    String kit = getColumnValue(row, columnIndexMap, "PAR_KIT", dataFormatter);
                    String saveHistory = getColumnValue(row, columnIndexMap, "PAR_SAVE_HISTORY", dataFormatter);
                    String outOfService = getColumnValue(row, columnIndexMap, "PAR_OUT_OF_SERVICE", dataFormatter);
                    String inspectionRequired = getColumnValue(row, columnIndexMap, "PAR_INSPECTION_REQUIRED", dataFormatter);
                    String repairable = getColumnValue(row, columnIndexMap, "PAR_REPAIRABLE", dataFormatter);
                    String calibrationStandard = getColumnValue(row, columnIndexMap, "PAR_CALIBRATION_STANDARD", dataFormatter);
                    String preventReorders = getColumnValue(row, columnIndexMap, "PAR_PREVENT_REORDERS", dataFormatter);

                    System.out.println("PAR_CODE: " + partCode);
                    System.out.println("ORG_CODE: " + organizationCode);
                    System.out.println("PAR_DESC: " + descriptionCode);
                    System.out.println("PAR_CLASS: " + classCode);
                    System.out.println("CLASS_ORG: " + classOrganization);
                    System.out.println("DESC_CLASS: " + descriptionClass);
                    System.out.println("CATEGORY_CODE: " + categoryCode);
                    System.out.println("CATEGORY_DESC: " + categoryDescription);
                    System.out.println("PAR_UOM: " + uomCode);
                    System.out.println("TOOL_CODE: " + toolCode);
                    System.out.println("TOOL_ORG: " + toolOrganization);
                    System.out.println("TOOL_DESC: " + toolDescription);
                    System.out.println("COMMODITY_CODE: " + commodityCode);
                    System.out.println("COMMODITY_ORG: " + commodityOrganization);
                    System.out.println("SECONDARY_COMMODITY_CODE: " + secondaryCommodityCode);
                    System.out.println("SECONDARY_COMMODITY_ORG: " + secondaryCommodityOrganization);
                    System.out.println("SECONDARY_COMMODITY_DESC: " + secondaryCommodityDescription);
                    System.out.println("METHOD_CODE: " + methodCode);
                    System.out.println("TAX_CODE: " + taxCode);
                    System.out.println("TAX_ORG: " + taxOrganization);
                    System.out.println("TAX_DESC: " + taxDescription);
                    System.out.println("TRACK_METHOD_TYPE_CODE: " + trackMethodTypeCode);
                    System.out.println("PAR_CODE_STRUCTURE: " + partCodeStructure);
                    System.out.println("USER_CODE: " + userCode);
                    System.out.println("SUPPLIER_CODE: " + supplierCode);
                    System.out.println("SUPPLIER_ORG: " + supplierOrganization);
                    System.out.println("SUPPLIER_DESC: " + supplierDescription);
                    System.out.println("CURRENCY_CODE: " + currencyCode);
                    System.out.println("SUPPLIER_UOM: " + supplierUOM);
                    System.out.println("COMMODITY_DESC: " + commodityDescription);
                    System.out.println("CONVERSION_FACTOR: " + conversionFactor);
                    System.out.println("UDFCHAR01: " + UDFCHAR01);
                    System.out.println("UDFCHAR02: " + UDFCHAR02);
                    System.out.println("UDFCHAR03: " + UDFCHAR03);
                    System.out.println("UDFCHAR04: " + UDFCHAR04);
                    System.out.println("UDFCHAR05: " + UDFCHAR05);
                    System.out.println("UDFCHAR06: " + UDFCHAR06);
                    System.out.println("UDFCHAR07: " + UDFCHAR07);
                    System.out.println("UDFCHAR08: " + UDFCHAR08);
                    System.out.println("UDFCHAR09: " + UDFCHAR09);
                    System.out.println("UDFCHAR10: " + UDFCHAR10);
                    System.out.println("UDFCHAR11: " + UDFCHAR11);
                    System.out.println("UDFCHAR12: " + UDFCHAR12);
                    System.out.println("UDFCHAR13: " + UDFCHAR13);
                    System.out.println("UDFCHAR14: " + UDFCHAR14);
                    System.out.println("UDFCHAR15: " + UDFCHAR15);
                    System.out.println("UDFCHAR16: " + UDFCHAR16);
                    System.out.println("UDFCHAR17: " + UDFCHAR17);
                    System.out.println("UDFCHAR18: " + UDFCHAR18);
                    System.out.println("UDFCHAR19: " + UDFCHAR19);
                    System.out.println("UDFCHAR20: " + UDFCHAR20);
                    System.out.println("UDFCHAR21: " + UDFCHAR21);
                    System.out.println("UDFCHAR22: " + UDFCHAR22);
                    System.out.println("UDFCHAR23: " + UDFCHAR23);
                    System.out.println("UDFCHAR24: " + UDFCHAR24);
                    System.out.println("UDFCHAR25: " + UDFCHAR25);
                    System.out.println("UDFCHAR26: " + UDFCHAR26);
                    System.out.println("UDFCHAR27: " + UDFCHAR27);
                    System.out.println("UDFCHAR28: " + UDFCHAR28);
                    System.out.println("UDFCHAR29: " + UDFCHAR29);
                    System.out.println("UDFCHAR30: " + UDFCHAR30);
                    System.out.println("OBJECT_CODE: " + objectCode);
                    System.out.println("PROFILE_ORG: " + profileOrganization);
                    System.out.println("PROFILE_DESC: " + profileDescription);
                    System.out.println("TYPE_CODE: " + typeCode);
                    System.out.println("CLASS_ID_CODE: " + classIdCode);

                    String result = workOrderCreationService.postPartsData(
                            apiUser, partCode, organizationCode, descriptionCode, classCode, classOrganization, descriptionClass, categoryCode, categoryDescription, uomCode, toolCode, toolOrganization, toolDescription, commodityCode, commodityOrganization, secondaryCommodityCode, secondaryCommodityOrganization, secondaryCommodityDescription, methodCode, taxCode, taxOrganization, taxDescription, trackMethodTypeCode, partCodeStructure, userCode, supplierCode, supplierOrganization, supplierDescription, currencyCode, supplierUOM, commodityDescription, conversionFactor, UDFCHAR01, UDFCHAR02, UDFCHAR03, UDFCHAR04, UDFCHAR05, UDFCHAR06, UDFCHAR07, UDFCHAR08, UDFCHAR09, UDFCHAR10, UDFCHAR11, UDFCHAR12, UDFCHAR13, UDFCHAR14, UDFCHAR15, UDFCHAR16, UDFCHAR17, UDFCHAR18, UDFCHAR19, UDFCHAR20, UDFCHAR21, UDFCHAR22, UDFCHAR23, UDFCHAR24, UDFCHAR25, UDFCHAR26, UDFCHAR27, UDFCHAR28, UDFCHAR29, UDFCHAR30, objectCode, profileOrganization, profileDescription, typeCode, classIdCode, classIdOrganization, classIdDescription, statusCode, departmentCode, departmentOrganization, departmentDescription, categoryIdCode, costCode, costOrganization, storeCode, storeOrganization, storeDescription, partIdCode, partIdOrganization, partIdDescription, meterUnit, manufacturerCode, serialNumber, model, modelRevision, cnNumber, propertyCode, propertyLabel, UserDefinedClassCode, UserDefinedClassOrg, UserDefinedClassDescription, priceType, byAsset, byLot, kit, saveHistory, outOfService, inspectionRequired, repairable, calibrationStandard, preventReorders
                    );

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Atualizando resultadoLabel");
                            resultadoLabel.setForeground(Color.RED); // Define a cor do texto para vermelho
                            resultadoLabel.setText("<html>" + result.replace("\n", "<br>") + "</html>"); // Imprime mensagem do resultado na interface.
                        }
                    });

                    System.out.println("Resultado da criação da tabela: " + ("<html>" + result.replace("\n", "<br>") + "</html>"));
                }
            }

        }   catch (Exception ex) {
            ex.printStackTrace(System.out);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    resultadoLabel.setForeground(Color.RED);
                    String errorMessage = "Erro: " + ex.getMessage();

                    // Aumente o tamanho do componente (se 'resultadoLabel' for um componente Swing adequado)
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
        // Return an empty string or handle the missing column as needed
        return "";
    }
}
