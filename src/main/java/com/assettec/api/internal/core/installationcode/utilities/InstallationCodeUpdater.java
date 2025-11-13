package com.assettec.api.internal.core.installationcode.utilities;

import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.core.installationcode.InstallationCode;
import com.assettec.api.internal.utilities.common.XMLParser;
import com.assettec.api.internal.utilities.handlers.RequestCreator;
import com.assettec.api.internal.utilities.handlers.RequestSender;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

@Component
@AllArgsConstructor
public class InstallationCodeUpdater {

    private XMLParser xmlParser;
    private RequestCreator requestBuilder;
    private RequestSender requestSender;
    private InstallationCodeSetter installationCodeSetter;


    @SneakyThrows
    public InstallationCode updateInstallationCode(ApiUser apiUser, String installationCode) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());
        postRequest = requestBuilder.getAdministrationRequestBuilder().getInstallationCode(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization(), installationCode);
        response = requestSender.sendPostRequest(postRequest,host);

        Document xmlData = xmlParser.toDocument(response);

        return installationCodeSetter.setInstallationCode(xmlData, new InstallationCode());
    }
}
