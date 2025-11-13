package com.assettec.api.internal.core.user.info.area;

import com.assettec.api.internal.core.entities.basic.setter.DateSetter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class UserDefinedAreaSetter {


    private DateSetter dateSetter;

    public UserDefinedArea setUserDefinedArea(NodeList childNodes) {
        UserDefinedArea userDefinedArea = new UserDefinedArea();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node customField = childNodes.item(i);
            String customFieldName = customField.getNodeName();

            if (customFieldName.equals("PROPERTYCODE")) userDefinedArea.setPropertyCode(customField.getTextContent());
            if (customFieldName.equals("PROPERTYLABEL")) userDefinedArea.setPropertyLabel(customField.getTextContent());

            if (customFieldName.equals("DATEFIELD")) userDefinedArea.setDateField(dateSetter.setDate(customField.getChildNodes()));
            if (customFieldName.equals("MAXVALUE")) userDefinedArea.setMaxValue(customField.getTextContent());
            if (customFieldName.equals("MINVALUE")) userDefinedArea.setMinValue(customField.getTextContent());
            if (customFieldName.equals("UOM")) userDefinedArea.setUnitOfMetric(customField.getTextContent());
            if (customFieldName.equals("LOVSETTINGS")) {
                userDefinedArea.setLovType(customField.getFirstChild().getTextContent());
                userDefinedArea.setLovValidate(customField.getLastChild().getTextContent());
            }
            if (customFieldName.equals("VALUESOURCE")) {
                userDefinedArea.setCatValue(customField.getFirstChild().getTextContent());
                userDefinedArea.setNonUpdatable(customField.getLastChild().getTextContent());
            }
            if (customFieldName.equals("GROUPLABEL")) {
                userDefinedArea.setGroupLabel(customField.getTextContent());
            }
        }
        return userDefinedArea;
    }
}