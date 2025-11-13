package com.assettec.api.internal.core.entities.asset.position;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class AssetPositionUpdater {

    private AssetPositionSetter assetPositionSetter;


    public AssetPosition getPosition(NodeList resultData) {
        AssetPosition position = new AssetPosition();

        for (int i = 0; i < resultData.getLength(); i++) {
            Node resultDataNode = resultData.item(i);
            if (resultDataNode.getNodeName().equals("PositionEquipment")) {
                position.setUpdatedCount(resultDataNode.getAttributes().getNamedItem("recordid").getTextContent());
                assetPositionSetter.setPosition(position, resultDataNode.getChildNodes());
            }

        }

        return position;
    }

    public AssetPosition setPosition(NodeList resultData) {
        AssetPosition position = new AssetPosition();

        assetPositionSetter.setPosition(position,resultData);


        return position;
    }
}
