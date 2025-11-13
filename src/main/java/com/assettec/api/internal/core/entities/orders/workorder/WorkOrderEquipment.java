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
public class WorkOrderEquipment {
    private Id workOrderId;
    private Id equipmentId;
    private AdditionalDetails additionalDetails;

    public String buildRequest(String upper, String lower) {

        String workOrderId = getWorkOrderId() == null ? "" : getWorkOrderId().buildRequest("<WORKORDERID auto_generated=\"true\" xmlns=\"http://schemas.datastream.net/MP_fields\">","</WORKORDERID>","<ORGANIZATIONID entity=\"EquipmentCategory\">","</ORGANIZATIONID>","JOBNUM","DESCRIPTION","ORGANIZATIONCODE","DESCRIPTION");
        String equipmentId = getEquipmentId() == null ? "" : getEquipmentId().buildRequest("<EQUIPMENTID xmlns=\"http://schemas.datastream.net/MP_fields\">","</EQUIPMENTID>","<ORGANIZATIONID entity=\"EquipmentCategoryDefault\">","</ORGANIZATIONID>","EQUIPMENTCODE","DESCRIPTION","ORGANIZATIONCODE","DESCRIPTION");
        String additionalDetails = getAdditionalDetails() == null ? "" :  getAdditionalDetails().buildRequest();

        return upper + workOrderId + equipmentId + additionalDetails + lower;
    }
}
