package com.assettec.api.internal.core.entities.basic.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InforEamCount {
    private String value;
    private String decimals;
    private String sign;
    private String uom;

    public String toString() {
        if (sign.equals("+")) return String.valueOf(Long.parseLong(value) / Math.pow(10, Integer.parseInt(decimals)));
        else return sign + Long.parseLong(value) / Math.pow(10, Integer.parseInt(decimals));
    }

    public String buildRequest(String upper, String lower) {
        if (value == null || value.isEmpty()) return "";
        if (decimals == null || decimals.isEmpty()) return "";
        if (sign == null || sign.isEmpty()) return "";
        if (uom == null || uom.isEmpty()) return "";

        return upper + "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + value + "</VALUE>" +
                "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + decimals + "</NUMOFDEC>" +
                "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + sign + "</SIGN>" +
                "<UOM xmlns=\"http://www.openapplications.org/oagis_fields\">" + uom + "</UOM>" + lower;
    }
}
