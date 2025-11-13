package com.assettec.api.integration.CLIENTES.laborbook;

import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.common.XMLParser;
import com.assettec.api.internal.utilities.handlers.RequestCreator;
import com.assettec.api.internal.utilities.handlers.RequestSender;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.Date;

@Service
@AllArgsConstructor
public class LaborBookingService {

    private RequestCreator requestBuilder;
    private RequestSender requestSender;
    private XMLParser xmlParser;


    @SneakyThrows
    public String postLabor(ApiUser apiUser, String OS, String employee, String activityCode, String department, String laborDate, String typeOfTime, String laborStartHours, String laborEndHours) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        // Parse the start date into DAY, MONTH, and YEAR
        String[] laborDateParts = laborDate.split("-");
        String day = laborDateParts[0];
        String month = laborDateParts[1];
        String year = laborDateParts[2];

        String[] startHoursParts = laborStartHours.split(":");
        String startHours = startHoursParts[0];
        String startMinute = startHoursParts[1];

        String[] endHoursParts = laborEndHours.split(":");
        String endHours = endHoursParts[0];
        String endMinute = endHoursParts[1];


        postRequest = requestBuilder.getLaborBookingRequestBuilder().addLabor(apiUser,  OS,  employee,  activityCode, department,  year,  month,  day,  typeOfTime, startHours, startMinute, endHours, endMinute);
        response = requestSender.sendPostRequest(postRequest, host);
        Document xmlData = xmlParser.toDocument(response);

        return xmlData.getElementsByTagName("Message").item(0).getTextContent();
    }

    @SneakyThrows
    public String getLabor(ApiUser apiUser) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getCommentsRequestBuilder().getBooking(apiUser);
        response = requestSender.sendPostRequest(postRequest, host);
        Document xmlData = xmlParser.toDocument(response);

        System.out.println("XML response:\n" + response);


        NodeList messageNodes = xmlData.getElementsByTagName("Message");
        if (messageNodes.getLength() > 0) {
            return messageNodes.item(0).getTextContent();
        } else {
            // Handle the case where the "Message" node is missing
            return "Message node not found";
        }

    }

    @SneakyThrows
    public String getActivity(ApiUser apiUser, String jobNum) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getCommentsRequestBuilder().getActivity(apiUser, jobNum);
        response = requestSender.sendPostRequest(postRequest, host);
        Document xmlData = xmlParser.toDocument(response);

        System.out.println("XML response:\n" + response);


        NodeList messageNodes = xmlData.getElementsByTagName("Message");
        if (messageNodes.getLength() > 0) {
            return messageNodes.item(0).getTextContent();
        } else {
            // Handle the case where the "Message" node is missing
            return "Message node not found";
        }

    }

    @SneakyThrows
    public String postActiivty(ApiUser apiUser, String jobNum, String ACTIVITYCODE, String TRADECODE, String PERSONS, String ESTIMATEDHOURS) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getCommentsRequestBuilder().addActivity(apiUser, jobNum, ACTIVITYCODE, TRADECODE, PERSONS, ESTIMATEDHOURS);
        response = requestSender.sendPostRequest(postRequest, host);
        Document xmlData = xmlParser.toDocument(response);


        return xmlData.getElementsByTagName("Message").item(0).getTextContent();
    }


}
