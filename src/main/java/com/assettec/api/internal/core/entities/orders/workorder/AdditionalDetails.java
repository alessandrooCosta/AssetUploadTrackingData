package com.assettec.api.internal.core.entities.orders.workorder;

import com.assettec.api.internal.core.entities.basic.objects.Id.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalDetails {
    private Id relatedWorkOrderId;
    private String objType;
    private Id departmentid;
    private Id locationId;
    private Id costCodeId;
    private String safety;
    private String warranty;
    private int updatedCount;

    public String buildRequest() {

        String relatedWorkOrder = relatedWorkOrderId == null ? "" : "<RELATEDWORKORDERID auto_generated=\"true\" xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<JOBNUM>" + relatedWorkOrderId.getCode() + "</JOBNUM>" +
                relatedWorkOrderId.buildOrganizationRequestString("<ORGANIZATIONID entity=\"PartStoresDefault\">","</ORGANIZATIONID>") +
                "<DESCRIPTION>" + relatedWorkOrderId.getDescription() + "</DESCRIPTION>" +
                "</RELATEDWORKORDERID>";

        String department = departmentid == null ? "" : "<DEPARTMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<DEPARTMENTCODE>" + departmentid.getCode() + "</DEPARTMENTCODE>" +
                departmentid.buildOrganizationRequestString("<ORGANIZATIONID entity=\"Warranty\">","</ORGANIZATIONID>") +
                "<DESCRIPTION>" + departmentid.getDescription() + "</DESCRIPTION>" +
                "</DEPARTMENTID>";

        String location = locationId == null ? "" : "<LOCATIONID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<LOCATIONCODE>" + locationId.getCode() + "</LOCATIONCODE>" +
                locationId.buildOrganizationRequestString("<ORGANIZATIONID entity=\"WarrantyDefault\">","</ORGANIZATIONID>") +
                "<DESCRIPTION>" + locationId.getDescription() + "</DESCRIPTION>" +
                "</LOCATIONID>";

        String costCode = costCodeId == null ? "" : "<COSTCODEID xmlns=\"http://schemas.datastream.net/MP_fields\">" +
                "<COSTCODE>" + costCodeId.getCode() + "</COSTCODE>" +
                "<DESCRIPTION>" + costCodeId.getDescription() + "</DESCRIPTION>" +
                costCodeId.buildOrganizationRequestString("<ORGANIZATIONID entity=\"Catalogue\">","</ORGANIZATIONID>") +
                "</COSTCODEID>";

        String objTypeString = objType == null || objType.isEmpty() ? "" : "<OBJTYPE xmlns=\"http://schemas.datastream.net/MP_fields\">" + objType + "</OBJTYPE>";
        String safetyString = safety == null || safety.isEmpty() ? "" : "<SAFETY xmlns=\"http://schemas.datastream.net/MP_fields\">" + safety + "</SAFETY>";
        String warrantyString = warranty == null || warranty.isEmpty() ? "" : "<WARRANTY xmlns=\"http://schemas.datastream.net/MP_fields\">" + warranty + "</WARRANTY>";



        return "<AdditionalDetails recordid=\"" + updatedCount + "\">" +
                relatedWorkOrder +
                objTypeString +
                department +
                location +
                costCode +
                safetyString +
                warrantyString +
                "</AdditionalDetails>";
    }
}
