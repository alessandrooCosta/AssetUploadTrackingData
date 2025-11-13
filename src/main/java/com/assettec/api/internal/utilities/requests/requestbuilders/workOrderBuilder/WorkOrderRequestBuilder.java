package com.assettec.api.internal.utilities.requests.requestbuilders.workOrderBuilder;

import com.assettec.api.integration.CLIENTES.maptronic.WorkOrderUpdateDTO;
import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.requests.requestbuilders.common.XMLRequestHeader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WorkOrderRequestBuilder {
    private XMLRequestHeader xmlRequestHeader;

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





    public String putWorkOrder(ApiUser apiUser, int OS, WorkOrderUpdateDTO updateDTO) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "   <Body>\n" +
                "  <MP0025_SyncWorkOrder_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" replace_mec_eq=\"false\" deleteActivities=\"dele1\" autoproductionrequestprompt=\"autoproductionrequestprompt1\" completenonevaluatedsurveyequipprompt=\"completenonevaluatedsurveyequipprompt1\" confirmadddeletechecklist=\"prompt\" confirmincompletechecklist=\"prompt\" confirmworkorderhasfollowupchecklist=\"prompt\" confirmrouteequipmentchecklist=\"prompt\" confirmequipmentchecklist=\"prompt\" iscontractorportal=\"false\" verb=\"Sync\" noun=\"WorkOrder\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0025_001\">\n" +
                "  <WorkOrder recordid=\"" + OS + "\" is_completed=\"true\" is_cancelled=\"true\" has_department_security=\"has_1\" is_batchwo=\"true\" is_parentpmwo=\"true\" is_batchwo_update=\"true\" is_room_occupied=\"false\" xmlns=\"http://schemas.datastream.net/MP_entities/WorkOrder_001\">\n" +
                "  <WORKORDERID auto_generated=\"true\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <JOBNUM>" + OS + "</JOBNUM> \n" +
                "  <ORGANIZATIONID entity=\"User\">\n" +
                "        <ORGANIZATIONCODE>" + updateDTO.getOrganizationCodeID() + "</ORGANIZATIONCODE> \n" +
                "   </ORGANIZATIONID>\n" +
                "                    <DESCRIPTION>" + updateDTO.getWorkOrderDescription() + "</DESCRIPTION>\n" +
                "  </WORKORDERID>\n" +
                "  <STATUS entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <STATUSCODE>" + updateDTO.getStatus() + "</STATUSCODE> \n" +
                "  </STATUS>\n" +
                "  <EQUIPMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <EQUIPMENTCODE>" + updateDTO.getEquipmentID() + "</EQUIPMENTCODE> \n" +
                "  <ORGANIZATIONID entity=\"Organization\">\n" +
                "  <ORGANIZATIONCODE>" + updateDTO.getOrganizationCodeID() + "</ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION>DESCRIPTION2</DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION>DESCRIPTION1</DESCRIPTION> \n" +
                "  </EQUIPMENTID>\n" +
                "                <TYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                    <TYPECODE>" + updateDTO.getTypeID() + "</TYPECODE>\n" +
                "                </TYPE>\n" +
                "  <DEPARTMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <DEPARTMENTCODE>" + updateDTO.getDepartmentID() + "</DEPARTMENTCODE> \n" +
                "  </DEPARTMENTID>\n" +
                "  <FIXED xmlns=\"http://schemas.datastream.net/MP_fields\"></FIXED> \n" +
                "  </WorkOrder>\n" +
                "  </MP0025_SyncWorkOrder_001>\n" +
                "  </Body>\n" +
                "</Envelope>";
    }


    public String deleteWorkOrderBuilder(ApiUser apiUser, String serviceId) {
        return  "" +
                "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "        <MP0055_DeleteWorkOrder_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Delete\" noun=\"WorkOrder\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0055_001\">\n" +
                "            <WORKORDERID auto_generated=\"true\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                <JOBNUM>" + serviceId + "</JOBNUM>\n" +
                "                <ORGANIZATIONID entity=\"User\">\n" +
                "                    <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "                </ORGANIZATIONID>\n" +
                "            </WORKORDERID>\n" +
                "        </MP0055_DeleteWorkOrder_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

    public String getWorkOrder(ApiUser apiUser,String jobNum) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization())  +
                "    <Body>\n" +
                "        <MP0024_GetWorkOrder_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" first_activity_only=\"true\" isworkorderquickentry=\"false\" iscontractorportal=\"false\" verb=\"Get\" noun=\"WorkOrder\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0024_001\">\n" +
                "                    <WORKORDERID auto_generated=\"true\">\n" +
                "                        <JOBNUM>" + jobNum +  "</JOBNUM> \n" +
                "                        <ORGANIZATIONID entity=\"User\">\n" +
                "                            <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "                        </ORGANIZATIONID>\n" +
                "                    </WORKORDERID>\n" +
                "        </MP0024_GetWorkOrder_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

//    public String putWorkOrder(ApiUser apiUser, WorkOrder workOrder, WorkOrderSummaryUpdate workOrderSummaryUpdate) {
//        return workOrderBodyBuilder.buildBody2(apiUser,workOrder, workOrderSummaryUpdate);
//    }

//    public String getComment(ApiUser apiUser, WorkOrder workOrder) {
//        return workOrderBodyBuilder.buildBody3(apiUser,workOrder);
//    }





    public String getWorkOrderPlanedLabels(ApiUser apiUser, String jobNum, String organization, String activityCode, String tradeCode) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(),apiUser.getPassword(), apiUser.getOrganization())  +
                "    <Body>\n" +
                "        <MP5741_GetWorkOrderPlanLabor_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Get\" noun=\"WorkOrderPlanLabor\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP5741_001\">\n" +
                "            <WORKORDERPLANLABORID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "                <ACTIVITYID>\n" +
                "                    <WORKORDERID auto_generated=\"true\">\n" +
                "                        <JOBNUM>" + jobNum +  "</JOBNUM> \n" +
                "                        <ORGANIZATIONID entity=\"User\">\n" +
                "                            <ORGANIZATIONCODE>" + organization + "</ORGANIZATIONCODE>\n" +
                "                        </ORGANIZATIONID>\n" +
                "                    </WORKORDERID>\n" +
                "                    <ACTIVITYCODE auto_generated=\"false\">" + activityCode + "</ACTIVITYCODE>\n" +
                "                </ACTIVITYID>\n" +
                "                <TRADEID>\n" +
                "                    <TRADECODE>" + tradeCode + "</TRADECODE> \n" +
                "                </TRADEID>\n" +
                "            </WORKORDERPLANLABORID>\n" +
                "        </MP5741_GetWorkOrderPlanLabor_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

}
