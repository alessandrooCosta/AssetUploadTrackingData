package com.assettec.api.internal.core.installationcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstallationCode {
    private String code;
    private String description;
    private String value;
    private String fixed;
}
