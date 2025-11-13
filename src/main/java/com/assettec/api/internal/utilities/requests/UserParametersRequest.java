package com.assettec.api.internal.utilities.requests;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class UserParametersRequest {
    private String userName;
    private String tenant;
    private String passWord;
    private String userFunctionName;
    private String gridName;
    private String organization;
    private String dataSpyId;
}
