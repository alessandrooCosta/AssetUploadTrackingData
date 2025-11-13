package com.assettec.api.internal.users;

import com.assettec.api.internal.utilities.common.XMLParser;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ApiUserService {

    private final Logger logger = LoggerFactory.getLogger(ApiUserService.class);
    public ApiUser findByUserName(String userName) {
        return ApiUserRepository.findByUserName(userName);
    }
    public ApiUser findByToken(String token) { return ApiUserRepository.findByToken(token); }
    public void saveApiUser(ApiUser apiUser) {
        ApiUserRepository.saveApiUser(apiUser);
    }
    public void deleteApiUser(ApiUser apiUser) {
        ApiUserRepository.deleteApiUser(apiUser);
    }
    public ApiUser findByDeleteToken(String token) {
        return ApiUserRepository.findByDeleteToken(token);
    }
    @SneakyThrows
    public ApiUser findByTenantAndEmail(String tenant, String email) {
        List<ApiUser> apiUsers = ApiUserRepository.findAll();
        for (ApiUser apiUser : apiUsers) {
            if (Objects.equals(apiUser.getEmail(), email) && Objects.equals(apiUser.getTenant(), tenant)) return apiUser;
        }
        return null;
    }
    @SneakyThrows
    public ApiUser createUser(AppUser appUser) {
        if (appUser.getUsername() == null || appUser.getUsername().isEmpty()) throw new IllegalAccessException("Username must not be blank.");
        if (appUser.getPassword() == null || appUser.getPassword().isEmpty()) throw new IllegalAccessException("Password must not be blank.");
        if (appUser.getTenant() == null || appUser.getTenant().isEmpty()) throw new IllegalAccessException("Tenant must not be blank.");
        if (appUser.getOrganization() == null || appUser.getOrganization().isEmpty()) throw new IllegalAccessException("Organization must not be blank.");

        try {
            ApiUser existingUser = findByUserName(appUser.getUsername());
            appUser.setToken(existingUser.getToken());

            if (existingUser.toAppUser().equals(appUser)) {
                logger.info("[ApiUserService][ User Already Registered ]");
                return existingUser;

            }
        } catch (Exception e) {
            logger.info("[ApiUserService][ " + e.getMessage() + " ][ Creating User ]");
        }

        ApiUser apiUser = new ApiUser();
        apiUser.setServer(appUser.getServer());
        apiUser.setPort(appUser.getPort());
        apiUser.setUsername(appUser.getUsername());
        apiUser.setPassword(appUser.getPassword());
        apiUser.setOrganization(appUser.getOrganization());
        apiUser.setTenant(appUser.getTenant());
        apiUser.setToken(UUID.randomUUID().toString());
        apiUser.setEnabled(false);
        apiUser.setTimeCreated(LocalDateTime.now());

        saveApiUser(apiUser);
        logger.info("[ApiUserService][ Created User ]");
        return apiUser;
    }

    @SneakyThrows
    public ApiUser updateUser(String token, AppUser appUser) {
        if (appUser.getUsername() == null || appUser.getUsername().isEmpty()) throw new IllegalAccessException("User name must not be blank.");
        if (appUser.getPassword() == null || appUser.getPassword().isEmpty()) throw new IllegalAccessException("Password must not be blank.");
        if (appUser.getTenant() == null || appUser.getTenant().isEmpty()) throw new IllegalAccessException("Tenant must not be blank.");
        if (appUser.getOrganization() == null || appUser.getOrganization().isEmpty()) throw new IllegalAccessException("Organization must not be blank.");

        logger.info("[ApiUserService][ Updating User ]");

        ApiUser apiUser = findByToken(token);
        apiUser.setServer(appUser.getServer());
        apiUser.setPort(appUser.getPort());
        apiUser.setUsername(appUser.getUsername() != null ? appUser.getUsername() : apiUser.getUsername());
        apiUser.setPassword(appUser.getPassword() != null ? appUser.getPassword() : apiUser.getPassword());
        apiUser.setOrganization(appUser.getOrganization() != null ? appUser.getOrganization() : apiUser.getOrganization());
        apiUser.setTenant(appUser.getTenant() != null ? appUser.getTenant() : apiUser.getTenant());

        saveApiUser(apiUser);
        logger.info("[ApiUserService][ User Updated ]");
        return apiUser;
    }

}
