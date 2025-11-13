package com.assettec.api.integration.CLIENTES.laborbook;

import com.assettec.api.internal.core.grid.DataSpy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GridDataLaborBooking {

        private DataSpy currentDataspy;
        private List<LaborBooking> laborBookingList;
    }


