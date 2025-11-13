package com.assettec.api.internal.core.installationcode.utilities;

import com.assettec.api.internal.core.installationcode.InstallationCode;
import com.assettec.api.internal.utilities.common.XMLParser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

@Component
@AllArgsConstructor
public class InstallationCodeSetter {

    public InstallationCode setInstallationCode(Document xmlData, InstallationCode installationCode) {

        installationCode.setCode(xmlData.getElementsByTagName("INSTALLATIONCODE").item(0).getTextContent());
        installationCode.setDescription(xmlData.getElementsByTagName("INSTALLATIONCODEDESCRIPTION").item(0).getTextContent());
        installationCode.setValue(xmlData.getElementsByTagName("INSTALLATIONCODEDEFAULT").item(0).getTextContent());
        installationCode.setFixed(xmlData.getElementsByTagName("INSTALLATIONCODEFIXED").item(0).getTextContent());

        return installationCode;
    }
}
