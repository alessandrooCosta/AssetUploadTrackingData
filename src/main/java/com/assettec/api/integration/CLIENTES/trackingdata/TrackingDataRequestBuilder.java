package com.assettec.api.integration.CLIENTES.trackingdata;

import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.requests.requestbuilders.common.XMLRequestHeader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TrackingDataRequestBuilder {

    private XMLRequestHeader xmlRequestHeader;


    public String postTrackingData(ApiUser apiUser, String TRANSCODE, String PROMPTDATA1, String PROMPTDATA2, String PROMPTDATA3, String PROMPTDATA4, String PROMPTDATA5, String PROMPTDATA50, String PROMPTDATA51) {
        return " <Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                " <Body>\n" +
                "  <MP0810_AddInterfaceTransactions_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Add\" noun=\"InterfaceTransactions\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0810_001\">\n" +
                "  <InterfaceTransactions xmlns=\"http://schemas.datastream.net/MP_entities/InterfaceTransactions_001\">\n" +
                "  <TrackingData xmlns=\"http://schemas.datastream.net/MP_entities/TrackingData_001\">\n" +
                "  <TRANSCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + TRANSCODE + "</TRANSCODE> \n" +
                "  <PROMPTDATA1 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA1 + "</PROMPTDATA1> \n" +
                "  <PROMPTDATA2 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA2 + "</PROMPTDATA2> \n" +
                "  <PROMPTDATA3 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA3 + "</PROMPTDATA3> \n" +
                "  <PROMPTDATA4 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA4 + "</PROMPTDATA4> \n" +
                "  <PROMPTDATA5 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA5 + "</PROMPTDATA5> \n" +
                "  <PROMPTDATA50 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA50 + "</PROMPTDATA50> \n" +
                "  <PROMPTDATA51 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA51 + "</PROMPTDATA51> \n" +
                "  </TrackingData>\n" +
                "  </InterfaceTransactions>\n" +
                "  </MP0810_AddInterfaceTransactions_001>" +
                "    </Body>\n" +
                "</Envelope>";

    }
}