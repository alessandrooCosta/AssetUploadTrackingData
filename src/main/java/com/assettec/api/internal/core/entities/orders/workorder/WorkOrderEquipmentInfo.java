package com.assettec.api.internal.core.entities.orders.workorder;

import com.assettec.api.internal.core.entities.basic.objects.Id.Id;
import com.assettec.api.internal.core.entities.basic.objects.Id.IdEntity;
import com.assettec.api.internal.core.entities.basic.objects.Id.IdRevision;
import com.assettec.api.internal.core.entities.basic.objects.InforEamCode;
import com.assettec.api.internal.core.entities.basic.objects.InforEamCount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkOrderEquipmentInfo {
    private Id equipmentId;
    private Id classId;
    private InforEamCode category;
    private String preventWoCompletion;
    private InforEamCode objType;
    private String stateCode;
    private String linearRefUom;
    private InforEamCount equipmentLength;
    private String gisObjId;
    private String gisLayer;
    private String sdmFlag;
    private String reliabilityRankingIndexCode;
    private IdRevision reliabilityRankingId;
    private InforEamCount reliabilityRankingScore;
    private InforEamCount startingAt;
    private IdEntity linearDirectionId;
    private InforEamCode assignedTo;
}
