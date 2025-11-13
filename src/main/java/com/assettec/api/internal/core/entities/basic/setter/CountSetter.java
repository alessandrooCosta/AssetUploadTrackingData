package com.assettec.api.internal.core.entities.basic.setter;

import com.assettec.api.internal.core.entities.basic.objects.InforEamCount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class CountSetter {

    public InforEamCount setCount(NodeList nodeList) {
        InforEamCount inforEamCount = new InforEamCount();

        inforEamCount.setValue(nodeList.item(0).getTextContent());
        inforEamCount.setDecimals(nodeList.item(1).getTextContent());
        inforEamCount.setSign(nodeList.item(2).getTextContent());
        inforEamCount.setUom(nodeList.item(3).getTextContent());

        return inforEamCount;
    }
}
