package com.assettec.api.internal.core.entities.orders.purchaseorder.utilities;

import com.assettec.api.internal.core.user.info.area.UserDefinedAreaSetter;
import com.assettec.api.internal.core.user.info.fields.UserDefinedFieldsSetter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PurchaseOrderSetter {

    private UserDefinedFieldsSetter userDefinedFieldsSetter;
    private UserDefinedAreaSetter userDefinedAreaSetter;

//    public void setUserDefinedFields(Document xmlData, PurchaseOrder purchaseOrder) {
//        NodeList userDefinedFieldsList = xmlData.getElementsByTagName("UserDefinedFields");
//        NodeList userDefinedFields = userDefinedFieldsList.getLength() != 0 ? userDefinedFieldsList.item(0).getChildNodes() : userDefinedFieldsList;
//
//        purchaseOrder.setUserDefinedFields(userDefinedFieldsSetter.setUserDefinedFields(userDefinedFields));
//    }
//
//    public void setUserDefinedArea(Document xmlData, PurchaseOrder purchaseOrder) {
//        NodeList userDefinedAreaList = xmlData.getElementsByTagName("USERDEFINEDAREA");
//        NodeList customFieldList = userDefinedAreaList.getLength() != 0 ? userDefinedAreaList.item(0).getChildNodes() : userDefinedAreaList;
//
//        purchaseOrder.setUserDefinedArea(userDefinedAreaSetter.setUserDefinedArea(customFieldList));
//    }
//
//    public void setApproveDate(Document xmlData, PurchaseOrder purchaseOrder) {
//        NodeList approveDate = xmlData.getElementsByTagName("APPROVEDATE");
//        int approveDateYear = approveDate.getLength() != 0 ? Integer.parseInt(approveDate.item(0).getChildNodes().item(0).getTextContent()) : -120;
//        int approveDateMonth = approveDate.getLength() != 0 ? Integer.parseInt(approveDate.item(0).getChildNodes().item(1).getTextContent()) : -120;
//        int approveDateDay = approveDate.getLength() != 0 ? Integer.parseInt(approveDate.item(0).getChildNodes().item(2).getTextContent()) : -120;
//        int approveDateHour = approveDate.getLength() != 0 ? Integer.parseInt(approveDate.item(0).getChildNodes().item(3).getTextContent()) : -120;
//        int approveDateMinute = approveDate.getLength() != 0 ? Integer.parseInt(approveDate.item(0).getChildNodes().item(4).getTextContent()) : -120;
//        int approveDateSecond = approveDate.getLength() != 0 ? Integer.parseInt(approveDate.item(0).getChildNodes().item(5).getTextContent()) : -120;
//        int approveDateSubsecond = approveDate.getLength() != 0 ? Integer.parseInt(approveDate.item(0).getChildNodes().item(6).getTextContent()) : -120;
//        String approveDateTimeZone = approveDate.getLength() != 0 ? approveDate.item(0).getChildNodes().item(7).getTextContent() : null;
//
//        if (approveDateSubsecond != -120) {
//            LocalDateTime approveDate1 = LocalDateTime.of(approveDateYear, approveDateMonth, approveDateDay, approveDateHour, approveDateMinute, approveDateSecond, approveDateSubsecond);
//            purchaseOrder.setApproveDate(approveDate1);
//            purchaseOrder.setApproveDateTimeZone(approveDateTimeZone);
//        }
//    }
//
//    public void setOrderDate(Document xmlData, PurchaseOrder purchaseOrder) {
//        Node orderDate = xmlData.getElementsByTagName("ORDERDATE").item(0);
//        NodeList orderDateChildNodes = orderDate.getChildNodes();
//        int orderDateYear = Integer.parseInt(orderDateChildNodes.item(0).getTextContent());
//        int orderDateMonth = Integer.parseInt(orderDateChildNodes.item(1).getTextContent());
//        int orderDateDay = Integer.parseInt(orderDateChildNodes.item(2).getTextContent());
//        int orderDateHour = Integer.parseInt(orderDateChildNodes.item(3).getTextContent());
//        int orderDateMinute = Integer.parseInt(orderDateChildNodes.item(4).getTextContent());
//        int orderDateSecond = Integer.parseInt(orderDateChildNodes.item(5).getTextContent());
//        int orderDateSubSecond = Integer.parseInt(orderDateChildNodes.item(6).getTextContent());
//        String orderDateTimeZone = orderDateChildNodes.item(7).getTextContent();
//
//        LocalDateTime orderDate1 = LocalDateTime.of(orderDateYear, orderDateMonth, orderDateDay, orderDateHour, orderDateMinute, orderDateSecond, orderDateSubSecond);
//        purchaseOrder.setOrderDate(orderDate1);
//        purchaseOrder.setOrderDateTimeZone(orderDateTimeZone);
//    }
//
//    public void setDueDate(Document xmlData, PurchaseOrder purchaseOrder) {
//        Node dueDate = xmlData.getElementsByTagName("DUEDATE").item(0);
//        NodeList dueDateChildNodes = dueDate.getChildNodes();
//        int dueDateYear = Integer.parseInt(dueDateChildNodes.item(0).getTextContent());
//        int dueDateMonth = Integer.parseInt(dueDateChildNodes.item(1).getTextContent());
//        int dueDateDay = Integer.parseInt(dueDateChildNodes.item(2).getTextContent());
//        int dueDateHour = Integer.parseInt(dueDateChildNodes.item(3).getTextContent());
//        int dueDateMinute = Integer.parseInt(dueDateChildNodes.item(4).getTextContent());
//        int dueDateSecond = Integer.parseInt(dueDateChildNodes.item(5).getTextContent());
//        int dueDateSubsecond = Integer.parseInt(dueDateChildNodes.item(6).getTextContent());
//        String dueDateTimeZone = dueDateChildNodes.item(7).getTextContent();
//
//        LocalDateTime dueDate1 = LocalDateTime.of(dueDateYear, dueDateMonth, dueDateDay, dueDateHour, dueDateMinute, dueDateSecond, dueDateSubsecond);
//        purchaseOrder.setDueDate(dueDate1);
//        purchaseOrder.setDueDateTimeZone(dueDateTimeZone);
//    }
//
//    public void setTotalExtra(Document xmlData, PurchaseOrder purchaseOrder) {
//        NodeList totalExtra = xmlData.getElementsByTagName("TOTALEXTRA");
//        String totalExtraValue = totalExtra.item(0).getFirstChild().getTextContent();
//        String totalExtraDecimals = totalExtra.item(0).getChildNodes().item(1).getTextContent();
//        String totalExtraCurrency = totalExtra.item(0).getChildNodes().item(3).getTextContent();
//
//        purchaseOrder.setExtraValue(String.valueOf(Long.parseLong(totalExtraValue) / Math.pow(10, Byte.parseByte(totalExtraDecimals))));
//        purchaseOrder.setExtraCurrency(totalExtraCurrency);
//    }
//
//    public void setTotalTax(Document xmlData, PurchaseOrder purchaseOrder) {
//        NodeList totalTaxAmount = xmlData.getElementsByTagName("TOTALTAXAMOUNT");
//        String totalTaxValue = totalTaxAmount.item(0).getFirstChild().getTextContent();
//        String totalTaxDecimals = totalTaxAmount.item(0).getChildNodes().item(1).getTextContent();
//        String totalTaxCurrency = totalTaxAmount.item(0).getChildNodes().item(3).getTextContent();
//
//        purchaseOrder.setTaxAmountValue(String.valueOf(Long.parseLong(totalTaxValue) / Math.pow(10, Byte.parseByte(totalTaxDecimals))));
//        purchaseOrder.setTaxAmountCurrency(totalTaxCurrency);
//    }
//
//    @SneakyThrows
//    public void setOriginator(Document xmlData, PurchaseOrder purchaseOrder) {
//        NodeList originator = xmlData.getElementsByTagName("ORIGINATOR");
//        String personCode = originator.item(0).getFirstChild().getTextContent();
//        String personName = originator.item(0).getLastChild().getTextContent();
//
//        Employee employee;
//
//        if (purchaseOrder.getOriginator() == null) {
//            employee = new Employee();
//        } else {
//            employee = purchaseOrder.getEmployee();
//        }
//        employee.setCode(personCode);
//        employee.setName(personName);
//
//        purchaseOrder.setOriginator(employee);
//    }
//
//    @SneakyThrows
//    public void setAuthorizer(Document xmlData, PurchaseOrder purchaseOrder) {
//        NodeList authorizer = xmlData.getElementsByTagName("AUTHORIZER");
//        String authCode = authorizer.getLength() != 0 ? authorizer.item(0).getFirstChild().getTextContent() : "";
//        String authDescription = authorizer.getLength() != 0 ? authorizer.item(0).getLastChild().getTextContent() : "";
//
//        Authorizer authorizer1;
//        if (purchaseOrder.getAuthorizer() == null) {
//            authorizer1 = new Authorizer();
//        } else {
//            authorizer1 = purchaseOrder.getAuthorizer();
//        }
//        authorizer1.setCode(authCode);
//        authorizer1.setDescription(authDescription);
//        purchaseOrder.setAuthorizer(authorizer1);
//    }
//
//    public void setType(Document xmlData, PurchaseOrder purchaseOrder) {
//        NodeList type = xmlData.getElementsByTagName("TYPE");
//        String typeCode = type.item(0).getFirstChild().getTextContent();
//        purchaseOrder.setType(typeCode);
//    }
//
//    public void setPrintedTransmitted(Document xmlData, PurchaseOrder purchaseOrder) {
//        String printed = xmlData.getElementsByTagName("PRINTED").item(0).getTextContent();
//        String transmitted = xmlData.getElementsByTagName("TRANSMITTED").item(0).getTextContent();
//
//        purchaseOrder.setPrinted(printed);
//        purchaseOrder.setTransmitted(transmitted);
//    }
//
//    public void setContractDeliveryAddress(Document xmlData, PurchaseOrder purchaseOrder) {
//        NodeList deliveryAddress = xmlData.getElementsByTagName("DELADDRESSCODE");
//        String deliveryAddressCode = deliveryAddress.getLength() != 0 ? deliveryAddress.item(0).getTextContent() : "";
//        purchaseOrder.setDeliveryAddress(deliveryAddressCode);
//
//        NodeList contract = xmlData.getElementsByTagName("CONTRACTCODE");
//        String contractCode = contract.getLength() != 0 ? contract.item(0).getTextContent() : "";
//        purchaseOrder.setContract(contractCode);
//    }
//
//    @SneakyThrows
//    public void setBuyer(Document xmlData, PurchaseOrder purchaseOrder) {
//        NodeList buyer = xmlData.getElementsByTagName("BUYER");
//        String buyerCode = buyer.getLength() != 0 ? buyer.item(0).getFirstChild().getTextContent() : "";
//        String buyerDescription = buyer.getLength() != 0 ? buyer.item(0).getLastChild().getTextContent() : "";
//
//        Buyer orderBuyer;
//        if (purchaseOrder.getBuyer() == null) {
//            orderBuyer = new Buyer();
//        } else orderBuyer = purchaseOrder.getBuyer();
//
//        orderBuyer.setCode(buyerCode);
//        orderBuyer.setDescription(buyerDescription);
//
//        purchaseOrder.setBuyer(orderBuyer);
//    }
//
//    public void setDiscount(Document xmlData, PurchaseOrder purchaseOrder) {
//        NodeList discount = xmlData.getElementsByTagName("DISCOUNT");
//        String discountValue = discount.getLength() != 0 ? discount.item(0).getFirstChild().getTextContent() : "";
//        String discountDecimals = discount.getLength() != 0 ? discount.item(0).getChildNodes().item(1).getTextContent() : "";
//        String discountCurrency = discount.getLength() != 0 ? discount.item(0).getChildNodes().item(3).getTextContent() : "";
//
//        purchaseOrder.setDiscountValue(!Objects.equals(discountValue, "") || !Objects.equals(discountDecimals, "")
//                ? String.valueOf(Long.parseLong(Objects.requireNonNull(discountValue)) / Math.pow(10, Byte.parseByte(Objects.requireNonNull(discountDecimals)))) : "");
//        purchaseOrder.setDiscountCurrency(discountCurrency);
//    }
//
//    public void setExchange(Document xmlData, PurchaseOrder purchaseOrder) {
//        Node exchange = xmlData.getElementsByTagName("EXCHANGE").item(0);
//        String exchangeValue = exchange.getFirstChild().getTextContent();
//        String exchangeDecimals = exchange.getChildNodes().item(1).getTextContent();
//        String exchangeCurrency = exchange.getChildNodes().item(3).getTextContent();
//
//        purchaseOrder.setExchangeValue(exchangeValue);
//        purchaseOrder.setExchangeDecimals(exchangeDecimals);
//        purchaseOrder.setExchangeCurrency(exchangeCurrency);
//    }
//
//    @SneakyThrows
//    public void setSupplier(Document xmlData, PurchaseOrder purchaseOrder) {
//        Node supplierId = xmlData.getElementsByTagName("SUPPLIERID").item(0);
//        String supplierCode = supplierId.getFirstChild().getTextContent();
//        String supplierOrganization = supplierId.getChildNodes().item(1).getTextContent();
//        String supplierDescription = supplierId.getChildNodes().item(2).getTextContent();
//
//        NodeList languageNode = xmlData.getElementsByTagName("SUPPLIERINFO");
//        String language = languageNode.getLength() != 0 ? languageNode.item(0).getChildNodes().item(0).getFirstChild().getTextContent() : "";
//
//        Supplier supplier;
//
//        if (purchaseOrder.getSupplier() == null) {
//            supplier = new Supplier();
//        } else supplier = purchaseOrder.getSupplier();
//
//        supplier.setCode(supplierCode);
//        supplier.setOrganization(supplierOrganization);
//        supplier.setDescription(supplierDescription);
//        supplier.setLanguage(language);
//
//        purchaseOrder.setSupplier(supplier);
//    }
//
//
//    @SneakyThrows
//    public void setStore(Document xmlData, PurchaseOrder purchaseOrder) {
//        NodeList storeId = xmlData.getElementsByTagName("STOREID");
//        String storeCode = storeId.item(0).getFirstChild().getTextContent();
//        String storeDescription = storeId.item(0).getLastChild().getTextContent();
//
//        Store store;
//        if (purchaseOrder.getStore() == null) {
//            store = new Store();
//            store.setCode(storeCode);
//        } else {
//            store = purchaseOrder.getStore();
//            if (!Objects.equals(store.getCode(), storeCode)) store.setCode(storeCode);
//        }
//        store.setDescription(storeDescription);
//        purchaseOrder.setStore(store);
//    }
//
//    public void setPartForPurchase(Document xmlData, PurchaseOrder purchaseOrder, String lineNum) {
//        String partCode = xmlData.getElementsByTagName("PARTCODE").item(0).getTextContent();
//        String partOrganization = xmlData.getElementsByTagName("PARTID").item(0).getChildNodes().item(1).getTextContent();
//        String partDescription = xmlData.getElementsByTagName("PARTID").item(0).getChildNodes().item(2).getTextContent();
//
//        String purchaseOrderType = xmlData.getElementsByTagName("PURCHASEORDERTYPE").item(0).getTextContent();
//        String purchaseOrderQuantityValue = xmlData.getElementsByTagName("PURCHASEQTY").item(0).getChildNodes().item(0).getTextContent();
//        String purchaseOrderQuantityDecimals = xmlData.getElementsByTagName("PURCHASEQTY").item(0).getChildNodes().item(1).getTextContent();
//
//        String purchaseOrderUnitOfMetric = xmlData.getElementsByTagName("PURCHASEUOM").item(0).getTextContent();
//
//        String conversionFactorValue = xmlData.getElementsByTagName("CONVERSIONFACTOR").item(0).getChildNodes().item(0).getTextContent();
//        String conversionFactorDecimals = xmlData.getElementsByTagName("CONVERSIONFACTOR").item(0).getChildNodes().item(1).getTextContent();
//
//        String status = xmlData.getElementsByTagName("STATUS").item(0).getTextContent();
//
//        String partQuantityValue = xmlData.getElementsByTagName("PARTQUANTITY").item(0).getChildNodes().item(0).getTextContent();
//        String partQuantityDecimals = xmlData.getElementsByTagName("PARTQUANTITY").item(0).getChildNodes().item(1).getTextContent();
//
//        String partUnitOfMetric = xmlData.getElementsByTagName("PARTUOM").item(0).getTextContent();
//
//        String dueDateYear = xmlData.getElementsByTagName("DUEDATE").item(0).getChildNodes().item(0).getTextContent();
//        String dueDateMonth = xmlData.getElementsByTagName("DUEDATE").item(0).getChildNodes().item(1).getTextContent();
//        String dueDateDay = xmlData.getElementsByTagName("DUEDATE").item(0).getChildNodes().item(2).getTextContent();
//        String dueDateHour = xmlData.getElementsByTagName("DUEDATE").item(0).getChildNodes().item(3).getTextContent();
//        String dueDateMinute = xmlData.getElementsByTagName("DUEDATE").item(0).getChildNodes().item(4).getTextContent();
//        String dueDateSecond = xmlData.getElementsByTagName("DUEDATE").item(0).getChildNodes().item(5).getTextContent();
//        String dueDateSubSecond = xmlData.getElementsByTagName("DUEDATE").item(0).getChildNodes().item(6).getTextContent();
//
//        String priceValue = xmlData.getElementsByTagName("PRICE").item(0).getChildNodes().item(0).getTextContent();
//        String priceDecimals = xmlData.getElementsByTagName("PRICE").item(0).getChildNodes().item(1).getTextContent();
//
//        String currency = xmlData.getElementsByTagName("CURRENCYID").item(0).getTextContent();
//
//        String exchangeRateValue = xmlData.getElementsByTagName("EXCHRATE").item(0).getChildNodes().item(0).getTextContent();
//        String exchangeRateDecimals = xmlData.getElementsByTagName("EXCHRATE").item(0).getChildNodes().item(1).getTextContent();
//
//        Part part = new Part();
//        part.setCode(partCode);
//        part.setOrganization(partOrganization);
//        part.setDescription(partDescription);
//        part.setUnitOfMetric(partUnitOfMetric);
//
//        PartForPurchase partForPurchase = new PartForPurchase();
//        partForPurchase.setPart(part);
//        partForPurchase.setStatus(status);
//        partForPurchase.setPurchaseOrderType(purchaseOrderType);
//        partForPurchase.setCurrency(currency);
//        partForPurchase.setPurchaseQuantity(String.valueOf(Long.parseLong(purchaseOrderQuantityValue) / Math.pow(10, Double.parseDouble(purchaseOrderQuantityDecimals))));
//        partForPurchase.setConversionFactor(String.valueOf(Long.parseLong(conversionFactorValue) / Math.pow(10, Double.parseDouble(conversionFactorDecimals))));
//        partForPurchase.setPartQuantity(String.valueOf(Long.parseLong(partQuantityValue) / Math.pow(10, Double.parseDouble(partQuantityDecimals))));
//        partForPurchase.setDueDate(LocalDateTime.of(Integer.parseInt(dueDateYear), Integer.parseInt(dueDateMonth), Integer.parseInt(dueDateDay), Integer.parseInt(dueDateHour), Integer.parseInt(dueDateMinute), Integer.parseInt(dueDateSecond), Integer.parseInt(dueDateSubSecond)));
//        partForPurchase.setPurchaseUnitOfMetric(purchaseOrderUnitOfMetric);
//        partForPurchase.setExchangeRate(String.valueOf(Long.parseLong(exchangeRateValue) / Math.pow(10, Double.parseDouble(exchangeRateDecimals))));
//        partForPurchase.setPrice(String.valueOf(Long.parseLong(priceValue) / Math.pow(10, Double.parseDouble(priceDecimals))));
//        partForPurchase.setLineNum(lineNum);
//
//        NodeList parentNode = xmlData.getElementsByTagName("UserDefinedFields");
//        NodeList childNodes = parentNode.getLength() != 0 ? parentNode.item(0).getChildNodes() : parentNode;
//
//        partForPurchase.setUserDefinedFields(userDefinedFieldsSetter.setUserDefinedFields(childNodes));
//
//        purchaseOrder.getPartsForPurchase().add(partForPurchase);
//    }
//
//    @SneakyThrows
//    public void setBasicData(Document xmlData, PurchaseOrder purchaseOrder) {
//
//        purchaseOrder.setCode(xmlData.getElementsByTagName("PURCHASEORDERCODE").getLength() != 0 ? xmlData.getElementsByTagName("PURCHASEORDERCODE").item(0).getTextContent() : "");
//        purchaseOrder.setOrganization(xmlData.getElementsByTagName("PURCHASEORDERID").getLength() != 0 ? xmlData.getElementsByTagName("PURCHASEORDERID").item(0).getChildNodes().item(1).getTextContent() : "");
//        purchaseOrder.setDescription(xmlData.getElementsByTagName("PURCHASEORDERID").getLength() != 0 ? xmlData.getElementsByTagName("PURCHASEORDERID").item(0).getLastChild().getTextContent() : "");
//        purchaseOrder.setStatus(xmlData.getElementsByTagName("STATUSCODE").getLength() != 0 ? xmlData.getElementsByTagName("STATUSCODE").item(0).getTextContent() : "");
//        purchaseOrder.setRevisionNumber(xmlData.getElementsByTagName("POREVISION").getLength() != 0 ? xmlData.getElementsByTagName("POREVISION").item(0).getTextContent() : "");
//        purchaseOrder.setTrackingNumber(xmlData.getElementsByTagName("PACKAGETRACKINGNUMBER").getLength() != 0 ? xmlData.getElementsByTagName("PACKAGETRACKINGNUMBER").item(0).getTextContent() : "");
//        purchaseOrder.setCurrency(xmlData.getElementsByTagName("CURRENCYCODE").getLength() != 0 ? xmlData.getElementsByTagName("CURRENCYCODE").item(0).getTextContent() : "");
//        purchaseOrder.setNumberOfPartLines(xmlData.getElementsByTagName("no_of_partlines").getLength() != 0 ? xmlData.getElementsByTagName("no_of_partlines").item(0).getTextContent() : "");
//    }
//
//    public void setPurchaseOrderValue(Document xmlData, PurchaseOrder purchaseOrder) {
//        NodeList purchaseOrderNode = xmlData.getElementsByTagName("PURCHASEORDERVALUE");
//        int length = purchaseOrderNode.getLength();
//
//        if (length != 0) {
//            long value = Long.parseLong(purchaseOrderNode.item(0).getFirstChild().getTextContent());
//            int decimals = Integer.parseInt(purchaseOrderNode.item(0).getChildNodes().item(1).getTextContent());
//            double realValue = value/Math.pow(10,decimals);
//
//            purchaseOrder.setPurchaseOrderValue(String.valueOf(realValue));
//            purchaseOrder.setPurchaseOrderCurrency(purchaseOrderNode.item(0).getChildNodes().item(3).getTextContent());
//        }
//    }
//
//    public void setPaymentTermAndMethod(Document xmlData, PurchaseOrder purchaseOrder) {
//        NodeList paymentTermNode = xmlData.getElementsByTagName("PAYMENTTERM");
//        String paymentTerm = paymentTermNode.getLength() != 0 ? paymentTermNode.item(0).getFirstChild().getFirstChild().getTextContent() : "";
//
//        NodeList paymentMethodNode = xmlData.getElementsByTagName("PAYBYMETHOD");
//        String paymentMethod = paymentMethodNode.getLength() != 0 ? paymentMethodNode.item(0).getFirstChild().getFirstChild().getTextContent() : "";
//
//        purchaseOrder.setPaymentTerm(paymentTerm);
//        purchaseOrder.setPaymentMethod(paymentMethod);
//    }
//
//    public void setAttentionTo(Document xmlData, PurchaseOrder purchaseOrder) {
//        NodeList attentionToNodeList = xmlData.getElementsByTagName("ATTENTIONTO");
//        String attentionTo = attentionToNodeList.getLength() != 0 ? attentionToNodeList.item(0).getTextContent() : "";
//
//        purchaseOrder.setAttentionTo(attentionTo);
//    }
//
//    public void setOrderTermShipViaAndFreightTerm(Document xmlData, PurchaseOrder purchaseOrder) {
//
//        NodeList defaultApproverNode = xmlData.getElementsByTagName("DEFAULTAPPROVER");
//        String defaultApproverCode = defaultApproverNode.getLength() != 0 ? defaultApproverNode.item(0).getFirstChild().getTextContent() : "";
//        String defaultApproverDescription = defaultApproverNode.getLength() != 0 ? defaultApproverNode.item(0).getLastChild().getTextContent() : "";
//
//        NodeList shipviaNode = xmlData.getElementsByTagName("SHIPVIA");
//        String  shipviaMethod = shipviaNode.getLength() != 0 ? shipviaNode.item(0).getFirstChild().getFirstChild().getTextContent() : "";
//        String shipviaOrganization = shipviaNode.getLength() != 0 ? shipviaNode.item(0).getFirstChild().getChildNodes().item(1).getFirstChild().getTextContent() : "";
//
//
//        NodeList fobPointNode = xmlData.getElementsByTagName("FOBPOINT");
//        String fobPointMethod = fobPointNode.getLength() != 0 ? fobPointNode.item(0).getFirstChild().getFirstChild().getTextContent() : "";
//        String fobPointOrganization = fobPointNode.getLength() != 0 ? fobPointNode.item(0).getFirstChild().getChildNodes().item(1).getFirstChild().getTextContent() : "";
//
//
//        NodeList freighttermNode = xmlData.getElementsByTagName("FREIGHTTERM");
//        String freighttermtMethod = freighttermNode.getLength() != 0 ? freighttermNode.item(0).getFirstChild().getFirstChild().getTextContent() : "";
//        String freghtTermOrganization = freighttermNode.getLength() != 0 ? freighttermNode.item(0).getFirstChild().getChildNodes().item(1).getFirstChild().getTextContent() : "";
//
//
//        Employee defaultApprover = new Employee();
//        defaultApprover.setCode(defaultApproverCode);
//        defaultApprover.setName(defaultApproverDescription);
//
//        purchaseOrder.setEmployee(defaultApprover);
//        purchaseOrder.setShipViaCode(shipviaMethod);
//        purchaseOrder.setShipViaOrganization(shipviaOrganization);
//        purchaseOrder.setFobPointCode(fobPointMethod);
//        purchaseOrder.setFobPointOrganization(fobPointOrganization);
//        purchaseOrder.setFreightTermCode(freighttermtMethod);
//        purchaseOrder.setFreightTermOrganization(freghtTermOrganization);
//    }
//
//    public void setClass(Document xmlData, PurchaseOrder purchaseOrder) {
//        NodeList classIdNodeList = xmlData.getElementsByTagName("CLASSID");
//
//        if (classIdNodeList.getLength() == 0) {
//            purchaseOrder.setClassCode("");
//            purchaseOrder.setClassDescription("");
//            purchaseOrder.setClassOrganization("");
//        } else {
//            Node classIdNode = classIdNodeList.item(0);
//            purchaseOrder.setClassCode(classIdNode.getFirstChild() != null ? classIdNode.getFirstChild().getTextContent() : "");
//            purchaseOrder.setClassOrganization(classIdNode.getChildNodes().item(1) != null ? classIdNode.getChildNodes().item(1).getFirstChild().getTextContent() : "");
//            purchaseOrder.setClassDescription(classIdNode.getLastChild() != null ? classIdNode.getLastChild().getTextContent() : "");
//        }
//    }
}
