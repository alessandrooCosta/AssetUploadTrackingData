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
public class IdNumber {
    private String code;
    private String number;
    private InforEamCode organization;
    private String description;
}
