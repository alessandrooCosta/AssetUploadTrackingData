package com.assettec.api.internal.core.entities.basic.objects.Id;

import com.assettec.api.internal.core.entities.basic.objects.InforEamCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IdPk {
    private String pk;
    private String code;
    private String description;
    private InforEamCode organization;
}
