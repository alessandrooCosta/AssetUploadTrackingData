package com.assettec.api.internal.core.entities.basic.setter;

import com.assettec.api.internal.core.entities.basic.objects.CodeRevision;
import com.assettec.api.internal.core.entities.basic.objects.Id.IdEntity;
import com.assettec.api.internal.core.entities.basic.objects.InforEamCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class CodeSetter {

    public CodeRevision setCodeRevision(NodeList childNodes) {
        CodeRevision codeRevision = new CodeRevision();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);

            if (node.getNodeName().contains("CODE")) codeRevision.setCode(node.getTextContent());
            if (node.getNodeName().contains("REVISION")) codeRevision.setRevision(node.getTextContent());
            if (node.getNodeName().equals("DESCRIPTION")) codeRevision.setDescription(node.getTextContent());
        }

        return codeRevision;
    }

    public IdEntity setEntity(NodeList childNodes) {
        IdEntity inforEamEntity = new IdEntity();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);

            if (childNode.getNodeName().equals("ENTITY")) inforEamEntity.setEntity(childNode.getTextContent());
            if (childNode.getNodeName().contains("CODE")) inforEamEntity.setCode(childNode.getTextContent());
            if (childNode.getNodeName().equals("DESCRIPTION"))
                inforEamEntity.setDescription(childNode.getTextContent());
        }

        return inforEamEntity;
    }

    public InforEamCode setOrganization(NodeList childNodes) {
        InforEamCode inforEamCode = new InforEamCode();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeName().contains("CODE")) inforEamCode.setCode(childNode.getTextContent());
            if (childNode.getNodeName().equals("DESCRIPTION")) inforEamCode.setDescription(childNode.getTextContent());
        }

        return inforEamCode;
    }

    public InforEamCode setCode(NodeList childNodes) {
        InforEamCode inforEamCode = new InforEamCode();

        if (childNodes == null || childNodes.getLength() == 0) {
            return inforEamCode;
        } else {
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node childNode = childNodes.item(i);
                String nodeName = childNode.getNodeName();
                if (checkAcceptedCodeList(nodeName)) inforEamCode.setCode(childNode.getTextContent());
                if (nodeName.contains("DESCRIPTION")) inforEamCode.setDescription(childNode.getTextContent());
            }
        }

        return inforEamCode;
    }

    private boolean checkAcceptedCodeList(String nodeName) {
        String[] acceptedList = {"CRITICALITY", "LINEARREFUOM", "OBJTYPE"};
        List<String> stringList = Arrays.asList(acceptedList);

        if (stringList.contains(nodeName) || nodeName.contains("CODE")) return true;
        if (nodeName.equals("DESCRIPTION")) return false;
        else throw new IllegalStateException("node: " + nodeName + " is not in acceptedCodeList.");
    }
}
