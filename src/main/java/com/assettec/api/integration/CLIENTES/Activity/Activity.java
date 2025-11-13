package com.assettec.api.integration.CLIENTES.Activity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

    private int id;
    private String code;
    private String activity;
    private String nivel;
    private String multipleNivels;
    private String persons;
    private String estimatedHours;
    private String programmingHours;
    private String description;
    private String startDate;

}
