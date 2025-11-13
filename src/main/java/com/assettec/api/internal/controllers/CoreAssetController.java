package com.assettec.api.internal.controllers;

import com.assettec.api.internal.core.entities.asset.AssetService;
import com.assettec.api.internal.core.entities.asset.equipment.AssetEquipment;
import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.users.ApiUserService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "core/asset")
@AllArgsConstructor
public class CoreAssetController {

    private ApiUserService apiUserService;
    private AssetService assetService;

    @GetMapping @SneakyThrows @Async
    public CompletableFuture<List<AssetEquipment>> getAssetList(@RequestParam(name = "token") String token) {
        ApiUser apiUser = apiUserService.findByToken(token);
        return CompletableFuture.completedFuture(assetService.getAssetList(apiUser));
    }

    @GetMapping(path = "position") @SneakyThrows @Async
    public CompletableFuture<String> getPositionList(@RequestParam(name = "token") String token) {
        ApiUser apiUser = apiUserService.findByToken(token);
        return CompletableFuture.completedFuture(assetService.getPositionList(apiUser));
    }

    @GetMapping(path = "system") @SneakyThrows @Async
    public CompletableFuture<String> getSystemList(@RequestParam(name = "token") String token) {
        ApiUser apiUser = apiUserService.findByToken(token);
        return CompletableFuture.completedFuture(assetService.getSystemList(apiUser));
    }

}
