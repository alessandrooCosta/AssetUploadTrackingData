package com.assettec.api.internal.core.entities.orders.purchaseorder;


import com.assettec.api.internal.utilities.common.XMLParser;
import com.assettec.api.internal.utilities.handlers.RequestCreator;
import com.assettec.api.internal.utilities.handlers.RequestSender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchaseOrderService {


    private RequestCreator requestBuilder;
    private RequestSender requestSender;
    private XMLParser xmlParser;

//    @SneakyThrows
//    public String registerPurchaseOrder(ApiUser apiUser, IGPurchaseOrder request) {
//        if (request.getOrganization() == null || request.getOrganization().isEmpty())
//            throw new IllegalStateException("purchase order organization must not be null or blank");
//        if (request.getSupplierCode() == null || request.getSupplierCode().isEmpty())
//            throw new IllegalStateException("supplier code must not be null or blank");
//        if (request.getStoreCode() == null || request.getStoreCode().isEmpty())
//            throw new IllegalStateException("store code must not be null or blank");
//        if (request.getOriginator() == null || request.getOriginator().isEmpty())
//            throw new IllegalStateException("originator must not be null or blank");
//        if (request.getPurchaseOrderLines() == null || request.getPurchaseOrderLines().size() == 0)
//            throw new IllegalStateException("Purchase Order Lines must not be null or empty");
//
//        int lines = request.getPurchaseOrderLines().size();
//
//        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());
//        request.setCreatedDate(LocalDateTime.now());
//        request.setDueDate(LocalDateTime.now().plusYears(1));
//
//        if (request.getDescription() == null) request.setDescription("{DEFAULT PURCHASE ORDER DESCRIPTION}");
//        postRequest = requestBuilder.getPurchaseOrderRequestBuilder().postPurchaseOrder(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization(), " ", request.getOrganization(), request.getDescription(), "U", "P", request.getSupplierCode(), "*", request.getStoreCode(), request.getOriginator(), "100", "XXX", "BRL", request.getDueDate().getYear(), request.getDueDate().getMonthValue(), request.getDueDate().getDayOfMonth(), request.getCreatedDate().getYear(), request.getCreatedDate().getMonthValue(), request.getCreatedDate().getDayOfMonth(), request.getPaymentTerm(), request.getPaymentMethod(), "-0300");
//        response = requestSender.sendPostRequest(postRequest, host);
//        Document xmlData = xmlParser.toDocument(response);
//
//        String inforResponse = xmlData.getElementsByTagName("Message").item(0).getTextContent();
//        String purchaseOrderCode = inforResponse.replace("Ordem de compra ", "").replace(" foi salvo com êxito.", "");
//        PurchaseOrder purchaseOrder = getPurchaseOrder(apiUser, purchaseOrderCode, request.getOrganization());
//
//        IGPurchaseOrderLine purchaseOrderLine;
//        StringBuilder lineResponse = new StringBuilder();
//        for (int i = 0; i < lines; i++) {
//            purchaseOrderLine = request.getPurchaseOrderLines().get(i);
//            postRequest = requestBuilder.getPurchaseOrderRequestBuilder().postPurchaseOrderPart(apiUser.getUsername(), apiUser.getTenant(), apiUser.getPassword(), apiUser.getOrganization(), purchaseOrder.getCode(), purchaseOrder.getOrganization(), i + 1, "PS", purchaseOrder.getStatus(), purchaseOrderLine.getPartCode(), purchaseOrderLine.getPartOrganization(), (int) purchaseOrderLine.getQuantity(), "1", purchaseOrderLine.getUnitOfMetric(), purchaseOrderLine.getUnitOfMetric(), "100", "100", "100", "XXX", "XXX", "BRL", purchaseOrder.getDueDate().getYear(), purchaseOrder.getDueDate().getMonthValue(), purchaseOrder.getDueDate().getDayOfMonth(), "-0300");
//            response = requestSender.sendPostRequest(postRequest, host);
//
//            Document xmlResponseData = xmlParser.toDocument(response);
//            String xmlResponse = xmlResponseData.getElementsByTagName("Message").item(0).getTextContent().replace("  ", " " + (i + 1) + " ");
//
//            lineResponse.append(xmlResponse).append("\n");
//        }
//
//        return inforResponse + "\n" + lineResponse;
//    }

//    @SneakyThrows
//    public PurchaseOrder getPurchaseOrder(ApiUser apiUser, String purchaseOrderCode, String purchaseOrderOrganization) {
//        return purchaseOrderUpdater.getPurchaseOrder(apiUser, purchaseOrderCode, purchaseOrderOrganization);
//    }
}
