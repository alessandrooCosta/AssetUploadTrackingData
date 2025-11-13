package com.assettec.api.internal.core.entities.orders.workorder.utilities;


import com.assettec.api.internal.core.entities.basic.setter.*;
import com.assettec.api.internal.core.entities.comment.setter.CommentSetter;
import com.assettec.api.internal.core.entities.orders.workorder.WorkOrderAdditionalInfo;

import com.assettec.api.internal.core.entities.signature.ESignatureDetailSetter;
import com.assettec.api.internal.core.entities.orders.workorder.WorkOrder;
import com.assettec.api.internal.core.user.info.area.UserDefinedAreaSetter;
import com.assettec.api.internal.core.user.info.fields.UserDefinedFieldsSetter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class WorkOrderSetter {


    private CodeSetter codeSetter;
    private CurrencySetter currencySetter;
    private DateSetter dateSetter;
    private CountSetter countSetter;
    private CommentSetter commentSetter;
    private ESignatureDetailSetter eSignatureDetailSetter;


    private UserDefinedFieldsSetter userDefinedFieldsSetter;
    private UserDefinedAreaSetter userDefinedAreaSetter;

    public void setWorkOrder(WorkOrder workOrder, NodeList resultData) {
        NodeList resultDataNodes = resultData.item(0).getChildNodes();

        for (int i = 0; i < resultDataNodes.getLength(); i++) {

            Node node = resultDataNodes.item(i);

            if (node.getNodeName().equals("ENTEREDBY")) workOrder.setEnteredBy(node.getTextContent());
            if (node.getNodeName().equals("PROJBUD")) workOrder.setProjectBudget(node.getTextContent());
            if (node.getNodeName().equals("SAFETY")) workOrder.setSafety(node.getTextContent());
            if (node.getNodeName().equals("WARRANTY")) workOrder.setWarranty(node.getTextContent());
            if (node.getNodeName().equals("EQUIPMENTALIAS")) workOrder.setEquipmentAlias(node.getTextContent());
            if (node.getNodeName().equals("SERIALNUMBER")) workOrder.setSerialNumber(node.getTextContent());
            if (node.getNodeName().equals("MODEL")) workOrder.setModel(node.getTextContent());
            if (node.getNodeName().equals("SCHEDGROUP")) workOrder.setScheduledGroup(node.getTextContent());
            if (node.getNodeName().equals("SUPERVISORDESCRIPTION"))
                workOrder.setSupervisorDescription(node.getTextContent());
            if (node.getNodeName().equals("CNNUMBER")) workOrder.setCnNumber(node.getTextContent());
            if (node.getNodeName().equals("CHANGENOTICEDESCRIPTION"))
                workOrder.setChangeNoticeDescription(node.getTextContent());
            if (node.getNodeName().equals("METERUNIT")) workOrder.setMeterUnit(node.getTextContent());
            if (node.getNodeName().equals("MSPROJECT")) workOrder.setMsProject(node.getTextContent());
            if (node.getNodeName().equals("FIXED")) workOrder.setFixed(node.getTextContent());
            if (node.getNodeName().equals("DEPEND")) workOrder.setDepend(node.getTextContent());
            if (node.getNodeName().equals("OBJTYPE")) workOrder.setObjectType(node.getTextContent());
            if (node.getNodeName().equals("REOPENED")) workOrder.setReOpened(node.getTextContent());
            if (node.getNodeName().equals("FREQUENCY")) workOrder.setFrequency(node.getTextContent());
            if (node.getNodeName().equals("EVTISSTYPE")) workOrder.setEvtissType(node.getTextContent());
            if (node.getNodeName().equals("WORKPACKAGE")) workOrder.setWorkPackage(node.getTextContent());
            if (node.getNodeName().equals("ROUTEPARENT")) workOrder.setRouteParent(node.getTextContent());
            if (node.getNodeName().equals("BILLABLE")) workOrder.setBillable(node.getTextContent());
            if (node.getNodeName().equals("PRINTED")) workOrder.setPrinted(node.getTextContent());
            if (node.getNodeName().equals("PRINT")) workOrder.setPrint(node.getTextContent());
            if (node.getNodeName().equals("SOURCESYSTEM")) workOrder.setSourceSystem(node.getTextContent());
            if (node.getNodeName().equals("SOURCECODE")) workOrder.setSourceCode(node.getTextContent());
            if (node.getNodeName().equals("ROUTEDFROM")) workOrder.setRoutedFrom(node.getTextContent());
            if (node.getNodeName().equals("ACDCODE")) workOrder.setAcdCode(node.getTextContent());
            if (node.getNodeName().equals("CALLERNAME")) workOrder.setCallerName(node.getTextContent());
            if (node.getNodeName().equals("LEVEL1")) workOrder.setLevel1(node.getTextContent());
            if (node.getNodeName().equals("REJECTIONREASON")) workOrder.setRejectionReason(node.getTextContent());
            if (node.getNodeName().equals("INSPECTIONDIRECTIONCODE"))
                workOrder.setInspectionDirectionCode(node.getTextContent());
            if (node.getNodeName().equals("FLOWCODE")) workOrder.setFlowCode(node.getTextContent());
            if (node.getNodeName().equals("MULTIEQUIP")) workOrder.setMultiEquip(node.getTextContent());
            if (node.getNodeName().equals("CCTRSPCVALIDATION")) workOrder.setCctrspcValidation(node.getTextContent());
            if (node.getNodeName().equals("SURVEY")) workOrder.setSurvey(node.getTextContent());
            if (node.getNodeName().equals("SEQUENCE")) workOrder.setSequence(node.getTextContent());
            if (node.getNodeName().equals("JOBSEQUENCE")) workOrder.setJobSequence(node.getTextContent());
            if (node.getNodeName().equals("ACTIVITYNOTE")) workOrder.setActivityNote(node.getTextContent());
            if (node.getNodeName().equals("PRESERVECALCPRIORITY"))
                workOrder.setPreserveCalculatedPriority(node.getTextContent());
            if (node.getNodeName().equals("CURRENCYCODE")) workOrder.setCurrencyCode(node.getTextContent());
            if (node.getNodeName().equals("MANUFACTURERCODE")) workOrder.setManufacturerCode(node.getTextContent());
            if (node.getNodeName().equals("OEMSITE")) workOrder.setOemSite(node.getTextContent());
            if (node.getNodeName().equals("VENDOR")) workOrder.setVendor(node.getTextContent());
            if (node.getNodeName().equals("MINOR")) workOrder.setMinor(node.getTextContent());

            if (node.getNodeName().equals("EQUIPMENTID"))

            if (node.getNodeName().equals("DEPARTMENTID"))


            if (node.getNodeName().equals("STANDARDWO"))

            if (node.getNodeName().equals("SERVICEREQUESTID"))

            if (node.getNodeName().equals("PARENTWO"))

            if (node.getNodeName().equals("TRIGGEREVENT"))

            if (node.getNodeName().equals("CUSTOMERCONTRACTID"))

            if (node.getNodeName().equals("STATUS")) workOrder.setStatus(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("CREATEDBY"))
                workOrder.setCreatedBy(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("TYPE")) workOrder.setType(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("PROBLEMCODEID"))
                workOrder.setProblem(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("PRIORITY")) workOrder.setPriority(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("CRITICALITYID"))
                workOrder.setCriticality(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("REQUESTEDBY"))
                workOrder.setRequestedBy(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("ASSIGNEDTO"))
                workOrder.setAssignedTo(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("SCHEDULINGSESSIONTYPE"))
                workOrder.setSchedulingSessionType(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("FAILURECODEID"))
                workOrder.setFailure(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("CAUSECODEID")) workOrder.setCause(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("ACTIONCODEID"))
                workOrder.setAction(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("PERIODUOM"))
                workOrder.setPeriodUom(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("METERUOM2"))
                workOrder.setMeterUom2(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("ROUTESTATUS"))
                workOrder.setRouteStatus(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("ALERTID")) workOrder.setAlert(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("COVERAGETYPE"))
                workOrder.setCoverageType(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("WOTYPECATEGORYID"))
                workOrder.setWorkOrderTypeCategory(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("FAILUREMODEID"))
                workOrder.setFailureMode(codeSetter.setEntity(node.getChildNodes()));
            if (node.getNodeName().equals("SYMPTOMID")) workOrder.setSymptom(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("TACTICALCAUSEID"))
                workOrder.setTacticalCause(codeSetter.setEntity(node.getChildNodes()));
            if (node.getNodeName().equals("HUMANFACTORID"))
                workOrder.setHumanFactor(codeSetter.setEntity(node.getChildNodes()));
            if (node.getNodeName().equals("WORKMANSHIPID"))
                workOrder.setWorkmanShip(codeSetter.setEntity(node.getChildNodes()));
            if (node.getNodeName().equals("HUMANOVERSIGHTID"))
                workOrder.setHumanOversight(codeSetter.setEntity(node.getChildNodes()));
            if (node.getNodeName().equals("METHODOFDETECTIONID"))
                workOrder.setMethodOfDetection(codeSetter.setEntity(node.getChildNodes()));
            if (node.getNodeName().equals("TARGETVALUE"))
                workOrder.setTargetValue(currencySetter.setCurrency(node.getChildNodes()));
            if (node.getNodeName().equals("DOWNTIMECOSTVALUE"))
                workOrder.setDownTimeCost(currencySetter.setCurrency(node.getChildNodes()));
            if (node.getNodeName().equals("LASTMETERREADING"))
                workOrder.setLastMeterReading(countSetter.setCount(node.getChildNodes()));
            if (node.getNodeName().equals("DOWNTIMEHOURS"))
                workOrder.setDownTimeHours(countSetter.setCount(node.getChildNodes()));
            if (node.getNodeName().equals("METERDUE"))
                workOrder.setMeterDue(countSetter.setCount(node.getChildNodes()));
            if (node.getNodeName().equals("METERDUE2"))
                workOrder.setMeterDue2(countSetter.setCount(node.getChildNodes()));
            if (node.getNodeName().equals("REPORTED")) workOrder.setReported(dateSetter.setDate(node.getChildNodes()));
            if (node.getNodeName().equals("TARGETDATE"))
                workOrder.setTargetDate(dateSetter.setDate(node.getChildNodes()));
            if (node.getNodeName().equals("SCHEDEND"))
                workOrder.setScheduledEnd(dateSetter.setDate(node.getChildNodes()));
            if (node.getNodeName().equals("REQUESTEDSTART"))
                workOrder.setRequestedStart(dateSetter.setDate(node.getChildNodes()));
            if (node.getNodeName().equals("REQUESTEDEND"))
                workOrder.setRequestedEnd(dateSetter.setDate(node.getChildNodes()));
            if (node.getNodeName().equals("CREATEDDATE"))
                workOrder.setCreatedDate(dateSetter.setDate(node.getChildNodes()));
            if (node.getNodeName().equals("STARTDATE"))
                workOrder.setStartDate(dateSetter.setDate(node.getChildNodes()));
            if (node.getNodeName().equals("COMPLETEDDATE"))
                workOrder.setCompletedDate(dateSetter.setDate(node.getChildNodes()));
            if (node.getNodeName().equals("DUEDATE")) workOrder.setDueDate(dateSetter.setDate(node.getChildNodes()));
            if (node.getNodeName().equals("UserDefinedFields"))
                workOrder.setUserDefinedFields(userDefinedFieldsSetter.setUserDefinedFields(node.getChildNodes()));
            if (node.getFirstChild() != null && node.getNodeName().equals("USERDEFINEDAREA"))
                workOrder.setUserDefinedArea(userDefinedAreaSetter.setUserDefinedArea(node.getFirstChild().getChildNodes()));
            if (node.getNodeName().equals("CAMPAIGNSTATUS"))
                workOrder.setCampaignStatus(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("MAINTENANCEPATTERNID"))

            if (node.getNodeName().equals("ESignatureDetail"))
                workOrder.setESignatureDetail(eSignatureDetailSetter.setESignatureDetails(node.getChildNodes()));
            if (node.getNodeName().equals("SAFETYREVIEWEDBY"))
                workOrder.setSafetyReviewedBy(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("PERMITREVIEWEDBY"))
                workOrder.setPermitReviewedBy(codeSetter.setCode(node.getChildNodes()));
            if (node.getNodeName().equals("CALCULATEDPRIORITY"))
                workOrder.setCalculatedPriority(countSetter.setCount(node.getChildNodes()));
            if (node.getNodeName().equals("ESTIMATEDLABORCOST"))
                workOrder.setEstimatedLaborCost(currencySetter.setCurrency(node.getChildNodes()));
            if (node.getNodeName().equals("ESTIMATEDMATERIALCOST"))
                workOrder.setEstimatedMaterialCost(currencySetter.setCurrency(node.getChildNodes()));
            if (node.getNodeName().equals("ESTIMATEDMISCELLANEOUSCOST"))
                workOrder.setEstimatedMiscellaneousCost(currencySetter.setCurrency(node.getChildNodes()));
            if (node.getNodeName().equals("ESTIMATEDTOTALCOST"))
                workOrder.setEstimatedTotalCost(currencySetter.setCurrency(node.getChildNodes()));
            if (node.getNodeName().equals("WORKSPACEID"))

            if (node.getNodeName().equals("LATITUDE"))
                workOrder.setLatitude(countSetter.setCount(node.getChildNodes()));
            if (node.getNodeName().equals("LONGITUDE"))
                workOrder.setLongitude(countSetter.setCount(node.getChildNodes()));

        }
    }
}

