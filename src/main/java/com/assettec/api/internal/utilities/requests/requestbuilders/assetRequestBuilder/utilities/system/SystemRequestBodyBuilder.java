package com.assettec.api.internal.utilities.requests.requestbuilders.assetRequestBuilder.utilities.system;

import com.assettec.api.internal.core.entities.asset.system.AssetSystem;
import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.requests.requestbuilders.common.XMLRequestHeader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SystemRequestBodyBuilder {

    private XMLRequestHeader xmlRequestHeader;

    public String buildBody(ApiUser apiUser, AssetSystem system) {
        String systemId = "<SYSTEMID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<EQUIPMENTCODE>" + system.getSystemId().getCode() + "</EQUIPMENTCODE>" +
                "<ORGANIZATIONID entity=\"User\">" +
                "<ORGANIZATIONCODE>" + system.getSystemId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "</ORGANIZATIONID>" +
                "<DESCRIPTION>" + system.getSystemId().getDescription() + "</DESCRIPTION>" +
                "</SYSTEMID>";

        String type = system.getType() == null ? "" : "<TYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<TYPECODE>" + system.getType().getCode() + "</TYPECODE>" +
                "<DESCRIPTION>" + system.getType().getDescription() + "</DESCRIPTION>" +
                "</TYPE>";

        String classIdOrg =  system.getClassId() == null || system.getClassId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"Organization\">" +
                "<ORGANIZATIONCODE>" + system.getClassId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + system.getClassId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String classId = system.getClassId() == null ? "" : "<CLASSID entity=\"ent1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<CLASSCODE>" + system.getClassId().getCode() + "</CLASSCODE>" +
                classIdOrg +
                "<DESCRIPTION>" + system.getClassId().getDescription() + "</DESCRIPTION>" +
                "</CLASSID>";

        String categoryId = system.getCategoryId() == null ? "" : "<CATEGORYID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<CATEGORYCODE>" + system.getCategoryId().getCode() + "</CATEGORYCODE>" +
                "<DESCRIPTION>" + system.getCategoryId().getDescription() + "</DESCRIPTION>" +
                "</CATEGORYID>";

        String status = system.getStatus() == null ? "" : "<STATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<STATUSCODE>" + system.getStatus().getCode() + "</STATUSCODE>" +
                "<DESCRIPTION>" + system.getStatus().getDescription() + "</DESCRIPTION>" +
                "</STATUS>";

        String departmentOrg = system.getDepartmentId() == null || system.getDepartmentId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"Group\">" +
                "<ORGANIZATIONCODE>" + system.getDepartmentId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "</ORGANIZATIONID>";

        String departmentId = system.getDepartmentId() == null ? "" : "<DEPARTMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<DEPARTMENTCODE>" + system.getDepartmentId().getCode() + "</DEPARTMENTCODE>" +
                departmentOrg +
                "<DESCRIPTION>" + system.getDepartmentId().getDescription() + "</DESCRIPTION>" +
                "</DEPARTMENTID>";

        String operationalStatus = system.getOperationalStatus() == null ? "" : "<OPERATIONALSTATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<STATUSCODE>" + system.getOperationalStatus().getCode() + "</STATUSCODE>" +
                "</OPERATIONALSTATUS>";

        String loanedOrg = system.getLoanedToDepartmentId() == null || system.getLoanedToDepartmentId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"Class\">" +
                "<ORGANIZATIONCODE>" + system.getLoanedToDepartmentId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + system.getLoanedToDepartmentId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String loanedToDepartment = system.getLoanedToDepartmentId() == null ? "" : "<LOANEDTODEPARTMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<DEPARTMENTCODE>" + system.getLoanedToDepartmentId().getCode() + "</DEPARTMENTCODE>" +
                loanedOrg +
                "<DESCRIPTION>" + system.getLoanedToDepartmentId().getDescription() + "</DESCRIPTION>" +
                "</LOANEDTODEPARTMENTID>";

        String pmWoDepartOrg = system.getPmWoDepartment() == null || system.getPmWoDepartment().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"Department\">" +
                "<ORGANIZATIONCODE>" + system.getPmWoDepartment().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + system.getPmWoDepartment().getOrganization().getCode() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String pmWoDepartmentId = system.getPmWoDepartment() == null ? "" : "<PMWODEPARTMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<DEPARTMENTCODE>" + system.getPmWoDepartment().getCode() + "</DEPARTMENTCODE>" +
                pmWoDepartOrg +
                "<DESCRIPTION>" + system.getPmWoDepartment().getDescription() + "</DESCRIPTION>" +
                "</PMWODEPARTMENTID>";

        String inProduction = system.getInProduction() == null ? "" : "<INPRODUCTION xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getInProduction() + "</INPRODUCTION>";

        String safety = system.getSafety() == null ? "" : "<SAFETY xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getSafety() + "</SAFETY>";

        String outOfService = system.getOutOfService() == null ? "" : "<OUTOFSERVICE xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getOutOfService() + "</OUTOFSERVICE>";

        String profileIdOrg = system.getProfileId() == null || system.getProfileId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"Personnel\">" +
                "<ORGANIZATIONCODE>" + system.getProfileId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + system.getProfileId().getOrganization().getCode() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String profileId = system.getProfileId() == null ? "" : "<PROFILEID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<OBJECTCODE>" + system.getProfileId().getCode() + "</OBJECTCODE>" +
                profileIdOrg +
                "<DESCRIPTION>" + system.getProfileId().getDescription() + "</DESCRIPTION>" +
                "</PROFILEID>";

        String costCodeOrg = system.getCostCodeId() == null || system.getCostCodeId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"OrganizationValidity\">" +
                "<ORGANIZATIONCODE>" + system.getCostCodeId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + system.getCostCodeId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String costCodeId = system.getCostCodeId() == null ? "" : "<COSTCODEID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<COSTCODE>" + system.getCostCodeId().getCode() + "</COSTCODE>" +
                "<DESCRIPTION>" + system.getCostCodeId().getDescription() + "</DESCRIPTION>" +
                costCodeOrg +
                "</COSTCODEID>";

        String commissionDate = system.getCommissionDate() == null ? "" : "<COMMISSIONDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCommissionDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCommissionDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCommissionDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCommissionDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCommissionDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCommissionDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCommissionDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCommissionDate().getTimeZone() + "</TIMEZONE>" +
                "</COMMISSIONDATE>";

        String transferDate = system.getTransferDate() == null ? "" : "<TRANSFERDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getTransferDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getTransferDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getTransferDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getTransferDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getTransferDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getTransferDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getTransferDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getTransferDate().getTimeZone() + "</TIMEZONE>" +
                "</TRANSFERDATE>";

        String withdrawalDate = system.getWithdrawalDate() == null ? "" : "<WITHDRAWALDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getWithdrawalDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getWithdrawalDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getWithdrawalDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getWithdrawalDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getWithdrawalDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getWithdrawalDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getWithdrawalDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getWithdrawalDate().getTimeZone() + "</TIMEZONE>" +
                "</WITHDRAWALDATE>";

        String assignedTo = system.getAssignedTo() == null ? "" : "<ASSIGNEDTO xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<PERSONCODE>" + system.getAssignedTo().getCode() + "</PERSONCODE>" +
                "<DESCRIPTION>" + system.getAssignedTo().getDescription() + "</DESCRIPTION>" +
                "</ASSIGNEDTO>";

        String meterUnit = system.getMeterUnit() == null ? "" : "<METERUNIT xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getMeterUnit() + "</METERUNIT>";

        String criticalityId = system.getCriticalityId() == null ? "" : "<CRITICALITYID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<CRITICALITY>" + system.getCriticalityId().getCode() + "</CRITICALITY>" +
                "<DESCRIPTION>" + system.getCriticalityId().getDescription() + "</DESCRIPTION>" +
                "</CRITICALITYID>";

        String soldDate = system.getSoldDate() == null ? "" : "<SOLDDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getSoldDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getSoldDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getSoldDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getSoldDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getSoldDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getSoldDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getSoldDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getSoldDate().getTimeZone() + "</TIMEZONE>" +
                "</SOLDDATE>";

//        String dormantStart = system.getDormant() == null || system.getDormant().getStart() == null ? "" : "<DORMANTSTART qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getDormant().getStart().getYear() + "</YEAR>" +
//                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getDormant().getStart().getMonth() + "</MONTH>" +
//                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getDormant().getStart().getDay() + "</DAY>" +
//                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getDormant().getStart().getHour() + "</HOUR>" +
//                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getDormant().getStart().getMinute() + "</MINUTE>" +
//                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getDormant().getStart().getSecond() + "</SECOND>" +
//                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getDormant().getStart().getNano() + "</SUBSECOND>" +
//                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getDormant().getStart().getTimeZone() + "</TIMEZONE>" +
//                "</DORMANTSTART>";
//
//        String dormantEnd = system.getDormant() == null || system.getDormant().getEnd() == null ? "" : "<DORMANTEND qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getDormant().getEnd().getYear() + "</YEAR>" +
//                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getDormant().getEnd().getMonth() + "</MONTH>" +
//                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getDormant().getEnd().getDay() + "</DAY>" +
//                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getDormant().getEnd().getHour() + "</HOUR>" +
//                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getDormant().getEnd().getMinute() + "</MINUTE>" +
//                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getDormant().getEnd().getSecond() + "</SECOND>" +
//                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getDormant().getEnd().getNano() + "</SUBSECOND>" +
//                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getDormant().getEnd().getTimeZone() + "</TIMEZONE>" +
//                "</DORMANTEND>";
//
//        String dormantReUse = system.getDormant() == null || system.getDormant().getReUse() == null ? "" : "<DORMANTREUSE xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getDormant().getReUse() + "</DORMANTREUSE>";
//
//        String dormant = system.getDormant() == null ? "" : "<DORMANT>" +
//                dormantStart +
//                dormantEnd +
//                dormantReUse +
//                "</DORMANT>";
//
//        String variable1 =  system.getVariables() == null || system.getVariables().getVariable1() == null ? "" : "<VARIABLE1>" + system.getVariables().getVariable1() + "</VARIABLE1>";
//        String variable2 =  system.getVariables() == null || system.getVariables().getVariable2() == null ? "" : "<VARIABLE2>" + system.getVariables().getVariable2() + "</VARIABLE2>";
//        String variable3 =  system.getVariables() == null || system.getVariables().getVariable3() == null ? "" : "<VARIABLE3>" + system.getVariables().getVariable3() + "</VARIABLE3>";
//        String variable4 =  system.getVariables() == null || system.getVariables().getVariable4() == null ? "" : "<VARIABLE4>" + system.getVariables().getVariable4() + "</VARIABLE4>";
//        String variable5 =  system.getVariables() == null || system.getVariables().getVariable5() == null ? "" : "<VARIABLE5>" + system.getVariables().getVariable5() + "</VARIABLE5>";
//        String variable6 =  system.getVariables() == null || system.getVariables().getVariable6() == null ? "" : "<VARIABLE6>" + system.getVariables().getVariable6() + "</VARIABLE6>";
//
//        String variables = system.getVariables() == null ? "" : "<Variables>" +
//                variable1 +
//                variable2 +
//                variable3 +
//                variable4 +
//                variable5 +
//                variable6 +
//                "</Variables>";
//
//        String manuCode = system.getManufacturerInfo() == null || system.getManufacturerInfo().getManufacturerCode() == null ? "" : "<MANUFACTURERCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getManufacturerInfo().getManufacturerCode() + "</MANUFACTURERCODE>";
//        String serial = system.getManufacturerInfo() == null || system.getManufacturerInfo().getSerialNumber() == null ? "" : "<SERIALNUMBER xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getManufacturerInfo().getSerialNumber() + "</SERIALNUMBER>";
//        String model = system.getManufacturerInfo() == null || system.getManufacturerInfo().getModel() == null ? "" : "<MODEL xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getManufacturerInfo().getModel() + "</MODEL>";
//        String revision = system.getManufacturerInfo() == null || system.getManufacturerInfo().getModelRevision() == null ? "" : "<MODELREVISION xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getManufacturerInfo().getModelRevision() + "</MODELREVISION>";
//
//        String xCoordinate = system.getManufacturerInfo() == null || system.getManufacturerInfo().getXCoordinate() == null ? "" : "<XCOORDINATE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getManufacturerInfo().getXCoordinate().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getManufacturerInfo().getXCoordinate().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getManufacturerInfo().getXCoordinate().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getManufacturerInfo().getXCoordinate().getUom() + "</UOM>" +
//                "</XCOORDINATE>";
//
//        String yCoordinate = system.getManufacturerInfo() == null || system.getManufacturerInfo().getYCoordinate() == null ? "" : "<YCOORDINATE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getManufacturerInfo().getYCoordinate().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getManufacturerInfo().getYCoordinate().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getManufacturerInfo().getYCoordinate().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getManufacturerInfo().getYCoordinate().getUom() + "</UOM>" +
//                "</YCOORDINATE>";
//
//        String zCoordinate = system.getManufacturerInfo() == null || system.getManufacturerInfo().getZCoordinate() == null ? "" : "<ZCOORDINATE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getManufacturerInfo().getZCoordinate().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getManufacturerInfo().getZCoordinate().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getManufacturerInfo().getZCoordinate().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getManufacturerInfo().getZCoordinate().getUom() + "</UOM>" +
//                "</ZCOORDINATE>";
//
//        String manufacturerInfo = system.getManufacturerInfo() == null ? "" : "<ManufacturerInfo>" +
//                manuCode +
//                serial +
//                model +
//                revision +
//                xCoordinate +
//                yCoordinate +
//                zCoordinate +
//                "</ManufacturerInfo>";

        String preventWoCompletion = system.getPreventWoCompletion() == null ? "" : "<PREVENTWOCOMPLETION xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getPreventWoCompletion() + "</PREVENTWOCOMPLETION>";

        String propertyCode = system.getUserDefinedArea() == null || system.getUserDefinedArea().getPropertyCode() == null ? "" : "<PROPERTYCODE>" + system.getUserDefinedArea().getPropertyCode() + "</PROPERTYCODE>";
        String label = system.getUserDefinedArea() == null || system.getUserDefinedArea().getPropertyLabel() == null ? "" : "<PROPERTYLABEL>" + system.getUserDefinedArea().getPropertyLabel() + "</PROPERTYLABEL>";

        String idOrg = system.getUserDefinedArea() == null || system.getUserDefinedArea().getClassId() == null || system.getUserDefinedArea().getClassId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"Equipment\">" +
                "<ORGANIZATIONCODE>" + system.getUserDefinedArea().getClassId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + system.getUserDefinedArea().getClassId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String id = system.getUserDefinedArea() == null || system.getUserDefinedArea().getClassId() == null ? "" : "<CLASSID entity=\"ent2\">" +
                "<CLASSCODE>" + system.getUserDefinedArea().getClassId().getCode() + "</CLASSCODE>" +
                idOrg +
                "<DESCRIPTION>" + system.getUserDefinedArea().getClassId().getDescription() + "</DESCRIPTION>" +
                "</CLASSID>";

        String dateField = system.getUserDefinedArea() == null || system.getUserDefinedArea().getDateField() == null ? "" : "<DATEFIELD qualifier=\"ACCOUNTING\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedArea().getDateField().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedArea().getDateField().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedArea().getDateField().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedArea().getDateField().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedArea().getDateField().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedArea().getDateField().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedArea().getDateField().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedArea().getDateField().getTimeZone() + "</TIMEZONE>" +
                "</DATEFIELD>";

        String maxValue = system.getUserDefinedArea() == null || system.getUserDefinedArea().getMaxValue() == null ? "" : "<MAXVALUE>" + system.getUserDefinedArea().getMaxValue() + "</MAXVALUE>";
        String minValue = system.getUserDefinedArea() == null || system.getUserDefinedArea().getMinValue() == null ? "" : "<MINVALUE>" + system.getUserDefinedArea().getMinValue() + "</MINVALUE>";
        String unitOfMetric = system.getUserDefinedArea() == null || system.getUserDefinedArea().getUnitOfMetric() == null ? "" : "<UOM>" + system.getUserDefinedArea().getUnitOfMetric() + "</UOM>";

        String lovSettings = system.getUserDefinedArea() == null || (system.getUserDefinedArea().getLovType() == null && system.getUserDefinedArea().getLovValidate() == null) ? "" : "<LOVSETTINGS>" +
                "<LOV_TYPE>" + system.getUserDefinedArea().getLovType() + "</LOV_TYPE>" +
                "<LOV_VALIDATE>" + system.getUserDefinedArea().getLovValidate() + "</LOV_VALIDATE>" +
                "</LOVSETTINGS>";

        String valueSource = system.getUserDefinedArea() == null || (system.getUserDefinedArea().getCatValue() == null && system.getUserDefinedArea().getNonUpdatable() == null) ? "" : "<VALUESOURCE>" +
                "<CATVALUE>" + system.getUserDefinedArea().getCatValue() + "</CATVALUE>" +
                "<NONUPDATEABLE>" + system.getUserDefinedArea().getNonUpdatable() + "</NONUPDATEABLE>" +
                "</VALUESOURCE>";

        String groupLabel = system.getUserDefinedArea() == null || system.getUserDefinedArea().getGroupLabel() == null ? "" : "<GROUPLABEL>" + system.getUserDefinedArea().getGroupLabel() + "</GROUPLABEL>";

        String userDefinedArea = system.getUserDefinedArea() == null ? "" : "<USERDEFINEDAREA xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<CUSTOMFIELD index=\"1\" entity=\"entity1\" type=\"type1\" changed=\"chan1\">" +
                propertyCode +
                label +
                id +
                dateField +
                maxValue +
                minValue +
                unitOfMetric +
                lovSettings +
                valueSource +
                groupLabel +
                "</CUSTOMFIELD>" +
                "</USERDEFINEDAREA>";

        String gisObjId = system.getGisObjId() == null ? "" : "<GISOBJID xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getGisObjId() + "</GISOBJID>";
        String gisProfile = system.getGisProfile() == null ? "" : "<GISPROFILE xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getGisProfile() + "</GISPROFILE>";
        String cgMp = system.getCgMp() == null ? "" : "<CGMP xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getCgMp() + "</CGMP>";
        String linkGisObj = system.getLinkGisWo() == null ? "" : "<LINKGISWO xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getLinkGisWo() + "</LINKGISWO>";

        String vmrsCode = system.getSystemLevelId() == null ? "" : "<VMRSCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<SYSTEMLEVELID>" +
                "<SYSTEMLEVELCODE>" + system.getSystemLevelId().getCode() + "</SYSTEMLEVELCODE>" +
                "<DESCRIPTION>" + system.getSystemLevelId().getDescription() + "</DESCRIPTION>" +
                "</SYSTEMLEVELID>" +
                "</VMRSCODE>";

        String partLocation = system.getPartLocationCode() == null ? "" : "<PARTLOCATIONCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getPartLocationCode() + "</PARTLOCATIONCODE>";

        String gisMapOrg = system.getGisMapId() == null || system.getGisMapId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"AssetEquipment\">" +
        "<ORGANIZATIONCODE>" + system.getGisMapId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
        "<DESCRIPTION>" + system.getGisMapId().getOrganization().getDescription() + "</DESCRIPTION>" +
        "</ORGANIZATIONID>";

        String gisMapId = system.getGisMapId() == null ? "" : "<GISMAPID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<GISMAPCODE>" + system.getGisMapId().getCode() + "</GISMAPCODE>" +
                "<DESCRIPTION>" + system.getGisMapId().getDescription() + "</DESCRIPTION>" +
                gisMapOrg +
                "</GISMAPID>";

        String gisLayer = system.getGisLayer() == null ? "" : "<GISLAYER xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getGisLayer() + "</GISLAYER>";

        String xLocation = system.getXLocation() == null ? "" : "<XLOCATION qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getXLocation().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getXLocation().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getXLocation().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getXLocation().getUom() + "</UOM>" +
                "</XLOCATION>";

        String yLocation = system.getYLocation() == null ? "" : "<YLOCATION qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getYLocation().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getYLocation().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getYLocation().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getYLocation().getUom() + "</UOM>" +
                "</YLOCATION>";

//        String equiplength = system.getLinearReferenceDetails() == null || system.getLinearReferenceDetails().getEquipmentLength() == null ? "" : "<EQUIPMENTLENGTH qualifier=\"ACCEPTED\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLinearReferenceDetails().getEquipmentLength().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLinearReferenceDetails().getEquipmentLength().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLinearReferenceDetails().getEquipmentLength().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLinearReferenceDetails().getEquipmentLength().getUom() + "</UOM>" +
//                "</EQUIPMENTLENGTH>";
//
//        String equipUom = system.getLinearReferenceDetails() == null || system.getLinearReferenceDetails().getEquipmentLengthUom() == null ? "" : "<EQUIPMENTLENGTHUOM>" + system.getLinearReferenceDetails().getEquipmentLengthUom() + "</EQUIPMENTLENGTHUOM>";
//        String linearRef = system.getLinearReferenceDetails() == null || system.getLinearReferenceDetails().getLinearReferenceUom() == null ? "" : "<LINEARREFUOM>" + system.getLinearReferenceDetails().getLinearReferenceUom() + "</LINEARREFUOM>";
//        String linearRefPre = system.getLinearReferenceDetails() == null || system.getLinearReferenceDetails().getLinearReferencePrecision() == null ? "" : "<LINEARREFPRECISION>" + system.getLinearReferenceDetails().getLinearReferencePrecision() + "</LINEARREFPRECISION>";
//        String geoRef = system.getLinearReferenceDetails() == null || system.getLinearReferenceDetails().getGeographicalReference() == null ? "" : "<GEOGRAPHICALREFERENCE>" + system.getLinearReferenceDetails().getGeographicalReference() + "</GEOGRAPHICALREFERENCE>";
//        String inspecDirect = system.getLinearReferenceDetails() == null || system.getLinearReferenceDetails().getInspectionDirectionCode() == null ? "" : "<INSPECTIONDIRECTIONCODE>" + system.getLinearReferenceDetails().getInspectionDirectionCode() + "</INSPECTIONDIRECTIONCODE>";
//        String flow = system.getLinearReferenceDetails() == null || system.getLinearReferenceDetails().getFlowCode() == null ? "" : "<FLOWCODE>" + system.getLinearReferenceDetails().getFlowCode() + "</FLOWCODE>";
//        String linearCostWeight = system.getLinearReferenceDetails() == null || system.getLinearReferenceDetails().getLinearCostWeight() == null ? "" : "<LINEARCOSTWEIGHT>" + system.getLinearReferenceDetails().getLinearCostWeight() + "</LINEARCOSTWEIGHT>";
//
//        String lrffFromPoint = system.getLinearReferenceDetails() == null || system.getLinearReferenceDetails().getLrfFromPoint() == null ? "" : "<LRFFROMPOINT qualifier=\"ACCEPTED\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLinearReferenceDetails().getLrfFromPoint().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLinearReferenceDetails().getLrfFromPoint().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLinearReferenceDetails().getLrfFromPoint().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLinearReferenceDetails().getLrfFromPoint().getUom() + "</UOM>" +
//                "</LRFFROMPOINT>";
//
//        String lrffToPoint = system.getLinearReferenceDetails() == null || system.getLinearReferenceDetails().getLrfToPoint() == null ? "" : "<LRFTOPOINT qualifier=\"ACCEPTED\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLinearReferenceDetails().getLrfToPoint().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLinearReferenceDetails().getLrfToPoint().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLinearReferenceDetails().getLrfToPoint().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLinearReferenceDetails().getLrfToPoint().getUom() + "</UOM>" +
//                "</LRFTOPOINT>";
//
//        String linearDirection = system.getLinearReferenceDetails() == null || system.getLinearReferenceDetails().getLinearDirection() == null ? "" : "<LINEARDIRECTIONID>" +
//                "<UCODEENTITY>" + system.getLinearReferenceDetails().getLinearDirection().getUCodeEntity() + "</UCODEENTITY>" +
//                "<UCODE>" + system.getLinearReferenceDetails().getLinearDirection().getUCode() + "</UCODE>" +
//                "<DESCRIPTION>" + system.getLinearReferenceDetails().getLinearDirection().getDescription() + "</DESCRIPTION>" +
//                "</LINEARDIRECTIONID>";
//
//        String linearEquipType = system.getLinearReferenceDetails() == null || system.getLinearReferenceDetails().getLinearEquipmentType() == null ? "" : "<LINEAREQUIPMENTTYPE entity=\"User\">" +
//                "<TYPECODE>" + system.getLinearReferenceDetails().getLinearEquipmentType().getCode() + "</TYPECODE>" +
//                "<DESCRIPTION>" + system.getLinearReferenceDetails().getLinearEquipmentType().getDescription() + "</DESCRIPTION>" +
//                "</LINEAREQUIPMENTTYPE>";
//
//        String linearReferenceDetails = system.getLinearReferenceDetails() == null ? "" : "<LINEARREFERENCEDETAILS xmlns=\"http://schemas.datastream.net/MP_fields\">" +
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
//        String penaltyFactor = system.getCallCenter() == null || system.getCallCenter().getPenaltyFactor() == null ? "" : "<PENALTYFACTOR qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCallCenter().getPenaltyFactor().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCallCenter().getPenaltyFactor().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCallCenter().getPenaltyFactor().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCallCenter().getPenaltyFactor().getUom() + "</UOM>" +
//                "</PENALTYFACTOR>";
//
//        String penaltyAmount = system.getCallCenter() == null || system.getCallCenter().getPenaltyAmount() == null ? "" : "<PENALTYAMOUNT qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCallCenter().getPenaltyAmount().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCallCenter().getPenaltyAmount().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCallCenter().getPenaltyAmount().getSign() + "</SIGN>" +
//                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCallCenter().getPenaltyAmount().getCurrency() + "</CURRENCY>" +
//                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCallCenter().getPenaltyAmount().getDRCR() + "</DRCR>" +
//                "</PENALTYAMOUNT>";
//
//        String orgCurrency = system.getCallCenter() == null || system.getCallCenter().getOrgCurrency() == null ? "" : "<ORGCURRENCY xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<CURRENCYCODE>" + system.getCallCenter().getOrgCurrency().getCode() + "</CURRENCYCODE>" +
//                "<DESCRIPTION>" + system.getCallCenter().getOrgCurrency().getDescription() + "</DESCRIPTION>" +
//                "</ORGCURRENCY>";
//
//        String calendarGroupIdOrg = system.getCallCenter() == null || system.getCallCenter().getCalendarGroup() == null || system.getCallCenter().getCalendarGroup().getOrganization() == null ? "" :  "<ORGANIZATIONID entity=\"PositionEquipment\">" +
//                "<ORGANIZATIONCODE>" + system.getCallCenter().getCalendarGroup().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
//                "<DESCRIPTION>" + system.getCallCenter().getCalendarGroup().getOrganization().getDescription() + "</DESCRIPTION>" +
//                "</ORGANIZATIONID>";
//
//        String calendarGroupId = system.getCallCenter() == null || system.getCallCenter().getCalendarGroup() == null ? "" : "<CALENDARGROUPID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<CALENDARGROUPCODE>" + system.getCallCenter().getCalendarGroup().getCode() + "</CALENDARGROUPCODE>" +
//                calendarGroupIdOrg +
//                "<DESCRIPTION>" + system.getCallCenter().getCalendarGroup().getDescription() + "</DESCRIPTION>" +
//                "</CALENDARGROUPID>";
//
//        String sdmFlag = system.getCallCenter() == null || system.getCallCenter().getSdmFlag() == null ? "" : "<SDMFLAG xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getCallCenter().getSdmFlag() + "</SDMFLAG>";
//
//        String enableSdmCheck = system.getCallCenter() == null || system.getCallCenter().getEnableSdmCheck() == null ? "" : "<ENABLESDMCHECK xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getCallCenter().getEnableSdmCheck() + "</ENABLESDMCHECK>";
//
//        String callCenterDetails = system.getCallCenter() == null ? "" : "<CallCenterDetails>" +
//                penaltyFactor +
//                penaltyAmount +
//                orgCurrency +
//                calendarGroupId +
//                sdmFlag +
//                enableSdmCheck +
//                "</CallCenterDetails>";

        String udfChar01 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar01() == null ? "" : "<UDFCHAR01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar01() + "</UDFCHAR01>";
        String udfChar02 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar02() == null ? "" : "<UDFCHAR02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar02() + "</UDFCHAR02>";
        String udfChar03 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar03() == null ? "" : "<UDFCHAR03 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar03() + "</UDFCHAR03>";
        String udfChar04 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar04() == null ? "" : "<UDFCHAR04 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar04() + "</UDFCHAR04>";
        String udfChar05 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar05() == null ? "" : "<UDFCHAR05 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar05() + "</UDFCHAR05>";
        String udfChar06 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar06() == null ? "" : "<UDFCHAR06 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar06() + "</UDFCHAR06>";
        String udfChar07 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar07() == null ? "" : "<UDFCHAR07 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar07() + "</UDFCHAR07>";
        String udfChar08 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar08() == null ? "" : "<UDFCHAR08 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar08() + "</UDFCHAR08>";
        String udfChar09 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar09() == null ? "" : "<UDFCHAR09 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar09() + "</UDFCHAR09>";
        String udfChar10 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar10() == null ? "" : "<UDFCHAR10 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar10() + "</UDFCHAR10>";
        String udfChar11 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar11() == null ? "" : "<UDFCHAR11 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar11() + "</UDFCHAR11>";
        String udfChar12 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar12() == null ? "" : "<UDFCHAR12 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar12() + "</UDFCHAR12>";
        String udfChar13 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar13() == null ? "" : "<UDFCHAR13 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar13() + "</UDFCHAR13>";
        String udfChar14 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar14() == null ? "" : "<UDFCHAR14 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar14() + "</UDFCHAR14>";
        String udfChar15 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar15() == null ? "" : "<UDFCHAR15 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar15() + "</UDFCHAR15>";
        String udfChar16 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar16() == null ? "" : "<UDFCHAR16 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar16() + "</UDFCHAR16>";
        String udfChar17 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar17() == null ? "" : "<UDFCHAR17 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar17() + "</UDFCHAR17>";
        String udfChar18 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar18() == null ? "" : "<UDFCHAR18 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar18() + "</UDFCHAR18>";
        String udfChar19 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar19() == null ? "" : "<UDFCHAR19 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar19() + "</UDFCHAR19>";
        String udfChar20 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar20() == null ? "" : "<UDFCHAR20 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar20() + "</UDFCHAR20>";
        String udfChar21 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar21() == null ? "" : "<UDFCHAR21 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar21() + "</UDFCHAR21>";
        String udfChar22 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar22() == null ? "" : "<UDFCHAR22 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar22() + "</UDFCHAR22>";
        String udfChar23 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar23() == null ? "" : "<UDFCHAR23 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar23() + "</UDFCHAR23>";
        String udfChar24 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar24() == null ? "" : "<UDFCHAR24 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar24() + "</UDFCHAR24>";
        String udfChar25 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar25() == null ? "" : "<UDFCHAR25 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar25() + "</UDFCHAR25>";
        String udfChar26 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar26() == null ? "" : "<UDFCHAR26 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar26() + "</UDFCHAR26>";
        String udfChar27 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar27() == null ? "" : "<UDFCHAR27 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar27() + "</UDFCHAR27>";
        String udfChar28 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar28() == null ? "" : "<UDFCHAR28 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar28() + "</UDFCHAR28>";
        String udfChar29 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar29() == null ? "" : "<UDFCHAR29 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar29() + "</UDFCHAR29>";
        String udfChar30 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar30() == null ? "" : "<UDFCHAR30 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar30() + "</UDFCHAR30>";
        String udfChar31 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar31() == null ? "" : "<UDFCHAR31 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar31() + "</UDFCHAR31>";
        String udfChar32 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar32() == null ? "" : "<UDFCHAR32 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar32() + "</UDFCHAR32>";
        String udfChar33 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar33() == null ? "" : "<UDFCHAR33 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar33() + "</UDFCHAR33>";
        String udfChar34 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar34() == null ? "" : "<UDFCHAR34 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar34() + "</UDFCHAR34>";
        String udfChar35 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar35() == null ? "" : "<UDFCHAR35 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar35() + "</UDFCHAR35>";
        String udfChar36 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar36() == null ? "" : "<UDFCHAR36 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar36() + "</UDFCHAR36>";
        String udfChar37 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar37() == null ? "" : "<UDFCHAR37 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar37() + "</UDFCHAR37>";
        String udfChar38 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar38() == null ? "" : "<UDFCHAR38 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar38() + "</UDFCHAR38>";
        String udfChar39 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar39() == null ? "" : "<UDFCHAR39 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar39() + "</UDFCHAR39>";
        String udfChar40 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar40() == null ? "" : "<UDFCHAR40 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar40() + "</UDFCHAR40>";
        String udfChar41 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar41() == null ? "" : "<UDFCHAR41 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar41() + "</UDFCHAR41>";
        String udfChar42 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar42() == null ? "" : "<UDFCHAR42 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar42() + "</UDFCHAR42>";
        String udfChar43 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar43() == null ? "" : "<UDFCHAR43 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar43() + "</UDFCHAR43>";
        String udfChar44 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar44() == null ? "" : "<UDFCHAR44 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar44() + "</UDFCHAR44>";
        String udfChar45 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChar45() == null ? "" : "<UDFCHAR45 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChar45() + "</UDFCHAR45>";

        String udfNum1 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfNum1() == null ? "" : "<UDFNUM01 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum1().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum1().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum1().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum1().getUom() + "</UOM>" +
                "</UDFNUM01>";

        String udfNum2 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfNum2() == null ? "" : "<UDFNUM02 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum2().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum2().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum2().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum2().getUom() + "</UOM>" +
                "</UDFNUM02>";

        String udfNum3 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfNum3() == null ? "" : "<UDFNUM03 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum3().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum3().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum3().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum3().getUom() + "</UOM>" +
                "</UDFNUM03>";

        String udfNum4 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfNum4() == null ? "" : "<UDFNUM04 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum4().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum4().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum4().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum4().getUom() + "</UOM>" +
                "</UDFNUM04>";

        String udfNum5 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfNum5() == null ? "" : "<UDFNUM05 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum5().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum5().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum5().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum5().getUom() + "</UOM>" +
                "</UDFNUM05>";

        String udfNum6 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfNum6() == null ? "" : "<UDFNUM06 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum6().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum6().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum6().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum6().getUom() + "</UOM>" +
                "</UDFNUM06>";

        String udfNum7 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfNum7() == null ? "" : "<UDFNUM07 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum7().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum7().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum7().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum7().getUom() + "</UOM>" +
                "</UDFNUM07>";

        String udfNum8 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfNum8() == null ? "" : "<UDFNUM08 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum8().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum8().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum8().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum8().getUom() + "</UOM>" +
                "</UDFNUM08>";

        String udfNum9 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfNum9() == null ? "" : "<UDFNUM09 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum9().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum9().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum9().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum9().getUom() + "</UOM>" +
                "</UDFNUM09>";

        String udfNum10 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfNum10() == null ? "" : "<UDFNUM10 qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum10().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum10().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum10().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfNum10().getUom() + "</UOM>" +
                "</UDFNUM10>";

        String udfDate1 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfDate1() == null ? "" : "<UDFDATE01 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate1().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate1().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate1().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate1().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate1().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate1().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate1().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate1().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE01>";

        String udfDate2 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfDate2() == null ? "" : "<UDFDATE02 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate2().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate2().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate2().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate2().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate2().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate2().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate2().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate2().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE02>";

        String udfDate3 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfDate3() == null ? "" : "<UDFDATE03 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate3().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate3().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate3().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate3().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate3().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate3().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate3().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate3().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE03>";

        String udfDate4 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfDate4() == null ? "" : "<UDFDATE04 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate4().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate4().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate4().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate4().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate4().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate4().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate4().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate4().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE04>";

        String udfDate5 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfDate5() == null ? "" : "<UDFDATE05 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate5().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate5().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate5().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate5().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate5().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate5().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate5().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate5().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE05>";

        String udfDate6 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfDate6() == null ? "" : "<UDFDATE06 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate6().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate6().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate6().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate6().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate6().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate6().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate6().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate6().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE06>";

        String udfDate7 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfDate7() == null ? "" : "<UDFDATE07 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate7().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate7().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate7().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate7().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate7().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate7().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate7().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate7().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE07>";

        String udfDate8 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfDate8() == null ? "" : "<UDFDATE08 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate8().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate8().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate8().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate8().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate8().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate8().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate8().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate8().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE08>";

        String udfDate9 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfDate9() == null ? "" : "<UDFDATE09 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate9().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate9().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate9().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate9().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate9().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate9().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate9().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate9().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE09>";

        String udfDate10 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfDate10() == null ? "" : "<UDFDATE10 qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate10().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate10().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate10().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate10().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate10().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate10().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate10().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getUserDefinedFields().getUdfDate10().getTimeZone() + "</TIMEZONE>" +
                "</UDFDATE10>";

        String udfCheckBox1 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChkBox01() == null ? "" : "<UDFCHKBOX01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChkBox01() + "</UDFCHKBOX01>";
        String udfCheckBox2 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChkBox02() == null ? "" : "<UDFCHKBOX02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChkBox02() + "</UDFCHKBOX02>";
        String udfCheckBox3 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChkBox03() == null ? "" : "<UDFCHKBOX03 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChkBox03() + "</UDFCHKBOX03>";
        String udfCheckBox4 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChkBox04() == null ? "" : "<UDFCHKBOX04 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChkBox04() + "</UDFCHKBOX04>";
        String udfCheckBox5 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChkBox05() == null ? "" : "<UDFCHKBOX05 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChkBox05() + "</UDFCHKBOX05>";
        String udfCheckBox6 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChkBox06() == null ? "" : "<UDFCHKBOX06 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChkBox06() + "</UDFCHKBOX06>";
        String udfCheckBox7 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChkBox07() == null ? "" : "<UDFCHKBOX07 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChkBox07() + "</UDFCHKBOX07>";
        String udfCheckBox8 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChkBox08() == null ? "" : "<UDFCHKBOX08 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChkBox08() + "</UDFCHKBOX08>";
        String udfCheckBox9 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChkBox09() == null ? "" : "<UDFCHKBOX09 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChkBox09() + "</UDFCHKBOX09>";
        String udfCheckBox10 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfChkBox10() == null ? "" : "<UDFCHKBOX10 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfChkBox10() + "</UDFCHKBOX10>";
        String udfNote1 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfNote01() == null ? "" : "<UDFNOTE01 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfNote01() + "</UDFNOTE01>";
        String udfNote2 = system.getUserDefinedFields() == null || system.getUserDefinedFields().getUdfNote02() == null ? "" : "<UDFNOTE02 xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUserDefinedFields().getUdfNote02() + "</UDFNOTE02>";

        String userDefinedFields = system.getUserDefinedFields() == null ? "" : "<UserDefinedFields>" +
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

//        String countryId = system.getFacilityConditionIndex() == null || system.getFacilityConditionIndex().getCountry() == null ? "" : "<COUNTRYID qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getCountry().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getCountry().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getCountry().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getCountry().getUom() + "</UOM>" +
//                "</COUNTRYID>";
//
//        String costOfNeededRepairs = system.getFacilityConditionIndex() == null || system.getFacilityConditionIndex().getCostOfNeededRepairs() == null ? "" : "<COSTOFNEEDEDREPAIRS qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getCostOfNeededRepairs().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getCostOfNeededRepairs().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getCostOfNeededRepairs().getSign() + "</SIGN>" +
//                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getCostOfNeededRepairs().getCurrency() + "</CURRENCY>" +
//                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getCostOfNeededRepairs().getDRCR() + "</DRCR>" +
//                "</COSTOFNEEDEDREPAIRS>";
//
//        String replacementValue = system.getFacilityConditionIndex() == null || system.getFacilityConditionIndex().getReplacementValue() == null ? "" : "<REPLACEMENTVALUE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getReplacementValue().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getReplacementValue().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getReplacementValue().getSign() + "</SIGN>" +
//                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getReplacementValue().getCurrency() + "</CURRENCY>" +
//                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getReplacementValue().getDRCR() + "</DRCR>" +
//                "</REPLACEMENTVALUE>";
//
//        String faciConditionIndex = system.getFacilityConditionIndex() == null || system.getFacilityConditionIndex().getFacilityCondition() == null ? "" : "<FACILITYCONDITIONINDEX qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getFacilityCondition().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getFacilityCondition().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getFacilityCondition().getSign() + "</SIGN>" +
//                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getFacilityCondition().getCurrency() + "</CURRENCY>" +
//                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getFacilityCondition().getDRCR() + "</DRCR>" +
//                "</FACILITYCONDITIONINDEX>";
//
//        String utilityBillLevel = system.getFacilityConditionIndex() == null || system.getFacilityConditionIndex().getUtilityBillLevel() == null ? "" : "<UTILITYBILLLEVEL xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getFacilityConditionIndex().getUtilityBillLevel() + "</UTILITYBILLLEVEL>";
//        String gasTracked = system.getFacilityConditionIndex() == null || system.getFacilityConditionIndex().getGasTracked() == null ? "" : "<GASTRACKED xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getFacilityConditionIndex().getGasTracked() + "</GASTRACKED>";
//
//        String floorArea = system.getFacilityConditionIndex() == null || system.getFacilityConditionIndex().getFloorArea() == null ? "" : "<FLOORAREA qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getFloorArea().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getFloorArea().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getFloorArea().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getFloorArea().getUom() + "</UOM>" +
//                "</FLOORAREA>";
//
//        String floorAreaUom = system.getFacilityConditionIndex() == null || system.getFacilityConditionIndex().getFloorAreaUom() == null ? "" : "<FLOORAREAUOM xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<UOMCODE>" + system.getFacilityConditionIndex().getFloorAreaUom().getCode() + "</UOMCODE>" +
//                "<DESCRIPTION>" + system.getFacilityConditionIndex().getFloorAreaUom().getDescription() + "</DESCRIPTION>" +
//                "</FLOORAREAUOM>";
//
//        String estimatedRevenue = system.getFacilityConditionIndex() == null || system.getFacilityConditionIndex().getEstimatedRevenue() == null ? "" : "<ESTIMATEDREVENUE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getEstimatedRevenue().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getEstimatedRevenue().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getEstimatedRevenue().getSign() + "</SIGN>" +
//                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getEstimatedRevenue().getCurrency() + "</CURRENCY>" +
//                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getEstimatedRevenue().getDRCR() + "</DRCR>" +
//                "</ESTIMATEDREVENUE>";
//
//        String region = system.getFacilityConditionIndex() == null || system.getFacilityConditionIndex().getRegion() == null ? "" : "<REGION entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<TYPECODE>" + system.getFacilityConditionIndex().getRegion().getCode() + "</TYPECODE>" +
//                "<DESCRIPTION>" + system.getFacilityConditionIndex().getRegion().getDescription() + "</DESCRIPTION>" +
//                "</REGION>";
//
//        String regionIdOrg = system.getFacilityConditionIndex() == null || system.getFacilityConditionIndex().getRegionId() == null || system.getFacilityConditionIndex().getRegionId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"AssetEquipmentDefault\">" +
//                "<ORGANIZATIONCODE>" + system.getFacilityConditionIndex().getRegionId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
//                "<DESCRIPTION>" + system.getFacilityConditionIndex().getRegionId().getOrganization().getDescription() + "</DESCRIPTION>" +
//                "</ORGANIZATIONID>";
//
//        String regionId = system.getFacilityConditionIndex() == null || system.getFacilityConditionIndex().getRegionId() == null ? "" : "<REGIONID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<REGIONCODE>" + system.getFacilityConditionIndex().getRegionId().getCode() + "</REGIONCODE>" +
//                regionIdOrg +
//                "<DESCRIPTION>" + system.getFacilityConditionIndex().getRegionId().getDescription() + "</DESCRIPTION>" +
//                "</REGIONID>";
//
//        String primaryUse = system.getFacilityConditionIndex() == null || system.getFacilityConditionIndex().getPrimaryUse() == null ? "" : "<PRIMARYUSE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<TYPECODE>" + system.getFacilityConditionIndex().getPrimaryUse().getCode() + "</TYPECODE>" +
//                "<DESCRIPTION>" + system.getFacilityConditionIndex().getPrimaryUse().getDescription() + "</DESCRIPTION>" +
//                "</PRIMARYUSE>";
//
//        String yearBuilt = system.getFacilityConditionIndex() == null || system.getFacilityConditionIndex().getYearBuilt() == null ? "" : "<YEARBUILT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getYearBuilt().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getYearBuilt().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getYearBuilt().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getYearBuilt().getUom() + "</UOM>" +
//                "</YEARBUILT>";
//
//        String serviceLife = system.getFacilityConditionIndex() == null || system.getFacilityConditionIndex().getServiceLife() == null ? "" : "<SERVICELIFE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getServiceLife().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getServiceLife().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getServiceLife().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFacilityConditionIndex().getServiceLife().getUom() + "</UOM>" +
//                "</SERVICELIFE>";
//
//        String energyStartEligible = system.getFacilityConditionIndex() == null || system.getFacilityConditionIndex().getEnergyStarEligible() == null ? "" : "<ENERGYSTARELIGIBLE xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getFacilityConditionIndex().getEnergyStarEligible() + "</ENERGYSTARELIGIBLE>";
//
//        String isFacility = system.getFacilityConditionIndex() == null || system.getFacilityConditionIndex().getIsFacility() == null ? "" : "<ISFACILITY xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getFacilityConditionIndex().getIsFacility() + "</ISFACILITY>";
//
//        String facilityConditionIndex = system.getFacilityConditionIndex() == null ? "" : "<FacilityConditionIndex>" +
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

        String resourceEnabled = system.getResourceEnabled() == null ? "" : "<RESOURCEENABLED xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getResourceEnabled() + "</RESOURCEENABLED>";

//        String rankingLocked = system.getReliabilityRankingDetails() == null || system.getReliabilityRankingDetails().getRankingLocked() == null ? "" : "<RELIABILITYRANKINGLOCKED>" + system.getReliabilityRankingDetails().getRankingLocked() + "</RELIABILITYRANKINGLOCKED>";
//        String indexCode = system.getReliabilityRankingDetails() == null || system.getReliabilityRankingDetails().getRankingIndexCode() == null ? "" : "<RELIABILITYRANKINGINDEXCODE>" + system.getReliabilityRankingDetails().getRankingIndexCode() + "</RELIABILITYRANKINGINDEXCODE>";
//
//        String reliabilityRankingIdOrg = system.getReliabilityRankingDetails() == null || system.getReliabilityRankingDetails().getRankingId() == null || system.getReliabilityRankingDetails().getRankingId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"BookedHours\">" +
//                "<ORGANIZATIONCODE>" + system.getReliabilityRankingDetails().getRankingId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
//                "<DESCRIPTION>" + system.getReliabilityRankingDetails().getRankingId().getOrganization().getDescription() + "</DESCRIPTION>" +
//                "</ORGANIZATIONID>";
//
//        String reliabilityRankingId = system.getReliabilityRankingDetails() == null || system.getReliabilityRankingDetails().getRankingId() == null ? "" : "<RELIABILITYRANKINGID>" +
//                "<RELIABILITYRANKINGCODE>" + system.getReliabilityRankingDetails().getRankingId().getCode() + "</RELIABILITYRANKINGCODE>" +
//                "<RELIABILITYRANKINGREVISION>" + system.getReliabilityRankingDetails().getRankingId().getRevision() + "</RELIABILITYRANKINGREVISION>" +
//                reliabilityRankingIdOrg +
//                "<DESCRIPTION>" + system.getReliabilityRankingDetails().getRankingId().getDescription() + "</DESCRIPTION>" +
//                "</RELIABILITYRANKINGID>";
//
//        String rankingScore = system.getReliabilityRankingDetails() == null || system.getReliabilityRankingDetails().getRankingScore() == null ? "" : "<RELIABILITYRANKINGSCORE qualifier=\"ACCEPTED\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getRankingScore().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getRankingScore().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getRankingScore().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getRankingScore().getUom() + "</UOM>" +
//                "</RELIABILITYRANKINGSCORE>";
//
//        String outOfSync = system.getReliabilityRankingDetails() == null || system.getReliabilityRankingDetails().getOutOfSync() == null ? "" : "<OUTOFSYNC>" + system.getReliabilityRankingDetails().getOutOfSync() + "</OUTOFSYNC>";
//
//        String setupLastUpdate = system.getReliabilityRankingDetails() == null || system.getReliabilityRankingDetails().getSetupLastUpdate() == null ? "" : "<SETUPLASTUPDATEDDATE qualifier=\"ACCOUNTING\">" +
//                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getSetupLastUpdate().getYear() + "</YEAR>" +
//                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getSetupLastUpdate().getMonth() + "</MONTH>" +
//                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getSetupLastUpdate().getDay() + "</DAY>" +
//                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getSetupLastUpdate().getHour() + "</HOUR>" +
//                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getSetupLastUpdate().getMinute() + "</MINUTE>" +
//                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getSetupLastUpdate().getSecond() + "</SECOND>" +
//                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getSetupLastUpdate().getNano() + "</SUBSECOND>" +
//                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getSetupLastUpdate().getTimeZone() + "</TIMEZONE>" +
//                "</SETUPLASTUPDATEDDATE>";
//
//        String surveyLastUpdate = system.getReliabilityRankingDetails() == null || system.getReliabilityRankingDetails().getSurveyLastUpdate() == null ? "" : "<SURVEYLASTUPDATEDDATE qualifier=\"ACCOUNTING\">" +
//                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getSurveyLastUpdate().getYear() + "</YEAR>" +
//                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getSurveyLastUpdate().getMonth() + "</MONTH>" +
//                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getSurveyLastUpdate().getDay() + "</DAY>" +
//                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getSurveyLastUpdate().getHour() + "</HOUR>" +
//                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getSurveyLastUpdate().getMinute() + "</MINUTE>" +
//                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getSurveyLastUpdate().getSecond() + "</SECOND>" +
//                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getSurveyLastUpdate().getNano() + "</SUBSECOND>" +
//                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getSurveyLastUpdate().getTimeZone() + "</TIMEZONE>" +
//                "</SURVEYLASTUPDATEDDATE>";
//
//        String lastCalculatedDate = system.getReliabilityRankingDetails() == null || system.getReliabilityRankingDetails().getValuesLastUpdate() == null ? "" : "<VALUESLASTCALCULATEDDATE qualifier=\"ACCOUNTING\">" +
//                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getValuesLastUpdate().getYear() + "</YEAR>" +
//                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getValuesLastUpdate().getMonth() + "</MONTH>" +
//                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getValuesLastUpdate().getDay() + "</DAY>" +
//                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getValuesLastUpdate().getHour() + "</HOUR>" +
//                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getValuesLastUpdate().getMinute() + "</MINUTE>" +
//                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getValuesLastUpdate().getSecond() + "</SECOND>" +
//                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getValuesLastUpdate().getNano() + "</SUBSECOND>" +
//                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getReliabilityRankingDetails().getValuesLastUpdate().getTimeZone() + "</TIMEZONE>" +
//                "</VALUESLASTCALCULATEDDATE>";
//
//        String reliabilityRankingDetails = system.getReliabilityRankingDetails() == null ? "" : "<RELIABILITYRANKINGDETAILS xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                rankingLocked +
//                indexCode +
//                reliabilityRankingId +
//                rankingScore +
//                outOfSync +
//                setupLastUpdate +
//                surveyLastUpdate +
//                lastCalculatedDate +
//                "</RELIABILITYRANKINGDETAILS>";
//
//        String vehicleType = system.getRentalDetails() == null || system.getRentalDetails().getVehicleType() == null ? "" : "<VEHICLETYPE entity=\"User\">" +
//                "<TYPECODE>" + system.getRentalDetails().getVehicleType().getCode() + "</TYPECODE>" +
//                "<DESCRIPTION>" + system.getRentalDetails().getVehicleType().getDescription() + "</DESCRIPTION>" +
//                "</VEHICLETYPE>";
//
//        String isRental = system.getRentalDetails() == null || system.getRentalDetails().getIsRental() == null ? "" : "<ISRENTAL>" + system.getRentalDetails().getIsRental() + "</ISRENTAL>";
//
//        String rentalTemplateIdOrg = system.getRentalDetails() == null || system.getRentalDetails().getRentalTemplateId() == null || system.getRentalDetails().getRentalTemplateId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"Store\">" +
//                "<ORGANIZATIONCODE>" + system.getRentalDetails().getRentalTemplateId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
//                "<DESCRIPTION>" + system.getRentalDetails().getRentalTemplateId().getOrganization().getDescription() + "</DESCRIPTION>" +
//                "</ORGANIZATIONID>";
//
//        String rentalTemplateId = system.getRentalDetails() == null || system.getRentalDetails().getRentalTemplateId() == null ? "" : "<RENTALTEMPLATEID>" +
//                "<RENTALTEMPLATECODE>" + system.getRentalDetails().getRentalTemplateId().getCode() + "</RENTALTEMPLATECODE>" +
//                rentalTemplateIdOrg +
//                "<DESCRIPTION>" + system.getRentalDetails().getRentalTemplateId().getDescription() + "</DESCRIPTION>" +
//                "</RENTALTEMPLATEID>";
//
//        String isContract = system.getRentalDetails() == null || system.getRentalDetails().getIsContract() == null ? "" : "<ISCONTRACT>" + system.getRentalDetails().getIsContract() + "</ISCONTRACT>";
//
//        String contractTemplateIdOrg = system.getRentalDetails() == null || system.getRentalDetails().getContractTemplateId() == null || system.getRentalDetails().getContractTemplateId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"StoreDefault\">" +
//                "<ORGANIZATIONCODE>" + system.getRentalDetails().getContractTemplateId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
//                "<DESCRIPTION>" + system.getRentalDetails().getContractTemplateId().getOrganization().getDescription() + "</DESCRIPTION>" +
//                "</ORGANIZATIONID>";
//
//        String contractTemplateId = system.getRentalDetails() == null || system.getRentalDetails().getContractTemplateId() == null ? "" : "<CONTRACTTEMPLATEID>" +
//                "<CONTRACTTEMPLATECODE>" + system.getRentalDetails().getContractTemplateId().getCode() + "</CONTRACTTEMPLATECODE>" +
//                contractTemplateIdOrg +
//                "<DESCRIPTION>" + system.getRentalDetails().getContractTemplateId().getDescription() + "</DESCRIPTION>" +
//                "</CONTRACTTEMPLATEID>";
//
//        String customerId = system.getRentalDetails() == null || system.getRentalDetails().getVehicleType() == null ? "" : "<CUSTOMERID>" +
//                "<CUSTOMERCODE>" + system.getRentalDetails().getCustomerId().getCode() + "</CUSTOMERCODE>" +
//                "<ORGANIZATIONID entity=\"Activity\">" +
//                "<ORGANIZATIONCODE>" + system.getRentalDetails().getCustomerId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
//                "<DESCRIPTION>" + system.getRentalDetails().getCustomerId().getOrganization().getDescription() + "</DESCRIPTION>" +
//                "</ORGANIZATIONID>" +
//                "<DESCRIPTION>" + system.getRentalDetails().getCustomerId().getDescription() + "</DESCRIPTION>" +
//                "</CUSTOMERID>";
//
//        String availabilityStatus = system.getRentalDetails() == null || system.getRentalDetails().getVehicleType() == null ? "" : "<AVAILABILITYSTATUS entity=\"User\">" +
//                "<STATUSCODE>" + system.getRentalDetails().getAvailabilityStatus().getCode() + "</STATUSCODE>" +
//                "<DESCRIPTION>" + system.getRentalDetails().getAvailabilityStatus().getDescription() + "</DESCRIPTION>" +
//                "</AVAILABILITYSTATUS>";
//
//        String issueTo = system.getRentalDetails() == null || system.getRentalDetails().getVehicleType() == null ? "" : "<ISSUETO>" +
//                "<PERSONCODE>" + system.getRentalDetails().getIssueTo().getCode() + "</PERSONCODE>" +
//                "<DESCRIPTION>" + system.getRentalDetails().getIssueTo().getDescription() + "</DESCRIPTION>" +
//                "</ISSUETO>";
//
//        String contractRentalDetails = system.getRentalDetails() == null ? "" : "<CONTRACTANDRENTALDETAILS xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                vehicleType +
//                isRental +
//                rentalTemplateId +
//                isContract +
//                contractTemplateId +
//                customerId +
//                availabilityStatus +
//                issueTo +
//                "</CONTRACTANDRENTALDETAILS>";

        String equipmentAlias = system.getEquipmentAlias() == null ? "" : "<EQUIPMENTALIAS xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getEquipmentAlias() + "</EQUIPMENTALIAS>";

        String safetyDate = system.getSafetyReviewRequired() == null ? "" : "<SAFETYDATEREVIEWREQUIRED qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getSafetyReviewRequired().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getSafetyReviewRequired().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getSafetyReviewRequired().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getSafetyReviewRequired().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getSafetyReviewRequired().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getSafetyReviewRequired().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getSafetyReviewRequired().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getSafetyReviewRequired().getTimeZone() + "</TIMEZONE>" +
                "</SAFETYDATEREVIEWREQUIRED>";

        String safetyReview = system.getSafetyReviewedBy() == null ? "" : "<SAFETYREVIEWEDBY xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<USERCODE>" + system.getSafetyReviewedBy().getCode() + "</USERCODE>" +
                "<DESCRIPTION>" + system.getSafetyReviewedBy().getDescription() + "</DESCRIPTION>" +
                "</SAFETYREVIEWEDBY>";

        String permitDate = system.getPermitDateReviewRequired() == null ? "" : "<PERMITDATEREVIEWREQUIRED qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPermitDateReviewRequired().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPermitDateReviewRequired().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPermitDateReviewRequired().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPermitDateReviewRequired().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPermitDateReviewRequired().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPermitDateReviewRequired().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPermitDateReviewRequired().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPermitDateReviewRequired().getTimeZone() + "</TIMEZONE>" +
                "</PERMITDATEREVIEWREQUIRED>";

        String permitReview = system.getPermitReviewedBy() == null ? "" : "<PERMITREVIEWEDBY xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<USERCODE>" + system.getPermitReviewedBy().getCode() + "</USERCODE>" +
                "<DESCRIPTION>" + system.getPermitReviewedBy().getDescription() + "</DESCRIPTION>" +
                "</PERMITREVIEWEDBY>";

        String loToDate = system.getLotoDateReviewRequired() == null ? "" : "<LOTODATEREVIEWREQUIRED qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLotoDateReviewRequired().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLotoDateReviewRequired().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLotoDateReviewRequired().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLotoDateReviewRequired().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLotoDateReviewRequired().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLotoDateReviewRequired().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLotoDateReviewRequired().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLotoDateReviewRequired().getTimeZone() + "</TIMEZONE>" +
                "</LOTODATEREVIEWREQUIRED>";

        String loToReview = system.getLotoReviewedBy() == null ? "" : "<LOTOREVIEWEDBY xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<USERCODE>" + system.getLotoReviewedBy().getCode() + "</USERCODE>" +
                "<DESCRIPTION>" + system.getLotoReviewedBy().getDescription() + "</DESCRIPTION>" +
                "</LOTOREVIEWEDBY>";

//        String equipmentConfigurationIdOrg = system.getEquipmentConfigurationId() == null || system.getEquipmentConfigurationId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"ActivityDefault\">" +
//                "<ORGANIZATIONCODE>" + system.getEquipmentConfigurationId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
//                "<DESCRIPTION>" + system.getEquipmentConfigurationId().getOrganization().getDescription() + "</DESCRIPTION>" +
//                "</ORGANIZATIONID>";
//
//        String equipmentConfigurationIdRevision = system.getEquipmentConfigurationId() == null || system.getEquipmentConfigurationId().getRevisionNum() == null ? "" : "<REVISIONNUM qualifier=\"ACCEPTED\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getEquipmentConfigurationId().getRevisionNum().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getEquipmentConfigurationId().getRevisionNum().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getEquipmentConfigurationId().getRevisionNum().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getEquipmentConfigurationId().getRevisionNum().getUom() + "</UOM>" +
//                "</REVISIONNUM>";
//
//        String equipmentConfigurationId = system.getEquipmentConfigurationId() == null ? "" : "<EQUIPMENTCONFIGURATIONID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<EQUIPMENTCONFIGURATIONCODE>" + system.getEquipmentConfigurationId().getCode() + "</EQUIPMENTCONFIGURATIONCODE>" +
//                equipmentConfigurationIdOrg +
//                equipmentConfigurationIdRevision +
//                "<DESCRIPTION>" + system.getEquipmentConfigurationId().getDescription() + "</DESCRIPTION>" +
//                "</EQUIPMENTCONFIGURATIONID>";

        String rcmLevel = system.getRcmLevelId() == null ? "" : "<RCMLEVELID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<ENTITY>" + system.getRcmLevelId().getEntity() + "</ENTITY>" +
                "<USERDEFINEDCODE>" + system.getRcmLevelId().getCode() + "</USERDEFINEDCODE>" +
                "<DESCRIPTION>" + system.getRcmLevelId().getDescription() + "</DESCRIPTION>" +
                "</RCMLEVELID>";

        String riskMatrixSetup = system.getRiskMatrixSetupId() == null ? "" : "<RISKMATRIXSETUPID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<RISKMATRIXSETUPCODE>" + system.getRiskMatrixSetupId().getCode() + "</RISKMATRIXSETUPCODE>" +
                "<DESCRIPTION>" + system.getRiskMatrixSetupId().getDescription() + "</DESCRIPTION>" +
                "</RISKMATRIXSETUPID>";

        String riskPriorityNumber = system.getRiskPriorityNumber() == null ? "" : "<RISKPRIORITYNUMBER qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getRiskPriorityNumber().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getRiskPriorityNumber().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getRiskPriorityNumber().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getRiskPriorityNumber().getUom() + "</UOM>" +
                "</RISKPRIORITYNUMBER>";

        String originalReceiptDate = system.getOriginalReceiptDate() == null ? "" : "<ORIGINALRECEIPTDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getOriginalReceiptDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getOriginalReceiptDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getOriginalReceiptDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getOriginalReceiptDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getOriginalReceiptDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getOriginalReceiptDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getOriginalReceiptDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getOriginalReceiptDate().getTimeZone() + "</TIMEZONE>" +
                "</ORIGINALRECEIPTDATE>";

        String latestReceiptDate = system.getLatestReceiptDate() == null ? "" : "<LATESTRECEIPTDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLatestReceiptDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLatestReceiptDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLatestReceiptDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLatestReceiptDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLatestReceiptDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLatestReceiptDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLatestReceiptDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLatestReceiptDate().getTimeZone() + "</TIMEZONE>" +
                "</LATESTRECEIPTDATE>";

        String originalInstallDate = system.getOriginalInstallDate() == null ? "" : "<ORIGINALINSTALLDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getOriginalInstallDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getOriginalInstallDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getOriginalInstallDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getOriginalInstallDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getOriginalInstallDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getOriginalInstallDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getOriginalInstallDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getOriginalInstallDate().getTimeZone() + "</TIMEZONE>" +
                "</ORIGINALINSTALLDATE>";

        String latestInstallDate = system.getLatestInstallDate() == null ? "" : "<LATESTINSTALLDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLatestInstallDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLatestInstallDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLatestInstallDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLatestInstallDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLatestInstallDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLatestInstallDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLatestInstallDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getLatestInstallDate().getTimeZone() + "</TIMEZONE>" +
                "</LATESTINSTALLDATE>";

        String docuMoto = system.getDocuMotoBookId() == null ? "" : "<DOCUMOTOBOOKID xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getDocuMotoBookId() + "</DOCUMOTOBOOKID>";

        String reservationCalendarOwner = system.getReservationCalendarOwner() == null ? "" : "<RESERVATIONCALENDAROWNER xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<USERCODE>" + system.getReservationCalendarOwner().getCode() + "</USERCODE>" +
                "<DESCRIPTION>" + system.getReservationCalendarOwner().getDescription() + "</DESCRIPTION>" +
                "</RESERVATIONCALENDAROWNER>";

        String reservationCalendarOwnerListOrg = system.getReservationCalendarOwnerList() == null || system.getReservationCalendarOwnerList().getOrganization() == null ? "" :  "<ORGANIZATIONID entity=\"LaborRequisition\">" +
                "<ORGANIZATIONCODE>" + system.getReservationCalendarOwnerList().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + system.getReservationCalendarOwnerList().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String reservationCalendarOwnerList = system.getReservationCalendarOwnerList() == null ? "" : "<RESERVATIONCALENDAROWNERSLIST xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<APPROVALLISTCODE>" + system.getReservationCalendarOwnerList().getCode() + "</APPROVALLISTCODE>" +
                "<DESCRIPTION>" + system.getReservationCalendarOwnerList().getDescription() + "</DESCRIPTION>" +
                reservationCalendarOwnerListOrg +
                "</RESERVATIONCALENDAROWNERSLIST>";

        String workSpaceIdOrg = system.getWorkSpaceId() == null || system.getWorkSpaceId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"CustomFields\">" +
                "<ORGANIZATIONCODE>" + system.getWorkSpaceId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + system.getWorkSpaceId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String workSpaceId = system.getWorkSpaceId() == null ? "" : "<WORKSPACEID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<WORKSPACENUMBER>" + system.getWorkSpaceId().getNumber() + "</WORKSPACENUMBER>" +
                "<WORKSPACECODE>" + system.getWorkSpaceId().getCode() + "</WORKSPACECODE>" +
                workSpaceIdOrg +
                "<DESCRIPTION>" + system.getWorkSpaceId().getDescription() + "</DESCRIPTION>" +
                "</WORKSPACEID>";

        String setIdOrg = system.getSetId() == null || system.getSetId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"EquipmentSummary\">" +
                "<ORGANIZATIONCODE>" + system.getSetId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + system.getSetId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String setId = system.getSetId() == null ? "" : "<SETID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<SETCONSISTPK>" + system.getSetId().getPk() + "</SETCONSISTPK>" +
                "<SETCONSISTCODE>" + system.getSetId().getCode() + "</SETCONSISTCODE>" +
                "<DESCRIPTION>" + system.getSetId().getDescription() + "</DESCRIPTION>" +
                setIdOrg +
                "</SETID>";

        String setPosition = system.getSetPosition() == null ? "" : "<SETPOSITION xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getSetPosition() + "</SETPOSITION>";

        String consistIdOrg = system.getConsistId() == null || system.getConsistId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"StorePart\">" +
                "<ORGANIZATIONCODE>" + system.getConsistId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + system.getConsistId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String consistId = system.getConsistId() == null ? "" : "<CONSISTID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<SETCONSISTPK>" + system.getConsistId().getPk() + "</SETCONSISTPK>" +
                "<SETCONSISTCODE>" + system.getConsistId().getCode() + "</SETCONSISTCODE>" +
                "<DESCRIPTION>" + system.getConsistId().getDescription() + "</DESCRIPTION>" +
                consistIdOrg +
                "</CONSISTID>";

        String consistPosition = system.getConsistPosition() == null ? "" : "<CONSISTPOSITION xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getConsistPosition() + "</CONSISTPOSITION>";

        String url = system.getUrl() == null ? "" : "<URL xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getUrl() + "</URL>";

        String conditionIndex = system.getConditionIndex() == null ? "" : "<CONDITIONINDEX xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<ENTITY>" + system.getConditionIndex().getEntity() + "</ENTITY>" +
                "<USERDEFINEDCODE>" + system.getConditionIndex().getCode() + "</USERDEFINEDCODE>" +
                "<DESCRIPTION>" + system.getConditionIndex().getDescription() + "</DESCRIPTION>" +
                "</CONDITIONINDEX>";

        String conditionScore = system.getConditionScore() == null ? "" : "<CONDITIONSCORE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getConditionScore().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getConditionScore().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getConditionScore().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getConditionScore().getUom() + "</UOM>" +
                "</CONDITIONSCORE>";

        String processError = system.getProcessError() == null ? "" : "<PROCESSERROR xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getProcessError() + "</PROCESSERROR>";

        String linearUomId = system.getLinearUomId() == null ? "" : "<LINEARUOMID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<LINEARREFUOM>" + system.getLinearUomId().getCode() + "</LINEARREFUOM>" +
                "<DESCRIPTION>" + system.getLinearUomId().getDescription() + "</DESCRIPTION>" +
                "</LINEARUOMID>";

        String equipmentLength = system.getEquipmentLengthOverride() == null ? "" : "<EQUIPMENTLENGTHOVERRIDE xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getEquipmentLengthOverride() + "</EQUIPMENTLENGTHOVERRIDE>";
        String tempMonitored = system.getTempMonitored() == null ? "" : "<TEMPMONITORED xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getTempMonitored() + "</TEMPMONITORED>";
        String hardwareVersion = system.getHardwareVersion() == null ? "" : "<HARDWAREVER xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getHardwareVersion() + "</HARDWAREVER>";
        String softwareVersion = system.getSoftwareVersion() == null ? "" : "<SOFTWAREVER xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getSoftwareVersion() + "</SOFTWAREVER>";
        String purchasingAsset = system.getPurchasingAsset() == null ? "" : "<PURCHASINGASSET xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getPurchasingAsset() + "</PURCHASINGASSET>";
        String bioMedicalAsset = system.getBioMedicalAsset() == null ? "" : "<BIOMEDICALASSET xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getBioMedicalAsset() + "</BIOMEDICALASSET>";

        String umdNs = system.getUdmNs() == null ? "" : "<UMDNS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<TYPECODE>" + system.getUdmNs().getCode() + "</TYPECODE>" +
                "<DESCRIPTION>" + system.getUdmNs().getDescription() + "</DESCRIPTION>" +
                "</UMDNS>";

        String oemSite = system.getOemSite() == null ? "" : "<OEMSITE xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getOemSite() + "</OEMSITE>";
        String vendor = system.getVendor() == null ? "" : "<VENDOR xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getVendor() + "</VENDOR>";

        String coverageType = system.getCoverageType() == null ? "" : "<COVERAGETYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<TYPECODE>" + system.getCoverageType().getCode() + "</TYPECODE>" +
                "<DESCRIPTION>" + system.getCoverageType().getDescription() + "</DESCRIPTION>" +
                "</COVERAGETYPE>";

        String lockout = system.getLockout() == null ? "" : "<LOCKOUT xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getLockout() + "</LOCKOUT>";
        String personalProtectiveEquipment = system.getPersonalProtectiveEquipment() == null ? "" : "<PERSONALPROTECTIVEEQUIP xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getPersonalProtectiveEquipment() + "</PERSONALPROTECTIVEEQUIP>";
        String confinedSpace = system.getConfinedSpace() == null ? "" : "<CONFINEDSPACE xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getConfinedSpace() + "</CONFINEDSPACE>";
        String statementOfCondition = system.getStatementOfCondition() == null ? "" : "<STATEMENTOFCOND xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getStatementOfCondition() + "</STATEMENTOFCOND>";
        String buildMaintenanceProgram = system.getBuildMaintenanceProgram() == null ? "" : "<BUILDMAINTPROGRAM xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getBuildMaintenanceProgram() + "</BUILDMAINTPROGRAM>";
        String hipaaConfidentiality = system.getHipaaConfidentiality() == null ? "" : "<HIPAACONFIDENTIALITY xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getHipaaConfidentiality() + "</HIPAACONFIDENTIALITY>";

        String ownershipType = system.getOwnershipType() == null ? "" : "<OWNERSHIPTYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<TYPECODE>" + system.getOwnershipType().getCode() + "</TYPECODE>" +
                "<DESCRIPTION>" + system.getOwnershipType().getDescription() + "</DESCRIPTION>" +
                "</OWNERSHIPTYPE>";

        String inventoryVerificationDate = system.getInventoryVerificationDate() == null ? "" : "<INVENTORYVERIFICATIONDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getInventoryVerificationDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getInventoryVerificationDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getInventoryVerificationDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getInventoryVerificationDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getInventoryVerificationDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getInventoryVerificationDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getInventoryVerificationDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getInventoryVerificationDate().getTimeZone() + "</TIMEZONE>" +
                "</INVENTORYVERIFICATIONDATE>";

        String assetValue = system.getAssetValue() == null ? "" : "<ASSETVALUE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getAssetValue().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getAssetValue().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getAssetValue().getSign() + "</SIGN>" +
                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getAssetValue().getCurrency() + "</CURRENCY>" +
                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getAssetValue().getDRCR() + "</DRCR>" +
                "</ASSETVALUE>";

        String purchaseOrderCode = system.getPurchaseOrderCode() == null ? "" : "<PURCHASEORDERCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getPurchaseOrderCode() + "</PURCHASEORDERCODE>";

        String purchaseOrderDate = system.getPurchaseDate() == null ? "" : "<PURCHASEDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPurchaseDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPurchaseDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPurchaseDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPurchaseDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPurchaseDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPurchaseDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPurchaseDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPurchaseDate().getTimeZone() + "</TIMEZONE>" +
                "</PURCHASEDATE>";

        String purchaseCost = system.getPurchaseCost() == null ? "" : "<PURCHASECOST qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPurchaseCost().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPurchaseCost().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPurchaseCost().getSign() + "</SIGN>" +
                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPurchaseCost().getCurrency() + "</CURRENCY>" +
                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPurchaseCost().getDRCR() + "</DRCR>" +
                "</PURCHASECOST>";

        String purchaseCurrency = system.getPurchaseCurrency() == null ? "" : "<PURCHASECURRENCY xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<CURRENCYCODE>" + system.getPurchaseCurrency().getCode() + "</CURRENCYCODE>" +
                "<DESCRIPTION>" + system.getPurchaseCurrency().getDescription() + "</DESCRIPTION>" +
                "</PURCHASECURRENCY>";

        String disposalType = system.getDisposalType() == null ? "" : "<DISPOSALTYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<TYPECODE>" + system.getDisposalType().getCode() + "</TYPECODE>" +
                "<DESCRIPTION>" + system.getDisposalType().getDescription() + "</DESCRIPTION>" +
                "</DISPOSALTYPE>";

        String checkListFilter = system.getCheckListFilter() == null ? "" : "<CHECKLISTFILTER xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getCheckListFilter() + "</CHECKLISTFILTER>";

        String toleranceSize = system.getToleranceSize() == null ? "" : "<TOLERANCESIZE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getToleranceSize().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getToleranceSize().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getToleranceSize().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getToleranceSize().getUom() + "</UOM>" +
                "</TOLERANCESIZE>";

        String fuelId = system.getFuelId() == null ? "" : "<FUELID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<FUELCODE>" + system.getFuelId().getCode() + "</FUELCODE>" +
                "<DESCRIPTION>" + system.getFuelId().getDescription() + "</DESCRIPTION>" +
                "</FUELID>";

        String riskPriorityCode = system.getRiskPriorityCode() == null ? "" : "<RISKPRIORITYCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getRiskPriorityCode() + "</RISKPRIORITYCODE>";

        String criticalityScore = system.getCriticalityScore() == null ? "" : "<CRITICALITYSCORE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCriticalityScore().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCriticalityScore().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCriticalityScore().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCriticalityScore().getUom() + "</UOM>" +
                "</CRITICALITYSCORE>";

        String correctionConditionScore = system.getCorrectionConditionScore() == null ? "" : "<CORRECTIONCONDITIONSCORE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCorrectionConditionScore().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCorrectionConditionScore().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCorrectionConditionScore().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCorrectionConditionScore().getUom() + "</UOM>" +
                "</CORRECTIONCONDITIONSCORE>";

        String correctionConditionReason = system.getCorrectionConditionReason() == null ? "" : "<CORRECTIONCONDITIONREASON xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getCorrectionConditionReason() + "</CORRECTIONCONDITIONREASON>";

        String correctionConditionDate = system.getCorrectionConditionDate() == null ? "" : "<CORRECTIONCONDITIONDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCorrectionConditionDate().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCorrectionConditionDate().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCorrectionConditionDate().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCorrectionConditionDate().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCorrectionConditionDate().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCorrectionConditionDate().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCorrectionConditionDate().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCorrectionConditionDate().getTimeZone() + "</TIMEZONE>" +
                "</CORRECTIONCONDITIONDATE>";

        String correctionUsage = system.getCorrectionUsage() == null ? "" : "<CORRECTIONUSAGE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCorrectionUsage().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCorrectionUsage().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCorrectionUsage().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getCorrectionUsage().getUom() + "</UOM>" +
                "</CORRECTIONUSAGE>";

        String correctionUsageUom = system.getCorrectionUsageUom() == null ? "" : "<CORRECTIONUSAGEUOM xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<UOMCODE>" + system.getCorrectionUsageUom().getCode() + "</UOMCODE>" +
                "<DESCRIPTION>" + system.getCorrectionUsageUom().getDescription() + "</DESCRIPTION>" +
                "</CORRECTIONUSAGEUOM>";

        String endUsefulLife = system.getEndUsefulLife() == null ? "" : "<ENDUSEFULLIFE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getEndUsefulLife().getYear() + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getEndUsefulLife().getMonth() + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getEndUsefulLife().getDay() + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getEndUsefulLife().getHour() + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getEndUsefulLife().getMinute() + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getEndUsefulLife().getSecond() + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getEndUsefulLife().getNano() + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getEndUsefulLife().getTimeZone() + "</TIMEZONE>" +
                "</ENDUSEFULLIFE>";

        String remainingUsefulLife = system.getRemainingUsefulLife() == null ? "" : "<REMAININGUSEFULLIFE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getRemainingUsefulLife().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getRemainingUsefulLife().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getRemainingUsefulLife().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getRemainingUsefulLife().getUom() + "</UOM>" +
                "</REMAININGUSEFULLIFE>";

        String serviceLifeUsage = system.getServiceLifeUsage() == null ? "" : "<SERVICELIFEUSAGE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getServiceLifeUsage().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getServiceLifeUsage().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getServiceLifeUsage().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getServiceLifeUsage().getUom() + "</UOM>" +
                "</SERVICELIFEUSAGE>";

        String serviceLifeUsageUom = system.getServiceLifeUsageUom() == null ? "" : "<SERVICELIFEUSAGEUOM xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<UOMCODE>" + system.getServiceLifeUsageUom().getCode() + "</UOMCODE>" +
                "<DESCRIPTION>" + system.getServiceLifeUsageUom().getDescription() + "</DESCRIPTION>" +
                "</SERVICELIFEUSAGEUOM>";

        String profilePictureOrg = system.getProfileId() == null || system.getProfileId().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"BinStockDefault\">" +
                "<ORGANIZATIONCODE>" + system.getProfileId().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
                "<DESCRIPTION>" + system.getProfileId().getOrganization().getDescription() + "</DESCRIPTION>" +
                "</ORGANIZATIONID>";

        String profilePicture = system.getProfileId() == null ? "" : "<PROFILEPICTURE xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<DOCUMENTCODE>" + system.getProfileId().getCode() + "</DOCUMENTCODE>" +
                profilePictureOrg +
                "<DESCRIPTION>" + system.getProfileId().getDescription() + "</DESCRIPTION>" +
                "</PROFILEPICTURE>";

//        String performanceFormulaIdOrg = system.getPerformanceDetails() == null || system.getPerformanceDetails().getPerformanceFormula() == null || system.getPerformanceDetails().getPerformanceFormula().getOrganization() == null ? "" : "<ORGANIZATIONID entity=\"BinStock\">" +
//                "<ORGANIZATIONCODE>" + system.getPerformanceDetails().getPerformanceFormula().getOrganization().getCode() + "</ORGANIZATIONCODE>" +
//                "<DESCRIPTION>" + system.getPerformanceDetails().getPerformanceFormula().getOrganization().getDescription() + "</DESCRIPTION>" +
//                "</ORGANIZATIONID>";
//
//        String performanceFormulaIdRevision = system.getPerformanceDetails() == null || system.getPerformanceDetails().getPerformanceFormula() == null || system.getPerformanceDetails().getPerformanceFormula().getRevisionNum() == null ? "" : "<REVISIONNUM qualifier=\"ACTDUR\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getPerformanceFormula().getRevisionNum().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getPerformanceFormula().getRevisionNum().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getPerformanceFormula().getRevisionNum().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getPerformanceFormula().getRevisionNum().getUom() + "</UOM>" +
//                "</REVISIONNUM>";
//
//        String performanceFormulaId = system.getPerformanceDetails() == null || system.getPerformanceDetails().getPerformanceFormula() == null ? "" : "<PERFORMANCEFORMULAID auto_generated=\"false\" entity=\"ent1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<STANDARDENTITYCODE>" + system.getPerformanceDetails().getPerformanceFormula().getCode() + "</STANDARDENTITYCODE>" +
//                performanceFormulaIdRevision +
//                performanceFormulaIdOrg +
//                "<DESCRIPTION>" + system.getPerformanceDetails().getPerformanceFormula().getDescription() + "</DESCRIPTION>" +
//                "</PERFORMANCEFORMULAID>";
//
//        String performance = system.getPerformanceDetails() == null || system.getPerformanceDetails().getPerformance() == null ? "" : "<PERFORMANCE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getPerformance().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getPerformance().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getPerformance().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getPerformance().getUom() + "</UOM>" +
//                "</PERFORMANCE>";
//
//        String lastUpdatedDate = system.getPerformanceDetails() == null || system.getPerformanceDetails().getLastUpdatedDate() == null ? "" : "<LASTUPDATEDDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getLastUpdatedDate().getYear() + "</YEAR>" +
//                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getLastUpdatedDate().getMonth() + "</MONTH>" +
//                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getLastUpdatedDate().getDay() + "</DAY>" +
//                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getLastUpdatedDate().getHour() + "</HOUR>" +
//                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getLastUpdatedDate().getMinute() + "</MINUTE>" +
//                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getLastUpdatedDate().getSecond() + "</SECOND>" +
//                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getLastUpdatedDate().getNano() + "</SUBSECOND>" +
//                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getLastUpdatedDate().getTimeZone() + "</TIMEZONE>" +
//                "</LASTUPDATEDDATE>";
//
//        String conditionRatingWeight = system.getPerformanceDetails() == null || system.getPerformanceDetails().getConditionRatingWeight() == null ? "" : "<CONDITIONRATINGWEIGHT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getConditionRatingWeight().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getConditionRatingWeight().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getConditionRatingWeight().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getConditionRatingWeight().getUom() + "</UOM>" +
//                "</CONDITIONRATINGWEIGHT>";
//
//        String capacityCode = system.getPerformanceDetails() == null || system.getPerformanceDetails().getCapacityCode() == null ? "" : "<CAPACITYCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<ENTITY>" + system.getPerformanceDetails().getCapacityCode().getEntity() + "</ENTITY>" +
//                "<USERDEFINEDCODE>" + system.getPerformanceDetails().getCapacityCode().getCode() + "</USERDEFINEDCODE>" +
//                "<DESCRIPTION>" + system.getPerformanceDetails().getCapacityCode().getDescription() + "</DESCRIPTION>" +
//                "</CAPACITYCODE>";
//
//        String availableCapacity = system.getPerformanceDetails() == null || system.getPerformanceDetails().getAvailableCapacity() == null ? "" : "<AVAILABLECAPACITY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getAvailableCapacity().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getAvailableCapacity().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getAvailableCapacity().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getAvailableCapacity().getUom() + "</UOM>" +
//                "</AVAILABLECAPACITY>";
//
//        String desiredCapacity = system.getPerformanceDetails() == null || system.getPerformanceDetails().getDesiredCapacity() == null ? "" : "<DESIREDCAPACITY qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getDesiredCapacity().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getDesiredCapacity().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getDesiredCapacity().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getDesiredCapacity().getUom() + "</UOM>" +
//                "</DESIREDCAPACITY>";
//
//        String capacityRatingWeight = system.getPerformanceDetails() == null || system.getPerformanceDetails().getCapacityRatingWeight() == null ? "" : "<CAPACITYRATINGWEIGHT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getCapacityRatingWeight().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getCapacityRatingWeight().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getCapacityRatingWeight().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getCapacityRatingWeight().getUom() + "</UOM>" +
//                "</CAPACITYRATINGWEIGHT>";
//
//        String noOffFailures = system.getPerformanceDetails() == null || system.getPerformanceDetails().getNoOffFailures() == null ? "" : "<NOOFFAILURES qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getNoOffFailures().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getNoOffFailures().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getNoOffFailures().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getNoOffFailures().getUom() + "</UOM>" +
//                "</NOOFFAILURES>";
//
//        String mtbfDays = system.getPerformanceDetails() == null || system.getPerformanceDetails().getMtbfDays() == null ? "" : "<MTBFDAYS qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMtbfDays().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMtbfDays().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMtbfDays().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMtbfDays().getUom() + "</UOM>" +
//                "</MTBFDAYS>";
//
//        String mtbfRatingWeight = system.getPerformanceDetails() == null || system.getPerformanceDetails().getMtbfRatingWeight() == null ? "" : "<MTBFRATINGWEIGHT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMtbfRatingWeight().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMtbfRatingWeight().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMtbfRatingWeight().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMtbfRatingWeight().getUom() + "</UOM>" +
//                "</MTBFRATINGWEIGHT>";
//
//        String mubf = system.getPerformanceDetails() == null || system.getPerformanceDetails().getMubf() == null ? "" : "<MUBF qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMubf().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMubf().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMubf().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMubf().getUom() + "</UOM>" +
//                "</MUBF>";
//
//        String mubfUom = system.getPerformanceDetails() == null || system.getPerformanceDetails().getMubfUom() == null ? "" : "<MUBFUOM xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<UOMCODE>" + system.getPerformanceDetails().getMubfUom().getCode() + "</UOMCODE>" +
//                "<DESCRIPTION>" + system.getPerformanceDetails().getMubfUom().getDescription() + "</DESCRIPTION>" +
//                "</MUBFUOM>";
//
//        String mubfRating = system.getPerformanceDetails() == null || system.getPerformanceDetails().getMubfRating() == null ? "" : "<MUBFRATING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMubfRating().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMubfRating().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMubfRating().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMubfRating().getUom() + "</UOM>" +
//                "</MUBFRATING>";
//
//        String mttrHrs = system.getPerformanceDetails() == null || system.getPerformanceDetails().getMttrHrs() == null ? "" : "<MTTRHRS qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMttrHrs().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMttrHrs().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMttrHrs().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMttrHrs().getUom() + "</UOM>" +
//                "</MTTRHRS>";
//
//        String mttrRating = system.getPerformanceDetails() == null || system.getPerformanceDetails().getMttrRating() == null ? "" : "<MTTRRATING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMttrRating().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMttrRating().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMttrRating().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getMttrRating().getUom() + "</UOM>" +
//                "</MTTRRATING>";
//
//        String variableResult1 = system.getPerformanceDetails() == null || system.getPerformanceDetails().getVariableResult1() == null ? "" : "<VARIABLE1RESULT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult1().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult1().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult1().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult1().getUom() + "</UOM>" +
//                "</VARIABLE1RESULT>";
//
//        String variableResult2 = system.getPerformanceDetails() == null || system.getPerformanceDetails().getVariableResult2() == null ? "" : "<VARIABLE2RESULT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult2().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult2().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult2().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult2().getUom() + "</UOM>" +
//                "</VARIABLE2RESULT>";
//
//        String variableResult3 = system.getPerformanceDetails() == null || system.getPerformanceDetails().getVariableResult3() == null ? "" : "<VARIABLE3RESULT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult3().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult3().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult3().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult3().getUom() + "</UOM>" +
//                "</VARIABLE3RESULT>";
//
//        String variableResult4 = system.getPerformanceDetails() == null || system.getPerformanceDetails().getVariableResult4() == null ? "" : "<VARIABLE4RESULT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult4().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult4().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult4().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult4().getUom() + "</UOM>" +
//                "</VARIABLE4RESULT>";
//
//        String variableResult5 = system.getPerformanceDetails() == null || system.getPerformanceDetails().getVariableResult5() == null ? "" : "<VARIABLE5RESULT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult5().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult5().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult5().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult5().getUom() + "</UOM>" +
//                "</VARIABLE5RESULT>";
//
//        String variableResult6 = system.getPerformanceDetails() == null || system.getPerformanceDetails().getVariableResult6() == null ? "" : "<VARIABLE6RESULT qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult6().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult6().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult6().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableResult6().getUom() + "</UOM>" +
//                "</VARIABLE6RESULT>";
//
//        String variableRating1 = system.getPerformanceDetails() == null || system.getPerformanceDetails().getVariableRating1() == null ? "" : "<VARIABLE1RATING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating1().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating1().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating1().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating1().getUom() + "</UOM>" +
//                "</VARIABLE1RATING>";
//
//        String variableRating2 = system.getPerformanceDetails() == null || system.getPerformanceDetails().getVariableRating2() == null ? "" : "<VARIABLE2RATING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating2().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating2().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating2().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating2().getUom() + "</UOM>" +
//                "</VARIABLE2RATING>";
//
//        String variableRating3 = system.getPerformanceDetails() == null || system.getPerformanceDetails().getVariableRating3() == null ? "" : "<VARIABLE3RATING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating3().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating3().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating3().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating3().getUom() + "</UOM>" +
//                "</VARIABLE3RATING>";
//
//        String variableRating4 = system.getPerformanceDetails() == null || system.getPerformanceDetails().getVariableRating4() == null ? "" : "<VARIABLE4RATING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating4().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating4().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating4().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating4().getUom() + "</UOM>" +
//                "</VARIABLE4RATING>";
//
//        String variableRating5 = system.getPerformanceDetails() == null || system.getPerformanceDetails().getVariableRating5() == null ? "" : "<VARIABLE5RATING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating5().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating5().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating5().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating5().getUom() + "</UOM>" +
//                "</VARIABLE5RATING>";
//
//        String variableRating6 = system.getPerformanceDetails() == null || system.getPerformanceDetails().getVariableRating6() == null ? "" : "<VARIABLE6RATING qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
//                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating6().getValue() + "</VALUE>" +
//                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating6().getDecimals() + "</NUMOFDEC>" +
//                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating6().getSign() + "</SIGN>" +
//                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getPerformanceDetails().getVariableRating6().getUom() + "</UOM>" +
//                "</VARIABLE6RATING>";
//
//        String performanceDetails = system.getPerformanceDetails() == null ? "" : "<PERFORMANCEDETAILS>" +
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

        String riskConsequenceCost = system.getRiskConsequenceCost() == null ? "" : "<RISKCONSEQUENCECOST qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getRiskConsequenceCost().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getRiskConsequenceCost().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getRiskConsequenceCost().getSign() + "</SIGN>" +
                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getRiskConsequenceCost().getCurrency() + "</CURRENCY>" +
                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getRiskConsequenceCost().getDRCR() + "</DRCR>" +
                "</RISKCONSEQUENCECOST>";

        String failureProbPercent = system.getFailureProbabilityPercentage() == null ? "" : "<FAILUREPROBPERCENTAGE qualifier=\"ACCEPTED\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFailureProbabilityPercentage().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFailureProbabilityPercentage().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFailureProbabilityPercentage().getSign() + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getFailureProbabilityPercentage().getUom() + "</UOM>" +
                "</FAILUREPROBPERCENTAGE>";

        String blackSwanCost = system.getBlackSwanCost() == null ? "" : "<BLACKSWANCOST qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getBlackSwanCost().getValue() + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getBlackSwanCost().getDecimals() + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getBlackSwanCost().getSign() + "</SIGN>" +
                "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getBlackSwanCost().getCurrency() + "</CURRENCY>" +
                "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + system.getBlackSwanCost().getDRCR() + "</DRCR>" +
                "</BLACKSWANCOST>";

        String blackSwan = system.getBlackSwan() == null ? "" : "<BLACKSWAN xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getBlackSwan() + "</BLACKSWAN>";

        String currencyCode = system.getCurrencyCode() == null ? "" : "<CURRENCYCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + system.getCurrencyCode() + "</CURRENCYCODE>";

        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "<Body>" +
                "<MP0313_SyncSystemEquipment_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Sync\" noun=\"SystemEquipment\" version=\"001\" confirm_availability_status=\"confirm_availability_status1\" confirmaddlinearreferences=\"confirmaddlinearreferences1\" confirmnewequipmentlength=\"confirmnewequipmentlength1\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0313_001\">" +
                "<SystemEquipment recordid=\"" + system.getUpdatedCount() + "\" user_entity=\"user_entity1\" system_entity=\"system_entity1\" autonumber=\"default\" creategis=\"true\" has_department_security=\"has_1\" has_readonly_department_security_for_createwo=\"has_1\" is_associated_to_current_consist=\"false\" is_default_rankings_available=\"false\" instructure=\"false\" haswo=\"false\" confirm_delete_surveryanswers=\"confirmed\" xmlns=\"http://schemas.datastream.net/MP_entities/SystemEquipment_001\">" +
                systemId +
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
                linkGisObj +
                vmrsCode +
                partLocation +
                gisMapId +
                gisLayer +
                xLocation +
                yLocation +

                userDefinedFields +

                resourceEnabled +

                equipmentAlias +
                safetyDate +
                safetyReview +
                permitDate +
                permitReview +
                loToDate +
                loToReview +

                rcmLevel +
                riskMatrixSetup +
                riskPriorityNumber +
                originalReceiptDate +
                latestReceiptDate +
                originalInstallDate +
                latestInstallDate +
                docuMoto +
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
                equipmentLength +
                tempMonitored +
                hardwareVersion +
                softwareVersion +
                purchasingAsset +
                bioMedicalAsset +
                umdNs +
                oemSite +
                vendor +
                coverageType +
                lockout +
                personalProtectiveEquipment +
                confinedSpace +
                statementOfCondition +
                buildMaintenanceProgram +
                hipaaConfidentiality +
                ownershipType +
                inventoryVerificationDate +
                assetValue +
                purchaseOrderCode +
                purchaseOrderDate +
                purchaseCost +
                purchaseCurrency +
                disposalType +
                checkListFilter +
                toleranceSize +
                fuelId +
                riskPriorityCode +
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
                failureProbPercent +
                blackSwanCost +
                blackSwan +
                currencyCode +
                "</SystemEquipment>" +
                "</MP0313_SyncSystemEquipment_001>" +
                "</Body>" +
                "</Envelope>";
    }
}
