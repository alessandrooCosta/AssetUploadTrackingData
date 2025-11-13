package com.assettec.api.internal.core.user.info.area;

import com.assettec.api.internal.core.entities.basic.objects.Id.Id;
import com.assettec.api.internal.core.entities.basic.objects.InforEamDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDefinedArea {

    private String propertyCode;
    private String propertyLabel;
    private Id classId;
    private InforEamDate dateField;
    private String maxValue;
    private String minValue;
    private String unitOfMetric;

    private String lovType;
    private String lovValidate;
    private String catValue;
    private String nonUpdatable;
    private String groupLabel;

    public String buildRequest(String upper, String lower) {

        String code = getPropertyCode() == null ? "" : "<PROPERTYCODE>" + getPropertyCode() + "</PROPERTYCODE>";
        String label = getPropertyLabel() == null ? "" : "<PROPERTYLABEL>" + getPropertyLabel() + "</PROPERTYLABEL>";
        String classId = getClassId() == null ? "" : getClassId().buildRequest("<CLASSID entity=\"ent2\">","</CLASSID>","<ORGANIZATIONID entity=\"Location\">","</ORGANIZATIONID>","CLASSCODE","DESCRIPTION","ORGANIZATIONCODE","DESCRIPTION");
        String dateField = getDateField() == null ? "" : getDateField().buildRequest("<DATEFIELD qualifier=\"ACCOUNTING\">","</DATEFIELD>");
        String maxValue = getMaxValue() == null ? "" : "<MAXVALUE>" + getMaxValue() + "</MAXVALUE>";
        String minValue = getMinValue() == null ? "" : "<MINVALUE>" + getMinValue() + "</MINVALUE>";
        String UOM = getUnitOfMetric() == null ? "" : "<UOM>" + getUnitOfMetric() + "</UOM>";
        String groupLabel = "<GROUPLABEL>" + getGroupLabel() + "</GROUPLABEL>";
        String lovSettings = getLovType() == null && getLovValidate() == null ? "" : getLovType() != null && getLovValidate() == null ? "<LOVSETTINGS>" +
                "<LOV_TYPE>" + getLovType() + "</LOV_TYPE>" +
                "</LOVSETTINGS>" : getLovType() == null && getLovValidate() != null ? "<LOVSETTINGS>" +
                "<LOV_VALIDATE>" + getLovValidate() + "</LOV_VALIDATE>" +
                "</LOVSETTINGS>" : "<LOVSETTINGS>" +
                "<LOV_TYPE>" + getLovType() + "</LOV_TYPE>" +
                "<LOV_VALIDATE>" + getLovValidate() + "</LOV_VALIDATE>" +
                "</LOVSETTINGS>";

        String valueSource = getCatValue() == null && getNonUpdatable() == null ? "" : getCatValue() != null && getNonUpdatable() == null ? "<VALUESOURCE>" +
                "<CATVALUE>" + getCatValue() + "</CATVALUE>" +
                "</VALUESOURCE>" : getCatValue() == null && getNonUpdatable() != null ? "<VALUESOURCE>" +
                "<NONUPDATEABLE>" + getNonUpdatable() + "</NONUPDATEABLE>" +
                "</VALUESOURCE>" : "<VALUESOURCE>" +
                "<CATVALUE>" + getCatValue() + "</CATVALUE>" +
                "<NONUPDATEABLE>" + getNonUpdatable() + "</NONUPDATEABLE>" +
                "</VALUESOURCE>";


        return upper + code + label + classId + dateField + maxValue + minValue + UOM + lovSettings + valueSource + groupLabel + lower;
    }
}
