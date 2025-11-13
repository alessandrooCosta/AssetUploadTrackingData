package com.assettec.api.internal.core.entities.asset.common.objects;

import com.assettec.api.internal.core.entities.basic.objects.Id.IdEntity;
import com.assettec.api.internal.core.entities.basic.objects.InforEamCode;
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
public class PerformanceDetails {
    private EquipmentConfigurationId performanceFormula;
    private IdEntity capacityCode;
    private InforEamCode mubfUom;
    private InforEamDate lastUpdatedDate;
    private InforEamCount performance;
    private InforEamCount conditionRatingWeight;
    private InforEamCount availableCapacity;
    private InforEamCount desiredCapacity;
    private InforEamCount capacityRatingWeight;
    private InforEamCount noOffFailures;
    private InforEamCount mtbfDays;
    private InforEamCount mtbfRatingWeight;
    private InforEamCount mubf;
    private InforEamCount mubfRating;
    private InforEamCount mttrHrs;
    private InforEamCount mttrRating;

    private InforEamCount variableResult1;
    private InforEamCount variableResult2;
    private InforEamCount variableResult3;
    private InforEamCount variableResult4;
    private InforEamCount variableResult5;
    private InforEamCount variableResult6;

    private InforEamCount variableRating1;
    private InforEamCount variableRating2;
    private InforEamCount variableRating3;
    private InforEamCount variableRating4;
    private InforEamCount variableRating5;
    private InforEamCount variableRating6;
}
