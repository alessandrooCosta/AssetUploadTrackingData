package com.assettec.api.internal.utilities.requests.requestbuilders.common;

import org.springframework.stereotype.Service;

@Service
public class XMLRequestHeader {
    public String postRequestHeader(String userName, String tenant, String passWord, String organization) {
        return  "<Header>" +
                "<Security xmlns=\"http://schemas.xmlsoap.org/ws/2002/04/secext\">" +
                "<UsernameToken>" +
                "<Username>" + userName + "@" + tenant + "</Username>" +
                "<Password>" + passWord + "</Password>" +
                "</UsernameToken>" +
                "</Security>" +
                "<SessionScenario xmlns=\"http://schemas.datastream.net/headers\">terminate</SessionScenario>" +
                "<Organization xmlns=\"http://schemas.datastream.net/headers\">" + organization + "</Organization>" +
                "</Header>";
    }
}
