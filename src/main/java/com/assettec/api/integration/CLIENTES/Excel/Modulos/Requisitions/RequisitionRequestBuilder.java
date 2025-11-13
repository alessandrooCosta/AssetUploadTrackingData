package com.assettec.api.integration.CLIENTES.Excel.Modulos.Requisitions;

import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.requests.requestbuilders.common.XMLRequestHeader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RequisitionRequestBuilder {

    private XMLRequestHeader xmlRequestHeader;


    public String postRequisition(ApiUser apiUser, String ReqCode , String Organization, String description, String status, String Almoxarifado, String Person, String SupplierCode, String ClassCode, String CostCode, String OS, String budgetCode, String budgetDescription, String CreatedUserCode, String printed, String DefaultApproverCode, String approverCode, String partLineCount, String serviceLineCount, String requisitionLineCount, String partTotal, String serviceTotal, String requisitionTotal, String partCurrency, String serviceCurrency, String requisitionCurrency, String rejectionReason, String attentionTo, String quotationRequestCode, String rfqRequired, String UDFCHAR01, String UDFCHAR02, String UDFCHAR03, String UDFCHAR04, String UDFCHAR05, String UDFCHAR06, String projectCode, String UDFCHAR07, String UDFCHAR08, String UDFCHAR09, String UDFCHAR10, String UDFCHAR11, String UDFCHAR12, String UDFCHAR13, String UDFCHAR14, String UDFCHAR15, String UDFCHAR16, String UDFCHAR17, String UDFCHAR18, String UDFCHAR19, String UDFCHAR20, String UDFCHAR21, String UDFCHAR22, String UDFCHAR23, String UDFCHAR24, String UDFCHAR25, String UDFCHAR26, String UDFCHAR27, String UDFCHAR28, String UDFCHAR29, String UDFCHAR30, String UDFNUM01, String UDFNUM02, String UDFNUM03, String UDFNUM04, String UDFNUM05, String UDFCHKBOX01, String UDFCHKBOX02, String UDFCHKBOX03, String UDFCHKBOX04, String UDFCHKBOX05, String  udfDate01Year, String udfDate01Month, String udfDate01Day, String udfDate02Year, String udfDate02Month, String udfDate02Day, String udfDate03Year, String udfDateDay03Month, String udfDateDay03Day, String udfDate04Year, String udfDate04Month, String udfDateDay04Day, String udfDate05Year, String udfDate05Month, String udfDate05Day, String aproveDateYear, String aproveDateMonth, String aproveDateDay) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "     <MP1214_AddReq_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Add\" noun=\"Req\" version=\"001\" workorder=\"\" xmlns=\"http://schemas.datastream.net/MP_functions/MP1214_001\">\n" +
                "      <Req recordid=\"1\" xmlns=\"http://schemas.datastream.net/MP_entities/Req_001\">\n" +
                "        <REQUISITIONID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <REQUISITIONCODE>" + ReqCode + "</REQUISITIONCODE>\n" +
                "          <ORGANIZATIONID entity=\"User\">\n" +
                "            <ORGANIZATIONCODE>" + Organization + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION>" + description + "</DESCRIPTION>\n" +
                "        </REQUISITIONID>\n" +
                "        <STATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <STATUSCODE>" + status + "</STATUSCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </STATUS>\n" +
                "        <STOREID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <STORECODE>" + Almoxarifado + "</STORECODE>\n" +
                "          <ORGANIZATIONID entity=\"Organization\">\n" +
                "            <ORGANIZATIONCODE>" + Organization + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </STOREID>\n" +
                "        <REQUESTEDBY xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <PERSONCODE>" + Person + "</PERSONCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </REQUESTEDBY>\n" +
                "        <DELADDRESSCODE xmlns=\"http://schemas.datastream.net/MP_fields\"></DELADDRESSCODE>\n" +
                "        <SUPPLIERID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <SUPPLIERCODE>" + SupplierCode + "</SUPPLIERCODE>\n" +
                "          <ORGANIZATIONID entity=\"Group\">\n" +
                "            <ORGANIZATIONCODE>" + Organization + " </ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </SUPPLIERID>\n" +
                "        <CLASSID entity=\"ent1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <CLASSCODE>" + ClassCode + "</CLASSCODE>\n" +
                "          <ORGANIZATIONID entity=\"Class\">\n" +
                "            <ORGANIZATIONCODE>" + Organization + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </CLASSID>\n" +
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
                "        <COSTCODEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <COSTCODE>" + CostCode + "</COSTCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "          <ORGANIZATIONID entity=\"Department\">\n" +
                "            <ORGANIZATIONCODE>" + Organization + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "        </COSTCODEID>\n" +
                "        <WORKORDERACTIVITY xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <ACTIVITYID>\n" +
                "            <WORKORDERID auto_generated=\"true\">\n" +
                "              <JOBNUM>" + OS + "</JOBNUM>\n" +
                "              <ORGANIZATIONID entity=\"Personnel\">\n" +
                "                <ORGANIZATIONCODE>" + Organization + "</ORGANIZATIONCODE>\n" +
                "                <DESCRIPTION></DESCRIPTION>\n" +
                "              </ORGANIZATIONID>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </WORKORDERID>\n" +
                "            <ACTIVITYCODE auto_generated=\"false\"></ACTIVITYCODE>\n" +
                "            <ACTIVITYNOTE></ACTIVITYNOTE>\n" +
                "          </ACTIVITYID>\n" +
                "        </WORKORDERACTIVITY>\n" +
                "        <JOBSEQUENCE xmlns=\"http://schemas.datastream.net/MP_fields\"></JOBSEQUENCE>\n" +
                "        <PROJECTBUDGET xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <PROJECTID>\n" +
                "            <PROJECTCODE>" + projectCode + "</PROJECTCODE>\n" +
                "            <ORGANIZATIONID entity=\"OrganizationValidity\">\n" +
                "              <ORGANIZATIONCODE>" + Organization + "</ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </PROJECTID>\n" +
                "          <BUDGETID>\n" +
                "            <BUDGETCODE>" + budgetCode +"</BUDGETCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </BUDGETID>\n" +
                "          <DESCRIPTION>" + budgetDescription + "</DESCRIPTION>\n" +
                "        </PROJECTBUDGET>\n" +
                "        <CREATEDBY xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <USERCODE>" + CreatedUserCode + "</USERCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </CREATEDBY>\n" +
                "        <PRINTED xmlns=\"http://schemas.datastream.net/MP_fields\">" + printed + "</PRINTED>\n" +
                "        <DEFAULTAPPROVER xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <USERCODE>" + DefaultApproverCode + "</USERCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </DEFAULTAPPROVER>\n" +
                "        <APPROVER xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <USERCODE>" + approverCode + "</USERCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </APPROVER>\n" +
                "        <APPROVEDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + aproveDateYear + "</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + aproveDateMonth + "</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + aproveDateDay + "</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </APPROVEDATE>\n" +
                "        <PARTLINECOUNT xmlns=\"http://schemas.datastream.net/MP_fields\">" + partLineCount + "</PARTLINECOUNT>\n" +
                "        <SERVICELINECOUNT xmlns=\"http://schemas.datastream.net/MP_fields\">" + serviceLineCount+ "</SERVICELINECOUNT>\n" +
                "        <REQUISITIONLINECOUNT xmlns=\"http://schemas.datastream.net/MP_fields\">" + requisitionLineCount + "</REQUISITIONLINECOUNT>\n" +
                "        <PARTTOTAL qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + partTotal + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </PARTTOTAL>\n" +
                "        <SERVICETOTAL qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + serviceTotal + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </SERVICETOTAL>\n" +
                "        <REQUISITIONTOTAL qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + requisitionTotal + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </REQUISITIONTOTAL>\n" +
                "        <PARTCURRENCY xmlns=\"http://schemas.datastream.net/MP_fields\">" + partCurrency + "</PARTCURRENCY>\n" +
                "        <SERVICECURRENCY xmlns=\"http://schemas.datastream.net/MP_fields\">" + serviceCurrency + "</SERVICECURRENCY>\n" +
                "        <REQUISITIONCURRENCY xmlns=\"http://schemas.datastream.net/MP_fields\">" +  requisitionCurrency + "</REQUISITIONCURRENCY>\n" +
                "        <REJECTIONREASON xmlns=\"http://schemas.datastream.net/MP_fields\">" + rejectionReason + "</REJECTIONREASON>\n" +
                "        <RELATEDWORKORDERID auto_generated=\"true\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <JOBNUM>" + OS + "</JOBNUM>\n" +
                "          <ORGANIZATIONID entity=\"Equipment\">\n" +
                "            <ORGANIZATIONCODE>" + Organization + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </RELATEDWORKORDERID>\n" +
                "        <ATTENTIONTO xmlns=\"http://schemas.datastream.net/MP_fields\">" + attentionTo + "</ATTENTIONTO>\n" +
                "        <QUOTATIONREQUESTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <QUOTATIONREQUESTCODE>" + quotationRequestCode + "</QUOTATIONREQUESTCODE>\n" +
                "          <ORGANIZATIONID entity=\"PositionEquipment\">\n" +
                "            <ORGANIZATIONCODE>" + Organization + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </QUOTATIONREQUESTID>\n" +
                "        <RFQREQUIRED xmlns=\"http://schemas.datastream.net/MP_fields\">" + rfqRequired+ "</RFQREQUIRED>\n" +
                "        <UserDefinedFields>\n" +
                "          <UDFCHAR01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR01 + "</UDFCHAR01>\n" +
                "          <UDFCHAR02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR02 + "</UDFCHAR02>\n" +
                "          <UDFCHAR03 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR03 + "</UDFCHAR03>\n" +
                "          <UDFCHAR04 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR04 + "</UDFCHAR04>\n" +
                "          <UDFCHAR05 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR05 + "</UDFCHAR05>\n" +
                "          <UDFCHAR06 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR06 + "</UDFCHAR06>\n" +
                "          <UDFCHAR07 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR07 + "</UDFCHAR07>\n" +
                "          <UDFCHAR08 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR08 + "</UDFCHAR08>\n" +
                "          <UDFCHAR09 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR09 + "</UDFCHAR09>\n" +
                "          <UDFCHAR10 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR10 + "</UDFCHAR10>\n" +
                "          <UDFCHAR11 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR11 + "</UDFCHAR11>\n" +
                "          <UDFCHAR12 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR12 + "</UDFCHAR12>\n" +
                "          <UDFCHAR13 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR13 + "</UDFCHAR13>\n" +
                "          <UDFCHAR14 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR14 + "</UDFCHAR14>\n" +
                "          <UDFCHAR15 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR15 + "</UDFCHAR15>\n" +
                "          <UDFCHAR16 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR16 + "</UDFCHAR16>\n" +
                "          <UDFCHAR17 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR17 + "</UDFCHAR17>\n" +
                "          <UDFCHAR18 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR18 + "</UDFCHAR18>\n" +
                "          <UDFCHAR19 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR19 + "</UDFCHAR19>\n" +
                "          <UDFCHAR20 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR20 + "</UDFCHAR20>\n" +
                "          <UDFCHAR21 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR21 + "</UDFCHAR21>\n" +
                "          <UDFCHAR22 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR22 + "</UDFCHAR22>\n" +
                "          <UDFCHAR23 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR23 + "</UDFCHAR23>\n" +
                "          <UDFCHAR24 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR24 + "</UDFCHAR24>\n" +
                "          <UDFCHAR25 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR25 + "</UDFCHAR25>\n" +
                "          <UDFCHAR26 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR26 + "</UDFCHAR26>\n" +
                "          <UDFCHAR27 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR27 + "</UDFCHAR27>\n" +
                "          <UDFCHAR28 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR28 + "</UDFCHAR28>\n" +
                "          <UDFCHAR29 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR29 + "</UDFCHAR29>\n" +
                "          <UDFCHAR30 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR30 + "</UDFCHAR30>\n" +
                "          <UDFNUM01 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + UDFNUM01 + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM01>\n" +
                "          <UDFNUM02 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + UDFNUM02 + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM02>\n" +
                "          <UDFNUM03 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + UDFNUM03 + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM03>\n" +
                "          <UDFNUM04 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + UDFNUM04 + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM04>\n" +
                "          <UDFNUM05 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + UDFNUM05 + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM05>\n" +
                "          <UDFDATE01 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate01Year + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate01Month + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate01Day + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE01>\n" +
                "          <UDFDATE02 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">"  + udfDate02Year + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate02Month + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate02Day + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE02>\n" +
                "          <UDFDATE03 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate03Year + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDateDay03Month + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDateDay03Day + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE03>\n" +
                "          <UDFDATE04 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate04Year + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate04Month + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDateDay04Day + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE04>\n" +
                "          <UDFDATE05 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate05Year + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate05Month + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate05Day + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE05>\n" +
                "          <UDFCHKBOX01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHKBOX01 + "</UDFCHKBOX01>\n" +
                "          <UDFCHKBOX02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHKBOX02 + "</UDFCHKBOX02>\n" +
                "          <UDFCHKBOX03 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHKBOX03 + "</UDFCHKBOX03>\n" +
                "          <UDFCHKBOX04 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHKBOX04 + "</UDFCHKBOX04>\n" +
                "          <UDFCHKBOX05 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHKBOX05 + "</UDFCHKBOX05>\n" +
                "        </UserDefinedFields>\n" +
                "      </Req>\n" +
                "    </MP1214_AddReq_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }


        public String postRequisitionPart(ApiUser apiUser, String ReqCode, String partCode, String ManufacturerPartCode, String ManufacturerCode, String type, String quantityRequired, String uomCode, String taxCode, String Price, String currencyCode, String status, String activityCode, String activityNote, String dateRequiredYear, String dateRequiredMonth, String dateRequiredDay, String OS, String budgetCode, String exchRate, String CostCode, String buyer, String DefaultApproverCode, String approverCode, String partLineCount, String serviceLineCount, String requisitionLineCount, String partTotal, String serviceTotal, String requisitionTotal, String partCurrency, String attentionTo, String quotationRequestCode, String UDFCHAR01, String UDFCHAR02, String UDFCHAR03, String UDFCHAR04, String UDFCHAR05, String UDFCHAR06, String projectCode, String UDFCHAR07, String UDFCHAR08, String UDFCHAR09, String UDFCHAR10, String UDFCHAR11, String UDFCHAR12, String UDFCHAR13, String UDFCHAR14, String UDFCHAR15, String UDFCHAR16, String UDFCHAR17, String UDFCHAR18, String UDFCHAR19, String UDFCHAR20, String UDFCHAR21, String UDFCHAR22, String UDFCHAR23, String UDFCHAR24, String UDFCHAR25, String UDFCHAR26, String UDFCHAR27, String UDFCHAR28, String UDFCHAR29, String UDFCHAR30, String UDFNUM01, String UDFNUM02, String UDFNUM03, String UDFNUM04, String UDFNUM05, String UDFCHKBOX01, String UDFCHKBOX02, String UDFCHKBOX03, String UDFCHKBOX04, String UDFCHKBOX05, String  udfDate01Year, String udfDate01Month, String udfDate01Day, String udfDate02Year, String udfDate02Month, String udfDate02Day, String udfDate03Year, String udfDateDay03Month, String udfDateDay03Day, String udfDate04Year, String udfDate04Month, String udfDateDay04Day, String udfDate05Year, String udfDate05Month, String udfDate05Day, String deladdRessCode, String inspectionRequired, String warranty, String blankeTorder, String expenseType, String commodityCode, String byAsset, String quotationIndicator, String RelatedWorkOrder, String iplastUpdatedDateYear, String iplastUpdatedDateMonth, String iplastUpdatedDateDay, String preventreOrders, String quotationResponseCode, String quotationLineNum, String assignedQuantity, String receivedQuantity, String scrapQuantity, String IperrorCode, String IperrorMessage, String EWSIperrorMessage, String IperrorFlag, String partConditionTemplate) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "     <MP1229_AddReqPart_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Add\" noun=\"ReqPart\" version=\"001\" newpart=\"false\" workorder=\"\" confirm_use_primary_manufacturerpartnumber=\"prompt\" xmlns=\"http://schemas.datastream.net/MP_functions/MP1229_001\">\n" +
                "      <ReqPart recordid=\"1\" addplannedwopart=\"false\" xmlns=\"http://schemas.datastream.net/MP_entities/ReqPart_001\">\n" +
                "        <REQUISITIONLINEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <REQUISITIONID>\n" +
                "            <REQUISITIONCODE>" + ReqCode + "</REQUISITIONCODE>\n" +
                "            <ORGANIZATIONID entity=\"User\">\n" +
                "              <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </REQUISITIONID>\n" +
                "          <REQUISITIONLINENUM>1</REQUISITIONLINENUM>\n" +
                "        </REQUISITIONLINEID>\n" +
                "        <SUPPLIERPARTCODE xmlns=\"http://schemas.datastream.net/MP_fields\"></SUPPLIERPARTCODE>\n" +
                "        <PARTMANUFACTURERID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <PARTID>\n" +
                "            <PARTCODE>" + partCode + "</PARTCODE>\n" +
                "            <ORGANIZATIONID entity=\"Group\">\n" +
                "              <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </PARTID>\n" +
                "          <MANUFACTURERPARTCODE>" + ManufacturerPartCode + "</MANUFACTURERPARTCODE>\n" +
                "          <MANUFACTURERCODE>" + ManufacturerCode + "</MANUFACTURERCODE>\n" +
                "        </PARTMANUFACTURERID>\n" +
                "        <TYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <TYPECODE>" + type + "</TYPECODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </TYPE>\n" +
                "        <QUANTITYREQUIRED qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + quantityRequired + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </QUANTITYREQUIRED>\n" +
                "        <UOMID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <UOMCODE>" + uomCode + "</UOMCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </UOMID>\n" +
                "        <TAXID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <TAXCODE>" + taxCode + "</TAXCODE>\n" +
                "          <ORGANIZATIONID entity=\"Class\">\n" +
                "            <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </TAXID>\n" +
                "        <PRICE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + Price + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">BRL</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </PRICE>\n" +
                "        <CURRENCYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <CURRENCYCODE>" + currencyCode + "</CURRENCYCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </CURRENCYID>\n" +
                "        <STATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <STATUSCODE>" + status + "</STATUSCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </STATUS>\n" +
                "        <DATEREQUIRED qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + dateRequiredYear + "</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + dateRequiredMonth + "</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + dateRequiredDay + "</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </DATEREQUIRED>\n" +
                "        <EXCHRATE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + exchRate + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </EXCHRATE>\n" +
                "        <COSTCODEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <COSTCODE>" + CostCode + "</COSTCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "          <ORGANIZATIONID entity=\"Department\">\n" +
                "            <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "        </COSTCODEID>\n" +
                "        <WORKORDERACTIVITY xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <ACTIVITYID>\n" +
                "            <WORKORDERID auto_generated=\"true\">\n" +
                "              <JOBNUM>" + OS + "</JOBNUM>\n" +
                "              <ORGANIZATIONID entity=\"Personnel\">\n" +
                "                <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "                <DESCRIPTION></DESCRIPTION>\n" +
                "              </ORGANIZATIONID>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </WORKORDERID>\n" +
                "            <ACTIVITYCODE auto_generated=\"false\">" + activityCode + "</ACTIVITYCODE>\n" +
                "            <ACTIVITYNOTE>" + activityNote+ "</ACTIVITYNOTE>\n" +
                "          </ACTIVITYID>\n" +
                "        </WORKORDERACTIVITY>\n" +
                "        <JOBSEQUENCE xmlns=\"http://schemas.datastream.net/MP_fields\"></JOBSEQUENCE>\n" +
                "        <PROJECTBUDGET xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <PROJECTID>\n" +
                "            <PROJECTCODE>" + projectCode + "</PROJECTCODE>\n" +
                "            <ORGANIZATIONID entity=\"OrganizationValidity\">\n" +
                "              <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </PROJECTID>\n" +
                "          <BUDGETID>\n" +
                "            <BUDGETCODE>" + budgetCode + "</BUDGETCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </BUDGETID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </PROJECTBUDGET>\n" +
                "        <BUYER xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <USERCODE>" + buyer + "</USERCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </BUYER>\n" +
                "        <DELADDRESSCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + deladdRessCode + "</DELADDRESSCODE>\n" +
                "        <INSPECTIONREQUIRED xmlns=\"http://schemas.datastream.net/MP_fields\">" + inspectionRequired + "</INSPECTIONREQUIRED>\n" +
                "        <WARRANTY xmlns=\"http://schemas.datastream.net/MP_fields\">" + warranty + "</WARRANTY>\n" +
                "        <BLANKETORDER xmlns=\"http://schemas.datastream.net/MP_fields\">" + blankeTorder + "</BLANKETORDER>\n" +
                "        <EXPENSETYPE xmlns=\"http://schemas.datastream.net/MP_fields\">" + expenseType + "</EXPENSETYPE>\n" +
                "        <COMMODITYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <COMMODITYCODE>" + commodityCode + "</COMMODITYCODE>\n" +
                "          <ORGANIZATIONID entity=\"Equipment\">\n" +
                "            <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </COMMODITYID>\n" +
                "        <BYASSET xmlns=\"http://schemas.datastream.net/MP_fields\">" + byAsset + "</BYASSET>\n" +
                "        <QUOTATIONINDICATOR xmlns=\"http://schemas.datastream.net/MP_fields\">" + quotationIndicator + "</QUOTATIONINDICATOR>\n" +
                "        <PARTTOTAL qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + partTotal + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">BRL</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </PARTTOTAL>\n" +
                "        <PARTCURRENCY xmlns=\"http://schemas.datastream.net/MP_fields\">" + partCurrency + "</PARTCURRENCY>\n" +
                "        <RELATEDWORKORDERID auto_generated=\"true\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <JOBNUM>" + RelatedWorkOrder + "</JOBNUM>\n" +
                "          <ORGANIZATIONID entity=\"AssetEquipment\">\n" +
                "            <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </RELATEDWORKORDERID>\n" +
                "        <IPLASTUPDATEDDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + iplastUpdatedDateYear +"</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + iplastUpdatedDateMonth + "</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + iplastUpdatedDateDay + "</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </IPLASTUPDATEDDATE>\n" +
                "        <ATTENTIONTO xmlns=\"http://schemas.datastream.net/MP_fields\">" + attentionTo + "</ATTENTIONTO>\n" +
                "        <PREVENTREORDERS xmlns=\"http://schemas.datastream.net/MP_fields\">" + preventreOrders + "</PREVENTREORDERS>\n" +
                "        <RFQLINEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <QUOTATIONREQUESTID>\n" +
                "            <QUOTATIONREQUESTCODE>" + quotationRequestCode + "</QUOTATIONREQUESTCODE>\n" +
                "            <ORGANIZATIONID entity=\"PositionEquipment\">\n" +
                "              <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </QUOTATIONREQUESTID>\n" +
                "          <RFQLINENUM></RFQLINENUM>\n" +
                "        </RFQLINEID>\n" +
                "        <QUOTATIONLINEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <QUOTATIONRESPONSEID>\n" +
                "            <QUOTATIONRESPONSECODE>" + quotationResponseCode + "</QUOTATIONRESPONSECODE>\n" +
                "            <ORGANIZATIONID entity=\"PositionEquipmentDefault\">\n" +
                "              <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </QUOTATIONRESPONSEID>\n" +
                "          <QUOTATIONLINENUM>" + quotationLineNum + "</QUOTATIONLINENUM>\n" +
                "        </QUOTATIONLINEID>\n" +
                "        <PARTINSPECTIONREQUIRED xmlns=\"http://schemas.datastream.net/MP_fields\">false</PARTINSPECTIONREQUIRED>\n" +
                "        <ASSIGNEDQUANTITY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + assignedQuantity + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">BRL</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </ASSIGNEDQUANTITY>\n" +
                "        <RECEIVEDQUANTITY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + receivedQuantity + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </RECEIVEDQUANTITY>\n" +
                "        <SCRAPQUANTITY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + scrapQuantity + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </SCRAPQUANTITY>\n" +
                "        <IPERRORID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <IPERRORCODE qualifier=\"ACCEPTED\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + IperrorCode + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </IPERRORCODE>\n" +
                "          <IPERRORMESSAGE>" + IperrorMessage + "</IPERRORMESSAGE>\n" +
                "          <EWSIPERRORMESSAGE>" + EWSIperrorMessage + "</EWSIPERRORMESSAGE>\n" +
                "        </IPERRORID>\n" +
                "        <IPERRORFLAG xmlns=\"http://schemas.datastream.net/MP_fields\">" + IperrorFlag + "</IPERRORFLAG>\n" +
                "        <PARTCONDITIONTEMPLATECONDITIONCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + partConditionTemplate + "</PARTCONDITIONTEMPLATECONDITIONCODE>\n" +
                "        <LONGDESCRIPTION xmlns=\"http://schemas.datastream.net/MP_fields\"></LONGDESCRIPTION>\n" +
                "        <UserDefinedFields>\n" +
                "          <UDFCHAR01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR01 + "</UDFCHAR01>\n" +
                "          <UDFCHAR02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR02 + "</UDFCHAR02>\n" +
                "          <UDFCHAR03 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR03 + "</UDFCHAR03>\n" +
                "          <UDFCHAR04 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR04 + "</UDFCHAR04>\n" +
                "          <UDFCHAR05 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR05 + "</UDFCHAR05>\n" +
                "          <UDFCHAR06 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR06 + "</UDFCHAR06>\n" +
                "          <UDFCHAR07 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR07 + "</UDFCHAR07>\n" +
                "          <UDFCHAR08 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR08 + "</UDFCHAR08>\n" +
                "          <UDFCHAR09 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR09 + "</UDFCHAR09>\n" +
                "          <UDFCHAR10 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR10 + "</UDFCHAR10>\n" +
                "          <UDFCHAR11 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR11 + "</UDFCHAR11>\n" +
                "          <UDFCHAR12 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR12 + "</UDFCHAR12>\n" +
                "          <UDFCHAR13 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR13 + "</UDFCHAR13>\n" +
                "          <UDFCHAR14 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR14 + "</UDFCHAR14>\n" +
                "          <UDFCHAR15 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR15 + "</UDFCHAR15>\n" +
                "          <UDFCHAR16 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR16 + "</UDFCHAR16>\n" +
                "          <UDFCHAR17 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR17 + "</UDFCHAR17>\n" +
                "          <UDFCHAR18 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR18 + "</UDFCHAR18>\n" +
                "          <UDFCHAR19 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR19 + "</UDFCHAR19>\n" +
                "          <UDFCHAR20 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR20 + "</UDFCHAR20>\n" +
                "          <UDFCHAR21 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR21 + "</UDFCHAR21>\n" +
                "          <UDFCHAR22 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR22 + "</UDFCHAR22>\n" +
                "          <UDFCHAR23 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR23 + "</UDFCHAR23>\n" +
                "          <UDFCHAR24 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR24 + "</UDFCHAR24>\n" +
                "          <UDFCHAR25 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR25 + "</UDFCHAR25>\n" +
                "          <UDFCHAR26 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR26 + "</UDFCHAR26>\n" +
                "          <UDFCHAR27 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR27 + "</UDFCHAR27>\n" +
                "          <UDFCHAR28 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR28 + "</UDFCHAR28>\n" +
                "          <UDFCHAR29 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR29 + "</UDFCHAR29>\n" +
                "          <UDFCHAR30 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR30 + "</UDFCHAR30>\n" +
                "          <UDFNUM01 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + UDFNUM01 + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM01>\n" +
                "          <UDFNUM02 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + UDFNUM02 + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM02>\n" +
                "          <UDFNUM03 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + UDFNUM03 + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM03>\n" +
                "          <UDFNUM04 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + UDFNUM04 + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM04>\n" +
                "          <UDFNUM05 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + UDFNUM05 + "</VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM05>\n" +
                "          <UDFDATE01 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate01Year + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate01Month + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate01Day + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE01>\n" +
                "          <UDFDATE02 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">"  + udfDate02Year + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate02Month + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate02Day + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE02>\n" +
                "          <UDFDATE03 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate03Year + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDateDay03Month + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDateDay03Day + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE03>\n" +
                "          <UDFDATE04 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate04Year + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate04Month + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDateDay04Day + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE04>\n" +
                "          <UDFDATE05 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate05Year + "</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate05Month + "</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + udfDate05Day + "</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE05>\n" +
                "          <UDFCHKBOX01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHKBOX01 + "</UDFCHKBOX01>\n" +
                "          <UDFCHKBOX02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHKBOX02 + "</UDFCHKBOX02>\n" +
                "          <UDFCHKBOX03 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHKBOX03 + "</UDFCHKBOX03>\n" +
                "          <UDFCHKBOX04 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHKBOX04 + "</UDFCHKBOX04>\n" +
                "          <UDFCHKBOX05 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHKBOX05 + "</UDFCHKBOX05>\n" +
                "        </UserDefinedFields>\n" +
                "      </ReqPart>\n" +
                "    </MP1229_AddReqPart_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }


    public String postCommentReq(ApiUser apiUser, String ReqCode , String language, String print, String commentText) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "     < <MP0109_AddComments_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" isFromBatch=\"false\" isFromWOQuickClose=\"false\" bypassWorkOrderTypeAuthorization=\"false\" is_gis_webservice_request=\"false\" verb=\"Add\" noun=\"Comments\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0109_001\">\n" +
                "      <COMMENT recordid=\"1\" is_html_comment=\"is_h1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "        <ENTITYCOMMENTID>\n" +
                "          <ENTITY>REQ</ENTITY>\n" +
                "          <COMMENTTYPE entity=\"User\">\n" +
                "            <TYPECODE>*</TYPECODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </COMMENTTYPE>\n" +
                "          <ENTITYKEYCODE>" + ReqCode + "</ENTITYKEYCODE>\n" +
                "          <LANGUAGEID>\n" +
                "            <LANGUAGECODE>" + language + "</LANGUAGECODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </LANGUAGEID>\n" +
                "        </ENTITYCOMMENTID>\n" +
                "        <COMMENTTEXT>" + commentText + "</COMMENTTEXT>\n" +
                "        <PRINT>" + print + "</PRINT>\n" +
                "        <CREATEDBY>\n" +
                "          <USERCODE></USERCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </CREATEDBY>\n" +
                "        <UPDATEDBY>\n" +
                "          <USERCODE></USERCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </UPDATEDBY>\n" +
                "        <CATEGORYID>\n" +
                "          <CATEGORYCODE></CATEGORYCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </CATEGORYID>\n" +
                "        <ORGANIZATIONID entity=\"User\">\n" +
                "          <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </ORGANIZATIONID>\n" +
                "        <TRANSLATEDTEXT></TRANSLATEDTEXT>\n" +
                "      </COMMENT>\n" +
                "    </MP0109_AddComments_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

}


