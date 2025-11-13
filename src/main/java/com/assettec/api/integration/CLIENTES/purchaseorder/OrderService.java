package com.assettec.api.integration.CLIENTES.purchaseorder;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@AllArgsConstructor
public class OrderService {

    public void setPurchaseOrder(PurchaseOrder purchaseOrder, NodeList resultData) {
        NodeList resultDataNodes = resultData.item(0).getChildNodes();

        SimpleDateFormat inputDateFormat = new SimpleDateFormat("d-M-yyyy");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        for (int i = 0; i < resultDataNodes.getLength(); i++) {
            Node node = resultDataNodes.item(i);

            if (node.getNodeName().equals("PURCHASEORDERID")) {
                // Extract the code (PURCHASEORDERCODE) and set it
                NodeList purchaseOrderNodes = node.getChildNodes();
                for (int j = 0; j < purchaseOrderNodes.getLength(); j++) {
                    Node purchaseOrderNode = purchaseOrderNodes.item(j);
                    if (purchaseOrderNode.getNodeName().equals("PURCHASEORDERCODE")) {
                        purchaseOrder.setCode(purchaseOrderNode.getTextContent());
                        break;
                    }
                }
            }
            if (node.getNodeName().equals("PURCHASEORDERID")) {
                // Extract the code (PURCHASEORDERCODE) and set it
                NodeList purchaseOrderNodes = node.getChildNodes();
                for (int j = 0; j < purchaseOrderNodes.getLength(); j++) {
                    Node purchaseOrderNode = purchaseOrderNodes.item(j);
                    if (purchaseOrderNode.getNodeName().equals("DESCRIPTION")) {
                        purchaseOrder.setDescription(purchaseOrderNode.getTextContent());
                        break;
                    }
                }
            }
            if (node.getNodeName().equals("PURCHASEORDERID")) {
                // Extract the code (PURCHASEORDERCODE) and set it
                NodeList purchaseOrderNodes = node.getChildNodes();
                for (int j = 0; j < purchaseOrderNodes.getLength(); j++) {
                    Node purchaseOrderNode = purchaseOrderNodes.item(j);
                    if (purchaseOrderNode.getNodeName().equals("ORGANIZATIONID")) {
                        purchaseOrder.setOrganization(purchaseOrderNode.getTextContent());
                        break;
                    }
                }
            }

//            if (node.getNodeName().equals("TYPE")) {
//                // Extract the code (PURCHASEORDERCODE) and set it
//                NodeList purchaseOrderNodes = node.getChildNodes();
//                for (int j = 0; j < purchaseOrderNodes.getLength(); j++) {
//                    Node purchaseOrderNode = purchaseOrderNodes.item(j);
//                    if (purchaseOrderNode.getNodeName().equals("TYPECODE")) {
//                        purchaseOrder.setType(purchaseOrderNode.getTextContent());
//                        break;
//                    }
//                }
//            }
//
//            if (node.getNodeName().equals("TYPE")) {
//                // Extract the code (PURCHASEORDERCODE) and set it
//                NodeList purchaseOrderNodes = node.getChildNodes();
//                for (int j = 0; j < purchaseOrderNodes.getLength(); j++) {
//                    Node purchaseOrderNode = purchaseOrderNodes.item(j);
//                    if (purchaseOrderNode.getNodeName().equals("DESCRIPTION")) {
//                        purchaseOrder.setTypeDescription(purchaseOrderNode.getTextContent());
//                        break;
//                    }
//                }
//            }

            if (node.getNodeName().equals("STATUS")) {
                // Extract the code (PURCHASEORDERCODE) and set it
                NodeList purchaseOrderNodes = node.getChildNodes();
                for (int j = 0; j < purchaseOrderNodes.getLength(); j++) {
                    Node purchaseOrderNode = purchaseOrderNodes.item(j);
                    if (purchaseOrderNode.getNodeName().equals("STATUSCODE")) {
                        purchaseOrder.setStatus(purchaseOrderNode.getTextContent());
                        break;
                    }
                }
            }

//            if (node.getNodeName().equals("STATUS")) {
//                // Extract the code (PURCHASEORDERCODE) and set it
//                NodeList purchaseOrderNodes = node.getChildNodes();
//                for (int j = 0; j < purchaseOrderNodes.getLength(); j++) {
//                    Node purchaseOrderNode = purchaseOrderNodes.item(j);
//                    if (purchaseOrderNode.getNodeName().equals("DESCRIPTION")) {
//                        purchaseOrder.setStatusDescription(purchaseOrderNode.getTextContent());
//                        break;
//                    }
//                }
//            }

            if (node.getNodeName().equals("STOREID")) {
                // Extract the code (PURCHASEORDERCODE) and set it
                NodeList purchaseOrderNodes = node.getChildNodes();
                for (int j = 0; j < purchaseOrderNodes.getLength(); j++) {
                    Node purchaseOrderNode = purchaseOrderNodes.item(j);
                    if (purchaseOrderNode.getNodeName().equals("STORECODE")) {
                        purchaseOrder.setStoreCode(purchaseOrderNode.getTextContent());
                        break;
                    }
                }
            }

            if (node.getNodeName().equals("CURRENCYCODE")) purchaseOrder.setCurrency(node.getTextContent());


//            if (node.getNodeName().equals("BUYER")) {
//                // Extract the code (PURCHASEORDERCODE) and set it
//                NodeList purchaseOrderNodes = node.getChildNodes();
//                for (int j = 0; j < purchaseOrderNodes.getLength(); j++) {
//                    Node purchaseOrderNode = purchaseOrderNodes.item(j);
//                    if (purchaseOrderNode.getNodeName().equals("USERCODE")) {
//                        purchaseOrder.setBuyerCode(purchaseOrderNode.getTextContent());
//                        break;
//                    }
//                }
//            }

//            if (node.getNodeName().equals("BUYER")) {
//                // Extract the code (PURCHASEORDERCODE) and set it
//                NodeList purchaseOrderNodes = node.getChildNodes();
//                for (int j = 0; j < purchaseOrderNodes.getLength(); j++) {
//                    Node purchaseOrderNode = purchaseOrderNodes.item(j);
//                    if (purchaseOrderNode.getNodeName().equals("DESCRIPTION")) {
//                        purchaseOrder.setBuyerDescription(purchaseOrderNode.getTextContent());
//                        break;
//                    }
//                }
//            }

            if (node.getNodeName().equals("DUEDATE")) {
                // Extract the year, month, and day from the child nodes and format the date
                NodeList dueDateNodes = node.getChildNodes();
                String year = null, month = null, day = null;

                for (int j = 0; j < dueDateNodes.getLength(); j++) {
                    Node dueDateNode = dueDateNodes.item(j);
                    if (dueDateNode.getNodeName().equals("YEAR")) {
                        year = dueDateNode.getTextContent();
                    } else if (dueDateNode.getNodeName().equals("MONTH")) {
                        month = dueDateNode.getTextContent();
                    } else if (dueDateNode.getNodeName().equals("DAY")) {
                        day = dueDateNode.getTextContent();
                    }
                }

                if (year != null && month != null && day != null) {
                    String formattedDueDate = day + "-" + month + "-" + year;
                    try {
                        Date date = inputDateFormat.parse(formattedDueDate);
                        formattedDueDate = outputDateFormat.format(date);
                    } catch (Exception e) {
                        // Handle any parsing or formatting errors
                    }
                    purchaseOrder.setDueDateDATA(formattedDueDate);
                }
            }


            if (node.getNodeName().equals("SUPPLIERID")) {
                // Extract only the code part (e.g., "FAC")
                NodeList supplierNodes = node.getChildNodes();
                for (int j = 0; j < supplierNodes.getLength(); j++) {
                    Node supplierNode = supplierNodes.item(j);
                    if (supplierNode.getNodeName().equals("SUPPLIERCODE")) {
                        purchaseOrder.setSupplierCode(supplierNode.getTextContent());
                        break;
                    }
                }
            }

//            if (node.getNodeName().equals("SUPPLIERID")) {
//                // Extract only the code part (e.g., "FAC")
//                NodeList supplierNodes = node.getChildNodes();
//                for (int j = 0; j < supplierNodes.getLength(); j++) {
//                    Node supplierNode = supplierNodes.item(j);
//                    if (supplierNode.getNodeName().equals("ORGANIZATIONID")) {
//                        purchaseOrder.setSupplierOrganization(supplierNode.getTextContent());
//                        break;
//                    }
//                }
//            }
//
//            if (node.getNodeName().equals("SUPPLIERID")) {
//                // Extract only the code part (e.g., "FAC")
//                NodeList supplierNodes = node.getChildNodes();
//                for (int j = 0; j < supplierNodes.getLength(); j++) {
//                    Node supplierNode = supplierNodes.item(j);
//                    if (supplierNode.getNodeName().equals("DESCRIPTION")) {
//                        purchaseOrder.setSupplierDescription(supplierNode.getTextContent());
//                        break;
//                    }
//                }
//            }

            if (node.getNodeName().equals("ORIGINATOR")) {
                // Extract the code from child node
                NodeList originatorNodes = node.getChildNodes();
                for (int j = 0; j < originatorNodes.getLength(); j++) {
                    Node originatorNode = originatorNodes.item(j);
                    if (originatorNode.getNodeName().equals("PERSONCODE")) {
                        purchaseOrder.setOriginatorCode(originatorNode.getTextContent());
                        break;
                    }
                }
            }

//            if (node.getNodeName().equals("ORIGINATOR")) {
//                // Extract the code from child node
//                NodeList originatorNodes = node.getChildNodes();
//                for (int j = 0; j < originatorNodes.getLength(); j++) {
//                    Node originatorNode = originatorNodes.item(j);
//                    if (originatorNode.getNodeName().equals("DESCRIPTION")) {
//                        purchaseOrder.setOriginatorDescription(originatorNode.getTextContent());
//                        break;
//                    }
//                }
            }
        }
    }




