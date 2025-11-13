package com.assettec.api.integration.CLIENTES.purchaseorder;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDetails {

    private String code;
    private String organization;
    private String description;
    private String storeCode;
    private String status;
    private String dueDate;
    private String originator;
    private String supplierCode;
    private String currency;

        public static PurchaseDetails createEmpty() {
            return new PurchaseDetails("", "", "", "", "", "", "", "", ""

            );
        }
}
