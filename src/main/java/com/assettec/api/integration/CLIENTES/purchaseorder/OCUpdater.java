package com.assettec.api.integration.CLIENTES.purchaseorder;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class OCUpdater {

        private OrderService orderService;

        public PurchaseOrder setPurchaseOrder(NodeList resultData) {
            PurchaseOrder purchaseOrder = new PurchaseOrder();

            orderService.setPurchaseOrder(purchaseOrder,resultData);


            return purchaseOrder;
        }
    }

