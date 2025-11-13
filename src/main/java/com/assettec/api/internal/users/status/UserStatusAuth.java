package com.assettec.api.internal.users.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserStatusAuth {
    private String userGroupCode;
    private String userGroupDescription;
    private String userSpecificAuthorization;
    private String entityDescription;
    private String systemEntity;
    private String entityCode;
    private String userCode;
    private String fromStatus;
    private String fromStatusDescription;
    private String toStatus;
    private String toStatusDescription;
}
