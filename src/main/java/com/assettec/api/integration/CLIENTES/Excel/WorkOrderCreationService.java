package com.assettec.api.integration.CLIENTES.Excel;

import com.assettec.api.integration.CLIENTES.Excel.Modulos.Data.WorkOrderData;
import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.integration.CLIENTES.Excel.Modulos.Data.WorkOrderData;
import com.assettec.api.internal.users.ApiUserService;
import com.assettec.api.internal.utilities.common.XMLParser;
import com.assettec.api.internal.utilities.handlers.RequestCreator;
import com.assettec.api.internal.utilities.handlers.RequestSender;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;


@Service
@AllArgsConstructor
public class WorkOrderCreationService {

    private RequestCreator requestBuilder;
    private RequestSender requestSender;
    private XMLParser xmlParser;


    @SneakyThrows
    public String postWorkOrder(ApiUser apiUser, WorkOrderData workOrderData) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        // Modelo antigo
//        String[] UDFDateParts01 = UDFDate01.split("-");
//        String UDFDateDay01 = UDFDateParts01[0];
//        String UDFDateMonth01 = UDFDateParts01[1];
//        String UDFDateYear01 = UDFDateParts01[2];

        String activityStartDate = workOrderData.getActivityStartDate();
        String activityEndDate = workOrderData.getActivityEndDate();
        String UDFDate01 = workOrderData.getUDFDate01();
        String UDFDate02 = workOrderData.getUDFDate02();
        String UDFDate03 = workOrderData.getUDFDate03();
        String UDFDate04 = workOrderData.getUDFDate04();
        String UDFDate05 = workOrderData.getUDFDate05();
        String targetDate = workOrderData.getTargetDate();
        String schedDate = workOrderData.getSchedDate();
        String requestedStartDate = workOrderData.getRequestedStartDate();
        String requestedEndDate = workOrderData.getRequestedEndDate();
        String startDate = workOrderData.getStartDate();
        String completedDate = workOrderData.getCompletedDate();

// Define other variables in a similar manner.


        // Parse the start date into DAY, MONTH, and YEAR
        String[] startDateParts = activityStartDate.split("-");
        workOrderData.setActivityStartDay(startDateParts[0]);
        workOrderData.setActivityStartMonth(startDateParts[1]);
        workOrderData.setActivityStartYear(startDateParts[2]);

        // Parse the end date into DAY, MONTH, and YEAR
        String[] endDateParts = activityEndDate.split("-");
        workOrderData.setActivityEndDay(endDateParts[0]);
        workOrderData.setActivityEndMonth(endDateParts[1]);
        workOrderData.setActivityEndYear(endDateParts[2]);

        String[] UDFDateParts01 = UDFDate01.split("-");
        workOrderData.setUDFDateDay01(UDFDateParts01[0]);
        workOrderData.setUDFDateMonth01(UDFDateParts01[1]);
        workOrderData.setUDFDateYear01(UDFDateParts01[2]);

        String[] UDFDateParts02 = UDFDate02.split("-");
        workOrderData.setUDFDateDay02(UDFDateParts02[0]);
        workOrderData.setUDFDateMonth02(UDFDateParts02[1]);
        workOrderData.setUDFDateYear02(UDFDateParts02[2]);

        String[] UDFDateParts03 = UDFDate03.split("-");
        workOrderData.setUDFDateDay03(UDFDateParts03[0]);
        workOrderData.setUDFDateMonth03(UDFDateParts03[1]);
        workOrderData.setUDFDateYear03(UDFDateParts03[2]);

        String[] UDFDateParts04 = UDFDate04.split("-");
        workOrderData.setUDFDateDay04(UDFDateParts04[0]);
        workOrderData.setUDFDateMonth04(UDFDateParts04[1]);
        workOrderData.setUDFDateYear04(UDFDateParts04[2]);

        String[] UDFDateParts05 = UDFDate05.split("-");
        workOrderData.setUDFDateDay05(UDFDateParts05[0]);
        workOrderData.setUDFDateMonth05(UDFDateParts05[1]);
        workOrderData.setUDFDateYear05(UDFDateParts05[2]);

        String[] targetDateParts = targetDate.split("-");
        workOrderData.setTargetDateDay(targetDateParts[0]);
        workOrderData.setTargetDateMonth(targetDateParts[1]);
        workOrderData.setTargetDateYear(targetDateParts[2]);

