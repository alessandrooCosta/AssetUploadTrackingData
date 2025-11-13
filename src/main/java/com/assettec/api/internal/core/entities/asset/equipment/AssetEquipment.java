package com.assettec.api.internal.core.entities.asset.equipment;


import com.assettec.api.internal.core.entities.asset.common.objects.EnergyPerformance;
import com.assettec.api.internal.core.entities.asset.common.objects.EquipmentConfigurationId;
import com.assettec.api.internal.core.entities.asset.common.objects.ReliabilityRankingDetails;
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

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssetEquipment {
    private String code;
    private String organization;
    private String oldOrganization;
    private String description;
    private String type;
    private String status;
    private String department;

    // todo new stuff
    private Id equipmentClass;
    private InforEamCode category;

    private Id departmentId;
    private InforEamCode operationalStatus;
    private InforEamDate commissionDateNew;
    private InforEamDate transferDateNew;
    private InforEamDate withdrawalDateNew;
    private InforEamCurrency assetValue;
    private InforEamCode assignedToNew;

    private Id loanedToDepartment;
    private Id pmWoDepartment;
    private Id profile;

    private Id costId;
    private String assignedTo;
    private String meterUnit;
    private InforEamCode criticality;
    private InforEamDate soldDate;

    private InforEamDate dormantStart;
    private InforEamDate dormantEnd;

    private InforEamDate inventoryVerificationDate;
    private Id partId;
    private Id storeId;
    private String bin;
    private String lot;

    private String manufacturerCode;
    private String serialnumber;
    private String model;
    private String modelRevision;

    private InforEamCount xCoordinate;
    private InforEamCount yCoordinate;
    private InforEamCount zCoordinate;

    private String isVehicle;
    private Id fleetCustomer;
    private Id fleetBilling;
    private Id fleetMarkUp;
    private InforEamCode vehicleStatus;
    private InforEamCode vehicleType;
    private InforEamCode issueTo;
    private String isRental;
    private Id rentalTemplate;
    private String isContract;
    private Id contractTemplate;
    private Id customer;
    private InforEamCode availabilityStatus;

    private InforEamCode cnId;
    private InforEamCode equipmentState;

    private InforEamCode systemLevelCode;
    private String partLocationCode;

    private Id purchaseOrder;
    private String purchaseOrderLineNum;

    private String variable1;
    private String variable2;
    private String variable3;
    private String variable4;
    private String variable5;
    private String variable6;

    private String preventWoCompletion;
    private String gisObj;
    private String gisProfile;
    private String cgMp;
    private String linkGisWo;
    private Id gisMap;
    private String gislayer;
    private InforEamCount xLocation;
    private InforEamCount yLocation;


    private String resourceEnabled;
    private ReliabilityRankingDetails reliabilityRankingDetails;
    private String equipmentAlias;
    private EnergyPerformance energyPerformance;
    private InforEamDate safetyDateReviewRequired;
    private InforEamCode safetyReviewedBy;
    private InforEamDate permitDateReviewRequired;
    private InforEamCode permitReviewedBy;
    private InforEamDate lotoDateReviewRequired;
    private InforEamCode lotoReviewedBy;
    private EquipmentConfigurationId equipmentConfigurationId;
    private IdEntity rcmLevel;
    private InforEamCode riskMatrixSetup;
    private InforEamCount riskPriorityNumber;
    private InforEamDate originalReceiptDate;
    private InforEamDate latestReceiptDate;
    private InforEamDate originalInstallDateNew;
    private InforEamDate latestInstallDateNew;

    private String docuMotoBook;
    private InforEamCode reservationCalendarOwner;
    private Id reservationCalendarOwnerList;
    private IdNumber workSpace;
    private IdPk setId;
    private String setPosition;
    private IdPk consistId;
    private String consistPosition;
    private String url;
    private IdEntity conditionIndex;
    private InforEamCount conditionScore;
    private String processError;
    private InforEamCode linearUom;
    private String equipmentLengthOverride;
    private String tempMonitored;
    private Id driver;
    private String phoneNumber;
    private String nonSmoking;
    private String hardwareVer;
    private String softwareVer;
    private String purchasingAsset;
    private String bioMedicalAsset;
    private InforEamCode umdns;
    private String oemSite;
    private String vendor;
    private InforEamCode coverageType;
    private String lockout;
    private String personalProtectiveEquipment;
    private String confinedSpace;
    private String statementOfCondition;
    private String buildMaintenanceProgram;
    private String hipaaConfidentiality;
    private InforEamCode ownerShipType;
    private String purchaseOrderCode;
    private InforEamDate purchaseDateNew;
    private InforEamCurrency purchaseCost;
    private InforEamCode purchaseCurrency;
    private InforEamCode disposalType;
    private String checkListFilter;
    private InforEamCount toleranceSize;
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
    private InforEamCount failureProbPercentage;
    private String blackSwan;
    private InforEamCurrency blackSwanCost;

    private String currencyCode;
    // todo new stuff

    private String value;
    private String valueDecimals;
    private String cost;

    private String inProduction;
    private String safety;
    private String outOfService;
    private String commissionDateTimeZone;
    private String dormantReuse;
    private String utilityBillLevel;
    private String gasTracked;
    private String isFacility;
    private String reliabilityRankingLocked;
    private String accessible;
    private String personalProtectiveEquip;
    private String statementOfCond;
    private String buildMainTProgram;
    private LocalDateTime purchaseDate;
    private String purchaseDateTimeZone;
    private String purchaseCostValue;
    private String purchaseCostDecimals;

    private LocalDateTime originalInstallDate;
    private String originalInstallDateTimeZone;
    private LocalDateTime latestInstallDate;
    private String latestInstallDateTimeZone;

    private LocalDateTime transferDate;
    private String transferDateTimeZone;

    private LocalDateTime withdrawalDate;
    private String withdrawalDateTimeZone;

    private LocalDateTime commissionDate;
    private int updatedCount;


    private UserDefinedArea userDefinedArea;
    private UserDefinedFields userDefinedFields;

}
