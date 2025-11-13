package com.assettec.api.integration.CLIENTES.purchaseorder;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


@AllArgsConstructor
@Component
public class PurchaseSetter {

        private OrderService orderService;

        public PurchaseOrder getPurchaseSetter(PurchaseOrder purchaseOrder) {
            NodeList resultData= (NodeList) new PurchaseOrder();

            orderService.setPurchaseOrder(purchaseOrder, resultData);

            return purchaseOrder;

        }
}
