package com.assettec.api.internal.core.entities.asset.equipment.utilities;


import com.assettec.api.internal.core.entities.asset.equipment.AssetEquipment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class AssetUpdaterNew {


    private AssetSetterNew assetSetterNew;

    public AssetEquipment updateAsset(AssetEquipment asset, NodeList resultDataChildNodes) {
        for (int i = 0; i < resultDataChildNodes.getLength(); i++) {
            Node childNode = resultDataChildNodes.item(i);
            if (childNode.getNodeName().equals("AssetEquipment")) asset = assetSetterNew.setAsset(asset, childNode.getChildNodes());

        }
        return asset;
    }
}