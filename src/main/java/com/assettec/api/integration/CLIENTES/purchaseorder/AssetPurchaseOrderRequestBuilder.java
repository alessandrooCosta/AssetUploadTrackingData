package com.assettec.api.integration.CLIENTES.purchaseorder;

import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.requests.requestbuilders.common.XMLRequestHeader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssetPurchaseOrderRequestBuilder {

    private XMLRequestHeader xmlRequestHeader;

    public String getPurchaseOrder(ApiUser apiUser, String purchaseOrderCode, String purchaseOrderOrganization) {
        return  "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "        <MP0413_GetPurchaseOrder_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Get\" noun=\"PurchaseOrder\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0413_001\">\n" +
                "            <PURCHASEORDERID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                <PURCHASEORDERCODE>" + purchaseOrderCode + "</PURCHASEORDERCODE> \n" +
                "                <ORGANIZATIONID entity=\"User\">\n" +
                "                    <ORGANIZATIONCODE>" + purchaseOrderOrganization + "</ORGANIZATIONCODE>\n" +
                "                </ORGANIZATIONID>\n" +
                "            </PURCHASEORDERID>\n" +
                "        </MP0413_GetPurchaseOrder_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

    public String postPurchaseOrder(ApiUser apiUser, String purchaseOrderOrganization, String purchaseOrderDescription, String purchaseOrderStatusCode, String storeCode, String originatorCode, String currency, String supplierCode, String dueDateYear, String dueDateMonth, String dueDateDay) {
        return  "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "   <MP0414_AddPurchaseOrder_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" autoid=\"true\" verb=\"Add\" noun=\"PurchaseOrder\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0414_001\">\n" +
                "      <PurchaseOrder recordid=\"1\" xmlns=\"http://schemas.datastream.net/MP_entities/PurchaseOrder_001\">\n" +
                "        <PURCHASEORDERID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <PURCHASEORDERCODE></PURCHASEORDERCODE>\n" +
                "          <ORGANIZATIONID entity=\"User\">\n" +
                "            <ORGANIZATIONCODE>" + purchaseOrderOrganization + "</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION>" + purchaseOrderDescription + "</DESCRIPTION>\n" +
                "        </PURCHASEORDERID>\n" +
                "        <CLASSID entity=\"ent1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <CLASSCODE></CLASSCODE>\n" +
                "          <ORGANIZATIONID entity=\"Organization\">\n" +
                "            <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </CLASSID>\n" +
                "        <STATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <STATUSCODE>" + purchaseOrderStatusCode + "</STATUSCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </STATUS>\n" +
                "        <POREVISION xmlns=\"http://schemas.datastream.net/MP_fields\">1</POREVISION>\n" +
                "        <STOREID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <STORECODE>" + storeCode + "</STORECODE>\n" +
                "          <ORGANIZATIONID entity=\"Group\">\n" +
                "            <ORGANIZATIONCODE>ASSET</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </STOREID>\n" +
                "        <DUEDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + dueDateYear + "</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + dueDateMonth + "</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + dueDateDay + "</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </DUEDATE>\n" +
                "        <BUYER xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <USERCODE></USERCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </BUYER>\n" +
                "        <DELADDRESSCODE xmlns=\"http://schemas.datastream.net/MP_fields\"></DELADDRESSCODE>\n" +
                "        <SUPPLIERID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <SUPPLIERCODE>" + supplierCode + "</SUPPLIERCODE>\n" +
                "          <ORGANIZATIONID entity=\"Class\">\n" +
                "            <ORGANIZATIONCODE>ASSET</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </SUPPLIERID>\n" +
                "        <CURRENCYCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + currency + "</CURRENCYCODE>\n" +
                "        <EXCHANGE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">10</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">BRL</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </EXCHANGE>\n" +
                "        <CONTRACTCODE xmlns=\"http://schemas.datastream.net/MP_fields\"></CONTRACTCODE>\n" +
                "        <DISCOUNT qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </DISCOUNT>\n" +
                "        <BLANKETORDER xmlns=\"http://schemas.datastream.net/MP_fields\"></BLANKETORDER>\n" +
                "        <BLANKETORDERRELEASE xmlns=\"http://schemas.datastream.net/MP_fields\"></BLANKETORDERRELEASE>\n" +
                "        <ORDERDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </ORDERDATE>\n" +
                "        <SOURCECODE xmlns=\"http://schemas.datastream.net/MP_fields\"></SOURCECODE>\n" +
                "        <PRINTED xmlns=\"http://schemas.datastream.net/MP_fields\"></PRINTED>\n" +
                "        <TRANSMITTED xmlns=\"http://schemas.datastream.net/MP_fields\">false</TRANSMITTED>\n" +
                "        <DEFAULTAPPROVER xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <USERCODE></USERCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </DEFAULTAPPROVER>\n" +
                "        <APPROVEDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </APPROVEDATE>\n" +
                "        <TYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <TYPECODE></TYPECODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </TYPE>\n" +
                "        <AUTHORIZER xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <USERCODE></USERCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </AUTHORIZER>\n" +
                "        <PURCHASEORDERVALUE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </PURCHASEORDERVALUE>\n" +
                "        <PAYMENTTERM ordertermtype=\"PAY\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <ORDERTERMID>\n" +
                "            <ORDERTERMCODE></ORDERTERMCODE>\n" +
                "            <ORGANIZATIONID entity=\"Department\">\n" +
                "              <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORDERTERMID>\n" +
                "        </PAYMENTTERM>\n" +
                "        <FREIGHTTERM ordertermtype=\"FRTR\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <ORDERTERMID>\n" +
                "            <ORDERTERMCODE></ORDERTERMCODE>\n" +
                "            <ORGANIZATIONID entity=\"Personnel\">\n" +
                "              <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORDERTERMID>\n" +
                "        </FREIGHTTERM>\n" +
                "        <SHIPVIA ordertermtype=\"SHIP\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <ORDERTERMID>\n" +
                "            <ORDERTERMCODE></ORDERTERMCODE>\n" +
                "            <ORGANIZATIONID entity=\"OrganizationValidity\">\n" +
                "              <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORDERTERMID>\n" +
                "        </SHIPVIA>\n" +
                "        <FOBPOINT ordertermtype=\"FOB\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <ORDERTERMID>\n" +
                "            <ORDERTERMCODE></ORDERTERMCODE>\n" +
                "            <ORGANIZATIONID entity=\"Equipment\">\n" +
                "              <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORDERTERMID>\n" +
                "        </FOBPOINT>\n" +
                "        <PAYBYMETHOD ordertermtype=\"PYMT\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <ORDERTERMID>\n" +
                "            <ORDERTERMCODE></ORDERTERMCODE>\n" +
                "            <ORGANIZATIONID entity=\"AssetEquipment\">\n" +
                "              <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORDERTERMID>\n" +
                "        </PAYBYMETHOD>\n" +
                "        <ORDERDISCPERC qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </ORDERDISCPERC>\n" +
                "        <ORIGINATOR xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <PERSONCODE>" + originatorCode + "</PERSONCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </ORIGINATOR>\n" +
                "        <SOURCESYSTEM xmlns=\"http://schemas.datastream.net/MP_fields\"></SOURCESYSTEM>\n" +
                "        <REVISEDDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </REVISEDDATE>\n" +
                "        <INTERFACE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </INTERFACE>\n" +
                "        <EXCHTODUAL qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </EXCHTODUAL>\n" +
                "        <EXCHFROMDUAL qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </EXCHFROMDUAL>\n" +
                "        <CREDITCARD xmlns=\"http://schemas.datastream.net/MP_fields\"></CREDITCARD>\n" +
                "        <POCONTROLNO xmlns=\"http://schemas.datastream.net/MP_fields\"></POCONTROLNO>\n" +
                "        <ATTENTIONTO xmlns=\"http://schemas.datastream.net/MP_fields\"></ATTENTIONTO>\n" +
                "             <UserDefinedFields>\n" +
                "          <UDFCHAR01 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR01>\n" +
                "          <UDFCHAR02 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR02>\n" +
                "          <UDFCHAR03 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR03>\n" +
                "          <UDFCHAR04 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR04>\n" +
                "          <UDFCHAR05 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR05>\n" +
                "          <UDFCHAR06 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR06>\n" +
                "          <UDFCHAR07 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR07>\n" +
                "          <UDFCHAR08 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR08>\n" +
                "          <UDFCHAR09 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR09>\n" +
                "          <UDFCHAR10 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR10>\n" +
                "          <UDFCHAR11 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR11>\n" +
                "          <UDFCHAR12 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR12>\n" +
                "          <UDFCHAR13 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR13>\n" +
                "          <UDFCHAR14 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR14>\n" +
                "          <UDFCHAR15 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR15>\n" +
                "          <UDFCHAR16 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR16>\n" +
                "          <UDFCHAR17 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR17>\n" +
                "          <UDFCHAR18 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR18>\n" +
                "          <UDFCHAR19 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR19>\n" +
                "          <UDFCHAR20 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR20>\n" +
                "          <UDFCHAR21 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR21>\n" +
                "          <UDFCHAR22 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR22>\n" +
                "          <UDFCHAR23 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR23>\n" +
                "          <UDFCHAR24 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR24>\n" +
                "          <UDFCHAR25 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR25>\n" +
                "          <UDFCHAR26 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR26>\n" +
                "          <UDFCHAR27 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR27>\n" +
                "          <UDFCHAR28 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR28>\n" +
                "          <UDFCHAR29 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR29>\n" +
                "          <UDFCHAR30 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR30>\n" +
                "          <UDFNUM01 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM01>\n" +
                "          <UDFNUM02 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM02>\n" +
                "          <UDFNUM03 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM03>\n" +
                "          <UDFNUM04 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM04>\n" +
                "          <UDFNUM05 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM05>\n" +
                "          <UDFDATE01 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE01>\n" +
                "          <UDFDATE02 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE02>\n" +
                "          <UDFDATE03 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE03>\n" +
                "          <UDFDATE04 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE04>\n" +
                "          <UDFDATE05 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE05>\n" +
                "          <UDFCHKBOX01 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHKBOX01>\n" +
                "          <UDFCHKBOX02 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHKBOX02>\n" +
                "          <UDFCHKBOX03 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHKBOX03>\n" +
                "          <UDFCHKBOX04 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHKBOX04>\n" +
                "          <UDFCHKBOX05 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHKBOX05>\n" +
                "        </UserDefinedFields>\n" +
                "        <part_lines_value qualifier=\"ACTUAL\" type=\"T\" index=\"index1\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </part_lines_value>\n" +
                "        <service_lines_value qualifier=\"ACTUAL\" type=\"T\" index=\"index1\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </service_lines_value>\n" +
                "        <no_of_partlines>1</no_of_partlines>\n" +
                "        <no_of_servicelines>1</no_of_servicelines>\n" +
                "        <SUBTOTALPARTVALUE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </SUBTOTALPARTVALUE>\n" +
                "        <SUBTOTALSERVICEVALUE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </SUBTOTALSERVICEVALUE>\n" +
                "        <NEWREVISIONREASON xmlns=\"http://schemas.datastream.net/MP_fields\"></NEWREVISIONREASON>\n" +
                "        <PACKAGETRACKINGNUMBER xmlns=\"http://schemas.datastream.net/MP_fields\"></PACKAGETRACKINGNUMBER>\n" +
                "      </PurchaseOrder>\n" +
                "    </MP0414_AddPurchaseOrder_001>\n" +
                "   </Body>\n" +
                "</Envelope>";
    }


    public String postPurchaseOrderPART(ApiUser apiUser, String purchaseOrderCode, String linha, String purchaseOrderOrganization, String purchaseOrderDescription, String partCode, String purchaseOrderStatusCode, String purchaseOrderTypeCode, String purchaseUOM, String price, String currency, String requestDueDateYEAR, String requestDueDateMONTH, String requestDueDateDAY) {
        return  "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "   <MP0421_AddPartForPO_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Add\" noun=\"PartForPO\" version=\"001\" confirm_use_primary_manufacturerpartnumber=\"prompt\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0421_001\">\n" +
                "      <PartForPO recordid=\"1\" addplannedwopart=\"false\" xmlns=\"http://schemas.datastream.net/MP_entities/PartForPO_001\">\n" +
                "        <PURCHASEORDERLINEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <PURCHASEORDERID>\n" +
                "            <PURCHASEORDERCODE>" + purchaseOrderCode + "</PURCHASEORDERCODE>\n" +
                "            <ORGANIZATIONID entity=\"User\">\n" +
                "              <ORGANIZATIONCODE>" + purchaseOrderOrganization + "</ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION>" + purchaseOrderDescription + "</DESCRIPTION>\n" +
                "          </PURCHASEORDERID>\n" +
                "          <PURCHASEORDERLINENUM>" + linha + "</PURCHASEORDERLINENUM>\n" +
                "        </PURCHASEORDERLINEID>\n" +
                "        <REQUESTDUEDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + requestDueDateYEAR + "</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + requestDueDateMONTH + "</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + requestDueDateDAY + "</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </REQUESTDUEDATE>\n" +
                "        <REQUESTEDQTY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </REQUESTEDQTY>\n" +
                "        <PARTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <PARTCODE>" + partCode + "</PARTCODE>\n" +
                "          <ORGANIZATIONID entity=\"Group\">\n" +
                "            <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </PARTID>\n" +
                "        <PURCHASEORDERTYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <TYPECODE>" + purchaseOrderTypeCode + "</TYPECODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </PURCHASEORDERTYPE>\n" +
                "        <STATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <STATUSCODE>" + purchaseOrderStatusCode + "</STATUSCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </STATUS>\n" +
                "        <SUPPLIERREFERENCE xmlns=\"http://schemas.datastream.net/MP_fields\"></SUPPLIERREFERENCE>\n" +
                "        <PURCHASEQTY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </PURCHASEQTY>\n" +
                "        <PURCHASEUOM xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <UOMCODE>" + purchaseUOM + "</UOMCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </PURCHASEUOM>\n" +
                "        <CONVERSIONFACTOR qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </CONVERSIONFACTOR>\n" +
                "        <PARTQUANTITY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </PARTQUANTITY>\n" +
                "        <PARTUOM xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <UOMCODE>PC</UOMCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </PARTUOM>\n" +
                "        <DUEDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + requestDueDateYEAR + "</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + requestDueDateMONTH + "</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + requestDueDateDAY + "</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </DUEDATE>\n" +
                "        <PRICE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + price + "</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </PRICE>\n" +
                "        <CURRENCYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <CURRENCYCODE>" + currency + "</CURRENCYCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </CURRENCYID>\n" +
                "        <EXCHRATE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </EXCHRATE>\n" +
                "        <ACTIVITYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <WORKORDERID auto_generated=\"true\">\n" +
                "            <JOBNUM></JOBNUM>\n" +
                "            <ORGANIZATIONID entity=\"Class\">\n" +
                "              <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </WORKORDERID>\n" +
                "          <ACTIVITYCODE auto_generated=\"false\"></ACTIVITYCODE>\n" +
                "          <ACTIVITYNOTE></ACTIVITYNOTE>\n" +
                "        </ACTIVITYID>\n" +
                "        <JOBSEQUENCE xmlns=\"http://schemas.datastream.net/MP_fields\">1</JOBSEQUENCE>\n" +
                "        <PROJECTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <PROJECTCODE></PROJECTCODE>\n" +
                "          <ORGANIZATIONID entity=\"Department\">\n" +
                "            <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </PROJECTID>\n" +
                "        <PROJBUD xmlns=\"http://schemas.datastream.net/MP_fields\"></PROJBUD>\n" +
                "        <EQUIPMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <EQUIPMENTCODE></EQUIPMENTCODE>\n" +
                "          <ORGANIZATIONID entity=\"Personnel\">\n" +
                "            <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </EQUIPMENTID>\n" +
                "        <RELATEDWORKORDERID auto_generated=\"true\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <JOBNUM></JOBNUM>\n" +
                "          <ORGANIZATIONID entity=\"OrganizationValidity\">\n" +
                "            <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </RELATEDWORKORDERID>\n" +
                "        <DELIVERYADDRESSID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <DELADDRESSCODE></DELADDRESSCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </DELIVERYADDRESSID>\n" +
                "        <TAXID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <TAXCODE></TAXCODE>\n" +
                "          <ORGANIZATIONID entity=\"Equipment\">\n" +
                "            <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </TAXID>\n" +
                "        <TAX2ID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <TAXCODE></TAXCODE>\n" +
                "          <ORGANIZATIONID entity=\"AssetEquipment\">\n" +
                "            <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </TAX2ID>\n" +
                "        <COSTCODEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <COSTCODE></COSTCODE>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "          <ORGANIZATIONID entity=\"PositionEquipment\">\n" +
                "            <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "        </COSTCODEID>\n" +
                "        <CONTRACTCODE xmlns=\"http://schemas.datastream.net/MP_fields\"></CONTRACTCODE>\n" +
                "        <DISCOUNT qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </DISCOUNT>\n" +
                "        <LEADTIMES qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </LEADTIMES>\n" +
                "        <ASSIGNEDREPAIRPART qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </ASSIGNEDREPAIRPART>\n" +
                "        <RECEIVEDQUANTITY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </RECEIVEDQUANTITY>\n" +
                "        <PARTINSPECTIONREQUIRED xmlns=\"http://schemas.datastream.net/MP_fields\">false</PARTINSPECTIONREQUIRED>\n" +
                "        <TOTALTAXAMOUNT qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </TOTALTAXAMOUNT>\n" +
                "        <INVCALCTAXAMOUNT qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </INVCALCTAXAMOUNT>\n" +
                "        <BYASSET xmlns=\"http://schemas.datastream.net/MP_fields\"></BYASSET>\n" +
                "        <TOTALEXTRA qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </TOTALEXTRA>\n" +
                "        <ISPOLINEACTIVE xmlns=\"http://schemas.datastream.net/MP_fields\"></ISPOLINEACTIVE>\n" +
                "        <EXCHFIX xmlns=\"http://schemas.datastream.net/MP_fields\"></EXCHFIX>\n" +
                "        <STOREID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <STORECODE></STORECODE>\n" +
                "          <ORGANIZATIONID entity=\"PositionEquipmentDefault\">\n" +
                "            <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </STOREID>\n" +
                "        <SUPPLIERID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <SUPPLIERCODE></SUPPLIERCODE>\n" +
                "          <ORGANIZATIONID entity=\"SystemEquipment\">\n" +
                "            <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </SUPPLIERID>\n" +
                "        <RECEIVEDVALUE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </RECEIVEDVALUE>\n" +
                "        <INVOICEDQTY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </INVOICEDQTY>\n" +
                "        <INVOICEDVALUE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </INVOICEDVALUE>\n" +
                "        <POREVISION xmlns=\"http://schemas.datastream.net/MP_fields\"></POREVISION>\n" +
                "        <REVISEDDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </REVISEDDATE>\n" +
                "        <BLANKETORDER xmlns=\"http://schemas.datastream.net/MP_fields\"></BLANKETORDER>\n" +
                "        <BLANKETLINE xmlns=\"http://schemas.datastream.net/MP_fields\"></BLANKETLINE>\n" +
                "        <SOURCESYSTEM xmlns=\"http://schemas.datastream.net/MP_fields\"></SOURCESYSTEM>\n" +
                "        <SOURCECODE xmlns=\"http://schemas.datastream.net/MP_fields\"></SOURCECODE>\n" +
                "        <ACCOUNTDETAIL qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </ACCOUNTDETAIL>\n" +
                "        <INTERFACE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </INTERFACE>\n" +
                "        <EXCHTODUAL qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </EXCHTODUAL>\n" +
                "        <EXCHFROMDUAL qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">*</CURRENCY>\n" +
                "          <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</DRCR>\n" +
                "        </EXCHFROMDUAL>\n" +
                "        <TRADEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <TRADECODE></TRADECODE>\n" +
                "          <ORGANIZATIONID entity=\"Location\">\n" +
                "            <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </TRADEID>\n" +
                "        <FREEZE xmlns=\"http://schemas.datastream.net/MP_fields\"></FREEZE>\n" +
                "        <RECVTASKQTY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </RECVTASKQTY>\n" +
                "        <DCKRECVQTY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </DCKRECVQTY>\n" +
                "        <SCRAPQUANTITY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </SCRAPQUANTITY>\n" +
                "        <IPTRANSMITTED xmlns=\"http://schemas.datastream.net/MP_fields\"></IPTRANSMITTED>\n" +
                "        <IPCURRPRICE xmlns=\"http://schemas.datastream.net/MP_fields\"></IPCURRPRICE>\n" +
                "        <IPLASTUPDATEDDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "          <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "          <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "          <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "          <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "          <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "          <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "          <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "        </IPLASTUPDATEDDATE>\n" +
                "        <ATTENTIONTO xmlns=\"http://schemas.datastream.net/MP_fields\"></ATTENTIONTO>\n" +
                "        <IPERRORID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <IPERRORCODE qualifier=\"ACCEPTED\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </IPERRORCODE>\n" +
                "          <IPERRORMESSAGE></IPERRORMESSAGE>\n" +
                "          <EWSIPERRORMESSAGE></EWSIPERRORMESSAGE>\n" +
                "        </IPERRORID>\n" +
                "        <IPERRORFLAG xmlns=\"http://schemas.datastream.net/MP_fields\"></IPERRORFLAG>\n" +
                "        <QUOTATIONLINEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <QUOTATIONRESPONSEID>\n" +
                "            <QUOTATIONRESPONSECODE></QUOTATIONRESPONSECODE>\n" +
                "            <ORGANIZATIONID entity=\"WorkRequest\">\n" +
                "              <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "              <DESCRIPTION></DESCRIPTION>\n" +
                "            </ORGANIZATIONID>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </QUOTATIONRESPONSEID>\n" +
                "          <QUOTATIONLINENUM></QUOTATIONLINENUM>\n" +
                "        </QUOTATIONLINEID>\n" +
                "        <MANUFACTURERID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <MANUFACTURERCODE></MANUFACTURERCODE>\n" +
                "          <ORGANIZATIONID entity=\"Requisition\">\n" +
                "            <ORGANIZATIONCODE></ORGANIZATIONCODE>\n" +
                "            <DESCRIPTION></DESCRIPTION>\n" +
                "          </ORGANIZATIONID>\n" +
                "          <DESCRIPTION></DESCRIPTION>\n" +
                "        </MANUFACTURERID>\n" +
                "        <MANUFACTURERPARTCODE xmlns=\"http://schemas.datastream.net/MP_fields\"></MANUFACTURERPARTCODE>\n" +
                "             <UserDefinedFields>\n" +
                "          <UDFCHAR01 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR01>\n" +
                "          <UDFCHAR02 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR02>\n" +
                "          <UDFCHAR03 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR03>\n" +
                "          <UDFCHAR04 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR04>\n" +
                "          <UDFCHAR05 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR05>\n" +
                "          <UDFCHAR06 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR06>\n" +
                "          <UDFCHAR07 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR07>\n" +
                "          <UDFCHAR08 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR08>\n" +
                "          <UDFCHAR09 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR09>\n" +
                "          <UDFCHAR10 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR10>\n" +
                "          <UDFCHAR11 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR11>\n" +
                "          <UDFCHAR12 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR12>\n" +
                "          <UDFCHAR13 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR13>\n" +
                "          <UDFCHAR14 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR14>\n" +
                "          <UDFCHAR15 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR15>\n" +
                "          <UDFCHAR16 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR16>\n" +
                "          <UDFCHAR17 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR17>\n" +
                "          <UDFCHAR18 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR18>\n" +
                "          <UDFCHAR19 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR19>\n" +
                "          <UDFCHAR20 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR20>\n" +
                "          <UDFCHAR21 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR21>\n" +
                "          <UDFCHAR22 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR22>\n" +
                "          <UDFCHAR23 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR23>\n" +
                "          <UDFCHAR24 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR24>\n" +
                "          <UDFCHAR25 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR25>\n" +
                "          <UDFCHAR26 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR26>\n" +
                "          <UDFCHAR27 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR27>\n" +
                "          <UDFCHAR28 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR28>\n" +
                "          <UDFCHAR29 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR29>\n" +
                "          <UDFCHAR30 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHAR30>\n" +
                "          <UDFNUM01 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM01>\n" +
                "          <UDFNUM02 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM02>\n" +
                "          <UDFNUM03 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM03>\n" +
                "          <UDFNUM04 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM04>\n" +
                "          <UDFNUM05 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "            <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "            <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "            <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "          </UDFNUM05>\n" +
                "          <UDFDATE01 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE01>\n" +
                "          <UDFDATE02 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE02>\n" +
                "          <UDFDATE03 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE03>\n" +
                "          <UDFDATE04 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE04>\n" +
                "          <UDFDATE05 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "            <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR>\n" +
                "            <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH>\n" +
                "            <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY>\n" +
                "            <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "            <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "            <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "            <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "            <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "          </UDFDATE05>\n" +
                "          <UDFCHKBOX01 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHKBOX01>\n" +
                "          <UDFCHKBOX02 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHKBOX02>\n" +
                "          <UDFCHKBOX03 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHKBOX03>\n" +
                "          <UDFCHKBOX04 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHKBOX04>\n" +
                "          <UDFCHKBOX05 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHKBOX05>\n" +
                "        </UserDefinedFields>\n" +
                "        <PACKAGETRACKINGNUMBER xmlns=\"http://schemas.datastream.net/MP_fields\"></PACKAGETRACKINGNUMBER>\n" +
                "        <PARTCONDITIONTEMPLATECONDITIONCODE xmlns=\"http://schemas.datastream.net/MP_fields\"></PARTCONDITIONTEMPLATECONDITIONCODE>\n" +
                "        <LONGDESCRIPTION xmlns=\"http://schemas.datastream.net/MP_fields\"></LONGDESCRIPTION>\n" +
                "        <ALLOWPREPAYMENT xmlns=\"http://schemas.datastream.net/MP_fields\"></ALLOWPREPAYMENT>\n" +
                "        <PAYMENTNUMBER qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "          <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\"></VALUE>\n" +
                "          <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "          <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "          <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">XXXX</UOM>\n" +
                "        </PAYMENTNUMBER>\n" +
                "      </PartForPO>\n" +
                "    </MP0421_AddPartForPO_001>\n" +
                "   </Body>\n" +
                "</Envelope>";
    }

    public String postCommentsOC(ApiUser apiUser, String OC, String language, String comment, String print) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization())  +
                "    <Body>\n" +
                "  <MP0109_AddComments_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" isFromBatch=\"false\" isFromWOQuickClose=\"false\" bypassWorkOrderTypeAuthorization=\"false\" is_gis_webservice_request=\"false\" verb=\"Add\" noun=\"Comments\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0109_001\">\n" +
                "  <COMMENT recordid=\"1\" is_html_comment=\"is_h1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <ENTITYCOMMENTID>\n" +
                "  <ENTITY>PORD</ENTITY> \n" +
                "  <COMMENTTYPE entity=\"User\">\n" +
                "  <TYPECODE>*</TYPECODE> \n" +
                "  </COMMENTTYPE>\n" +
                "  <ENTITYKEYCODE>" + OC +  "</ENTITYKEYCODE> \n" +
                "  <LANGUAGEID>\n" +
                "  <LANGUAGECODE>" + language +  "</LANGUAGECODE> \n" +
                "  </LANGUAGEID>\n" +
                "  </ENTITYCOMMENTID>\n" +
                "  <COMMENTTEXT>" + comment +  "</COMMENTTEXT> \n" +
                "  <PRINT>" + print +  "</PRINT> \n" +
                "  </COMMENT>\n" +
                "  </MP0109_AddComments_001>\n" +
                "  </Body>\n" +
                "</Envelope>";
    }



    public String deletePurchaseOrder(String  userName, String tenant, String passWord, String organization, String purchaseOrderCode, String purchaseOrderOrganization) {
        return  "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(userName,tenant,passWord,organization) +
                "    <Body>\n" +
                "        <MP0420_DeletePurchaseOrder_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Delete\" noun=\"PurchaseOrder\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0420_001\">\n" +
                "            <PURCHASEORDERID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                <PURCHASEORDERCODE>" + purchaseOrderCode + "</PURCHASEORDERCODE> \n" +
                "                <ORGANIZATIONID entity=\"User\">\n" +
                "                    <ORGANIZATIONCODE>" + purchaseOrderOrganization + "</ORGANIZATIONCODE>\n" +
                "                </ORGANIZATIONID>\n" +
                "            </PURCHASEORDERID>\n" +
                "        </MP0420_DeletePurchaseOrder_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

    public String getPurchaseOrderPart(String  userName, String tenant, String passWord, String organization, String purchaseOrderCode, String purchaseOrderOrganization, String lineNum) {
        return  "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(userName,tenant,passWord,organization) +
                "    <Body>\n" +
                "        <MP0422_GetPartForPO_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Get\" noun=\"PartForPO\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0422_001\">\n" +
                "            <PURCHASEORDERLINEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                <PURCHASEORDERID>\n" +
                "                    <PURCHASEORDERCODE>" + purchaseOrderCode + "</PURCHASEORDERCODE> \n" +
                "                    <ORGANIZATIONID entity=\"User\">\n" +
                "                        <ORGANIZATIONCODE>" + purchaseOrderOrganization + "</ORGANIZATIONCODE>\n" +
                "                    </ORGANIZATIONID>\n" +
                "                </PURCHASEORDERID>\n" +
                "                <PURCHASEORDERLINENUM>" + lineNum + "</PURCHASEORDERLINENUM>\n" +
                "            </PURCHASEORDERLINEID>\n" +
                "        </MP0422_GetPartForPO_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }


    public String putPurchaseOrderPart(String  userName, String tenant, String passWord, String organization, String purchaseOrderCode, String purchaseOrderOrganization, String partLineNum, String purchaseOrderType, String purchaseStatus, String partCode, String partOrganization, String purchaseQuantity, String partQuantity, String purchaseUnitOfMetric, String partUnitOfMetric, String conversionValue, String price, String exchangeValue, String conversionCurrency, String priceCurrency, String currency, String dueDateYear, String dueDateMonth, String dueDateDay, String timeZone, String updatedCount) {
        return  "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(userName,tenant,passWord,organization) +
                "    <Body>\n" +
                "        <MP0423_SyncPartForPO_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Add\" noun=\"PartForPO\" version=\"001\" confirm_use_primary_manufacturerpartnumber=\"prompt\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0421_001\">\n" +
                "            <PartForPO recordid=\"" + updatedCount + "\" addplannedwopart=\"false\" xmlns=\"http://schemas.datastream.net/MP_entities/PartForPO_001\">\n" +
                "                <PURCHASEORDERLINEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                    <PURCHASEORDERID>\n" +
                "                        <PURCHASEORDERCODE>" + purchaseOrderCode + "</PURCHASEORDERCODE> \n" +
                "                        <ORGANIZATIONID entity=\"User\">\n" +
                "                            <ORGANIZATIONCODE>" + purchaseOrderOrganization + "</ORGANIZATIONCODE>\n" +
                "                        </ORGANIZATIONID>\n" +
                "                    </PURCHASEORDERID>\n" +
                "                    <PURCHASEORDERLINENUM>" + partLineNum + "</PURCHASEORDERLINENUM>\n" +
                "                </PURCHASEORDERLINEID>\n" +
                "                <PARTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                    <PARTCODE>" + partCode + "</PARTCODE>\n" +
                "                    <ORGANIZATIONID entity=\"Group\">\n" +
                "                        <ORGANIZATIONCODE>" + partOrganization + "</ORGANIZATIONCODE>\n" +
                "                    </ORGANIZATIONID>" +
                "                </PARTID>\n" +
                "                <PURCHASEORDERTYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                    <TYPECODE>" + purchaseOrderType + "</TYPECODE>\n" +
                "                </PURCHASEORDERTYPE>\n" +
                "                <STATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                    <STATUSCODE>" + purchaseStatus + "</STATUSCODE>\n" +
                "                </STATUS>\n" +
                "                <PURCHASEQTY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                    <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + purchaseQuantity + "</VALUE>\n" +
                "                    <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC>\n" +
                "                    <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "                    <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">default</UOM>\n" +
                "                </PURCHASEQTY>\n" +
                "                <PURCHASEUOM xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                    <UOMCODE>" + purchaseUnitOfMetric + "</UOMCODE>\n" +
                "                </PURCHASEUOM>\n" +
                "                <CONVERSIONFACTOR qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                    <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + conversionValue + "</VALUE>\n" +
                "                    <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">2</NUMOFDEC>\n" +
                "                    <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "                    <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + conversionCurrency + "</CURRENCY>\n" +
                "                    <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">D</DRCR>\n" +
                "                </CONVERSIONFACTOR>\n" +
                "                <PARTQUANTITY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                    <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + partQuantity + "</VALUE>\n" +
                "                    <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC>\n" +
                "                    <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "                    <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">default</UOM>\n" +
                "                </PARTQUANTITY>\n" +
                "                <PARTUOM xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                    <UOMCODE>" + partUnitOfMetric + "</UOMCODE>\n" +
                "                </PARTUOM>\n" +
                "                <DUEDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                    <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + dueDateYear + "</YEAR>\n" +
                "                    <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" +  dueDateMonth + "</MONTH>\n" +
                "                    <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + dueDateDay + "</DAY>\n" +
                "                    <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">0</HOUR>\n" +
                "                    <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">0</MINUTE>\n" +
                "                    <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">0</SECOND>\n" +
                "                    <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">0</SUBSECOND>\n" +
                "                    <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + timeZone + "</TIMEZONE>\n" +
                "                </DUEDATE>\n" +
                "                <PRICE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                    <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + price + "</VALUE>\n" +
                "                    <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">2</NUMOFDEC>\n" +
                "                    <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "                    <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + priceCurrency + "</CURRENCY>\n" +
                "                    <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">D</DRCR>\n" +
                "                </PRICE>\n" +
                "                <CURRENCYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                    <CURRENCYCODE>" + currency + "</CURRENCYCODE>\n" +
                "                </CURRENCYID>\n" +
                "                <EXCHRATE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                    <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + exchangeValue + "</VALUE>\n" +
                "                    <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">2</NUMOFDEC>\n" +
                "                    <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "                    <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">default</UOM>\n" +
                "                </EXCHRATE>\n" +
                "            </PartForPO>\n" +
                "        </MP0423_SyncPartForPO_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

    public String deletePurchaseOrderPart(String  userName, String tenant, String passWord, String organization, String purchaseOrderCode, String purchaseOrderOrganization, String partLineNum) {
        return  "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(userName,tenant,passWord,organization) +
                "    <Body>\n" +
                "        <MP0424_DeletePartForPO_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Delete\" noun=\"PartForPO\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0424_001\">\n" +
                "            <PURCHASEORDERLINEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                <PURCHASEORDERID>\n" +
                "                    <PURCHASEORDERCODE>" + purchaseOrderCode + "</PURCHASEORDERCODE> \n" +
                "                    <ORGANIZATIONID entity=\"User\">\n" +
                "                        <ORGANIZATIONCODE>" + purchaseOrderOrganization + "</ORGANIZATIONCODE>\n" +
                "                    </ORGANIZATIONID>\n" +
                "                </PURCHASEORDERID>\n" +
                "                <PURCHASEORDERLINENUM>" + partLineNum + "</PURCHASEORDERLINENUM>\n" +
                "            </PURCHASEORDERLINEID>\n" +
                "        </MP0424_DeletePartForPO_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }


}
