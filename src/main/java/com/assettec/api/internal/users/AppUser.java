package com.assettec.api.internal.users;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AppUser {
    @NotBlank(message = "O campo 'server' é obrigatório!")
    private String server;
    private String port;
    @NotBlank(message = "O campo 'username' é obrigatório!")
    private String username;
    @NotBlank(message = "O campo 'password' é obrigatório!")
    private String password;
    @NotBlank(message = "O campo 'organization' é obrigatório!")
    private String organization;
    @NotBlank(message = "O campo 'tenant' é obrigatório!")
    private String tenant;
    private String token;

    public String getPort() {
        if (port == null || port.equals("string")) {
            return ""; // Retorna uma string vazia quando o valor do port for null ou "string"
        }
        return port;
    }
}


