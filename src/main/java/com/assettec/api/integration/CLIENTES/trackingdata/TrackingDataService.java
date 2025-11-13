package com.assettec.api.integration.CLIENTES.trackingdata;

import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.common.XMLParser;
import com.assettec.api.internal.utilities.handlers.RequestCreator;
import com.assettec.api.internal.utilities.handlers.RequestSender;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

@Service
@AllArgsConstructor
public class TrackingDataService {

    private RequestCreator requestBuilder;
    private RequestSender requestSender;
    private XMLParser xmlParser;


    @SneakyThrows
    public String postTrackingData(ApiUser apiUser, String TRANSCODE, String PROMPTDATA1, String PROMPTDATA2, String PROMPTDATA3, String PROMPTDATA4, String PROMPTDATA5, String PROMPTDATA50, String PROMPTDATA51) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getTrackingDataRequestBuilder().postTrackingData(apiUser, TRANSCODE, PROMPTDATA1, PROMPTDATA2, PROMPTDATA3, PROMPTDATA4, PROMPTDATA5, PROMPTDATA50, PROMPTDATA51);
        response = requestSender.sendPostRequest(postRequest, host);
        Document xmlData = xmlParser.toDocument(response);

        NodeList messageNodes = xmlData.getElementsByTagName("Message");
        if (messageNodes.getLength() > 0) {
            return messageNodes.item(0).getTextContent();
        } else {
            return "Dados carregado na tabela TrackingData";
        }
    }}
