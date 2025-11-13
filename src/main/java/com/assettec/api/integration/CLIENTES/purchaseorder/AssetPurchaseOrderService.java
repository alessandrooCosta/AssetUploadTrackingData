package com.assettec.api.integration.CLIENTES.purchaseorder;

import com.assettec.api.integration.CLIENTES.purchaseorder.PurchaseOrder;
import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.common.XMLParser;
import com.assettec.api.internal.utilities.handlers.RequestCreator;
import com.assettec.api.internal.utilities.handlers.RequestSender;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

@Service
@AllArgsConstructor
public class AssetPurchaseOrderService {

    private OCUpdater ocUpdater;
    private RequestCreator requestBuilder;
    private RequestSender requestSender;
    private XMLParser xmlParser;

    @SneakyThrows
    public PurchaseOrder getPurchaseOrdems(ApiUser apiUser, String purchaseOrderCode, String organization) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getAssetPurchaseOrderRequestBuilder().getPurchaseOrder(apiUser, purchaseOrderCode, organization);
        response = requestSender.sendPostRequest(postRequest, host);
        Document xmlData = xmlParser.toDocument(response);
        NodeList resultData = xmlData.getElementsByTagName("ResultData").item(0).getChildNodes();

        return ocUpdater.setPurchaseOrder(resultData);
    }

    @SneakyThrows
    public String postPurchaseOrder(ApiUser apiUser, String purchaseOrderOrganization, String purchaseOrderDescription, String purchaseOrderStatusCode, String storeCode, String originatorCode, String currency, String supplierCode, String dueDate) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());


        String[] dueDateParts = dueDate.split("-");
        String dueDateDay = dueDateParts[0];
        String dueDateMonth = dueDateParts[1];
        String dueDateYear = dueDateParts[2];


        postRequest = requestBuilder.getAssetPurchaseOrderRequestBuilder().postPurchaseOrder(apiUser, purchaseOrderOrganization,  purchaseOrderDescription,  purchaseOrderStatusCode,  storeCode,  originatorCode,  currency,  supplierCode,  dueDateYear,  dueDateMonth,  dueDateDay);
        response = requestSender.sendPostRequest(postRequest, host);
        Document xmlData = xmlParser.toDocument(response);

        return xmlData.getElementsByTagName("Message").item(0).getTextContent();
    }

    @SneakyThrows
    public String postPurchaseOrderPART(ApiUser apiUser, String purchaseOrderCode, String linha, String purchaseOrderOrganization, String purchaseOrderDescription, String partCode, String purchaseOrderStatusCode, String purchaseOrderTypeCode, String purchaseUOM, String price, String currency, String dueDateParts) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());


        String[] dueDatePart = dueDateParts.split("-");
        String requestDueDateDAY = dueDatePart[0];
        String requestDueDateMONTH = dueDatePart[1];
        String requestDueDateYEAR = dueDatePart[2];


        postRequest = requestBuilder.getAssetPurchaseOrderRequestBuilder().postPurchaseOrderPART(apiUser, purchaseOrderCode, linha, purchaseOrderOrganization, purchaseOrderDescription, partCode, purchaseOrderStatusCode, purchaseOrderTypeCode, purchaseUOM, price, currency, requestDueDateYEAR, requestDueDateMONTH,  requestDueDateDAY);
        response = requestSender.sendPostRequest(postRequest, host);
        Document xmlData = xmlParser.toDocument(response);

        return xmlData.getElementsByTagName("Message").item(0).getTextContent();
    }

    @SneakyThrows
    public String postCommentsOC(ApiUser apiUser, String OC, String language, String comment, String print) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getAssetPurchaseOrderRequestBuilder().postCommentsOC(apiUser, OC, language, comment, print);
        response = requestSender.sendPostRequest(postRequest, host);

        // Verificar o conteúdo do XML retornado
        System.out.println("XML Response: " + response);

        // Verificar se há uma tag de erro na resposta do servidor
        if (response.contains("<ns1:Message>")) {
            int start = response.indexOf("<ns1:Message>") + "<ns1:Message>".length();
            int end = response.indexOf("</ns1:Message>", start);
            String errorMessage = response.substring(start, end);
            return errorMessage;
        } else {
            // Se não houver uma mensagem de erro específica, consideramos que a operação foi bem-sucedida
            return null;
        }
    }


}

