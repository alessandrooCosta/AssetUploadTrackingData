package com.assettec.api.internal.core.entities.orders.purchaseorder.utilities;

import com.assettec.api.internal.utilities.common.XMLParser;
import com.assettec.api.internal.utilities.handlers.RequestCreator;
import com.assettec.api.internal.utilities.handlers.RequestSender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PurchaseOrderUpdater {

    private XMLParser xmlParser;
    private RequestSender requestSender;
    private RequestCreator requestBuilder;
    private PurchaseOrderSetter purchaseOrderSetter;



//    @SneakyThrows
//    public void updatePurchaseOrders(ApiUser apiUser, List<PurchaseOrder> purchaseOrderList) {
//        String host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());
//        PurchaseOrderRequestBuilder builder = requestBuilder.getPurchaseOrderRequestBuilder();
//
//        for (PurchaseOrder purchaseOrder : purchaseOrderList) {
//
//            String getPO = builder.getPurchaseOrder(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization(), purchaseOrder.getCode(), purchaseOrder.getOrganization());
//            String rawResponse = requestSender.sendPostRequest(getPO, host);
//            String response = rawResponse.replaceAll("ns[0-9]:", "").replaceAll("ns[0-9][0-9]:", "").replaceAll("ns[0-9][0-9][0-9]:", "");
//
//            Document xmlData = xmlParser.toDocument(response);
//            setPurchaserOrder(xmlData,purchaseOrder);
//        }
//    }
//
//    @SneakyThrows
//    public void updatePartForPurchaseOrders(ApiUser apiUser, PurchaseOrder purchaseOrder, PurchaseOrderRequestBuilder builder, String host) {
//
//        int i = 1;
//        String lineNum = i + "0";
//
//        String getPOParts = builder.getPurchaseOrderPart(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization(), purchaseOrder.getCode(), purchaseOrder.getOrganization(), lineNum);
//        String rawResponse = requestSender.sendPostRequest(getPOParts, host);
//        String response = rawResponse.replaceAll("ns[0-9]:", "").replaceAll("ns[0-9][0-9]:", "").replaceAll("ns[0-9][0-9][0-9]:", "");
//
//        if (purchaseOrder.getPartsForPurchase() != null) { purchaseOrder.getPartsForPurchase().clear(); }
//
//        while (!response.contains("Unable to locate")) {
//            Document xmlData = xmlParser.toDocument(response);
//            purchaseOrderSetter.setPartForPurchase(xmlData, purchaseOrder, lineNum);
//            i+=1;lineNum = i + "0";
//
//            getPOParts = builder.getPurchaseOrderPart(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization(), purchaseOrder.getCode(), purchaseOrder.getOrganization(), lineNum);
//            rawResponse = requestSender.sendPostRequest(getPOParts, host);
//            response = rawResponse.replaceAll("ns[0-9]:", "").replaceAll("ns[0-9][0-9]:", "").replaceAll("ns[0-9][0-9][0-9]:", "");
//        }
//    }
//
//    @SneakyThrows
//    public PurchaseOrder getPurchaseOrder(ApiUser apiUser, String purchaseOrderCode, String purchaseOrderOrganization) {
//        String host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());
//
//        PurchaseOrderRequestBuilder purchaseOrderRequestBuilder = requestBuilder.getPurchaseOrderRequestBuilder();
//        String postRequest = purchaseOrderRequestBuilder.getPurchaseOrder(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization(),purchaseOrderCode,purchaseOrderOrganization);
//        String rawResponse = requestSender.sendPostRequest(postRequest, host);
//        String response = rawResponse.replaceAll("ns[0-9]:", "").replaceAll("ns[0-9][0-9]:", "").replaceAll("ns[0-9][0-9][0-9]:", "");
//
//        if (rawResponse.equals("Unable to locate registry")) throw new IllegalStateException("Unable to locate purchaseOrder");
//        PurchaseOrder purchaseOrder = new PurchaseOrder();
//
//        Document xmlData = xmlParser.toDocument(response);
//        setPurchaserOrder(xmlData, purchaseOrder);
//        if (!purchaseOrder.getNumberOfPartLines().equals("0")) updatePartForPurchaseOrders(apiUser,purchaseOrder, requestBuilder.getPurchaseOrderRequestBuilder(),host);
//
//        return purchaseOrder;
//    }
//
//    @SneakyThrows
//    public void setPurchaserOrder(Document xmlData, PurchaseOrder purchaseOrder) {
//        purchaseOrder.setUpdateCount(Integer.parseInt(xmlData.getElementsByTagName("PurchaseOrder").item(0).getAttributes().getNamedItem("recordid").getNodeValue()));
//
//        purchaseOrderSetter.setBasicData(xmlData, purchaseOrder);
//        purchaseOrderSetter.setStore(xmlData, purchaseOrder);
//        purchaseOrderSetter.setSupplier(xmlData, purchaseOrder);
//
//        purchaseOrderSetter.setPurchaseOrderValue(xmlData, purchaseOrder);
//        purchaseOrderSetter.setExchange(xmlData, purchaseOrder);
//        purchaseOrderSetter.setDiscount(xmlData, purchaseOrder);
//        purchaseOrderSetter.setBuyer(xmlData, purchaseOrder);
//
//        purchaseOrderSetter.setContractDeliveryAddress(xmlData, purchaseOrder);
//        purchaseOrderSetter.setPrintedTransmitted(xmlData, purchaseOrder);
//
//        purchaseOrderSetter.setType(xmlData, purchaseOrder);
//        purchaseOrderSetter.setAuthorizer(xmlData, purchaseOrder);
//        purchaseOrderSetter.setOriginator(xmlData, purchaseOrder);
//        purchaseOrderSetter.setAttentionTo(xmlData, purchaseOrder);
//
//        purchaseOrderSetter.setTotalTax(xmlData, purchaseOrder);
//        purchaseOrderSetter.setTotalExtra(xmlData, purchaseOrder);
//
//        purchaseOrderSetter.setDueDate(xmlData, purchaseOrder);
//        purchaseOrderSetter.setOrderDate(xmlData, purchaseOrder);
//        purchaseOrderSetter.setApproveDate(xmlData, purchaseOrder);
//
//        purchaseOrderSetter.setPaymentTermAndMethod(xmlData,purchaseOrder);
//        purchaseOrderSetter.setOrderTermShipViaAndFreightTerm(xmlData,purchaseOrder);
//
//        purchaseOrderSetter.setClass(xmlData,purchaseOrder);
//
//        purchaseOrderSetter.setUserDefinedFields(xmlData, purchaseOrder);
//        purchaseOrderSetter.setUserDefinedArea(xmlData, purchaseOrder);
//
//    }
}
