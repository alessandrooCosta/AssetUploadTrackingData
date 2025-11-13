package com.assettec.api.internal.core.entities.asset.common.setters;

import com.assettec.api.internal.core.entities.asset.equipment.AssetEquipment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class PurchaseOrderInfoSetter {



    public void setPurchaseOrderInfo(AssetEquipment asset, NodeList childNodes) {
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeName().equals("PURCHASEORDERLINEID")) {
                for (int j = 0; j < childNode.getChildNodes().getLength(); j++) {
                    Node childNode2 = childNode.getChildNodes().item(j);


                    if (childNode2.getNodeName().equals("PURCHASEORDERLINENUM")) asset.setPurchaseOrderLineNum(childNode2.getTextContent());

                }
            }
        }
    }
}
