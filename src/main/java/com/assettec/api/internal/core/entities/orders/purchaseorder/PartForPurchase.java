package com.assettec.api.internal.core.entities.orders.purchaseorder;


import com.assettec.api.internal.core.user.info.fields.UserDefinedFields;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartForPurchase {


    private String purchaseOrderType;
    private String purchaseQuantity;
    private String purchaseUnitOfMetric;
    private String conversionFactor;
    private String partQuantity;
    private String exchangeRate;
    private String status;
    private String timeZone;
    private String price;
    private String currency;

    private LocalDateTime dueDate;
    private String lineNum;

    private UserDefinedFields userDefinedFields;

}
