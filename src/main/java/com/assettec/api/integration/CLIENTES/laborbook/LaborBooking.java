package com.assettec.api.integration.CLIENTES.laborbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LaborBooking {

    private int id;
    private String code; // boo_code
    private String OS; // workordernum
    private String activity; // boo_act
    private String description; //boo_desc
    private String nivel; //BOO_TRADE
    private String funcionario; //boo_person
    private String department;  //boo_mrc
    private String date; //  boo_date (Dia Trabalhado)
    private String typeHours; //  boo_octype (Tipo de Hora)
    private String workHours; // boo_hours (Horas Trabalhadas)
    private String taxa; // boo_rate




}
