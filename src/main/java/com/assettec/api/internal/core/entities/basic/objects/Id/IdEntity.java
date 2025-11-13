package com.assettec.api.internal.core.entities.basic.objects.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IdEntity {
    private String entity;
    private String code;
    private String description;

    public String buildRequestString() {
        if ((entity == null || entity.isEmpty()) && (code == null || code.isEmpty()) && (description == null || description.isEmpty())) return "";

        String entityString = entity == null || entity.isEmpty() ? "" : "<ENTITY>" + entity + "</ENTITY>";
        String codeString = code == null || code.isEmpty() ? "" : "<USERDEFINEDCODE>" + code + "</USERDEFINEDCODE>";
        String descriptionString = description == null || description.isEmpty() ? "" : "<DESCRIPTION>" + description + "</DESCRIPTION>";

        return entityString + codeString + descriptionString;
    }
}
