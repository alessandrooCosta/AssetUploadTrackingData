package com.assettec.api.integration.CLIENTES.Excel.Modulos.Data;

import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.requests.requestbuilders.common.XMLRequestHeader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TrackingDataBuilder {

    private XMLRequestHeader xmlRequestHeader;


    public String postTrackingData(ApiUser apiUser, String TRANSID, String TRANSCODE, String PROMPTDATA1, String PROMPTDATA2, String PROMPTDATA3, String PROMPTDATA4, String PROMPTDATA5,  String PROMPTDATA6, String PROMPTDATA7, String PROMPTDATA8, String PROMPTDATA9, String PROMPTDATA10, String PROMPTDATA11, String PROMPTDATA12, String PROMPTDATA13, String PROMPTDATA14, String PROMPTDATA15, String PROMPTDATA16, String PROMPTDATA17, String PROMPTDATA18, String PROMPTDATA19, String PROMPTDATA20, String PROMPTDATA21, String PROMPTDATA22, String PROMPTDATA23, String PROMPTDATA24, String PROMPTDATA25, String PROMPTDATA26, String PROMPTDATA27, String PROMPTDATA28, String PROMPTDATA29, String PROMPTDATA30, String PROMPTDATA31, String PROMPTDATA32, String PROMPTDATA33, String PROMPTDATA34, String PROMPTDATA35, String PROMPTDATA36, String PROMPTDATA37, String PROMPTDATA38, String PROMPTDATA39, String PROMPTDATA40, String PROMPTDATA41, String PROMPTDATA42, String PROMPTDATA43, String PROMPTDATA44, String PROMPTDATA45, String PROMPTDATA46, String PROMPTDATA47, String PROMPTDATA48, String PROMPTDATA49, String PROMPTDATA50, String PROMPTDATA51) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                " <Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                " <Body>\n" +
                "  <MP0810_AddInterfaceTransactions_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Add\" noun=\"InterfaceTransactions\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0810_001\">\n" +
                "  <InterfaceTransactions xmlns=\"http://schemas.datastream.net/MP_entities/InterfaceTransactions_001\">\n" +
                "  <TrackingData xmlns=\"http://schemas.datastream.net/MP_entities/TrackingData_001\">\n" +
                "  <TRANSID xmlns=\"http://schemas.datastream.net/MP_fields\">" + TRANSID + "</TRANSID> \n" +
                "  <TRANSCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + TRANSCODE + "</TRANSCODE> \n" +
                "  <PROMPTDATA1 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA1 + "</PROMPTDATA1> \n" +
                "  <PROMPTDATA2 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA2 + "</PROMPTDATA2> \n" +
                "  <PROMPTDATA3 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA3 + "</PROMPTDATA3> \n" +
                "  <PROMPTDATA4 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA4 + "</PROMPTDATA4> \n" +
                "  <PROMPTDATA5 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA5 + "</PROMPTDATA5> \n" +
                "  <PROMPTDATA6 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA6 + "</PROMPTDATA6> \n" +
                "  <PROMPTDATA7 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA7 + "</PROMPTDATA7> \n" +
                "  <PROMPTDATA8 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA8 + "</PROMPTDATA8> \n" +
                "  <PROMPTDATA9 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA9 + "</PROMPTDATA9> \n" +
                "  <PROMPTDATA10 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA10 + "</PROMPTDATA10> \n" +
                "  <PROMPTDATA11 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA11 + "</PROMPTDATA11> \n" +
                "  <PROMPTDATA12 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA12 + "</PROMPTDATA12> \n" +
                "  <PROMPTDATA13 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA13 + "</PROMPTDATA13> \n" +
                "  <PROMPTDATA14 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA14 + "</PROMPTDATA14> \n" +
                "  <PROMPTDATA15 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA15 + "</PROMPTDATA15> \n" +
                "  <PROMPTDATA16 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA16 + "</PROMPTDATA16> \n" +
                "  <PROMPTDATA17 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA17 + "</PROMPTDATA17> \n" +
                "  <PROMPTDATA18 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA18 + "</PROMPTDATA18> \n" +
                "  <PROMPTDATA19 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA19 + "</PROMPTDATA19> \n" +
                "  <PROMPTDATA20 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA20 + "</PROMPTDATA20> \n" +
                "  <PROMPTDATA21 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA21 + "</PROMPTDATA21> \n" +
                "  <PROMPTDATA22 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA22 + "</PROMPTDATA22> \n" +
                "  <PROMPTDATA23 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA23 + "</PROMPTDATA23> \n" +
                "  <PROMPTDATA24 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA24 + "</PROMPTDATA24> \n" +
                "  <PROMPTDATA25 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA25 + "</PROMPTDATA25> \n" +
                "  <PROMPTDATA26 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA26 + "</PROMPTDATA26> \n" +
                "  <PROMPTDATA27 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA27 + "</PROMPTDATA27> \n" +
                "  <PROMPTDATA28 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA28 + "</PROMPTDATA28> \n" +
                "  <PROMPTDATA29 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA29 + "</PROMPTDATA29> \n" +
                "  <PROMPTDATA30 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA30 + "</PROMPTDATA30> \n" +
                "  <PROMPTDATA31 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA31 + "</PROMPTDATA31> \n" +
                "  <PROMPTDATA32 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA32 + "</PROMPTDATA32> \n" +
                "  <PROMPTDATA33 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA33 + "</PROMPTDATA33> \n" +
                "  <PROMPTDATA34 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA34 + "</PROMPTDATA34> \n" +
                "  <PROMPTDATA35 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA35 + "</PROMPTDATA35> \n" +
                "  <PROMPTDATA36 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA36 + "</PROMPTDATA36> \n" +
                "  <PROMPTDATA37 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA37 + "</PROMPTDATA37> \n" +
                "  <PROMPTDATA38 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA38 + "</PROMPTDATA38> \n" +
                "  <PROMPTDATA39 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA39 + "</PROMPTDATA39> \n" +
                "  <PROMPTDATA40 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA40 + "</PROMPTDATA40> \n" +
                "  <PROMPTDATA41 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA41 + "</PROMPTDATA41> \n" +
                "  <PROMPTDATA42 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA42 + "</PROMPTDATA42> \n" +
                "  <PROMPTDATA43 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA43 + "</PROMPTDATA43> \n" +
                "  <PROMPTDATA44 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA44 + "</PROMPTDATA44> \n" +
                "  <PROMPTDATA45 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA45 + "</PROMPTDATA45> \n" +
                "  <PROMPTDATA46 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA46 + "</PROMPTDATA46> \n" +
                "  <PROMPTDATA47 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA47 + "</PROMPTDATA47> \n" +
                "  <PROMPTDATA48 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA48 + "</PROMPTDATA48> \n" +
                "  <PROMPTDATA49 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA49 + "</PROMPTDATA49> \n" +
                "  <PROMPTDATA50 xmlns=\"http://schemas.datastream.net/MP_fields\">" + PROMPTDATA50 + "</PROMPTDATA50> \n" +
                "  <PROMPTDATA51 xmlns=\"http://schemas.datastream.net/MP_fields\"><![CDATA[" + PROMPTDATA51 + "]]></PROMPTDATA51> \n" +
                "  </TrackingData>\n" +
                "  </InterfaceTransactions>\n" +
                "  </MP0810_AddInterfaceTransactions_001>" +
                "    </Body>\n" +
                "</Envelope>";

    }
}
