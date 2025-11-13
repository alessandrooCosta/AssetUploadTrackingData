package com.assettec.api.integration.CLIENTES.purchaseorder;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssetPurchaseOrder {


    private String code;
    private String organization;
    private String description;

    private String currency;
    private String status;
    private String statusDescription;

    private String supplierCode;
    private String supplierOrganization;
    private String supplierDescription;
    private String buyerCode;
    private String buyerDescription;
    private String storeCode;
    private String originatorCode;
    private String originatorDescription;
    private String dueDateDATA;

    private String type;
    private String typeDescription;


//    private String paymentTerm;
//    private String paymentMethod;


//    private LocalDateTime createdDate;
//    private LocalDateTime dueDate;

    public static AssetPurchaseOrder createEmpty() {
        return new AssetPurchaseOrder("", "", "", "", "", "", "", "", "", "", "", "", "", "",
                "","","");
    }


    }
