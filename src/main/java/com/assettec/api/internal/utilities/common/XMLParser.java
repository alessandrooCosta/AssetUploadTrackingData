package com.assettec.api.internal.utilities.common;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

@Component
public class XMLParser {
    private static final Logger logger = LoggerFactory.getLogger(XMLParser.class);



    @SneakyThrows
    public void printXml(String response) {
        System.out.println(readXML(response));
    }

    @SneakyThrows
    public String readXML(String xmlString) throws TransformerException, ParserConfigurationException, IOException, SAXException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        DOMSource source = new DOMSource(toDocument(xmlString));
        StreamResult result = new StreamResult(new StringWriter());
        transformer.transform(source, result);

        return result.getWriter().toString();
    }

    public Document toDocument(String response) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        return builder.parse(new InputSource(new StringReader(response)));
    }


    private static Document readDocument(String fileUrl) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        return builder.parse(new File(fileUrl));
    }

    @SneakyThrows
    public static String getInforHost(String server, String port) {
        String inforHost;

        if (server.isEmpty()) {
            logger.info("[SpringFramework][ Spring boot shutting down: SKR ]");
            logger.info("[SpringFramework][ Shutdown cause: server is blank ]");
            logger.info("[SpringFramework][ Please provide the server information ]");
            System.exit(500);
        }

        String trimmedServer = server.trim();
        boolean serverHasScheme = trimmedServer.startsWith("http://") || trimmedServer.startsWith("https://");
        boolean useHttps = trimmedServer.startsWith("https://") || (port == null || port.isEmpty()) || "443".equals(port);

        if (port != null && !port.isEmpty()) {
            if (serverHasScheme) {
                inforHost = trimmedServer + ":" + port + "/axis/services/EWSConnector";
            } else if (useHttps) {
                inforHost = "https://" + trimmedServer + ":" + port + "/axis/services/EWSConnector";
            } else {
                inforHost = "http://" + trimmedServer + ":" + port + "/axis/services/EWSConnector";
            }
        } else {
            if (serverHasScheme) {
                inforHost = trimmedServer + "/axis/services/EWSConnector";
            } else if (useHttps) {
                inforHost = "https://" + trimmedServer + "/axis/services/EWSConnector";
            } else {
                inforHost = "http://" + trimmedServer + "/axis/services/EWSConnector";
            }
        }

        return inforHost;
    }


    private static boolean fileExists(String url) {
        File file = new File(url);
        return file.exists();
    }

    @SneakyThrows
    private static void createFile(String url) {
        File file = new File(url);
        boolean madeDir = file.getParentFile().mkdirs();
        boolean createdFile = file.createNewFile();

        if (madeDir && createdFile) logger.info("[XMLParser][ Created directories and config file ]");

        FileWriter fileWriter = new FileWriter(file);
        String xml = "\n<core>\n    <server></server>\n   <client></client>\n  <ports>\n        <http></http>\n        <https></https>\n    </ports>\n</core>";
        fileWriter.write(xml);
        fileWriter.close();
    }
}
