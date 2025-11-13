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
public class ParentHierarchy {
    private Id id;
    private InforEamCode type;
    private Id location;
    private String positionParent;
    private DependentAsset dependentAsset;
    private DependentAsset nonDependentPosition;
    private DependentAsset nonDependentPrimarySystem;
    private DependentAsset nonDependentSystem;
}
