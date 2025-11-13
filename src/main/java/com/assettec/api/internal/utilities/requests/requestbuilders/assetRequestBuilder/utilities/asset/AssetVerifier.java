package com.assettec.api.internal.utilities.requests.requestbuilders.assetRequestBuilder.utilities.asset;

import com.assettec.api.internal.core.entities.asset.equipment.AssetEquipment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AssetVerifier {

    public String addAssetId(AssetEquipment asset) {
        return "<ASSETID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<EQUIPMENTCODE>" + asset.getCode() + "</EQUIPMENTCODE>" +
                "<ORGANIZATIONID entity=\"User\">" +
                "<ORGANIZATIONCODE>" + asset.getOrganization() + "</ORGANIZATIONCODE>" +
                "</ORGANIZATIONID>" +
                "<DESCRIPTION>" + asset.getDescription() + "</DESCRIPTION>" +
                "</ASSETID>";
    }

    public String addType(AssetEquipment asset) {
        return "<TYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<TYPECODE>" + asset.getType() + "</TYPECODE>" +
                "</TYPE>";
    }

    public String addClassId(AssetEquipment asset) {
        if (asset.getEquipmentClass() == null) return "";

        String organization, organizationDescription, organizationCode, description, classCode, classId;

        organizationDescription = (asset.getEquipmentClass().getOrganization().getDescription().isEmpty()) ? "" : "<DESCRIPTION>" + asset.getEquipmentClass().getOrganization().getDescription() + "</DESCRIPTION>";
        organizationCode = (asset.getEquipmentClass().getOrganization().getCode().isEmpty()) ? "" : "<ORGANIZATIONCODE>" + asset.getEquipmentClass().getOrganization().getCode() + "</ORGANIZATIONCODE>";
        organization = (organizationCode.equals("") && organizationDescription.equals("")) ? "" : "<ORGANIZATIONID entity=\"Organization\">" + organizationCode + organizationDescription + "</ORGANIZATIONID>";
        description = asset.getEquipmentClass().getDescription().isEmpty() ? "" : "<DESCRIPTION>" + asset.getEquipmentClass().getDescription() + "</DESCRIPTION>";
        classCode = asset.getEquipmentClass().getCode().isEmpty() ? "" : "<CLASSCODE>" + asset.getEquipmentClass().getCode() + "</CLASSCODE>";
        classId = classCode.isEmpty() && organization.isEmpty() && description.isEmpty() ? "" : "<CLASSID entity=\"ent1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + classCode + organization + description + "</CLASSID>";

        return classId;
    }

    public String addStatus(AssetEquipment asset) {
        return "<STATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<STATUSCODE>" + asset.getStatus() + "</STATUSCODE>" +
                "</STATUS>";
    }

    public String addDepartment(AssetEquipment asset) {

        String departmentId, departmentCode, organization, organizationCode, organizationDescription, description;

        departmentCode = asset.getDepartmentId().getCode().isEmpty() ? "" : "<DEPARTMENTCODE>" + asset.getDepartmentId().getCode() + "</DEPARTMENTCODE>";
        organizationCode = asset.getDepartmentId().getOrganization() == null || asset.getDepartmentId().getOrganization().getCode().isEmpty() ? "" : "<ORGANIZATIONCODE>" + asset.getDepartmentId().getOrganization().getCode() + "</ORGANIZATIONCODE>";
        organizationDescription = asset.getDepartmentId().getOrganization() == null || asset.getDepartmentId().getOrganization().getDescription().isEmpty() ? "" : "<DESCRIPTION>" + asset.getDepartmentId().getOrganization().getDescription() + "</DESCRIPTION>";
        organization = organizationCode.isEmpty() && organizationDescription.isEmpty() ? "" : "<ORGANIZATIONID entity=\"Group\">" + organizationCode + organizationDescription + "</ORGANIZATIONID>";
        description = asset.getDepartmentId().getDescription().isEmpty() ? "" : "<DESCRIPTION>" + asset.getDepartmentId().getDescription() + "</DESCRIPTION>";
        departmentId = departmentCode.isEmpty() && organization.isEmpty() && description.isEmpty() ? "" : "<DEPARTMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">" + departmentCode + organization + description + "</DEPARTMENTID>";

        return departmentId;
    }

    public String addOperationalStatus(AssetEquipment asset) {

        if (asset.getOperationalStatus() == null) return "";

        String status, description, operational;

        status = asset.getOperationalStatus().getCode().isEmpty() ? "" : "<STATUSCODE>" + asset.getOperationalStatus().getCode() + "</STATUSCODE>";
        description = asset.getOperationalStatus().getDescription().isEmpty() ? "" : "<DESCRIPTION>" + asset.getOperationalStatus().getDescription() + "</DESCRIPTION>";
        operational = status.isEmpty() && description.isEmpty() ? "" : "<OPERATIONALSTATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + status + description + "</OPERATIONALSTATUS>";

        return operational;
    }

    public String addLoanedToDepartment(AssetEquipment asset) {

        if (asset.getLoanedToDepartment() == null) return "";

        String depCode, orgCode, orgDesc, org, desc, loaned;

        depCode = asset.getLoanedToDepartment().getCode().isEmpty() ? "" : "<DEPARTMENTCODE>" + asset.getLoanedToDepartment().getCode() + "</DEPARTMENTCODE>";
        orgCode = asset.getLoanedToDepartment().getOrganization().getCode().isEmpty() ? "" : "<ORGANIZATIONCODE>" + asset.getLoanedToDepartment().getOrganization().getCode() + "</ORGANIZATIONCODE>";
        orgDesc = asset.getLoanedToDepartment().getOrganization().getDescription().isEmpty() ? "" : "<DESCRIPTION>" + asset.getLoanedToDepartment().getOrganization().getDescription() + "</DESCRIPTION>";
        org = orgDesc.isEmpty() && orgCode.isEmpty() ? "" : "<ORGANIZATIONID entity=\"Class\">" + orgCode + orgDesc + "</ORGANIZATIONID>";
        desc = asset.getLoanedToDepartment().getDescription().isEmpty() ? "" : "<DESCRIPTION>" + asset.getLoanedToDepartment().getDescription() + "</DESCRIPTION>";
        loaned = depCode.isEmpty() && org.isEmpty() && desc.isEmpty() ? "" : "<LOANEDTODEPARTMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">" + depCode + org + desc + "</LOANEDTODEPARTMENTID>";

        return loaned;
    }

    public String addPmWoDepartment(AssetEquipment asset) {

        if (asset.getPmWoDepartment() == null) return "";

        String pmwo, depCode, orgCode, orgDesc, org, desc;

        depCode = asset.getPmWoDepartment().getCode() == null ? "" : "<DEPARTMENTCODE>" + asset.getPmWoDepartment().getCode() + "</DEPARTMENTCODE>";
        orgCode = asset.getPmWoDepartment().getOrganization() == null || asset.getPmWoDepartment().getOrganization().getCode() == null ? "" : "<ORGANIZATIONCODE>" + asset.getPmWoDepartment().getOrganization().getCode() + "</ORGANIZATIONCODE>";
        orgDesc = asset.getPmWoDepartment().getOrganization() == null || asset.getPmWoDepartment().getOrganization().getDescription() == null ? "" : "<DESCRIPTION>" + asset.getPmWoDepartment().getOrganization().getDescription() + "</DESCRIPTION>";
        org = orgCode.isEmpty() && orgDesc.isEmpty() ? "" : "<ORGANIZATIONID entity=\"Department\">" + orgCode + orgDesc + "</ORGANIZATIONID>";
        desc = asset.getPmWoDepartment().getDescription() == null ? "" : "<DESCRIPTION>" + asset.getPmWoDepartment().getDescription() + "</DESCRIPTION>";
        pmwo = depCode.isEmpty() && org.isEmpty() && desc.isEmpty() ? "" : "<PMWODEPARTMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">" + depCode + org + desc + "</PMWODEPARTMENTID>";

        return pmwo;
    }

    public String addCategory(AssetEquipment asset) {

        if (asset.getCategory() == null) return "";

        String cat, catCode, catDesc;

        catCode = asset.getCategory().getCode() == null ? "" : "<CATEGORYCODE>" + asset.getCategory().getCode() + "</CATEGORYCODE>";
        catDesc = asset.getCategory().getDescription() == null ? "" : "<DESCRIPTION>" + asset.getCategory().getDescription() + "</DESCRIPTION>";
        cat = catCode.isEmpty() && catDesc.isEmpty() ? "" : "<CATEGORYID xmlns=\"http://schemas.datastream.net/MP_fields\">" + catCode + catDesc + "</CATEGORYID>";

        return cat;
    }

    public String addProfileId(AssetEquipment asset) {

        if (asset.getProfile() == null) return "";

        String profile, objCode, org, orgCode, orgDesc, desc;

        objCode = asset.getProfile().getCode() == null ? "" : "<OBJECTCODE>" + asset.getProfile().getCode() + "</OBJECTCODE>";
        orgCode = asset.getProfile().getOrganization() == null || asset.getProfile().getOrganization().getCode() == null ? "" : "<ORGANIZATIONCODE>" + asset.getProfile().getOrganization().getCode() + "</ORGANIZATIONCODE>";
        orgDesc = asset.getProfile().getOrganization() == null || asset.getProfile().getOrganization().getDescription() == null ? "" : "<DESCRIPTION>" + asset.getProfile().getOrganization().getDescription() + "</DESCRIPTION>";
        org = orgCode.isEmpty() && orgDesc.isEmpty() ? "" : "<ORGANIZATIONID entity=\"Personnel\">" + orgCode + orgDesc + "</ORGANIZATIONID>";
        desc = asset.getProfile().getDescription() == null ? "" : "<DESCRIPTION>" + asset.getProfile().getDescription() + "</DESCRIPTION>";
        profile = objCode.isEmpty() && org.isEmpty() && desc.isEmpty() ? "" : "<PROFILEID xmlns=\"http://schemas.datastream.net/MP_fields\">" + objCode + org + desc + "</PROFILEID>";

        return profile;
    }

    public String addInProductionSafetyOutOfService(AssetEquipment asset) {

        String prod, saf, out;

        prod = asset.getInProduction() == null ? "" : "<INPRODUCTION xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getInProduction() + "</INPRODUCTION>";
        saf = asset.getSafety() == null ? "" : "<SAFETY xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getSafety() + "</SAFETY>";
        out = asset.getOutOfService() == null ? "" : "<OUTOFSERVICE xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getOutOfService() + "</OUTOFSERVICE>";

        return prod + saf + out;
    }

    public String addCostCode(AssetEquipment asset) {

        if (asset.getCostId() == null) return "";

        String costId, costCode, desc, org, orgCode, orgDesc;

        costCode = asset.getCostId().getCode() == null ? "" : "<COSTCODE>" + asset.getCostId().getCode() + "</COSTCODE>";
        desc = asset.getCostId().getDescription() == null ? "" : "<DESCRIPTION>" + asset.getCostId().getDescription() + "</DESCRIPTION>";
        orgCode = asset.getCostId().getOrganization() == null || asset.getCostId().getOrganization().getCode() == null ? "" : "<ORGANIZATIONCODE>" + asset.getCostId().getOrganization().getCode() + "</ORGANIZATIONCODE>";
        orgDesc = asset.getCostId().getOrganization() == null || asset.getCostId().getOrganization().getDescription() == null ? "" : "<DESCRIPTION>" + asset.getCostId().getOrganization().getDescription() + "</DESCRIPTION>";
        org = orgCode.isEmpty() && orgDesc.isEmpty() ? "" : "<ORGANIZATIONID entity=\"OrganizationValidity\">" + orgCode + orgDesc + "</ORGANIZATIONID>";
        costId = costCode.isEmpty() && desc.isEmpty() && org.isEmpty() ? "" : "<COSTCODEID xmlns=\"http://schemas.datastream.net/MP_fields\">" + costCode + desc + org + "</COSTCODEID>";

        return costId;
    }

    public String addCommissionDate(AssetEquipment asset) {
        if (asset.getCommissionDateNew() == null) return "";
        return "<COMMISSIONDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCommissionDateNew().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCommissionDateNew().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCommissionDateNew().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCommissionDateNew().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCommissionDateNew().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCommissionDateNew().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCommissionDateNew().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCommissionDateNew().getTimeZone() + "</TIMEZONE>" +
                "</COMMISSIONDATE>";
    }

    public String addTransferDate(AssetEquipment asset) {
        if (asset.getTransferDateNew() == null)
            return "";
        return "<TRANSFERDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getTransferDateNew().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getTransferDateNew().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getTransferDateNew().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getTransferDateNew().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getTransferDateNew().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getTransferDateNew().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getTransferDateNew().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getTransferDateNew().getTimeZone() + "</TIMEZONE>" +
                "</TRANSFERDATE>";
    }

    public String addWithdrawalDate(AssetEquipment asset) {
        if (asset.getWithdrawalDateNew() == null)
            return "";
        return "<WITHDRAWALDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getWithdrawalDateNew().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getWithdrawalDateNew().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getWithdrawalDateNew().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getWithdrawalDateNew().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getWithdrawalDateNew().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getWithdrawalDateNew().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getWithdrawalDateNew().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getWithdrawalDateNew().getTimeZone() + "</TIMEZONE>" +
                "</WITHDRAWALDATE>";
    }

    public String addAssetValue(AssetEquipment asset) {
        if (asset.getAssetValue() == null) return "";
        return "<ASSETVALUE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getAssetValue().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getAssetValue().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getAssetValue().getSign() + "</SIGN>" +
                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getAssetValue().getCurrency() + "</CURRENCY>" +
                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getAssetValue().getDRCR() + "</DRCR>" +
                "</ASSETVALUE>";
    }

    public String addAssignedTo(AssetEquipment asset) {
        if (asset.getAssignedToNew() == null) return "";

        String code, desc, ass;

        code = asset.getAssignedToNew().getCode().isEmpty() ? "" : "<PERSONCODE>" + asset.getAssignedToNew().getCode() + "</PERSONCODE>";
        desc = asset.getAssignedToNew().getDescription().isEmpty() ? "" : "<DESCRIPTION>" + asset.getAssignedToNew().getDescription() + "</DESCRIPTION>";
        ass = code.isEmpty() && desc.isEmpty() ? "" : "<ASSIGNEDTO xmlns=\"http://schemas.datastream.net/MP_fields\">" + code + desc + "</ASSIGNEDTO>";

        return ass;
    }

    public String addMeterUnit(AssetEquipment asset) {
        if (asset.getMeterUnit() == null) return "";
        return "<METERUNIT xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getMeterUnit() + "</METERUNIT>";
    }

    public String addCriticality(AssetEquipment asset) {
        if (asset.getCriticality() == null) return "";
        if (asset.getCriticality().getCode().isEmpty() && asset.getCriticality().getDescription().isEmpty()) return "";
        if (asset.getCriticality().getCode().isEmpty() && !asset.getCriticality().getDescription().isEmpty())
            return "<CRITICALITYID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                    "<CRITICALITY>" + asset.getCriticality().getCode() + "</CRITICALITY>" +
                    "</CRITICALITYID>";
        return "<CRITICALITYID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<CRITICALITY>" + asset.getCriticality().getCode() + "</CRITICALITY>" +
                "<DESCRIPTION>" + asset.getCriticality().getDescription() + "</DESCRIPTION>" +
                "</CRITICALITYID>";
    }

    public String addSoldDate(AssetEquipment asset) {
        if (asset.getSoldDate() == null) return "";
        return "<SOLDDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getSoldDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getSoldDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getSoldDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getSoldDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getSoldDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getSoldDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getSoldDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getSoldDate().getTimeZone() + "</TIMEZONE>" +
                "</SOLDDATE>";
    }

    public String addDormant(AssetEquipment asset) {
        if (asset.getDormantStart() == null && asset.getDormantEnd() == null && asset.getDormantReuse() == null)
            return "";
        String dormantStart = asset.getDormantStart() == null ? "" : "<DORMANTSTART qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getDormantStart().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getDormantStart().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getDormantStart().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getDormantStart().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getDormantStart().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getDormantStart().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getDormantStart().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getDormantStart().getTimeZone() + "</TIMEZONE>" +
                "</DORMANTSTART>";

        String dormantEnd = asset.getDormantEnd() == null ? "" : "<DORMANTEND qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getDormantEnd().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getDormantEnd().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getDormantEnd().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getDormantEnd().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getDormantEnd().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getDormantEnd().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getDormantEnd().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getDormantEnd().getTimeZone() + "</TIMEZONE>" +
                "</DORMANTEND>";

        String dormantReuse = asset.getDormantReuse() == null ? "" : "<DORMANTREUSE xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getDormantReuse() + "</DORMANTREUSE>";
        return "<DORMANT>" +
                dormantStart +
                dormantEnd +
                dormantReuse +
                "</DORMANT>";
    }

    public String addInventoryVerificationDate(AssetEquipment asset) {
        if (asset.getInventoryVerificationDate() == null) return "";
        return "<INVENTORYVERIFICATIONDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getInventoryVerificationDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getInventoryVerificationDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getInventoryVerificationDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getInventoryVerificationDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getInventoryVerificationDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getInventoryVerificationDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getInventoryVerificationDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getInventoryVerificationDate().getTimeZone() + "</TIMEZONE>" +
                "</INVENTORYVERIFICATIONDATE>";
    }

//    public String addPartAssociation(AssetEquipment asset) {
//        return "<PartAssociation is_bylot=\"is_b1\">" +
//                "<PARTID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<PARTCODE>" + asset.getAssociatedPart().getCode() + "</PARTCODE>" +
//                "<ORGANIZATIONID entity=\"Equipment\">" +
//                "<ORGANIZATIONCODE>" + asset.getAssociatedPart().getOrganization() + "</ORGANIZATIONCODE>" +
//                "</ORGANIZATIONID>" +
//                "<DESCRIPTION>" + asset.getAssociatedPart().getDescription() + "</DESCRIPTION>" +
//                "</PARTID>" +
//                "<STORELOCATION xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<STOREID>" +
//                "<STORECODE>" + asset.getStoreLocation().getCode() + "</STORECODE>" +
//                "<ORGANIZATIONID entity=\"AssetEquipment\">" +
//                "<ORGANIZATIONCODE>" + asset.getStoreLocation().getOrganization() + "</ORGANIZATIONCODE>" +
//                "</ORGANIZATIONID>" +
//                "<DESCRIPTION>" + asset.getStoreLocation().getDescription() + "</DESCRIPTION>" +
//                "</STOREID>" +
////                "<BIN>" + asset.getAssociatedPart().getBin() + "</BIN>" +
////                "<LOT>" + asset.getAssociatedPart().getLot() + "</LOT>" +
//                "</STORELOCATION>" +
//                "</PartAssociation>";
//    }

    public String addManufacturerInfo(AssetEquipment asset) {

        String info, manuCode, serial, model, moRev, xco, yco, zco;

        manuCode = asset.getManufacturerCode() == null ? "" : "<MANUFACTURERCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getManufacturerCode() + "</MANUFACTURERCODE>";
        serial = asset.getSerialnumber() == null ? "" : "<SERIALNUMBER xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getSerialnumber() + "</SERIALNUMBER>";
        model = asset.getModel() == null ? "" : "<MODEL xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getModel() + "</MODEL>";
        moRev = asset.getModelRevision() == null ? "" : "<MODELREVISION xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getModelRevision() + "</MODELREVISION>";
        xco = asset.getXCoordinate() == null ? "" : "<XCOORDINATE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getXCoordinate().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getXCoordinate().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getXCoordinate().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getXCoordinate().getUom() + "</UOM>" +
                "</XCOORDINATE>";

        yco = asset.getYCoordinate() == null ? "" : "<YCOORDINATE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getYCoordinate().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getYCoordinate().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getYCoordinate().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getYCoordinate().getUom() + "</UOM>" +
                "</YCOORDINATE>";

        zco = asset.getZCoordinate() == null ? "" : "<ZCOORDINATE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getZCoordinate().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getZCoordinate().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getZCoordinate().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getZCoordinate().getUom() + "</UOM>" +
                "</ZCOORDINATE>";

        info = manuCode.isEmpty() && serial.isEmpty() && model.isEmpty() && moRev.isEmpty() && xco.isEmpty() && yco.isEmpty() && zco.isEmpty() ? "" : "<ManufacturerInfo>" + manuCode + serial + model + moRev + xco + yco + zco + "</ManufacturerInfo>";
        return info;
    }

    public String addFleetVehicleInfo(AssetEquipment asset) {

        String info, isVehicle, fleetCustomerId, billingId, markupId, status, type, issueTo;

        isVehicle = asset.getIsVehicle() == null ? "" : "<ISVEHICLE xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getIsVehicle() + "</ISVEHICLE>";

        fleetCustomerId = asset.getFleetCustomer() == null ? "" : "<FLEETCUSTOMERID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<FLEETCUSTOMERCODE>" + asset.getFleetCustomer().getCode() + "</FLEETCUSTOMERCODE>" +
                "<DESCRIPTION>" + asset.getFleetCustomer().getDescription() + "</DESCRIPTION>" +
                "<ORGANIZATIONID entity=\"PositionEquipment\">" +
                "<ORGANIZATIONCODE>" + asset.getFleetCustomer().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + asset.getFleetCustomer().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>" +
                "</FLEETCUSTOMERID>";

        billingId = asset.getFleetBilling() == null ? "" : "<FLEETBILLINGID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<FLEETBILLINGCODE>" + asset.getFleetBilling().getCode() + "</FLEETBILLINGCODE>" +
                "<ORGANIZATIONID entity=\"PositionEquipmentDefault\">" +
                "<ORGANIZATIONCODE>" + asset.getFleetBilling().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + asset.getFleetBilling().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>" +
                "<DESCRIPTION>" + asset.getFleetBilling().getDescription() + "</DESCRIPTION>" +
                "</FLEETBILLINGID>";

        markupId = asset.getFleetMarkUp() == null ? "" : "<FLEETMARKUPID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<FLEETMARKUPCODE>" + asset.getFleetMarkUp().getCode() + "</FLEETMARKUPCODE>" +
                "<ORGANIZATIONID entity=\"SystemEquipment\">" +
                "<ORGANIZATIONCODE>" + asset.getFleetMarkUp().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + asset.getFleetMarkUp().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>" +
                "<DESCRIPTION>" + asset.getFleetMarkUp().getDescription() + "</DESCRIPTION>" +
                "</FLEETMARKUPID>";

        status = asset.getVehicleStatus() == null ? "" : "<VEHICLESTATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<STATUSCODE>" + asset.getVehicleStatus().getCode() + "</STATUSCODE>" +
                "<DESCRIPTION>" + asset.getVehicleStatus().getDescription() + "</DESCRIPTION>" +
                "</VEHICLESTATUS>";

        type = asset.getVehicleType() == null ? "" : "<VEHICLETYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<TYPECODE>" + asset.getVehicleType().getCode() + "</TYPECODE>" +
                "<DESCRIPTION>" + asset.getVehicleType().getDescription() + "</DESCRIPTION>" +
                "</VEHICLETYPE>";

        issueTo = asset.getIssueTo() == null ? "" : "<ISSUETO xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<PERSONCODE>" + asset.getIssueTo().getCode() + "</PERSONCODE>" +
                "<DESCRIPTION>" + asset.getIssueTo().getDescription() + "</DESCRIPTION>" +
                "</ISSUETO>";

        String rentalTemplateId = asset.getRentalTemplate() == null ? "" : "<RENTALTEMPLATEID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<RENTALTEMPLATECODE>" + asset.getRentalTemplate().getCode() + "</RENTALTEMPLATECODE>" +
                "<ORGANIZATIONID entity=\"SystemEquipmentDefault\">" +
                "<ORGANIZATIONCODE>" + asset.getRentalTemplate().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + asset.getRentalTemplate().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>" +
                "<DESCRIPTION>" + asset.getRentalTemplate().getDescription() + "</DESCRIPTION>" +
                "</RENTALTEMPLATEID>";

        String rental = asset.getIsRental() == null ? "" : "<ISRENTAL xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getIsRental() + "</ISRENTAL>";
        String isContract = asset.getIsContract() == null ? "" : "<ISCONTRACT xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getIsContract() + "</ISCONTRACT>";
        String contractTemplateId = asset.getContractTemplate() == null ? "" : "<CONTRACTTEMPLATEID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<CONTRACTTEMPLATECODE>" + asset.getContractTemplate().getCode() + "</CONTRACTTEMPLATECODE>" +
                "<ORGANIZATIONID entity=\"Location\">" +
                "<ORGANIZATIONCODE>" + asset.getContractTemplate().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + asset.getContractTemplate().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>" +
                "<DESCRIPTION>" + asset.getContractTemplate().getDescription() + "</DESCRIPTION>" +
                "</CONTRACTTEMPLATEID>";
        String customerId = asset.getCustomer() == null ? "" : "<CUSTOMERID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<CUSTOMERCODE>" + asset.getCustomer().getCode() + "</CUSTOMERCODE>" +
                "<ORGANIZATIONID entity=\"WorkRequest\">" +
                "<ORGANIZATIONCODE>" + asset.getCustomer().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + asset.getCustomer().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>" +
                "<DESCRIPTION>" + asset.getCustomer().getDescription() + "</DESCRIPTION>" +
                "</CUSTOMERID>";

        String availabilityStatus = asset.getAvailabilityStatus() == null ? "" : "<AVAILABILITYSTATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<STATUSCODE>" + asset.getAvailabilityStatus().getCode() + "</STATUSCODE>" +
                "<DESCRIPTION>" + asset.getAvailabilityStatus().getDescription() + "</DESCRIPTION>" +
                "</AVAILABILITYSTATUS>";

        info = isVehicle.isEmpty() && fleetCustomerId.isEmpty() && billingId.isEmpty() && markupId.isEmpty() && status.isEmpty() && type.isEmpty() && issueTo.isEmpty() && rental.isEmpty() && rentalTemplateId.isEmpty() && isContract.isEmpty() && contractTemplateId.isEmpty() && customerId.isEmpty() && availabilityStatus.isEmpty() ? "" : "<FleetVehicleInfo>" + isVehicle + fleetCustomerId + billingId + markupId + status + type + issueTo + rental + rentalTemplateId + isContract + contractTemplateId + customerId + availabilityStatus + "</FleetVehicleInfo>";
        return info;
    }

    public String addCnId(AssetEquipment asset) {
        if (asset.getCnId() == null) return "";
        return "<CNID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<CNNUMBER>" + asset.getCnId().getCode() + "</CNNUMBER>" +
                "<DESCRIPTION>" + asset.getCnId().getDescription() + "</DESCRIPTION>" +
                "</CNID>";
    }

    public String addEquipmentStateId(AssetEquipment asset) {
        if (asset.getEquipmentState() == null) return "";
        return "<EQUIPMENTSTATEID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<STATECODE>" + asset.getEquipmentState().getCode() + "</STATECODE>" +
                "<DESCRIPTION>" + asset.getEquipmentState().getDescription() + "</DESCRIPTION>" +
                "</EQUIPMENTSTATEID>";
    }

    public String addVmrsCode(AssetEquipment asset) {
        if (asset.getSystemLevelCode() == null) return "";
        return "<VMRSCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<SYSTEMLEVELID>" +
                "<SYSTEMLEVELCODE>" + asset.getSystemLevelCode().getCode() + "</SYSTEMLEVELCODE>" +
                "<DESCRIPTION>" + asset.getSystemLevelCode().getDescription() + "</DESCRIPTION>" +
                "</SYSTEMLEVELID>" +
                "</VMRSCODE>";
    }

    public String addPartLocationCode(AssetEquipment asset) {
        if (asset.getPartLocationCode() == null) return "";
        return "<PARTLOCATIONCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getPartLocationCode() + "</PARTLOCATIONCODE>";
    }

    public String addPurchaseOrderInfo(AssetEquipment asset) {
        if (asset.getPurchaseOrder() == null) return "";
        return "<PurchaseOrderInfo>" +
                "<PURCHASEORDERLINEID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<PURCHASEORDERID>" +
                "<PURCHASEORDERCODE>" + asset.getPurchaseOrder().getCode() + "</PURCHASEORDERCODE>" +
                "<ORGANIZATIONID entity=\"Requisition\">" +
                "<ORGANIZATIONCODE>" + asset.getPurchaseOrder().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + asset.getPurchaseOrder().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>" +
                "<DESCRIPTION>" + asset.getPurchaseOrder().getDescription() + "</DESCRIPTION>" +
                "</PURCHASEORDERID>" +
                "<PURCHASEORDERLINENUM>" + asset.getPurchaseOrderLineNum() + "</PURCHASEORDERLINENUM>" +
                "</PURCHASEORDERLINEID>" +
                "</PurchaseOrderInfo>";
    }

    public String addVariables(AssetEquipment asset) {
        if (asset.getVariable1() == null && asset.getVariable2() == null && asset.getVariable3() == null && asset.getVariable4() == null && asset.getVariable5() == null && asset.getVariable6() == null)
            return "";

        String v1 = asset.getVariable1() == null ? "" : "<VARIABLE1>" + asset.getVariable1() + "</VARIABLE1>";
        String v2 = asset.getVariable2() == null ? "" : "<VARIABLE2>" + asset.getVariable2() + "</VARIABLE2>";
        String v3 = asset.getVariable3() == null ? "" : "<VARIABLE3>" + asset.getVariable3() + "</VARIABLE3>";
        String v4 = asset.getVariable4() == null ? "" : "<VARIABLE4>" + asset.getVariable4() + "</VARIABLE4>";
        String v5 = asset.getVariable5() == null ? "" : "<VARIABLE5>" + asset.getVariable5() + "</VARIABLE5>";
        String v6 = asset.getVariable6() == null ? "" : "<VARIABLE6>" + asset.getVariable6() + "</VARIABLE6>";

        return "<Variables>" + v1 + v2 + v3 + v4 + v5 + v6 + "</Variables>";
    }

    public String addPreventWoCompletion(AssetEquipment asset) {
        if (asset.getPreventWoCompletion() == null) return "";
        return "<PREVENTWOCOMPLETION xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getPreventWoCompletion() + "</PREVENTWOCOMPLETION>";
    }

    public String addUserDefinedArea(AssetEquipment asset) {

        if (asset.getUserDefinedArea() == null) return "";
        System.out.println(asset.getUserDefinedArea() == null);

        String classOrganization = asset.getUserDefinedArea().getClassId() == null || asset.getUserDefinedArea().getClassId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"RequisitionDefault\">" +
                "<ORGANIZATIONCODE>" + asset.getUserDefinedArea().getClassId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + asset.getUserDefinedArea().getClassId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String classId = asset.getUserDefinedArea().getClassId() == null ? "" : "<CLASSID entity=\"ent2\">" +
                "<CLASSCODE>" + asset.getUserDefinedArea().getClassId().getCode() + "</CLASSCODE>" +
                classOrganization +
                "<DESCRIPTION>" + asset.getUserDefinedArea().getClassId().getDescription() + "</DESCRIPTION>" +
                "</CLASSID>";

        String dateField = asset.getUserDefinedArea().getDateField() == null ? "" : "<DATEFIELD qualifier=\"ACCOUNTING\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedArea().getDateField().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedArea().getDateField().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedArea().getDateField().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedArea().getDateField().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedArea().getDateField().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedArea().getDateField().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedArea().getDateField().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedArea().getDateField().getTimeZone() + "</TIMEZONE>" +
                "</DATEFIELD>";

        return "<USERDEFINEDAREA xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<CUSTOMFIELD index=\"1\" entity=\"entity1\" type=\"type1\" changed=\"chan1\">" +
                "<PROPERTYCODE>" + asset.getUserDefinedArea().getPropertyCode() + "</PROPERTYCODE>" +
                "<PROPERTYLABEL>" + asset.getUserDefinedArea().getPropertyLabel() + "</PROPERTYLABEL>" +
                classId +
                dateField +
                "<MAXVALUE>" + asset.getUserDefinedArea().getMaxValue() + "</MAXVALUE>" +
                "<MINVALUE>" + asset.getUserDefinedArea().getMinValue() + "</MINVALUE>" +
                "<UOM>" + asset.getUserDefinedArea().getUnitOfMetric() + "</UOM>" +
                "<LOVSETTINGS>" +
                "<LOV_TYPE>" + asset.getUserDefinedArea().getLovType() + "</LOV_TYPE>" +
                "<LOV_VALIDATE>" + asset.getUserDefinedArea().getLovValidate() + "</LOV_VALIDATE>" +
                "</LOVSETTINGS>" +
                "<VALUESOURCE>" +
                "<CATVALUE>" + asset.getUserDefinedArea().getCatValue() + "</CATVALUE>" +
                "<NONUPDATEABLE>" + asset.getUserDefinedArea().getNonUpdatable() + "</NONUPDATEABLE>" +
                "</VALUESOURCE>" +
                "<GROUPLABEL>" + asset.getUserDefinedArea().getGroupLabel() + "</GROUPLABEL>" +
                "</CUSTOMFIELD>" +
                "</USERDEFINEDAREA>";
    }

    public String addGisObjProfileCGMPLingGis(AssetEquipment asset) {

        String gisObj = asset.getGisObj() == null ? "" : "<GISOBJID xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getGisObj() + "</GISOBJID>";
        String gisProfile = asset.getGisProfile() == null ? "" : "<GISPROFILE xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getGisProfile() + "</GISPROFILE>";

        return  gisObj +
                gisProfile +
                "<CGMP xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getCgMp() + "</CGMP>" +
                "<LINKGISWO xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getLinkGisWo() + "</LINKGISWO>";
    }

    public String addGisMap(AssetEquipment asset) {
        if (asset.getGisMap() == null) return "";
        return "<GISMAPID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<GISMAPCODE>" + asset.getGisMap().getCode() + "</GISMAPCODE>" +
                "<DESCRIPTION>" + asset.getGisMap().getDescription() + "</DESCRIPTION>" +
                "<ORGANIZATIONID entity=\"RequisitionLine\">" +
                "<ORGANIZATIONCODE>" + asset.getGisMap().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + asset.getGisMap().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>" +
                "</GISMAPID>";
    }

    public String addGisLayer(AssetEquipment asset) {
        return "<GISLAYER xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getGislayer() + "</GISLAYER>";
    }

    public String addXYLocation(AssetEquipment asset) {
        if (asset.getXLocation() == null && asset.getYLocation() == null) return "";
        return "<XLOCATION qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getXLocation().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getXLocation().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getXLocation().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getXLocation().getUom() + "</UOM>" +
                "</XLOCATION>" +
                "<YLOCATION qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getYLocation().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getYLocation().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getYLocation().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getYLocation().getUom() + "</UOM>" +
                "</YLOCATION>";
    }

//    public String addLinearReferenceDetails(AssetEquipment asset) {
//
//        if (asset.getLinearReferenceDetails() == null) return "";
//
//        String equipmentLength = asset.getLinearReferenceDetails().getEquipmentLength() == null ? "" : "<EQUIPMENTLENGTH qualifier=\"ACCEPTED\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLinearReferenceDetails().getEquipmentLength().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLinearReferenceDetails().getEquipmentLength().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLinearReferenceDetails().getEquipmentLength().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLinearReferenceDetails().getEquipmentLength().getUom() + "</UOM>" +
//                "</EQUIPMENTLENGTH>";
//
//        String fromPoint = asset.getLinearReferenceDetails().getLrfFromPoint() == null ? "" : "<LRFFROMPOINT qualifier=\"ACCEPTED\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLinearReferenceDetails().getLrfFromPoint().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLinearReferenceDetails().getLrfFromPoint().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLinearReferenceDetails().getLrfFromPoint().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLinearReferenceDetails().getLrfFromPoint().getUom() + "</UOM>" +
//                "</LRFFROMPOINT>";
//
//        String toPoint = asset.getLinearReferenceDetails().getLrfToPoint() == null ? "" : "<LRFTOPOINT qualifier=\"ACCEPTED\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLinearReferenceDetails().getLrfToPoint().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLinearReferenceDetails().getLrfToPoint().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLinearReferenceDetails().getLrfToPoint().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLinearReferenceDetails().getLrfToPoint().getUom() + "</UOM>" +
//                "</LRFTOPOINT>";
//
//        String linearDirection = asset.getLinearReferenceDetails().getLinearDirection() == null ? "" : "<LINEARDIRECTIONID>" +
//                "<UCODEENTITY>" + asset.getLinearReferenceDetails().getLinearDirection().getUCodeEntity() + "</UCODEENTITY>" +
//                "<UCODE>" + asset.getLinearReferenceDetails().getLinearDirection().getUCode() + "</UCODE>" +
//                "<DESCRIPTION>" + asset.getLinearReferenceDetails().getLinearDirection().getDescription() + "</DESCRIPTION>" +
//                "</LINEARDIRECTIONID>";
//
//        String linearEquipmentType = asset.getLinearReferenceDetails().getLinearEquipmentType() == null ? "" : "<LINEAREQUIPMENTTYPE entity=\"User\">" +
//                "<TYPECODE>" + asset.getLinearReferenceDetails().getLinearEquipmentType().getCode() + "</TYPECODE>" +
//                "<DESCRIPTION>" + asset.getLinearReferenceDetails().getLinearEquipmentType().getDescription() + "</DESCRIPTION>" +
//                "</LINEAREQUIPMENTTYPE>";
//
//        String linearCostWeight = asset.getLinearReferenceDetails().getLinearCostWeight() == null ? "" : "<LINEARCOSTWEIGHT>" + asset.getLinearReferenceDetails().getLinearCostWeight() + "</LINEARCOSTWEIGHT>";
//
//        return "<LINEARREFERENCEDETAILS xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                equipmentLength +
//                "<EQUIPMENTLENGTHUOM>" + asset.getLinearReferenceDetails().getEquipmentLengthUom() + "</EQUIPMENTLENGTHUOM>" +
//                "<LINEARREFUOM>" + asset.getLinearReferenceDetails().getLinearReferenceUom() + "</LINEARREFUOM>" +
//                "<LINEARREFPRECISION>" + asset.getLinearReferenceDetails().getLinearReferencePrecision() + "</LINEARREFPRECISION>" +
//                "<GEOGRAPHICALREFERENCE>" + asset.getLinearReferenceDetails().getGeographicalReference() + "</GEOGRAPHICALREFERENCE>" +
//                "<INSPECTIONDIRECTIONCODE>" + asset.getLinearReferenceDetails().getInspectionDirectionCode() + "</INSPECTIONDIRECTIONCODE>" +
//                "<FLOWCODE>" + asset.getLinearReferenceDetails().getFlowCode() + "</FLOWCODE>" +
//                linearCostWeight +
//                fromPoint +
//                toPoint +
//                linearDirection +
//                linearEquipmentType +
//                "</LINEARREFERENCEDETAILS>";
//    }

//    public String addCallCenterDetails(AssetEquipment asset) {
//
//        String penaltyFactor = asset.getCallCenter().getPenaltyFactor() == null ? "" : "<PENALTYFACTOR qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCallCenter().getPenaltyFactor().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCallCenter().getPenaltyFactor().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCallCenter().getPenaltyFactor().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCallCenter().getPenaltyFactor().getUom() + "</UOM>" +
//                "</PENALTYFACTOR>";
//
//        String penaltyAmount = asset.getCallCenter().getPenaltyAmount() == null ? "" : "<PENALTYAMOUNT qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCallCenter().getPenaltyAmount().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCallCenter().getPenaltyAmount().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCallCenter().getPenaltyAmount().getSign() + "</SIGN>" +
//                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCallCenter().getPenaltyAmount().getCurrency() + "</CURRENCY>" +
//                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCallCenter().getPenaltyAmount().getDRCR() + "</DRCR>" +
//                "</PENALTYAMOUNT>";
//
//        String orgCurrency = asset.getCallCenter().getOrgCurrency() == null ? "" : "<ORGCURRENCY xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<CURRENCYCODE>" + asset.getCallCenter().getOrgCurrency().getCode() + "</CURRENCYCODE>" +
//                "<DESCRIPTION>" + asset.getCallCenter().getOrgCurrency().getDescription() + "</DESCRIPTION>" +
//                "</ORGCURRENCY>";
//
//        String calendarGroupId = asset.getCallCenter().getCalendarGroup() == null ? "" : "<CALENDARGROUPID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<CALENDARGROUPCODE>" + asset.getCallCenter().getCalendarGroup().getCode() + "</CALENDARGROUPCODE>" +
//                "<ORGANIZATIONID entity=\"RequisitionLineDefault\">" +
//                "<ORGANIZATIONCODE>" + asset.getCallCenter().getCalendarGroup().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
//                "<DESCRIPTION>" + asset.getCallCenter().getCalendarGroup().getOrganization().getDescription() + "</DESCRIPTION>" +
//                "</ORGANIZATIONID>" +
//                "<DESCRIPTION>" + asset.getCallCenter().getCalendarGroup().getDescription() + "</DESCRIPTION>" +
//                "</CALENDARGROUPID>";
//
//        return "<CallCenterDetails>" +
//                penaltyFactor +
//                penaltyAmount +
//                orgCurrency +
//                calendarGroupId +
//                "<SDMFLAG xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getCallCenter().getSdmFlag() + "</SDMFLAG>" +
//                "<ENABLESDMCHECK xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getCallCenter().getEnableSdmCheck() + "</ENABLESDMCHECK>" +
//                "</CallCenterDetails>";
//    }

//    public String addAssetParentHierarchy(AssetEquipment asset) {
//        if (asset.getAssetParentHierarchy() == null) return "";
//
//        String assetId = asset.getAssetParentHierarchy().getId() == null ? "" : "<ASSETID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<EQUIPMENTCODE>" + asset.getAssetParentHierarchy().getId().getCode() + "</EQUIPMENTCODE>" +
//                "<ORGANIZATIONID entity=\"WorkOrderDefault\">" +
//                "<ORGANIZATIONCODE>" + asset.getAssetParentHierarchy().getId().getCode() + "</ORGANIZATIONCODE>" +
//                "<DESCRIPTION>" + asset.getAssetParentHierarchy().getId().getCode() + "</DESCRIPTION>" +
//                "</ORGANIZATIONID>" +
//                "<DESCRIPTION>" + asset.getAssetParentHierarchy().getId().getCode() + "</DESCRIPTION>" +
//                "</ASSETID>";
//
//        String type = asset.getAssetParentHierarchy().getType() == null ? "" : "<TYPE entity=\"Organization\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<TYPECODE>" + asset.getAssetParentHierarchy().getType().getCode() + "</TYPECODE>" +
//                "<DESCRIPTION>" + asset.getAssetParentHierarchy().getType().getDescription() + "</DESCRIPTION>" +
//                "</TYPE>";
//
//        String locationId = asset.getAssetParentHierarchy().getLocation() == null ? "" : "<LOCATIONID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<LOCATIONCODE>" + asset.getAssetParentHierarchy().getLocation().getCode() + "</LOCATIONCODE>" +
//                "<ORGANIZATIONID entity=\"WorkOrder\">" +
//                "<ORGANIZATIONCODE>" + asset.getAssetParentHierarchy().getLocation().getCode() + "</ORGANIZATIONCODE>" +
//                "<DESCRIPTION>" + asset.getAssetParentHierarchy().getLocation().getCode() + "</DESCRIPTION>" +
//                "</ORGANIZATIONID>" +
//                "<DESCRIPTION>" + asset.getAssetParentHierarchy().getLocation().getCode() + "</DESCRIPTION>" +
//                "</LOCATIONID>";
//
//        String assetDependencies = "";
//
//        if (asset.getAssetParentHierarchy().getDependentAsset() != null || asset.getAssetParentHierarchy().getNonDependentPosition() != null || asset.getAssetParentHierarchy().getNonDependentPrimarySystem() != null || asset.getAssetParentHierarchy().getNonDependentSystem() != null) {
//
//            assetDependencies = assetDependencies.concat("<AssetDependency>");
//
//            if (asset.getAssetParentHierarchy().getDependentAsset() != null) {
//
//                String idOrg = asset.getAssetParentHierarchy().getDependentAsset().getId() == null || asset.getAssetParentHierarchy().getDependentAsset().getId().getOrganization() == null ? "" :  "<ORGANIZATIONID entity=\"Part\">" +
//                        "<ORGANIZATIONCODE>" + asset.getAssetParentHierarchy().getDependentAsset().getId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
//                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getDependentAsset().getId().getOrganization().getDescription() + "</DESCRIPTION>" +
//                        "</ORGANIZATIONID>";
//
//                String id = asset.getAssetParentHierarchy().getDependentAsset().getId() == null ? "" : "<ASSETID>" +
//                        "<EQUIPMENTCODE>" + asset.getAssetParentHierarchy().getDependentAsset().getId().getCode() + "</EQUIPMENTCODE>" +
//                        idOrg +
//                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getDependentAsset().getId().getDescription() + "</DESCRIPTION>" +
//                        "</ASSETID>";
//
//                String type1 = asset.getAssetParentHierarchy().getDependentAsset().getType() == null ? "" : "<TYPE entity=\"Group\">" +
//                        "<TYPECODE>" + asset.getAssetParentHierarchy().getDependentAsset().getType().getCode() + "</TYPECODE>" +
//                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getDependentAsset().getType().getDescription() + "</DESCRIPTION>" +
//                        "</TYPE>";
//
//                String costRollUp =  asset.getAssetParentHierarchy().getDependentAsset().getCostRollup() != null ? "" : "<COSTROLLUP>" + asset.getAssetParentHierarchy().getDependentAsset().getCostRollup() + "</COSTROLLUP>";
//
//                String depOrg = asset.getAssetParentHierarchy().getDependentAsset().getDepartment() == null || asset.getAssetParentHierarchy().getDependentAsset().getDepartment().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"PartDefault\">" +
//                        "<ORGANIZATIONCODE>" + asset.getAssetParentHierarchy().getDependentAsset().getDepartment().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
//                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getDependentAsset().getDepartment().getOrganization().getDescription() + "</DESCRIPTION>" +
//                        "</ORGANIZATIONID>";
//
//                String departmentId = asset.getAssetParentHierarchy().getDependentAsset().getDepartment() == null ? "" : "<DEPARTMENTID>" +
//                        "<DEPARTMENTCODE>" + asset.getAssetParentHierarchy().getDependentAsset().getDepartment().getCode() + "</DEPARTMENTCODE>" +
//                        depOrg +
//                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getDependentAsset().getDepartment().getDescription() + "</DESCRIPTION>" +
//                        "</DEPARTMENTID>";
//
//                String loanedOrg = asset.getAssetParentHierarchy().getDependentAsset().getLoanedToDepartment() == null || asset.getAssetParentHierarchy().getDependentAsset().getLoanedToDepartment().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"PurchaseOrder\">" +
//                        "<ORGANIZATIONCODE>" + asset.getAssetParentHierarchy().getDependentAsset().getLoanedToDepartment().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
//                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getDependentAsset().getLoanedToDepartment().getOrganization().getDescription() + "</DESCRIPTION>" +
//                        "</ORGANIZATIONID>";
//
//                String loaned = asset.getAssetParentHierarchy().getDependentAsset().getLoanedToDepartment() == null ? "" : "<LOANEDTODEPARTMENTID>" +
//                        "<DEPARTMENTCODE>" + asset.getAssetParentHierarchy().getDependentAsset().getLoanedToDepartment().getCode() + "</DEPARTMENTCODE>" +
//                        loanedOrg +
//                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getDependentAsset().getLoanedToDepartment().getDescription() + "</DESCRIPTION>" +
//                        "</LOANEDTODEPARTMENTID>";
//
//                assetDependencies = assetDependencies.concat("<DEPENDENTASSET recordid=\"" + asset.getAssetParentHierarchy().getDependentAsset().getUpdatedCount() + "\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                        id +
//                        type1 +
//                        costRollUp +
//                        departmentId +
//                        loaned +
//                        "</DEPENDENTASSET>");
//            }


////////            if (asset.getAssetParentHierarchy().getNonDependentPosition() != null) {
////////
////////                String idOrg = asset.getAssetParentHierarchy().getNonDependentPosition().getId() == null || asset.getAssetParentHierarchy().getNonDependentPosition().getId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"AssetEquipmentDefault\">" +
////////                        "<ORGANIZATIONCODE>" + asset.getAssetParentHierarchy().getNonDependentPosition().getId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentPosition().getId().getOrganization().getDescription() + "</DESCRIPTION>" +
////////                        "</ORGANIZATIONID>";
////////
////////                String id = asset.getAssetParentHierarchy().getNonDependentPosition().getId() == null ? "" : "<POSITIONID>" +
////////                        "<EQUIPMENTCODE>" + asset.getAssetParentHierarchy().getNonDependentPosition().getId().getCode() + "</EQUIPMENTCODE>" +
////////                        idOrg +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentPosition().getId().getDescription() + "</DESCRIPTION>" +
////////                        "</POSITIONID>";
////////
////////                String type1 = asset.getAssetParentHierarchy().getNonDependentPosition().getType() == null ? "" : "<TYPE entity=\"Class\">" +
////////                        "<TYPECODE>" + asset.getAssetParentHierarchy().getNonDependentPosition().getType().getCode() + "</TYPECODE>" +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentPosition().getType().getDescription() + "</DESCRIPTION>" +
////////                        "</TYPE>";
////////
////////                String costRollUp = asset.getAssetParentHierarchy().getNonDependentPosition().getCostRollup() == null ? "" : "<COSTROLLUP>" + asset.getAssetParentHierarchy().getNonDependentPosition().getCostRollup() + "</COSTROLLUP>";
////////
////////                String departmentOrg = asset.getAssetParentHierarchy().getNonDependentPosition().getDepartment() == null || asset.getAssetParentHierarchy().getNonDependentPosition().getDepartment().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"BookedHours\">" +
////////                        "<ORGANIZATIONCODE>" + asset.getAssetParentHierarchy().getNonDependentPosition().getDepartment().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentPosition().getDepartment().getOrganization().getDescription() + "</DESCRIPTION>" +
////////                        "</ORGANIZATIONID>";
////////
////////                String department = asset.getAssetParentHierarchy().getNonDependentPosition().getDepartment() == null ? "" : "<DEPARTMENTID>" +
////////                        "<DEPARTMENTCODE>" + asset.getAssetParentHierarchy().getNonDependentPosition().getDepartment().getCode() + "</DEPARTMENTCODE>" +
////////                        departmentOrg +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentPosition().getDepartment().getDescription() + "</DESCRIPTION>" +
////////                        "</DEPARTMENTID>";
////////
////////                String loanedOrg = asset.getAssetParentHierarchy().getNonDependentPosition().getLoanedToDepartment() == null || asset.getAssetParentHierarchy().getNonDependentPosition().getLoanedToDepartment().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"Store\">" +
////////                        "<ORGANIZATIONCODE>" + asset.getAssetParentHierarchy().getNonDependentPosition().getLoanedToDepartment().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentPosition().getLoanedToDepartment().getOrganization().getDescription() + "</DESCRIPTION>" +
////////                        "</ORGANIZATIONID>";
////////
////////                String loaned = asset.getAssetParentHierarchy().getNonDependentPosition().getLoanedToDepartment() == null ? "" : "<LOANEDTODEPARTMENTID>" +
////////                        "<DEPARTMENTCODE>" + asset.getAssetParentHierarchy().getNonDependentPosition().getLoanedToDepartment().getCode() + "</DEPARTMENTCODE>" +
////////                        loanedOrg +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentPosition().getLoanedToDepartment().getDescription() + "</DESCRIPTION>" +
////////                        "</LOANEDTODEPARTMENTID>";
////////
////////                assetDependencies = assetDependencies.concat(
////////                        "<NONDEPENDENTPOSITION recordid=\"" + asset.getAssetParentHierarchy().getNonDependentPosition().getUpdatedCount() + "\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
////////                                id +
////////                                type1 +
////////                                costRollUp +
////////                                department +
////////                                loaned +
////////                                "</NONDEPENDENTPOSITION>");
////////            }
////////
////////            if (asset.getAssetParentHierarchy().getNonDependentPrimarySystem() != null) {
////////
////////                String idOrg = asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getId() == null || asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"StoreDefault\">" +
////////                        "<ORGANIZATIONCODE>" + asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getId().getOrganization().getDescription() + "</DESCRIPTION>" +
////////                        "</ORGANIZATIONID>";
////////
////////                String id = asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getId() == null ? "" : "<SYSTEMID>" +
////////                        "<EQUIPMENTCODE>" + asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getId().getCode() + "</EQUIPMENTCODE>" +
////////                        idOrg +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getId().getDescription() + "</DESCRIPTION>" +
////////                        "</SYSTEMID>";
////////
////////                String type1 = asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getType() == null ? "" : "<TYPE entity=\"Department\">" +
////////                        "<TYPECODE>" + asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getType().getCode() + "</TYPECODE>" +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getType().getDescription() + "</DESCRIPTION>" +
////////                        "</TYPE>";
////////
////////                String costRollUp = asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getCostRollup() == null ? "" : "<COSTROLLUP>" + asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getCostRollup() + "</COSTROLLUP>";
////////
////////                String departOrg = asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getDepartment() == null || asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getDepartment().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"Activity\">" +
////////                        "<ORGANIZATIONCODE>" + asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getDepartment().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getDepartment().getOrganization().getDescription() + "</DESCRIPTION>" +
////////                        "</ORGANIZATIONID>";
////////
////////                String depart = asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getDepartment() == null ? "" : "<DEPARTMENTID>" +
////////                        "<DEPARTMENTCODE>" + asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getDepartment().getCode() + "</DEPARTMENTCODE>" +
////////                        departOrg +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getDepartment().getDescription() + "</DESCRIPTION>" +
////////                        "</DEPARTMENTID>";
////////
////////                String loanedOrg = "<ORGANIZATIONID entity=\"ActivityDefault\">" +
////////                        "<ORGANIZATIONCODE>" + asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getLoanedToDepartment().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getLoanedToDepartment().getOrganization().getDescription() + "</DESCRIPTION>" +
////////                        "</ORGANIZATIONID>";
////////
////////                String loaned = "<LOANEDTODEPARTMENTID>" +
////////                        "<DEPARTMENTCODE>" + asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getLoanedToDepartment().getCode() + "</DEPARTMENTCODE>" +
////////                        loanedOrg +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getLoanedToDepartment().getDescription() + "</DESCRIPTION>" +
////////                        "</LOANEDTODEPARTMENTID>";
////////
////////                assetDependencies = assetDependencies.concat(
////////                        "<NONDEPENDENTPRIMARYSYSTEM recordid=\"" + asset.getAssetParentHierarchy().getNonDependentPrimarySystem().getUpdatedCount() + "\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
////////                                id +
////////                                type1 +
////////                                costRollUp +
////////                                depart +
////////                                loaned +
////////                                "</NONDEPENDENTPRIMARYSYSTEM>");
////////            }
////////
////////            if (asset.getAssetParentHierarchy().getNonDependentSystem() != null) {
////////
////////                String idOrg = asset.getAssetParentHierarchy().getNonDependentSystem().getId() == null || asset.getAssetParentHierarchy().getNonDependentSystem().getId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"LaborRequisition\">" +
////////                        "<ORGANIZATIONCODE>" + asset.getAssetParentHierarchy().getNonDependentSystem().getId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentSystem().getId().getOrganization().getDescription() + "</DESCRIPTION>" +
////////                        "</ORGANIZATIONID>";
////////
////////                String id = asset.getAssetParentHierarchy().getNonDependentSystem().getId() == null ? "" : "<SYSTEMID>" +
////////                        "<EQUIPMENTCODE>" + asset.getAssetParentHierarchy().getNonDependentSystem().getId().getCode() + "</EQUIPMENTCODE>" +
////////                        idOrg +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentSystem().getId().getDescription() + "</DESCRIPTION>" +
////////                        "</SYSTEMID>";
////////
////////                String type1 = asset.getAssetParentHierarchy().getNonDependentSystem().getType() == null ? "" : "<TYPE entity=\"Personnel\">" +
////////                        "<TYPECODE>" + asset.getAssetParentHierarchy().getNonDependentSystem().getType().getCode() + "</TYPECODE>" +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentSystem().getType().getDescription() + "</DESCRIPTION>" +
////////                        "</TYPE>";
////////
////////                String costRollUp = asset.getAssetParentHierarchy().getNonDependentSystem().getCostRollup() == null ? "" : "<COSTROLLUP>" + asset.getAssetParentHierarchy().getNonDependentSystem().getCostRollup() + "</COSTROLLUP>";
////////
////////                String departOrg = asset.getAssetParentHierarchy().getNonDependentSystem().getDepartment() == null || asset.getAssetParentHierarchy().getNonDependentSystem().getDepartment().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"CustomFields\">" +
////////                        "<ORGANIZATIONCODE>" + asset.getAssetParentHierarchy().getNonDependentSystem().getDepartment().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentSystem().getDepartment().getOrganization().getDescription() + "</DESCRIPTION>" +
////////                        "</ORGANIZATIONID>";
////////
////////                String depart = asset.getAssetParentHierarchy().getNonDependentSystem().getDepartment() == null ? "" : "<DEPARTMENTID>" +
////////                        "<DEPARTMENTCODE>" + asset.getAssetParentHierarchy().getNonDependentSystem().getDepartment().getCode() + "</DEPARTMENTCODE>" +
////////                        departOrg +
////////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentSystem().getDepartment().getDescription() + "</DESCRIPTION>" +
////////                        "</DEPARTMENTID>";
//////
//////                String loanedOrg = asset.getAssetParentHierarchy().getNonDependentSystem().getLoanedToDepartment() == null || asset.getAssetParentHierarchy().getNonDependentSystem().getLoanedToDepartment().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"EquipmentSummary\">" +
//////                        "<ORGANIZATIONCODE>" + asset.getAssetParentHierarchy().getNonDependentSystem().getLoanedToDepartment().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
//////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentSystem().getLoanedToDepartment().getOrganization().getDescription() + "</DESCRIPTION>" +
//////                        "</ORGANIZATIONID>";
//////
//////                String loaned = asset.getAssetParentHierarchy().getNonDependentSystem().getLoanedToDepartment() == null ? "" : "<LOANEDTODEPARTMENTID>" +
//////                        "<DEPARTMENTCODE>" + asset.getAssetParentHierarchy().getNonDependentSystem().getLoanedToDepartment().getCode() + "</DEPARTMENTCODE>" +
//////                        loanedOrg +
//////                        "<DESCRIPTION>" + asset.getAssetParentHierarchy().getNonDependentSystem().getLoanedToDepartment().getDescription() + "</DESCRIPTION>" +
//////                        "</LOANEDTODEPARTMENTID>";
//////
//////                assetDependencies = assetDependencies.concat(
//////                        "<NONDEPENDENTSYSTEM recordid=\"" + asset.getAssetParentHierarchy().getNonDependentSystem().getUpdatedCount() + "\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//////                                id +
//////                                type1 +
//////                                costRollUp +
//////                                depart +
//////                                loaned +
//////                                "</NONDEPENDENTSYSTEM>");
//////            }
////
////            assetDependencies = assetDependencies.concat("</AssetDependency>");
////        }
//
//        return "<AssetParentHierarchy>" +
//                assetId +
//                type +
//                locationId +
//                "<POSITIONPARENT xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getAssetParentHierarchy().getPositionParent() + "</POSITIONPARENT>" +
//                assetDependencies +
//                "</AssetParentHierarchy>";
//    }

    public String addUserDefinedFields(AssetEquipment asset) {

        if (asset.getUserDefinedFields() == null) return "";

        String userDefinedChars = "";

        System.out.println(asset.getUserDefinedFields().getUdfChar01() != null);
        System.out.println(asset.getUserDefinedFields().getUdfChar02() != null);
        System.out.println(asset.getUserDefinedFields().getUdfChar03() != null);
        System.out.println(asset.getUserDefinedFields().getUdfChar09() != null);
        if (asset.getUserDefinedFields().getUdfChar01() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar01() + "</UDFCHAR01>");
        if (asset.getUserDefinedFields().getUdfChar02() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar02() + "</UDFCHAR02>");
        if (asset.getUserDefinedFields().getUdfChar03() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR03 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar03() + "</UDFCHAR03>");
        if (asset.getUserDefinedFields().getUdfChar04() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR04 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar04() + "</UDFCHAR04>");
        if (asset.getUserDefinedFields().getUdfChar05() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR05 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar05() + "</UDFCHAR05>");
        if (asset.getUserDefinedFields().getUdfChar06() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR06 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar06() + "</UDFCHAR06>");
        if (asset.getUserDefinedFields().getUdfChar07() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR07 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar07() + "</UDFCHAR07>");
        if (asset.getUserDefinedFields().getUdfChar08() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR08 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar08() + "</UDFCHAR08>");
        if (asset.getUserDefinedFields().getUdfChar09() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR09 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar09() + "</UDFCHAR09>");
        if (asset.getUserDefinedFields().getUdfChar10() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR10 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar10() + "</UDFCHAR10>");
        if (asset.getUserDefinedFields().getUdfChar11() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR11 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar11() + "</UDFCHAR11>");
        if (asset.getUserDefinedFields().getUdfChar12() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR12 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar12() + "</UDFCHAR12>");
        if (asset.getUserDefinedFields().getUdfChar13() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR13 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar13() + "</UDFCHAR13>");
        if (asset.getUserDefinedFields().getUdfChar14() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR14 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar14() + "</UDFCHAR14>");
        if (asset.getUserDefinedFields().getUdfChar15() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR15 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar15() + "</UDFCHAR15>");
        if (asset.getUserDefinedFields().getUdfChar16() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR16 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar16() + "</UDFCHAR16>");
        if (asset.getUserDefinedFields().getUdfChar17() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR17 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar17() + "</UDFCHAR17>");
        if (asset.getUserDefinedFields().getUdfChar18() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR18 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar18() + "</UDFCHAR18>");
        if (asset.getUserDefinedFields().getUdfChar19() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR19 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar19() + "</UDFCHAR19>");
        if (asset.getUserDefinedFields().getUdfChar20() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR20 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar20() + "</UDFCHAR20>");
        if (asset.getUserDefinedFields().getUdfChar21() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR21 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar21() + "</UDFCHAR21>");
        if (asset.getUserDefinedFields().getUdfChar22() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR22 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar22() + "</UDFCHAR22>");
        if (asset.getUserDefinedFields().getUdfChar23() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR23 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar23() + "</UDFCHAR23>");
        if (asset.getUserDefinedFields().getUdfChar24() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR24 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar24() + "</UDFCHAR24>");
        if (asset.getUserDefinedFields().getUdfChar25() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR25 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar25() + "</UDFCHAR25>");
        if (asset.getUserDefinedFields().getUdfChar26() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR26 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar26() + "</UDFCHAR26>");
        if (asset.getUserDefinedFields().getUdfChar27() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR27 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar27() + "</UDFCHAR27>");
        if (asset.getUserDefinedFields().getUdfChar28() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR28 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar28() + "</UDFCHAR28>");
        if (asset.getUserDefinedFields().getUdfChar29() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR29 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar29() + "</UDFCHAR29>");
        if (asset.getUserDefinedFields().getUdfChar30() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR30 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar30() + "</UDFCHAR30>");
        if (asset.getUserDefinedFields().getUdfChar31() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR31 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar31() + "</UDFCHAR31>");
        if (asset.getUserDefinedFields().getUdfChar32() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR32 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar32() + "</UDFCHAR32>");
        if (asset.getUserDefinedFields().getUdfChar33() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR33 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar33() + "</UDFCHAR33>");
        if (asset.getUserDefinedFields().getUdfChar34() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR34 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar34() + "</UDFCHAR34>");
        if (asset.getUserDefinedFields().getUdfChar35() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR35 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar35() + "</UDFCHAR35>");
        if (asset.getUserDefinedFields().getUdfChar36() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR36 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar36() + "</UDFCHAR36>");
        if (asset.getUserDefinedFields().getUdfChar37() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR37 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar37() + "</UDFCHAR37>");
        if (asset.getUserDefinedFields().getUdfChar38() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR38 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar38() + "</UDFCHAR38>");
        if (asset.getUserDefinedFields().getUdfChar39() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR39 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar39() + "</UDFCHAR39>");
        if (asset.getUserDefinedFields().getUdfChar40() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR40 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar40() + "</UDFCHAR40>");
        if (asset.getUserDefinedFields().getUdfChar41() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR41 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar41() + "</UDFCHAR41>");
        if (asset.getUserDefinedFields().getUdfChar42() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR42 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar42() + "</UDFCHAR42>");
        if (asset.getUserDefinedFields().getUdfChar43() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR43 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar43() + "</UDFCHAR43>");
        if (asset.getUserDefinedFields().getUdfChar44() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR44 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar44() + "</UDFCHAR44>");
        if (asset.getUserDefinedFields().getUdfChar45() != null)
            userDefinedChars = userDefinedChars.concat("<UDFCHAR45 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChar45() + "</UDFCHAR45>");

        String userDefinedNumbers = "";

        if (asset.getUserDefinedFields().getUdfNum1() != null)
            userDefinedNumbers = userDefinedNumbers.concat("<UDFNUM01 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum1().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum1().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum1().getSign() + "</SIGN>" + "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum1().getUom() + "</UOM>" + "</UDFNUM01>");
        if (asset.getUserDefinedFields().getUdfNum2() != null)
            userDefinedNumbers = userDefinedNumbers.concat("<UDFNUM02 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum2().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum2().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum2().getSign() + "</SIGN>" + "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum2().getUom() + "</UOM>" + "</UDFNUM02>");
        if (asset.getUserDefinedFields().getUdfNum3() != null)
            userDefinedNumbers = userDefinedNumbers.concat("<UDFNUM03 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum3().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum3().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum3().getSign() + "</SIGN>" + "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum3().getUom() + "</UOM>" + "</UDFNUM03>");
        if (asset.getUserDefinedFields().getUdfNum4() != null)
            userDefinedNumbers = userDefinedNumbers.concat("<UDFNUM04 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum4().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum4().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum4().getSign() + "</SIGN>" + "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum4().getUom() + "</UOM>" + "</UDFNUM04>");
        if (asset.getUserDefinedFields().getUdfNum5() != null)
            userDefinedNumbers = userDefinedNumbers.concat("<UDFNUM05 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum5().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum5().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum5().getSign() + "</SIGN>" + "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum5().getUom() + "</UOM>" + "</UDFNUM05>");
        if (asset.getUserDefinedFields().getUdfNum6() != null)
            userDefinedNumbers = userDefinedNumbers.concat("<UDFNUM06 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum6().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum6().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum6().getSign() + "</SIGN>" + "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum6().getUom() + "</UOM>" + "</UDFNUM06>");
        if (asset.getUserDefinedFields().getUdfNum7() != null)
            userDefinedNumbers = userDefinedNumbers.concat("<UDFNUM07 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum7().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum7().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum7().getSign() + "</SIGN>" + "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum7().getUom() + "</UOM>" + "</UDFNUM07>");
        if (asset.getUserDefinedFields().getUdfNum8() != null)
            userDefinedNumbers = userDefinedNumbers.concat("<UDFNUM08 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum8().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum8().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum8().getSign() + "</SIGN>" + "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum8().getUom() + "</UOM>" + "</UDFNUM08>");
        if (asset.getUserDefinedFields().getUdfNum9() != null)
            userDefinedNumbers = userDefinedNumbers.concat("<UDFNUM09 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum9().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum9().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum9().getSign() + "</SIGN>" + "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum9().getUom() + "</UOM>" + "</UDFNUM09>");
        if (asset.getUserDefinedFields().getUdfNum10() != null)
            userDefinedNumbers = userDefinedNumbers.concat("<UDFNUM10 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum10().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum10().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum10().getSign() + "</SIGN>" + "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfNum10().getUom() + "</UOM>" + "</UDFNUM10>");

        String userDefinedDates = "";

        if (asset.getUserDefinedFields().getUdfDate1() != null)
            userDefinedDates = userDefinedDates.concat("<UDFDATE01 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate1().getYear() + "</YEAR>" + "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate1().getMonth() + "</MONTH>" + "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate1().getDay() + "</DAY>" + "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate1().getHour() + "</HOUR>" + "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate1().getMinute() + "</MINUTE>" + "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate1().getSecond() + "</SECOND>" + "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate1().getNano() + "</SUBSECOND>" + "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate1().getTimeZone() + "</TIMEZONE>" + "</UDFDATE01>");
        if (asset.getUserDefinedFields().getUdfDate2() != null)
            userDefinedDates = userDefinedDates.concat("<UDFDATE02 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate2().getYear() + "</YEAR>" + "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate2().getMonth() + "</MONTH>" + "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate2().getDay() + "</DAY>" + "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate2().getHour() + "</HOUR>" + "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate2().getMinute() + "</MINUTE>" + "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate2().getSecond() + "</SECOND>" + "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate2().getNano() + "</SUBSECOND>" + "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate2().getTimeZone() + "</TIMEZONE>" + "</UDFDATE02>");
        if (asset.getUserDefinedFields().getUdfDate3() != null)
            userDefinedDates = userDefinedDates.concat("<UDFDATE03 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate3().getYear() + "</YEAR>" + "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate3().getMonth() + "</MONTH>" + "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate3().getDay() + "</DAY>" + "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate3().getHour() + "</HOUR>" + "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate3().getMinute() + "</MINUTE>" + "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate3().getSecond() + "</SECOND>" + "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate3().getNano() + "</SUBSECOND>" + "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate3().getTimeZone() + "</TIMEZONE>" + "</UDFDATE03>");
        if (asset.getUserDefinedFields().getUdfDate4() != null)
            userDefinedDates = userDefinedDates.concat("<UDFDATE04 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate4().getYear() + "</YEAR>" + "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate4().getMonth() + "</MONTH>" + "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate4().getDay() + "</DAY>" + "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate4().getHour() + "</HOUR>" + "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate4().getMinute() + "</MINUTE>" + "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate4().getSecond() + "</SECOND>" + "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate4().getNano() + "</SUBSECOND>" + "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate4().getTimeZone() + "</TIMEZONE>" + "</UDFDATE04>");
        if (asset.getUserDefinedFields().getUdfDate5() != null)
            userDefinedDates = userDefinedDates.concat("<UDFDATE05 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate5().getYear() + "</YEAR>" + "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate5().getMonth() + "</MONTH>" + "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate5().getDay() + "</DAY>" + "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate5().getHour() + "</HOUR>" + "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate5().getMinute() + "</MINUTE>" + "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate5().getSecond() + "</SECOND>" + "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate5().getNano() + "</SUBSECOND>" + "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate5().getTimeZone() + "</TIMEZONE>" + "</UDFDATE05>");
        if (asset.getUserDefinedFields().getUdfDate6() != null)
            userDefinedDates = userDefinedDates.concat("<UDFDATE06 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate6().getYear() + "</YEAR>" + "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate6().getMonth() + "</MONTH>" + "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate6().getDay() + "</DAY>" + "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate6().getHour() + "</HOUR>" + "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate6().getMinute() + "</MINUTE>" + "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate6().getSecond() + "</SECOND>" + "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate6().getNano() + "</SUBSECOND>" + "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate6().getTimeZone() + "</TIMEZONE>" + "</UDFDATE06>");
        if (asset.getUserDefinedFields().getUdfDate7() != null)
            userDefinedDates = userDefinedDates.concat("<UDFDATE07 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate7().getYear() + "</YEAR>" + "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate7().getMonth() + "</MONTH>" + "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate7().getDay() + "</DAY>" + "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate7().getHour() + "</HOUR>" + "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate7().getMinute() + "</MINUTE>" + "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate7().getSecond() + "</SECOND>" + "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate7().getNano() + "</SUBSECOND>" + "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate7().getTimeZone() + "</TIMEZONE>" + "</UDFDATE07>");
        if (asset.getUserDefinedFields().getUdfDate8() != null)
            userDefinedDates = userDefinedDates.concat("<UDFDATE08 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate8().getYear() + "</YEAR>" + "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate8().getMonth() + "</MONTH>" + "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate8().getDay() + "</DAY>" + "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate8().getHour() + "</HOUR>" + "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate8().getMinute() + "</MINUTE>" + "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate8().getSecond() + "</SECOND>" + "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate8().getNano() + "</SUBSECOND>" + "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate8().getTimeZone() + "</TIMEZONE>" + "</UDFDATE08>");
        if (asset.getUserDefinedFields().getUdfDate9() != null)
            userDefinedDates = userDefinedDates.concat("<UDFDATE09 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate9().getYear() + "</YEAR>" + "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate9().getMonth() + "</MONTH>" + "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate9().getDay() + "</DAY>" + "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate9().getHour() + "</HOUR>" + "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate9().getMinute() + "</MINUTE>" + "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate9().getSecond() + "</SECOND>" + "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate9().getNano() + "</SUBSECOND>" + "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate9().getTimeZone() + "</TIMEZONE>" + "</UDFDATE09>");
        if (asset.getUserDefinedFields().getUdfDate10() != null)
            userDefinedDates = userDefinedDates.concat("<UDFDATE10 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate10().getYear() + "</YEAR>" + "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate10().getMonth() + "</MONTH>" + "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate10().getDay() + "</DAY>" + "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate10().getHour() + "</HOUR>" + "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate10().getMinute() + "</MINUTE>" + "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate10().getSecond() + "</SECOND>" + "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate10().getNano() + "</SUBSECOND>" + "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getUserDefinedFields().getUdfDate10().getTimeZone() + "</TIMEZONE>" + "</UDFDATE10>");

        String checkBoxes = "";

        if (asset.getUserDefinedFields().getUdfChkBox01() != null)
            checkBoxes = checkBoxes.concat("<UDFCHKBOX01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChkBox01() + "</UDFCHKBOX01>");
        if (asset.getUserDefinedFields().getUdfChkBox02() != null)
            checkBoxes = checkBoxes.concat("<UDFCHKBOX02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChkBox02() + "</UDFCHKBOX02>");
        if (asset.getUserDefinedFields().getUdfChkBox03() != null)
            checkBoxes = checkBoxes.concat("<UDFCHKBOX03 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChkBox03() + "</UDFCHKBOX03>");
        if (asset.getUserDefinedFields().getUdfChkBox04() != null)
            checkBoxes = checkBoxes.concat("<UDFCHKBOX04 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChkBox04() + "</UDFCHKBOX04>");
        if (asset.getUserDefinedFields().getUdfChkBox05() != null)
            checkBoxes = checkBoxes.concat("<UDFCHKBOX05 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChkBox05() + "</UDFCHKBOX05>");
        if (asset.getUserDefinedFields().getUdfChkBox06() != null)
            checkBoxes = checkBoxes.concat("<UDFCHKBOX06 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChkBox06() + "</UDFCHKBOX06>");
        if (asset.getUserDefinedFields().getUdfChkBox07() != null)
            checkBoxes = checkBoxes.concat("<UDFCHKBOX07 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChkBox07() + "</UDFCHKBOX07>");
        if (asset.getUserDefinedFields().getUdfChkBox08() != null)
            checkBoxes = checkBoxes.concat("<UDFCHKBOX08 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChkBox08() + "</UDFCHKBOX08>");
        if (asset.getUserDefinedFields().getUdfChkBox09() != null)
            checkBoxes = checkBoxes.concat("<UDFCHKBOX09 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChkBox09() + "</UDFCHKBOX09>");
        if (asset.getUserDefinedFields().getUdfChkBox10() != null)
            checkBoxes = checkBoxes.concat("<UDFCHKBOX10 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfChkBox10() + "</UDFCHKBOX10>");

        String notes = "";

        if (asset.getUserDefinedFields().getUdfNote01() != null)
            notes = notes.concat("<UDFNOTE01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfNote01() + "</UDFNOTE01>");
        if (asset.getUserDefinedFields().getUdfNote02() != null)
            notes = notes.concat("<UDFNOTE02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUserDefinedFields().getUdfNote02() + "</UDFNOTE02>");

        return "<UserDefinedFields>" +
                userDefinedChars +
                userDefinedNumbers +
                userDefinedDates +
                checkBoxes +
                notes +
                "</UserDefinedFields>";
    }

    public String addFacilityConditionIndex(AssetEquipment asset) {




        if (asset.getReliabilityRankingDetails() == null) return "";

        String reliabilityRankingId = asset.getReliabilityRankingDetails().getRankingId() == null ? "" : "<RELIABILITYRANKINGID>" +
                "<RELIABILITYRANKINGCODE>" + asset.getReliabilityRankingDetails().getRankingId().getCode() + "</RELIABILITYRANKINGCODE>" +
                "<RELIABILITYRANKINGREVISION>" + asset.getReliabilityRankingDetails().getRankingId().getRevision() + "</RELIABILITYRANKINGREVISION>" +
                "<ORGANIZATIONID entity=\"BinStockDefault\">" +
                "<ORGANIZATIONCODE>" + asset.getReliabilityRankingDetails().getRankingId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + asset.getReliabilityRankingDetails().getRankingId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>" +
                "<DESCRIPTION>" + asset.getReliabilityRankingDetails().getRankingId().getDescription() + "</DESCRIPTION>" +
                "</RELIABILITYRANKINGID>";

        String reliabilityScore = asset.getReliabilityRankingDetails().getRankingScore() == null ? "" : "<RELIABILITYRANKINGSCORE qualifier=\"ACCEPTED\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getRankingScore().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getRankingScore().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getRankingScore().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getRankingScore().getUom() + "</UOM>" +
                "</RELIABILITYRANKINGSCORE>";

        String setupLastUpdate = asset.getReliabilityRankingDetails().getSetupLastUpdate() == null ? "" : "<SETUPLASTUPDATEDDATE qualifier=\"ACCOUNTING\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getSetupLastUpdate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getSetupLastUpdate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getSetupLastUpdate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getSetupLastUpdate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getSetupLastUpdate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getSetupLastUpdate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getSetupLastUpdate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getSetupLastUpdate().getTimeZone() + "</TIMEZONE>" +
                "</SETUPLASTUPDATEDDATE>";

        String surveyLastUpdate = asset.getReliabilityRankingDetails().getSurveyLastUpdate() == null ? "" : "<SURVEYLASTUPDATEDDATE qualifier=\"ACCOUNTING\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getSurveyLastUpdate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getSurveyLastUpdate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getSurveyLastUpdate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getSurveyLastUpdate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getSurveyLastUpdate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getSurveyLastUpdate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getSurveyLastUpdate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getSurveyLastUpdate().getTimeZone() + "</TIMEZONE>" +
                "</SURVEYLASTUPDATEDDATE>";

        String valueLastUpdate = asset.getReliabilityRankingDetails().getValuesLastUpdate() == null ? "" : "<VALUESLASTCALCULATEDDATE qualifier=\"ACCOUNTING\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getValuesLastUpdate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getValuesLastUpdate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getValuesLastUpdate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getValuesLastUpdate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getValuesLastUpdate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getValuesLastUpdate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getValuesLastUpdate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getReliabilityRankingDetails().getValuesLastUpdate().getTimeZone() + "</TIMEZONE>" +
                "</VALUESLASTCALCULATEDDATE>";

        return "<RELIABILITYRANKINGDETAILS xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<RELIABILITYRANKINGLOCKED>" + asset.getReliabilityRankingDetails().getRankingLocked() + "</RELIABILITYRANKINGLOCKED>" +
                "<RELIABILITYRANKINGINDEXCODE>" + asset.getReliabilityRankingDetails().getRankingIndexCode() + "</RELIABILITYRANKINGINDEXCODE>" +
                reliabilityRankingId +
                reliabilityScore +
                "<OUTOFSYNC>" + asset.getReliabilityRankingDetails().getOutOfSync() + "</OUTOFSYNC>" +
                setupLastUpdate +
                surveyLastUpdate +
                valueLastUpdate +
                "</RELIABILITYRANKINGDETAILS>";
    }

    public String addEquipmentAlias(AssetEquipment asset) {
        return "<EQUIPMENTALIAS xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getEquipmentAlias() + "</EQUIPMENTALIAS>";
    }

    public String addEnergyPerformance(AssetEquipment asset) {
        if (asset.getEnergyPerformance() == null) return "";

        String targetPowerFactor = asset.getEnergyPerformance().getTargetPowerFactor() == null ? "" : "<TARGETPOWERFACTOR qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getTargetPowerFactor().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getTargetPowerFactor().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getTargetPowerFactor().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getTargetPowerFactor().getUom() + "</UOM>" +
                "</TARGETPOWERFACTOR>";

        String targetPeakDemand = asset.getEnergyPerformance().getTargetPeakDemand() == null ? "" : "<TARGETPEAKDEMAND qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getTargetPeakDemand().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getTargetPeakDemand().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getTargetPeakDemand().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getTargetPeakDemand().getUom() + "</UOM>" +
                "</TARGETPEAKDEMAND>";

        String billingStartDate = asset.getEnergyPerformance().getBillingPeriodStartDate() == null ? "" : "<BILLINGPERIODSTARTDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getBillingPeriodStartDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getBillingPeriodStartDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getBillingPeriodStartDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getBillingPeriodStartDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getBillingPeriodStartDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getBillingPeriodStartDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getBillingPeriodStartDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getBillingPeriodStartDate().getTimeZone() + "</TIMEZONE>" +
                "</BILLINGPERIODSTARTDATE>";

        String billingPeriod = asset.getEnergyPerformance().getBillEveryPeriod() == null ? "" : "<BILLEVERYPERIOD qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getBillEveryPeriod().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getBillEveryPeriod().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getBillEveryPeriod().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getBillEveryPeriod().getUom() + "</UOM>" +
                "</BILLEVERYPERIOD>";

        String billingEvery = asset.getEnergyPerformance().getBillEveryUom() == null ? "" : "<BILLEVERYUOM xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<PERIODUOMCODE>" + asset.getEnergyPerformance().getBillEveryUom().getCode() + "</PERIODUOMCODE>" +
                "<DESCRIPTION>" + asset.getEnergyPerformance().getBillEveryUom().getDescription() + "</DESCRIPTION>" +
                "</BILLEVERYUOM>";

        String phaseImbalances = "";

        if (asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost1() != null)
            phaseImbalances = phaseImbalances.concat("<PHASEIMBALANCEEFFICIENCYLOSS1 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost1().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost1().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost1().getSign() + "</SIGN>" + "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost1().getUom() + "</UOM>" + "</PHASEIMBALANCEEFFICIENCYLOSS1>");
        if (asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost2() != null)
            phaseImbalances = phaseImbalances.concat("<PHASEIMBALANCEEFFICIENCYLOSS2 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost2().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost2().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost2().getSign() + "</SIGN>" + "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost2().getUom() + "</UOM>" + "</PHASEIMBALANCEEFFICIENCYLOSS2>");
        if (asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost3() != null)
            phaseImbalances = phaseImbalances.concat("<PHASEIMBALANCEEFFICIENCYLOSS3 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost3().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost3().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost3().getSign() + "</SIGN>" + "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost3().getUom() + "</UOM>" + "</PHASEIMBALANCEEFFICIENCYLOSS3>");
        if (asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost4() != null)
            phaseImbalances = phaseImbalances.concat("<PHASEIMBALANCEEFFICIENCYLOSS4 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost4().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost4().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost4().getSign() + "</SIGN>" + "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost4().getUom() + "</UOM>" + "</PHASEIMBALANCEEFFICIENCYLOSS4>");
        if (asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost5() != null)
            phaseImbalances = phaseImbalances.concat("<PHASEIMBALANCEEFFICIENCYLOSS5 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost5().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost5().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost5().getSign() + "</SIGN>" + "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getPhaseInBalanceEfficiencyLost5().getUom() + "</UOM>" + "</PHASEIMBALANCEEFFICIENCYLOSS5>");

        String performanceManager = asset.getEnergyPerformance().getPerformanceManager() == null ? "" : "<PERFORMANCEMANAGER xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<PERSONCODE>" + asset.getEnergyPerformance().getPerformanceManager().getCode() + "</PERSONCODE>" +
                "<DESCRIPTION>" + asset.getEnergyPerformance().getPerformanceManager().getDescription() + "</DESCRIPTION>" +
                "</PERFORMANCEMANAGER>";

        String electricSub = asset.getEnergyPerformance().getElectricSubMeterInterval() == null ? "" : "<ELECTRICSUBMETERINTERVAL qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getElectricSubMeterInterval().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getElectricSubMeterInterval().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getElectricSubMeterInterval().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getElectricSubMeterInterval().getUom() + "</UOM>" +
                "</ELECTRICSUBMETERINTERVAL>";

        String electricThreshold = asset.getEnergyPerformance().getElectricUsageThreshold() == null ? "" : "<ELECTRICUSAGETHRESHOLD qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getElectricUsageThreshold().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getElectricUsageThreshold().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getElectricUsageThreshold().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEnergyPerformance().getElectricUsageThreshold().getUom() + "</UOM>" +
                "</ELECTRICUSAGETHRESHOLD>";

        return "<EnergyPerformance>" +
                targetPowerFactor +
                targetPeakDemand +
                billingStartDate +
                billingPeriod +
                billingEvery +
                phaseImbalances +
                performanceManager +
                electricSub +
                electricThreshold +
                "</EnergyPerformance>";
    }

    public String addReviewRequiredBy(AssetEquipment asset) {
        if (asset.getSafetyDateReviewRequired() == null && asset.getSafetyReviewedBy() == null && asset.getPermitDateReviewRequired() == null && asset.getPermitReviewedBy() == null)
            return "";
        return "<SAFETYDATEREVIEWREQUIRED qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getSafetyDateReviewRequired().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getSafetyDateReviewRequired().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getSafetyDateReviewRequired().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getSafetyDateReviewRequired().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getSafetyDateReviewRequired().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getSafetyDateReviewRequired().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getSafetyDateReviewRequired().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getSafetyDateReviewRequired().getTimeZone() + "</TIMEZONE>" +
                "</SAFETYDATEREVIEWREQUIRED>" +
                "<SAFETYREVIEWEDBY xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<USERCODE>" + asset.getSafetyReviewedBy().getCode() + "</USERCODE>" +
                "<DESCRIPTION>" + asset.getSafetyReviewedBy().getDescription() + "</DESCRIPTION>" +
                "</SAFETYREVIEWEDBY>" +
                "<PERMITDATEREVIEWREQUIRED qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPermitDateReviewRequired().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPermitDateReviewRequired().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPermitDateReviewRequired().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPermitDateReviewRequired().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPermitDateReviewRequired().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPermitDateReviewRequired().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPermitDateReviewRequired().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPermitDateReviewRequired().getTimeZone() + "</TIMEZONE>" +
                "</PERMITDATEREVIEWREQUIRED>" +
                "<PERMITREVIEWEDBY xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<USERCODE>" + asset.getPermitReviewedBy().getCode() + "</USERCODE>" +
                "<DESCRIPTION>" + asset.getPermitReviewedBy().getDescription() + "</DESCRIPTION>" +
                "</PERMITREVIEWEDBY>";
    }

    public String addLoto(AssetEquipment asset) {
        if (asset.getLotoDateReviewRequired() == null && asset.getLotoReviewedBy() == null) return "";
        return "<LOTODATEREVIEWREQUIRED qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLotoDateReviewRequired().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLotoDateReviewRequired().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLotoDateReviewRequired().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLotoDateReviewRequired().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLotoDateReviewRequired().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLotoDateReviewRequired().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLotoDateReviewRequired().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLotoDateReviewRequired().getTimeZone() + "</TIMEZONE>" +
                "</LOTODATEREVIEWREQUIRED>" +
                "<LOTOREVIEWEDBY xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<USERCODE>" + asset.getLotoReviewedBy().getCode() + "</USERCODE>" +
                "<DESCRIPTION>" + asset.getLotoReviewedBy().getDescription() + "</DESCRIPTION>" +
                "</LOTOREVIEWEDBY>";
    }

    public String addEquipmentConfiguration(AssetEquipment asset) {
        if (asset.getEquipmentConfigurationId() == null) return "";
        return "<EQUIPMENTCONFIGURATIONID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<EQUIPMENTCONFIGURATIONCODE>" + asset.getEquipmentConfigurationId().getCode() + "</EQUIPMENTCONFIGURATIONCODE>" +
                "<ORGANIZATIONID entity=\"BinStock\">" +
                "<ORGANIZATIONCODE>" + asset.getEquipmentConfigurationId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + asset.getEquipmentConfigurationId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>" +
                "<REVISIONNUM qualifier=\"ACCEPTED\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEquipmentConfigurationId().getRevisionNum().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEquipmentConfigurationId().getRevisionNum().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEquipmentConfigurationId().getRevisionNum().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEquipmentConfigurationId().getRevisionNum().getUom() + "</UOM>" +
                "</REVISIONNUM>" +
                "<DESCRIPTION>" + asset.getEquipmentConfigurationId().getDescription() + "</DESCRIPTION>" +
                "</EQUIPMENTCONFIGURATIONID>";
    }

    public String addRcmLevel(AssetEquipment asset) {
        if (asset.getRcmLevel() == null) return "";
        return "<RCMLEVELID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<ENTITY>" + asset.getRcmLevel().getEntity() + "</ENTITY>" +
                "<USERDEFINEDCODE>" + asset.getRcmLevel().getCode() + "</USERDEFINEDCODE>" +
                "<DESCRIPTION>" + asset.getRcmLevel().getDescription() + "</DESCRIPTION>" +
                "</RCMLEVELID>";
    }

    public String addRisk(AssetEquipment asset) {
        if (asset.getRiskMatrixSetup() == null) return "";
        return "<RISKMATRIXSETUPID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<RISKMATRIXSETUPCODE>" + asset.getRiskMatrixSetup().getCode() + "</RISKMATRIXSETUPCODE>" +
                "<DESCRIPTION>" + asset.getRiskMatrixSetup().getDescription() + "</DESCRIPTION>" +
                "</RISKMATRIXSETUPID>" +
                "<RISKPRIORITYNUMBER qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getRiskPriorityNumber().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getRiskPriorityNumber().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getRiskPriorityNumber().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getRiskPriorityNumber().getUom() + "</UOM>" +
                "</RISKPRIORITYNUMBER>";
    }

    public String addReceiptInstallDate(AssetEquipment asset) {
        if (asset.getOriginalReceiptDate() == null && asset.getLatestReceiptDate() == null && asset.getOriginalInstallDateNew() == null && asset.getLatestInstallDateNew() == null)
            return "";

        String originalReceiptDate = asset.getOriginalReceiptDate() == null ? "" : "<ORIGINALRECEIPTDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getOriginalReceiptDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getOriginalReceiptDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getOriginalReceiptDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getOriginalReceiptDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getOriginalReceiptDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getOriginalReceiptDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getOriginalReceiptDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getOriginalReceiptDate().getTimeZone() + "</TIMEZONE>" +
                "</ORIGINALRECEIPTDATE>";

        String lastReceiptDate = asset.getLatestReceiptDate() == null ? "" : "<LATESTRECEIPTDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLatestReceiptDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLatestReceiptDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLatestReceiptDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLatestReceiptDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLatestReceiptDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLatestReceiptDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLatestReceiptDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLatestReceiptDate().getTimeZone() + "</TIMEZONE>" +
                "</LATESTRECEIPTDATE>";

        String originalInstallDate = asset.getOriginalInstallDateNew() == null ? "" : "<ORIGINALINSTALLDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getOriginalInstallDateNew().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getOriginalInstallDateNew().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getOriginalInstallDateNew().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getOriginalInstallDateNew().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getOriginalInstallDateNew().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getOriginalInstallDateNew().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getOriginalInstallDateNew().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getOriginalInstallDateNew().getTimeZone() + "</TIMEZONE>" +
                "</ORIGINALINSTALLDATE>";

        String latestInstallDate = asset.getLatestInstallDateNew() == null ? "" : "<LATESTINSTALLDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLatestInstallDateNew().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLatestInstallDateNew().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLatestInstallDateNew().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLatestInstallDateNew().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLatestInstallDateNew().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLatestInstallDateNew().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLatestInstallDateNew().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getLatestInstallDateNew().getTimeZone() + "</TIMEZONE>" +
                "</LATESTINSTALLDATE>";

        return originalReceiptDate +
                lastReceiptDate +
                originalInstallDate +
                latestInstallDate;
    }

    public String addDocuReservationWorkSpace(AssetEquipment asset) {

        String reservationCalendarOwner = asset.getReservationCalendarOwner() == null ? "" : "<RESERVATIONCALENDAROWNER xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<USERCODE>" + asset.getReservationCalendarOwner().getCode() + "</USERCODE>" +
                "<DESCRIPTION>" + asset.getReservationCalendarOwner().getDescription() + "</DESCRIPTION>" +
                "</RESERVATIONCALENDAROWNER>";

        String reservationCalendarList = asset.getReservationCalendarOwnerList() == null ? "" : "<RESERVATIONCALENDAROWNERSLIST xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<APPROVALLISTCODE>" + asset.getReservationCalendarOwnerList().getCode() + "</APPROVALLISTCODE>" +
                "<DESCRIPTION>" + asset.getReservationCalendarOwnerList().getDescription() + "</DESCRIPTION>" +
                "<ORGANIZATIONID entity=\"LocationDefault\">" +
                "<ORGANIZATIONCODE>" + asset.getReservationCalendarOwnerList().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + asset.getReservationCalendarOwnerList().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>" +
                "</RESERVATIONCALENDAROWNERSLIST>";

        String workSpace = asset.getWorkSpace() == null ? "" : "<WORKSPACEID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<WORKSPACENUMBER>" + asset.getWorkSpace().getNumber() + "</WORKSPACENUMBER>" +
                "<WORKSPACECODE>" + asset.getWorkSpace().getCode() + "</WORKSPACECODE>" +
                "<ORGANIZATIONID entity=\"EquipmentHierarchy\">" +
                "<ORGANIZATIONCODE>" + asset.getWorkSpace().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + asset.getWorkSpace().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>" +
                "<DESCRIPTION>" + asset.getWorkSpace().getDescription() + "</DESCRIPTION>" +
                "</WORKSPACEID>";

        return "<DOCUMOTOBOOKID xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getDocuMotoBook() + "</DOCUMOTOBOOKID>" +
                reservationCalendarOwner +
                reservationCalendarList +
                workSpace;
    }

    public String addSet(AssetEquipment asset) {
        if (asset.getSetId() == null) return "";

        String org = asset.getSetId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"PositionHierarchy\">" +
                "<ORGANIZATIONCODE>" + asset.getSetId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + asset.getSetId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";


        return "<SETID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<SETCONSISTPK>" + asset.getSetId().getPk() + "</SETCONSISTPK>" +
                "<SETCONSISTCODE>" + asset.getSetId().getCode() + "</SETCONSISTCODE>" +
                "<DESCRIPTION>" + asset.getSetId().getDescription() + "</DESCRIPTION>" +
                org +
                "</SETID>" +
                "<SETPOSITION xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getSetPosition() + "</SETPOSITION>";
    }

    public String addConsist(AssetEquipment asset) {
        if (asset.getConsistId() == null) return "";

        String org = asset.getConsistId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"SystemHierarchy\">" +
                "<ORGANIZATIONCODE>" + asset.getConsistId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + asset.getConsistId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        return "<CONSISTID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<SETCONSISTPK>" + asset.getConsistId().getPk() + "</SETCONSISTPK>" +
                "<SETCONSISTCODE>" + asset.getConsistId().getCode() + "</SETCONSISTCODE>" +
                "<DESCRIPTION>" + asset.getConsistId().getDescription() + "</DESCRIPTION>" +
                org +
                "</CONSISTID>" +
                "<CONSISTPOSITION xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getConsistPosition() + "</CONSISTPOSITION>";
    }

    public String addURLCondition(AssetEquipment asset) {

        String conditionScore = asset.getConditionScore() == null ? "" : "<CONDITIONSCORE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getConditionScore().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getConditionScore().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getConditionScore().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getConditionScore().getUom() + "</UOM>" +
                "</CONDITIONSCORE>";

        String conditionIndex = asset.getConditionIndex() == null ? "" : "<CONDITIONINDEX xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<ENTITY>" + asset.getConditionIndex().getEntity() + "</ENTITY>" +
                "<USERDEFINEDCODE>" + asset.getConditionIndex().getCode() + "</USERDEFINEDCODE>" +
                "<DESCRIPTION>" + asset.getConditionIndex().getDescription() + "</DESCRIPTION>" +
                "</CONDITIONINDEX>";

        return "<URL xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getUrl() + "</URL>" +
                conditionIndex +
                conditionScore;
    }

    public String addProcessErrortoDriver(AssetEquipment asset) {
        String linearUomId = asset.getLinearUom() == null ? "" : "<LINEARUOMID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<LINEARREFUOM>" + asset.getLinearUom().getCode() + "</LINEARREFUOM>" +
                "<DESCRIPTION>" + asset.getLinearUom().getDescription() + "</DESCRIPTION>" +
                "</LINEARUOMID>";

        String driver = asset.getDriver() == null ? "" : "<DRIVER xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<EMPLOYEECODE>" + asset.getDriver().getCode() + "</EMPLOYEECODE>" +
                "<DESCRIPTION>" + asset.getDriver().getDescription() + "</DESCRIPTION>" +
                "<ORGANIZATIONID entity=\"AssetHierarchy\">" +
                "<ORGANIZATIONCODE>" + asset.getDriver().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + asset.getDriver().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>" +
                "</DRIVER>";

        return "<PROCESSERROR xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getProcessError() + "</PROCESSERROR>" +
                linearUomId +
                "<EQUIPMENTLENGTHOVERRIDE xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getEquipmentLengthOverride() + "</EQUIPMENTLENGTHOVERRIDE>" +
                "<TEMPMONITORED xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getTempMonitored() + "</TEMPMONITORED>" +
                driver;
    }

    public String addPhoneNumberToOwnerShipType(AssetEquipment asset) {

        String umdNs = asset.getUmdns() == null ? "" : "<UMDNS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<TYPECODE>" + asset.getUmdns().getCode() + "</TYPECODE>" +
                "<DESCRIPTION>" + asset.getUmdns().getDescription() + "</DESCRIPTION>" +
                "</UMDNS>";

        String coverageType = asset.getCoverageType() == null ? "" : "<COVERAGETYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<TYPECODE>" + asset.getCoverageType().getCode() + "</TYPECODE>" +
                "<DESCRIPTION>" + asset.getCoverageType().getDescription() + "</DESCRIPTION>" +
                "</COVERAGETYPE>";

        String ownerShipType = asset.getOwnerShipType() == null ? "" : "<OWNERSHIPTYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<TYPECODE>" + asset.getOwnerShipType().getCode() + "</TYPECODE>" +
                "<DESCRIPTION>" + asset.getOwnerShipType().getDescription() + "</DESCRIPTION>" +
                "</OWNERSHIPTYPE>";

        return "<PHONENUMBER xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getPhoneNumber() + "</PHONENUMBER>" +
                "<ACCESSIBLE xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getAccessible() + "</ACCESSIBLE>" +
                "<NONSMOKING xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getNonSmoking() + "</NONSMOKING>" +
                "<HARDWAREVER xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getHardwareVer() + "</HARDWAREVER>" +
                "<SOFTWAREVER xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getSoftwareVer() + "</SOFTWAREVER>" +
                "<PURCHASINGASSET xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getPurchasingAsset() + "</PURCHASINGASSET>" +
                "<BIOMEDICALASSET xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getBioMedicalAsset() + "</BIOMEDICALASSET>" +
                umdNs +
                "<OEMSITE xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getOemSite() + "</OEMSITE>" +
                "<VENDOR xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getVendor() + "</VENDOR>" +
                coverageType +
                "<LOCKOUT xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getLockout() + "</LOCKOUT>" +
                "<PERSONALPROTECTIVEEQUIP xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getPersonalProtectiveEquipment() + "</PERSONALPROTECTIVEEQUIP>" +
                "<CONFINEDSPACE xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getConfinedSpace() + "</CONFINEDSPACE>" +
                "<STATEMENTOFCOND xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getStatementOfCond() + "</STATEMENTOFCOND>" +
                "<BUILDMAINTPROGRAM xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getBuildMaintenanceProgram() + "</BUILDMAINTPROGRAM>" +
                "<HIPAACONFIDENTIALITY xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getHipaaConfidentiality() + "</HIPAACONFIDENTIALITY>" +
                ownerShipType;
    }

    public String addPurchase(AssetEquipment asset) {

        String purchaseDate = asset.getPurchaseDateNew() == null ? "" : "<PURCHASEDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPurchaseDateNew().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPurchaseDateNew().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPurchaseDateNew().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPurchaseDateNew().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPurchaseDateNew().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPurchaseDateNew().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPurchaseDateNew().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPurchaseDateNew().getTimeZone() + "</TIMEZONE>" +
                "</PURCHASEDATE>";

        String purchaseCost = asset.getPurchaseCost() == null ? "" : "<PURCHASECOST qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPurchaseCost().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPurchaseCost().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPurchaseCost().getSign() + "</SIGN>" +
                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPurchaseCost().getCurrency() + "</CURRENCY>" +
                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getPurchaseCost().getDRCR() + "</DRCR>" +
                "</PURCHASECOST>";

        String purchaseCurrency = asset.getPurchaseCurrency() == null ? "" : "<PURCHASECURRENCY xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<CURRENCYCODE>" + asset.getPurchaseCurrency().getCode() + "</CURRENCYCODE>" +
                "<DESCRIPTION>" + asset.getPurchaseCurrency().getDescription() + "</DESCRIPTION>" +
                "</PURCHASECURRENCY>";

        return "<PURCHASEORDERCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getPurchaseOrderCode() + "</PURCHASEORDERCODE>" +
                purchaseDate +
                purchaseCost +
                purchaseCurrency;
    }

    public String addDisposalTypeToRiskPriority(AssetEquipment asset) {

        String disposalType = asset.getDisposalType() == null ? "" : "<DISPOSALTYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<TYPECODE>" + asset.getDisposalType().getCode() + "</TYPECODE>" +
                "<DESCRIPTION>" + asset.getDisposalType().getDescription() + "</DESCRIPTION>" +
                "</DISPOSALTYPE>";

        String toleranceSize = asset.getToleranceSize() == null ? "" : "<TOLERANCESIZE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getToleranceSize().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getToleranceSize().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getToleranceSize().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getToleranceSize().getUom() + "</UOM>" +
                "</TOLERANCESIZE>";

        String fuelId = asset.getFuelId() == null ? "" : "<FUELID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<FUELCODE>" + asset.getFuelId().getCode() + "</FUELCODE>" +
                "<DESCRIPTION>" + asset.getFuelId().getDescription() + "</DESCRIPTION>" +
                "</FUELID>";

        return disposalType +
                "<CHECKLISTFILTER xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getCheckListFilter() + "</CHECKLISTFILTER>" +
                toleranceSize +
                fuelId +
                "<RISKPRIORITYCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getRiskPriorityCode() + "</RISKPRIORITYCODE>";
    }

    public String addCriticalityToCorrectionUseageUom(AssetEquipment asset) {

        String criticalityScore = asset.getCriticalityScore() == null ? "" : "<CRITICALITYSCORE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCriticalityScore().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCriticalityScore().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCriticalityScore().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCriticalityScore().getUom() + "</UOM>" +
                "</CRITICALITYSCORE>";

        String correctionConditionScore = asset.getCorrectionConditionScore() == null ? "" : "<CORRECTIONCONDITIONSCORE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCorrectionConditionScore().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCorrectionConditionScore().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCorrectionConditionScore().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCorrectionConditionScore().getUom() + "</UOM>" +
                "</CORRECTIONCONDITIONSCORE>";

        String correctionConditionDate = asset.getCorrectionConditionDate() == null ? "" : "<CORRECTIONCONDITIONDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCorrectionConditionDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCorrectionConditionDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCorrectionConditionDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCorrectionConditionDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCorrectionConditionDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCorrectionConditionDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCorrectionConditionDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCorrectionConditionDate().getTimeZone() + "</TIMEZONE>" +
                "</CORRECTIONCONDITIONDATE>";

        String correctionUsage = asset.getCorrectionUsage() == null ? "" : "<CORRECTIONUSAGE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCorrectionUsage().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCorrectionUsage().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCorrectionUsage().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getCorrectionUsage().getUom() + "</UOM>" +
                "</CORRECTIONUSAGE>";

        String correctionUsageUom = asset.getCorrectionUsageUom() == null ? "" : "<CORRECTIONUSAGEUOM xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<UOMCODE>" + asset.getCorrectionUsageUom().getCode() + "</UOMCODE>" +
                "<DESCRIPTION>" + asset.getCorrectionUsageUom().getDescription() + "</DESCRIPTION>" +
                "</CORRECTIONUSAGEUOM>";

        return criticalityScore +
                correctionConditionScore +
                "<CORRECTIONCONDITIONREASON xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getCorrectionConditionReason() + "</CORRECTIONCONDITIONREASON>" +
                correctionConditionDate +
                correctionUsage +
                correctionUsageUom;
    }

    public String addLifeToProfile(AssetEquipment asset) {

        String endUsefulLife = asset.getEndUsefulLife() == null ? "" : "<ENDUSEFULLIFE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEndUsefulLife().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEndUsefulLife().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEndUsefulLife().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEndUsefulLife().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEndUsefulLife().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEndUsefulLife().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEndUsefulLife().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getEndUsefulLife().getTimeZone() + "</TIMEZONE>" +
                "</ENDUSEFULLIFE>";

        String remainingUsefulLife = asset.getRemainingUsefulLife() == null ? "" : "<REMAININGUSEFULLIFE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getRemainingUsefulLife().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getRemainingUsefulLife().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getRemainingUsefulLife().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getRemainingUsefulLife().getUom() + "</UOM>" +
                "</REMAININGUSEFULLIFE>";

        String serviceLifeUsage = asset.getServiceLifeUsage() == null ? "" : "<SERVICELIFEUSAGE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getServiceLifeUsage().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getServiceLifeUsage().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getServiceLifeUsage().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getServiceLifeUsage().getUom() + "</UOM>" +
                "</SERVICELIFEUSAGE>";

        String serviceLifeUsageUom = asset.getServiceLifeUsageUom() == null ? "" : "<SERVICELIFEUSAGEUOM xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<UOMCODE>" + asset.getServiceLifeUsageUom().getCode() + "</UOMCODE>" +
                "<DESCRIPTION>" + asset.getServiceLifeUsageUom().getDescription() + "</DESCRIPTION>" +
                "</SERVICELIFEUSAGEUOM>";

        String profilePicture = asset.getProfilePicture() == null ? "" : "<PROFILEPICTURE xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<DOCUMENTCODE>" + asset.getProfilePicture().getCode() + "</DOCUMENTCODE>" +
                "<ORGANIZATIONID entity=\"AssetEquipmentByProfile\">" +
                "<ORGANIZATIONCODE>" + asset.getProfilePicture().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + asset.getProfilePicture().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>" +
                "<DESCRIPTION>" + asset.getProfilePicture().getDescription() + "</DESCRIPTION>" +
                "</PROFILEPICTURE>";

        return endUsefulLife +
                remainingUsefulLife +
                serviceLifeUsage +
                serviceLifeUsageUom +
                profilePicture;
    }



    public String addEnding(AssetEquipment asset) {

        String currencyCode = asset.getCurrencyCode() == null ? "" : "<CURRENCYCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getCurrencyCode() + "</CURRENCYCODE>";
        String blackSwanCost = asset.getBlackSwanCost() == null ? "" : "<BLACKSWANCOST qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getBlackSwanCost().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getBlackSwanCost().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getBlackSwanCost().getSign() + "</SIGN>" + "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getBlackSwanCost().getCurrency() + "</CURRENCY>" + "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getBlackSwanCost().getDRCR() + "</DRCR>" + "</BLACKSWANCOST>";
        String blackSwan = asset.getBlackSwan() == null ? "" : "<BLACKSWAN xmlns=\"http://schemas.datastream.net/MP_fields\">" + asset.getBlackSwan() + "</BLACKSWAN>";
        String failurePerc = asset.getFailureProbPercentage() == null ? "" : "<FAILUREPROBPERCENTAGE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getFailureProbPercentage().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getFailureProbPercentage().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getFailureProbPercentage().getSign() + "</SIGN>" + "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getFailureProbPercentage().getUom() + "</UOM>" + "</FAILUREPROBPERCENTAGE>";
        String riskCon = asset.getRiskConsequenceCost() == null ? "" : "<RISKCONSEQUENCECOST qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getRiskConsequenceCost().getValue() + "</VALUE>" + "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getRiskConsequenceCost().getDecimals() + "</NUMOFDEC>" + "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getRiskConsequenceCost().getSign() + "</SIGN>" + "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getRiskConsequenceCost().getCurrency() + "</CURRENCY>" + "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + asset.getRiskConsequenceCost().getDRCR() + "</DRCR>" + "</RISKCONSEQUENCECOST>";

        return riskCon + failurePerc + blackSwan + blackSwanCost + currencyCode;
    }
}
