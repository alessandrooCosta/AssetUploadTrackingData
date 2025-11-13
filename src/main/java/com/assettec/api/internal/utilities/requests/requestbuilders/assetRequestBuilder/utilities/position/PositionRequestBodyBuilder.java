package com.assettec.api.internal.utilities.requests.requestbuilders.assetRequestBuilder.utilities.position;

import com.assettec.api.internal.core.entities.asset.position.AssetPosition;
import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.requests.requestbuilders.common.XMLRequestHeader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PositionRequestBodyBuilder {

    private XMLRequestHeader xmlRequestHeader;

    public String buildBody(ApiUser apiUser, AssetPosition position) {

        String id = "<POSITIONID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<EQUIPMENTCODE>" + position.getPositionId().getCode() + "</EQUIPMENTCODE>" +
                "<ORGANIZATIONID entity=\"User\">" +
                "<ORGANIZATIONCODE>" + position.getPositionId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + position.getPositionId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>" +
                "<DESCRIPTION>" + position.getPositionId().getDescription() + "</DESCRIPTION>" +
                "</POSITIONID>";

        String type = position.getType() == null ? "" : "<TYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<TYPECODE>" + position.getType().getCode() + "</TYPECODE>" +
                "<DESCRIPTION>" + position.getType().getDescription() + "</DESCRIPTION>" +
                "</TYPE>";

        String classIdOrg =  position.getClassId() == null || position.getClassId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"Organization\">" +
                "<ORGANIZATIONCODE>" + position.getClassId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + position.getClassId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String classId = position.getClassId() == null ? "" : "<CLASSID entity=\"ent1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<CLASSCODE>" + position.getClassId().getCode() + "</CLASSCODE>" +
                classIdOrg +
                "<DESCRIPTION>" + position.getClassId().getDescription() + "</DESCRIPTION>" +
                "</CLASSID>";

        String categoryId = position.getCategoryId() == null ? "" : "<CATEGORYID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<CATEGORYCODE>" + position.getCategoryId().getCode() + "</CATEGORYCODE>" +
                "<DESCRIPTION>" + position.getCategoryId().getDescription() + "</DESCRIPTION>" +
                "</CATEGORYID>";

        String status = position.getStatus() == null ? "" : "<STATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<STATUSCODE>" + position.getStatus().getCode() + "</STATUSCODE>" +
                "<DESCRIPTION>" + position.getStatus().getDescription() + "</DESCRIPTION>" +
                "</STATUS>";

        String departmentOrg = position.getDepartmentId() == null || position.getDepartmentId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"Group\">" +
                "<ORGANIZATIONCODE>" + position.getDepartmentId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "</ORGANIZATIONID>";

        String departmentId = position.getDepartmentId() == null ? "" : "<DEPARTMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<DEPARTMENTCODE>" + position.getDepartmentId().getCode() + "</DEPARTMENTCODE>" +
                departmentOrg +
                "<DESCRIPTION>" + position.getDepartmentId().getDescription() + "</DESCRIPTION>" +
                "</DEPARTMENTID>";

        String operationalStatus = position.getOperationalStatus() == null ? "" : "<OPERATIONALSTATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<STATUSCODE>" + position.getOperationalStatus().getCode() + "</STATUSCODE>" +
                "<DESCRIPTION>" + position.getOperationalStatus().getDescription() + "</DESCRIPTION>" +
                "</OPERATIONALSTATUS>";

        String loanedOrg = position.getLoanedToDepartmentId() == null || position.getLoanedToDepartmentId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"Class\">" +
                "<ORGANIZATIONCODE>" + position.getLoanedToDepartmentId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + position.getLoanedToDepartmentId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String loanedToDepartment = position.getLoanedToDepartmentId() == null ? "" : "<LOANEDTODEPARTMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<DEPARTMENTCODE>" + position.getLoanedToDepartmentId().getCode() + "</DEPARTMENTCODE>" +
                loanedOrg +
                "<DESCRIPTION>" + position.getLoanedToDepartmentId().getDescription() + "</DESCRIPTION>" +
                "</LOANEDTODEPARTMENTID>";

        String pmWoDepartOrg = position.getPmWoDepartment() == null || position.getPmWoDepartment().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"Department\">" +
                "<ORGANIZATIONCODE>" + position.getPmWoDepartment().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + position.getPmWoDepartment().getOrganization().getCode() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String pmWoDepartmentId = position.getPmWoDepartment() == null ? "" : "<PMWODEPARTMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<DEPARTMENTCODE>" + position.getPmWoDepartment().getCode() + "</DEPARTMENTCODE>" +
                pmWoDepartOrg +
                "<DESCRIPTION>" + position.getPmWoDepartment().getDescription() + "</DESCRIPTION>" +
                "</PMWODEPARTMENTID>";

        String inProduction = position.getInProduction() == null ? "" : "<INPRODUCTION xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getInProduction() + "</INPRODUCTION>";

        String safety = position.getSafety() == null ? "" : "<SAFETY xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getSafety() + "</SAFETY>";

        String outOfService = position.getOutOfService() == null ? "" : "<OUTOFSERVICE xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getOutOfService() + "</OUTOFSERVICE>";

        String profileIdOrg = position.getProfileId() == null || position.getProfileId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"Personnel\">" +
                "<ORGANIZATIONCODE>" + position.getProfileId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + position.getProfileId().getOrganization().getCode() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String profileId = position.getProfileId() == null ? "" : "<PROFILEID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<OBJECTCODE>" + position.getProfileId().getCode() + "</OBJECTCODE>" +
                profileIdOrg +
                "<DESCRIPTION>" + position.getProfileId().getDescription() + "</DESCRIPTION>" +
                "</PROFILEID>";

        String costCodeOrg = position.getCostCodeId() == null || position.getCostCodeId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"OrganizationValidity\">" +
                "<ORGANIZATIONCODE>" + position.getCostCodeId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + position.getCostCodeId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String costCodeId = position.getCostCodeId() == null ? "" : "<COSTCODEID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<COSTCODE>" + position.getCostCodeId().getCode() + "</COSTCODE>" +
                "<DESCRIPTION>" + position.getCostCodeId().getDescription() + "</DESCRIPTION>" +
                costCodeOrg +
                "</COSTCODEID>";

        String commissionDate = position.getCommissionDate() == null ? "" : "<COMMISSIONDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCommissionDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCommissionDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCommissionDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCommissionDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCommissionDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCommissionDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCommissionDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCommissionDate().getTimeZone() + "</TIMEZONE>" +
                "</COMMISSIONDATE>";

        String transferDate = position.getTransferDate() == null ? "" : "<TRANSFERDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getTransferDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getTransferDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getTransferDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getTransferDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getTransferDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getTransferDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getTransferDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getTransferDate().getTimeZone() + "</TIMEZONE>" +
                "</TRANSFERDATE>";

        String withdrawalDate = position.getWithdrawalDate() == null ? "" : "<WITHDRAWALDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getWithdrawalDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getWithdrawalDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getWithdrawalDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getWithdrawalDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getWithdrawalDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getWithdrawalDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getWithdrawalDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getWithdrawalDate().getTimeZone() + "</TIMEZONE>" +
                "</WITHDRAWALDATE>";

        String assignedTo = position.getAssignedTo() == null ? "" : "<ASSIGNEDTO xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<PERSONCODE>" + position.getAssignedTo().getCode() + "</PERSONCODE>" +
                "<DESCRIPTION>" + position.getAssignedTo().getDescription() + "</DESCRIPTION>" +
                "</ASSIGNEDTO>";

        String meterUnit = position.getMeterUnit() == null ? "" : "<METERUNIT xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getMeterUnit() + "</METERUNIT>";

        String criticalityId = position.getCriticalityId() == null ? "" : "<CRITICALITYID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<CRITICALITY>" + position.getCriticalityId().getCode() + "</CRITICALITY>" +
                "<DESCRIPTION>" + position.getCriticalityId().getDescription() + "</DESCRIPTION>" +
                "</CRITICALITYID>";

        String soldDate = position.getSoldDate() == null ? "" : "<SOLDDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getSoldDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getSoldDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getSoldDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getSoldDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getSoldDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getSoldDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getSoldDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getSoldDate().getTimeZone() + "</TIMEZONE>" +
                "</SOLDDATE>";

//        String dormantStart = position.getDormant() == null || position.getDormant().getStart() == null ? "" : "<DORMANTSTART qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getDormant().getStart().getYear() + "</YEAR>" +
//                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getDormant().getStart().getMonth() + "</MONTH>" +
//                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getDormant().getStart().getDay() + "</DAY>" +
//                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getDormant().getStart().getHour() + "</HOUR>" +
//                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getDormant().getStart().getMinute() + "</MINUTE>" +
//                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getDormant().getStart().getSecond() + "</SECOND>" +
//                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getDormant().getStart().getNano() + "</SUBSECOND>" +
//                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getDormant().getStart().getTimeZone() + "</TIMEZONE>" +
//                "</DORMANTSTART>";
//
//        String dormantEnd = position.getDormant() == null || position.getDormant().getEnd() == null ? "" : "<DORMANTEND qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getDormant().getEnd().getYear() + "</YEAR>" +
//                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getDormant().getEnd().getMonth() + "</MONTH>" +
//                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getDormant().getEnd().getDay() + "</DAY>" +
//                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getDormant().getEnd().getHour() + "</HOUR>" +
//                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getDormant().getEnd().getMinute() + "</MINUTE>" +
//                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getDormant().getEnd().getSecond() + "</SECOND>" +
//                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getDormant().getEnd().getNano() + "</SUBSECOND>" +
//                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getDormant().getEnd().getTimeZone() + "</TIMEZONE>" +
//                "</DORMANTEND>";
//
//        String dormantReUse = position.getDormant() == null || position.getDormant().getReUse() == null ? "" : "<DORMANTREUSE xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getDormant().getReUse() + "</DORMANTREUSE>";
//
//        String dormant = position.getDormant() == null ? "" : "<DORMANT>" +
//                dormantStart +
//                dormantEnd +
//                dormantReUse +
//                "</DORMANT>";

        String preventWoCompletion = position.getPreventWoCompletion() == null ? "" : "<PREVENTWOCOMPLETION xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getPreventWoCompletion() + "</PREVENTWOCOMPLETION>";

        String propertyCode = position.getUserDefinedArea() == null || position.getUserDefinedArea().getPropertyCode() == null ? "" : "<PROPERTYCODE>" + position.getUserDefinedArea().getPropertyCode() + "</PROPERTYCODE>";
        String label = position.getUserDefinedArea() == null || position.getUserDefinedArea().getPropertyLabel() == null ? "" : "<PROPERTYLABEL>" + position.getUserDefinedArea().getPropertyLabel() + "</PROPERTYLABEL>";

        String idOrg = position.getUserDefinedArea() == null || position.getUserDefinedArea().getClassId() == null || position.getUserDefinedArea().getClassId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"Equipment\">" +
                "<ORGANIZATIONCODE>" + position.getUserDefinedArea().getClassId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + position.getUserDefinedArea().getClassId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String userDefinedId = position.getUserDefinedArea() == null || position.getUserDefinedArea().getClassId() == null ? "" : "<CLASSID entity=\"ent2\">" +
                "<CLASSCODE>" + position.getUserDefinedArea().getClassId().getCode() + "</CLASSCODE>" +
                idOrg +
                "<DESCRIPTION>" + position.getUserDefinedArea().getClassId().getDescription() + "</DESCRIPTION>" +
                "</CLASSID>";

        String dateField = position.getUserDefinedArea() == null || position.getUserDefinedArea().getDateField() == null ? "" : "<DATEFIELD qualifier=\"ACCOUNTING\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedArea().getDateField().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedArea().getDateField().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedArea().getDateField().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedArea().getDateField().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedArea().getDateField().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedArea().getDateField().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedArea().getDateField().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedArea().getDateField().getTimeZone() + "</TIMEZONE>" +
                "</DATEFIELD>";

        String maxValue = position.getUserDefinedArea() == null || position.getUserDefinedArea().getMaxValue() == null ? "" : "<MAXVALUE>" + position.getUserDefinedArea().getMaxValue() + "</MAXVALUE>";
        String minValue = position.getUserDefinedArea() == null || position.getUserDefinedArea().getMinValue() == null ? "" : "<MINVALUE>" + position.getUserDefinedArea().getMinValue() + "</MINVALUE>";
        String unitOfMetric = position.getUserDefinedArea() == null || position.getUserDefinedArea().getUnitOfMetric() == null ? "" : "<UOM>" + position.getUserDefinedArea().getUnitOfMetric() + "</UOM>";

        String lovSettings = position.getUserDefinedArea() == null || (position.getUserDefinedArea().getLovType() == null && position.getUserDefinedArea().getLovValidate() == null) ? "" : "<LOVSETTINGS>" +
                "<LOV_TYPE>" + position.getUserDefinedArea().getLovType() + "</LOV_TYPE>" +
                "<LOV_VALIDATE>" + position.getUserDefinedArea().getLovValidate() + "</LOV_VALIDATE>" +
                "</LOVSETTINGS>";

        String valueSource = position.getUserDefinedArea() == null || (position.getUserDefinedArea().getCatValue() == null && position.getUserDefinedArea().getNonUpdatable() == null) ? "" : "<VALUESOURCE>" +
                "<CATVALUE>" + position.getUserDefinedArea().getCatValue() + "</CATVALUE>" +
                "<NONUPDATEABLE>" + position.getUserDefinedArea().getNonUpdatable() + "</NONUPDATEABLE>" +
                "</VALUESOURCE>";

        String groupLabel = position.getUserDefinedArea() == null || position.getUserDefinedArea().getGroupLabel() == null ? "" : "<GROUPLABEL>" + position.getUserDefinedArea().getGroupLabel() + "</GROUPLABEL>";

        String userDefinedArea = position.getUserDefinedArea() == null ? "" : "<USERDEFINEDAREA xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<CUSTOMFIELD index=\"1\" entity=\"entity1\" type=\"type1\" changed=\"chan1\">" +
                propertyCode +
                label +
                userDefinedId +
                dateField +
                maxValue +
                minValue +
                unitOfMetric +
                lovSettings +
                valueSource +
                groupLabel +
                "</CUSTOMFIELD>" +
                "</USERDEFINEDAREA>";

        String gisObjId = position.getGisObjId() == null ? "" : "<GISOBJID xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getGisObjId() + "</GISOBJID>";

        String gisProfile = position.getGisProfile() == null ? "" : "<GISPROFILE xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getGisProfile() + "</GISPROFILE>";

        String cgMp = position.getCgMp() == null ? "" : "<CGMP xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getCgMp() + "</CGMP>";

        String linkGisWo = position.getLinkGisWo() == null ? "" : "<LINKGISWO xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getLinkGisWo() + "</LINKGISWO>";

        String vmrsCode = position.getSystemLevelId() == null ? "" : "<VMRSCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<SYSTEMLEVELID>" +
                "<SYSTEMLEVELCODE>" + position.getSystemLevelId().getCode() + "</SYSTEMLEVELCODE>" +
                "<DESCRIPTION>" + position.getSystemLevelId().getDescription() + "</DESCRIPTION>" +
                "</SYSTEMLEVELID>" +
                "</VMRSCODE>";

        String partLocation = position.getPartLocationCode() == null ? "" : "<PARTLOCATIONCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getPartLocationCode() + "</PARTLOCATIONCODE>";

        String gisMapOrg = position.getGisMapId() == null || position.getGisMapId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"AssetEquipment\">" +
                "<ORGANIZATIONCODE>" + position.getGisMapId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + position.getGisMapId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String gisMapId = position.getGisMapId() == null ? "" : "<GISMAPID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<GISMAPCODE>" + position.getGisMapId().getCode() + "</GISMAPCODE>" +
                "<DESCRIPTION>" + position.getGisMapId().getDescription() + "</DESCRIPTION>" +
                gisMapOrg +
                "</GISMAPID>";

        String gisLayer = position.getGisLayer() == null ? "" : "<GISLAYER xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getGisLayer() + "</GISLAYER>";

        String xLocation = position.getXLocation() == null ? "" : "<XLOCATION qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getXLocation().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getXLocation().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getXLocation().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getXLocation().getUom() + "</UOM>" +
                "</XLOCATION>";

        String yLocation = position.getYLocation() == null ? "" : "<YLOCATION qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getYLocation().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getYLocation().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getYLocation().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getYLocation().getUom() + "</UOM>" +
                "</YLOCATION>";

//        String equiplength = position.getLinearReferenceDetails() == null || position.getLinearReferenceDetails().getEquipmentLength() == null ? "" : "<EQUIPMENTLENGTH qualifier=\"ACCEPTED\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLinearReferenceDetails().getEquipmentLength().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLinearReferenceDetails().getEquipmentLength().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLinearReferenceDetails().getEquipmentLength().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLinearReferenceDetails().getEquipmentLength().getUom() + "</UOM>" +
//                "</EQUIPMENTLENGTH>";

//        String equipUom = position.getLinearReferenceDetails() == null || position.getLinearReferenceDetails().getEquipmentLengthUom() == null ? "" : "<EQUIPMENTLENGTHUOM>" + position.getLinearReferenceDetails().getEquipmentLengthUom() + "</EQUIPMENTLENGTHUOM>";
//        String linearRef = position.getLinearReferenceDetails() == null || position.getLinearReferenceDetails().getLinearReferenceUom() == null ? "" : "<LINEARREFUOM>" + position.getLinearReferenceDetails().getLinearReferenceUom() + "</LINEARREFUOM>";
//        String linearRefPre = position.getLinearReferenceDetails() == null || position.getLinearReferenceDetails().getLinearReferencePrecision() == null ? "" : "<LINEARREFPRECISION>" + position.getLinearReferenceDetails().getLinearReferencePrecision() + "</LINEARREFPRECISION>";
//        String geoRef = position.getLinearReferenceDetails() == null || position.getLinearReferenceDetails().getGeographicalReference() == null ? "" : "<GEOGRAPHICALREFERENCE>" + position.getLinearReferenceDetails().getGeographicalReference() + "</GEOGRAPHICALREFERENCE>";
//        String inspecDirect = position.getLinearReferenceDetails() == null || position.getLinearReferenceDetails().getInspectionDirectionCode() == null ? "" : "<INSPECTIONDIRECTIONCODE>" + position.getLinearReferenceDetails().getInspectionDirectionCode() + "</INSPECTIONDIRECTIONCODE>";
//        String flow = position.getLinearReferenceDetails() == null || position.getLinearReferenceDetails().getFlowCode() == null ? "" : "<FLOWCODE>" + position.getLinearReferenceDetails().getFlowCode() + "</FLOWCODE>";
//        String linearCostWeight = position.getLinearReferenceDetails() == null || position.getLinearReferenceDetails().getLinearCostWeight() == null ? "" : "<LINEARCOSTWEIGHT>" + position.getLinearReferenceDetails().getLinearCostWeight() + "</LINEARCOSTWEIGHT>";
//
//        String lrffFromPoint = position.getLinearReferenceDetails() == null || position.getLinearReferenceDetails().getLrfFromPoint() == null ? "" : "<LRFFROMPOINT qualifier=\"ACCEPTED\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLinearReferenceDetails().getLrfFromPoint().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLinearReferenceDetails().getLrfFromPoint().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLinearReferenceDetails().getLrfFromPoint().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLinearReferenceDetails().getLrfFromPoint().getUom() + "</UOM>" +
//                "</LRFFROMPOINT>";
//
//        String lrffToPoint = position.getLinearReferenceDetails() == null || position.getLinearReferenceDetails().getLrfToPoint() == null ? "" : "<LRFTOPOINT qualifier=\"ACCEPTED\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLinearReferenceDetails().getLrfToPoint().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLinearReferenceDetails().getLrfToPoint().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLinearReferenceDetails().getLrfToPoint().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLinearReferenceDetails().getLrfToPoint().getUom() + "</UOM>" +
//                "</LRFTOPOINT>";
//
//        String linearDirection = position.getLinearReferenceDetails() == null || position.getLinearReferenceDetails().getLinearDirection() == null ? "" : "<LINEARDIRECTIONID>" +
//                "<UCODEENTITY>" + position.getLinearReferenceDetails().getLinearDirection().getUCodeEntity() + "</UCODEENTITY>" +
//                "<UCODE>" + position.getLinearReferenceDetails().getLinearDirection().getUCode() + "</UCODE>" +
//                "<DESCRIPTION>" + position.getLinearReferenceDetails().getLinearDirection().getDescription() + "</DESCRIPTION>" +
//                "</LINEARDIRECTIONID>";
//
//        String linearEquipType = position.getLinearReferenceDetails() == null || position.getLinearReferenceDetails().getLinearEquipmentType() == null ? "" : "<LINEAREQUIPMENTTYPE entity=\"User\">" +
//                "<TYPECODE>" + position.getLinearReferenceDetails().getLinearEquipmentType().getCode() + "</TYPECODE>" +
//                "<DESCRIPTION>" + position.getLinearReferenceDetails().getLinearEquipmentType().getDescription() + "</DESCRIPTION>" +
//                "</LINEAREQUIPMENTTYPE>";
//
//        String linearReferenceDetails = position.getLinearReferenceDetails() == null ? "" : "<LINEARREFERENCEDETAILS xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                equiplength +
//                equipUom +
//                linearRef +
//                linearRefPre +
//                geoRef +
//                inspecDirect +
//                flow +
//                linearCostWeight +
//                lrffFromPoint +
//                lrffToPoint +
//                linearDirection +
//                linearEquipType +
//                "</LINEARREFERENCEDETAILS>";
//
//        String manufacturerCode = position.getManufacturerInfo() == null || position.getManufacturerInfo().getManufacturerCode() == null ? "" : "<MANUFACTURERCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getManufacturerInfo().getManufacturerCode() + "</MANUFACTURERCODE>";
//        String serialNumber = position.getManufacturerInfo() == null || position.getManufacturerInfo().getSerialNumber() == null ? "" : "<SERIALNUMBER xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getManufacturerInfo().getSerialNumber() + "</SERIALNUMBER>";
//        String model = position.getManufacturerInfo() == null || position.getManufacturerInfo().getModel() == null ? "" : "<MODEL xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getManufacturerInfo().getModel() + "</MODEL>";
//        String modelRevision = position.getManufacturerInfo() == null || position.getManufacturerInfo().getModelRevision() == null ? "" : "<MODELREVISION xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getManufacturerInfo().getModelRevision() + "</MODELREVISION>";
//        String hardwareVersion = position.getManufacturerInfo() == null || position.getManufacturerInfo().getHardwareVersion() == null ? "" : "<HARDWAREVER xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getManufacturerInfo().getHardwareVersion() + "</HARDWAREVER>";
//        String softwareVersion = position.getManufacturerInfo() == null || position.getManufacturerInfo().getSoftwareVersion() == null ? "" : "<SOFTWAREVER xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getManufacturerInfo().getSoftwareVersion() + "</SOFTWAREVER>";
//        String purchasingAsset = position.getManufacturerInfo() == null || position.getManufacturerInfo().getPurchasingAsset() == null ? "" : "<PURCHASINGASSET xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getManufacturerInfo().getPurchasingAsset() + "</PURCHASINGASSET>";
//        String bioMedicalAsset = position.getManufacturerInfo() == null || position.getManufacturerInfo().getBioMedicalAsset() == null ? "" : "<BIOMEDICALASSET xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getManufacturerInfo().getBioMedicalAsset() + "</BIOMEDICALASSET>";
//
//        String umdNs = position.getManufacturerInfo() == null || position.getManufacturerInfo().getUmdNs() == null ? "" : "<UMDNS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<TYPECODE>" + position.getManufacturerInfo().getUmdNs().getCode() + "</TYPECODE>" +
//                "<DESCRIPTION>" + position.getManufacturerInfo().getUmdNs().getDescription() + "</DESCRIPTION>" +
//                "</UMDNS>";
//
//        String oemSite = position.getManufacturerInfo() == null || position.getManufacturerInfo().getOemSite() == null ? "" : "<OEMSITE xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getManufacturerInfo().getOemSite() + "</OEMSITE>";
//        String vendor = position.getManufacturerInfo() == null || position.getManufacturerInfo().getVendor() == null ? "" : "<VENDOR xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getManufacturerInfo().getVendor() + "</VENDOR>";
//
//        String coverageType = position.getManufacturerInfo() == null || position.getManufacturerInfo().getCoverageType() == null ? "" : "<COVERAGETYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<TYPECODE>" + position.getManufacturerInfo().getCoverageType().getCode() + "</TYPECODE>" +
//                "<DESCRIPTION>" + position.getManufacturerInfo().getCoverageType().getDescription() + "</DESCRIPTION>" +
//                "</COVERAGETYPE>";
//
//        String xCoordinate = position.getManufacturerInfo() == null || position.getManufacturerInfo().getXCoordinate() == null ? "" : "<XCOORDINATE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getManufacturerInfo().getXCoordinate().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getManufacturerInfo().getXCoordinate().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getManufacturerInfo().getXCoordinate().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getManufacturerInfo().getXCoordinate().getUom() + "</UOM>" +
//                "</XCOORDINATE>";
//
//        String yCoordinate = position.getManufacturerInfo() == null || position.getManufacturerInfo().getYCoordinate() == null ? "" : "<YCOORDINATE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getManufacturerInfo().getYCoordinate().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getManufacturerInfo().getYCoordinate().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getManufacturerInfo().getYCoordinate().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getManufacturerInfo().getYCoordinate().getUom() + "</UOM>" +
//                "</YCOORDINATE>";
//
//        String zCoordinate = position.getManufacturerInfo() == null || position.getManufacturerInfo().getZCoordinate() == null ? "" : "<ZCOORDINATE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getManufacturerInfo().getZCoordinate().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getManufacturerInfo().getZCoordinate().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getManufacturerInfo().getZCoordinate().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getManufacturerInfo().getZCoordinate().getUom() + "</UOM>" +
//                "</ZCOORDINATE>";
//
//        String manufacturerInfo = "<ManufacturerInfo>" +
//                manufacturerCode +
//                serialNumber +
//                model +
//                modelRevision +
//                hardwareVersion +
//                softwareVersion +
//                purchasingAsset +
//                bioMedicalAsset +
//                umdNs +
//                oemSite +
//                vendor +
//                coverageType +
//                xCoordinate +
//                yCoordinate +
//                zCoordinate +
//                "</ManufacturerInfo>";
//
//        String variable1 = position.getVariables() == null || position.getVariables().getVariable1() == null ? "" : "<VARIABLE1>" + position.getVariables().getVariable1() + "</VARIABLE1>";
//        String variable2 = position.getVariables() == null || position.getVariables().getVariable2() == null ? "" : "<VARIABLE2>" + position.getVariables().getVariable2() + "</VARIABLE2>";
//        String variable3 = position.getVariables() == null || position.getVariables().getVariable3() == null ? "" : "<VARIABLE3>" + position.getVariables().getVariable3() + "</VARIABLE3>";
//        String variable4 = position.getVariables() == null || position.getVariables().getVariable4() == null ? "" : "<VARIABLE4>" + position.getVariables().getVariable4() + "</VARIABLE4>";
//        String variable5 = position.getVariables() == null || position.getVariables().getVariable5() == null ? "" : "<VARIABLE5>" + position.getVariables().getVariable5() + "</VARIABLE5>";
//        String variable6 = position.getVariables() == null || position.getVariables().getVariable6() == null ? "" : "<VARIABLE6>" + position.getVariables().getVariable6() + "</VARIABLE6>";
//
//        String variables = position.getVariables() == null ? "" : "<Variables>" +
//                variable1 +
//                variable2 +
//                variable3 +
//                variable4 +
//                variable5 +
//                variable6 +
//                "</Variables>";
//
//        String penaltyFactor = position.getCallCenter() == null || position.getCallCenter().getPenaltyFactor() == null ? "" : "<PENALTYFACTOR qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCallCenter().getPenaltyFactor().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCallCenter().getPenaltyFactor().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCallCenter().getPenaltyFactor().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCallCenter().getPenaltyFactor().getUom() + "</UOM>" +
//                "</PENALTYFACTOR>";
//
//        String penaltyAmount = position.getCallCenter() == null || position.getCallCenter().getPenaltyAmount() == null ? "" : "<PENALTYAMOUNT qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCallCenter().getPenaltyAmount().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCallCenter().getPenaltyAmount().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCallCenter().getPenaltyAmount().getSign() + "</SIGN>" +
//                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCallCenter().getPenaltyAmount().getCurrency() + "</CURRENCY>" +
//                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCallCenter().getPenaltyAmount().getDRCR() + "</DRCR>" +
//                "</PENALTYAMOUNT>";
//
//        String orgCurrency = position.getCallCenter() == null || position.getCallCenter().getOrgCurrency() == null ? "" : "<ORGCURRENCY xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<CURRENCYCODE>" + position.getCallCenter().getOrgCurrency().getCode() + "</CURRENCYCODE>" +
//                "<DESCRIPTION>" + position.getCallCenter().getOrgCurrency().getDescription() + "</DESCRIPTION>" +
//                "</ORGCURRENCY>";
//
//        String calendarGroupIdOrg = position.getCallCenter() == null || position.getCallCenter().getCalendarGroup() == null || position.getCallCenter().getCalendarGroup().getOrganization() == null ? "" :  "<ORGANIZATIONID entity=\"PositionEquipment\">" +
//                "<ORGANIZATIONCODE>" + position.getCallCenter().getCalendarGroup().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
//                "<DESCRIPTION>" + position.getCallCenter().getCalendarGroup().getOrganization().getDescription() + "</DESCRIPTION>" +
//                "</ORGANIZATIONID>";
//
//        String calendarGroupId = position.getCallCenter() == null || position.getCallCenter().getCalendarGroup() == null ? "" : "<CALENDARGROUPID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<CALENDARGROUPCODE>" + position.getCallCenter().getCalendarGroup().getCode() + "</CALENDARGROUPCODE>" +
//                calendarGroupIdOrg +
//                "<DESCRIPTION>" + position.getCallCenter().getCalendarGroup().getDescription() + "</DESCRIPTION>" +
//                "</CALENDARGROUPID>";
//
//        String sdmFlag = position.getCallCenter() == null || position.getCallCenter().getSdmFlag() == null ? "" : "<SDMFLAG xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getCallCenter().getSdmFlag() + "</SDMFLAG>";
//
//        String enableSdmCheck = position.getCallCenter() == null || position.getCallCenter().getEnableSdmCheck() == null ? "" : "<ENABLESDMCHECK xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getCallCenter().getEnableSdmCheck() + "</ENABLESDMCHECK>";
//
//        String callCenter = position.getCallCenter() == null ? "" : "<CallCenterDetails>" +
//                penaltyFactor +
//                penaltyAmount +
//                orgCurrency +
//                calendarGroupId +
//                sdmFlag +
//                enableSdmCheck +
//                "</CallCenterDetails>";

        String udfChar01 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar01() == null ? "" : "<UDFCHAR01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar01() + "</UDFCHAR01>";
        String udfChar02 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar02() == null ? "" : "<UDFCHAR02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar02() + "</UDFCHAR02>";
        String udfChar03 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar03() == null ? "" : "<UDFCHAR03 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar03() + "</UDFCHAR03>";
        String udfChar04 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar04() == null ? "" : "<UDFCHAR04 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar04() + "</UDFCHAR04>";
        String udfChar05 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar05() == null ? "" : "<UDFCHAR05 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar05() + "</UDFCHAR05>";
        String udfChar06 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar06() == null ? "" : "<UDFCHAR06 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar06() + "</UDFCHAR06>";
        String udfChar07 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar07() == null ? "" : "<UDFCHAR07 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar07() + "</UDFCHAR07>";
        String udfChar08 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar08() == null ? "" : "<UDFCHAR08 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar08() + "</UDFCHAR08>";
        String udfChar09 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar09() == null ? "" : "<UDFCHAR09 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar09() + "</UDFCHAR09>";
        String udfChar10 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar10() == null ? "" : "<UDFCHAR10 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar10() + "</UDFCHAR10>";
        String udfChar11 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar11() == null ? "" : "<UDFCHAR11 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar11() + "</UDFCHAR11>";
        String udfChar12 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar12() == null ? "" : "<UDFCHAR12 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar12() + "</UDFCHAR12>";
        String udfChar13 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar13() == null ? "" : "<UDFCHAR13 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar13() + "</UDFCHAR13>";
        String udfChar14 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar14() == null ? "" : "<UDFCHAR14 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar14() + "</UDFCHAR14>";
        String udfChar15 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar15() == null ? "" : "<UDFCHAR15 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar15() + "</UDFCHAR15>";
        String udfChar16 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar16() == null ? "" : "<UDFCHAR16 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar16() + "</UDFCHAR16>";
        String udfChar17 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar17() == null ? "" : "<UDFCHAR17 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar17() + "</UDFCHAR17>";
        String udfChar18 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar18() == null ? "" : "<UDFCHAR18 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar18() + "</UDFCHAR18>";
        String udfChar19 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar19() == null ? "" : "<UDFCHAR19 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar19() + "</UDFCHAR19>";
        String udfChar20 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar20() == null ? "" : "<UDFCHAR20 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar20() + "</UDFCHAR20>";
        String udfChar21 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar21() == null ? "" : "<UDFCHAR21 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar21() + "</UDFCHAR21>";
        String udfChar22 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar22() == null ? "" : "<UDFCHAR22 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar22() + "</UDFCHAR22>";
        String udfChar23 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar23() == null ? "" : "<UDFCHAR23 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar23() + "</UDFCHAR23>";
        String udfChar24 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar24() == null ? "" : "<UDFCHAR24 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar24() + "</UDFCHAR24>";
        String udfChar25 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar25() == null ? "" : "<UDFCHAR25 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar25() + "</UDFCHAR25>";
        String udfChar26 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar26() == null ? "" : "<UDFCHAR26 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar26() + "</UDFCHAR26>";
        String udfChar27 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar27() == null ? "" : "<UDFCHAR27 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar27() + "</UDFCHAR27>";
        String udfChar28 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar28() == null ? "" : "<UDFCHAR28 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar28() + "</UDFCHAR28>";
        String udfChar29 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar29() == null ? "" : "<UDFCHAR29 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar29() + "</UDFCHAR29>";
        String udfChar30 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar30() == null ? "" : "<UDFCHAR30 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar30() + "</UDFCHAR30>";
        String udfChar31 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar31() == null ? "" : "<UDFCHAR31 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar31() + "</UDFCHAR31>";
        String udfChar32 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar32() == null ? "" : "<UDFCHAR32 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar32() + "</UDFCHAR32>";
        String udfChar33 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar33() == null ? "" : "<UDFCHAR33 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar33() + "</UDFCHAR33>";
        String udfChar34 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar34() == null ? "" : "<UDFCHAR34 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar34() + "</UDFCHAR34>";
        String udfChar35 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar35() == null ? "" : "<UDFCHAR35 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar35() + "</UDFCHAR35>";
        String udfChar36 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar36() == null ? "" : "<UDFCHAR36 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar36() + "</UDFCHAR36>";
        String udfChar37 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar37() == null ? "" : "<UDFCHAR37 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar37() + "</UDFCHAR37>";
        String udfChar38 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar38() == null ? "" : "<UDFCHAR38 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar38() + "</UDFCHAR38>";
        String udfChar39 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar39() == null ? "" : "<UDFCHAR39 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar39() + "</UDFCHAR39>";
        String udfChar40 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar40() == null ? "" : "<UDFCHAR40 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar40() + "</UDFCHAR40>";
        String udfChar41 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar41() == null ? "" : "<UDFCHAR41 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar41() + "</UDFCHAR41>";
        String udfChar42 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar42() == null ? "" : "<UDFCHAR42 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar42() + "</UDFCHAR42>";
        String udfChar43 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar43() == null ? "" : "<UDFCHAR43 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar43() + "</UDFCHAR43>";
        String udfChar44 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar44() == null ? "" : "<UDFCHAR44 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar44() + "</UDFCHAR44>";
        String udfChar45 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChar45() == null ? "" : "<UDFCHAR45 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChar45() + "</UDFCHAR45>";

        String udfNum1 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfNum1() == null ? "" : "<UDFNUM01 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum1().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum1().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum1().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum1().getUom() + "</UOM>" +
                "</UDFNUM01>";

        String udfNum2 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfNum2() == null ? "" : "<UDFNUM02 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum2().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum2().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum2().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum2().getUom() + "</UOM>" +
                "</UDFNUM02>";

        String udfNum3 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfNum3() == null ? "" : "<UDFNUM03 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum3().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum3().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum3().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum3().getUom() + "</UOM>" +
                "</UDFNUM03>";

        String udfNum4 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfNum4() == null ? "" : "<UDFNUM04 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum4().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum4().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum4().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum4().getUom() + "</UOM>" +
                "</UDFNUM04>";

        String udfNum5 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfNum5() == null ? "" : "<UDFNUM05 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum5().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum5().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum5().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum5().getUom() + "</UOM>" +
                "</UDFNUM05>";

        String udfNum6 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfNum6() == null ? "" : "<UDFNUM06 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum6().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum6().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum6().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum6().getUom() + "</UOM>" +
                "</UDFNUM06>";

        String udfNum7 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfNum7() == null ? "" : "<UDFNUM07 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum7().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum7().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum7().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum7().getUom() + "</UOM>" +
                "</UDFNUM07>";

        String udfNum8 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfNum8() == null ? "" : "<UDFNUM08 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum8().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum8().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum8().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum8().getUom() + "</UOM>" +
                "</UDFNUM08>";

        String udfNum9 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfNum9() == null ? "" : "<UDFNUM09 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum9().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum9().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum9().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum9().getUom() + "</UOM>" +
                "</UDFNUM09>";

        String udfNum10 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfNum10() == null ? "" : "<UDFNUM10 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum10().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum10().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum10().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfNum10().getUom() + "</UOM>" +
                "</UDFNUM10>";

        String udfDate1 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfDate1() == null ? "" : "<UDFDATE01 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate1().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate1().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate1().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate1().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate1().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate1().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate1().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate1().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE01>";

        String udfDate2 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfDate2() == null ? "" : "<UDFDATE02 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate2().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate2().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate2().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate2().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate2().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate2().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate2().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate2().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE02>";

        String udfDate3 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfDate3() == null ? "" : "<UDFDATE03 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate3().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate3().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate3().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate3().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate3().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate3().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate3().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate3().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE03>";

        String udfDate4 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfDate4() == null ? "" : "<UDFDATE04 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate4().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate4().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate4().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate4().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate4().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate4().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate4().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate4().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE04>";

        String udfDate5 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfDate5() == null ? "" : "<UDFDATE05 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate5().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate5().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate5().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate5().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate5().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate5().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate5().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate5().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE05>";

        String udfDate6 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfDate6() == null ? "" : "<UDFDATE06 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate6().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate6().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate6().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate6().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate6().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate6().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate6().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate6().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE06>";

        String udfDate7 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfDate7() == null ? "" : "<UDFDATE07 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate7().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate7().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate7().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate7().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate7().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate7().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate7().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate7().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE07>";

        String udfDate8 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfDate8() == null ? "" : "<UDFDATE08 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate8().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate8().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate8().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate8().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate8().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate8().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate8().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate8().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE08>";

        String udfDate9 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfDate9() == null ? "" : "<UDFDATE09 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate9().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate9().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate9().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate9().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate9().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate9().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate9().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate9().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE09>";

        String udfDate10 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfDate10() == null ? "" : "<UDFDATE10 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate10().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate10().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate10().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate10().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate10().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate10().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate10().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getUserDefinedFields().getUdfDate10().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE10>";

        String udfCheckBox1 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChkBox01() == null ? "" : "<UDFCHKBOX01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChkBox01() + "</UDFCHKBOX01>";
        String udfCheckBox2 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChkBox02() == null ? "" : "<UDFCHKBOX02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChkBox02() + "</UDFCHKBOX02>";
        String udfCheckBox3 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChkBox03() == null ? "" : "<UDFCHKBOX03 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChkBox03() + "</UDFCHKBOX03>";
        String udfCheckBox4 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChkBox04() == null ? "" : "<UDFCHKBOX04 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChkBox04() + "</UDFCHKBOX04>";
        String udfCheckBox5 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChkBox05() == null ? "" : "<UDFCHKBOX05 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChkBox05() + "</UDFCHKBOX05>";
        String udfCheckBox6 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChkBox06() == null ? "" : "<UDFCHKBOX06 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChkBox06() + "</UDFCHKBOX06>";
        String udfCheckBox7 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChkBox07() == null ? "" : "<UDFCHKBOX07 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChkBox07() + "</UDFCHKBOX07>";
        String udfCheckBox8 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChkBox08() == null ? "" : "<UDFCHKBOX08 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChkBox08() + "</UDFCHKBOX08>";
        String udfCheckBox9 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChkBox09() == null ? "" : "<UDFCHKBOX09 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChkBox09() + "</UDFCHKBOX09>";
        String udfCheckBox10 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfChkBox10() == null ? "" : "<UDFCHKBOX10 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfChkBox10() + "</UDFCHKBOX10>";
        String udfNote1 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfNote01() == null ? "" : "<UDFNOTE01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfNote01() + "</UDFNOTE01>";
        String udfNote2 = position.getUserDefinedFields() == null || position.getUserDefinedFields().getUdfNote02() == null ? "" : "<UDFNOTE02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUserDefinedFields().getUdfNote02() + "</UDFNOTE02>";

        String userDefinedFields = position.getUserDefinedFields() == null ? "" : "<UserDefinedFields>" +
                udfChar01 +
                udfChar02 +
                udfChar03 +
                udfChar04 +
                udfChar05 +
                udfChar06 +
                udfChar07 +
                udfChar08 +
                udfChar09 +
                udfChar10 +
                udfChar11 +
                udfChar12 +
                udfChar13 +
                udfChar14 +
                udfChar15 +
                udfChar16 +
                udfChar17 +
                udfChar18 +
                udfChar19 +
                udfChar20 +
                udfChar21 +
                udfChar22 +
                udfChar23 +
                udfChar24 +
                udfChar25 +
                udfChar26 +
                udfChar27 +
                udfChar28 +
                udfChar29 +
                udfChar30 +
                udfChar31 +
                udfChar32 +
                udfChar33 +
                udfChar34 +
                udfChar35 +
                udfChar36 +
                udfChar37 +
                udfChar38 +
                udfChar39 +
                udfChar40 +
                udfChar41 +
                udfChar42 +
                udfChar43 +
                udfChar44 +
                udfChar45 +
                udfNum1 +
                udfNum2 +
                udfNum3 +
                udfNum4 +
                udfNum5 +
                udfNum6 +
                udfNum7 +
                udfNum8 +
                udfNum9 +
                udfNum10 +
                udfDate1 +
                udfDate2 +
                udfDate3 +
                udfDate4 +
                udfDate5 +
                udfDate6 +
                udfDate7 +
                udfDate8 +
                udfDate9 +
                udfDate10 +
                udfCheckBox1 +
                udfCheckBox2 +
                udfCheckBox3 +
                udfCheckBox4 +
                udfCheckBox5 +
                udfCheckBox6 +
                udfCheckBox7 +
                udfCheckBox8 +
                udfCheckBox9 +
                udfCheckBox10 +
                udfNote1 +
                udfNote2 +
                "</UserDefinedFields>";

//        String countryId = position.getFacilityConditionIndex() == null || position.getFacilityConditionIndex().getCountry() == null ? "" : "<COUNTRYID qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getCountry().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getCountry().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getCountry().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getCountry().getUom() + "</UOM>" +
//                "</COUNTRYID>";
//
//        String costOfNeededRepairs = position.getFacilityConditionIndex() == null || position.getFacilityConditionIndex().getCostOfNeededRepairs() == null ? "" : "<COSTOFNEEDEDREPAIRS qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getCostOfNeededRepairs().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getCostOfNeededRepairs().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getCostOfNeededRepairs().getSign() + "</SIGN>" +
//                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getCostOfNeededRepairs().getCurrency() + "</CURRENCY>" +
//                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getCostOfNeededRepairs().getDRCR() + "</DRCR>" +
//                "</COSTOFNEEDEDREPAIRS>";
//
//        String replacementValue = position.getFacilityConditionIndex() == null || position.getFacilityConditionIndex().getReplacementValue() == null ? "" : "<REPLACEMENTVALUE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getReplacementValue().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getReplacementValue().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getReplacementValue().getSign() + "</SIGN>" +
//                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getReplacementValue().getCurrency() + "</CURRENCY>" +
//                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getReplacementValue().getDRCR() + "</DRCR>" +
//                "</REPLACEMENTVALUE>";
//
//        String faciConditionIndex = position.getFacilityConditionIndex() == null || position.getFacilityConditionIndex().getFacilityCondition() == null ? "" : "<FACILITYCONDITIONINDEX qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getFacilityCondition().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getFacilityCondition().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getFacilityCondition().getSign() + "</SIGN>" +
//                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getFacilityCondition().getCurrency() + "</CURRENCY>" +
//                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getFacilityCondition().getDRCR() + "</DRCR>" +
//                "</FACILITYCONDITIONINDEX>";
//
//        String utilityBillLevel = position.getFacilityConditionIndex() == null || position.getFacilityConditionIndex().getUtilityBillLevel() == null ? "" : "<UTILITYBILLLEVEL xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getFacilityConditionIndex().getUtilityBillLevel() + "</UTILITYBILLLEVEL>";
//        String gasTracked = position.getFacilityConditionIndex() == null || position.getFacilityConditionIndex().getGasTracked() == null ? "" : "<GASTRACKED xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getFacilityConditionIndex().getGasTracked() + "</GASTRACKED>";
//
//        String floorArea = position.getFacilityConditionIndex() == null || position.getFacilityConditionIndex().getFloorArea() == null ? "" : "<FLOORAREA qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getFloorArea().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getFloorArea().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getFloorArea().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getFloorArea().getUom() + "</UOM>" +
//                "</FLOORAREA>";
//
//        String floorAreaUom = position.getFacilityConditionIndex() == null || position.getFacilityConditionIndex().getFloorAreaUom() == null ? "" : "<FLOORAREAUOM xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<UOMCODE>" + position.getFacilityConditionIndex().getFloorAreaUom().getCode() + "</UOMCODE>" +
//                "<DESCRIPTION>" + position.getFacilityConditionIndex().getFloorAreaUom().getDescription() + "</DESCRIPTION>" +
//                "</FLOORAREAUOM>";
//
//        String estimatedRevenue = position.getFacilityConditionIndex() == null || position.getFacilityConditionIndex().getEstimatedRevenue() == null ? "" : "<ESTIMATEDREVENUE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getEstimatedRevenue().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getEstimatedRevenue().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getEstimatedRevenue().getSign() + "</SIGN>" +
//                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getEstimatedRevenue().getCurrency() + "</CURRENCY>" +
//                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getEstimatedRevenue().getDRCR() + "</DRCR>" +
//                "</ESTIMATEDREVENUE>";
//
//        String region = position.getFacilityConditionIndex() == null || position.getFacilityConditionIndex().getRegion() == null ? "" : "<REGION entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<TYPECODE>" + position.getFacilityConditionIndex().getRegion().getCode() + "</TYPECODE>" +
//                "<DESCRIPTION>" + position.getFacilityConditionIndex().getRegion().getDescription() + "</DESCRIPTION>" +
//                "</REGION>";
//
//        String regionIdOrg = position.getFacilityConditionIndex() == null || position.getFacilityConditionIndex().getRegionId() == null || position.getFacilityConditionIndex().getRegionId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"AssetEquipmentDefault\">" +
//                "<ORGANIZATIONCODE>" + position.getFacilityConditionIndex().getRegionId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
//                "<DESCRIPTION>" + position.getFacilityConditionIndex().getRegionId().getOrganization().getDescription() + "</DESCRIPTION>" +
//                "</ORGANIZATIONID>";
//
//        String regionId = position.getFacilityConditionIndex() == null || position.getFacilityConditionIndex().getRegionId() == null ? "" : "<REGIONID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<REGIONCODE>" + position.getFacilityConditionIndex().getRegionId().getCode() + "</REGIONCODE>" +
//                regionIdOrg +
//                "<DESCRIPTION>" + position.getFacilityConditionIndex().getRegionId().getDescription() + "</DESCRIPTION>" +
//                "</REGIONID>";
//
//        String primaryUse = position.getFacilityConditionIndex() == null || position.getFacilityConditionIndex().getPrimaryUse() == null ? "" : "<PRIMARYUSE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<TYPECODE>" + position.getFacilityConditionIndex().getPrimaryUse().getCode() + "</TYPECODE>" +
//                "<DESCRIPTION>" + position.getFacilityConditionIndex().getPrimaryUse().getDescription() + "</DESCRIPTION>" +
//                "</PRIMARYUSE>";
//
//        String yearBuilt = position.getFacilityConditionIndex() == null || position.getFacilityConditionIndex().getYearBuilt() == null ? "" : "<YEARBUILT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getYearBuilt().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getYearBuilt().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getYearBuilt().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getYearBuilt().getUom() + "</UOM>" +
//                "</YEARBUILT>";
//
//        String serviceLife = position.getFacilityConditionIndex() == null || position.getFacilityConditionIndex().getServiceLife() == null ? "" : "<SERVICELIFE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getServiceLife().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getServiceLife().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getServiceLife().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFacilityConditionIndex().getServiceLife().getUom() + "</UOM>" +
//                "</SERVICELIFE>";
//
//        String energyStartEligible = position.getFacilityConditionIndex() == null || position.getFacilityConditionIndex().getEnergyStarEligible() == null ? "" : "<ENERGYSTARELIGIBLE xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getFacilityConditionIndex().getEnergyStarEligible() + "</ENERGYSTARELIGIBLE>";
//
//        String isFacility = position.getFacilityConditionIndex() == null || position.getFacilityConditionIndex().getIsFacility() == null ? "" : "<ISFACILITY xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getFacilityConditionIndex().getIsFacility() + "</ISFACILITY>";
//
//        String facilityConditionIndex = position.getFacilityConditionIndex() == null ? "" : "<FacilityConditionIndex>" +
//                costOfNeededRepairs +
//                replacementValue +
//                faciConditionIndex +
//                utilityBillLevel +
//                gasTracked +
//                floorArea +
//                floorAreaUom +
//                estimatedRevenue +
//                region +
//                regionId +
//                primaryUse +
//                yearBuilt +
//                serviceLife +
//                energyStartEligible +
//                isFacility +
//                countryId +
//                "</FacilityConditionIndex>";

        String resourceEnabled = position.getResourceEnabled() == null ? "" : "<RESOURCEENABLED xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getResourceEnabled() + "</RESOURCEENABLED>";

        String rankingLocked = position.getReliabilityRankingDetails() == null || position.getReliabilityRankingDetails().getRankingLocked() == null ? "" : "<RELIABILITYRANKINGLOCKED>" + position.getReliabilityRankingDetails().getRankingLocked() + "</RELIABILITYRANKINGLOCKED>";
        String indexCode = position.getReliabilityRankingDetails() == null || position.getReliabilityRankingDetails().getRankingIndexCode() == null ? "" : "<RELIABILITYRANKINGINDEXCODE>" + position.getReliabilityRankingDetails().getRankingIndexCode() + "</RELIABILITYRANKINGINDEXCODE>";

        String reliabilityRankingIdOrg = position.getReliabilityRankingDetails() == null || position.getReliabilityRankingDetails().getRankingId() == null || position.getReliabilityRankingDetails().getRankingId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"BookedHours\">" +
                "<ORGANIZATIONCODE>" + position.getReliabilityRankingDetails().getRankingId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + position.getReliabilityRankingDetails().getRankingId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String reliabilityRankingId = position.getReliabilityRankingDetails() == null || position.getReliabilityRankingDetails().getRankingId() == null ? "" : "<RELIABILITYRANKINGID>" +
                "<RELIABILITYRANKINGCODE>" + position.getReliabilityRankingDetails().getRankingId().getCode() + "</RELIABILITYRANKINGCODE>" +
                "<RELIABILITYRANKINGREVISION>" + position.getReliabilityRankingDetails().getRankingId().getRevision() + "</RELIABILITYRANKINGREVISION>" +
                reliabilityRankingIdOrg +
                "<DESCRIPTION>" + position.getReliabilityRankingDetails().getRankingId().getDescription() + "</DESCRIPTION>" +
                "</RELIABILITYRANKINGID>";

        String rankingScore = position.getReliabilityRankingDetails() == null || position.getReliabilityRankingDetails().getRankingScore() == null ? "" : "<RELIABILITYRANKINGSCORE qualifier=\"ACCEPTED\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getRankingScore().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getRankingScore().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getRankingScore().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getRankingScore().getUom() + "</UOM>" +
                "</RELIABILITYRANKINGSCORE>";

        String outOfSync = position.getReliabilityRankingDetails() == null || position.getReliabilityRankingDetails().getOutOfSync() == null ? "" : "<OUTOFSYNC>" + position.getReliabilityRankingDetails().getOutOfSync() + "</OUTOFSYNC>";

        String setupLastUpdate = position.getReliabilityRankingDetails() == null || position.getReliabilityRankingDetails().getSetupLastUpdate() == null ? "" : "<SETUPLASTUPDATEDDATE qualifier=\"ACCOUNTING\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getSetupLastUpdate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getSetupLastUpdate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getSetupLastUpdate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getSetupLastUpdate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getSetupLastUpdate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getSetupLastUpdate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getSetupLastUpdate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getSetupLastUpdate().getTimeZone() + "</TIMEZONE>" +
                "</SETUPLASTUPDATEDDATE>";

        String surveyLastUpdate = position.getReliabilityRankingDetails() == null || position.getReliabilityRankingDetails().getSurveyLastUpdate() == null ? "" : "<SURVEYLASTUPDATEDDATE qualifier=\"ACCOUNTING\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getSurveyLastUpdate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getSurveyLastUpdate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getSurveyLastUpdate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getSurveyLastUpdate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getSurveyLastUpdate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getSurveyLastUpdate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getSurveyLastUpdate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getSurveyLastUpdate().getTimeZone() + "</TIMEZONE>" +
                "</SURVEYLASTUPDATEDDATE>";

        String lastCalculatedDate = position.getReliabilityRankingDetails() == null || position.getReliabilityRankingDetails().getValuesLastUpdate() == null ? "" : "<VALUESLASTCALCULATEDDATE qualifier=\"ACCOUNTING\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getValuesLastUpdate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getValuesLastUpdate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getValuesLastUpdate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getValuesLastUpdate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getValuesLastUpdate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getValuesLastUpdate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getValuesLastUpdate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getReliabilityRankingDetails().getValuesLastUpdate().getTimeZone() + "</TIMEZONE>" +
                "</VALUESLASTCALCULATEDDATE>";

        String reliabilityRankingDetails = position.getReliabilityRankingDetails() == null ? "" : "<RELIABILITYRANKINGDETAILS xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                rankingLocked +
                indexCode +
                reliabilityRankingId +
                rankingScore +
                outOfSync +
                setupLastUpdate +
                surveyLastUpdate +
                lastCalculatedDate +
                "</RELIABILITYRANKINGDETAILS>";

        String vehicleType = position.getRentalDetails() == null || position.getRentalDetails().getVehicleType() == null ? "" : "<VEHICLETYPE entity=\"User\">" +
                "<TYPECODE>" + position.getRentalDetails().getVehicleType().getCode() + "</TYPECODE>" +
                "<DESCRIPTION>" + position.getRentalDetails().getVehicleType().getDescription() + "</DESCRIPTION>" +
                "</VEHICLETYPE>";

        String isRental = position.getRentalDetails() == null || position.getRentalDetails().getIsRental() == null ? "" : "<ISRENTAL>" + position.getRentalDetails().getIsRental() + "</ISRENTAL>";

        String rentalTemplateIdOrg = position.getRentalDetails() == null || position.getRentalDetails().getRentalTemplateId() == null || position.getRentalDetails().getRentalTemplateId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"Store\">" +
                "<ORGANIZATIONCODE>" + position.getRentalDetails().getRentalTemplateId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + position.getRentalDetails().getRentalTemplateId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String rentalTemplateId = position.getRentalDetails() == null || position.getRentalDetails().getRentalTemplateId() == null ? "" : "<RENTALTEMPLATEID>" +
                "<RENTALTEMPLATECODE>" + position.getRentalDetails().getRentalTemplateId().getCode() + "</RENTALTEMPLATECODE>" +
                rentalTemplateIdOrg +
                "<DESCRIPTION>" + position.getRentalDetails().getRentalTemplateId().getDescription() + "</DESCRIPTION>" +
                "</RENTALTEMPLATEID>";

        String isContract = position.getRentalDetails() == null || position.getRentalDetails().getIsContract() == null ? "" : "<ISCONTRACT>" + position.getRentalDetails().getIsContract() + "</ISCONTRACT>";

        String contractTemplateIdOrg = position.getRentalDetails() == null || position.getRentalDetails().getContractTemplateId() == null || position.getRentalDetails().getContractTemplateId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"StoreDefault\">" +
                "<ORGANIZATIONCODE>" + position.getRentalDetails().getContractTemplateId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + position.getRentalDetails().getContractTemplateId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String contractTemplateId = position.getRentalDetails() == null || position.getRentalDetails().getContractTemplateId() == null ? "" : "<CONTRACTTEMPLATEID>" +
                "<CONTRACTTEMPLATECODE>" + position.getRentalDetails().getContractTemplateId().getCode() + "</CONTRACTTEMPLATECODE>" +
                contractTemplateIdOrg +
                "<DESCRIPTION>" + position.getRentalDetails().getContractTemplateId().getDescription() + "</DESCRIPTION>" +
                "</CONTRACTTEMPLATEID>";

        String customerId = position.getRentalDetails() == null || position.getRentalDetails().getVehicleType() == null ? "" : "<CUSTOMERID>" +
                "<CUSTOMERCODE>" + position.getRentalDetails().getCustomerId().getCode() + "</CUSTOMERCODE>" +
                "<ORGANIZATIONID entity=\"Activity\">" +
                "<ORGANIZATIONCODE>" + position.getRentalDetails().getCustomerId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + position.getRentalDetails().getCustomerId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>" +
                "<DESCRIPTION>" + position.getRentalDetails().getCustomerId().getDescription() + "</DESCRIPTION>" +
                "</CUSTOMERID>";

        String availabilityStatus = position.getRentalDetails() == null || position.getRentalDetails().getVehicleType() == null ? "" : "<AVAILABILITYSTATUS entity=\"User\">" +
                "<STATUSCODE>" + position.getRentalDetails().getAvailabilityStatus().getCode() + "</STATUSCODE>" +
                "<DESCRIPTION>" + position.getRentalDetails().getAvailabilityStatus().getDescription() + "</DESCRIPTION>" +
                "</AVAILABILITYSTATUS>";

        String issueTo = position.getRentalDetails() == null || position.getRentalDetails().getVehicleType() == null ? "" : "<ISSUETO>" +
                "<PERSONCODE>" + position.getRentalDetails().getIssueTo().getCode() + "</PERSONCODE>" +
                "<DESCRIPTION>" + position.getRentalDetails().getIssueTo().getDescription() + "</DESCRIPTION>" +
                "</ISSUETO>";

        String contractRentalDetails = position.getRentalDetails() == null ? "" : "<CONTRACTANDRENTALDETAILS xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                vehicleType +
                isRental +
                rentalTemplateId +
                isContract +
                contractTemplateId +
                customerId +
                availabilityStatus +
                issueTo +
                "</CONTRACTANDRENTALDETAILS>";

        String equipmentAlias = position.getEquipmentAlias() == null ? "" : "<EQUIPMENTALIAS xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getEquipmentAlias() + "</EQUIPMENTALIAS>";

//        String targetPowerFactor = position.getEnergyPerformance() == null || position.getEnergyPerformance().getTargetPowerFactor() == null ? "" : "<TARGETPOWERFACTOR qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getTargetPowerFactor().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getTargetPowerFactor().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getTargetPowerFactor().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getTargetPowerFactor().getUom() + "</UOM>" +
//                "</TARGETPOWERFACTOR>";
//
//        String targetPeakDemand = position.getEnergyPerformance() == null || position.getEnergyPerformance().getTargetPeakDemand() == null ? "" : "<TARGETPEAKDEMAND qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getTargetPeakDemand().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getTargetPeakDemand().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getTargetPeakDemand().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getTargetPeakDemand().getUom() + "</UOM>" +
//                "</TARGETPEAKDEMAND>";
//
//        String billingPeriodStartDate = position.getEnergyPerformance() == null || position.getEnergyPerformance().getBillingPeriodStartDate() == null ? "" : "<BILLINGPERIODSTARTDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getBillingPeriodStartDate().getYear() + "</YEAR>" +
//                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getBillingPeriodStartDate().getMonth() + "</MONTH>" +
//                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getBillingPeriodStartDate().getDay() + "</DAY>" +
//                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getBillingPeriodStartDate().getHour() + "</HOUR>" +
//                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getBillingPeriodStartDate().getMinute() + "</MINUTE>" +
//                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getBillingPeriodStartDate().getSecond() + "</SECOND>" +
//                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getBillingPeriodStartDate().getNano() + "</SUBSECOND>" +
//                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getBillingPeriodStartDate().getTimeZone() + "</TIMEZONE>" +
//                "</BILLINGPERIODSTARTDATE>";
//
//        String billEveryPeriod = position.getEnergyPerformance() == null || position.getEnergyPerformance().getBillEveryPeriod() == null ? "" : "<BILLEVERYPERIOD qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getBillEveryPeriod().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getBillEveryPeriod().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getBillEveryPeriod().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getBillEveryPeriod().getUom() + "</UOM>" +
//                "</BILLEVERYPERIOD>";
//
//        String billEveryUom = position.getEnergyPerformance() == null || position.getEnergyPerformance().getBillEveryUom() == null ? "" : "<BILLEVERYUOM xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<PERIODUOMCODE>" + position.getEnergyPerformance().getBillEveryUom().getCode() + "</PERIODUOMCODE>" +
//                "<DESCRIPTION>" + position.getEnergyPerformance().getBillEveryUom().getDescription() + "</DESCRIPTION>" +
//                "</BILLEVERYUOM>";
//
//        String phaseBalance1 = position.getEnergyPerformance() == null || position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost1() == null ? "" : "<PHASEIMBALANCEEFFICIENCYLOSS1 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost1().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost1().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost1().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost1().getUom() + "</UOM>" +
//                "</PHASEIMBALANCEEFFICIENCYLOSS1>";
//
//        String phaseBalance2 = position.getEnergyPerformance() == null || position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost2() == null ? "" : "<PHASEIMBALANCEEFFICIENCYLOSS2 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost2().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost2().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost2().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost2().getUom() + "</UOM>" +
//                "</PHASEIMBALANCEEFFICIENCYLOSS2>";
//
//        String phaseBalance3 = position.getEnergyPerformance() == null || position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost3() == null ? "" : "<PHASEIMBALANCEEFFICIENCYLOSS3 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost3().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost3().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost3().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost3().getUom() + "</UOM>" +
//                "</PHASEIMBALANCEEFFICIENCYLOSS3>";
//
//        String phaseBalance4 = position.getEnergyPerformance() == null || position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost4() == null ? "" : "<PHASEIMBALANCEEFFICIENCYLOSS4 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost4().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost4().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost4().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost4().getUom() + "</UOM>" +
//                "</PHASEIMBALANCEEFFICIENCYLOSS4>";
//
//        String phaseBalance5 = position.getEnergyPerformance() == null || position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost5() == null ? "" : "<PHASEIMBALANCEEFFICIENCYLOSS5 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost5().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost5().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost5().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getPhaseInBalanceEfficiencyLost5().getUom() + "</UOM>" +
//                "</PHASEIMBALANCEEFFICIENCYLOSS5>";
//
//        String performanceManager = position.getEnergyPerformance() == null || position.getEnergyPerformance().getPerformanceManager() == null ? "" : "<PERFORMANCEMANAGER xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<PERSONCODE>" + position.getEnergyPerformance().getPerformanceManager().getCode() + "</PERSONCODE>" +
//                "<DESCRIPTION>" + position.getEnergyPerformance().getPerformanceManager().getDescription() + "</DESCRIPTION>" +
//                "</PERFORMANCEMANAGER>";
//
//        String electricSubMeterInterval = position.getEnergyPerformance() == null || position.getEnergyPerformance().getElectricSubMeterInterval() == null ? "" : "<ELECTRICSUBMETERINTERVAL qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getElectricSubMeterInterval().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getElectricSubMeterInterval().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getElectricSubMeterInterval().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getElectricSubMeterInterval().getUom() + "</UOM>" +
//                "</ELECTRICSUBMETERINTERVAL>";
//
//        String electricUsageThreshold = position.getEnergyPerformance() == null || position.getEnergyPerformance().getElectricUsageThreshold() == null ? "" : "<ELECTRICUSAGETHRESHOLD qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getElectricUsageThreshold().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getElectricUsageThreshold().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getElectricUsageThreshold().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEnergyPerformance().getElectricUsageThreshold().getUom() + "</UOM>" +
//                "</ELECTRICUSAGETHRESHOLD>";
//
//        String energyPerformance = position.getEnergyPerformance() == null ? "" : "<EnergyPerformance xmlns=\"http://schemas.datastream.net/MP_entities/AssetEquipment_001\">" +
//                targetPowerFactor +
//                targetPeakDemand +
//                billingPeriodStartDate +
//                billEveryPeriod +
//                billEveryUom +
//                phaseBalance1 +
//                phaseBalance2 +
//                phaseBalance3 +
//                phaseBalance4 +
//                phaseBalance5 +
//                performanceManager +
//                electricSubMeterInterval +
//                electricUsageThreshold +
//                "</EnergyPerformance>";

        String lockout = position.getLockout() == null ? "" : "<LOCKOUT xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getLockout() + "</LOCKOUT>";
        String personalProtectiveEquipment = position.getPersonalProtectiveEquipment() == null ? "" : "<PERSONALPROTECTIVEEQUIP xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getPersonalProtectiveEquipment() + "</PERSONALPROTECTIVEEQUIP>";
        String confinedSpace = position.getConfinedSpace() == null ? "" : "<CONFINEDSPACE xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getConfinedSpace() + "</CONFINEDSPACE>";
        String statementOfCondition = position.getStatementOfCondition() == null ? "" : "<STATEMENTOFCOND xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getStatementOfCondition() + "</STATEMENTOFCOND>";
        String buildMaintProgram = position.getBuildMaintenanceProgram() == null ? "" : "<BUILDMAINTPROGRAM xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getBuildMaintenanceProgram() + "</BUILDMAINTPROGRAM>";
        String hipaaconfidentiality = position.getHipaaConfidentiality() == null ? "" : "<HIPAACONFIDENTIALITY xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getHipaaConfidentiality() + "</HIPAACONFIDENTIALITY>";

        String ownershipType = position.getOwnershipType() == null ? "" : "<OWNERSHIPTYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<TYPECODE>" + position.getOwnershipType().getCode() + "</TYPECODE>" +
                "<DESCRIPTION>" + position.getOwnershipType().getDescription() + "</DESCRIPTION>" +
                "</OWNERSHIPTYPE>";

        String inventoryDate = position.getInventoryVerificationDate() == null ? "" : "<INVENTORYVERIFICATIONDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getInventoryVerificationDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getInventoryVerificationDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getInventoryVerificationDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getInventoryVerificationDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getInventoryVerificationDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getInventoryVerificationDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getInventoryVerificationDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getInventoryVerificationDate().getTimeZone() + "</TIMEZONE>" +
                "</INVENTORYVERIFICATIONDATE>";

        String assetValue = position.getAssetValue() == null ? "" : "<ASSETVALUE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getAssetValue().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getAssetValue().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getAssetValue().getSign() + "</SIGN>" +
                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getAssetValue().getCurrency() + "</CURRENCY>" +
                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getAssetValue().getDRCR() + "</DRCR>" +
                "</ASSETVALUE>";

        String purchaseCode = position.getPurchaseOrderCode() == null ? "" : "<PURCHASEORDERCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getPurchaseOrderCode() + "</PURCHASEORDERCODE>";

        String purchaseDate = position.getPurchaseDate() == null ? "" : "<PURCHASEDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPurchaseDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPurchaseDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPurchaseDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPurchaseDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPurchaseDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPurchaseDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPurchaseDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPurchaseDate().getTimeZone() + "</TIMEZONE>" +
                "</PURCHASEDATE>";

        String purchaseCost = position.getPurchaseCost() == null ? "" : "<PURCHASECOST qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPurchaseCost().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPurchaseCost().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPurchaseCost().getSign() + "</SIGN>" +
                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPurchaseCost().getCurrency() + "</CURRENCY>" +
                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPurchaseCost().getDRCR() + "</DRCR>" +
                "</PURCHASECOST>";

        String purchaseCurrency = position.getPurchaseCurrency() == null ? "" : "<PURCHASECURRENCY xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<CURRENCYCODE>" + position.getPurchaseCurrency().getCode() + "</CURRENCYCODE>" +
                "<DESCRIPTION>" + position.getPurchaseCurrency().getDescription() + "</DESCRIPTION>" +
                "</PURCHASECURRENCY>";

        String disposalType = position.getDisposalType() == null ? "" : "<DISPOSALTYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<TYPECODE>" + position.getDisposalType().getCode() + "</TYPECODE>" +
                "<DESCRIPTION>" + position.getDisposalType().getDescription() + "</DESCRIPTION>" +
                "</DISPOSALTYPE>";

        String safetyDate = position.getSafetyReviewRequired() == null ? "" : "<SAFETYDATEREVIEWREQUIRED qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getSafetyReviewRequired().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getSafetyReviewRequired().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getSafetyReviewRequired().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getSafetyReviewRequired().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getSafetyReviewRequired().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getSafetyReviewRequired().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getSafetyReviewRequired().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getSafetyReviewRequired().getTimeZone() + "</TIMEZONE>" +
                "</SAFETYDATEREVIEWREQUIRED>";

        String safetyReviewed = position.getSafetyReviewedBy() == null ? "" : "<SAFETYREVIEWEDBY xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<USERCODE>" + position.getSafetyReviewedBy().getCode() + "</USERCODE>" +
                "<DESCRIPTION>" + position.getSafetyReviewedBy().getDescription() + "</DESCRIPTION>" +
                "</SAFETYREVIEWEDBY>";

        String permitDate = position.getPermitDateReviewRequired() == null ? "" : "<PERMITDATEREVIEWREQUIRED qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPermitDateReviewRequired().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPermitDateReviewRequired().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPermitDateReviewRequired().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPermitDateReviewRequired().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPermitDateReviewRequired().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPermitDateReviewRequired().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPermitDateReviewRequired().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPermitDateReviewRequired().getTimeZone() + "</TIMEZONE>" +
                "</PERMITDATEREVIEWREQUIRED>";

        String permitReview = position.getPermitReviewedBy() == null ? "" : "<PERMITREVIEWEDBY xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<USERCODE>" + position.getPermitReviewedBy().getCode() + "</USERCODE>" +
                "<DESCRIPTION>" + position.getPermitReviewedBy().getDescription() + "</DESCRIPTION>" +
                "</PERMITREVIEWEDBY>";

        String loToDate = position.getLotoDateReviewRequired() == null ? "" : "<LOTODATEREVIEWREQUIRED qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLotoDateReviewRequired().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLotoDateReviewRequired().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLotoDateReviewRequired().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLotoDateReviewRequired().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLotoDateReviewRequired().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLotoDateReviewRequired().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLotoDateReviewRequired().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLotoDateReviewRequired().getTimeZone() + "</TIMEZONE>" +
                "</LOTODATEREVIEWREQUIRED>";

        String loToReviewed = position.getLotoReviewedBy() == null ? "" : "<LOTOREVIEWEDBY xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<USERCODE>" + position.getLotoReviewedBy().getCode() + "</USERCODE>" +
                "<DESCRIPTION>" + position.getLotoReviewedBy().getDescription() + "</DESCRIPTION>" +
                "</LOTOREVIEWEDBY>";

//        String equipmentConfigurationIdOrg = position.getEquipmentConfigurationId() == null || position.getEquipmentConfigurationId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"ActivityDefault\">" +
//                "<ORGANIZATIONCODE>" + position.getEquipmentConfigurationId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
//                "<DESCRIPTION>" + position.getEquipmentConfigurationId().getOrganization().getDescription() + "</DESCRIPTION>" +
//                "</ORGANIZATIONID>";
//
//        String equipmentConfigurationIdRevision = position.getEquipmentConfigurationId() == null || position.getEquipmentConfigurationId().getRevisionNum() == null ? "" : "<REVISIONNUM qualifier=\"ACCEPTED\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEquipmentConfigurationId().getRevisionNum().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEquipmentConfigurationId().getRevisionNum().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEquipmentConfigurationId().getRevisionNum().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEquipmentConfigurationId().getRevisionNum().getUom() + "</UOM>" +
//                "</REVISIONNUM>";
//
//        String equipmentConfigurationId = position.getEquipmentConfigurationId() == null ? "" : "<EQUIPMENTCONFIGURATIONID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<EQUIPMENTCONFIGURATIONCODE>" + position.getEquipmentConfigurationId().getCode() + "</EQUIPMENTCONFIGURATIONCODE>" +
//                equipmentConfigurationIdOrg +
//                equipmentConfigurationIdRevision +
//                "<DESCRIPTION>" + position.getEquipmentConfigurationId().getDescription() + "</DESCRIPTION>" +
//                "</EQUIPMENTCONFIGURATIONID>";

        String rcmLevelId = position.getRcmLevelId() == null ? "" : "<RCMLEVELID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<ENTITY>" + position.getRcmLevelId().getEntity() + "</ENTITY>" +
                "<USERDEFINEDCODE>" + position.getRcmLevelId().getCode() + "</USERDEFINEDCODE>" +
                "<DESCRIPTION>" + position.getRcmLevelId().getDescription() + "</DESCRIPTION>" +
                "</RCMLEVELID>";

        String riskMatrixSetup = position.getRiskMatrixSetupId() == null ? "" : "<RISKMATRIXSETUPID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<RISKMATRIXSETUPCODE>" + position.getRiskMatrixSetupId().getCode() + "</RISKMATRIXSETUPCODE>" +
                "<DESCRIPTION>" + position.getRiskMatrixSetupId().getDescription() + "</DESCRIPTION>" +
                "</RISKMATRIXSETUPID>";

        String riskPriorityNumber = position.getRiskPriorityNumber() == null ? "" : "<RISKPRIORITYNUMBER qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getRiskPriorityNumber().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getRiskPriorityNumber().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getRiskPriorityNumber().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getRiskPriorityNumber().getUom() + "</UOM>" +
                "</RISKPRIORITYNUMBER>";

        String originalReceiptDate = position.getOriginalReceiptDate() == null ? "" : "<ORIGINALRECEIPTDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getOriginalReceiptDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getOriginalReceiptDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getOriginalReceiptDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getOriginalReceiptDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getOriginalReceiptDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getOriginalReceiptDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getOriginalReceiptDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getOriginalReceiptDate().getTimeZone() + "</TIMEZONE>" +
                "</ORIGINALRECEIPTDATE>";

        String latestReceiptDate = position.getLatestReceiptDate() == null ? "" : "<LATESTRECEIPTDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLatestReceiptDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLatestReceiptDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLatestReceiptDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLatestReceiptDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLatestReceiptDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLatestReceiptDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLatestReceiptDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLatestReceiptDate().getTimeZone() + "</TIMEZONE>" +
                "</LATESTRECEIPTDATE>";

        String originalInstallDate = position.getOriginalInstallDate() == null ? "" : "<ORIGINALINSTALLDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getOriginalInstallDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getOriginalInstallDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getOriginalInstallDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getOriginalInstallDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getOriginalInstallDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getOriginalInstallDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getOriginalInstallDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getOriginalInstallDate().getTimeZone() + "</TIMEZONE>" +
                "</ORIGINALINSTALLDATE>";

        String latestInstallDate = position.getLatestInstallDate() == null ? "" : "<LATESTINSTALLDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLatestInstallDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLatestInstallDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLatestInstallDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLatestInstallDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLatestInstallDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLatestInstallDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLatestInstallDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getLatestInstallDate().getTimeZone() + "</TIMEZONE>" +
                "</LATESTINSTALLDATE>";

        String docuMotoId = position.getDocuMotoBookId() == null ? "" : "<DOCUMOTOBOOKID xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getDocuMotoBookId() + "</DOCUMOTOBOOKID>";

        String reservationCalendarOwner = position.getReservationCalendarOwner() == null ? "" : "<RESERVATIONCALENDAROWNER xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<USERCODE>" + position.getReservationCalendarOwner().getCode() + "</USERCODE>" +
                "<DESCRIPTION>" + position.getReservationCalendarOwner().getDescription() + "</DESCRIPTION>" +
                "</RESERVATIONCALENDAROWNER>";

        String reservationCalendarOwnerListOrg = position.getReservationCalendarOwnerList() == null || position.getReservationCalendarOwnerList().getOrganization() == null ? "" :  "<ORGANIZATIONID entity=\"LaborRequisition\">" +
                "<ORGANIZATIONCODE>" + position.getReservationCalendarOwnerList().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + position.getReservationCalendarOwnerList().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String reservationCalendarOwnerList = position.getReservationCalendarOwnerList() == null ? "" : "<RESERVATIONCALENDAROWNERSLIST xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<APPROVALLISTCODE>" + position.getReservationCalendarOwnerList().getCode() + "</APPROVALLISTCODE>" +
                "<DESCRIPTION>" + position.getReservationCalendarOwnerList().getDescription() + "</DESCRIPTION>" +
                reservationCalendarOwnerListOrg +
                "</RESERVATIONCALENDAROWNERSLIST>";

        String workSpaceIdOrg = position.getWorkSpaceId() == null || position.getWorkSpaceId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"CustomFields\">" +
                "<ORGANIZATIONCODE>" + position.getWorkSpaceId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + position.getWorkSpaceId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String workSpaceId = position.getWorkSpaceId() == null ? "" : "<WORKSPACEID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<WORKSPACENUMBER>" + position.getWorkSpaceId().getNumber() + "</WORKSPACENUMBER>" +
                "<WORKSPACECODE>" + position.getWorkSpaceId().getCode() + "</WORKSPACECODE>" +
                workSpaceIdOrg +
                "<DESCRIPTION>" + position.getWorkSpaceId().getDescription() + "</DESCRIPTION>" +
                "</WORKSPACEID>";

        String setIdOrg = position.getSetId() == null || position.getSetId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"EquipmentSummary\">" +
                "<ORGANIZATIONCODE>" + position.getSetId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + position.getSetId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String setId = position.getSetId() == null ? "" : "<SETID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<SETCONSISTPK>" + position.getSetId().getPk() + "</SETCONSISTPK>" +
                "<SETCONSISTCODE>" + position.getSetId().getCode() + "</SETCONSISTCODE>" +
                "<DESCRIPTION>" + position.getSetId().getDescription() + "</DESCRIPTION>" +
                setIdOrg +
                "</SETID>";

        String setPosition = position.getSetPosition() == null ? "" : "<SETPOSITION xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getSetPosition() + "</SETPOSITION>";

        String consistIdOrg = position.getConsistId() == null || position.getConsistId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"StorePart\">" +
                "<ORGANIZATIONCODE>" + position.getConsistId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + position.getConsistId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String consistId = position.getConsistId() == null ? "" : "<CONSISTID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<SETCONSISTPK>" + position.getConsistId().getPk() + "</SETCONSISTPK>" +
                "<SETCONSISTCODE>" + position.getConsistId().getCode() + "</SETCONSISTCODE>" +
                "<DESCRIPTION>" + position.getConsistId().getDescription() + "</DESCRIPTION>" +
                consistIdOrg +
                "</CONSISTID>";

        String consistPosition = position.getConsistPosition() == null ? "" : "<CONSISTPOSITION xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getConsistPosition() + "</CONSISTPOSITION>";

        String url = position.getUrl() == null ? "" : "<URL xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getUrl() + "</URL>";

        String conditionIndex = position.getConditionIndex() == null ? "" : "<CONDITIONINDEX xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<ENTITY>" + position.getConditionIndex().getEntity() + "</ENTITY>" +
                "<USERDEFINEDCODE>" + position.getConditionIndex().getCode() + "</USERDEFINEDCODE>" +
                "<DESCRIPTION>" + position.getConditionIndex().getDescription() + "</DESCRIPTION>" +
                "</CONDITIONINDEX>";

        String conditionScore = position.getConditionScore() == null ? "" : "<CONDITIONSCORE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getConditionScore().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getConditionScore().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getConditionScore().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getConditionScore().getUom() + "</UOM>" +
                "</CONDITIONSCORE>";

        String processError = position.getProcessError() == null ? "" : "<PROCESSERROR xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getProcessError() + "</PROCESSERROR>";

        String linearUomId = position.getLinearUomId() == null ? "" : "<LINEARUOMID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<LINEARREFUOM>" + position.getLinearUomId().getCode() + "</LINEARREFUOM>" +
                "<DESCRIPTION>" + position.getLinearUomId().getDescription() + "</DESCRIPTION>" +
                "</LINEARUOMID>";

        String equipLength = position.getEquipmentLengthOverride() == null ? "" : "<EQUIPMENTLENGTHOVERRIDE xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getEquipmentLengthOverride() + "</EQUIPMENTLENGTHOVERRIDE>";

        String checkListFilter = position.getCheckListFilter() == null ? "" : "<CHECKLISTFILTER xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getCheckListFilter() + "</CHECKLISTFILTER>";

        String toleranceSize = position.getToleranceSize() == null ? "" : "<TOLERANCESIZE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getToleranceSize().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getToleranceSize().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getToleranceSize().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getToleranceSize().getUom() + "</UOM>" +
                "</TOLERANCESIZE>";

        String tempMonitored = position.getTempMonitored() == null ? "" : "<TEMPMONITORED xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getTempMonitored() + "</TEMPMONITORED>";

        String fuelId = position.getFuelId() == null ? "" : "<FUELID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<FUELCODE>" + position.getFuelId().getCode() + "</FUELCODE>" +
                "<DESCRIPTION>" + position.getFuelId().getDescription() + "</DESCRIPTION>" +
                "</FUELID>";

        String riskPriority = position.getRiskPriorityCode() == null ? "" : "<RISKPRIORITYCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getRiskPriorityCode() + "</RISKPRIORITYCODE>";

        String criticalityScore = position.getCriticalityScore() == null ? "" : "<CRITICALITYSCORE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCriticalityScore().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCriticalityScore().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCriticalityScore().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCriticalityScore().getUom() + "</UOM>" +
                "</CRITICALITYSCORE>";

        String correctionConditionScore = position.getCorrectionConditionScore() == null ? "" : "<CORRECTIONCONDITIONSCORE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCorrectionConditionScore().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCorrectionConditionScore().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCorrectionConditionScore().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCorrectionConditionScore().getUom() + "</UOM>" +
                "</CORRECTIONCONDITIONSCORE>";

        String correctionConditionReason = position.getCorrectionConditionReason() == null ? "" : "<CORRECTIONCONDITIONREASON xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getCorrectionConditionReason() + "</CORRECTIONCONDITIONREASON>";

        String correctionConditionDate = position.getCorrectionConditionDate() == null ? "" : "<CORRECTIONCONDITIONDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCorrectionConditionDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCorrectionConditionDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCorrectionConditionDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCorrectionConditionDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCorrectionConditionDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCorrectionConditionDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCorrectionConditionDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCorrectionConditionDate().getTimeZone() + "</TIMEZONE>" +
                "</CORRECTIONCONDITIONDATE>";

        String correctionUsage = position.getCorrectionUsage() == null ? "" : "<CORRECTIONUSAGE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCorrectionUsage().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCorrectionUsage().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCorrectionUsage().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getCorrectionUsage().getUom() + "</UOM>" +
                "</CORRECTIONUSAGE>";

        String correctionUsageUom = position.getCorrectionUsageUom() == null ? "" : "<CORRECTIONUSAGEUOM xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<UOMCODE>" + position.getCorrectionUsageUom().getCode() + "</UOMCODE>" +
                "<DESCRIPTION>" + position.getCorrectionUsageUom().getDescription() + "</DESCRIPTION>" +
                "</CORRECTIONUSAGEUOM>";

        String endUsefulLife = position.getEndUsefulLife() == null ? "" : "<ENDUSEFULLIFE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEndUsefulLife().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEndUsefulLife().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEndUsefulLife().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEndUsefulLife().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEndUsefulLife().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEndUsefulLife().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEndUsefulLife().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getEndUsefulLife().getTimeZone() + "</TIMEZONE>" +
                "</ENDUSEFULLIFE>";

        String remainingUsefulLife = position.getRemainingUsefulLife() == null ? "" : "<REMAININGUSEFULLIFE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getRemainingUsefulLife().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getRemainingUsefulLife().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getRemainingUsefulLife().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getRemainingUsefulLife().getUom() + "</UOM>" +
                "</REMAININGUSEFULLIFE>";

        String serviceLifeUsage = position.getServiceLifeUsage() == null ? "" : "<SERVICELIFEUSAGE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getServiceLifeUsage().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getServiceLifeUsage().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getServiceLifeUsage().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getServiceLifeUsage().getUom() + "</UOM>" +
                "</SERVICELIFEUSAGE>";

        String serviceLifeUsageUom = position.getServiceLifeUsageUom() == null ? "" : "<SERVICELIFEUSAGEUOM xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<UOMCODE>" + position.getServiceLifeUsageUom().getCode() + "</UOMCODE>" +
                "<DESCRIPTION>" + position.getServiceLifeUsageUom().getDescription() + "</DESCRIPTION>" +
                "</SERVICELIFEUSAGEUOM>";

        String profilePictureOrg = position.getProfileId() == null || position.getProfileId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"BinStockDefault\">" +
                "<ORGANIZATIONCODE>" + position.getProfileId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + position.getProfileId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String profilePicture = position.getProfileId() == null ? "" : "<PROFILEPICTURE xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<DOCUMENTCODE>" + position.getProfileId().getCode() + "</DOCUMENTCODE>" +
                profilePictureOrg +
                "<DESCRIPTION>" + position.getProfileId().getDescription() + "</DESCRIPTION>" +
                "</PROFILEPICTURE>";

//        String performanceFormulaIdOrg = position.getPerformanceDetails() == null || position.getPerformanceDetails().getPerformanceFormula() == null || position.getPerformanceDetails().getPerformanceFormula().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"BinStock\">" +
//                "<ORGANIZATIONCODE>" + position.getPerformanceDetails().getPerformanceFormula().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
//                "<DESCRIPTION>" + position.getPerformanceDetails().getPerformanceFormula().getOrganization().getDescription() + "</DESCRIPTION>" +
//                "</ORGANIZATIONID>";
//
//        String performanceFormulaIdRevision = position.getPerformanceDetails() == null || position.getPerformanceDetails().getPerformanceFormula() == null || position.getPerformanceDetails().getPerformanceFormula().getRevisionNum() == null ? "" : "<REVISIONNUM qualifier=\"ACTDUR\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getPerformanceFormula().getRevisionNum().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getPerformanceFormula().getRevisionNum().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getPerformanceFormula().getRevisionNum().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getPerformanceFormula().getRevisionNum().getUom() + "</UOM>" +
//                "</REVISIONNUM>";
//
//        String performanceFormulaId = position.getPerformanceDetails() == null || position.getPerformanceDetails().getPerformanceFormula() == null ? "" : "<PERFORMANCEFORMULAID auto_generated=\"false\" entity=\"ent1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<STANDARDENTITYCODE>" + position.getPerformanceDetails().getPerformanceFormula().getCode() + "</STANDARDENTITYCODE>" +
//                performanceFormulaIdRevision +
//                performanceFormulaIdOrg +
//                "<DESCRIPTION>" + position.getPerformanceDetails().getPerformanceFormula().getDescription() + "</DESCRIPTION>" +
//                "</PERFORMANCEFORMULAID>";
//
//        String performance = position.getPerformanceDetails() == null || position.getPerformanceDetails().getPerformance() == null ? "" : "<PERFORMANCE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getPerformance().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getPerformance().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getPerformance().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getPerformance().getUom() + "</UOM>" +
//                "</PERFORMANCE>";
//
//        String lastUpdatedDate = position.getPerformanceDetails() == null || position.getPerformanceDetails().getLastUpdatedDate() == null ? "" : "<LASTUPDATEDDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getLastUpdatedDate().getYear() + "</YEAR>" +
//                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getLastUpdatedDate().getMonth() + "</MONTH>" +
//                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getLastUpdatedDate().getDay() + "</DAY>" +
//                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getLastUpdatedDate().getHour() + "</HOUR>" +
//                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getLastUpdatedDate().getMinute() + "</MINUTE>" +
//                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getLastUpdatedDate().getSecond() + "</SECOND>" +
//                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getLastUpdatedDate().getNano() + "</SUBSECOND>" +
//                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getLastUpdatedDate().getTimeZone() + "</TIMEZONE>" +
//                "</LASTUPDATEDDATE>";
//
//        String conditionRatingWeight = position.getPerformanceDetails() == null || position.getPerformanceDetails().getConditionRatingWeight() == null ? "" : "<CONDITIONRATINGWEIGHT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getConditionRatingWeight().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getConditionRatingWeight().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getConditionRatingWeight().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getConditionRatingWeight().getUom() + "</UOM>" +
//                "</CONDITIONRATINGWEIGHT>";
//
//        String capacityCode = position.getPerformanceDetails() == null || position.getPerformanceDetails().getCapacityCode() == null ? "" : "<CAPACITYCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<ENTITY>" + position.getPerformanceDetails().getCapacityCode().getEntity() + "</ENTITY>" +
//                "<USERDEFINEDCODE>" + position.getPerformanceDetails().getCapacityCode().getCode() + "</USERDEFINEDCODE>" +
//                "<DESCRIPTION>" + position.getPerformanceDetails().getCapacityCode().getDescription() + "</DESCRIPTION>" +
//                "</CAPACITYCODE>";
//
//        String availableCapacity = position.getPerformanceDetails() == null || position.getPerformanceDetails().getAvailableCapacity() == null ? "" : "<AVAILABLECAPACITY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getAvailableCapacity().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getAvailableCapacity().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getAvailableCapacity().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getAvailableCapacity().getUom() + "</UOM>" +
//                "</AVAILABLECAPACITY>";
//
//        String desiredCapacity = position.getPerformanceDetails() == null || position.getPerformanceDetails().getDesiredCapacity() == null ? "" : "<DESIREDCAPACITY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getDesiredCapacity().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getDesiredCapacity().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getDesiredCapacity().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getDesiredCapacity().getUom() + "</UOM>" +
//                "</DESIREDCAPACITY>";
//
//        String capacityRatingWeight = position.getPerformanceDetails() == null || position.getPerformanceDetails().getCapacityRatingWeight() == null ? "" : "<CAPACITYRATINGWEIGHT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getCapacityRatingWeight().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getCapacityRatingWeight().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getCapacityRatingWeight().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getCapacityRatingWeight().getUom() + "</UOM>" +
//                "</CAPACITYRATINGWEIGHT>";
//
//        String noOffFailures = position.getPerformanceDetails() == null || position.getPerformanceDetails().getNoOffFailures() == null ? "" : "<NOOFFAILURES qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getNoOffFailures().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getNoOffFailures().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getNoOffFailures().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getNoOffFailures().getUom() + "</UOM>" +
//                "</NOOFFAILURES>";
//
//        String mtbfDays = position.getPerformanceDetails() == null || position.getPerformanceDetails().getMtbfDays() == null ? "" : "<MTBFDAYS qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMtbfDays().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMtbfDays().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMtbfDays().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMtbfDays().getUom() + "</UOM>" +
//                "</MTBFDAYS>";
//
//        String mtbfRatingWeight = position.getPerformanceDetails() == null || position.getPerformanceDetails().getMtbfRatingWeight() == null ? "" : "<MTBFRATINGWEIGHT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMtbfRatingWeight().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMtbfRatingWeight().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMtbfRatingWeight().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMtbfRatingWeight().getUom() + "</UOM>" +
//                "</MTBFRATINGWEIGHT>";
//
//        String mubf = position.getPerformanceDetails() == null || position.getPerformanceDetails().getMubf() == null ? "" : "<MUBF qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMubf().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMubf().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMubf().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMubf().getUom() + "</UOM>" +
//                "</MUBF>";
//
//        String mubfUom = position.getPerformanceDetails() == null || position.getPerformanceDetails().getMubfUom() == null ? "" : "<MUBFUOM xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<UOMCODE>" + position.getPerformanceDetails().getMubfUom().getCode() + "</UOMCODE>" +
//                "<DESCRIPTION>" + position.getPerformanceDetails().getMubfUom().getDescription() + "</DESCRIPTION>" +
//                "</MUBFUOM>";
//
//        String mubfRating = position.getPerformanceDetails() == null || position.getPerformanceDetails().getMubfRating() == null ? "" : "<MUBFRATING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMubfRating().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMubfRating().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMubfRating().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMubfRating().getUom() + "</UOM>" +
//                "</MUBFRATING>";
//
//        String mttrHrs = position.getPerformanceDetails() == null || position.getPerformanceDetails().getMttrHrs() == null ? "" : "<MTTRHRS qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMttrHrs().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMttrHrs().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMttrHrs().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMttrHrs().getUom() + "</UOM>" +
//                "</MTTRHRS>";
//
//        String mttrRating = position.getPerformanceDetails() == null || position.getPerformanceDetails().getMttrRating() == null ? "" : "<MTTRRATING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMttrRating().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMttrRating().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMttrRating().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getMttrRating().getUom() + "</UOM>" +
//                "</MTTRRATING>";
//
//        String variableResult1 = position.getPerformanceDetails() == null || position.getPerformanceDetails().getVariableResult1() == null ? "" : "<VARIABLE1RESULT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult1().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult1().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult1().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult1().getUom() + "</UOM>" +
//                "</VARIABLE1RESULT>";
//
//        String variableResult2 = position.getPerformanceDetails() == null || position.getPerformanceDetails().getVariableResult2() == null ? "" : "<VARIABLE2RESULT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult2().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult2().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult2().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult2().getUom() + "</UOM>" +
//                "</VARIABLE2RESULT>";
//
//        String variableResult3 = position.getPerformanceDetails() == null || position.getPerformanceDetails().getVariableResult3() == null ? "" : "<VARIABLE3RESULT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult3().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult3().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult3().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult3().getUom() + "</UOM>" +
//                "</VARIABLE3RESULT>";
//
//        String variableResult4 = position.getPerformanceDetails() == null || position.getPerformanceDetails().getVariableResult4() == null ? "" : "<VARIABLE4RESULT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult4().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult4().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult4().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult4().getUom() + "</UOM>" +
//                "</VARIABLE4RESULT>";
//
//        String variableResult5 = position.getPerformanceDetails() == null || position.getPerformanceDetails().getVariableResult5() == null ? "" : "<VARIABLE5RESULT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult5().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult5().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult5().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult5().getUom() + "</UOM>" +
//                "</VARIABLE5RESULT>";
//
//        String variableResult6 = position.getPerformanceDetails() == null || position.getPerformanceDetails().getVariableResult6() == null ? "" : "<VARIABLE6RESULT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult6().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult6().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult6().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableResult6().getUom() + "</UOM>" +
//                "</VARIABLE6RESULT>";
//
//        String variableRating1 = position.getPerformanceDetails() == null || position.getPerformanceDetails().getVariableRating1() == null ? "" : "<VARIABLE1RATING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating1().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating1().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating1().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating1().getUom() + "</UOM>" +
//                "</VARIABLE1RATING>";
//
//        String variableRating2 = position.getPerformanceDetails() == null || position.getPerformanceDetails().getVariableRating2() == null ? "" : "<VARIABLE2RATING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating2().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating2().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating2().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating2().getUom() + "</UOM>" +
//                "</VARIABLE2RATING>";
//
//        String variableRating3 = position.getPerformanceDetails() == null || position.getPerformanceDetails().getVariableRating3() == null ? "" : "<VARIABLE3RATING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating3().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating3().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating3().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating3().getUom() + "</UOM>" +
//                "</VARIABLE3RATING>";
//
//        String variableRating4 = position.getPerformanceDetails() == null || position.getPerformanceDetails().getVariableRating4() == null ? "" : "<VARIABLE4RATING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating4().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating4().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating4().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating4().getUom() + "</UOM>" +
//                "</VARIABLE4RATING>";
//
//        String variableRating5 = position.getPerformanceDetails() == null || position.getPerformanceDetails().getVariableRating5() == null ? "" : "<VARIABLE5RATING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating5().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating5().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating5().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating5().getUom() + "</UOM>" +
//                "</VARIABLE5RATING>";
//
//        String variableRating6 = position.getPerformanceDetails() == null || position.getPerformanceDetails().getVariableRating6() == null ? "" : "<VARIABLE6RATING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating6().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating6().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating6().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getPerformanceDetails().getVariableRating6().getUom() + "</UOM>" +
//                "</VARIABLE6RATING>";
//
//        String performanceDetails = position.getPerformanceDetails() == null ? "" : "<PERFORMANCEDETAILS>" +
//                performanceFormulaId +
//                performance +
//                lastUpdatedDate+
//                conditionRatingWeight +
//                capacityCode +
//                availableCapacity +
//                desiredCapacity +
//                capacityRatingWeight +
//                noOffFailures +
//                mtbfDays +
//                mtbfRatingWeight +
//                mubf +
//                mubfUom +
//                mubfRating +
//                mttrHrs +
//                mttrRating +
//                variableResult1 +
//                variableResult2 +
//                variableResult3 +
//                variableResult4 +
//                variableResult5 +
//                variableResult6 +
//                variableRating1 +
//                variableRating2 +
//                variableRating3 +
//                variableRating4 +
//                variableRating5 +
//                variableRating6 +
//                "</PERFORMANCEDETAILS>";

        String riskConsequenceCost = position.getRiskConsequenceCost() == null ? "" : "<RISKCONSEQUENCECOST qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getRiskConsequenceCost().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getRiskConsequenceCost().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getRiskConsequenceCost().getSign() + "</SIGN>" +
                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getRiskConsequenceCost().getCurrency() + "</CURRENCY>" +
                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getRiskConsequenceCost().getDRCR() + "</DRCR>" +
                "</RISKCONSEQUENCECOST>";

        String failureProb = position.getFailureProbabilityPercentage() == null ? "" : "<FAILUREPROBPERCENTAGE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFailureProbabilityPercentage().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFailureProbabilityPercentage().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFailureProbabilityPercentage().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getFailureProbabilityPercentage().getUom() + "</UOM>" +
                "</FAILUREPROBPERCENTAGE>";

        String blackSwanCost = position.getBlackSwanCost() == null ? "" : "<BLACKSWANCOST qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getBlackSwanCost().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getBlackSwanCost().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getBlackSwanCost().getSign() + "</SIGN>" +
                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getBlackSwanCost().getCurrency() + "</CURRENCY>" +
                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + position.getBlackSwanCost().getDRCR() + "</DRCR>" +
                "</BLACKSWANCOST>";

        String blackSwan = position.getBlackSwan() == null ? "" : "<BLACKSWAN xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getBlackSwan() + "</BLACKSWAN>";

        String currencyCode = position.getCurrencyCode() == null ? "" : "<CURRENCYCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + position.getCurrencyCode() + "</CURRENCYCODE>";

        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "<Body>" +
                "<MP0308_SyncPositionEquipment_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Sync\" noun=\"PositionEquipment\" version=\"001\" confirm_availability_status=\"confirm_availability_status1\" confirmaddlinearreferences=\"confirmaddlinearreferences1\" confirmnewequipmentlength=\"confirmnewequipmentlength1\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0308_001\">" +
                "<PositionEquipment recordid=\"" + position.getUpdatedCount() + "\" user_entity=\"user_entity1\" system_entity=\"system_entity1\" autonumber=\"default\" creategis=\"true\" has_department_security=\"has_1\" has_readonly_department_security_for_createwo=\"has_1\" is_associated_to_current_consist=\"false\" is_default_rankings_available=\"false\" instructure=\"false\" haswo=\"false\" confirm_delete_surveryanswers=\"confirmed\" xmlns=\"http://schemas.datastream.net/MP_entities/PositionEquipment_001\">" +
                id +
                type +
                classId +
                categoryId +
                status +
                departmentId +
                operationalStatus +
                loanedToDepartment +
                pmWoDepartmentId +
                inProduction +
                safety +
                outOfService +
                profileId +
                costCodeId +
                commissionDate +
                transferDate +
                withdrawalDate +
                assignedTo +
                meterUnit +
                criticalityId +
                soldDate +

                preventWoCompletion +
                userDefinedArea +
                gisObjId +
                gisProfile +
                cgMp +
                linkGisWo +
                vmrsCode +
                partLocation +
                gisMapId +
                gisLayer +
                xLocation +
                yLocation +

                userDefinedFields +

                resourceEnabled +
                reliabilityRankingDetails +
                contractRentalDetails +
                equipmentAlias +

                lockout +
                personalProtectiveEquipment +
                confinedSpace +
                statementOfCondition +
                buildMaintProgram +
                hipaaconfidentiality +
                ownershipType +
                inventoryDate +
                assetValue +
                purchaseCode +
                purchaseDate +
                purchaseCost +
                purchaseCurrency +
                disposalType +
                safetyDate +
                safetyReviewed +
                permitDate +
                permitReview +
                loToDate +
                loToReviewed +

                rcmLevelId +
                riskMatrixSetup +
                riskPriorityNumber +
                originalReceiptDate +
                latestReceiptDate +
                originalInstallDate +
                latestInstallDate +
                docuMotoId +
                reservationCalendarOwner +
                reservationCalendarOwnerList +
                workSpaceId +
                setId +
                setPosition +
                consistId +
                consistPosition +
                url +
                conditionIndex +
                conditionScore +
                processError +
                linearUomId +
                equipLength +
                checkListFilter +
                toleranceSize +
                tempMonitored +
                fuelId +
                riskPriority +
                criticalityScore +
                correctionConditionScore +
                correctionConditionReason +
                correctionConditionDate +
                correctionUsage +
                correctionUsageUom +
                endUsefulLife +
                remainingUsefulLife +
                serviceLifeUsage +
                serviceLifeUsageUom +
                profilePicture +

                riskConsequenceCost +
                failureProb +
                blackSwanCost +
                blackSwan +
                currencyCode +
                "</PositionEquipment>" +
                "</MP0308_SyncPositionEquipment_001>" +
                "</Body>" +
                "</Envelope>";
    }
}