        String[] schedEndParts = schedDate.split("-");
        workOrderData.setSchedEndDay(schedEndParts[0]);
        workOrderData.setSchedEndMonth(schedEndParts[1]);
        workOrderData.setSchedEndYear(schedEndParts[2]);

        String[] requestedStartParts = requestedStartDate.split("-");
        workOrderData.setRequestedStartDay(requestedStartParts[0]);
        workOrderData.setRequestedStartMonth(requestedStartParts[1]);
        workOrderData.setRequestedStartYear(requestedStartParts[2]);

        String[] requestedEndParts = requestedEndDate.split("-");
        workOrderData.setRequestedEndDay(requestedEndParts[0]);
        workOrderData.setRequestedEndMonth(requestedEndParts[1]);
        workOrderData.setRequestedEndYear(requestedEndParts[2]);

        String[] startDateeParts = startDate.split("-");
        workOrderData.setStartDateDay(startDateeParts[0]);
        workOrderData.setStartDateMonth(startDateeParts[1]);
        workOrderData.setStartDateYear(startDateeParts[2]);

        String[] completedDateParts = completedDate.split("-");
        workOrderData.setCompletedDateDay(completedDateParts[0]);
        workOrderData.setCompletedDateMonth(completedDateParts[1]);
        workOrderData.setCompletedDateYear(completedDateParts[2]);


        postRequest = requestBuilder.getExcelRequestBuilder().postWorkOrder(apiUser, workOrderData
        );
        response = requestSender.sendPostRequest(postRequest, host);
        Document xmlData = xmlParser.toDocument(response);

