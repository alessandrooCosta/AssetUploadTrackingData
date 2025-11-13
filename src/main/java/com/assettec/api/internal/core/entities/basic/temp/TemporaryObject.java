package com.assettec.api.internal.core.entities.basic.temp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TemporaryObject {
    private String code;
    private String organization;
    private String description;
}
