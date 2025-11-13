package com.assettec.api.internal.core.entities.orders.workorder.utilities;

import com.assettec.api.internal.core.entities.orders.workorder.WorkOrder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class WorkOrderUpdater {
    private WorkOrderSetter workOrderSetter;

    public WorkOrder setWorkOrder(NodeList resultData) {
        WorkOrder workOrder = new WorkOrder();

        workOrderSetter.setWorkOrder(workOrder,resultData);



        return workOrder;
    }
}
