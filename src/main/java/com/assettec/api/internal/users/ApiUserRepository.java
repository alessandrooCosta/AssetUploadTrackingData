package com.assettec.api.internal.users;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ApiUserRepository {

    @SneakyThrows
    public static void saveApiUser(ApiUser newApiUser) {
        checkIfFileExists();

        Path userListPath = System.getProperty("os.name").contains("Windows") ? Paths.get(System.getProperty("user.dir"), "\\config\\userList") : Paths.get(System.getProperty("user.dir"), "/config/userList");
        File userListFile = new File(String.valueOf(userListPath));

        List<ApiUser> apiUserList = getApiUsers();
        boolean foundUser = false;

        for (int i = 0; i < apiUserList.size(); i++) {
            ApiUser storedApiUser = apiUserList.get(i);

            if (storedApiUser.getToken().equals(newApiUser.getToken())) {
                newApiUser.setId((long) i);
                apiUserList.set(i,newApiUser);
                foundUser = true;
            }
        }

        if (!foundUser) apiUserList.add(newApiUser);

        FileOutputStream userList = new FileOutputStream(String.valueOf(userListFile));
        ObjectOutputStream userListOutput = new ObjectOutputStream(userList);

        userListOutput.writeObject(apiUserList);
        userListOutput.flush();
        userListOutput.close();
    }

    @SneakyThrows
    public static void deleteApiUser(ApiUser apiUser) {
        Path userListPath = System.getProperty("os.name").contains("Windows") ? Paths.get(System.getProperty("user.dir"), "\\config\\userList") : Paths.get(System.getProperty("user.dir"), "/config/userList");
        File userListFile = new File(String.valueOf(userListPath));

        if (!fileExists()) throw new IllegalStateException("There is no ApiUser saved.");
        else {
            List<ApiUser> apiUserList = getApiUsers();
            boolean userFound = false;

            for (int i = 0; i < apiUserList.size(); i++) {
                ApiUser storedApiUser = apiUserList.get(i);
                if (storedApiUser.getToken().equals(apiUser.getToken())) {
                    userFound = true;
                    //noinspection SuspiciousListRemoveInLoop
                    apiUserList.remove(i);
                }
            }

            if (!userFound) throw new IllegalStateException("Unable to find user.");

            FileOutputStream userList = new FileOutputStream(String.valueOf(userListFile));
            ObjectOutputStream userListOutput = new ObjectOutputStream(userList);

            userListOutput.writeObject(apiUserList);
            userListOutput.flush();
            userListOutput.close();
        }
    }

    @SneakyThrows
    public static List<ApiUser> getApiUsers() {
        Path userListPath = System.getProperty("os.name").contains("Windows") ? Paths.get(System.getProperty("user.dir"), "\\config\\userList") : Paths.get(System.getProperty("user.dir"), "/config/userList");
        FileInputStream userListFile = new FileInputStream(String.valueOf(userListPath));
        ObjectInputStream userListInput = new ObjectInputStream(userListFile);

        List<ApiUser> apiUserList = (List<ApiUser>) userListInput.readObject();

        userListInput.close();
        userListFile.close();

        return apiUserList;
    }

    public static boolean fileExists() {
        if (System.getProperty("os.name").contains("Windows")) {
            return new File(System.getProperty("user.dir"), "\\config\\userList").exists();
        } else {
            return new File(System.getProperty("user.dir"), "/config/userList").exists();
        }
    }

    @SneakyThrows
    public static ApiUser findByToken(String token) {
        List<ApiUser> apiUserList = getApiUsers();

        for (ApiUser apiUser : apiUserList) {
            if (apiUser.getToken().equals(token)) return apiUser;
        }

        throw new IllegalStateException("Could not find user");
    }

    @SneakyThrows
    public static void checkIfFileExists() {
        if (!fileExists()) {
            Path userListPath;
            userListPath = System.getProperty("os.name").contains("Windows") ? Paths.get(System.getProperty("user.dir"), "\\config\\userList") : Paths.get(System.getProperty("user.dir"), "/config/userList");
            File userListFile = new File(String.valueOf(userListPath));

            //noinspection ResultOfMethodCallIgnored
            userListFile.getParentFile().mkdirs();
            List<ApiUser> apiUserList = new ArrayList<>();

            FileOutputStream userList = new FileOutputStream(String.valueOf(userListFile));
            ObjectOutputStream userListOutput = new ObjectOutputStream(userList);

            userListOutput.writeObject(apiUserList);
            userListOutput.flush();
            userListOutput.close();
        }
    }

    @SneakyThrows
    public static ApiUser findByUserName(String userName) {
        List<ApiUser> apiUserList = getApiUsers();

        for (ApiUser apiUser : apiUserList) {
            if (apiUser.getUsername().equals(userName)) return apiUser;
        }

        throw new IllegalStateException("Could not find user");
    }

    @SneakyThrows
    public static ApiUser findByDeleteToken(String deleteToken) {
        List<ApiUser> apiUserList = getApiUsers();

        for (ApiUser apiUser : apiUserList) {
            if (Objects.equals(apiUser.getDeleteToken(), deleteToken)) return apiUser;
        }

        throw new IllegalStateException("Could not find user");
    }

    @SneakyThrows
    public static List<ApiUser> findAll() {
        return getApiUsers();
    }

    public static void delete(ApiUser apiUser) {
        deleteApiUser(apiUser);
    }
}