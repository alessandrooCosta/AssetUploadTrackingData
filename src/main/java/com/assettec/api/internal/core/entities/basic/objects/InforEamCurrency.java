package com.assettec.api.internal.core.entities.basic.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InforEamCurrency {
    private String value;
    private String decimals;
    private String sign;
    private String currency;
    private String DRCR;

    public String toString() {
        if (sign.equals("+")) return String.valueOf(Long.parseLong(value) / Math.pow(10, Integer.parseInt(decimals)));
        else return sign + Long.parseLong(value) / Math.pow(10, Integer.parseInt(decimals));
    }

    public String buildRequest(String upper, String lower) {

        if ( (value == null || value.isEmpty()) && (decimals == null || decimals.isEmpty()) && (sign == null || sign.isEmpty()) && (currency == null || currency.isEmpty()) && (DRCR == null || DRCR.isEmpty()) ) return "";

        String valueString = value == null || value.isEmpty() ? "" : "<VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + value + "</VALUE>";
        String decimalsString = decimals == null || decimals.isEmpty() ? "" : "<NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + decimals + "</NUMOFDEC>";
        String signString = sign == null || sign.isEmpty() ? "" : "<SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">" + sign + "</SIGN>";
        String currencyString = currency == null || currency.isEmpty() ? "" : "<CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">" + currency + "</CURRENCY>";
        String DRCRString = DRCR == null || DRCR.isEmpty() ? "" : "<DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">" + DRCR + "</DRCR>";

        return upper + valueString + decimalsString + signString + currencyString + DRCRString + lower;
    }
}
