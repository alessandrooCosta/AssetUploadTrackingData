package com.assettec.api.internal.utilities.requests.requestbuilders;

import com.assettec.api.internal.utilities.requests.requestbuilders.common.XMLRequestHeader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdministrationRequestBuilder {

    private XMLRequestHeader xmlRequestHeader;

    public String getInstallationCode(String userName, String tenant, String passWord, String organization, String installationCode) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(userName,tenant,passWord,organization) +
                "    <Body>\n" +
                "        <MP0651_GetInstallationCode_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Get\" noun=\"InstallationCode\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0651_001\">\n" +
                "            <INSTALLATIONCODEID entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                <INSTALLATIONCODE>" + installationCode + "</INSTALLATIONCODE>\n" +
                "            </INSTALLATIONCODEID>\n" +
                "        </MP0651_GetInstallationCode_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }
}
