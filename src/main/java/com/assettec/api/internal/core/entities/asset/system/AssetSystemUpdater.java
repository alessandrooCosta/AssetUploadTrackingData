package com.assettec.api.internal.core.entities.asset.system;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class AssetSystemUpdater {

    private AssetSystemSetter assetSystemSetter;


    public AssetSystem getSystem(NodeList resultData) {
        AssetSystem system = new AssetSystem();

        for (int i = 0; i < resultData.getLength(); i++) {
            Node resultDataNode = resultData.item(i);
            if (resultDataNode.getNodeName().equals("SystemEquipment")) {
                system.setUpdatedCount(resultDataNode.getAttributes().getNamedItem("recordid").getTextContent());
                assetSystemSetter.setSystem(system, resultDataNode.getChildNodes());
            }

        }

        return system;
    }
}
