package com.assettec.api.internal.core.entities.orders.workorder;

import com.assettec.api.integration.CLIENTES.comments.CommentData;
import com.assettec.api.integration.CLIENTES.comments.CommentUpdateDTO;
import com.assettec.api.integration.CLIENTES.maptronic.WorkOrderUpdateDTO;
import com.assettec.api.internal.core.entities.comment.setter.CommentSetter;
import com.assettec.api.internal.core.entities.orders.workorder.utilities.WorkOrderUpdater;
import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.utilities.common.XMLParser;
import com.assettec.api.internal.utilities.handlers.RequestCreator;
import com.assettec.api.internal.utilities.handlers.RequestSender;
import com.assettec.api.internal.utilities.requests.requestbuilders.workOrderBuilder.WorkOrderRequestBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class WorkOrderService {

    private WorkOrderRequestBuilder workOrderRequestBuilder;
    private CommentSetter commentSetter;

    private WorkOrderUpdater workOrderUpdater;
    private RequestCreator requestBuilder;
    private RequestSender requestSender;
    private XMLParser xmlParser;



    @SneakyThrows
    public WorkOrder getWorkOrder(ApiUser apiUser, String jobNum) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getWorkOrderRequestBuilder().getWorkOrder(apiUser, jobNum);
        response = requestSender.sendPostRequest(postRequest, host);
        Document xmlData = xmlParser.toDocument(response);
        NodeList resultData = xmlData.getElementsByTagName("ResultData").item(0).getChildNodes();

        return workOrderUpdater.setWorkOrder(resultData);
    }

    @SneakyThrows
    public String postWorkOrder(ApiUser apiUser, String workOrderOrganization, String workOrderDescription, String status, String equipmentCode, String equipmentOrganization, String department, String type, String workOrderUdfChar20) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getWorkOrderRequestBuilder().postWorkOrder(apiUser, workOrderOrganization, workOrderDescription, status, equipmentCode, equipmentOrganization, department, type, workOrderUdfChar20);
        response = requestSender.sendPostRequest(postRequest, host);
        Document xmlData = xmlParser.toDocument(response);

        return xmlData.getElementsByTagName("Message").item(0).getTextContent();
    }


    @SneakyThrows
    public String deleteWorkOrder(ApiUser apiUser, String serviceId) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getWorkOrderRequestBuilder().deleteWorkOrderBuilder(apiUser, serviceId);
        response = requestSender.sendPostRequest(postRequest, host);
        Document xmlData = xmlParser.toDocument(response);

        return xmlData.getElementsByTagName("Message").item(0).getTextContent();
    }


    @SneakyThrows
    public String postComment(ApiUser apiUser, String OS, String language, String comment, String print) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        postRequest = requestBuilder.getCommentsRequestBuilder().addComments(apiUser, OS, language, comment, print);
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

    @SneakyThrows
    public String updateWorkOrderComments(ApiUser apiUser, String OS, CommentUpdateDTO commentUpdateDTO) {
        String putRequest = requestBuilder.getCommentsRequestBuilder().updateComment(apiUser, OS, commentUpdateDTO);
        String host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        try {
            String response = requestSender.sendPostRequest(putRequest, host);
            response = response.trim();  // Limpa espaços em branco do início e fim da resposta

            System.out.println("Response from InforEAM: " + response);  // Linha para depurar

            return response; // Retorna a resposta completa do InforEAM
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing InforEAM response.");
        }
    }


    @SneakyThrows
    public List<CommentData> getWorkComments(ApiUser apiUser, String OS) {
        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());
        postRequest = requestBuilder.getCommentsRequestBuilder().getComments(apiUser, OS);
        response = requestSender.sendPostRequest(postRequest, host);

        // Convert the XML response to JSON using Jackson's ObjectMapper
        ObjectMapper xmlMapper = new XmlMapper();
        JsonNode jsonNode = xmlMapper.readTree(response);

        // Log para exibir o JSON resultante
        String jsonString = jsonNode.toPrettyString();
        System.out.println(jsonString);

        // Extract the necessary data from the JSON
        List<CommentData> comments = new ArrayList<>();
        JsonNode resultData = jsonNode.get("Body")
                .get("MP0108_GetComments_001_Result")
                .get("ResultData")
                .get("Comments")
                .get("COMMENT");

        if (resultData.isArray()) {
            int commentId = 1;
            for (JsonNode comment : resultData) {
                CommentData commentData = new CommentData();
                commentData.setId(Integer.toString(commentId));
                commentData.setUserCode(comment.at("/CREATEDBY/USERCODE").asText());
                commentData.setDescription(comment.at("/CREATEDBY/DESCRIPTION").asText());
                commentData.setCommentText(comment.at("/COMMENTTEXT").asText());

                // Access the LANGUAGEID node
                JsonNode languageIdNode = comment.at("/ENTITYCOMMENTID/LANGUAGEID");

                // Check if the node is not missing and has the LANGUAGECODE node
                if (!languageIdNode.isMissingNode() && languageIdNode.has("LANGUAGECODE")) {
                    String languageCode = languageIdNode.get("LANGUAGECODE").asText();
                    commentData.setLanguageCode(languageCode);
                } else {
                    // If LANGUAGECODE is missing, you can set a default value or handle it accordingly
                    commentData.setLanguageCode("");
                }

                commentData.setPrint(comment.at("/PRINT").asBoolean());

                // Extract date and time from the JSON
                JsonNode createdDateNode = comment.at("/CREATEDDATE");
                int day = createdDateNode.at("/DAY").asInt();
                int month = createdDateNode.at("/MONTH").asInt();
                int year = createdDateNode.at("/YEAR").asInt();
                int hour = createdDateNode.at("/HOUR").asInt();
                int minute = createdDateNode.at("/MINUTE").asInt();
                int second = createdDateNode.at("/SECOND").asInt();

                // Set date and formatted time in the CommentData object
                commentData.setCreatedDate(String.format("%02d/%02d/%04d", day, month, year));
                commentData.setFormattedCreatedTime(String.format("%02d:%02d:%02d", hour, minute, second));
                commentId++;

                comments.add(commentData);
            }
        }
        return comments;
    }

    @SneakyThrows
    public String updateWorkOrder(ApiUser apiUser, int OS, WorkOrderUpdateDTO updateDTO) {
        String putRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());

        putRequest = requestBuilder.getWorkOrderRequestBuilder().putWorkOrder(apiUser, OS, updateDTO);
        response = requestSender.sendPostRequest(putRequest, host);
        Document xmlData = xmlParser.toDocument(response);

        return xmlData.getElementsByTagName("Message").item(0).getTextContent();
    }



//    @SneakyThrows
//    public String getWorkComments(ApiUser apiUser, WorkOrder workOrder) {
//        // Implemente a lógica para obter os comentários da ordem de serviço com base no apiUser e workOrder
//        return workOrderRequestBuilder.getComment(apiUser, workOrder);
//    }




//    @SneakyThrows
//    public String putWorkOrder(ApiUser apiUser, WorkOrder workOrder, WorkOrderSummaryUpdate workOrderSummaryUpdate) {
//        String postRequest, response, host = XMLParser.getInforHost(apiUser.getServer(), apiUser.getPort());
//
//        postRequest = requestBuilder.getWorkOrderRequestBuilder().putWorkOrder(apiUser, workOrder, workOrderSummaryUpdate);
////        response = requestSender.sendPostRequest(postRequest, host);
////        Document xmlData = xmlParser.toDocument(response);
//
//        return postRequest;
//    }
}
