package com.assettec.api.internal.core.entities.basic.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InforEamDate {
    private String year;
    private String month;
    private String day;
    private String hour;
    private String minute;
    private String second;
    private String nano;
    private String timeZone;

    public String toString(boolean detailed) {
        second = addZero(second);
        minute = addZero(minute);
        hour = addZero(hour);
        day = addZero(day);
        month = addZero(month);

        if ((hour.equals("00") && minute.equals("00") && second.equals("00")) || !detailed) return year + "-" + month + "-" + day;
        else return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
    }

    private String addZero(String data) {
        if (data.length() == 1) data = "0" + data;
        return data;
    }

    public String buildRequest(String upper, String lower) {
        if (year == null || year.isEmpty()) return "";
        return upper + "<YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + year + "</YEAR>" +
                "<MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + month + "</MONTH>" +
                "<DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + day + "</DAY>" +
                "<HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">" + hour + "</HOUR>" +
                "<MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">" + minute + "</MINUTE>" +
                "<SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + second + "</SECOND>" +
                "<SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">" + nano + "</SUBSECOND>" +
                "<TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">" + timeZone + "</TIMEZONE>" + lower;
    }
}