        return xmlData.getElementsByTagName("Message").item(0).getTextContent();
    }

    @SneakyThrows
    public String postTrackingData(ApiUser apiUser, String TRANSID, String TRANSCODE, String PROMPTDATA1, String PROMPTDATA2, String PROMPTDATA3, String PROMPTDATA4, String PROMPTDATA5,  String PROMPTDATA6, String PROMPTDATA7, String PROMPTDATA8, String PROMPTDATA9, String PROMPTDATA10, String PROMPTDATA11, String PROMPTDATA12, String PROMPTDATA13, String PROMPTDATA14, String PROMPTDATA15, String PROMPTDATA16, String PROMPTDATA17, String PROMPTDATA18, String PROMPTDATA19, String PROMPTDATA20, String PROMPTDATA21, String PROMPTDATA22, String PROMPTDATA23, String PROMPTDATA24, String PROMPTDATA25, String PROMPTDATA26, String PROMPTDATA27, String PROMPTDATA28, String PROMPTDATA29, String PROMPTDATA30, String PROMPTDATA31, String PROMPTDATA32, String PROMPTDATA33, String PROMPTDATA34, String PROMPTDATA35, String PROMPTDATA36, String PROMPTDATA37, String PROMPTDATA38, String PROMPTDATA39, String PROMPTDATA40, String PROMPTDATA41, String PROMPTDATA42, String PROMPTDATA43, String PROMPTDATA44, String PROMPTDATA45, String PROMPTDATA46, String PROMPTDATA47, String PROMPTDATA48, String PROMPTDATA49, String PROMPTDATA50, String PROMPTDATA51) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getTrackingDataBuilder().postTrackingData(apiUser, TRANSID, TRANSCODE, PROMPTDATA1, PROMPTDATA2, PROMPTDATA3, PROMPTDATA4, PROMPTDATA5, PROMPTDATA6, PROMPTDATA7, PROMPTDATA8, PROMPTDATA9, PROMPTDATA10, PROMPTDATA11, PROMPTDATA12, PROMPTDATA13, PROMPTDATA14, PROMPTDATA15, PROMPTDATA16, PROMPTDATA17, PROMPTDATA18, PROMPTDATA19, PROMPTDATA20, PROMPTDATA21, PROMPTDATA22, PROMPTDATA23, PROMPTDATA24, PROMPTDATA25, PROMPTDATA26, PROMPTDATA27, PROMPTDATA28, PROMPTDATA29, PROMPTDATA30, PROMPTDATA31, PROMPTDATA32, PROMPTDATA33, PROMPTDATA34, PROMPTDATA35, PROMPTDATA36, PROMPTDATA37, PROMPTDATA38, PROMPTDATA39, PROMPTDATA40, PROMPTDATA41, PROMPTDATA42, PROMPTDATA43, PROMPTDATA44, PROMPTDATA45, PROMPTDATA46, PROMPTDATA47, PROMPTDATA48, PROMPTDATA49, PROMPTDATA50, PROMPTDATA51);
        // Debug opcional: imprimir o XML enviado (ativar quando necessário)
        System.out.println("[TrackingData][Request] \n" + postRequest);
        response = requestSender.sendPostRequest(postRequest, host);
        // Debug opcional: imprimir o XML de resposta
        System.out.println("[TrackingData][Response] \n" + response);
        Document xmlData = xmlParser.toDocument(response);

        NodeList messageNodes = xmlData.getElementsByTagName("Message");
        if (messageNodes.getLength() > 0) {
            return messageNodes.item(0).getTextContent();
        } else {
            return "Dados carregado na tabela TrackingData";
        }
    }

    // Parts Service (Peças)
    @SneakyThrows
    public String postPartsData(ApiUser apiUser, String partCode, String organizationCode, String descriptionCode, String classCode, String classOrganization, String descriptionClass, String categoryCode, String categoryDescription, String uomCode, String toolCode, String toolOrganization, String toolDescription, String commodityCode, String commodityOrganization, String secondaryCommodityCode, String secondaryCommodityOrganization, String secondaryCommodityDescription, String methodCode, String taxCode, String taxOrganization, String taxDescription, String trackMethodTypeCode, String partCodeStructure, String userCode, String supplierCode, String supplierOrganization, String supplierDescription, String currencyCode, String supplierUOM, String commodityDescription, String conversionFactor, String UDFCHAR01, String UDFCHAR02, String UDFCHAR03, String UDFCHAR04, String UDFCHAR05, String UDFCHAR06, String UDFCHAR07, String UDFCHAR08, String UDFCHAR09, String UDFCHAR10, String UDFCHAR11, String UDFCHAR12, String UDFCHAR13, String UDFCHAR14, String UDFCHAR15, String UDFCHAR16, String UDFCHAR17, String UDFCHAR18, String UDFCHAR19, String UDFCHAR20, String UDFCHAR21, String UDFCHAR22, String UDFCHAR23, String UDFCHAR24, String UDFCHAR25, String UDFCHAR26, String UDFCHAR27, String UDFCHAR28, String UDFCHAR29, String UDFCHAR30, String objectCode, String profileOrganization, String profileDescription, String typeCode, String classIdCode, String classIdOrganization, String classIdDescription, String statusCode, String departmentCode, String departmentOrganization, String departmentDescription, String categoryIdCode, String costCode, String costOrganization, String storeCode, String storeOrganization, String storeDescription, String partIdCode, String partIdOrganization, String partIdDescription, String meterUnit, String manufacturerCode, String serialNumber, String model, String modelRevision, String cnNumber, String propertyCode, String propertyLabel, String UserDefinedClassCode, String UserDefinedClassOrg, String UserDefinedClassDescription, String priceType, String byAsset, String byLot, String kit, String saveHistory, String outOfService, String inspectionRequired, String repairable, String calibrationStandard, String preventReorders) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getPartsRequestBuilder().postPartsData(apiUser, partCode, organizationCode, descriptionCode, classCode, classOrganization, descriptionClass, categoryCode, categoryDescription, uomCode, toolCode, toolOrganization, toolDescription, commodityCode, commodityOrganization, secondaryCommodityCode, secondaryCommodityOrganization, secondaryCommodityDescription, methodCode, taxCode, taxOrganization, taxDescription, trackMethodTypeCode, partCodeStructure, userCode, supplierCode, supplierOrganization, supplierDescription, currencyCode, supplierUOM, commodityDescription, conversionFactor, UDFCHAR01, UDFCHAR02, UDFCHAR03, UDFCHAR04, UDFCHAR05, UDFCHAR06, UDFCHAR07, UDFCHAR08, UDFCHAR09, UDFCHAR10, UDFCHAR11, UDFCHAR12, UDFCHAR13, UDFCHAR14, UDFCHAR15, UDFCHAR16, UDFCHAR17, UDFCHAR18, UDFCHAR19, UDFCHAR20, UDFCHAR21, UDFCHAR22, UDFCHAR23, UDFCHAR24, UDFCHAR25, UDFCHAR26, UDFCHAR27, UDFCHAR28, UDFCHAR29, UDFCHAR30, objectCode, profileOrganization, profileDescription, typeCode, classIdCode, classIdOrganization, classIdDescription, statusCode, departmentCode, departmentOrganization, departmentDescription, categoryIdCode, costCode, costOrganization, storeCode, storeOrganization, storeDescription, partIdCode, partIdOrganization, partIdDescription, meterUnit, manufacturerCode, serialNumber, model, modelRevision, cnNumber, propertyCode, propertyLabel, UserDefinedClassCode, UserDefinedClassOrg, UserDefinedClassDescription, priceType, byAsset, byLot, kit, saveHistory, outOfService, inspectionRequired, repairable, calibrationStandard, preventReorders
        );
        response = requestSender.sendPostRequest(postRequest, host);
        Document xmlData = xmlParser.toDocument(response);

        NodeList messageNodes = xmlData.getElementsByTagName("Message");
        if (messageNodes.getLength() > 0) {
            return messageNodes.item(0).getTextContent();
        } else {
            return "Dados carregado na tabela TrackingData";
        }
    }

    //    @SneakyThrows
    //    public String deleteWorkOrder(ApiUser apiUser, String serviceId) {
    //        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());
    //
    //        postRequest = requestBuilder.getWorkOrderRequestBuilder().deleteWorkOrderBuilder(apiUser, serviceId);
    //        response = requestSender.sendPostRequest(postRequest, host);
    //        Document xmlData = xmlParser.toDocument(response);
    //
    //        return xmlData.getElementsByTagName("Message").item(0).getTextContent();
    //    }

    @SneakyThrows
    public String postComment(ApiUser apiUser, String OS, String language, String comment, String print) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getCommentsRequestBuilder().addComments(apiUser, OS, language, comment, print);
        response = requestSender.sendPostRequest(postRequest, host);

        // Verificar o conteúdo do XML retornado
        System.out.println("XML Response: " + response);

        // Verificar se há uma tag de erro na resposta do servidor
        if (response.contains("<ns1:Message>")) {
            int start = response.indexOf("<ns1:Message>") + "<ns1:Message>".length();
            int end = response.indexOf("</ns1:Message>", start);
            String errorMessage = response.substring(start, end);
            return errorMessage;
        } else {
            // Se não houver uma mensagem de erro específica, consideramos que a operação foi bem-sucedida
            return null;
        }
    }

    @SneakyThrows
    public String postActivity(ApiUser apiUser, String OS, String ActivityCode, String Nivel, String PERSONS, String ESTIMATEDHOURS, String activityStartDate, String activityEndDate) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        // Parse the start date into DAY, MONTH, and YEAR
        String[] startDateParts = activityStartDate.split("-");
        String startDay = startDateParts[0];
        String startMonth = startDateParts[1];
        String startYear = startDateParts[2];

        // Parse the end date into DAY, MONTH, and YEAR
        String[] endDateParts = activityEndDate.split("-");
        String endDay = endDateParts[0];
        String endMonth = endDateParts[1];
        String endYear = endDateParts[2];

        postRequest = requestBuilder.getActivityRequestBuilder().postActivity(apiUser, OS, ActivityCode, Nivel, PERSONS, ESTIMATEDHOURS, startDay, startMonth, startYear, endDay, endMonth, endYear);
        response = requestSender.sendPostRequest(postRequest, host);
        Document xmlData = xmlParser.toDocument(response);

        return xmlData.getElementsByTagName("Message").item(0).getTextContent();
    }

    @SneakyThrows
    public String postLabor(ApiUser apiUser, String OS, String employee, String activityCode, String department, String laborDate, String typeOfTime, String laborStartHours, String laborEndHours) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        // Parse the start date into DAY, MONTH, and YEAR (DD-MM-YYYY)
        String[] laborDateParts = laborDate.split("-");
        String day = laborDateParts[0];
        String month = laborDateParts[1];
        String year = laborDateParts[2];

        String[] startHoursParts = laborStartHours.split(":");
        String startHours = startHoursParts[0];
        String startMinute = startHoursParts[1];

        String[] endHoursParts = laborEndHours.split(":");
        String endHours = endHoursParts[0];
        String endMinute = endHoursParts[1];


        postRequest = requestBuilder.getLaborBookingRequestBuilder().addLabor(apiUser,  OS,  employee,  activityCode, department,  year,  month,  day,  typeOfTime, startHours, startMinute, endHours, endMinute);
        response = requestSender.sendPostRequest(postRequest, host);
        Document xmlData = xmlParser.toDocument(response);

        return xmlData.getElementsByTagName("Message").item(0).getTextContent();
    }

}

