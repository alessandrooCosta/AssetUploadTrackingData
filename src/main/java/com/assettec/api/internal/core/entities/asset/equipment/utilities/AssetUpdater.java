package com.assettec.api.internal.core.entities.asset.equipment.utilities;

import com.assettec.api.internal.core.entities.asset.equipment.AssetEquipment;
import com.assettec.api.internal.core.entities.asset.position.AssetPosition;
import com.assettec.api.internal.core.entities.asset.position.AssetPositionUpdater;
import com.assettec.api.internal.core.entities.asset.system.AssetSystem;
import com.assettec.api.internal.core.entities.asset.system.AssetSystemUpdater;
import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.common.XMLParser;
import com.assettec.api.internal.utilities.handlers.RequestCreator;
import com.assettec.api.internal.utilities.handlers.RequestSender;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

@Service
@AllArgsConstructor
public class AssetUpdater {

    private AssetEquipmentSetter assetEquipmentSetter;
    private AssetPositionUpdater assetPositionUpdater;
    private AssetSystemUpdater assetSystemUpdater;
    private RequestCreator requestBuilder;
    private RequestSender requestSender;
    private XMLParser xmlParser;

    @SneakyThrows
    public AssetEquipment getAsset(ApiUser apiUser, String equipmentCode, String equipmentOrganization) {
        if (equipmentOrganization == null) throw new IllegalStateException("equipmentOrganization is null");

        String host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());
        String postRequest = requestBuilder.getAssetRequestBuilder().getEquipment(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization(), equipmentCode, equipmentOrganization);
        String response = requestSender.sendPostRequest(postRequest,host);

        if (response.equals("Unable to locate registry")) throw new IllegalStateException("Unable to locate Asset");

        Document xmlData = xmlParser.toDocument(response);
        AssetEquipment asset = new AssetEquipment();

        return assetEquipmentSetter.setAssetData(asset, xmlData);
    }

    @SneakyThrows
    public AssetPosition getPosition(ApiUser apiUser, String positionCode, String positionOrganization) {
        if (positionOrganization == null) throw new IllegalStateException("positionOrganization is null");

        String host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());
        String postRequest = requestBuilder.getAssetRequestBuilder().getPosition(apiUser, positionCode, positionOrganization);
        String response = requestSender.sendPostRequest(postRequest,host);

        if (response.equals("Unable to locate registry")) throw new IllegalStateException("Unable to locate Position");

        Document xmlData = xmlParser.toDocument(response);
        Node resultData = xmlData.getElementsByTagName("ResultData").item(0);

        return assetPositionUpdater.getPosition(resultData.getChildNodes());
    }

    @SneakyThrows
    public AssetSystem getSystem(ApiUser apiUser, String systemCode, String systemOrganization) {
        if (systemOrganization == null) throw new IllegalStateException("systemOrganization is null");

        String host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());
        String postRequest = requestBuilder.getAssetRequestBuilder().getSystem(apiUser, systemCode, systemOrganization);
        String response = requestSender.sendPostRequest(postRequest,host);

        if (response.equals("Unable to locate registry")) throw new IllegalStateException("Unable to locate System");

        Document xmlData = xmlParser.toDocument(response);
        Node resultData = xmlData.getElementsByTagName("ResultData").item(0);

        return assetSystemUpdater.getSystem(resultData.getChildNodes());
    }
}
