package com.assettec.api.integration.CLIENTES.maptronic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateWorkOrderRequest {
    private String description;
    private String status;
    private String equipmentCode;
    private String workOrderOrganization;
    private String equipmentOrganization;
    private String department;
    private String type;

    // Getters e setters
}
