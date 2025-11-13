package com.assettec.api.internal.core.entities.asset.common.objects;

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
public class EnergyPerformance {
    private InforEamCount targetPowerFactor;
    private InforEamCount targetPeakDemand;
    private InforEamCount billEveryPeriod;
    private InforEamCount phaseInBalanceEfficiencyLost1;
    private InforEamCount phaseInBalanceEfficiencyLost2;
    private InforEamCount phaseInBalanceEfficiencyLost3;
    private InforEamCount phaseInBalanceEfficiencyLost4;
    private InforEamCount phaseInBalanceEfficiencyLost5;
    private InforEamCount electricSubMeterInterval;
    private InforEamCount electricUsageThreshold;
    private InforEamCode billEveryUom;
    private InforEamCode performanceManager;
    private InforEamDate billingPeriodStartDate;
}
