package com.assettec.api.internal.utilities.requests.requestbuilders.assetRequestBuilder;

import com.assettec.api.internal.core.entities.asset.position.AssetPosition;
import com.assettec.api.internal.core.entities.asset.position.AssetPositionUpdater;
import com.assettec.api.internal.core.entities.asset.equipment.AssetEquipment;
import com.assettec.api.internal.core.entities.asset.system.AssetSystem;
import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.requests.requestbuilders.assetRequestBuilder.utilities.asset.AssetRequestBodyBuilder;
import com.assettec.api.internal.utilities.requests.requestbuilders.assetRequestBuilder.utilities.position.PositionRequestBodyBuilder;
import com.assettec.api.internal.utilities.requests.requestbuilders.assetRequestBuilder.utilities.system.SystemRequestBodyBuilder;
import com.assettec.api.internal.utilities.requests.requestbuilders.common.XMLRequestHeader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssetRequestBuilder {
    private XMLRequestHeader xmlRequestHeader;
    private AssetRequestBodyBuilder assetRequestBodyBuilder;
    private SystemRequestBodyBuilder systemRequestBodyBuilder;
    private PositionRequestBodyBuilder positionRequestBodyBuilder;

    public String getEquipment(String userName, String tenant, String passWord, String organization, String equipmentCode, String equipmentOrganization) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(userName, tenant, passWord, organization) +
                "    <Body>\n" +
                "        <MP0302_GetAssetEquipment_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Get\" noun=\"AssetEquipment\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0302_001\">\n" +
                "            <ASSETID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                <EQUIPMENTCODE>" + equipmentCode + "</EQUIPMENTCODE>\n" +
                "                <ORGANIZATIONID entity=\"User\">\n" +
                "                    <ORGANIZATIONCODE>" + equipmentOrganization + "</ORGANIZATIONCODE>\n" +
                "                </ORGANIZATIONID>\n" +
                "            </ASSETID>\n" +
                "        </MP0302_GetAssetEquipment_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

    public String putEquipment(ApiUser apiUser, AssetEquipment asset) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "<Body>" +
                "<MP0303_SyncAssetEquipment_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Sync\" noun=\"AssetEquipment\" version=\"001\" confirm_availability_status=\"confirm_availability_status1\" confirmaddlinearreferences=\"confirmaddlinearreferences1\" confirmnewequipmentlength=\"confirmnewequipmentlength1\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0303_001\">" +
                "<AssetEquipment recordid=\"" + asset.getUpdatedCount() + "\" user_entity=\"user_entity1\" system_entity=\"system_entity1\" autonumber=\"default\" creategis=\"true\" has_department_security=\"has_1\" has_readonly_department_security_for_createwo=\"has_1\" is_gis_webservice_request=\"false\" is_associated_to_current_consist=\"false\" is_default_rankings_available=\"false\" instructure=\"false\" haswo=\"false\" confirm_delete_surveryanswers=\"confirmed\" xmlns=\"http://schemas.datastream.net/MP_entities/AssetEquipment_001\">" +
                assetRequestBodyBuilder.buildBody(asset).replace("null","") +
                "</AssetEquipment>" +
                "</MP0303_SyncAssetEquipment_001>" +
                "</Body>" +
                "</Envelope>";
    }

    public String getPosition(ApiUser apiUser, String code, String organization) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "<Body>" +
                "<MP0307_GetPositionEquipment_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Get\" noun=\"PositionEquipment\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0307_001\">\n" +
                "<POSITIONID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<EQUIPMENTCODE>" + code + "</EQUIPMENTCODE> " +
                "<ORGANIZATIONID entity=\"User\">" +
                "<ORGANIZATIONCODE>" + organization + "</ORGANIZATIONCODE>" +
                "</ORGANIZATIONID>" +
                "</POSITIONID>" +
                "</MP0307_GetPositionEquipment_001>" +
                "</Body>" +
                "</Envelope>";
    }

    public String putPosition(ApiUser apiUser, AssetPosition position) {
        return positionRequestBodyBuilder.buildBody(apiUser, position);
    }

    public String getSystem(ApiUser apiUser, String systemCode, String systemOrganization) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "<Body>" +
                "<MP0312_GetSystemEquipment_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Get\" noun=\"PositionEquipment\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0307_001\">\n" +
                "<SYSTEMID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<EQUIPMENTCODE>" + systemCode + "</EQUIPMENTCODE> " +
                "<ORGANIZATIONID entity=\"User\">" +
                "<ORGANIZATIONCODE>" + systemOrganization + "</ORGANIZATIONCODE>" +
                "</ORGANIZATIONID>" +
                "</SYSTEMID>" +
                "</MP0312_GetSystemEquipment_001>" +
                "</Body>" +
                "</Envelope>";
    }

    public String putSystem(ApiUser apiUser, AssetSystem system) {
        return systemRequestBodyBuilder.buildBody(apiUser, system);
    }


}