package com.assettec.api.internal.core.requisitions;

import com.assettec.api.internal.users.ApiUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RequisitionService {

    public Requisition getRequisition(ApiUser apiUser, String requisitionCode, String requisitionOrganization) {
        return new Requisition();
    }
}
