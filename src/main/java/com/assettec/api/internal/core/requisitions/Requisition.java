package com.assettec.api.internal.core.requisitions;

import com.assettec.api.internal.core.entities.basic.objects.InforEamCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Requisition {
    private String code;
    private InforEamCode organization;
    private String description;
}
