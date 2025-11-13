package com.assettec.api.integration.CLIENTES.purchaseorder;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
public class XMLUtils {
        public static Node getChildNodeByName(Node parent, String nodeName) {
            NodeList childNodes = parent.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node childNode = childNodes.item(i);
                if (childNode.getNodeName().equals(nodeName)) {
                    return childNode;
                }
            }
            return null;
        }
    }