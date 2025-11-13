package com.assettec.api.integration.CLIENTES.requests;

import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.requests.requestbuilders.common.XMLRequestHeader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReqRequestBuilder {

        private XMLRequestHeader xmlRequestHeader;

        //
        public String postWorkOrder(ApiUser apiUser, String workOrderOrganization, String workOrderDescription, String status, String equipmentCode, String equipmentOrganization, String department, String type, String workOrderUdfChar20) {
            return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                    "    <Body>\n" +
                    "        <MP0023_AddWorkOrder_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Add\" noun=\"WorkOrder\" version=\"001\" callname=\"AddWorkOrder\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0023_001\">\n" +
                    "            <WorkOrder recordid=\"1\" is_completed=\"true\" is_cancelled=\"true\" has_department_security=\"has_1\" is_batchwo=\"true\" is_parentpmwo=\"true\" is_batchwo_update=\"true\" is_room_occupied=\"false\" xmlns=\"http://schemas.datastream.net/MP_entities/WorkOrder_001\">\n" +
                    "                <WORKORDERID auto_generated=\"true\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                    "                    <JOBNUM></JOBNUM>\n" +
                    "                    <ORGANIZATIONID entity=\"User\">\n" +
                    "                        <ORGANIZATIONCODE>" + workOrderOrganization + "</ORGANIZATIONCODE>\n" +
                    "                    </ORGANIZATIONID>\n" +
                    "                    <DESCRIPTION>"+ workOrderDescription +"</DESCRIPTION>\n" +
                    "                </WORKORDERID>\n" +
                    "                <STATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                    "                    <STATUSCODE>" + status + "</STATUSCODE>\n" +
                    "                </STATUS>\n" +
                    "                <EQUIPMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                    "                    <EQUIPMENTCODE>" + equipmentCode + "</EQUIPMENTCODE> \n" +
                    "                    <ORGANIZATIONID entity=\"Organization\">\n" +
                    "                        <ORGANIZATIONCODE>" + equipmentOrganization + "</ORGANIZATIONCODE>\n" +
                    "                    </ORGANIZATIONID>\n" +
                    "                </EQUIPMENTID>\n" +
                    "                <DEPARTMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                    "                    <DEPARTMENTCODE>" + department + "</DEPARTMENTCODE>\n" +
                    "                </DEPARTMENTID>\n" +
                    "                <TYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                    "                    <TYPECODE>" + type + "</TYPECODE>\n" +
                    "                </TYPE>\n" +
                    "                <UserDefinedFields>\n" +
                    "                    <UDFCHAR20 xmlns=\"http://schemas.datastream.net/MP_fields\">" + workOrderUdfChar20 + "</UDFCHAR20>\n" +
                    "                </UserDefinedFields>\n" +
                    "                <FIXED xmlns=\"http://schemas.datastream.net/MP_fields\"></FIXED>\n" +
                    "            </WorkOrder>\n" +
                    "        </MP0023_AddWorkOrder_001>\n" +
                    "    </Body>\n" +
                    "</Envelope>";
        }

    }
