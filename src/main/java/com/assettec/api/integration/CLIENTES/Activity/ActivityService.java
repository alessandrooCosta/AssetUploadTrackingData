package com.assettec.api.integration.CLIENTES.Activity;

import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.common.XMLParser;
import com.assettec.api.internal.utilities.handlers.RequestCreator;
import com.assettec.api.internal.utilities.handlers.RequestSender;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

@Service
@AllArgsConstructor
public class ActivityService {


        private RequestCreator requestBuilder;
        private RequestSender requestSender;
        private XMLParser xmlParser;

        @SneakyThrows
        public String postActivity(ApiUser apiUser, String OS, String ActivityCode, String Nivel, String PERSONS, String ESTIMATEDHOURS, String activityStartDate, String activityEndDate) {
                String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

                // Parse the start date into DAY, MONTH, and YEAR
                String[] startDateParts = activityStartDate.split("-");
                String startDay = startDateParts[0];
                String startMonth = startDateParts[1];
                String startYear = startDateParts[2];

                // Parse the end date into DAY, MONTH, and YEAR
                String[] endDateParts = activityEndDate.split("-");
                String endDay = endDateParts[0];
                String endMonth = endDateParts[1];
                String endYear = endDateParts[2];


                postRequest = requestBuilder.getActivityRequestBuilder().postActivity(apiUser, OS, ActivityCode, Nivel, PERSONS, ESTIMATEDHOURS, startDay, startMonth, startYear, endDay, endMonth, endYear);
                response = requestSender.sendPostRequest(postRequest, host);
                Document xmlData = xmlParser.toDocument(response);

                return xmlData.getElementsByTagName("Message").item(0).getTextContent();
        }


}