//    public void setAdditionalData(WorkOrder workOrder, NodeList resultData) {
//        WorkOrderAdditionalInfo workOrderAdditionalInfo = new WorkOrderAdditionalInfo();
//
//        for (int i = 0; i < resultData.getLength(); i++) {
//
//            Node resultDataNode = resultData.item(i);
//
//            if (resultDataNode.getNodeName().equals("EQUIPMENTINFO")) workOrderAdditionalInfo.setEquipmentInfo(workOrderEquipmentInfoSetter.setWorkOrderEquipmentInfo(resultDataNode.getChildNodes()));
//            if (resultDataNode.getNodeName().equals("PERTYPE")) workOrderAdditionalInfo.setPerType(resultDataNode.getTextContent());
//            if (resultDataNode.getNodeName().equals("WORKDAY")) workOrderAdditionalInfo.setWorkDay(resultDataNode.getTextContent());
//            if (resultDataNode.getNodeName().equals("PMRVCTRL")) workOrderAdditionalInfo.setPmrvctrl(resultDataNode.getTextContent());
//            if (resultDataNode.getNodeName().equals("CURRENCYCODE")) workOrderAdditionalInfo.setCurrency(resultDataNode.getTextContent());
//            if (resultDataNode.getNodeName().equals("REOPENPM")) workOrderAdditionalInfo.setReOpenPM(resultDataNode.getTextContent());
//            if (resultDataNode.getNodeName().equals("COMPLETEDDATE")) workOrderAdditionalInfo.setCompletedDate(dateSetter.setDate(resultDataNode.getChildNodes()));
//            if (resultDataNode.getNodeName().equals("EVENTTYPE")) workOrderAdditionalInfo.setEventType(resultDataNode.getTextContent());
//            if (resultDataNode.getNodeName().equals("SYSTEMCOMPLETESTATUS")) workOrderAdditionalInfo.setSystemCompleteStatus(codeSetter.setCode(resultDataNode.getChildNodes()));
//            if (resultDataNode.getNodeName().equals("CURRENTDATETIME")) workOrderAdditionalInfo.setCurrentDateTime(dateSetter.setDate(resultDataNode.getChildNodes()));
//            if (resultDataNode.getNodeName().equals("GROUP")) workOrderAdditionalInfo.setGroup(resultDataNode.getTextContent());
//            if (resultDataNode.getNodeName().equals("PROJECTSTATUS")) workOrderAdditionalInfo.setProjectStatus(codeSetter.setCode(resultDataNode.getChildNodes()));
//            if (resultDataNode.getNodeName().equals("DUEDATE")) workOrderAdditionalInfo.setDueDate(dateSetter.setDate(resultDataNode.getChildNodes()));
//            if (resultDataNode.getNodeName().equals("SINGLECHECKLISTACTIVITY")) workOrderAdditionalInfo.setSingleChecklistActivity(resultDataNode.getTextContent());
//        }
//        workOrder.setWorkOrderAdditionalInfo(workOrderAdditionalInfo);
//    }
//}
