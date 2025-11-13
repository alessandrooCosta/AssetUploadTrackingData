package com.assettec.api.internal.core.entities.asset.position;

import com.assettec.api.internal.core.entities.basic.setter.*;

import com.assettec.api.internal.core.user.info.area.UserDefinedAreaSetter;
import com.assettec.api.internal.core.user.info.fields.UserDefinedFieldsSetter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class AssetPositionSetter {


    private DateSetter dateSetter;
    private CodeSetter codeSetter;
    private CountSetter countSetter;

    private CurrencySetter currencySetter;

    private UserDefinedAreaSetter userDefinedAreaSetter;

    private UserDefinedFieldsSetter userDefinedFieldsSetter;


    public void setPosition(AssetPosition position, NodeList nodes) {

        for (int i = 0; i < nodes.getLength(); i++) {
            Node childNode = nodes.item(i);
            String name = childNode.getNodeName();


            if (name.equals("TYPE")) position.setType(codeSetter.setCode(childNode.getChildNodes()));

            if (name.equals("CATEGORYID")) position.setCategoryId(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("STATUS")) position.setStatus(codeSetter.setCode(childNode.getChildNodes()));

            if (name.equals("OPERATIONALSTATUS")) position.setOperationalStatus(codeSetter.setCode(childNode.getChildNodes()));

            if (name.equals("INPRODUCTION")) position.setInProduction(childNode.getTextContent());
            if (name.equals("SAFETY")) position.setSafety(childNode.getTextContent());
            if (name.equals("OUTOFSERVICE")) position.setOutOfService(childNode.getTextContent());

            if (name.equals("COMMISSIONDATE")) position.setCommissionDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("TRANSFERDATE")) position.setTransferDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("WITHDRAWALDATE")) position.setWithdrawalDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("ASSIGNEDTO")) position.setAssignedTo(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("METERUNIT")) position.setMeterUnit(childNode.getTextContent());
            if (name.equals("CRITICALITYID")) position.setCriticalityId(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("SOLDDATE")) position.setSoldDate(dateSetter.setDate(childNode.getChildNodes()));

            if (name.equals("PREVENTWOCOMPLETION")) position.setPreventWoCompletion(childNode.getTextContent());
            if (name.equals("USERDEFINEDAREA") && childNode.getFirstChild() != null) position.setUserDefinedArea(userDefinedAreaSetter.setUserDefinedArea(childNode.getFirstChild().getChildNodes()));
            if (name.equals("GISOBJID")) position.setGisObjId(childNode.getTextContent());
            if (name.equals("GISPROFILE")) position.setGisProfile(childNode.getTextContent());
            if (name.equals("CGMP")) position.setCgMp(childNode.getTextContent());
            if (name.equals("LINKGISWO")) position.setLinkGisWo(childNode.getTextContent());
            if (name.equals("VMRSCODE") && childNode.getFirstChild() != null) position.setSystemLevelId(codeSetter.setCode(childNode.getFirstChild().getChildNodes()));
            if (name.equals("PARTLOCATIONCODE")) position.setPartLocationCode(childNode.getTextContent());

            if (name.equals("GISLAYER")) position.setGisLayer(childNode.getTextContent());
            if (name.equals("XLOCATION")) position.setXLocation(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("YLOCATION")) position.setYLocation(countSetter.setCount(childNode.getChildNodes()));

            if (name.equals("UserDefinedFields")) position.setUserDefinedFields(userDefinedFieldsSetter.setUserDefinedFields(childNode.getChildNodes()));

            if (name.equals("RESOURCEENABLED")) position.setResourceEnabled(childNode.getTextContent());

            if (name.equals("EQUIPMENTALIAS")) position.setEquipmentAlias(childNode.getTextContent());

            if (name.equals("LOCKOUT")) position.setLockout(childNode.getTextContent());
            if (name.equals("PERSONALPROTECTIVEEQUIP")) position.setPersonalProtectiveEquipment(childNode.getTextContent());
            if (name.equals("CONFINEDSPACE")) position.setConfinedSpace(childNode.getTextContent());
            if (name.equals("STATEMENTOFCOND")) position.setStatementOfCondition(childNode.getTextContent());
            if (name.equals("BUILDMAINTPROGRAM")) position.setBuildMaintenanceProgram(childNode.getTextContent());
            if (name.equals("HIPAACONFIDENTIALITY")) position.setHipaaConfidentiality(childNode.getTextContent());
            if (name.equals("OWNERSHIPTYPE")) position.setOwnershipType(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("INVENTORYVERIFICATIONDATE")) position.setInventoryVerificationDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("ASSETVALUE")) position.setAssetValue(currencySetter.setCurrency(childNode.getChildNodes()));
            if (name.equals("PURCHASEORDERCODE")) position.setPurchaseOrderCode(childNode.getTextContent());
            if (name.equals("PURCHASEDATE")) position.setPurchaseDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("PURCHASECOST")) position.setPurchaseCost(currencySetter.setCurrency(childNode.getChildNodes()));
            if (name.equals("PURCHASECURRENCY")) position.setPurchaseCurrency(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("DISPOSALTYPE")) position.setDisposalType(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("SAFETYDATEREVIEWREQUIRED")) position.setSafetyReviewRequired(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("SAFETYREVIEWEDBY")) position.setSafetyReviewedBy(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("PERMITDATEREVIEWREQUIRED")) position.setPermitDateReviewRequired(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("PERMITREVIEWEDBY")) position.setPermitReviewedBy(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("LOTODATEREVIEWREQUIRED")) position.setLotoDateReviewRequired(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("LOTOREVIEWEDBY")) position.setLotoReviewedBy(codeSetter.setCode(childNode.getChildNodes()));

            if (name.equals("RISKMATRIXSETUPID")) position.setRiskMatrixSetupId(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("RISKPRIORITYNUMBER")) position.setRiskPriorityNumber(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("ORIGINALRECEIPTDATE")) position.setOriginalReceiptDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("LATESTRECEIPTDATE")) position.setLatestReceiptDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("ORIGINALINSTALLDATE")) position.setOriginalInstallDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("LATESTINSTALLDATE")) position.setLatestInstallDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("DOCUMOTOBOOKID")) position.setDocuMotoBookId(childNode.getTextContent());
            if (name.equals("RESERVATIONCALENDAROWNER")) position.setReservationCalendarOwner(codeSetter.setCode(childNode.getChildNodes()));

            if (name.equals("SETPOSITION")) position.setSetPosition(childNode.getTextContent());

            if (name.equals("CONSISTPOSITION")) position.setConsistPosition(childNode.getTextContent());
            if (name.equals("URL")) position.setUrl(childNode.getTextContent());

            if (name.equals("CONDITIONSCORE")) position.setConditionScore(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("PROCESSERROR")) position.setProcessError(childNode.getTextContent());
            if (name.equals("LINEARUOMID")) position.setLinearUomId(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("EQUIPMENTLENGTHOVERRIDE")) position.setEquipmentLengthOverride(childNode.getTextContent());
            if (name.equals("CHECKLISTFILTER")) position.setCheckListFilter(childNode.getTextContent());
            if (name.equals("TOLERANCESIZE")) position.setToleranceSize(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("TEMPMONITORED")) position.setTempMonitored(childNode.getTextContent());
            if (name.equals("FUELID")) position.setFuelId(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("RISKPRIORITYCODE")) position.setRiskPriorityCode(childNode.getTextContent());
            if (name.equals("CRITICALITYSCORE")) position.setCriticalityScore(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("CORRECTIONCONDITIONSCORE")) position.setCorrectionConditionScore(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("CORRECTIONCONDITIONREASON")) position.setCorrectionConditionReason(childNode.getTextContent());
            if (name.equals("CORRECTIONCONDITIONDATE")) position.setCorrectionConditionDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("CORRECTIONUSAGE")) position.setCorrectionUsage(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("CORRECTIONUSAGEUOM")) position.setCorrectionUsageUom(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("ENDUSEFULLIFE")) position.setEndUsefulLife(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("REMAININGUSEFULLIFE")) position.setRemainingUsefulLife(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("SERVICELIFEUSAGE")) position.setServiceLifeUsage(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("SERVICELIFEUSAGEUOM")) position.setServiceLifeUsageUom(codeSetter.setCode(childNode.getChildNodes()));

            if (name.equals("RISKCONSEQUENCECOST")) position.setRiskConsequenceCost(currencySetter.setCurrency(childNode.getChildNodes()));
            if (name.equals("FAILUREPROBPERCENTAGE")) position.setFailureProbabilityPercentage(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("BLACKSWANCOST")) position.setBlackSwanCost(currencySetter.setCurrency(childNode.getChildNodes()));
            if (name.equals("BLACKSWAN")) position.setBlackSwan(childNode.getTextContent());
            if (name.equals("CURRENCYCODE")) position.setCurrencyCode(childNode.getTextContent());
        }

    }
}
