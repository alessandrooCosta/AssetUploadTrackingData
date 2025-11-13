package com.assettec.api.internal.core.entities.basic.setter;

import com.assettec.api.internal.core.entities.basic.objects.InforEamDate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class DateSetter {

    public InforEamDate setDate(NodeList childNodes) {
        InforEamDate inforEamDate = new InforEamDate();

        inforEamDate.setYear(childNodes.item(0).getTextContent());
        inforEamDate.setMonth(childNodes.item(1).getTextContent());
        inforEamDate.setDay(childNodes.item(2).getTextContent());
        inforEamDate.setHour(childNodes.item(3).getTextContent());
        inforEamDate.setMinute(childNodes.item(4).getTextContent());
        inforEamDate.setSecond(childNodes.item(5).getTextContent());
        inforEamDate.setNano(childNodes.item(6).getTextContent());
        inforEamDate.setTimeZone(childNodes.item(7).getTextContent());

        return inforEamDate;

    }
}
