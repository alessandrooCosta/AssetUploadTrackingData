package com.assettec.api.internal.core.entities.asset.common.objects;

import com.assettec.api.internal.core.entities.basic.objects.Id.Id;
import com.assettec.api.internal.core.entities.basic.objects.InforEamCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DependentAsset {
    private Id id;
    private InforEamCode type;
    private String costRollup;
    private Id department;
    private Id loanedToDepartment;
    private String updatedCount;
}
