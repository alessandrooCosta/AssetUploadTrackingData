package com.assettec.api.integration.CLIENTES.Excel;

import com.assettec.api.integration.CLIENTES.Excel.Modulos.Data.WorkOrderData;
import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.requests.requestbuilders.common.XMLRequestHeader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExcelRequestBuilder {

    private XMLRequestHeader xmlRequestHeader;


    public String postWorkOrder(ApiUser apiUser, WorkOrderData workOrderData

//ULTIMO: COMPLETEDDATE
    ) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "        <MP0023_AddWorkOrder_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Add\" noun=\"WorkOrder\" version=\"001\" callname=\"AddWorkOrder\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0023_001\">\n" +
                "      <WorkOrder recordid=\"1\" is_completed=\"true\" is_cancelled=\"true\" has_department_security=\"has_1\" is_batchwo=\"true\" is_parentpmwo=\"true\" is_batchwo_update=\"true\" is_room_occupied=\"false\" xmlns=\"http://schemas.datastream.net/MP_entities/WorkOrder_001\">\n" +
                "        <WORKORDERID auto_generated=\"false\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <JOBNUM>" + workOrderData.getOS() + "</JOBNUM>\n" +
                "          <ORGANIZATIONID entity=\"User\">\n" +
                "            <ORGANIZATIONCODE>" + workOrderData.getWorkOrderOrganization() + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION>" + workOrderData.getWorkOrderDescription() + "</DESCRIPTION>\n" +
                "        </WORKORDERID>\n" +
                "        <STATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <STATUSCODE>" + workOrderData.getStatus() + "</STATUSCODE>\n" +
                "          <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "        </STATUS>\n" +
                "        <EQUIPMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <EQUIPMENTCODE>" + workOrderData.getEquipmentCode() + "</EQUIPMENTCODE>\n" +
                "          <ORGANIZATIONID entity=\"Organization\">\n" +
                "            <ORGANIZATIONCODE>" + workOrderData.getWorkOrderOrganization() + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION>DESCRIPTION2</DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "        </EQUIPMENTID>\n" +
                "        <TYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <TYPECODE>" + workOrderData.getType() + "</TYPECODE>\n" +
                "          <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "        </TYPE>\n" +
                "        <DEPARTMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <DEPARTMENTCODE>" + workOrderData.getDepartment() + "</DEPARTMENTCODE>\n" +
                "        </DEPARTMENTID>\n" +
                "     <CLASSID entity=\"ent1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <CLASSCODE>*</CLASSCODE>\n" +
                "          <ORGANIZATIONID entity=\"Class\">\n" +
                "            <ORGANIZATIONCODE>" + workOrderData.getWorkOrderOrganization() + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION>DESCRIPTION4</DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "        </CLASSID>\n" +
                "     <PROBLEMCODEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <PROBLEMCODE>" + workOrderData.getProblemCode() + "</PROBLEMCODE>\n" +
                "          <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "        </PROBLEMCODEID>\n" +
                "        <STANDARDWO xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <STDWOCODE>" + workOrderData.getStandardWork() + "</STDWOCODE>\n" +
                "          <ORGANIZATIONID entity=\"Department\">\n" +
                "            <ORGANIZATIONCODE>" + workOrderData.getWorkOrderOrganization() + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION>DESCRIPTION5</DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "        </STANDARDWO>\n" +
                "        <PRIORITY xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <PRIORITYCODE>" + workOrderData.getPriorityCode() + "</PRIORITYCODE>\n" +
                "          <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "        </PRIORITY>\n" +
                "        <LOCATIONID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <LOCATIONCODE>" + workOrderData.getLocationCode() + "</LOCATIONCODE>\n" +
                "          <ORGANIZATIONID entity=\"Personnel\">\n" +
                "            <ORGANIZATIONCODE>" + workOrderData.getWorkOrderOrganization() + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </LOCATIONID>\n" +
                "        <COSTCODEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <COSTCODE>" + workOrderData.getCostCode() + "</COSTCODE>\n" +
                "          <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "          <ORGANIZATIONID entity=\"OrganizationValidity\">\n" +
                "            <ORGANIZATIONCODE>" + workOrderData.getWorkOrderOrganization() + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION>DESCRIPTION7</DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "        </COSTCODEID>\n" +
                "    <PROJECTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <PROJECTCODE>" + workOrderData.getProjectCode() + "</PROJECTCODE>\n" +
                "          <ORGANIZATIONID entity=\"Equipment\">\n" +
                "            <ORGANIZATIONCODE>" + workOrderData.getWorkOrderOrganization() + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION>DESCRIPTION8</DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "        </PROJECTID>\n" +
                "    <TARGETVALUE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getTargetValue() + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">BRL</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </TARGETVALUE>\n" +
                "    <CRITICALITYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <CRITICALITY>" + workOrderData.getCriticality() + "</CRITICALITY>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </CRITICALITYID>\n" +
                "      <PROJBUD xmlns=\"http://schemas.datastream.net/MP_fields\"></PROJBUD>\n" +
                "     <PPM xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <PPMCODE>" + workOrderData.getPpmCode() + "</PPMCODE>\n" +
                "          <PPMREVISION>0</PPMREVISION>\n" +
                "          <ORGANIZATIONID entity=\"AssetEquipment\">\n" +
                "            <ORGANIZATIONCODE>" + workOrderData.getWorkOrderOrganization() + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION>DESCRIPTION9</DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "        </PPM>\n" +
                "        <SERVICEREQUESTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <SERVICEREQUESTCODE>" + workOrderData.getServiceRequestCode() + "</SERVICEREQUESTCODE>\n" +
                "          <ORGANIZATIONID entity=\"PositionEquipment\">\n" +
                "            <ORGANIZATIONCODE>" + workOrderData.getWorkOrderOrganization() + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION>DESCRIPTION10</DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "        </SERVICEREQUESTID>\n" +
                "    <SAFETY xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getSafety() + "</SAFETY>\n" +
                "        <WARRANTY xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getWarranty() + "</WARRANTY>\n" +
                "        <EQUIPMENTALIAS xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getEquipmentAlias() + "</EQUIPMENTALIAS>\n" +
                "        <SERIALNUMBER xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getSerialNumber() + "</SERIALNUMBER>\n" +
                "        <MODEL xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getModel() + "</MODEL>\n" +
                "        <REQUESTEDBY xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <PERSONCODE>" + workOrderData.getPersonCode() + "</PERSONCODE>\n" +
                "          <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "        </REQUESTEDBY>\n" +
                "        <REPORTED qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </REPORTED>\n" +
                "        <SCHEDGROUP xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getSchedGroup()  + "</SCHEDGROUP>\n" +
                "        <ASSIGNEDTO xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <PERSONCODE>" + workOrderData.getAssignedTo() + "</PERSONCODE>\n" +
                "          <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "        </ASSIGNEDTO>\n" +
                "    <TARGETDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getTargetDateYear() + "</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getTargetDateMonth() + "</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getTargetDateDay() + "</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </TARGETDATE>\n" +
                "        <SCHEDEND qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getSchedEndYear() + "</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getSchedEndMonth() + "</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getSchedEndDay() + "</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </SCHEDEND>\n" +
                "        <SHIFTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <SHIFTCODE>" + workOrderData.getShiftCode() + "</SHIFTCODE>\n" +
                "          <ORGANIZATIONID entity=\"PositionEquipmentDefault\">\n" +
                "            <ORGANIZATIONCODE>" + workOrderData.getWorkOrderOrganization() + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION>DESCRIPTION11</DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "        </SHIFTID>\n" +
                "    <PARENTWO auto_generated=\"true\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <JOBNUM></JOBNUM>\n" +
                "          <ORGANIZATIONID entity=\"SystemEquipment\">\n" +
                "            <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </PARENTWO>\n" +
                "    <CNNUMBER xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getCnnNumber() + "</CNNUMBER>\n" +
                "        <METERUNIT xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getMeterUnit() + "</METERUNIT>\n" +
                "        <LASTMETERREADING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getLastMeterReading() + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </LASTMETERREADING>\n" +
                "        <TRIGGEREVENT auto_generated=\"true\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <JOBNUM>" + workOrderData.getTriggerEvent() + "</JOBNUM>\n" +
                "          <ORGANIZATIONID entity=\"SystemEquipmentDefault\">\n" +
                "            <ORGANIZATIONCODE>" + workOrderData.getWorkOrderOrganization() + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </TRIGGEREVENT>\n" +
                "     <REQUESTEDSTART qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getRequestedStartYear() + "</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getRequestedStartMonth() + "</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getRequestedStartDay() + "</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </REQUESTEDSTART>\n" +
                "        <REQUESTEDEND qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getRequestedEndYear() + "</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getRequestedEndMonth() + "</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getRequestedEndDay() + "</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </REQUESTEDEND>\n" +
                "    <MSPROJECT xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getMsProject() + "</MSPROJECT>\n" +
                "        <SCHEDULINGSESSIONTYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <TYPECODE>" + workOrderData.getSchedulingSessionType() + "</TYPECODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </SCHEDULINGSESSIONTYPE>\n" +
                "    <DEPEND xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getDepend() + "</DEPEND>\n" +
                "        <CREATEDDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </CREATEDDATE>\n" +
                "        <OBJTYPE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getOBJtype() + "</OBJTYPE>\n" +
                "        <FAILURECODEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <FAILURECODE>" + workOrderData.getFailureCode() + "</FAILURECODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </FAILURECODEID>\n" +
                "    <CAUSECODEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <CAUSECODE>" + workOrderData.getCauseCode() + "</CAUSECODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </CAUSECODEID>\n" +
                "        <ACTIONCODEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <ACTIONCODE>" + workOrderData.getActionCode() + "</ACTIONCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </ACTIONCODEID>\n" +
                "        <STARTDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getStartDateYear() + "</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getStartDateMonth() + "</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getStartDateDay() + "</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </STARTDATE>\n" +
                "        <COMPLETEDDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getCompletedDateYear() + "</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getCompletedDateMonth() + "</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getCompletedDateDay() + "</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </COMPLETEDDATE>\n" +
                "    <DOWNTIMEHOURS qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getDowntimeHours() + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </DOWNTIMEHOURS>\n" +
                "        <DOWNTIMECOSTVALUE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getDownTimeCostValue() + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </DOWNTIMECOSTVALUE>\n" +
                "        <REOPENED xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getReopened() + "</REOPENED>\n" +
                "   <FREQUENCY xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getFrequency() + "</FREQUENCY>\n" +
                "        <EVTISSTYPE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getEVTisType() + "</EVTISSTYPE>\n" +
                "        <METERDUE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getMeterDue() + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </METERDUE>\n" +
                "        <METERDUE2 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getMeterDue2() + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </METERDUE2>\n" +
                "        <WORKPACKAGE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getWorkPackage() + "</WORKPACKAGE>\n" +
                "        <PERIODUOM xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <PERIODUOMCODE>" + workOrderData.getPeriodUOMCode() + "</PERIODUOMCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </PERIODUOM>\n" +
                "        <METERUOM2 xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <UOMCODE>" + workOrderData.getMeterUOMcode() + "</UOMCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </METERUOM2>\n" +
                "        <ROUTE xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <ROUTECODE>" + workOrderData.getRouteCode() + "</ROUTECODE>\n" +
                "          <ROUTEREVISION>" + workOrderData.getRouteRevision() + "</ROUTEREVISION>\n" +
                "          <ORGANIZATIONID entity=\"WorkRequest\">\n" +
                "            <ORGANIZATIONCODE>" + workOrderData.getWorkOrderOrganization() + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </ROUTE>\n" +
                "        <ROUTESTATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <STATUSCODE>" + workOrderData.getRouteStatus() +"</STATUSCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </ROUTESTATUS>\n" +
                "        <ROUTEPARENT xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getRouteParent() + "</ROUTEPARENT>\n" +
                "        <BILLABLE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getBillable() + "</BILLABLE>\n" +
                "        <PRINTED xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getPrinted() + "</PRINTED>\n" +
                "        <PRINT xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getPrint() + "</PRINT>\n" +
                "        <SOURCESYSTEM xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getSourceSystem() + "</SOURCESYSTEM>\n" +
                "        <SOURCECODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getSourceCode() + "</SOURCECODE>\n" +
                "        <ROUTEDFROM xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getRoutedFrom() + "</ROUTEDFROM>\n" +
                "        <ACDCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getAcdCode() + "</ACDCODE>\n" +
                "        <CLOSINGCOMMENT recordid=\"1\" is_html_comment=\"is_h1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <ENTITYCOMMENTID>\n" +
                "            <ENTITY>EVNT</ENTITY>\n" +
                "            <COMMENTTYPE entity=\"User\">\n" +
                "              <TYPECODE>*</TYPECODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </COMMENTTYPE>\n" +
                "            <ENTITYKEYCODE></ENTITYKEYCODE>\n" +
                "            <LANGUAGEID>\n" +
                "              <LANGUAGECODE>" + workOrderData.getLanguageCode() + "</LANGUAGECODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </LANGUAGEID>\n" +
                "            <LINENUM>1</LINENUM>\n" +
                "          </ENTITYCOMMENTID>\n" +
                "          <COMMENTTEXT>" + workOrderData.getComment() + "</COMMENTTEXT>\n" +
                "          <PRINT>" + workOrderData.getPrintComment() + "</PRINT>\n" +
                "          <CREATEDDATE qualifier=\"ACCOUNTING\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </CREATEDDATE>\n" +
                "          <UPDATEDDATE qualifier=\"ACCOUNTING\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UPDATEDDATE>\n" +
                "          <CREATEDBY>\n" +
                "            <USERCODE>" + workOrderData.getCreatedBy() + "</USERCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </CREATEDBY>\n" +
                "          <UPDATEDBY>\n" +
                "            <USERCODE>" + workOrderData.getUpdatedBy() + "</USERCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </UPDATEDBY>\n" +
                "          <CATEGORYID>\n" +
                "            <CATEGORYCODE>" + workOrderData.getCategoryCode() +  "</CATEGORYCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </CATEGORYID>\n" +
                "          <ORGANIZATIONID entity=\"Requisition\">\n" +
                "            <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <TRANSLATEDTEXT></TRANSLATEDTEXT>\n" +
                "        </CLOSINGCOMMENT>\n" +
                " <Activities>\n" +
                "          <Activity recordid=\"-1\" copyvmrsfields=\"false\" is_new=\"true\" has_transaction=\"has_1\" has_active_po=\"has_1\" has_active_req=\"has_1\" has_booked_hours=\"has_1\" is_ppm_act=\"is_p1\" is_warranty_claim=\"is_w1\" has_checklistitems_updated=\"false\" has_wo_act_detail_records=\"false\" has_wo_act_detail_records_including_qual=\"false\" task_has_enhanced_planning=\"false\" has_jobs_or_multiple_trades=\"false\" number_of_plan_labor_records=\"0\" xmlns=\"http://schemas.datastream.net/MP_entities/Activity_001\">\n" +
                "            <ACTIVITYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <WORKORDERID auto_generated=\"true\">\n" +
                "                <JOBNUM>" + workOrderData.getOSActivity() + "</JOBNUM>\n" +
                "                <ORGANIZATIONID entity=\"RequisitionDefault\">\n" +
                "                  <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "                  <DESCRIPTION></DESCRIPTION>\n" +
                "                </ORGANIZATIONID>\n" +
                "                <DESCRIPTION></DESCRIPTION>\n" +
                "              </WORKORDERID>\n" +
                "              <ACTIVITYCODE auto_generated=\"false\">" + workOrderData.getActivityCode() + "</ACTIVITYCODE>\n" +
                "              <ACTIVITYNOTE></ACTIVITYNOTE>\n" +
                "            </ACTIVITYID>\n" +
                "            <TRADEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <TRADECODE>*</TRADECODE>\n" +
                "              <ORGANIZATIONID entity=\"RequisitionLine\">\n" +
                "                <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "                <DESCRIPTION></DESCRIPTION>\n" +
                "              </ORGANIZATIONID>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </TRADEID>\n" +
                "            <MULTIPLETRADES xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getMultipleTrades() + "</MULTIPLETRADES>\n" +
                "            <PLANNINGLEVEL xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getPlanningLevel() + "</PLANNINGLEVEL>\n" +
                "            <DEPARTMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <DEPARTMENTCODE>" + workOrderData.getDepartmentActivity() + "</DEPARTMENTCODE>\n" +
                "              <ORGANIZATIONID entity=\"RequisitionLineDefault\">\n" +
                "                <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "                <DESCRIPTION></DESCRIPTION>\n" +
                "              </ORGANIZATIONID>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </DEPARTMENTID>\n" +
                "            <ESTIMATEDHOURS xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getEstimatedHours() + "</ESTIMATEDHOURS>\n" +
                "            <HOURSREMAINING xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getHoursRemaining() +"</HOURSREMAINING>\n" +
                "            <PERSONS xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getPersonsActivity() + "</PERSONS>\n" +
                "            <TOTALESTIMATEDHOURS qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getTotalEstimatedHoursActivity() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "            </TOTALESTIMATEDHOURS>\n" +
                "            <TOTALHOURSREMAINING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getTotalHoursRemainingActivity() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "            </TOTALHOURSREMAINING>\n" +
                "            <TOTALPEOPLEREQUIRED qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getTotalPeopleRequired() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "            </TOTALPEOPLEREQUIRED>\n" +
                "            <TASKSID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <TASKCODE>" + workOrderData.getTaskCode() + "</TASKCODE>\n" +
                "              <TASKREVISION>" + workOrderData.getTaskRevision() + "</TASKREVISION>\n" +
                "              <ORGANIZATIONID entity=\"WorkOrderDefault\">\n" +
                "                <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "                <DESCRIPTION></DESCRIPTION>\n" +
                "              </ORGANIZATIONID>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "              <TASKQUANTITY qualifier=\"ACCEPTED\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getTaskQuantity() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "              </TASKQUANTITY>\n" +
                "              <TASKUOM>\n" +
                "                <UOMCODE>" + workOrderData.getTaskUOM() + "</UOMCODE>\n" +
                "                <DESCRIPTION></DESCRIPTION>\n" +
                "              </TASKUOM>\n" +
                "            </TASKSID>\n" +
                "            <COMPLETED xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getCompleted() + "</COMPLETED>\n" +
                "            <PERCENTCOMPLETED xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getPercentCompleted() + "</PERCENTCOMPLETED>\n" +
                "            <ACTIVITYSTARTDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getActivityStartYear() + "</YEAR>\n" +
                "              <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getActivityStartMonth() + "</MONTH>\n" +
                "              <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getActivityStartDay() + "</DAY>\n" +
                "              <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "              <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "              <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "              <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "              <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "            </ACTIVITYSTARTDATE>\n" +
                "            <ACTIVITYENDDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getActivityEndYear() + "</YEAR>\n" +
                "              <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getActivityEndMonth() + "</MONTH>\n" +
                "              <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getActivityEndDay() + "</DAY>\n" +
                "              <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "              <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "              <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "              <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "              <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "            </ACTIVITYENDDATE>\n" +
                "            <DATELASTSCHEDULED qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getDateLastScheduledYear() + "</YEAR>\n" +
                "              <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getDateLastScheduledMonth() + "</MONTH>\n" +
                "              <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" +  workOrderData.getDateLastScheduledDay()  + "</DAY>\n" +
                "              <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "              <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "              <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "              <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "              <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "            </DATELASTSCHEDULED>\n" +
                "            <SCHEDULEDHOURS xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getScheduledHours() + "</SCHEDULEDHOURS>\n" +
                "            <HIREDLABOR xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getHiredLabor() + "</HIREDLABOR>\n" +
                "            <LABORTYPE xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <LABORTYPECODE>" + workOrderData.getLaborTypeCode() + "</LABORTYPECODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </LABORTYPE>\n" +
                "            <SUPPLIERID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <SUPPLIERCODE>" + workOrderData.getSupplierCode() + "</SUPPLIERCODE>\n" +
                "              <ORGANIZATIONID entity=\"WorkOrder\">\n" +
                "                <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "                <DESCRIPTION></DESCRIPTION>\n" +
                "              </ORGANIZATIONID>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </SUPPLIERID>\n" +
                "            <NORMALHOURSWORKED qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getNormalHoursWorked() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</CURRENCY>\n" +
                "              <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">D</DRCR>\n" +
                "            </NORMALHOURSWORKED>\n" +
                "            <OVERTIMEHOURSWORKED qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getOvertimeHoursWorked() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</CURRENCY>\n" +
                "              <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">D</DRCR>\n" +
                "            </OVERTIMEHOURSWORKED>\n" +
                "            <SOURCESYSTEM xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getSourceSystemActivity() + "</SOURCESYSTEM>\n" +
                "            <SOURCECODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getSourceCodeActivity() + "</SOURCECODE>\n" +
                "            <REASONFORREPAIR xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getReasonForRepair() + "</REASONFORREPAIR>\n" +
                "            <WORKACCOMPLISHED xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getWorkAccomplished() + "</WORKACCOMPLISHED>\n" +
                "            <TECHNICIANPARTFAILURE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getTechnicianPartFailure() + "</TECHNICIANPARTFAILURE>\n" +
                "            <VMRSCODE xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <SYSTEMLEVELID>\n" +
                "                <SYSTEMLEVELCODE>SL01</SYSTEMLEVELCODE>\n" +
                "                <DESCRIPTION></DESCRIPTION>\n" +
                "              </SYSTEMLEVELID>\n" +
                "            </VMRSCODE>\n" +
                "            <MANUFACTURERID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <MANUFACTURERCODE>" + workOrderData.getManufacturerCode() + "</MANUFACTURERCODE>\n" +
                "              <ORGANIZATIONID entity=\"Part\">\n" +
                "                <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "                <DESCRIPTION></DESCRIPTION>\n" +
                "              </ORGANIZATIONID>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </MANUFACTURERID>\n" +
                "            <WARRANTY xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getWarrantyActivity() + "</WARRANTY>\n" +
                "            <ACTIVITYCOMMENT xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getActivityComment() + "</ACTIVITYCOMMENT>\n" +
                "            <RELATEDWORKORDERID auto_generated=\"true\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <JOBNUM>" + workOrderData.getRelatedWorkOrderId() + "</JOBNUM>\n" +
                "              <ORGANIZATIONID entity=\"PartDefault\">\n" +
                "                <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "                <DESCRIPTION></DESCRIPTION>\n" +
                "              </ORGANIZATIONID>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </RELATEDWORKORDERID>\n" +
                "            <DEFERMAINTENANCE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getDefermaintenance() + "</DEFERMAINTENANCE>\n" +
                "            <DEFERACTDIRECTMATS xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getDeferactDirectmats() + "</DEFERACTDIRECTMATS>\n" +
                "            <ORIGINALWORKORDERACTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <ACTIVITYID>\n" +
                "                <WORKORDERID auto_generated=\"false\">\n" +
                "                  <JOBNUM>" + workOrderData.getOSActivity() + "</JOBNUM>\n" +
                "                  <ORGANIZATIONID entity=\"PurchaseOrder\">\n" +
                "                    <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "                    <DESCRIPTION></DESCRIPTION>\n" +
                "                  </ORGANIZATIONID>\n" +
                "                  <DESCRIPTION></DESCRIPTION>\n" +
                "                </WORKORDERID>\n" +
                "                <ACTIVITYCODE auto_generated=\"auto1\">" + workOrderData.getActivityCode() + "</ACTIVITYCODE>\n" +
                "                <ACTIVITYNOTE></ACTIVITYNOTE>\n" +
                "              </ACTIVITYID>\n" +
                "            </ORIGINALWORKORDERACTID>\n" +
                "            <PARTLOCATIONCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getPartLocationCode() + "</PARTLOCATIONCODE>\n" +
                "            <DBSESSIONID qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getdBsession() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "            </DBSESSIONID>\n" +
                "            <SCHEDULINGSESSIONTYPE entity=\"Organization\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <TYPECODE>" + workOrderData.getSchedulingSessionType2() + "</TYPECODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </SCHEDULINGSESSIONTYPE>\n" +
                "            <WorkOrderEquipments>\n" +
                "              <WorkOrderEquipment>\n" +
                "                <EQUIPMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                  <EQUIPMENTCODE>" + workOrderData.getEquipmentCodeActivity() + "</EQUIPMENTCODE>\n" +
                "                  <ORGANIZATIONID entity=\"AssetEquipmentDefault\">\n" +
                "                    <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "                    <DESCRIPTION></DESCRIPTION>\n" +
                "                  </ORGANIZATIONID>\n" +
                "                  <DESCRIPTION></DESCRIPTION>\n" +
                "                </EQUIPMENTID>\n" +
                "                <RELATEDWORKORDERACTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                  <ACTIVITYID>\n" +
                "                    <WORKORDERID auto_generated=\"true\">\n" +
                "                      <JOBNUM>" + workOrderData.getActivityRelatedOS() + "</JOBNUM>\n" +
                "                      <ORGANIZATIONID entity=\"BookedHours\">\n" +
                "                        <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "                        <DESCRIPTION></DESCRIPTION>\n" +
                "                      </ORGANIZATIONID>\n" +
                "                      <DESCRIPTION></DESCRIPTION>\n" +
                "                    </WORKORDERID>\n" +
                "                    <ACTIVITYCODE auto_generated=\"auto2\">" + workOrderData.getActivityCode2() + "</ACTIVITYCODE>\n" +
                "                    <ACTIVITYNOTE></ACTIVITYNOTE>\n" +
                "                  </ACTIVITYID>\n" +
                "                </RELATEDWORKORDERACTID>\n" +
                "              </WorkOrderEquipment>\n" +
                "            </WorkOrderEquipments>\n" +
                "                   <UserDefinedFields>\n" +
                "          <UDFCHAR01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR01() + "</UDFCHAR01>\n" +
                "          <UDFCHAR02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR02() + "</UDFCHAR02>\n" +
                "          <UDFCHAR03 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR03() + "</UDFCHAR03>\n" +
                "          <UDFCHAR04 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR04() + "</UDFCHAR04>\n" +
                "          <UDFCHAR05 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR05() + "</UDFCHAR05>\n" +
                "          <UDFCHAR06 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR06() + "</UDFCHAR06>\n" +
                "          <UDFCHAR07 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR07() + "</UDFCHAR07>\n" +
                "          <UDFCHAR08 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR08() + "</UDFCHAR08>\n" +
                "          <UDFCHAR09 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR09() + "</UDFCHAR09>\n" +
                "          <UDFCHAR10 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR10() + "</UDFCHAR10>\n" +
                "          <UDFCHAR11 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR11() + "</UDFCHAR11>\n" +
                "          <UDFCHAR12 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR12() + "</UDFCHAR12>\n" +
                "          <UDFCHAR13 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR13() + "</UDFCHAR13>\n" +
                "          <UDFCHAR14 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR14() + "</UDFCHAR14>\n" +
                "          <UDFCHAR15 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR15() + "</UDFCHAR15>\n" +
                "          <UDFCHAR16 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR16() + "</UDFCHAR16>\n" +
                "          <UDFCHAR17 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR17() + "</UDFCHAR17>\n" +
                "          <UDFCHAR18 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR18() + "</UDFCHAR18>\n" +
                "          <UDFCHAR19 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR19() + "</UDFCHAR19>\n" +
                "          <UDFCHAR20 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR20() + "</UDFCHAR20>\n" +
                "          <UDFCHAR21 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR21() + "</UDFCHAR21>\n" +
                "          <UDFCHAR22 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR22() + "</UDFCHAR22>\n" +
                "          <UDFCHAR23 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR23() + "</UDFCHAR23>\n" +
                "          <UDFCHAR24 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR24() + "</UDFCHAR24>\n" +
                "          <UDFCHAR25 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR25() + "</UDFCHAR25>\n" +
                "          <UDFCHAR26 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR26() + "</UDFCHAR26>\n" +
                "          <UDFCHAR27 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR27() + "</UDFCHAR27>\n" +
                "          <UDFCHAR28 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR28() + "</UDFCHAR28>\n" +
                "          <UDFCHAR29 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR29() + "</UDFCHAR29>\n" +
                "          <UDFCHAR30 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR30() + "</UDFCHAR30>\n" +
                "          <UDFNUM01 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFNum01() + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM01>\n" +
                "          <UDFNUM02 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFNum02() + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM02>\n" +
                "          <UDFNUM03 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFNum03() + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM03>\n" +
                "          <UDFNUM04 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFNum04() + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM04>\n" +
                "          <UDFNUM05 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFNum05() + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM05>\n" +
                "          <UDFDATE01 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateYear01() + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateMonth01() + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateDay01() + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE01>\n" +
                "          <UDFDATE02 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateYear02() + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateMonth02() + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateDay02()  + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE02>\n" +
                "          <UDFDATE03 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" +  workOrderData.getUDFDateYear03() + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateMonth03() + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateDay03() + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE03>\n" +
                "          <UDFDATE04 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateYear04() + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateMonth04() + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateDay04() + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE04>\n" +
                "          <UDFDATE05 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateYear05() + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateMonth05() + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateDay05() + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE05>\n" +
                "          <UDFCHKBOX01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUdfCHKBox01() + "</UDFCHKBOX01>\n" +
                "          <UDFCHKBOX02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUdfCHKBox02() + "</UDFCHKBOX02>\n" +
                "          <UDFCHKBOX03 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUdfCHKBox03() + "</UDFCHKBOX03>\n" +
                "          <UDFCHKBOX04 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUdfCHKBox04() + "</UDFCHKBOX04>\n" +
                "          <UDFCHKBOX05 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUdfCHKBox05() + "</UDFCHKBOX05>\n" +
                "        </UserDefinedFields>\n" +
                "            <LINEARREFUOM xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getLinearREFuom1() + "</LINEARREFUOM>\n" +
                "            <HEADEREQUIPMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <EQUIPMENTCODE>" + workOrderData.getHeaderEquipment() + "</EQUIPMENTCODE>\n" +
                "              <ORGANIZATIONID entity=\"Store\">\n" +
                "                <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "                <DESCRIPTION></DESCRIPTION>\n" +
                "              </ORGANIZATIONID>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </HEADEREQUIPMENTID>\n" +
                "            <TOPPARENTACTIVITYCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getTopParentActivity() + "</TOPPARENTACTIVITYCODE>\n" +
                "            <PARENTACTIVITYCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getParentActivity() + "</PARENTACTIVITYCODE>\n" +
                "            <JOBSEQUENCE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getJobSequence() + "</JOBSEQUENCE>\n" +
                "            <OLDJOBSEQUENCE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getOldJobSequence() + "</OLDJOBSEQUENCE>\n" +
                "            <ISWORKORDERJOB xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getIsWorkOrderJOB() + "</ISWORKORDERJOB>\n" +
                "            <REUSABLE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getReusable() + "</REUSABLE>\n" +
                "            <CURRENCYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <CURRENCYCODE>" + workOrderData.getCurrencyCode() + "</CURRENCYCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </CURRENCYID>\n" +
                "            <ESTIMATEDLABORCOST qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getEstimatedLaborCost() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</CURRENCY>\n" +
                "              <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">D</DRCR>\n" +
                "            </ESTIMATEDLABORCOST>\n" +
                "            <ESTIMATEDMATERIALCOST qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getEstimatedMaterialCost() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</CURRENCY>\n" +
                "              <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">D</DRCR>\n" +
                "            </ESTIMATEDMATERIALCOST>\n" +
                "            <ESTIMATEDMISCELLANEOUSCOST qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getEstimatedMiscellaneOusCOST() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</CURRENCY>\n" +
                "              <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">D</DRCR>\n" +
                "            </ESTIMATEDMISCELLANEOUSCOST>\n" +
                "            <ESTIMATEDTOTALCOST qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getEstimatedTotalCost() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</CURRENCY>\n" +
                "              <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">D</DRCR>\n" +
                "            </ESTIMATEDTOTALCOST>\n" +
                "            <ASSIGNMENTSTATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <STATUSCODE>" + workOrderData.getAssignmentStatus() + "</STATUSCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ASSIGNMENTSTATUS>\n" +
                "            <PREFERREDSUPPLIER xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "              <SUPPLIERCODE>" + workOrderData.getPreferredSupplier() + "</SUPPLIERCODE>\n" +
                "              <ORGANIZATIONID entity=\"StoreDefault\">\n" +
                "                <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "                <DESCRIPTION></DESCRIPTION>\n" +
                "              </ORGANIZATIONID>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </PREFERREDSUPPLIER>\n" +
                "          </Activity>\n" +
                "        </Activities>\n" +
                "       <CALLERNAME xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getCallerName() + "</CALLERNAME>\n" +
                "        <CUSTOMERID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <CUSTOMERCODE>" + workOrderData.getCustomerCode() + "</CUSTOMERCODE>\n" +
                "          <ORGANIZATIONID entity=\"Activity\">\n" +
                "            <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "        </CUSTOMERID>\n" +
                "        <LEVEL1 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getLEVEL1() + "</LEVEL1>\n" +
                "        <REJECTIONREASON xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getRejectionReason() + "</REJECTIONREASON>\n" +
                "        <LINEARREFERENCEEVENT xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <FROMPOINT qualifier=\"ACTDUR\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getFromPoint() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "          </FROMPOINT>\n" +
                "          <FROMREFDESC>" + workOrderData.getFromRefDesc() + "</FROMREFDESC>\n" +
                "          <FROMGEOREF>" + workOrderData.getFromGeoREF() + "</FROMGEOREF>\n" +
                "          <TOPOINT qualifier=\"ACTDUR\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getToPoint() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "          </TOPOINT>\n" +
                "          <TOREFDESC>" + workOrderData.getToREFdesc() + "</TOREFDESC>\n" +
                "          <TOGEOREF>" + workOrderData.getToGEOref() + "</TOGEOREF>\n" +
                "          <FROMREFERENCEID>\n" +
                "            <LINEARREFERENCECODE>" + workOrderData.getLinearReferenceCode() + "</LINEARREFERENCECODE>\n" +
                "            <DESCRIPTION>DESCRIPTION3</DESCRIPTION>\n" +
                "          </FROMREFERENCEID>\n" +
                "          <FROMOFFSET qualifier=\"ACTHRS\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getFromOffSet() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "          </FROMOFFSET>\n" +
                "          <FROMOFFSETPERCENTAGE qualifier=\"ACTDUR\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getFromOFFsetPercentage() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "          </FROMOFFSETPERCENTAGE>\n" +
                "          <FROMOFFSETDIRECTION>\n" +
                "            <UCODEENTITY>" + workOrderData.getUcodeEntity() + "</UCODEENTITY>\n" +
                "            <UCODE>" + workOrderData.getUcode() + "</UCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </FROMOFFSETDIRECTION>\n" +
                "          <FROMCOORDINATE>\n" +
                "            <X qualifier=\"ACTHRS\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getX() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "            </X>\n" +
                "            <Y qualifier=\"ACTHRS\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getY() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "            </Y>\n" +
                "          </FROMCOORDINATE>\n" +
                "          <FROMLATITUDE qualifier=\"ACTDUR\">\n" +
                "                <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getFromLatitude() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "          </FROMLATITUDE>\n" +
                "          <FROMLONGITUDE qualifier=\"ACTDUR\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getFromLongitude() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "          </FROMLONGITUDE>\n" +
                "          <FROMHORIZONTALVERTICALDETAILS>\n" +
                "            <RELATIONSHIPTYPEID entity=\"Class\">\n" +
                "              <TYPECODE>" + workOrderData.getRelationShipType() + "</TYPECODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </RELATIONSHIPTYPEID>\n" +
                "            <HORIZONTALOFFSET qualifier=\"ACTHRS\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getHorizontalOffSet() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "            </HORIZONTALOFFSET>\n" +
                "            <HORIZONTALOFFSETUOM>\n" +
                "              <LINEARREFUOM>" + workOrderData.getLinearRefUOM() + "</LINEARREFUOM>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </HORIZONTALOFFSETUOM>\n" +
                "            <HORIZONTALOFFSETTYPEID entity=\"Group\">\n" +
                "              <TYPECODE>" + workOrderData.getHorizontalOffSetType() + "</TYPECODE>\n" +
                "              <DESCRIPTION>DESCRIPTION3</DESCRIPTION>\n" +
                "            </HORIZONTALOFFSETTYPEID>\n" +
                "            <VERTICALOFFSET qualifier=\"ACTHRS\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getVerticalOffSet() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "            </VERTICALOFFSET>\n" +
                "            <VERTICALOFFSETUOM>\n" +
                "              <LINEARREFUOM>" + workOrderData.getLinearREF() + "</LINEARREFUOM>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </VERTICALOFFSETUOM>\n" +
                "            <VERTICALOFFSETTYPEID entity=\"Group\">\n" +
                "              <TYPECODE>" + workOrderData.getVerticalOffSetty() + "</TYPECODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </VERTICALOFFSETTYPEID>\n" +
                "          </FROMHORIZONTALVERTICALDETAILS>\n" +
                "          <TOREFERENCEID>\n" +
                "            <LINEARREFERENCECODE>" + workOrderData.getLinearReferenceCode2() + "</LINEARREFERENCECODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </TOREFERENCEID>\n" +
                "          <TOOFFSET qualifier=\"ACTHRS\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getToOffSet() + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "          </TOOFFSET>\n" +
                "          <TOOFFSETPERCENTAGE qualifier=\"ACTDUR\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getToOffSetPecentage() + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "          </TOOFFSETPERCENTAGE>\n" +
                "          <TOOFFSETDIRECTION>\n" +
                "            <UCODEENTITY>" + workOrderData.getUcodeEntity2() + "</UCODEENTITY>\n" +
                "            <UCODE>" + workOrderData.getUcode2() + "</UCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </TOOFFSETDIRECTION>\n" +
                "          <TOCOORDINATE>\n" +
                "            <X qualifier=\"ALLOCATED\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getX2() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "            </X>\n" +
                "            <Y qualifier=\"ALLOCATED\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getY2() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">0</NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "            </Y>\n" +
                "          </TOCOORDINATE>\n" +
                "          <TOLATITUDE qualifier=\"ACTDUR\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getToLatitude() + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "          </TOLATITUDE>\n" +
                "          <TOLONGITUDE qualifier=\"ACTDUR\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getToLongitude() + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "          </TOLONGITUDE>\n" +
                "          <TOHORIZONTALVERTICALDETAILS>\n" +
                "            <RELATIONSHIPTYPEID entity=\"Department\">\n" +
                "              <TYPECODE>" + workOrderData.getRelationShipID() + "</TYPECODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </RELATIONSHIPTYPEID>\n" +
                "            <HORIZONTALOFFSET qualifier=\"ALLOCATED\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getHorizontal() + "</VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "            </HORIZONTALOFFSET>\n" +
                "            <HORIZONTALOFFSETUOM>\n" +
                "              <LINEARREFUOM>" + workOrderData.getLinearUOM() + "</LINEARREFUOM>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </HORIZONTALOFFSETUOM>\n" +
                "            <HORIZONTALOFFSETTYPEID entity=\"Class\">\n" +
                "              <TYPECODE></TYPECODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </HORIZONTALOFFSETTYPEID>\n" +
                "            <VERTICALOFFSET qualifier=\"ALLOCATED\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "            </VERTICALOFFSET>\n" +
                "            <VERTICALOFFSETUOM>\n" +
                "              <LINEARREFUOM></LINEARREFUOM>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </VERTICALOFFSETUOM>\n" +
                "            <VERTICALOFFSETTYPEID entity=\"Class\">\n" +
                "              <TYPECODE></TYPECODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </VERTICALOFFSETTYPEID>\n" +
                "          </TOHORIZONTALVERTICALDETAILS>\n" +
                "          <RELATIONSHIPTYPEID entity=\"Personnel\">\n" +
                "            <TYPECODE></TYPECODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </RELATIONSHIPTYPEID>\n" +
                "          <RELATEDLINEARREFERENCEDETAILS>\n" +
                "            <FROMREFERENCEID>\n" +
                "              <LINEARREFERENCECODE></LINEARREFERENCECODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </FROMREFERENCEID>\n" +
                "            <FROMOFFSET qualifier=\"ALLOCATED\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "            </FROMOFFSET>\n" +
                "            <FROMOFFSETDIRECTION>\n" +
                "              <UCODEENTITY></UCODEENTITY>\n" +
                "              <UCODE></UCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </FROMOFFSETDIRECTION>\n" +
                "            <FROMREFERENCETYPE entity=\"Organization\">\n" +
                "              <TYPECODE></TYPECODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </FROMREFERENCETYPE>\n" +
                "            <TOREFERENCEID>\n" +
                "              <LINEARREFERENCECODE></LINEARREFERENCECODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </TOREFERENCEID>\n" +
                "            <TOOFFSET qualifier=\"ALLOCATED\">\n" +
                "              <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "              <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "              <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\"></SIGN>\n" +
                "              <UOM xmlns=\"http://www.openapplications.org/oagis_fields\"></UOM>\n" +
                "            </TOOFFSET>\n" +
                "            <TOOFFSETDIRECTION>\n" +
                "              <UCODEENTITY></UCODEENTITY>\n" +
                "              <UCODE></UCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </TOOFFSETDIRECTION>\n" +
                "            <TOREFERENCETYPE entity=\"Organization\">\n" +
                "              <TYPECODE></TYPECODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </TOREFERENCETYPE>\n" +
                "          </RELATEDLINEARREFERENCEDETAILS>\n" +
                "        </LINEARREFERENCEEVENT>\n" +
                "        <INSPECTIONDIRECTIONCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getInspectionDirection() + "</INSPECTIONDIRECTIONCODE>\n" +
                "        <FLOWCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getFlowCode() + "</FLOWCODE>\n" +
                "        <MULTIEQUIP xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getMultiEquip() + "</MULTIEQUIP>\n" +
                "        <CUSTOMERCONTRACTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <CUSTOMERCONTRACTCODE>" + workOrderData.getCustomerContract() + "</CUSTOMERCONTRACTCODE>\n" +
                "          <ORGANIZATIONID entity=\"ActivityDefault\">\n" +
                "            <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </CUSTOMERCONTRACTID>\n" +
                "        <DUEDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">2050</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">12</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">30</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </DUEDATE>\n" +
                "       <CCTRSPCVALIDATION xmlns=\"http://schemas.datastream.net/MP_fields\">S</CCTRSPCVALIDATION>\n" +
                "        <CallCenterDetail>\n" +
                "          <PERMANENTFIXPROMISEDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </PERMANENTFIXPROMISEDATE>\n" +
                "          <TEMPFIXPROMISEDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </TEMPFIXPROMISEDATE>\n" +
                "          <TEMPFIXDATECOMPLETED qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </TEMPFIXDATECOMPLETED>\n" +
                "          <WORKADDRESS xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getWorkAddress() + "</WORKADDRESS>\n" +
                "          <CASEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <CASECODE>" + workOrderData.getCaseCode() + "</CASECODE>\n" +
                "            <ORGANIZATIONID entity=\"BinStock\">\n" +
                "              <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </CASEID>\n" +
                "          <CASETYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <TYPECODE>" + workOrderData.getCaseType() + "</TYPECODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </CASETYPE>\n" +
                "          <DUPLICATECASEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <CASECODE>" + workOrderData.getDuplicateCase() + "</CASECODE>\n" +
                "            <ORGANIZATIONID entity=\"LocationDefault\">\n" +
                "              <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </DUPLICATECASEID>\n" +
                "          <CONTACTRECORDID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <CONTACTRECORDCODE>" + workOrderData.getContactRecord() + "</CONTACTRECORDCODE>\n" +
                "            <ORGANIZATIONID entity=\"EquipmentHierarchy\">\n" +
                "              <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </CONTACTRECORDID>\n" +
                "          <SERVICEREQUESTSTATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <STATUSCODE>" + workOrderData.getServiceRequestStatus() + "</STATUSCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </SERVICEREQUESTSTATUS>\n" +
                "          <ORIGINATINGCASEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <CASECODE>" + workOrderData.getOriginatingCase() + "</CASECODE>\n" +
                "            <ORGANIZATIONID entity=\"PositionHierarchy\">\n" +
                "              <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORIGINATINGCASEID>\n" +
                "          <ORIGINATINGCASETASKID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <CASETASKCODE>" + workOrderData.getOriginationTaskCode() + "</CASETASKCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORIGINATINGCASETASKID>\n" +
                "        </CallCenterDetail>\n" +
                "        <UserDefinedFields>\n" +
                "          <UDFCHAR01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR01() + "</UDFCHAR01>\n" +
                "          <UDFCHAR02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR02() + "</UDFCHAR02>\n" +
                "          <UDFCHAR03 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR03() + "</UDFCHAR03>\n" +
                "          <UDFCHAR04 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR04() + "</UDFCHAR04>\n" +
                "          <UDFCHAR05 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR05() + "</UDFCHAR05>\n" +
                "          <UDFCHAR06 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR06() + "</UDFCHAR06>\n" +
                "          <UDFCHAR07 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR07() + "</UDFCHAR07>\n" +
                "          <UDFCHAR08 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR08() + "</UDFCHAR08>\n" +
                "          <UDFCHAR09 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR09() + "</UDFCHAR09>\n" +
                "          <UDFCHAR10 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR10() + "</UDFCHAR10>\n" +
                "          <UDFCHAR11 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR11() + "</UDFCHAR11>\n" +
                "          <UDFCHAR12 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR12() + "</UDFCHAR12>\n" +
                "          <UDFCHAR13 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR13() + "</UDFCHAR13>\n" +
                "          <UDFCHAR14 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR14() + "</UDFCHAR14>\n" +
                "          <UDFCHAR15 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR15() + "</UDFCHAR15>\n" +
                "          <UDFCHAR16 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR16() + "</UDFCHAR16>\n" +
                "          <UDFCHAR17 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR17() + "</UDFCHAR17>\n" +
                "          <UDFCHAR18 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR18() + "</UDFCHAR18>\n" +
                "          <UDFCHAR19 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR19() + "</UDFCHAR19>\n" +
                "          <UDFCHAR20 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR20() + "</UDFCHAR20>\n" +
                "          <UDFCHAR21 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR21() + "</UDFCHAR21>\n" +
                "          <UDFCHAR22 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR22() + "</UDFCHAR22>\n" +
                "          <UDFCHAR23 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR23() + "</UDFCHAR23>\n" +
                "          <UDFCHAR24 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR24() + "</UDFCHAR24>\n" +
                "          <UDFCHAR25 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR25() + "</UDFCHAR25>\n" +
                "          <UDFCHAR26 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR26() + "</UDFCHAR26>\n" +
                "          <UDFCHAR27 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR27() + "</UDFCHAR27>\n" +
                "          <UDFCHAR28 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR28() + "</UDFCHAR28>\n" +
                "          <UDFCHAR29 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR29() + "</UDFCHAR29>\n" +
                "          <UDFCHAR30 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUDFCHAR30() + "</UDFCHAR30>\n" +
                "          <UDFNUM01 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFNum01() + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM01>\n" +
                "          <UDFNUM02 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFNum02() + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM02>\n" +
                "          <UDFNUM03 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFNum03() + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM03>\n" +
                "          <UDFNUM04 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFNum04() + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM04>\n" +
                "          <UDFNUM05 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFNum05() + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM05>\n" +
                "          <UDFDATE01 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateYear01() + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateMonth01() + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateDay01() + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE01>\n" +
                "          <UDFDATE02 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateYear02() + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateMonth02() + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateDay02()  + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE02>\n" +
                "          <UDFDATE03 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" +  workOrderData.getUDFDateYear03() + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateMonth03() + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateDay03() + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE03>\n" +
                "          <UDFDATE04 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateYear04() + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateMonth04() + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateDay04() + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE04>\n" +
                "          <UDFDATE05 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateYear05() + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateMonth05() + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getUDFDateDay05() + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE05>\n" +
                "          <UDFCHKBOX01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUdfCHKBox01() + "</UDFCHKBOX01>\n" +
                "          <UDFCHKBOX02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUdfCHKBox02() + "</UDFCHKBOX02>\n" +
                "          <UDFCHKBOX03 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUdfCHKBox03() + "</UDFCHKBOX03>\n" +
                "          <UDFCHKBOX04 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUdfCHKBox04() + "</UDFCHKBOX04>\n" +
                "          <UDFCHKBOX05 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getUdfCHKBox05() + "</UDFCHKBOX05>\n" +
                "        </UserDefinedFields>\n" +
                "       <ALERTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <ALERTCODE>" + workOrderData.getAlertCode() + "</ALERTCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </ALERTID>\n" +
                "        <ProductionDetails>\n" +
                "          <PRODUCTIONREQUESTCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getProductionRequestCode() + "</PRODUCTIONREQUESTCODE>\n" +
                "          <PRODUCTIONORDER xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getProductionOrder() + "</PRODUCTIONORDER>\n" +
                "          <PRODUCTIONPRIORITY xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getProductionPriority() + "</PRODUCTIONPRIORITY>\n" +
                "          <PRODUCTIONPRIORITYDESC xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getProductionPriorityDesc() + "</PRODUCTIONPRIORITYDESC>\n" +
                "          <ACCOUNTINGENTITY xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getAccountingEntity() + "</ACCOUNTINGENTITY>\n" +
                "        </ProductionDetails>\n" +
                "        <CAMPAIGNEVENTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <CAMPAIGNID>\n" +
                "            <CAMPAIGNCODE>" + workOrderData.getCampaignCode() + "</CAMPAIGNCODE>\n" +
                "            <ORGANIZATIONID entity=\"SystemHierarchy\">\n" +
                "              <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </CAMPAIGNID>\n" +
                "          <CAMPAIGNEVENT>1</CAMPAIGNEVENT>\n" +
                "        </CAMPAIGNEVENTID>\n" +
                "        <SURVEY xmlns=\"http://schemas.datastream.net/MP_fields\">false</SURVEY>\n" +
                "        <CAMPAIGNSTATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <STATUSCODE>" + workOrderData.getCampaignStatus() + "</STATUSCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </CAMPAIGNSTATUS>\n" +
                "        <MAINTENANCEPATTERNID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <MAINTENANCEPATTERNCODE>" + workOrderData.getMaintenancePatternCode() + "</MAINTENANCEPATTERNCODE>\n" +
                "          <MAINTENANCEPATTERNREVISION>0</MAINTENANCEPATTERNREVISION>\n" +
                "          <ORGANIZATIONID entity=\"AssetHierarchy\">\n" +
                "            <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </MAINTENANCEPATTERNID>\n" +
                "        <SEQUENCE xmlns=\"http://schemas.datastream.net/MP_fields\">1</SEQUENCE>\n" +
                "        <ESignatureDetail>\n" +
                "          <ESIGNER xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <USERCODE></USERCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ESIGNER>\n" +
                "          <ESIGNATUREDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </ESIGNATUREDATE>\n" +
                "          <SIGNATURETYPE xmlns=\"http://schemas.datastream.net/MP_fields\"></SIGNATURETYPE>\n" +
                "          <ERECORDCODE xmlns=\"http://schemas.datastream.net/MP_fields\"></ERECORDCODE>\n" +
                "        </ESignatureDetail>\n" +
                "        <SAFETYREVIEWEDBY xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <USERCODE>" + workOrderData.getSafetyReviewedBy() + "</USERCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </SAFETYREVIEWEDBY>\n" +
                "        <PERMITREVIEWEDBY xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <USERCODE>" + workOrderData.getPermitReviewedBy() + "</USERCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </PERMITREVIEWEDBY>\n" +
                "        <ORIGINALWORKORDERACTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <ACTIVITYID>\n" +
                "            <WORKORDERID auto_generated=\"false\">\n" +
                "              <JOBNUM>" + workOrderData.getOriginalWorkOrderACT() + "</JOBNUM>\n" +
                "              <ORGANIZATIONID entity=\"AssetEquipmentByProfile\">\n" +
                "                <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "                <DESCRIPTION></DESCRIPTION>\n" +
                "              </ORGANIZATIONID>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </WORKORDERID>\n" +
                "            <ACTIVITYCODE auto_generated=\"auto3\">0</ACTIVITYCODE>\n" +
                "            <ACTIVITYNOTE></ACTIVITYNOTE>\n" +
                "          </ACTIVITYID>\n" +
                "        </ORIGINALWORKORDERACTID>\n" +
                "        <JOBSEQUENCE xmlns=\"http://schemas.datastream.net/MP_fields\">1</JOBSEQUENCE>\n" +
                "        <ACTIVITYNOTE xmlns=\"http://schemas.datastream.net/MP_fields\"></ACTIVITYNOTE>\n" +
                "        <CALCULATEDPRIORITY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "        </CALCULATEDPRIORITY>\n" +
                "        <PRESERVECALCPRIORITY xmlns=\"http://schemas.datastream.net/MP_fields\">false</PRESERVECALCPRIORITY>\n" +
                "        <CURRENCYCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getCurrencyCode2() + "</CURRENCYCODE>\n" +
                "        <ESTIMATEDLABORCOST qualifier=\"APPRVORD\" type=\"F\" index=\"index2\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getEstimatedLaborCost2() +"</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">D</DRCR>\n" +
                "        </ESTIMATEDLABORCOST>\n" +
                "        <ESTIMATEDMATERIALCOST qualifier=\"APPRVORD\" type=\"F\" index=\"index2\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getEstimatedMaterialCost2() + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">D</DRCR>\n" +
                "        </ESTIMATEDMATERIALCOST>\n" +
                "        <ESTIMATEDMISCELLANEOUSCOST qualifier=\"APPRVORD\" type=\"F\" index=\"index2\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getEstimatedMiscellaneOusCOST2() + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">D</DRCR>\n" +
                "        </ESTIMATEDMISCELLANEOUSCOST>\n" +
                "        <ESTIMATEDTOTALCOST qualifier=\"APPRVORD\" type=\"F\" index=\"index2\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getEstimatedTotalCost() + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">D</DRCR>\n" +
                "        </ESTIMATEDTOTALCOST>\n" +
                "        <WORKSPACEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <WORKSPACENUMBER>" + workOrderData.getWorkspaceNumber() + "</WORKSPACENUMBER>\n" +
                "          <WORKSPACECODE>" + workOrderData.getWorkSpaceCode() + "</WORKSPACECODE>\n" +
                "          <ORGANIZATIONID entity=\"PartStores\">\n" +
                "            <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </WORKSPACEID>\n" +
                "        <POSITIONID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <EQUIPMENTCODE>" + workOrderData.getPositionEquipmentCode() + "</EQUIPMENTCODE>\n" +
                "          <ORGANIZATIONID entity=\"LaborRequisitionDefault\">\n" +
                "            <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </POSITIONID>\n" +
                "        <MANUFACTURERCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getManufacturerCode2() + "</MANUFACTURERCODE>\n" +
                "        <OEMSITE xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getOEMsite() + "</OEMSITE>\n" +
                "        <VENDOR xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getVendor() + "</VENDOR>\n" +
                "        <COVERAGETYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <TYPECODE>" + workOrderData.getCoverageType() + "</TYPECODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </COVERAGETYPE>\n" +
                "        <ComplianceDetail>\n" +
                "          <ABOVECEILINGPERMIT xmlns=\"http://schemas.datastream.net/MP_fields\">false</ABOVECEILINGPERMIT>\n" +
                "          <INTERIMLIFESAFETY xmlns=\"http://schemas.datastream.net/MP_fields\">false</INTERIMLIFESAFETY>\n" +
                "          <INTERIMINFECTIONCONTROL xmlns=\"http://schemas.datastream.net/MP_fields\">false</INTERIMINFECTIONCONTROL>\n" +
                "          <PRECONSTRUCTIONRISKASSESSMENT xmlns=\"http://schemas.datastream.net/MP_fields\">false</PRECONSTRUCTIONRISKASSESSMENT>\n" +
                "          <PLANIMPROVEMENT xmlns=\"http://schemas.datastream.net/MP_fields\">false</PLANIMPROVEMENT>\n" +
                "          <STATEMENTOFCOND xmlns=\"http://schemas.datastream.net/MP_fields\">false</STATEMENTOFCOND>\n" +
                "          <BUILDMAINTPROGRAM xmlns=\"http://schemas.datastream.net/MP_fields\">false</BUILDMAINTPROGRAM>\n" +
                "          <PERSONALPROTECTIVEEQUIP xmlns=\"http://schemas.datastream.net/MP_fields\">false</PERSONALPROTECTIVEEQUIP>\n" +
                "          <LOCKOUT xmlns=\"http://schemas.datastream.net/MP_fields\">false</LOCKOUT>\n" +
                "          <BURNPERMIT xmlns=\"http://schemas.datastream.net/MP_fields\">false</BURNPERMIT>\n" +
                "          <CONFINEDSPACE xmlns=\"http://schemas.datastream.net/MP_fields\">false</CONFINEDSPACE>\n" +
                "          <PATIENTSAFETY xmlns=\"http://schemas.datastream.net/MP_fields\">false</PATIENTSAFETY>\n" +
                "          <RECALLNOTICE xmlns=\"http://schemas.datastream.net/MP_fields\">false</RECALLNOTICE>\n" +
                "          <SMDA xmlns=\"http://schemas.datastream.net/MP_fields\">false</SMDA>\n" +
                "          <HIPAACONFIDENTIALITY xmlns=\"http://schemas.datastream.net/MP_fields\">false</HIPAACONFIDENTIALITY>\n" +
                "        </ComplianceDetail>\n" +
                "        <IncidentTracking>\n" +
                "          <PATIENT xmlns=\"http://schemas.datastream.net/MP_fields\">false</PATIENT>\n" +
                "          <STAFFINJURY xmlns=\"http://schemas.datastream.net/MP_fields\">false</STAFFINJURY>\n" +
                "          <SECURITYINCIDENT xmlns=\"http://schemas.datastream.net/MP_fields\">false</SECURITYINCIDENT>\n" +
                "          <PROPERTYDAMAGE xmlns=\"http://schemas.datastream.net/MP_fields\">false</PROPERTYDAMAGE>\n" +
                "          <HAZARDOUSMATERIALSINCIDENT xmlns=\"http://schemas.datastream.net/MP_fields\">false</HAZARDOUSMATERIALSINCIDENT>\n" +
                "          <FIRESAFETYINCIDENT xmlns=\"http://schemas.datastream.net/MP_fields\">false</FIRESAFETYINCIDENT>\n" +
                "          <MEDICALEQUIPMENTINCIDENT xmlns=\"http://schemas.datastream.net/MP_fields\">false</MEDICALEQUIPMENTINCIDENT>\n" +
                "          <UTILITYSYSTEMINCIDENT xmlns=\"http://schemas.datastream.net/MP_fields\">false</UTILITYSYSTEMINCIDENT>\n" +
                "        </IncidentTracking>\n" +
                "        <LATITUDE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getLatitude() +"</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "        </LATITUDE>\n" +
                "        <LONGITUDE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + workOrderData.getLongitude() + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</UOM>\n" +
                "        </LONGITUDE>\n" +
                "        <WOTYPECATEGORYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <CATEGORYCODE>" + workOrderData.getWoTypeCategory() + "</CATEGORYCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </WOTYPECATEGORYID>\n" +
                "        <MINOR xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderData.getMinor() + "</MINOR>\n" +
                "        <FIXED xmlns=\"http://schemas.datastream.net/MP_fields\"></FIXED>\n" +
                "      </WorkOrder>\n" +
                "    </MP0023_AddWorkOrder_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

}
