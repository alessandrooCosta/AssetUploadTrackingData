package com.assettec.api.integration.CLIENTES.purchaseorder;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssetSendPurchaseOrder {

    private String purchaseOrderCode;
    private String purchaseOrderDescription;
    private String purchaseOrderOrganization;
    private String purchaseOrderClass;

    private LocalDateTime purchaseOrderCreatedDate;
    private LocalDateTime purchaseOrderDueDate;
    private String purchaseOriginator;
    private String supplierCode;
    private String storeCode;
    private String purchasePaymentTerm;
    private String purchasePaymentMethod;


}
