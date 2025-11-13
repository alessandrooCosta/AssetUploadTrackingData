package com.assettec.api.integration.CLIENTES.Activity;

import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.requests.requestbuilders.common.XMLRequestHeader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivityRequestBuilder {

    private XMLRequestHeader xmlRequestHeader;

    public String postActivity(ApiUser apiUser, String OS, String ActivityCode, String Nivel, String PERSONS, String ESTIMATEDHOURS, String startDay, String startMonth, String startYear, String endDay, String endMonth, String endYear) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization()) +
                "  <Body>\n" +
                "  <MP0037_AddActivity_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Add\" noun=\"Activity\" version=\"001\" callname=\"AddActivity\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0037_001\">\n" +
                "  <Activity recordid=\"-1\" copyvmrsfields=\"false\" is_new=\"true\" has_transaction=\"has_1\" has_active_po=\"has_1\" has_active_req=\"has_1\" has_booked_hours=\"has_1\" is_ppm_act=\"is_p1\" is_warranty_claim=\"is_w1\" has_checklistitems_updated=\"false\" has_wo_act_detail_records=\"false\" has_wo_act_detail_records_including_qual=\"false\" task_has_enhanced_planning=\"false\" has_jobs_or_multiple_trades=\"false\" number_of_plan_labor_records=\"0\" xmlns=\"http://schemas.datastream.net/MP_entities/Activity_001\">\n" +
                "  <ACTIVITYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <WORKORDERID auto_generated=\"true\">\n" +
                "  <JOBNUM>" + OS + "</JOBNUM> \n" +
                "  </WORKORDERID>\n" +
                "  <ACTIVITYCODE auto_generated=\"false\">" + ActivityCode + "</ACTIVITYCODE> \n" +
                "  </ACTIVITYID>\n" +
                "  <TRADEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <TRADECODE>" + Nivel  + "</TRADECODE> \n" +
                "  <ORGANIZATIONID entity=\"Organization\">\n" +
                "  <ORGANIZATIONCODE>*</ORGANIZATIONCODE> \n" +
                "  </ORGANIZATIONID>\n" +
                "  </TRADEID> \n" +
                "  <ESTIMATEDHOURS xmlns=\"http://schemas.datastream.net/MP_fields\">" + ESTIMATEDHOURS + "</ESTIMATEDHOURS> \n" +
                "   <PERSONS xmlns=\"http://schemas.datastream.net/MP_fields\">" + PERSONS +"</PERSONS>\n" +
                "  <ACTIVITYSTARTDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + startYear + "</YEAR> \n" +
                "  <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + startMonth + "</MONTH> \n" +
                "  <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + startDay + "</DAY> \n" +
                "  <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR> \n" +
                "  <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE> \n" +
                "  <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND> \n" +
                "  <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND> \n" +
                "  <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE> \n" +
                "  </ACTIVITYSTARTDATE>\n" +
                "  <ACTIVITYENDDATE qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + endYear + "</YEAR> \n" +
                "  <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + endMonth + "</MONTH> \n" +
                "  <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + endDay + "</DAY> \n" +
                "  <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR> \n" +
                "  <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE> \n" +
                "  <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND> \n" +
                "  <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND> \n" +
                "  <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE> \n" +
                "  </ACTIVITYENDDATE>\n" +
                "  </Activity>\n" +
                "  </MP0037_AddActivity_001>\n" +
                "    </Body>\n" +
                "</Envelope>";
    }

}
