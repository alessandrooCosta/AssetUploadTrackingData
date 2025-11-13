package com.assettec.api.integration.CLIENTES.Excel.Modulos;

import com.assettec.api.integration.CLIENTES.Excel.CaminhoArquivoGUI;
import com.assettec.api.integration.CLIENTES.Excel.Modulos.Data.WorkOrderData;
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
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WorkOrderCreator {

    private ApiUserService apiUserService;
    private AssetService assetService;
    private WorkOrderCreationService workOrderCreationService;

    public WorkOrderCreator(ApiUserService apiUserService, AssetService assetService, WorkOrderCreationService workOrderCreationService, JLabel resultadoLabel, CaminhoArquivoGUI caminhoArquivoGUI) {
        this.apiUserService = apiUserService;
        this.assetService = assetService;
        this.workOrderCreationService = workOrderCreationService;
        this.resultadoLabel = resultadoLabel;
    }

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

    public void createWorkOrder(String token, String caminhoPlanilha, String selectedGuia) {
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

                // Verifica se a linha não está vazia e se pelo menos uma das colunas relevantes não está vazia
                boolean hasData = false;
                if (row != null) {
                    for (String columnName : Arrays.asList("OS", "equipmentCode", "workOrderOrganization", "workOrderDescription", "workOrderType", "workOrderStatus")) {
                        String columnValue = getColumnValue(row, columnIndexMap, columnName, dataFormatter);
                        if (!columnValue.isEmpty()) {
                            hasData = true;
                            break;
                        }
                    }
                }

                if (hasData) {
                    String OS = getColumnValue(row, columnIndexMap, "EVT_CODE", dataFormatter);
                    String equipmentCode = getColumnValue(row, columnIndexMap, "EVT_OBJECT", dataFormatter);
                    String workOrderOrganization = getColumnValue(row, columnIndexMap, "EVT_ORG", dataFormatter);
                    String workOrderDescription = getColumnValue(row, columnIndexMap, "EVT_DESC", dataFormatter);
                    String workOrderType = getColumnValue(row, columnIndexMap, "EVT_JOBTYPE", dataFormatter);
                    String workOrderStatus = getColumnValue(row, columnIndexMap, "EVT_STATUS", dataFormatter);
                    String workOrderDepartment = getColumnValue(row, columnIndexMap, "EVT_MRC", dataFormatter);

                    String createdBy = getColumnValue(row, columnIndexMap, "EVT_ENTEREDBY", dataFormatter);
                    String updatedBy = getColumnValue(row, columnIndexMap, "EVT_UPDATEDBY", dataFormatter);

            ;
                    String locationCode = getColumnValue(row, columnIndexMap, "EVT_LOCATION", dataFormatter);




                    String serviceRequestCode = getColumnValue(row, columnIndexMap, "serviceRequestCode", dataFormatter);
                    String safety = getColumnValue(row, columnIndexMap, "EVT_SAFETY", dataFormatter);
                    String warranty = getColumnValue(row, columnIndexMap, "EVT_WARRANTY", dataFormatter);
                    String depend = getColumnValue(row, columnIndexMap, "EVT_DEPEND", dataFormatter);
                    String equipmentAlias = getColumnValue(row, columnIndexMap, "OBJ_ALIAS", dataFormatter);
                    String serialNumber = getColumnValue(row, columnIndexMap, "OBJ_SERIALNO", dataFormatter);
                    String printed = getColumnValue(row, columnIndexMap, "EVT_PRINTED", dataFormatter);
                    String print = getColumnValue(row, columnIndexMap, "EVT_PRINT ", dataFormatter);
                    String model = getColumnValue(row, columnIndexMap, "OBJ_MANUFACTMODEL", dataFormatter);

                    // TELA PROGRAMAÇÃO DA ORDEM DE SERVIÇO (OS)
                    String personCode = getColumnValue(row, columnIndexMap, "EVT_ORIGIN", dataFormatter); // CAMPO "REPORTADO POR:"
                    String schedGroup = getColumnValue(row, columnIndexMap, "EVT_SCHEDGRP", dataFormatter); // ATRIBUIDO POR:
                    String assignedTo = getColumnValue(row, columnIndexMap, "EVT_PERSON", dataFormatter); // ATRIBUIDO A:
                    String targetDate = getColumnValue(row, columnIndexMap, "EVT_TARGET", dataFormatter); // DATA DE INÍCIO PROGRAMADA
                    String schedDate = getColumnValue(row, columnIndexMap, "EVT_SCHEDEND", dataFormatter); // DATA DE TÉRMINO PROGRAMADA
                    String requestedStartDate = getColumnValue(row, columnIndexMap, "EVT_REQUESTSTART", dataFormatter); // DATA DE INÍCIO SOLICITADA
                    String requestedEndDate = getColumnValue(row, columnIndexMap, "EVT_REQUESTEND", dataFormatter); // DATA DE TÉRMINO SOLICITADA
                    String startDate = getColumnValue(row, columnIndexMap, "EVT_START", dataFormatter); // DATA DE INÍCIO
                    String completedDate = getColumnValue(row, columnIndexMap, "EVT_COMPLETED", dataFormatter); // DATA DE CONCLUSÃO
                    String shiftCode = getColumnValue(row, columnIndexMap, "EVT_SHIFT", dataFormatter); // TURNO
                    String projectCode = getColumnValue(row, columnIndexMap, "EVT_PROJECT", dataFormatter); // PROJETO – ORÇAMENTO (Primeiro campo)






                    String OBJtype = getColumnValue(row, columnIndexMap, "EVT_OBTYPE", dataFormatter);





                    String frequency = getColumnValue(row, columnIndexMap, "frequency", dataFormatter);
                    String EVTisType = getColumnValue(row, columnIndexMap, "EVTisType", dataFormatter);
                    String meterDue = getColumnValue(row, columnIndexMap, "meterDue", dataFormatter);
                    String meterDue2 = getColumnValue(row, columnIndexMap, "meterDue2", dataFormatter);
                    String workPackage = getColumnValue(row, columnIndexMap, "workPackage", dataFormatter);
                    String periodUOMCode = getColumnValue(row, columnIndexMap, "periodUOMCode", dataFormatter);
                    String meterUOMcode = getColumnValue(row, columnIndexMap, "meterUOMcode", dataFormatter);

                    ///DETALHE DA OS (DETALHE DA ORDEM DE SERVIÇO)
                    String workOrderProblemCode = getColumnValue(row, columnIndexMap, "EVT_REQM", dataFormatter);
                    String criticality = getColumnValue(row, columnIndexMap, "EVT_OBJCRITICALITY", dataFormatter);
                    String ppmCode = getColumnValue(row, columnIndexMap, "EVT_PPM", dataFormatter);
                    String cnnNumber = getColumnValue(row, columnIndexMap, "EVT_CN ", dataFormatter);  // Não preenchivel
                    String msProject = getColumnValue(row, columnIndexMap, "EVT_MPPROJ", dataFormatter); // Não
                    String schedulingSessionType = getColumnValue(row, columnIndexMap, "EVT_MPPROJTYPE", dataFormatter);
                    String reopened = getColumnValue(row, columnIndexMap, "EVT_REOPENED", dataFormatter);
                    String causeCode = getColumnValue(row, columnIndexMap, "causeCode", dataFormatter);
                    String standardWork = getColumnValue(row, columnIndexMap, "EVT_STANDWORK", dataFormatter);
                    String priorityCode = getColumnValue(row, columnIndexMap, "EVT_PRIORITY", dataFormatter);
                    String costCode = getColumnValue(row, columnIndexMap, "EVT_COSTCODE", dataFormatter);
                    String targetValue = getColumnValue(row, columnIndexMap, "EVT_MAXCOST", dataFormatter);
                    String lastMeterReading = getColumnValue(row, columnIndexMap, "EVT_FAILUREUSAGE", dataFormatter);
                    String meterUnit = getColumnValue(row, columnIndexMap, "EVT_METUOM", dataFormatter);
                    String triggerEvent = getColumnValue(row, columnIndexMap, "EVT_TRIGEVENT", dataFormatter);
                    String failureCode = getColumnValue(row, columnIndexMap, "EVT_FAILURE", dataFormatter);
                    String actionCode = getColumnValue(row, columnIndexMap, "EVT_ACTION", dataFormatter);
                    String routeCode = getColumnValue(row, columnIndexMap, "EVT_ROUTE", dataFormatter);
                    String routeStatus = getColumnValue(row, columnIndexMap, "EVT_ROUTESTATUS", dataFormatter); //Não
                    String downTimeCostValue = getColumnValue(row, columnIndexMap, "EVT_DOWNTIME", dataFormatter);
                    String downtimeHours = getColumnValue(row, columnIndexMap, "EVT_DOWNTIMEHRS", dataFormatter);

                    String OSActivity = getColumnValue(row, columnIndexMap, "EVT_ORIGWO", dataFormatter); // Não preenchivel



                    String routeRevision = getColumnValue(row, columnIndexMap, "routeRevision", dataFormatter);

                    String routeParent = getColumnValue(row, columnIndexMap, "routeParent", dataFormatter);
                    String billable = getColumnValue(row, columnIndexMap, "billable", dataFormatter);
                    String sourceSystem = getColumnValue(row, columnIndexMap, "sourceSystem", dataFormatter);
                    String sourceCode = getColumnValue(row, columnIndexMap, "sourceCode", dataFormatter);
                    String routedFrom = getColumnValue(row, columnIndexMap, "routedFrom", dataFormatter);
                    String acdCode = getColumnValue(row, columnIndexMap, "acdCode", dataFormatter);
                    String languageCode = getColumnValue(row, columnIndexMap, "languageCode", dataFormatter);
                    String comment = getColumnValue(row, columnIndexMap, "comment", dataFormatter);
                    String printComment = getColumnValue(row, columnIndexMap, "printComment", dataFormatter);
                    String categoryCode = getColumnValue(row, columnIndexMap, "categoryCode", dataFormatter);

                    // TELA DE ATIVIDADES DA ORDEM DE SERVIÇO (OS)
                    String ActivityCode = getColumnValue(row, columnIndexMap, "ACT_ACT", dataFormatter); // Atividade (Código)
                    String MultipleTrades = getColumnValue(row, columnIndexMap, "MultipleTrades", dataFormatter); // Vários Níveis (Não da pra ver o nome dessa coluna
                    String taskCode = getColumnValue(row, columnIndexMap, "ACT_TASK", dataFormatter); // PLANO DE TAREFA
                    String reasonForRepair = getColumnValue(row, columnIndexMap, "ACT_RPC", dataFormatter); // MOTIVO DO REPARO
                    String workAccomplished = getColumnValue(row, columnIndexMap, "ACT_WAP", dataFormatter); // TRABALHO EXECUTADO
                    String technicianPartFailure = getColumnValue(row, columnIndexMap, "ACT_TPF", dataFormatter); // FALHA DA PEÇA SEGUNDO TÉCNICO
                    String manufacturerCode = getColumnValue(row, columnIndexMap, "ACT_MANUFACT", dataFormatter); // FABRICANTE
                    String activityStartDate = getColumnValue(row, columnIndexMap, "ACT_START", dataFormatter); // DATA INÍCIO ATIVIDADE
                    String activityEndDate = getColumnValue(row, columnIndexMap, "activityEndDate", dataFormatter); // Não tem em nenhum lugar informando o nome dessa coluna
                    String estimatedHours = getColumnValue(row, columnIndexMap, "ACT_EST", dataFormatter); // HORAS ESTIMADAS
                    String hoursRemaining = getColumnValue(row, columnIndexMap, "ACT_REM", dataFormatter); // HORAS RESTANTES
                    String personsActivity = getColumnValue(row, columnIndexMap, "ACT_PERSONS", dataFormatter); // PESSOAL REQUERIDO
                    String partLocationCode = getColumnValue(row, columnIndexMap, "ACT_COMPLOCATION", dataFormatter); // LOCALIZAÇÃO DO COMPONENTE

                    String PlanningLevel = getColumnValue(row, columnIndexMap, "PlanningLevel", dataFormatter);
                    String departmentActivity = getColumnValue(row, columnIndexMap, "departmentActivity", dataFormatter);



                    String totalEstimatedHoursActivity = getColumnValue(row, columnIndexMap, "totalEstimatedHoursActivity", dataFormatter);
                    String totalHoursRemainingActivity = getColumnValue(row, columnIndexMap, "totalHoursRemainingActivity", dataFormatter);
                    String totalPeopleRequired = getColumnValue(row, columnIndexMap, "totalPeopleRequired", dataFormatter);

                    String taskRevision = getColumnValue(row, columnIndexMap, "taskRevision", dataFormatter);
                    String taskQuantity = getColumnValue(row, columnIndexMap, "taskQuantity", dataFormatter);
                    String taskUOM = getColumnValue(row, columnIndexMap, "taskUOM", dataFormatter);
                    String completed = getColumnValue(row, columnIndexMap, "completed", dataFormatter);
                    String percentCompleted = getColumnValue(row, columnIndexMap, "percentCompleted", dataFormatter);

                    String dateLastScheduledYear = getColumnValue(row, columnIndexMap, "dateLastScheduledYear", dataFormatter);
                    String dateLastScheduledMonth = getColumnValue(row, columnIndexMap, "dateLastScheduledMonth", dataFormatter);
                    String dateLastScheduledDay = getColumnValue(row, columnIndexMap, "dateLastScheduledDay", dataFormatter);
                    String scheduledHours = getColumnValue(row, columnIndexMap, "scheduledHours", dataFormatter);
                    String hiredLabor = getColumnValue(row, columnIndexMap, "hiredLabor", dataFormatter);
                    String laborTypeCode = getColumnValue(row, columnIndexMap, "laborTypeCode", dataFormatter);
                    String supplierCode = getColumnValue(row, columnIndexMap, "supplierCode", dataFormatter);
                    String normalHoursWorked = getColumnValue(row, columnIndexMap, "normalHoursWorked", dataFormatter);
                    String overtimeHoursWorked = getColumnValue(row, columnIndexMap, "overtimeHoursWorked", dataFormatter);
                    String sourceSystemActivity = getColumnValue(row, columnIndexMap, "sourceSystemActivity", dataFormatter);
                    String sourceCodeActivity = getColumnValue(row, columnIndexMap, "sourceCodeActivity", dataFormatter);




                    String warrantyActivity = getColumnValue(row, columnIndexMap, "warrantyActivity", dataFormatter);
                    String activityComment = getColumnValue(row, columnIndexMap, "activityComment", dataFormatter);
                    String relatedWorkOrderId = getColumnValue(row, columnIndexMap, "relatedWorkOrderId", dataFormatter);
                    String defermaintenance = getColumnValue(row, columnIndexMap, "defermaintenance", dataFormatter);
                    String deferactDirectmats = getColumnValue(row, columnIndexMap, "deferactDirectmats", dataFormatter);
                    String activityCode = getColumnValue(row, columnIndexMap, "activityCode", dataFormatter);

                    String dBsession = getColumnValue(row, columnIndexMap, "dBsession", dataFormatter);
                    String schedulingSessionType2 = getColumnValue(row, columnIndexMap, "schedulingSessionType2", dataFormatter);
                    String equipmentCodeActivity = getColumnValue(row, columnIndexMap, "equipmentCodeActivity", dataFormatter);
                    String activityRelatedOS = getColumnValue(row, columnIndexMap, "activityRelatedOS", dataFormatter);
                    String activityCode2 = getColumnValue(row, columnIndexMap, "activityCode2", dataFormatter);

                    //CAMPOS DEFINIDO PELO USUÁRIO
                    String UDFCHAR01 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR01", dataFormatter);
                    String UDFCHAR02 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR02", dataFormatter);
                    String UDFCHAR03 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR03", dataFormatter);
                    String UDFCHAR04 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR04", dataFormatter);
                    String UDFCHAR05 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR05", dataFormatter);
                    String UDFCHAR06 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR06", dataFormatter);
                    String UDFCHAR07 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR07", dataFormatter);
                    String UDFCHAR08 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR08", dataFormatter);
                    String UDFCHAR09 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR09", dataFormatter);
                    String UDFCHAR10 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR10", dataFormatter);
                    String UDFCHAR11 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR11", dataFormatter);
                    String UDFCHAR12 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR12", dataFormatter);
                    String UDFCHAR13 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR13", dataFormatter);
                    String UDFCHAR14 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR14", dataFormatter);
                    String UDFCHAR15 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR15", dataFormatter);
                    String UDFCHAR16 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR16", dataFormatter);
                    String UDFCHAR17 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR17", dataFormatter);
                    String UDFCHAR18 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR18", dataFormatter);
                    String UDFCHAR19 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR19", dataFormatter);
                    String UDFCHAR20 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR20", dataFormatter);
                    String UDFCHAR21 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR21", dataFormatter);
                    String UDFCHAR22 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR22", dataFormatter);
                    String UDFCHAR23 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR23", dataFormatter);
                    String UDFCHAR24 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR24", dataFormatter);
                    String UDFCHAR25 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR25", dataFormatter);
                    String UDFCHAR26 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR26", dataFormatter);
                    String UDFCHAR27 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR27", dataFormatter);
                    String UDFCHAR28 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR28", dataFormatter);
                    String UDFCHAR29 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR29", dataFormatter);
                    String UDFCHAR30 = getColumnValue(row, columnIndexMap, "EVT_UDFCHAR30", dataFormatter);
                    String UDFNum01 = getColumnValue(row, columnIndexMap, "EVT_UDFNum01", dataFormatter);
                    String UDFNum02 = getColumnValue(row, columnIndexMap, "EVT_UDFNum02", dataFormatter);
                    String UDFNum03 = getColumnValue(row, columnIndexMap, "EVT_UDFNum03", dataFormatter);
                    String UDFNum04 = getColumnValue(row, columnIndexMap, "EVT_UDFNum04", dataFormatter);
                    String UDFNum05 = getColumnValue(row, columnIndexMap, "EVT_UDFNum05", dataFormatter);
                    String udfDate01 = getColumnValue(row, columnIndexMap, "EVT_UDFDate01", dataFormatter);
                    String udfDate02 = getColumnValue(row, columnIndexMap, "EVT_UDFDate02", dataFormatter);
                    String udfDate03 = getColumnValue(row, columnIndexMap, "EVT_UDFDate03", dataFormatter);
                    String udfDate04 = getColumnValue(row, columnIndexMap, "EVT_UDFDate04", dataFormatter);
                    String udfDate05 = getColumnValue(row, columnIndexMap, "EVT_UDFDate05", dataFormatter);
                    String udfCHKBox01 = getColumnValue(row, columnIndexMap, "EVT_UDFCHKBox01", dataFormatter);
                    String udfCHKBox02 = getColumnValue(row, columnIndexMap, "EVT_UDFCHKBox02", dataFormatter);
                    String udfCHKBox03 = getColumnValue(row, columnIndexMap, "EVT_UDFCHKBox03", dataFormatter);
                    String udfCHKBox04 = getColumnValue(row, columnIndexMap, "EVT_UDFCHKBox04", dataFormatter);
                    String udfCHKBox05 = getColumnValue(row, columnIndexMap, "EVT_UDFCHKBox05", dataFormatter);



                    String linearREFuom = getColumnValue(row, columnIndexMap, "linearREFuom", dataFormatter);
                    String headerEquipment = getColumnValue(row, columnIndexMap, "headerEquipment", dataFormatter);
                    String topParentActivity = getColumnValue(row, columnIndexMap, "topParentActivity", dataFormatter);
                    String parentActivity = getColumnValue(row, columnIndexMap, "parentActivity", dataFormatter);
                    String jobSequence = getColumnValue(row, columnIndexMap, "jobSequence", dataFormatter);
                    String oldJobSequence = getColumnValue(row, columnIndexMap, "oldJobSequence", dataFormatter);
                    String isWorkOrderJOB = getColumnValue(row, columnIndexMap, "isWorkOrderJOB", dataFormatter);
                    String reusable = getColumnValue(row, columnIndexMap, "reusable", dataFormatter);
                    String currencyCode = getColumnValue(row, columnIndexMap, "currencyCode", dataFormatter);
                    String estimatedLaborCost = getColumnValue(row, columnIndexMap, "estimatedLaborCost", dataFormatter);
                    String estimatedMaterialCost = getColumnValue(row, columnIndexMap, "estimatedMaterialCost", dataFormatter);
                    String estimatedMiscellaneOusCOST = getColumnValue(row, columnIndexMap, "estimatedMiscellaneOusCOST", dataFormatter);
                    String estimatedTotalCost = getColumnValue(row, columnIndexMap, "estimatedTotalCost", dataFormatter);
                    String assignmentStatus = getColumnValue(row, columnIndexMap, "assignmentStatus", dataFormatter);
                    String preferredSupplier = getColumnValue(row, columnIndexMap, "preferredSupplier", dataFormatter);
                    String callerName = getColumnValue(row, columnIndexMap, "callerName", dataFormatter);
                    String customerCode = getColumnValue(row, columnIndexMap, "customerCode", dataFormatter);
                    String LEVEL1 = getColumnValue(row, columnIndexMap, "LEVEL1", dataFormatter);
                    String rejectionReason = getColumnValue(row, columnIndexMap, "rejectionReason", dataFormatter);
                    String fromPoint = getColumnValue(row, columnIndexMap, "fromPoint", dataFormatter);
                    String fromRefDesc = getColumnValue(row, columnIndexMap, "fromRefDesc", dataFormatter);
                    String fromGeoREF = getColumnValue(row, columnIndexMap, "fromGeoREF", dataFormatter);
                    String toPoint = getColumnValue(row, columnIndexMap, "toPoint", dataFormatter);
                    String toREFdesc = getColumnValue(row, columnIndexMap, "toREFdesc", dataFormatter);
                    String toGEOref = getColumnValue(row, columnIndexMap, "toGEOref", dataFormatter);
                    String linearReferenceCode2 = getColumnValue(row, columnIndexMap, "linearReferenceCode2", dataFormatter);
                    String fromOffSet = getColumnValue(row, columnIndexMap, "fromOffSet", dataFormatter);
                    String FromOFFsetPercentage = getColumnValue(row, columnIndexMap, "FromOFFsetPercentage", dataFormatter);
                    String ucodeEntity = getColumnValue(row, columnIndexMap, "ucodeEntity", dataFormatter);
                    String ucode = getColumnValue(row, columnIndexMap, "ucode", dataFormatter);
                    String X = getColumnValue(row, columnIndexMap, "X", dataFormatter);
                    String Y = getColumnValue(row, columnIndexMap, "Y", dataFormatter);
                    String fromLatitude = getColumnValue(row, columnIndexMap, "fromLatitude", dataFormatter);
                    String fromLongitude = getColumnValue(row, columnIndexMap, "fromLongitude", dataFormatter);
                    String relationShipType = getColumnValue(row, columnIndexMap, "relationShipType", dataFormatter);
                    String horizontalOffSet = getColumnValue(row, columnIndexMap, "horizontalOffSet", dataFormatter);
                    String linearRefUOM = getColumnValue(row, columnIndexMap, "linearRefUOM", dataFormatter);
                    String horizontalOffSetType = getColumnValue(row, columnIndexMap, "horizontalOffSetType", dataFormatter);
                    String verticalOffSet = getColumnValue(row, columnIndexMap, "verticalOffSet", dataFormatter);
                    String linearREF = getColumnValue(row, columnIndexMap, "linearREF", dataFormatter);
                    String verticalOffSetty = getColumnValue(row, columnIndexMap, "verticalOffSetty", dataFormatter);
                    String linearReferenceCode = getColumnValue(row, columnIndexMap, "linearReferenceCode", dataFormatter);
                    String toOffSet = getColumnValue(row, columnIndexMap, "toOffSet", dataFormatter);
                    String toOffSetPecentage = getColumnValue(row, columnIndexMap, "toOffSetPecentage", dataFormatter);
                    String ucodeEntity2 = getColumnValue(row, columnIndexMap, "ucodeEntity2", dataFormatter);
                    String ucode2 = getColumnValue(row, columnIndexMap, "ucode2", dataFormatter);
                    String X2 = getColumnValue(row, columnIndexMap, "X2", dataFormatter);
                    String Y2 = getColumnValue(row, columnIndexMap, "Y2", dataFormatter);
                    String toLatitude = getColumnValue(row, columnIndexMap, "toLatitude", dataFormatter);
                    String toLongitude = getColumnValue(row, columnIndexMap, "toLongitude", dataFormatter);
                    String relationShipID = getColumnValue(row, columnIndexMap, "relationShipID", dataFormatter);
                    String horizontal = getColumnValue(row, columnIndexMap, "horizontal", dataFormatter);
                    String linearUOM = getColumnValue(row, columnIndexMap, "linearUOM", dataFormatter);
                    String inspectionDirection = getColumnValue(row, columnIndexMap, "inspectionDirection", dataFormatter);
                    String flowCode = getColumnValue(row, columnIndexMap, "flowCode", dataFormatter);
                    String multiEquip = getColumnValue(row, columnIndexMap, "multiEquip", dataFormatter);
                    String customerContract = getColumnValue(row, columnIndexMap, "customerContract", dataFormatter);
                    String workAddress = getColumnValue(row, columnIndexMap, "workAddress", dataFormatter);
                    String caseCode = getColumnValue(row, columnIndexMap, "caseCode", dataFormatter);
                    String caseType = getColumnValue(row, columnIndexMap, "caseType", dataFormatter);
                    String duplicateCase = getColumnValue(row, columnIndexMap, "duplicateCase", dataFormatter);
                    String contactRecord = getColumnValue(row, columnIndexMap, "contactRecord", dataFormatter);
                    String serviceRequestStatus = getColumnValue(row, columnIndexMap, "serviceRequestStatus", dataFormatter);
                    String originatingCase = getColumnValue(row, columnIndexMap, "originatingCase", dataFormatter);
                    String originationTaskCode = getColumnValue(row, columnIndexMap, "originationTaskCode", dataFormatter);
                    String alertCode = getColumnValue(row, columnIndexMap, "alertCode", dataFormatter);
                    String productionRequestCode = getColumnValue(row, columnIndexMap, "productionRequestCode", dataFormatter);
                    String productionOrder = getColumnValue(row, columnIndexMap, "productionOrder", dataFormatter);
                    String productionPriority = getColumnValue(row, columnIndexMap, "productionPriority", dataFormatter);
                    String productionPriorityDesc = getColumnValue(row, columnIndexMap, "productionPriorityDesc", dataFormatter);
                    String accountingEntity = getColumnValue(row, columnIndexMap, "accountingEntity", dataFormatter);
                    String campaignCode = getColumnValue(row, columnIndexMap, "campaignCode", dataFormatter);
                    String campaignStatus = getColumnValue(row, columnIndexMap, "campaignStatus", dataFormatter);
                    String maintenancePatternCode = getColumnValue(row, columnIndexMap, "maintenancePatternCode", dataFormatter);
                    String safetyReviewedBy = getColumnValue(row, columnIndexMap, "safetyReviewedBy", dataFormatter);
                    String permitReviewedBy = getColumnValue(row, columnIndexMap, "permitReviewedBy", dataFormatter);
                    String originalWorkOrderACT = getColumnValue(row, columnIndexMap, "originalWorkOrderACT", dataFormatter);
                    String currencyCode2 = getColumnValue(row, columnIndexMap, "currencyCode2", dataFormatter);
                    String estimatedLaborCost2 = getColumnValue(row, columnIndexMap, "estimatedLaborCost2", dataFormatter);
                    String estimatedMaterialCost2 = getColumnValue(row, columnIndexMap, "estimatedMaterialCost2", dataFormatter);
                    String estimatedMiscellaneOusCOST2 = getColumnValue(row, columnIndexMap, "estimatedMiscellaneOusCOST2", dataFormatter);
                    String workspaceNumber = getColumnValue(row, columnIndexMap, "workspaceNumber", dataFormatter);
                    String workSpaceCode = getColumnValue(row, columnIndexMap, "workSpaceCode", dataFormatter);
                    String positionEquipmentCode = getColumnValue(row, columnIndexMap, "positionEquipmentCode", dataFormatter);
                    String manufacturerCode2 = getColumnValue(row, columnIndexMap, "manufacturerCode2", dataFormatter);
                    String OEMsite = getColumnValue(row, columnIndexMap, "OEMsite", dataFormatter);
                    String vendor = getColumnValue(row, columnIndexMap, "vendor", dataFormatter);
                    String coverageType = getColumnValue(row, columnIndexMap, "coverageType", dataFormatter);
                    String latitude = getColumnValue(row, columnIndexMap, "latitude", dataFormatter);
                    String longitude = getColumnValue(row, columnIndexMap, "longitude", dataFormatter);
                    String woTypeCategory = getColumnValue(row, columnIndexMap, "woTypeCategory", dataFormatter);
                    String minor = getColumnValue(row, columnIndexMap, "minor", dataFormatter);



                    System.out.println("OS Code: " + OS);
                    System.out.println("Equipment Code: " + equipmentCode);
                    System.out.println("Equipment Organization: " + workOrderOrganization);
                    System.out.println("Work Order Description: " + workOrderDescription);
                    System.out.println("Work Order Type: " + workOrderType);
                    System.out.println("Work Order Status: " + workOrderStatus);

                    AssetEquipment assetEquipment = assetService.getAsset(apiUser, equipmentCode, workOrderOrganization);
                    if (Objects.equals(assetEquipment.getStatus(), "D"))
                        throw new IllegalAccessException("Equipment is not installed in this organization: " + workOrderOrganization);

                    // Verifica se a coluna "OS" está vazia e cria a ordem de serviço
                    WorkOrderData workOrderData = new WorkOrderData();

                    workOrderData.setOS(OS);
                    workOrderData.setWorkOrderOrganization(workOrderOrganization);
                    workOrderData.setWorkOrderDescription(workOrderDescription);
                    workOrderData.setStatus(workOrderStatus);
                    workOrderData.setEquipmentCode(equipmentCode);
                    workOrderData.setDepartment(workOrderDepartment);
                    workOrderData.setType(workOrderType);
                    workOrderData.setCreatedBy(createdBy);
                    workOrderData.setUpdatedBy(updatedBy);
                    workOrderData.setProblemCode(workOrderProblemCode);
                    workOrderData.setStandardWork(standardWork);
                    workOrderData.setPriorityCode(priorityCode);
                    workOrderData.setLocationCode(locationCode);
                    workOrderData.setCostCode(costCode);
                    workOrderData.setProjectCode(projectCode);
                    workOrderData.setTargetValue(targetValue);
                    workOrderData.setCriticality(criticality);
                    workOrderData.setPpmCode(ppmCode);
                    workOrderData.setServiceRequestCode(serviceRequestCode);
                    workOrderData.setSafety(safety);
                    workOrderData.setWarranty(warranty);
                    workOrderData.setEquipmentAlias(equipmentAlias);
                    workOrderData.setSerialNumber(serialNumber);
                    workOrderData.setModel(model);
                    workOrderData.setPersonCode(personCode);
                    workOrderData.setSchedGroup(schedGroup);
                    workOrderData.setAssignedTo(assignedTo);
                    workOrderData.setShiftCode(shiftCode);
                    workOrderData.setCnnNumber(cnnNumber);
                    workOrderData.setMeterUnit(meterUnit);
                    workOrderData.setLastMeterReading(lastMeterReading);
                    workOrderData.setTriggerEvent(triggerEvent);
                    workOrderData.setMsProject(msProject);
                    workOrderData.setSchedulingSessionType(schedulingSessionType);
                    workOrderData.setDepend(depend);
                    workOrderData.setOBJtype(OBJtype);
                    workOrderData.setFailureCode(failureCode);
                    workOrderData.setCauseCode(causeCode);
                    workOrderData.setActionCode(actionCode);
                    workOrderData.setDowntimeHours(downtimeHours);
                    workOrderData.setDownTimeCostValue(downTimeCostValue);
                    workOrderData.setReopened(reopened);
                    workOrderData.setFrequency(frequency);
                    workOrderData.setEVTisType(EVTisType);
                    workOrderData.setMeterDue(meterDue);
                    workOrderData.setMeterDue2(meterDue2);
                    workOrderData.setWorkPackage(workPackage);
                    workOrderData.setPeriodUOMCode(periodUOMCode);
                    workOrderData.setMeterUOMcode(meterUOMcode);
                    workOrderData.setRouteCode(routeCode);
                    workOrderData.setRouteRevision(routeRevision);
                    workOrderData.setRouteStatus(routeStatus);
                    workOrderData.setRouteParent(routeParent);
                    workOrderData.setBillable(billable);
                    workOrderData.setPrinted(printed);
                    workOrderData.setPrint(print);
                    workOrderData.setSourceSystem(sourceSystem);
                    workOrderData.setSourceCode(sourceCode);
                    workOrderData.setRoutedFrom(routedFrom);
                    workOrderData.setAcdCode(acdCode);
                    workOrderData.setLanguageCode(languageCode);
                    workOrderData.setComment(comment);
                    workOrderData.setPrintComment(printComment);
                    workOrderData.setCategoryCode(categoryCode);
                    workOrderData.setOSActivity(OSActivity);
                    workOrderData.setActivityCode(ActivityCode);
                    workOrderData.setMultipleTrades(MultipleTrades);
                    workOrderData.setPlanningLevel(PlanningLevel);
                    workOrderData.setDepartmentActivity(departmentActivity);
                    workOrderData.setEstimatedHours(estimatedHours);
                    workOrderData.setHoursRemaining(hoursRemaining);
                    workOrderData.setPersonsActivity(personsActivity);
                    workOrderData.setTotalEstimatedHoursActivity(totalEstimatedHoursActivity);
                    workOrderData.setTotalHoursRemainingActivity(totalHoursRemainingActivity);
                    workOrderData.setTotalPeopleRequired(totalPeopleRequired);
                    workOrderData.setTaskCode(taskCode);
                    workOrderData.setTaskRevision(taskRevision);
                    workOrderData.setTaskQuantity(taskQuantity);
                    workOrderData.setTaskUOM(taskUOM);
                    workOrderData.setCompleted(completed);
                    workOrderData.setPercentCompleted(percentCompleted);
                    workOrderData.setActivityStartYear(activityStartDate);
                    workOrderData.setActivityStartMonth(activityStartDate);
                    workOrderData.setActivityStartDay(activityStartDate);
                    workOrderData.setActivityEndYear(activityEndDate);
                    workOrderData.setActivityEndMonth(activityEndDate);
                    workOrderData.setActivityEndDay(activityEndDate);
                    workOrderData.setDateLastScheduledYear(dateLastScheduledYear);
                    workOrderData.setDateLastScheduledMonth(dateLastScheduledMonth);
                    workOrderData.setDateLastScheduledDay(dateLastScheduledDay);
                    workOrderData.setScheduledHours(scheduledHours);
                    workOrderData.setHiredLabor(hiredLabor);
                    workOrderData.setLaborTypeCode(laborTypeCode);
                    workOrderData.setSupplierCode(supplierCode);
                    workOrderData.setNormalHoursWorked(normalHoursWorked);
                    workOrderData.setOvertimeHoursWorked(overtimeHoursWorked);
                    workOrderData.setSourceSystemActivity(sourceSystemActivity);
                    workOrderData.setSourceCodeActivity(sourceCodeActivity);
                    workOrderData.setReasonForRepair(reasonForRepair);
                    workOrderData.setWorkAccomplished(workAccomplished);
                    workOrderData.setTechnicianPartFailure(technicianPartFailure);
                    workOrderData.setManufacturerCode(manufacturerCode);
                    workOrderData.setWarrantyActivity(warrantyActivity);
                    workOrderData.setActivityComment(activityComment);
                    workOrderData.setRelatedWorkOrderId(relatedWorkOrderId);
                    workOrderData.setDefermaintenance(defermaintenance);
                    workOrderData.setDeferactDirectmats(deferactDirectmats);
                    workOrderData.setPartLocationCode(partLocationCode);
                    workOrderData.setdBsession(dBsession);
                    workOrderData.setSchedulingSessionType2(schedulingSessionType2);
                    workOrderData.setEquipmentCodeActivity(equipmentCodeActivity);
                    workOrderData.setActivityRelatedOS(activityRelatedOS);
                    workOrderData.setActivityCode2(activityCode2);
                    workOrderData.setUDFCHAR01(UDFCHAR01);
                    workOrderData.setUDFCHAR02(UDFCHAR02);
                    workOrderData.setUDFCHAR03(UDFCHAR03);
                    workOrderData.setUDFCHAR04(UDFCHAR04);
                    workOrderData.setUDFCHAR05(UDFCHAR05);
                    workOrderData.setUDFCHAR06(UDFCHAR06);
                    workOrderData.setUDFCHAR07(UDFCHAR07);
                    workOrderData.setUDFCHAR08(UDFCHAR08);
                    workOrderData.setUDFCHAR09(UDFCHAR09);
                    workOrderData.setUDFCHAR10(UDFCHAR10);
                    workOrderData.setUDFCHAR11(UDFCHAR11);
                    workOrderData.setUDFCHAR12(UDFCHAR12);
                    workOrderData.setUDFCHAR13(UDFCHAR13);
                    workOrderData.setUDFCHAR14(UDFCHAR14);
                    workOrderData.setUDFCHAR15(UDFCHAR15);
                    workOrderData.setUDFCHAR16(UDFCHAR16);
                    workOrderData.setUDFCHAR17(UDFCHAR17);
                    workOrderData.setUDFCHAR18(UDFCHAR18);
                    workOrderData.setUDFCHAR19(UDFCHAR19);
                    workOrderData.setUDFCHAR20(UDFCHAR20);
                    workOrderData.setUDFCHAR21(UDFCHAR21);
                    workOrderData.setUDFCHAR22(UDFCHAR22);
                    workOrderData.setUDFCHAR23(UDFCHAR23);
                    workOrderData.setUDFCHAR24(UDFCHAR24);
                    workOrderData.setUDFCHAR25(UDFCHAR25);
                    workOrderData.setUDFCHAR26(UDFCHAR26);
                    workOrderData.setUDFCHAR27(UDFCHAR27);
                    workOrderData.setUDFCHAR28(UDFCHAR28);
                    workOrderData.setUDFCHAR29(UDFCHAR29);
                    workOrderData.setUDFCHAR30(UDFCHAR30);
                    workOrderData.setUDFNum01(UDFNum01);
                    workOrderData.setUDFNum02(UDFNum02);
                    workOrderData.setUDFNum03(UDFNum03);
                    workOrderData.setUDFNum04(UDFNum04);
                    workOrderData.setUDFNum05(UDFNum05);
                    workOrderData.setUDFDateYear01(udfDate01);
                    workOrderData.setUDFDateMonth01(udfDate01);
                    workOrderData.setUDFDateDay01(udfDate01);
                    workOrderData.setUDFDateYear02(udfDate02);
                    workOrderData.setUDFDateMonth02(udfDate02);
                    workOrderData.setUDFDateDay02(udfDate02);
                    workOrderData.setUDFDateYear03(udfDate03);
                    workOrderData.setUDFDateMonth03(udfDate03);
                    workOrderData.setUDFDateDay03(udfDate03);
                    workOrderData.setUDFDateYear04(udfDate04);
                    workOrderData.setUDFDateMonth04(udfDate04);
                    workOrderData.setUDFDateDay04(udfDate04);
                    workOrderData.setUDFDateYear05(udfDate05);
                    workOrderData.setUDFDateMonth05(udfDate05);
                    workOrderData.setUDFDateDay05(udfDate05);
                    workOrderData.setUdfCHKBox01(udfCHKBox01);
                    workOrderData.setUdfCHKBox02(udfCHKBox02);
                    workOrderData.setUdfCHKBox03(udfCHKBox03);
                    workOrderData.setUdfCHKBox04(udfCHKBox04);
                    workOrderData.setUdfCHKBox05(udfCHKBox05);
                    workOrderData.setLinearREFuom2(linearREFuom);
                    workOrderData.setHeaderEquipment(headerEquipment);
                    workOrderData.setTopParentActivity(topParentActivity);
                    workOrderData.setParentActivity(parentActivity);
                    workOrderData.setJobSequence(jobSequence);
                    workOrderData.setOldJobSequence(oldJobSequence);
                    workOrderData.setIsWorkOrderJOB(isWorkOrderJOB);
                    workOrderData.setReusable(reusable);
                    workOrderData.setCurrencyCode(currencyCode);
                    workOrderData.setEstimatedLaborCost(estimatedLaborCost);
                    workOrderData.setEstimatedMaterialCost(estimatedMaterialCost);
                    workOrderData.setEstimatedMiscellaneOusCOST(estimatedMiscellaneOusCOST);
                    workOrderData.setEstimatedTotalCost(estimatedTotalCost);
                    workOrderData.setAssignmentStatus(assignmentStatus);
                    workOrderData.setPreferredSupplier(preferredSupplier);
                    workOrderData.setTargetDateYear(targetDate);
                    workOrderData.setTargetDateMonth(targetDate);
                    workOrderData.setTargetDateDay(targetDate);
                    workOrderData.setSchedEndYear(schedDate);
                    workOrderData.setSchedEndMonth(schedDate);
                    workOrderData.setSchedEndDay(schedDate);
                    workOrderData.setRequestedStartYear(requestedStartDate);
                    workOrderData.setRequestedStartMonth(requestedStartDate);
                    workOrderData.setRequestedStartDay(requestedStartDate);
                    workOrderData.setRequestedEndYear(requestedEndDate);
                    workOrderData.setRequestedEndMonth(requestedEndDate);
                    workOrderData.setRequestedEndDay(requestedEndDate);
                    workOrderData.setStartDateYear(startDate);
                    workOrderData.setStartDateMonth(startDate);
                    workOrderData.setStartDateDay(startDate);
                    workOrderData.setCompletedDateYear(completedDate);
                    workOrderData.setCompletedDateMonth(completedDate);
                    workOrderData.setCompletedDateDay(completedDate);
                    workOrderData.setCallerName(callerName);
                    workOrderData.setCustomerCode(customerCode);
                    workOrderData.setLEVEL1(LEVEL1);
                    workOrderData.setRejectionReason(rejectionReason);
                    workOrderData.setFromPoint(fromPoint);
                    workOrderData.setFromRefDesc(fromRefDesc);
                    workOrderData.setFromGeoREF(fromGeoREF);
                    workOrderData.setToPoint(toPoint);
                    workOrderData.setToREFdesc(toREFdesc);
                    workOrderData.setToGEOref(toGEOref);
                    workOrderData.setLinearReferenceCode2(linearReferenceCode2);
                    workOrderData.setFromOffSet(fromOffSet);
                    workOrderData.setFromOFFsetPercentage(FromOFFsetPercentage);
                    workOrderData.setUcodeEntity(ucodeEntity);
                    workOrderData.setUcode(ucode);
                    workOrderData.setX(X);
                    workOrderData.setY(Y);
                    workOrderData.setFromLatitude(fromLatitude);
                    workOrderData.setFromLongitude(fromLongitude);
                    workOrderData.setRelationShipType(relationShipType);
                    workOrderData.setHorizontalOffSet(horizontalOffSet);
                    workOrderData.setLinearRefUOM(linearRefUOM);
                    workOrderData.setHorizontalOffSetType(horizontalOffSetType);
                    workOrderData.setVerticalOffSet(verticalOffSet);
                    workOrderData.setLinearREF(linearREF);
                    workOrderData.setVerticalOffSetty(verticalOffSetty);
                    workOrderData.setLinearReferenceCode(linearReferenceCode);
                    workOrderData.setToOffSet(toOffSet);
                    workOrderData.setToOffSetPecentage(toOffSetPecentage);
                    workOrderData.setUcodeEntity2(ucodeEntity2);
                    workOrderData.setUcode2(ucode2);
                    workOrderData.setX2(X2);
                    workOrderData.setY2(Y2);
                    workOrderData.setToLatitude(toLatitude);
                    workOrderData.setToLongitude(toLongitude);
                    workOrderData.setRelationShipID(relationShipID);
                    workOrderData.setHorizontal(horizontal);
                    workOrderData.setLinearUOM(linearUOM);
                    workOrderData.setInspectionDirection(inspectionDirection);
                    workOrderData.setFlowCode(flowCode);
                    workOrderData.setMultiEquip(multiEquip);
                    workOrderData.setCustomerContract(customerContract);
                    workOrderData.setWorkAddress(workAddress);
                    workOrderData.setCaseCode(caseCode);
                    workOrderData.setCaseType(caseType);
                    workOrderData.setDuplicateCase(duplicateCase);
                    workOrderData.setContactRecord(contactRecord);
                    workOrderData.setServiceRequestStatus(serviceRequestStatus);
                    workOrderData.setOriginatingCase(originatingCase);
                    workOrderData.setOriginationTaskCode(originationTaskCode);
                    workOrderData.setAlertCode(alertCode);
                    workOrderData.setProductionRequestCode(productionRequestCode);
                    workOrderData.setProductionOrder(productionOrder);
                    workOrderData.setProductionPriority(productionPriority);
                    workOrderData.setProductionPriorityDesc(productionPriorityDesc);
                    workOrderData.setAccountingEntity(accountingEntity);
                    workOrderData.setCampaignCode(campaignCode);
                    workOrderData.setCampaignStatus(campaignStatus);
                    workOrderData.setMaintenancePatternCode(maintenancePatternCode);
                    workOrderData.setSafetyReviewedBy(safetyReviewedBy);
                    workOrderData.setPermitReviewedBy(permitReviewedBy);
                    workOrderData.setOriginalWorkOrderACT(originalWorkOrderACT);
                    workOrderData.setCurrencyCode2(currencyCode2);
                    workOrderData.setEstimatedLaborCost2(estimatedLaborCost2);
                    workOrderData.setEstimatedMaterialCost2(estimatedMaterialCost2);
                    workOrderData.setEstimatedMiscellaneOusCOST2(estimatedMiscellaneOusCOST2);
                    workOrderData.setWorkspaceNumber(workspaceNumber);
                    workOrderData.setWorkSpaceCode(workSpaceCode);
                    workOrderData.setPositionEquipmentCode(positionEquipmentCode);
                    workOrderData.setManufacturerCode2(manufacturerCode2);
                    workOrderData.setOEMsite(OEMsite);
                    workOrderData.setVendor(vendor);
                    workOrderData.setCoverageType(coverageType);
                    workOrderData.setLatitude(latitude);
                    workOrderData.setLongitude(longitude);
                    workOrderData.setWoTypeCategory(woTypeCategory);
                    workOrderData.setMinor(minor);

                    String result = workOrderCreationService.postWorkOrder(apiUser, workOrderData);

                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("Atualizando resultadoLabel");
                                resultadoLabel.setForeground(Color.RED); // Define a cor do texto para vermelho
                                resultadoLabel.setText("<html>" + result.replace("\n", "<br>") + "</html>"); // Imprime mensagem do resultado na interface.
                            }
                        });

                        System.out.println("Resultado da criação da Ordem de Serviço: " + ("<html>" + result.replace("\n", "<br>") + "</html>"));
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

