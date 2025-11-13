package com.assettec.api.integration.CLIENTES.Activity;

import com.assettec.api.integration.CLIENTES.laborbook.LaborBooking;
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
public class GridDataActivity {
        private DataSpy currentDataspy;
        private List<Activity> activityOrderList;

    }
