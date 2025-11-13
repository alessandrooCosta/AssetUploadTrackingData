package com.assettec.api.internal.core.entities.orders.workorder;

import com.assettec.api.internal.core.entities.basic.objects.InforEamCode;
import com.assettec.api.internal.core.entities.basic.objects.InforEamDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkOrderAdditionalInfo {
    private WorkOrderEquipmentInfo equipmentInfo;
    private String perType;
    private String workDay;

    private String pmrvctrl;
    private String currency;
    private String reOpenPM;

    private InforEamDate completedDate;
    private String eventType;
    private InforEamCode systemCompleteStatus;

    private InforEamDate currentDateTime;
    private String group;
    private InforEamCode projectStatus;

    private InforEamDate dueDate;
    private String singleChecklistActivity;
}
