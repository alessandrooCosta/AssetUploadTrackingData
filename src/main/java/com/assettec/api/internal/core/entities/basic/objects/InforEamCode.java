package com.assettec.api.internal.core.entities.basic.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InforEamCode {
    private String EquipmentCode;
    private String EquipmentDescription;
    private String code;
    private String description;

    public String buildRequest(String upper, String lower, String codeLabel, String descriptionLabel) {

        String EquipmentCode = getEquipmentCode() == null ? "" : "<" + codeLabel + ">" + getCode() + "</" + codeLabel + ">";
        String EquipmentDescription = getDescription() == null ? "" : "<" + descriptionLabel + ">" + getDescription() + "</" + descriptionLabel + ">";
        String code = getCode() == null || getCode().isEmpty() ? "" : "<" + codeLabel + ">" + getCode() + "</" + codeLabel + ">";
        String description = getDescription() == null || getDescription().isEmpty() ? "" : "<" + descriptionLabel + ">" + getDescription() + "</" + descriptionLabel + ">";

        return upper + code + description + EquipmentCode + EquipmentDescription + lower;
    }
}
