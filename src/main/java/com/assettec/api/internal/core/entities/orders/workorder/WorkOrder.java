package com.assettec.api.internal.core.entities.orders.workorder;


import com.assettec.api.internal.core.entities.basic.objects.Id.Id;
import com.assettec.api.internal.core.entities.basic.objects.Id.IdEntity;
import com.assettec.api.internal.core.entities.basic.objects.Id.IdNumber;
import com.assettec.api.internal.core.entities.basic.objects.Id.IdRevision;
import com.assettec.api.internal.core.entities.basic.objects.InforEamCode;
import com.assettec.api.internal.core.entities.basic.objects.InforEamCount;
import com.assettec.api.internal.core.entities.basic.objects.InforEamCurrency;
import com.assettec.api.internal.core.entities.basic.objects.InforEamDate;
import com.assettec.api.internal.core.entities.signature.ESignatureDetail;
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
public class WorkOrder {
    private Id id;
    private InforEamCode status;
    private Id equipmentId;
    private InforEamCode createdBy;
    private String enteredBy;
    private InforEamCode type;
    private InforEamCode department;
    private InforEamCode equipment;
    private InforEamCode description;
    private Id departmentId;
    private Id classId;
    private InforEamCode problem;
    private Id standardWorkOrder;
    private InforEamCode priority;
    private Id locationId;
    private Id costCodeId;
    private Id projectId;
    private String projectBudget;

    private InforEamCurrency targetValue;
    private InforEamCode criticality;
    private Id serviceRequest;
    private String safety;
    private String warranty;
    private String equipmentAlias;
    private String serialNumber;
    private String model;
    private InforEamCode requestedBy;
    private InforEamDate reported;
    private String scheduledGroup;
    private String supervisorDescription;
    private InforEamCode assignedTo;
    private InforEamDate targetDate;
    private InforEamDate scheduledEnd;
    private Id shift;
    private Id parentWorkOrder;
    private String cnNumber;
    private String changeNoticeDescription;
    private String meterUnit;

    private InforEamCount lastMeterReading;
    private Id triggerEvent;
    private InforEamDate requestedStart;
    private InforEamDate requestedEnd;
    private String msProject;
    private InforEamCode schedulingSessionType;
    private String fixed;
    private String depend;
    private InforEamDate createdDate;
    private String objectType;

    private InforEamCode failure;
    private InforEamCode cause;
    private InforEamCode action;
    private InforEamDate startDate;
    private InforEamDate completedDate;
    private InforEamCount downTimeHours;
    private InforEamCurrency DownTimeCost;
    private String reOpened;
    private UserDefinedArea userDefinedArea;
    private String frequency;
    private String evtissType;
    private InforEamCount meterDue;
    private InforEamCount meterDue2;
    private String workPackage;
    private InforEamCode periodUom;
    private InforEamCode meterUom2;

    private InforEamCode routeStatus;
    private String routeParent;

    private String billable;
    private String printed;
    private String print;
    private String sourceSystem;
    private String sourceCode;
    private String routedFrom;
    private String acdCode;
//    private Comment closingComment;
//    private Activity activities;
    private String callerName;
    private Id customerId;
    private String level1;
    private String rejectionReason;
    private String inspectionDirectionCode;
    private String flowCode;
    private String multiEquip;
    private Id customerContractId;
    private InforEamDate dueDate;
    private String cctrspcValidation;


    private UserDefinedFields userDefinedFields;
    private InforEamCode Alert;

    private String survey;
    private InforEamCode campaignStatus;
    private IdRevision maintenancePatternId;
    private String sequence;
    private ESignatureDetail eSignatureDetail;
    private InforEamCode safetyReviewedBy;
    private InforEamCode permitReviewedBy;

    private String jobSequence;
    private String activityNote;
    private InforEamCount calculatedPriority;
    private String preserveCalculatedPriority;
    private String currencyCode;
    private InforEamCurrency estimatedLaborCost;
    private InforEamCurrency estimatedMaterialCost;
    private InforEamCurrency estimatedMiscellaneousCost;
    private InforEamCurrency estimatedTotalCost;

    private IdNumber workSpaceId;
    private Id positionId;
    private String manufacturerCode;
    private String oemSite;
    private String vendor;
    private InforEamCode coverageType;

    private InforEamCount latitude;
    private InforEamCount longitude;
    private WorkOrderEquipment multipleWorkOrderEquipment;
    private InforEamCode workOrderTypeCategory;
    private String minor;
    private IdEntity failureMode;
    private InforEamCode symptom;
    private IdEntity tacticalCause;
    private IdEntity humanFactor;
    private IdEntity workmanShip;
    private IdEntity humanOversight;
    private IdEntity methodOfDetection;

    private WorkOrderAdditionalInfo workOrderAdditionalInfo;
    private int updatedCount;

}
