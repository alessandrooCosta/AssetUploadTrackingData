package com.assettec.api.internal.core.entities.signature;

import com.assettec.api.internal.core.entities.basic.setter.CodeSetter;
import com.assettec.api.internal.core.entities.basic.setter.DateSetter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class ESignatureDetailSetter {

    private CodeSetter codeSetter;
    private DateSetter dateSetter;

    public ESignatureDetail setESignatureDetails(NodeList childNodes) {
        ESignatureDetail eSignatureDetail = new ESignatureDetail();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);

            if (childNode.getNodeName().equals("ESIGNER")) eSignatureDetail.setESigner(codeSetter.setCode(childNode.getChildNodes()));
            if (childNode.getNodeName().equals("ESIGNATUREDATE")) eSignatureDetail.setESignatureDate(dateSetter.setDate(childNode.getChildNodes()));
            if (childNode.getNodeName().equals("SIGNATURETYPE")) eSignatureDetail.setSignatureType(childNode.getTextContent());
            if (childNode.getNodeName().equals("ERECORDCODE")) eSignatureDetail.setERecordCode(childNode.getTextContent());

        }

        return eSignatureDetail;
    }
}
