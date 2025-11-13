package com.assettec.api.internal.core.entities.asset;

import com.assettec.api.internal.core.grid.GridService;
import com.assettec.api.internal.core.grid.Row;
import com.assettec.api.internal.core.entities.asset.equipment.AssetEquipment;
import com.assettec.api.internal.core.entities.asset.equipment.utilities.AssetUpdater;
import com.assettec.api.internal.core.entities.asset.position.AssetPosition;
import com.assettec.api.internal.core.entities.asset.system.AssetSystem;
import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.common.XMLParser;
import com.assettec.api.internal.utilities.handlers.RequestCreator;
import com.assettec.api.internal.utilities.handlers.RequestSender;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AssetService {

    private RequestCreator requestBuilder;
    private RequestSender requestSender;
    private AssetUpdater assetUpdater;
    private GridService gridService;

    public AssetEquipment getAsset(ApiUser apiUser, String equipmentCode, String equipmentOrganization) {
        return assetUpdater.getAsset(apiUser, equipmentCode, equipmentOrganization);
    }

    public AssetPosition getPosition(ApiUser apiUser, String positionCode, String positionOrganization) {
        return assetUpdater.getPosition(apiUser, positionCode, positionOrganization);
    }

    public AssetSystem getSystem(ApiUser apiUser, String systemCode, String systemOrganization) {
        return assetUpdater.getSystem(apiUser, systemCode, systemOrganization);
    }

    @SneakyThrows
    public List<AssetEquipment> getAssetList(ApiUser apiUser) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getGridRequestBuilder().buildGridRequest(apiUser, "OSOBJA", "OSOBJA");
        response = requestSender.sendPostRequest(postRequest, host);
        List<Row> rows = gridService.getRows(response);

        List<AssetEquipment> assets = new ArrayList<>();
        for (Row row : rows) {
            String equipmentCode = gridService.getDataByName("equipmentno", row);
            String equipmentOrganization = gridService.getDataByName("organization", row);

            assets.add(getAsset(apiUser, equipmentCode, equipmentOrganization));
        }

        return assets;
    }

    @SneakyThrows
    public String getPositionList(ApiUser apiUser) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getGridRequestBuilder().buildGridRequest(apiUser, "OSOBJP", "OSOBJP");
        response = requestSender.sendPostRequest(postRequest, host);
        List<Row> rows = gridService.getRows(response);

        List<AssetPosition> assets = new ArrayList<>();
        for (Row row : rows) {
            String positionCode = gridService.getDataByName("equipmentno", row);
            String organization = gridService.getDataByName("organization", row);
            AssetPosition position = getPosition(apiUser, positionCode, organization);
            assets.add(position);
            return updatePosition(apiUser, position);
        }

        return "assets";
    }

    @SneakyThrows
    public String getSystemList(ApiUser apiUser) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getGridRequestBuilder().buildGridRequest(apiUser, "OSOBJS", "OSOBJS");
        response = requestSender.sendPostRequest(postRequest, host);
        List<Row> rows = gridService.getRows(response);

        List<AssetSystem> assets = new ArrayList<>();
        for (Row row : rows) {
//            gridService.printNames(row);
            String systemCode = gridService.getDataByName("equipmentno", row);
            String organization = gridService.getDataByName("organization", row);
            AssetSystem system = getSystem(apiUser, systemCode, organization);
            assets.add(system);
            return updateSystem(apiUser, system);
        }

        return "assets";
    }

    @SneakyThrows
    private String updatePosition(ApiUser apiUser, AssetPosition position) {
        String postRequest, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getAssetRequestBuilder().putPosition(apiUser, position);
        requestSender.sendPostRequest(postRequest, host);
        return postRequest;
    }

    @SneakyThrows
    private String updateSystem(ApiUser apiUser, AssetSystem system) {
        String postRequest, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getAssetRequestBuilder().putSystem(apiUser, system);
        requestSender.sendPostRequest(postRequest, host);
        return postRequest;
    }
}
