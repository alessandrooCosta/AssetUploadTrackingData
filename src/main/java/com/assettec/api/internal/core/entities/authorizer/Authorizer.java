package com.assettec.api.internal.core.entities.authorizer;

import com.assettec.api.internal.core.user.info.area.UserDefinedArea;
import com.assettec.api.internal.core.user.info.fields.UserDefinedFields;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authorizer {
    private Long id;
    private String company;

    private String code;
    private String organization;
    private String description;

    private UserDefinedFields userDefinedFields;
    private UserDefinedArea userDefinedArea;

    private int updatedCount;
}
