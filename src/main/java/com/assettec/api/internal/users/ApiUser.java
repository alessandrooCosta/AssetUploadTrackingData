package com.assettec.api.internal.users;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ApiUser implements Serializable {
    private static final long serialVersionUID = -3389113295170712620L;
    private Long id;
    private String email;
    private String server;
    private String port;
    private String username;
    private String password;
    private String organization;
    private String token;
    private String deleteToken;
    private String tenant;
    private boolean isEnabled;
    private LocalDateTime timeCreated;
    public ApiUser(String userName, String password, String organization, String tenant) {
        this.username = userName;
        this.password = password;
        this.organization = organization;
        this.tenant = tenant;
    }
    public AppUser toAppUser() {
        return new AppUser(this.server, this.port, this.username,this.password,this.organization,this.tenant,this.token);
    }
}
