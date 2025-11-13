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
public class Id {
    private String code;
    private InforEamCode organization;
    private String description;
    private String EquipmentDescription;
    private String EquipmentCode;

    public String buildOrganizationRequestString(String upper, String lower) {
        if (organization == null) return "";
        String organizationCode = organization.getCode() == null || organization.getCode().isEmpty() ? "" : "<ORGANIZATIONCODE>" + organization.getCode() + "</ORGANIZATIONCODE>";
        String organizationDescription = organization.getDescription() == null || organization.getDescription().isEmpty() ? "" : "<DESCRIPTION>" + organization.getDescription() + "</DESCRIPTION>";

        return upper + organizationCode + organizationDescription + lower;
    }

    public String buildRequest(String upper, String lower, String organizationUpper, String organizationLower, String codeLabel, String descriptionLabel, String organizationCodeLabel, String organizationDescriptionLabel) {

        String EquipmentCode = getEquipmentCode() == null ? "" : "<" + codeLabel + ">" + getCode() + "</" + codeLabel + ">";
        String EquipmentDescription = getDescription() == null ? "" : "<" + descriptionLabel + ">" + getDescription() + "</" + descriptionLabel + ">";
        String code = getCode() == null ? "" : "<" + codeLabel + ">" + getCode() + "</" + codeLabel + ">";
        String description = getDescription() == null ? "" : "<" + descriptionLabel + ">" + getDescription() + "</" + descriptionLabel + ">";
        String organization = getOrganization() == null ? "" : getOrganization().buildRequest(organizationUpper,organizationLower,organizationCodeLabel,organizationDescriptionLabel);

        return upper + code + organization + description + EquipmentCode + EquipmentDescription + lower;
    }
}
