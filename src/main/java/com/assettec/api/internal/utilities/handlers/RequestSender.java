package com.assettec.api.internal.utilities.handlers;

import com.assettec.api.internal.utilities.common.XMLParser;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.rmi.ConnectIOException;

@Service
@AllArgsConstructor
public class RequestSender {

    private XMLParser xmlParser;
    private final Logger logger = LoggerFactory.getLogger(RequestSender.class);

    public String sendPostRequest(String postRequest, String host) throws IOException, ParserConfigurationException, TransformerException, SAXException {
        URL url = new URL(host);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "text/xml");
        con.setDoOutput(true);

        writePostRequest(con, postRequest);
        logger.info("[Authenticated Request][ Successfully established connection to server: Awaiting response ]");

        if (con.getResponseCode() != 200) {
            logger.info("[InforEAM Response][ Bad Response: Handling Error ]");
            String error = readPostError(con);
            if (error.contains("Autorização") && error.contains("negada"))
                throw new IllegalAccessError("Unauthorized request check credentials");
            else if (error.contains("Não é possível localizar o  do registro Linha/ordem de compra.")) return "Unable to locate purchase order part.";
            else if (error.contains("Não é possível localizar o ") && error.contains("registro")) return "Unable to locate registry";
            else if (error.contains("Já existe um registro que utiliza esse valor.")) return "registry already in use";
            else if (error.contains("Fornecedor não é válido.")) return "Cannot find the Supplier record.";
            else if (error.contains("Nenhum contato de fornecedor válido.")) return "Cannot find the SupplierContact record.";
            else if (error.contains("Os dados talvez estivessem fora da data nesse registro e não foram salvos no banco de dados.")) return "The data of this record is out of date.";
            else if (error.contains("Não há peças a serem recuperadas.")) return "No parts to be retrieved";
            else if (error.contains("Todas as linhas foram recuperadas.")) return "All Lines were retrieved";
            else if (error.contains("Código de peça inválido.")) return "Cannot find the part record.";
            else if (error.contains("Cannot find the POReceiptActiveLine record.")) return "Cannot find the POReceiptActiveLine record.";
            else if (error.contains("Cannot find the equipment record.")) return "Cannot find the equipment record.";
            else if (error.contains("An error occurred generating the xml response. Result of original action: TOBIN is a required field.")) return "missing toBin field";
            else if (error.contains("Não é possível localizar o parâmetro de instalação.")) throw new IllegalStateException("Unable to find installation parameter");
            else if (error.contains("Peça é inválido.")) throw new IllegalStateException("Invalid part. Check part code and organization");
            else if (error.contains("Ordem de serviço ou atividade inválida.")) throw new IllegalStateException("Ordem de serviço ou atividade inválida.");
            else if (error.contains("Equipment cannot be deleted becuase it has event history.")) throw new IllegalStateException("Equipment cannot be deleted because it has event history.");
            else if (error.contains("Departamento é inválido.")) throw new IllegalStateException("Invalid Department");
            else if (error.contains("é uma duplicação")) throw new IllegalArgumentException(xmlParser.toDocument(error.replaceAll("ns[0-9]:","")).getElementsByTagName("Message").item(0).getTextContent());
            else if (error.contains("InvalidCredentialsException")) throw new IllegalStateException("Please make certain all credentials are entered correctly.");
            else if (error.contains("a quantidade total de peças recebidas ou sucateadas é maior que a quantidade total de peças em trânsito")) throw new IllegalStateException("A quantidade total de peças recebidas ou sucateadas é maior que a quantidade total de peças em trânsito");
            else if (error.contains("Lote é inválido")) {logger.info("[InforEAM][ Asset part association linking issue needs manual intervention ]");return "Lote é inválido";}
            else if (error.contains("O campo Status de disponibilidade do sistema não pode ficar em branco.")) {logger.info("[InforEAM][ Asset missing required field needs manual intervention ]"); return "O campo Status de disponibilidade do sistema não pode ficar em branco.";}
            else if (error.contains("devem ser inseridos")) {logger.info("[InforEAM][ Asset missing required field needs manual intervention ]"); throw new IllegalStateException("[ Intervenção manual necessária ] O Conjunto e a Posição no conjunto devem ser inseridos ou ambos devem estar em branco.");}
            else if (error.contains("Equipment is updated.")) return "Equipment is updated.";
            else if (error.contains("Invalid GridName")) return "Invalid GridName";
            else if (error.contains("Não é possível gravar a guia de remessa porque ela não tem nenhuma linha associada.")) return "Não é possível gravar a guia de remessa porque ela não tem nenhuma linha associada.";
            else if (error.contains("Authorization failed. You are not authorized to perform this function.")) throw new IllegalStateException("Authorization failed. You are not authorized to perform this function." + postRequest);
            else if (error.contains("Equipamento é inválido")) throw new IllegalStateException("Equipment code and/or organization is/are invalid.");
            else throw new IllegalStateException(xmlParser.readXML(error));
        } else {
            logger.info("[InforEAM Response][ Extracted Data: Processing Information ]");
            String response = readPostResponse(con);
            Document responseXML = xmlParser.toDocument(response);

            if (response.contains("Invalid GridName")) return "Invalid GridName";


            logger.info("[Authenticated Request][ Successfully extracted data ]");
            return response.replaceAll("ns[0-9]:", "").replaceAll("ns[0-9][0-9]:", "").replaceAll("ns[0-9][0-9][0-9]:", "").replaceAll(":ns[0-9]","").replaceAll(":ns[0-9][0-9]","").replaceAll(":ns[0-9][0-9][0-9]","");
        }

    }

    private void writePostRequest(HttpURLConnection con, String postRequest) throws IOException {
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = postRequest.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        } catch (ConnectIOException e) {
            e.printStackTrace();
            throw e; // Relança a exceção original
        } catch (Exception e) {
            throw new ConnectIOException("Unable to send request", e);
        }
    }

    private String readPostError(HttpURLConnection con) throws IOException {
        con.getResponseCode();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getErrorStream(), StandardCharsets.UTF_8))) {
            StringBuilder stringBuilder = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                stringBuilder.append(responseLine.trim());
            }
            return stringBuilder.toString();
        }
    }

    private String readPostResponse(HttpURLConnection con) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder stringBuilder = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                stringBuilder.append(responseLine.trim());
            }
            return stringBuilder.toString();
        }
    }
}
