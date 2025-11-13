package com.assettec.api.internal.utilities.handlers;

import com.assettec.api.integration.CLIENTES.Activity.ActivityRequestBuilder;
import com.assettec.api.integration.CLIENTES.Excel.ExcelRequestBuilder;
import com.assettec.api.integration.CLIENTES.Excel.Modulos.Data.TrackingDataBuilder;
import com.assettec.api.integration.CLIENTES.Parts.PartsRequestBuilder;
import com.assettec.api.integration.CLIENTES.comments.CommentsRequestBuilder;

import com.assettec.api.integration.CLIENTES.laborbook.LaborBookingRequestBuilder;

import com.assettec.api.integration.CLIENTES.purchaseorder.AssetPurchaseOrderRequestBuilder;
import com.assettec.api.integration.CLIENTES.trackingdata.TrackingDataRequestBuilder;
import com.assettec.api.internal.utilities.requests.requestbuilders.*;

import com.assettec.api.internal.utilities.requests.requestbuilders.assetRequestBuilder.AssetRequestBuilder;
import com.assettec.api.internal.utilities.requests.requestbuilders.workOrderBuilder.WorkOrderRequestBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class RequestCreator {

    private TrackingDataBuilder trackingDataBuilder;
    private PartsRequestBuilder partsRequestBuilder;
    private ExcelRequestBuilder excelRequestBuilder;
    private ActivityRequestBuilder activityRequestBuilder;
    private WorkOrderRequestBuilder workOrderRequestBuilder;
    private AssetRequestBuilder assetRequestBuilder;


    private CommentsRequestBuilder commentsRequestBuilder;
    private LaborBookingRequestBuilder laborBookingRequestBuilder;
    private GridRequestBuilder gridRequestBuilder;
    private TrackingDataRequestBuilder trackingDataRequestBuilder;
    private AdministrationRequestBuilder administrationRequestBuilder;
    private AssetPurchaseOrderRequestBuilder assetPurchaseOrderRequestBuilder;


}
