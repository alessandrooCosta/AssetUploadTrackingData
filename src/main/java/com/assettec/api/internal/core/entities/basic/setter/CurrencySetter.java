package com.assettec.api.internal.core.entities.basic.setter;

import com.assettec.api.internal.core.entities.basic.objects.InforEamCurrency;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class CurrencySetter {

    public InforEamCurrency setCurrency(NodeList childNodes) {
        InforEamCurrency inforEamCurrency = new InforEamCurrency();

        inforEamCurrency.setValue(childNodes.item(0).getTextContent());
        inforEamCurrency.setDecimals(childNodes.item(1).getTextContent());
        inforEamCurrency.setSign(childNodes.item(2).getTextContent());
        inforEamCurrency.setCurrency(childNodes.item(3).getTextContent());
        inforEamCurrency.setDRCR(childNodes.item(4).getTextContent());

        return inforEamCurrency;
    }
}
