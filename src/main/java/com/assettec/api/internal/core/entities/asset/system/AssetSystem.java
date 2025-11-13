package com.assettec.api.internal.core.entities.asset.system;


import com.assettec.api.internal.core.entities.basic.objects.Id.Id;
import com.assettec.api.internal.core.entities.basic.objects.Id.IdEntity;
import com.assettec.api.internal.core.entities.basic.objects.Id.IdNumber;
import com.assettec.api.internal.core.entities.basic.objects.Id.IdPk;
import com.assettec.api.internal.core.entities.basic.objects.InforEamCode;
import com.assettec.api.internal.core.entities.basic.objects.InforEamCount;
import com.assettec.api.internal.core.entities.basic.objects.InforEamCurrency;
import com.assettec.api.internal.core.entities.basic.objects.InforEamDate;
import com.assettec.api.internal.core.user.info.area.UserDefinedArea;
import com.assettec.api.internal.core.user.info.fields.UserDefinedFields;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssetSystem {
    private Id systemId;
    private InforEamCode type;
    private Id classId;
    private InforEamCode categoryId;
    private InforEamCode status;
    private Id departmentId;
    private InforEamCode operationalStatus;
    private Id LoanedToDepartmentId;
    private Id pmWoDepartment;
    private String inProduction;
    private String safety;
    private String outOfService;
    private Id profileId;
    private Id costCodeId;
    private InforEamDate commissionDate;
    private InforEamDate transferDate;
    private InforEamDate withdrawalDate;
    private InforEamCode AssignedTo;
    private String meterUnit;
    private InforEamCode criticalityId;
    private InforEamDate soldDate;

    private String preventWoCompletion;
    private UserDefinedArea userDefinedArea;
    private String gisObjId;
    private String gisProfile;
    private String cgMp;
    private String linkGisWo;
    private InforEamCode systemLevelId;
    private String partLocationCode;
    private Id gisMapId;
    private String gisLayer;
    private InforEamCount xLocation;
    private InforEamCount yLocation;

    private UserDefinedFields userDefinedFields;

    private String resourceEnabled;

    private String equipmentAlias;

    private String lockout;
    private String personalProtectiveEquipment;
    private String confinedSpace;
    private String statementOfCondition;
    private String buildMaintenanceProgram;
    private String hipaaConfidentiality;
    private InforEamCode ownershipType;
    private InforEamDate inventoryVerificationDate;
    private InforEamCurrency assetValue;
    private String purchaseOrderCode;
    private InforEamDate purchaseDate;
    private InforEamCurrency purchaseCost;
    private InforEamCode purchaseCurrency;
    private InforEamCode disposalType;
    private InforEamDate safetyReviewRequired;
    private InforEamCode safetyReviewedBy;
    private InforEamDate permitDateReviewRequired;
    private InforEamCode permitReviewedBy;
    private InforEamDate lotoDateReviewRequired;
    private InforEamCode lotoReviewedBy;
    private IdEntity rcmLevelId;
    private InforEamCode riskMatrixSetupId;
    private InforEamCount riskPriorityNumber;
    private InforEamDate originalReceiptDate;
    private InforEamDate latestReceiptDate;
    private InforEamDate originalInstallDate;
    private InforEamDate latestInstallDate;
    private String docuMotoBookId;
    private InforEamCode reservationCalendarOwner;
    private Id reservationCalendarOwnerList;
    private IdNumber workSpaceId;
    private IdPk setId;
    private String setPosition;
    private IdPk consistId;
    private String consistPosition;
    private String url;
    private IdEntity conditionIndex;
    private InforEamCount conditionScore;
    private String processError;
    private InforEamCode linearUomId;
    private String equipmentLengthOverride;
    private String checkListFilter;
    private InforEamCount toleranceSize;
    private String tempMonitored;
    private InforEamCode fuelId;
    private String riskPriorityCode;
    private InforEamCount criticalityScore;
    private InforEamCount correctionConditionScore;
    private String correctionConditionReason;
    private InforEamDate correctionConditionDate;
    private InforEamCount correctionUsage;
    private InforEamCode correctionUsageUom;
    private InforEamDate endUsefulLife;
    private InforEamCount remainingUsefulLife;
    private InforEamCount serviceLifeUsage;
    private InforEamCode serviceLifeUsageUom;
    private Id profilePicture;
    private InforEamCurrency riskConsequenceCost;
    private InforEamCount failureProbabilityPercentage;
    private InforEamCurrency blackSwanCost;
    private String blackSwan;
    private String currencyCode;

    private String hardwareVersion;
    private String softwareVersion;
    private String purchasingAsset;
    private String bioMedicalAsset;
    private InforEamCode udmNs;
    private String oemSite;
    private String vendor;
    private InforEamCode coverageType;


    private String updatedCount;

    private String oldOrganization;
}
