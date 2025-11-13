package com.assettec.api.internal.core.entities.asset.common.objects;

import com.assettec.api.internal.core.entities.basic.objects.Id.Id;
import com.assettec.api.internal.core.entities.basic.objects.InforEamCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentalDetails {
    private InforEamCode vehicleType;
    private String isRental;
    private Id rentalTemplateId;
    private String isContract;
    private Id contractTemplateId;
    private Id customerId;
    private InforEamCode availabilityStatus;
    private InforEamCode issueTo;
}
