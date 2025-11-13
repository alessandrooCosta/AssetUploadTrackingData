package com.assettec.api.integration.CLIENTES.Parts;

import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.requests.requestbuilders.common.XMLRequestHeader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PartsRequestBuilder {

    private XMLRequestHeader xmlRequestHeader;

    public String postPartsData(ApiUser apiUser, String partCode, String organizationCode, String descriptionCode, String classCode, String classOrganization, String descriptionClass, String categoryCode, String categoryDescription, String uomCode, String toolCode, String toolOrganization, String toolDescription, String commodityCode, String secondaryCommodityCode, String secondaryCommodityOrganization, String secondaryCommodityDescription, String methodCode, String taxCode, String taxOrganization, String taxDescription, String trackMethodTypeCode, String partCodeStructure, String userCode, String supplierCode, String supplierOrganization, String supplierDescription, String currencyCode, String supplierUOM, String commodityOrganization, String commodityDescription, String conversionFactor, String UDFCHAR01, String UDFCHAR02, String UDFCHAR03, String UDFCHAR04, String UDFCHAR05, String UDFCHAR06, String UDFCHAR07, String UDFCHAR08, String UDFCHAR09, String UDFCHAR10, String UDFCHAR11, String UDFCHAR12, String UDFCHAR13, String UDFCHAR14, String UDFCHAR15, String UDFCHAR16, String UDFCHAR17, String UDFCHAR18, String UDFCHAR19, String UDFCHAR20, String UDFCHAR21, String UDFCHAR22, String UDFCHAR23, String UDFCHAR24, String UDFCHAR25, String UDFCHAR26, String UDFCHAR27, String UDFCHAR28, String UDFCHAR29, String UDFCHAR30, String objectCode, String profileOrganization, String profileDescription, String typeCode, String classIdCode, String classIdOrganization, String classIdDescription, String statusCode, String departmentCode, String departmentOrganization, String departmentDescription, String categoryIdCode, String costCode, String costOrganization, String storeCode, String storeOrganization, String storeDescription, String partIdCode, String partIdOrganization, String partIdDescription, String meterUnit, String manufacturerCode, String serialNumber, String model, String modelRevision, String cnNumber, String propertyCode, String propertyLabel, String UserDefinedClassCode, String UserDefinedClassOrg, String UserDefinedClassDescription, String priceType, String byAsset, String byLot, String kit, String saveHistory, String outOfService, String inspectionRequired, String repairable, String calibrationStandard, String preventReorders) {
        return " <Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                " <Body>\n" +
                "  <MP0240_AddPart_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Add\" noun=\"Part\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0240_001\">\n" +
                " <Part recordid=\"1\" user_entity=\"user_entity1\" system_entity=\"system_entity1\" xmlns=\"http://schemas.datastream.net/MP_entities/Part_001\">\n" +
                " <PARTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <PARTCODE>" + partCode + "</PARTCODE> \n" +
                " <ORGANIZATIONID entity=\"User\">\n" +
                "  <ORGANIZATIONCODE>" + organizationCode + "</ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION>" + descriptionCode + "</DESCRIPTION> \n" +
                "  </PARTID>\n" +
                " <CLASSID entity=\"ent1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <CLASSCODE>" + classCode + "</CLASSCODE> \n" +
                " <ORGANIZATIONID entity=\"Organization\">\n" +
                "  <ORGANIZATIONCODE>" + classOrganization + "</ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION>" + descriptionClass + "</DESCRIPTION> \n" +
                "  </CLASSID>\n" +
                " <CATEGORYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <CATEGORYCODE>" + categoryCode + "</CATEGORYCODE> \n" +
                "  <DESCRIPTION> " + categoryDescription + "</DESCRIPTION> \n" +
                "  </CATEGORYID>\n" +
                " <UOMID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <UOMCODE>" + uomCode + "</UOMCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </UOMID>\n" +
                " <TOOLID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <TOOLCODE>" + toolCode +"</TOOLCODE> \n" +
                " <ORGANIZATIONID entity=\"Group\">\n" +
                "  <ORGANIZATIONCODE>" + toolOrganization + "</ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION>" + toolDescription + "</DESCRIPTION> \n" +
                "  </TOOLID>\n" +
                " <PRIMARYCOMMODITY xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <COMMODITYCODE>" + commodityCode + "</COMMODITYCODE> \n" +
                "  <ORGANIZATIONID entity=\"Class\">\n" +
                "  <ORGANIZATIONCODE>" + commodityOrganization + "</ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION>" + commodityOrganization + "</DESCRIPTION> \n" +
                "  </PRIMARYCOMMODITY>\n" +
                " <SECONDARYCOMMODITY xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <COMMODITYCODE>" + secondaryCommodityCode + "</COMMODITYCODE> \n" +
                " <ORGANIZATIONID entity=\"Department\">\n" +
                "  <ORGANIZATIONCODE>" + secondaryCommodityOrganization + "</ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION>" + secondaryCommodityDescription + "</DESCRIPTION> \n" +
                "  </SECONDARYCOMMODITY>\n" +
                " <INSPECTMETHOD xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <METHODCODE>" + methodCode + "</METHODCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </INSPECTMETHOD>\n" +
                " <TAXID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <TAXCODE>" + taxCode + "</TAXCODE> \n" +
                " <ORGANIZATIONID entity=\"Personnel\">\n" +
                "  <ORGANIZATIONCODE>" + taxOrganization + "</ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION>" + taxDescription + "</DESCRIPTION> \n" +
                "  </TAXID>\n" +
                " <TRACKMETHOD entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <TYPECODE>" + trackMethodTypeCode + "</TYPECODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </TRACKMETHOD>\n" +
                " <WARRANTYDAYS qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE> \n" +
                "  <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC> \n" +
                "  <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">SIGN1</SIGN> \n" +
                "  <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">CURRENCY1</CURRENCY> \n" +
                "  <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">DRCR1</DRCR> \n" +
                "  </WARRANTYDAYS>\n" +
                "  <PARTCODESTRUCTURE xmlns=\"http://schemas.datastream.net/MP_fields\">" + partCodeStructure + "</PARTCODESTRUCTURE> \n" +
                "  <BUYER xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <USERCODE>" + userCode + "</USERCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </BUYER>\n" +
                " <PREFERREDSUPPLIER xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <SUPPLIERCODE>" + supplierCode + "</SUPPLIERCODE> \n" +
                " <ORGANIZATIONID entity=\"OrganizationValidity\">\n" +
                "  <ORGANIZATIONCODE>" + supplierOrganization + "</ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION>" + supplierDescription + "</DESCRIPTION> \n" +
                "  </PREFERREDSUPPLIER>\n" +
                " <SUPPLIERPRICE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE> \n" +
                "  <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC> \n" +
                "  <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">SIGN1</SIGN> \n" +
                "  <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">CURRENCY1</CURRENCY> \n" +
                "  <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">DRCR1</DRCR> \n" +
                "  </SUPPLIERPRICE>\n" +
                " <SUPPLIERCURRENCY xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <CURRENCYCODE>" + currencyCode + "</CURRENCYCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </SUPPLIERCURRENCY>\n" +
                " <SUPPLIERUOM xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <UOMCODE>" + supplierUOM + "</UOMCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </SUPPLIERUOM>\n" +
                " <CONVERSIONFACTOR qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE> \n" +
                "  <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC> \n" +
                "  <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">SIGN1</SIGN> \n" +
                "  <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">CURRENCY1</CURRENCY> \n" +
                "  <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">DRCR1</DRCR> \n" +
                "  </CONVERSIONFACTOR>\n" +
                " <COREVALUE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE> \n" +
                "  <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC> \n" +
                "  <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">SIGN1</SIGN> \n" +
                "  <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">CURRENCY1</CURRENCY> \n" +
                "  <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">DRCR1</DRCR> \n" +
                "  </COREVALUE>\n" +
                " <AVERAGEPRICE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE> \n" +
                "  <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC> \n" +
                "  <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">SIGN1</SIGN> \n" +
                "  <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">CURRENCY1</CURRENCY> \n" +
                "  <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">DRCR1</DRCR> \n" +
                "  </AVERAGEPRICE>\n" +
                " <LASTPRICE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE> \n" +
                "  <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC> \n" +
                "  <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">SIGN1</SIGN> \n" +
                "  <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">CURRENCY1</CURRENCY> \n" +
                "  <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">DRCR1</DRCR> \n" +
                "  </LASTPRICE>\n" +
                " <STANDARDPRICE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE> \n" +
                "  <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC> \n" +
                "  <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">SIGN1</SIGN> \n" +
                "  <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">CURRENCY1</CURRENCY> \n" +
                "  <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">DRCR1</DRCR> \n" +
                "  </STANDARDPRICE>\n" +
                " <CREDITBALANCE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE> \n" +
                "  <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC> \n" +
                "  <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">SIGN1</SIGN> \n" +
                "  <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">CURRENCY1</CURRENCY> \n" +
                "  <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">DRCR1</DRCR> \n" +
                "  </CREDITBALANCE>\n" +
                " <BASEPRICE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE> \n" +
                "  <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC> \n" +
                "  <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">SIGN1</SIGN> \n" +
                "  <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">CURRENCY1</CURRENCY> \n" +
                "  <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">DRCR1</DRCR> \n" +
                "  </BASEPRICE>\n" +
                " <PRICETYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <TYPECODE>" + priceType + "</TYPECODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </PRICETYPE>\n" +
                " <CURRENCYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <CURRENCYCODE>" + currencyCode + "</CURRENCYCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </CURRENCYID>\n" +
                "  <BYASSET xmlns=\"http://schemas.datastream.net/MP_fields\">" + byAsset + "</BYASSET> \n" +
                "  <BYLOT xmlns=\"http://schemas.datastream.net/MP_fields\">" + byLot + "</BYLOT> \n" +
                "  <KIT xmlns=\"http://schemas.datastream.net/MP_fields\">" + kit + "</KIT> \n" +
                "  <SAVEHISTORY xmlns=\"http://schemas.datastream.net/MP_fields\">" + saveHistory + "</SAVEHISTORY> \n" +
                "  <OUTOFSERVICE xmlns=\"http://schemas.datastream.net/MP_fields\">" + outOfService + "</OUTOFSERVICE> \n" +
                "  <INSPECTIONREQUIRED xmlns=\"http://schemas.datastream.net/MP_fields\">" + inspectionRequired + "</INSPECTIONREQUIRED> \n" +
                "  <REPAIRABLE xmlns=\"http://schemas.datastream.net/MP_fields\">" + repairable + "</REPAIRABLE> \n" +
                "  <CALIBRATIONSTANDARD xmlns=\"http://schemas.datastream.net/MP_fields\">" + calibrationStandard + "</CALIBRATIONSTANDARD> \n" +
                "  <PREVENTREORDERS xmlns=\"http://schemas.datastream.net/MP_fields\">" + preventReorders+ "</PREVENTREORDERS> \n" +
                " <Profile recordid=\"1\" user_entity=\"user_entity1\" system_entity=\"system_entity1\" xmlns=\"http://schemas.datastream.net/MP_entities/Profile_001\">\n" +
                " <PROFILEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <OBJECTCODE>" + objectCode + "</OBJECTCODE> \n" +
                " <ORGANIZATIONID entity=\"Equipment\">\n" +
                "  <ORGANIZATIONCODE>" + profileOrganization + "</ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION>" + profileDescription + "</DESCRIPTION> \n" +
                "  </PROFILEID>\n" +
                " <TYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <TYPECODE>" + typeCode + "</TYPECODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </TYPE>\n" +
                " <CLASSID entity=\"ent2\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <CLASSCODE>" + classIdCode + "</CLASSCODE> \n" +
                " <ORGANIZATIONID entity=\"AssetEquipment\">\n" +
                "  <ORGANIZATIONCODE>" + classIdOrganization + "</ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION>" + classIdDescription + "</DESCRIPTION> \n" +
                "  </CLASSID>\n" +
                " <STATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <STATUSCODE>" + statusCode + "</STATUSCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </STATUS>\n" +
                " <DEPARTMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <DEPARTMENTCODE>" + departmentCode + "</DEPARTMENTCODE> \n" +
                " <ORGANIZATIONID entity=\"PositionEquipment\">\n" +
                "  <ORGANIZATIONCODE>" + departmentOrganization + "</ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION>" + departmentDescription + "</DESCRIPTION> \n" +
                "  </DEPARTMENTID>\n" +
                " <CATEGORYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <CATEGORYCODE>" + categoryIdCode + "</CATEGORYCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </CATEGORYID>\n" +
                " <COSTCODEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <COSTCODE>" + costCode + "</COSTCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                " <ORGANIZATIONID entity=\"PositionEquipmentDefault\">\n" +
                "  <ORGANIZATIONCODE>" + costOrganization + "</ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  </COSTCODEID>\n" +
                " <STOREID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <STORECODE>" + storeCode + "</STORECODE> \n" +
                " <ORGANIZATIONID entity=\"SystemEquipment\">\n" +
                "  <ORGANIZATIONCODE>" + storeOrganization + "</ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION>" + storeDescription + "</DESCRIPTION> \n" +
                "  </STOREID>\n" +
                " <PARTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <PARTCODE>" + partIdCode + "</PARTCODE> \n" +
                " <ORGANIZATIONID entity=\"SystemEquipmentDefault\">\n" +
                "  <ORGANIZATIONCODE>" + partIdOrganization + "</ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION>" + partIdDescription + "</DESCRIPTION> \n" +
                "  </PARTID>\n" +
                "  <METERUNIT xmlns=\"http://schemas.datastream.net/MP_fields\">" + meterUnit +"</METERUNIT> \n" +
                " <ManufacturerInfo>\n" +
                "  <MANUFACTURERCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + manufacturerCode + "</MANUFACTURERCODE> \n" +
                "  <SERIALNUMBER xmlns=\"http://schemas.datastream.net/MP_fields\">" + serialNumber + "</SERIALNUMBER> \n" +
                "  <MODEL xmlns=\"http://schemas.datastream.net/MP_fields\">" + model + "</MODEL> \n" +
                "  <MODELREVISION xmlns=\"http://schemas.datastream.net/MP_fields\">" + modelRevision + "</MODELREVISION> \n" +
                "  </ManufacturerInfo>\n" +
                "  <CNNUMBER xmlns=\"http://schemas.datastream.net/MP_fields\">" + cnNumber + "</CNNUMBER> \n" +
                " <Variables>\n" +
                "  <VARIABLE1></VARIABLE1> \n" +
                "  <VARIABLE2></VARIABLE2> \n" +
                "  <VARIABLE3></VARIABLE3> \n" +
                "  <VARIABLE4></VARIABLE4> \n" +
                "  <VARIABLE5></VARIABLE5> \n" +
                "  <VARIABLE6></VARIABLE6> \n" +
                "  </Variables>\n" +
                "  </Profile>\n" +
                " <USERDEFINEDAREA customfieldlimitexceeded=\"cust1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                " <CUSTOMFIELD index=\"1\" entity=\"entity1\" type=\"type1\" changed=\"chan1\">\n" +
                "  <PROPERTYCODE>" + propertyCode + "</PROPERTYCODE> \n" +
                "  <PROPERTYLABEL>" + propertyLabel + "</PROPERTYLABEL> \n" +
                " <CLASSID entity=\"ent3\">\n" +
                "  <CLASSCODE>" + UserDefinedClassCode + "</CLASSCODE> \n" +
                " <ORGANIZATIONID entity=\"Location\">\n" +
                "  <ORGANIZATIONCODE>" + UserDefinedClassOrg + "</ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION>" + UserDefinedClassDescription + "</DESCRIPTION> \n" +
                "  </CLASSID>\n" +
                " <DATEFIELD qualifier=\"ACCOUNTING\">\n" +
                "  <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR> \n" +
                "  <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH> \n" +
                "  <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY> \n" +
                "  <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR> \n" +
                "  <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE> \n" +
                "  <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND> \n" +
                "  <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND> \n" +
                "  <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE> \n" +
                "  </DATEFIELD>\n" +
                "  <MAXVALUE></MAXVALUE> \n" +
                "  <MINVALUE></MINVALUE> \n" +
                "  <UOM></UOM> \n" +
                " <LOVSETTINGS>\n" +
                "  <LOV_TYPE></LOV_TYPE> \n" +
                "  <LOV_VALIDATE></LOV_VALIDATE> \n" +
                "  </LOVSETTINGS>\n" +
                " <VALUESOURCE>\n" +
                "  <CATVALUE></CATVALUE> \n" +
                "  <NONUPDATEABLE></NONUPDATEABLE> \n" +
                "  </VALUESOURCE>\n" +
                "  <GROUPLABEL></GROUPLABEL> \n" +
                "  </CUSTOMFIELD>\n" +
                "  <STATUSCODE></STATUSCODE> \n" +
                "  </USERDEFINEDAREA>\n" +
                " <PRIMARYMANUFACTURERID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <MANUFACTURERCODE></MANUFACTURERCODE> \n" +
                " <ORGANIZATIONID entity=\"WorkRequest\">\n" +
                "  <ORGANIZATIONCODE></ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </PRIMARYMANUFACTURERID>\n" +
                "  <PRIMARYMANUFACTURERPARTCODE xmlns=\"http://schemas.datastream.net/MP_fields\"></PRIMARYMANUFACTURERPARTCODE> \n" +
                " <VMRSCODE xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                " <SYSTEMLEVELID>\n" +
                "  <SYSTEMLEVELCODE></SYSTEMLEVELCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </SYSTEMLEVELID>\n" +
                "  </VMRSCODE>\n" +
                "  <FUGITIVEGAS xmlns=\"http://schemas.datastream.net/MP_fields\"></FUGITIVEGAS> \n" +
                "  <TRACKBYCONDITION xmlns=\"http://schemas.datastream.net/MP_fields\"></TRACKBYCONDITION> \n" +
                " <PARTCONDITIONTEMPLATEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <PARTCONDITIONTEMPLATECODE></PARTCONDITIONTEMPLATECODE> \n" +
                " <ORGANIZATIONID entity=\"Requisition\">\n" +
                "  <ORGANIZATIONCODE></ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </PARTCONDITIONTEMPLATEID>\n" +
                "  <PARENTPART xmlns=\"http://schemas.datastream.net/MP_fields\"></PARENTPART> \n" +
                "  <PARTCONDITIONTEMPLATECONDITIONCODE xmlns=\"http://schemas.datastream.net/MP_fields\"></PARTCONDITIONTEMPLATECONDITIONCODE> \n" +
                " <SAFETYDATEREVIEWREQUIRED qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR> \n" +
                "  <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH> \n" +
                "  <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY> \n" +
                "  <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR> \n" +
                "  <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE> \n" +
                "  <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND> \n" +
                "  <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND> \n" +
                "  <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE> \n" +
                "  </SAFETYDATEREVIEWREQUIRED>\n" +
                " <SAFETYREVIEWEDBY xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <USERCODE></USERCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </SAFETYREVIEWEDBY>\n" +
                "  <LONGDESCRIPTION xmlns=\"http://schemas.datastream.net/MP_fields\"></LONGDESCRIPTION> \n" +
                "  <DOCUMOTOBOOKID xmlns=\"http://schemas.datastream.net/MP_fields\"></DOCUMOTOBOOKID> \n" +
                "  <DOCUMOTOPARTID xmlns=\"http://schemas.datastream.net/MP_fields\"></DOCUMOTOPARTID> \n" +
                " <NONCONFORMITYIMPORTANCE xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <ENTITY></ENTITY> \n" +
                "  <USERDEFINEDCODE></USERDEFINEDCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </NONCONFORMITYIMPORTANCE>\n" +
                " <MATERIALTYPE xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <ENTITY></ENTITY> \n" +
                "  <USERDEFINEDCODE></USERDEFINEDCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </MATERIALTYPE>\n" +
                " <PROFILEPICTURE xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <DOCUMENTCODE></DOCUMENTCODE> \n" +
                " <ORGANIZATIONID entity=\"RequisitionDefault\">\n" +
                "  <ORGANIZATIONCODE></ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION></DESCRIPTION> \n" +
                "  </PROFILEPICTURE>\n" +
                "  <AVAILABLEFORCUS xmlns=\"http://schemas.datastream.net/MP_fields\">false</AVAILABLEFORCUS> \n" +
                " <UserDefinedFields>\n" +
                "  <UDFCHAR01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR01 + "</UDFCHAR01> \n" +
                "  <UDFCHAR02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR02 + "</UDFCHAR02> \n" +
                "  <UDFCHAR03 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR03 + "</UDFCHAR03> \n" +
                "  <UDFCHAR04 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR04 + "</UDFCHAR04> \n" +
                "  <UDFCHAR05 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR05 + "</UDFCHAR05> \n" +
                "  <UDFCHAR06 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR06 + "</UDFCHAR06> \n" +
                "  <UDFCHAR07 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR07 + "</UDFCHAR07> \n" +
                "  <UDFCHAR08 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR08 + "</UDFCHAR08> \n" +
                "  <UDFCHAR09 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR09 + "</UDFCHAR09> \n" +
                "  <UDFCHAR10 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR10 + "</UDFCHAR10> \n" +
                "  <UDFCHAR11 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR11 + "</UDFCHAR11> \n" +
                "  <UDFCHAR12 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR12 + "</UDFCHAR12> \n" +
                "  <UDFCHAR13 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR13 + "</UDFCHAR13> \n" +
                "  <UDFCHAR14 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR14 + "</UDFCHAR14> \n" +
                "  <UDFCHAR15 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR15 + "</UDFCHAR15> \n" +
                "  <UDFCHAR16 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR16 + "</UDFCHAR16> \n" +
                "  <UDFCHAR17 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR17 + "</UDFCHAR17> \n" +
                "  <UDFCHAR18 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR18 + "</UDFCHAR18> \n" +
                "  <UDFCHAR19 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR19 + "</UDFCHAR19> \n" +
                "  <UDFCHAR20 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR20 + "</UDFCHAR20> \n" +
                "  <UDFCHAR21 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR21 + "</UDFCHAR21> \n" +
                "  <UDFCHAR22 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR22 + "</UDFCHAR22> \n" +
                "  <UDFCHAR23 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR23 + "</UDFCHAR23> \n" +
                "  <UDFCHAR24 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR24 + "</UDFCHAR24> \n" +
                "  <UDFCHAR25 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR25 + "</UDFCHAR25> \n" +
                "  <UDFCHAR26 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR26 + "</UDFCHAR26> \n" +
                "  <UDFCHAR27 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR27 + "</UDFCHAR27> \n" +
                "  <UDFCHAR28 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR28 + "</UDFCHAR28> \n" +
                "  <UDFCHAR29 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR29 + "</UDFCHAR29> \n" +
                "  <UDFCHAR30 xmlns=\"http://schemas.datastream.net/MP_fields\">" + UDFCHAR30 + "</UDFCHAR30> \n" +
                "  <UDFNUM01 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE> \n" +
                "  <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC> \n" +
                "  <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">SIGN1</SIGN> \n" +
                "  <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">UOM1</UOM> \n" +
                "  </UDFNUM01>\n" +
                "  <UDFNUM02 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE> \n" +
                "  <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC> \n" +
                "  <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">SIGN1</SIGN> \n" +
                "  <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">UOM1</UOM> \n" +
                "  </UDFNUM02>\n" +
                "  <UDFNUM03 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE> \n" +
                "  <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC> \n" +
                "  <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">SIGN1</SIGN> \n" +
                "  <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">UOM1</UOM> \n" +
                "  </UDFNUM03>\n" +
                "  <UDFNUM04 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE> \n" +
                "  <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC> \n" +
                "  <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">SIGN1</SIGN> \n" +
                "  <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">UOM1</UOM> \n" +
                "  </UDFNUM04>\n" +
                "  <UDFNUM05 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE> \n" +
                "  <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">1</NUMOFDEC> \n" +
                "  <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">SIGN1</SIGN> \n" +
                "  <UOM xmlns=\"http://www.openapplications.org/oagis_fields\">UOM1</UOM> \n" +
                "  </UDFNUM05>\n" +
                "  <UDFDATE01 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR> \n" +
                "  <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH> \n" +
                "  <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY> \n" +
                "  <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR> \n" +
                "  <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE> \n" +
                "  <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND> \n" +
                "  <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND> \n" +
                "  <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE> \n" +
                "  </UDFDATE01>\n" +
                "  <UDFDATE02 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR> \n" +
                "  <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH> \n" +
                "  <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY> \n" +
                "  <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR> \n" +
                "  <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE> \n" +
                "  <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND> \n" +
                "  <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND> \n" +
                "  <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE> \n" +
                "  </UDFDATE02>\n" +
                "  <UDFDATE03 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR> \n" +
                "  <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH> \n" +
                "  <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY> \n" +
                "  <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR> \n" +
                "  <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE> \n" +
                "  <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND> \n" +
                "  <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND> \n" +
                "  <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE> \n" +
                "  </UDFDATE03>\n" +
                "  <UDFDATE04 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR> \n" +
                "  <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH> \n" +
                "  <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY> \n" +
                "  <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR> \n" +
                "  <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE> \n" +
                "  <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND> \n" +
                "  <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND> \n" +
                "  <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE> \n" +
                "  </UDFDATE04>\n" +
                "  <UDFDATE05 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR> \n" +
                "  <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH> \n" +
                "  <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY> \n" +
                "  <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR> \n" +
                "  <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE> \n" +
                "  <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND> \n" +
                "  <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND> \n" +
                "  <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE> \n" +
                "  </UDFDATE05>\n" +
                "  <UDFCHKBOX01 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHKBOX01> \n" +
                "  <UDFCHKBOX02 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHKBOX02> \n" +
                "  <UDFCHKBOX03 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHKBOX03> \n" +
                "  <UDFCHKBOX04 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHKBOX04> \n" +
                "  <UDFCHKBOX05 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFCHKBOX05> \n" +
                "  <UDFNOTE01 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFNOTE01> \n" +
                "  <UDFNOTE02 xmlns=\"http://schemas.datastream.net/MP_fields\"></UDFNOTE02> \n" +
                "  </UserDefinedFields>\n" +
                "  </Part>\n" +
                "  </MP0240_AddPart_001>\n" +
                "  </Body>" +
                "    </Body>\n" +
                "</Envelope>";

    }
}
