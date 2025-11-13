package com.assettec.api.internal.core.grid;

import com.assettec.api.internal.utilities.common.XMLParser;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

    @Service
    @AllArgsConstructor
    public class GridService {

        private XMLParser xmlParser;
        private final Logger logger = LoggerFactory.getLogger(GridService.class);

        @SneakyThrows
        public List<Row> getRows(String response) {
            if (response.equals("Invalid GridName")) throw new IllegalStateException("Invalid GridName");
            logger.info("[GridService][ Started retrieving data from grid request ]");
            List<Field> fieldList = getFieldList(response);

            Document xmlData = xmlParser.toDocument(response);
            NodeList data = xmlData.getElementsByTagName("DATA");
            if (data.getLength() == 0) throw new IllegalStateException("Unable to find grid Data.");
            NodeList rowNodeList = data.item(0).getChildNodes();

            List<Row> rows = new ArrayList<>();

            for (int i = 0; i < rowNodeList.getLength(); i++) {
                Row row = new Row();
                Node rowNode = rowNodeList.item(i);
                List<Field> rowFields = new ArrayList<>();

                for (int j = 0; j < rowNode.getChildNodes().getLength(); j++) {
                    Node rowItem = rowNode.getChildNodes().item(j);

                    String aliasNum = rowItem.getAttributes().getNamedItem("n").getTextContent();
                    Field field = setFieldData(aliasNum, fieldList, rowItem.getTextContent());

                    rowFields.add(field);
                }
                row.setId(rowNode.getAttributes().getNamedItem("id").getTextContent());
                row.setFields(rowFields);
                rows.add(row);
            }

            logger.info("[GridService][ Returning Rows Data ]");
            return rows;
        }

        private Field setFieldData(String aliasNum, List<Field> fieldList, String textContent) {
            Field field = findGridField(aliasNum, fieldList);
            return new Field(field.getAliasNum(),field.getName(),textContent, field.getLabel());
        }

        public Field findGridField(String aliasNum, List<Field> fields) {

            for (Field field : fields) {
                if (field.getAliasNum().equals(aliasNum)) {
                    return field;
                }
            }
            return null;
        }

        public String getDataByName(String name, Row row) {
            List<Field> fields = row.getFields();
            for (Field field : fields) {
                if (field.getName().equals(name)) {
                    return field.getData();
                }
            }
            return null;
        }

        public void printNames(Row row) {
            for (int i = 0; i < row.getFields().size(); i++) {
                System.out.println(row.getFields().get(i).getName());
            }
        }

        @SneakyThrows
        public List<Field> getFieldList(String response) {
            Document xmlData = xmlParser.toDocument(response);

            Node fieldsNodeList = xmlData.getElementsByTagName("FIELDS").item(0);
            NodeList fieldNodeList = fieldsNodeList.getChildNodes();

            List<Field> fieldList = new ArrayList<>();

            for (int i = 0; i < fieldNodeList.getLength(); i++) {
                Field field = new Field();
                Node fieldNode = fieldNodeList.item(i);

                field.setName(fieldNode.getAttributes().getNamedItem("name").getTextContent());
                field.setAliasNum(fieldNode.getAttributes().getNamedItem("aliasnum").getTextContent());
                field.setLabel(fieldNode.getAttributes().getNamedItem("label").getTextContent());

                fieldList.add(field);
            }

            return fieldList;
        }

        @SneakyThrows
        public List<DataSpy> getDataSpies(String response) {
            Document xmlData = xmlParser.toDocument(response);

            NodeList dataSpiesNodes = xmlData.getElementsByTagName("dataspylist_options").item(0).getChildNodes();
            List<DataSpy> dataSpies = new ArrayList<>();

            for (int i = 0; i < dataSpiesNodes.getLength(); i++) {
                Node dataSpyNode = dataSpiesNodes.item(i);

                DataSpy dataSpy = new DataSpy(Integer.parseInt(dataSpyNode.getLastChild().getTextContent()),
                        dataSpyNode.getFirstChild().getTextContent());
                dataSpies.add(dataSpy);
            }

            return dataSpies;
        }

    @SneakyThrows
    public DataSpy getCurrentDataSpy(String response) {
        Document xmlData = xmlParser.toDocument(response);

        Node dataSpyNode = xmlData.getElementsByTagName("DATASPY").item(0);
        return new DataSpy(Integer.parseInt(dataSpyNode.getAttributes().getNamedItem("id").getTextContent()),
                dataSpyNode.getAttributes().getNamedItem("label").getTextContent());
    }

    @SneakyThrows
    public int getRecords(String response) {
        return Integer.parseInt(xmlParser.toDocument(response).getElementsByTagName("RECORDS").item(0).getTextContent());
    }
}
