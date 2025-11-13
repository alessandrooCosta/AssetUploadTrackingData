package com.assettec.api.internal.core.entities.basic.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeRevision {
    private String code;
    private String revision;
    private String description;

    public String buildRequest(String upper, String lower, String codeLabel, String revisionLabel, String descriptionLabel) {

        String code = "<" + codeLabel + ">" + getCode() + "</" + codeLabel + ">";
        String revision = "<" + revisionLabel + ">" + getRevision() + "</" + revisionLabel + ">";
        String description = "<" + descriptionLabel + ">" + getDescription() + "</" + descriptionLabel + ">";

        return upper + code + revision + description + lower;
    }
}
