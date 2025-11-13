package com.assettec.api.internal.core.requisitions;

import com.assettec.api.internal.core.entities.basic.setter.CodeSetter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class RequisitionSetter {
    private CodeSetter codeSetter;

    public Requisition setRequisition(NodeList childNodes) {
        return new Requisition();
    }

}
