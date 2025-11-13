package com.assettec.api.internal.core.entities.orders.purchaseorder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrder {
//    private Long id;
    private int id;
    private String code;
    private String organization;
    private String description;
    private String status;
    private String currency;
    private String supplierCode;
    private String leadtime;
    private String storeCode;
    private String originatorCode;
    private String dueDateDATA;
    //

//    private String company;
    //    private String revisionNumber;
//    private String trackingNumber;
    //    private String printed;
    //    private String transmitted;
//    private String contract;
//    private String deliveryAddress;
//    private String paymentTerm;
//    private String paymentMethod;
//    private String attentionTo;
//
//    private String classCode;
//    private String classOrganization;
//    private String classDescription;
//
//    private String purchaseOrderValue;
//    private String purchaseOrderCurrency;
//    private String exchangeValue;
//    private String exchangeDecimals;
//    private String exchangeCurrency;
//    private String discountValue;
//    private String discountCurrency;
//    private String taxAmountValue;
//    private String taxAmountCurrency;
//    private String extraValue;
//    private String extraCurrency;
//    private String orderDateTimeZone;
//    private String dueDateTimeZone;
//    private String approveDateTimeZone;
//
//    private List<PartForPurchase> partsForPurchase = new ArrayList<>();
//
//    private Employee employee;
//    private Employee originator;
//    private Supplier supplier;
//    private Store store;
//    private Buyer buyer;
//    private Authorizer authorizer;
//
//    private UserDefinedArea userDefinedArea;
//    private UserDefinedFields userDefinedFields;
//
//    private LocalDateTime orderDate;
//    private LocalDateTime dueDate;
//    private LocalDateTime approveDate;
//    private int updateCount;
//    private String OrderTerm;
//    private Employee defaultApprover;
//    private String shipViaCode;
//    private String shipViaOrganization;
//    private String fobPointCode;
//    private String fobPointOrganization;
//    private String freightTermCode;
//    private String freightTermOrganization;
//
//    private String numberOfPartLines;

//    public static PurchaseOrder createEmpty() {
//        return new PurchaseOrder("", "", "", "", "", "", "", "", "", ""
//         );
//    }

}
