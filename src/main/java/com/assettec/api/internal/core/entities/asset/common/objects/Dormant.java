package com.assettec.api.internal.core.entities.asset.common.objects;

import com.assettec.api.internal.core.entities.basic.objects.InforEamDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dormant {
    private InforEamDate start;
    private InforEamDate end;
    private String reUse;
}
