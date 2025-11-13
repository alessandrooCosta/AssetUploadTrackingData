package com.assettec.api.integration.CLIENTES.laborbook;

import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.requests.requestbuilders.common.XMLRequestHeader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class LaborBookingRequestBuilder {

    private XMLRequestHeader xmlRequestHeader;

    public String addLabor(ApiUser apiUser, String OS, String employee, String activityCode, String department, String year, String month, String day, String typeOfTime, String startHours, String startMinute, String endHours, String endMinute) {

        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization())  +
                "  <Body>\n" +
                "  <MP0042_AddLaborBooking_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Add\" noun=\"LaborBooking\" version=\"001\" callname=\"AddLaborBooking\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0042_001\">\n" +
                "  <LaborBooking recordid=\"1\" xmlns=\"http://schemas.datastream.net/MP_entities/LaborBooking_001\">\n" +
                "    <ACTIVITYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "      <WORKORDERID auto_generated=\"true\">\n" +
                "        <JOBNUM>" + OS + "</JOBNUM>\n" +
                "        <ORGANIZATIONID entity=\"User\">\n" +
                "          <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "          <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "        </ORGANIZATIONID>\n" +
                "        <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "      </WORKORDERID>\n" +
                "      <ACTIVITYCODE auto_generated=\"false\">" + activityCode + "</ACTIVITYCODE>\n" +
                "      <ACTIVITYNOTE>10</ACTIVITYNOTE>\n" +
                "    </ACTIVITYID>\n" +
                "      <TRADEID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "        <TRADECODE>*</TRADECODE>\n" +
                "        <ORGANIZATIONID entity=\"Organization\">\n" +
                "          <ORGANIZATIONCODE>*</ORGANIZATIONCODE>\n" +
                "          <DESCRIPTION>DESCRIPTION2</DESCRIPTION>\n" +
                "        </ORGANIZATIONID>\n" +
                "        <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "      </TRADEID>\n" +
                "    <DEPARTMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "      <DEPARTMENTCODE>" + department + "</DEPARTMENTCODE>\n" +
                "      <ORGANIZATIONID entity=\"Group\">\n" +
                "        <ORGANIZATIONCODE>ASSET</ORGANIZATIONCODE>\n" +
                "        <DESCRIPTION>DESCRIPTION3</DESCRIPTION>\n" +
                "      </ORGANIZATIONID>\n" +
                "      <DESCRIPTION>DESCRIPTION1</DESCRIPTION>\n" +
                "    </DEPARTMENTID>\n" +
                "    <DATEWORKED qualifier=\"ACCOUNTING\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "      <YEAR xmlns=\"http://www.openapplications.org/oagis_fields\">" + year + "</YEAR>\n" +
                "      <MONTH xmlns=\"http://www.openapplications.org/oagis_fields\">" + month +"</MONTH>\n" +
                "      <DAY xmlns=\"http://www.openapplications.org/oagis_fields\">" + day + "</DAY>\n" +
                "      <HOUR xmlns=\"http://www.openapplications.org/oagis_fields\">1</HOUR>\n" +
                "      <MINUTE xmlns=\"http://www.openapplications.org/oagis_fields\">1</MINUTE>\n" +
                "      <SECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SECOND>\n" +
                "      <SUBSECOND xmlns=\"http://www.openapplications.org/oagis_fields\">1</SUBSECOND>\n" +
                "      <TIMEZONE xmlns=\"http://www.openapplications.org/oagis_fields\">TIMEZONE1</TIMEZONE>\n" +
                "    </DATEWORKED>\n" +
                "    <OCCUPATIONTYPE xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "      <OCCUPATIONTYPECODE>" + typeOfTime +"</OCCUPATIONTYPECODE>\n" +
                "      <DESCRIPTION></DESCRIPTION>\n" +
                "    </OCCUPATIONTYPE>\n" +
                "    <EMPLOYEE xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "      <PERSONCODE>" + employee + "</PERSONCODE>\n" +
                "      <DESCRIPTION></DESCRIPTION>\n" +
                "    </EMPLOYEE>\n" +
                "    <TRADERATE qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "      <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">10</VALUE>\n" +
                "      <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">0</NUMOFDEC>\n" +
                "      <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN>\n" +
                "      <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</CURRENCY>\n" +
                "      <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">D</DRCR>\n" +
                "    </TRADERATE>\n" +
                "    <HOURSWORKED qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "      <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">1</VALUE>\n" +
                "      <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\"></NUMOFDEC>\n" +
                "      <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">-</SIGN>\n" +
                "      <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</CURRENCY>\n" +
                "      <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">D</DRCR>\n" +
                "    </HOURSWORKED>\n" +
                "    <STARTTIME qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "    <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">"+ startHours +"</VALUE> \n" +
                "    <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + startMinute + "</NUMOFDEC> \n" +
                "    <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN> \n" +
                "    <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</CURRENCY> \n" +
                "    <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">D</DRCR> \n" +
                "    </STARTTIME>\n" +
                "   <ENDTIME qualifier=\"ACTUAL\" type=\"T\" index=\"index1\" xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "   <VALUE xmlns=\"http://www.openapplications.org/oagis_fields\">" + endHours + "</VALUE> \n" +
                "   <NUMOFDEC xmlns=\"http://www.openapplications.org/oagis_fields\">" + endMinute + "</NUMOFDEC> \n" +
                "   <SIGN xmlns=\"http://www.openapplications.org/oagis_fields\">+</SIGN> \n" +
                "   <CURRENCY xmlns=\"http://www.openapplications.org/oagis_fields\">XXX</CURRENCY> \n" +
                "   <DRCR xmlns=\"http://www.openapplications.org/oagis_fields\">D</DRCR> \n" +
                "   </ENDTIME> \n" +
                "  </LaborBooking>\n" +
                "</MP0042_AddLaborBooking_001>\n" +
                "  </Body>\n" +
                "  </Envelope>";

    }


    public String getLaborBooking(ApiUser apiUser, String jobNum ) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                xmlRequestHeader.postRequestHeader(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization())  +
                "   <Body>\n" +
                "  <MP0040_GetLaborBookingDefault_001 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" verb=\"Get\" noun=\"LaborBookingDefault\" version=\"001\" callname=\"GetLaborBookingDefault\" calculate_header_fields=\"false\" xmlns=\"http://schemas.datastream.net/MP_functions/MP0040_001\">\n" +
                "  <ACTIVITYID xmlns=\"http://schemas.datastream.net/MP_fields\">\n" +
                "  <WORKORDERID auto_generated=\"true\">\n" +
                "  <JOBNUM>" +  jobNum + "</JOBNUM> \n" +
                "  </WORKORDERID>\n" +
                "  <ACTIVITYCODE auto_generated=\"false\">1</ACTIVITYCODE> \n" +
                "  </ACTIVITYID>\n" +
                "  </MP0040_GetLaborBookingDefault_001>\n" +
                "  </Body>\n" +
                "</Envelope>";
    }
}
