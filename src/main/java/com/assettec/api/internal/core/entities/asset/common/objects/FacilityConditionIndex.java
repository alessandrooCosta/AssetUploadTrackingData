package com.assettec.api.internal.core.entities.asset.common.objects;

import com.assettec.api.internal.core.entities.basic.objects.Id.Id;
import com.assettec.api.internal.core.entities.basic.objects.InforEamCode;
import com.assettec.api.internal.core.entities.basic.objects.InforEamCount;
import com.assettec.api.internal.core.entities.basic.objects.InforEamCurrency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacilityConditionIndex {
    private InforEamCurrency costOfNeededRepairs;
    private InforEamCurrency replacementValue;
    private InforEamCurrency facilityCondition;
    private String utilityBillLevel;
    private String gasTracked;
    private InforEamCount floorArea;
    private InforEamCode floorAreaUom;
    private InforEamCurrency estimatedRevenue;
    private InforEamCode region;
    private Id regionId;
    private InforEamCode primaryUse;
    private InforEamCount yearBuilt;
    private InforEamCount serviceLife;
    private String energyStarEligible;
    private String isFacility;
    private InforEamCount country;
}
