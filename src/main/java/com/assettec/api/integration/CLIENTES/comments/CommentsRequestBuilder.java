package com.assettec.api.integration.CLIENTES.comments;

import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.requests.requestbuilders.common.XMLRequestHeader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentsRequestBuilder {

    private XMLRequestHeader xmlRequestHeader;


    public String addComments(ApiUser apiUser, String OS, String language, String comment, String print) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization())  +
                "    <Body>\n" +
                "  <MP0109_AddComments_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" isFromBatch=\"false\" isFromWOQuickClose=\"false\" bypassWorkOrderTypeAuthorization=\"false\" is_gis_webservice_request=\"false\" verb=\"Add\" noun=\"Comments\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0109_001\">\n" +
                "  <COMMENT recordid=\"1\" is_html_comment=\"is_h1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <ENTITYCOMMENTID>\n" +
                "  <ENTITY>EVNT</ENTITY> \n" +
                "  <COMMENTTYPE entity=\"User\">\n" +
                "  <TYPECODE>*</TYPECODE> \n" +
                "  </COMMENTTYPE>\n" +
                "  <ENTITYKEYCODE>" + OS +  "</ENTITYKEYCODE> \n" +
                "  <LANGUAGEID>\n" +
                "  <LANGUAGECODE>" + language +  "</LANGUAGECODE> \n" +
                "  </LANGUAGEID>\n" +
                "  </ENTITYCOMMENTID>\n" +
                "  <COMMENTTEXT>" + comment +  "</COMMENTTEXT> \n" +
                "  <PRINT>" + print +  "</PRINT> \n" +
                "  </COMMENT>\n" +
                "  </MP0109_AddComments_001>\n" +
                "  </Body>\n" +
                "</Envelope>";
    }

    public String getComments(ApiUser apiUser, String OS) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization())  +
                "   <Body>\n" +
                "  <MP0108_GetComments_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Get\" noun=\"Comments\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0108_001\">\n" +
                "  <CommentsReq remove_html_tags=\"false\">\n" +
                "  <ENTITY xmlns=\"http://schemas.datastream.net/MP_fields\">EVNT</ENTITY> \n" +
                "  <COMMENTTYPE entity=\"User\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <TYPECODE>*</TYPECODE> \n" +
                "  </COMMENTTYPE>\n" +
                "  <ENTITYKEYCODE xmlns=\"http://schemas.datastream.net/MP_fields\">" + OS +  "</ENTITYKEYCODE> \n" +
                "  </CommentsReq>\n" +
                "  </MP0108_GetComments_001>\n" +
                "  </Body>\n" +
                "</Envelope>";

    }

    public String updateComment(ApiUser apiUser, String OS, CommentUpdateDTO commentUpdateDTO) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "  <Body>" +
                "    <MP0110_SyncComments_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" isFromWOQuickClose=\"false\" is_gis_webservice_request=\"false\" verb=\"Sync\" noun=\"Comments\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0110_001\">" +
                "      <COMMENT recordid=\"" + commentUpdateDTO.getCommentId() + "\" is_html_comment=\"is_h1\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "        <ENTITYCOMMENTID>" +
                "          <ENTITY>EVNT</ENTITY>" +
                "          <COMMENTTYPE entity=\"User\">" +
                "            <TYPECODE>*</TYPECODE>" +
                "          </COMMENTTYPE>" +
                "          <ENTITYKEYCODE>" + OS + "</ENTITYKEYCODE>" +
                "          <LANGUAGEID>" +
                "            <LANGUAGECODE>EN</LANGUAGECODE>" +
                "          </LANGUAGEID>" +
                "          <LINENUM>1</LINENUM>" +
                "        </ENTITYCOMMENTID>" +
                "        <COMMENTTEXT>" + commentUpdateDTO.getCommentText() + "</COMMENTTEXT>" +
                "        <PRINT>false</PRINT>" +
                "      </COMMENT>" +
                "    </MP0110_SyncComments_001>" +
                "  </Body>" +
                "</Envelope>";
    }


    public String deleteCommentRequest(ApiUser apiUser, String OS, CommentData commentData) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "   <Body>\n" +
                "  <MP0111_DeleteComments_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" is_gis_webservice_request=\"false\" verb=\"Delete\" noun=\"Comments\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0111_001\">\n" +
                "  <ENTITYCOMMENTID recordid=\"" + commentData.getId() + "\" is_html_comment=\"is_h1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "      <ENTITY>EVNT</ENTITY>\n" +
                "      <COMMENTTYPE entity=\"User\">\n" +
                "        <TYPECODE>*</TYPECODE>\n" +
                "      </COMMENTTYPE>\n" +
                "      <ENTITYKEYCODE>" + OS + "</ENTITYKEYCODE>\n" +
                "      <LANGUAGEID>\n" +
                "        <LANGUAGECODE></LANGUAGECODE>\n" +
                "      </LANGUAGEID>\n" +
                "      <LINENUM>" + commentData.getId() + "</LINENUM>\n" +
                "    </ENTITYCOMMENTID>\n" +
                "  </MP0111_DeleteComments_001>\n" +
                "  </Body>\n" +
                "</Envelope>";
    }

    public String getLaborBooking(ApiUser apiUser, String jobNum ) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization())  +
                "    <Body>\n" +
                "  <MP7596_GetLaborBooking_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Get\" noun=\"LaborBooking\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP7596_001\">\n" +
                "  <BOOKEDHOURSID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <BOOKEDHOURSCODE></BOOKEDHOURSCODE> \n" +
                "  </BOOKEDHOURSID>\n" +
                "  <ACTIVITYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <WORKORDERID auto_generated=\"true\">\n" +
                "  <JOBNUM>" + jobNum +  "</JOBNUM> \n" +
                "  <ORGANIZATIONID entity=\"User\">\n" +
                "  <ORGANIZATIONCODE>ORGANIZATIONCO1</ORGANIZATIONCODE> \n" +
                "  <DESCRIPTION>DESCRIPTION1</DESCRIPTION> \n" +
                "  </ORGANIZATIONID>\n" +
                "  <DESCRIPTION>DESCRIPTION1</DESCRIPTION> \n" +
                "  </WORKORDERID>\n" +
                "  <ACTIVITYCODE auto_generated=\"false\">1</ACTIVITYCODE> \n" +
                "  <ACTIVITYNOTE>ACTIVITYNOTE1</ACTIVITYNOTE> \n" +
                "  </ACTIVITYID>\n" +
                "  </MP7596_GetLaborBooking_001>\n" +
                "  </Body>\n" +
                "</Envelope>";
    }


    public String getActivity(ApiUser apiUser, String jobNum) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "  <MP0035_GetActivity_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Get\" noun=\"Activity\" version=\"001\" callname=\"GetActivity\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0035_001\">\n" +
                "  <ACTIVITYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <WORKORDERID auto_generated=\"true\">\n" +
                "  <JOBNUM>" + jobNum + "</JOBNUM> \n" +
                "  </WORKORDERID>\n" +
                "  <ACTIVITYCODE auto_generated=\"false\">1</ACTIVITYCODE> \n" +
                "  </ACTIVITYID>\n" +
                "  </MP0035_GetActivity_001>\n" +
                "  </Body>\n" +
                "</Envelope>";
    }

    public String addActivity(ApiUser apiUser, String jobNum, String ACTIVITYCODE, String TRADECODE, String PERSONS, String ESTIMATEDHOURS) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "  <Body>\n" +
                "  <MP0037_AddActivity_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Add\" noun=\"Activity\" version=\"001\" callname=\"AddActivity\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0037_001\">\n" +
                "  <Activity recordid=\"-1\" copyvmrsfields=\"false\" is_new=\"true\" has_transaction=\"has_1\" has_active_po=\"has_1\" has_active_req=\"has_1\" has_booked_hours=\"has_1\" is_ppm_act=\"is_p1\" is_warranty_claim=\"is_w1\" has_checklistitems_updated=\"false\" has_wo_act_detail_records=\"false\" has_wo_act_detail_records_including_qual=\"false\" task_has_enhanced_planning=\"false\" has_jobs_or_multiple_trades=\"false\" number_of_plan_labor_records=\"0\" xmlns=\"http://schemas.datastream.net/MP_entities/Activity_001\">\n" +
                "  <ACTIVITYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <WORKORDERID auto_generated=\"true\">\n" +
                "  <JOBNUM>" + jobNum + "</JOBNUM> \n" +
                "  </WORKORDERID>\n" +
                "  <ACTIVITYCODE auto_generated=\"false\">" + ACTIVITYCODE + "</ACTIVITYCODE> \n" +
                "  </ACTIVITYID>\n" +
                "  </Activity>\n" +
                "  <TRADEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <TRADECODE>" + TRADECODE  + "</TRADECODE> \n" +
                "  <ORGANIZATIONID entity=\"Organization\">\n" +
                "  <ORGANIZATIONCODE>*</ORGANIZATIONCODE> \n" +
                "  </ORGANIZATIONID>\n" +
                "  </TRADEID> \n" +
                "  <ESTIMATEDHOURS xmlns=\"http://schemas.datastream.net/MP_fields\">" + ESTIMATEDHOURS + "</ESTIMATEDHOURS> \n" +
                "   <PERSONS xmlns=\"http://schemas.datastream.net/MP_fields\">" + PERSONS +"</PERSONS>\n" +
                "  <ACTIVITYSTARTDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR> \n" +
                "  <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH> \n" +
                "  <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY> \n" +
                "  <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR> \n" +
                "  <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE> \n" +
                "  <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND> \n" +
                "  <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND> \n" +
                "  <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE> \n" +
                "  </ACTIVITYSTARTDATE>\n" +
                "  <ACTIVITYENDDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">1900</YEAR> \n" +
                "  <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">1</MONTH> \n" +
                "  <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">1</DAY> \n" +
                "  <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR> \n" +
                "  <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE> \n" +
                "  <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND> \n" +
                "  <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND> \n" +
                "  <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE> \n" +
                "  </ACTIVITYENDDATE>\n" +
                "  </Activity>\n" +
                "  </MP0037_AddActivity_001>\n" +
                "  </Body>\n" +
                "</Envelope>";
    }


    public String getBooking(ApiUser apiUser) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "    <Body>\n" +
                "  <MP5809_GetLaborBooking_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Get\" noun=\"LaborBooking\" version=\"001\" xmlns=\"http://schemas.datastream.net/MP_functions/MP5809_001\">\n" +
                "  <BOOKEDHOURSID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <BOOKEDHOURSCODE>2054</BOOKEDHOURSCODE> \n" +
                "  </BOOKEDHOURSID>\n" +
                "  </MP5809_GetLaborBooking_001>\n" +
                "  </Body>\n" +
                "</Envelope>";
    }


}
