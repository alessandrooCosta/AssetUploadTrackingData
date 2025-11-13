package com.assettec.api.integration.CLIENTES.maptronic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkOrderUpdateDTO {
    private String workOrderDescription;
    private String organizationCodeID;
    private String equipmentID;
    private String status;
    private String typeID;
    private String departmentID;

    // Getters and setters
}
