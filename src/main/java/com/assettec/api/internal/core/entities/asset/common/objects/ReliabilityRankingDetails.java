package com.assettec.api.internal.core.entities.asset.common.objects;

import com.assettec.api.internal.core.entities.basic.objects.Id.IdRevision;
import com.assettec.api.internal.core.entities.basic.objects.InforEamCount;
import com.assettec.api.internal.core.entities.basic.objects.InforEamDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReliabilityRankingDetails {
    private String rankingLocked;
    private String rankingIndexCode;
    private IdRevision rankingId;
    private InforEamCount rankingScore;
    private String outOfSync;
    private InforEamDate setupLastUpdate;
    private InforEamDate surveyLastUpdate;
    private InforEamDate valuesLastUpdate;
}
