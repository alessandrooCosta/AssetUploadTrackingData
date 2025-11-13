package com.assettec.api.internal.core.entities.asset.equipment.utilities;

import com.assettec.api.internal.core.entities.basic.setter.*;
import com.assettec.api.internal.core.entities.asset.equipment.AssetEquipment;
import com.assettec.api.internal.core.user.info.area.UserDefinedAreaSetter;
import com.assettec.api.internal.core.user.info.fields.UserDefinedFieldsSetter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class AssetSetterNew {


    private CodeSetter codeSetter;
    private DateSetter dateSetter;
    private CountSetter countSetter;

    private CurrencySetter currencySetter;

    private UserDefinedFieldsSetter userDefinedFieldsSetter;

    public AssetEquipment setAsset(AssetEquipment asset, NodeList childNodes) {
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            String nodeName = childNode.getNodeName();


            if (nodeName.equals("OPERATIONALSTATUS")) asset.setOperationalStatus(codeSetter.setCode(childNode.getChildNodes()));

            if (nodeName.equals("CATEGORYID")) asset.setCategory(codeSetter.setCode(childNode.getChildNodes()));

            if (nodeName.equals("INPRODUCTION")) asset.setInProduction(childNode.getTextContent());
            if (nodeName.equals("SAFETY")) asset.setSafety(childNode.getTextContent());
            if (nodeName.equals("OUTOFSERVICE")) asset.setOutOfService(childNode.getTextContent());

            if (nodeName.equals("COMMISSIONDATE")) asset.setCommissionDateNew(dateSetter.setDate(childNode.getChildNodes()));
            if (nodeName.equals("TRANSFERDATE")) asset.setTransferDateNew(dateSetter.setDate(childNode.getChildNodes()));
            if (nodeName.equals("WITHDRAWALDATE")) asset.setWithdrawalDateNew(dateSetter.setDate(childNode.getChildNodes()));
            if (nodeName.equals("ASSETVALUE")) asset.setAssetValue(currencySetter.setCurrency(childNode.getChildNodes()));
            if (nodeName.equals("ASSIGNEDTO")) asset.setAssignedToNew(codeSetter.setCode(childNode.getChildNodes()));
            if (nodeName.equals("METERUNIT")) asset.setMeterUnit(childNode.getTextContent());
            if (nodeName.equals("CRITICALITYID")) asset.setCriticality(codeSetter.setCode(childNode.getChildNodes()));
            if (nodeName.equals("SOLDDATE")) asset.setSoldDate(dateSetter.setDate(childNode.getChildNodes()));

            if (nodeName.equals("INVENTORYVERIFICATIONDATE")) asset.setInventoryVerificationDate(dateSetter.setDate(childNode.getChildNodes()));

            if (nodeName.equals("CNID")) asset.setCnId(codeSetter.setCode(childNode.getChildNodes()));
            if (nodeName.equals("EQUIPMENTSTATEID")) asset.setEquipmentState(codeSetter.setCode(childNode.getChildNodes()));

            if (nodeName.equals("PARTLOCATIONCODE")) asset.setPartLocationCode(childNode.getTextContent());


            if (nodeName.equals("PREVENTWOCOMPLETION")) asset.setPreventWoCompletion(childNode.getTextContent());
            if (nodeName.equals("GISOBJID")) asset.setGisObj(childNode.getTextContent());
            if (nodeName.equals("GISPROFILE")) asset.setGisProfile(childNode.getTextContent());
            if (nodeName.equals("CGMP")) asset.setCgMp(childNode.getTextContent());
            if (nodeName.equals("LINKGISWO")) asset.setLinkGisWo(childNode.getTextContent());

            if (nodeName.equals("GISLAYER")) asset.setGislayer(childNode.getTextContent());
            if (nodeName.equals("XLOCATION")) asset.setXLocation(countSetter.setCount(childNode.getChildNodes()));
            if (nodeName.equals("YLOCATION")) asset.setYLocation(countSetter.setCount(childNode.getChildNodes()));

            if (nodeName.equals("RESOURCEENABLED")) asset.setResourceEnabled(childNode.getTextContent());
            if (nodeName.equals("EQUIPMENTALIAS")) asset.setEquipmentAlias(childNode.getTextContent());

            if (nodeName.equals("SAFETYDATEREVIEWREQUIRED")) asset.setSafetyDateReviewRequired(dateSetter.setDate(childNode.getChildNodes()));
            if (nodeName.equals("SAFETYREVIEWEDBY")) asset.setSafetyReviewedBy(codeSetter.setCode(childNode.getChildNodes()));
            if (nodeName.equals("PERMITDATEREVIEWREQUIRED")) asset.setPermitDateReviewRequired(dateSetter.setDate(childNode.getChildNodes()));
            if (nodeName.equals("PERMITREVIEWEDBY")) asset.setPermitReviewedBy(codeSetter.setCode(childNode.getChildNodes()));
            if (nodeName.equals("LOTODATEREVIEWREQUIRED")) asset.setLotoDateReviewRequired(dateSetter.setDate(childNode.getChildNodes()));
            if (nodeName.equals("LOTOREVIEWEDBY")) asset.setLotoReviewedBy(codeSetter.setCode(childNode.getChildNodes()));

            if (nodeName.equals("RISKMATRIXSETUPID")) asset.setRiskMatrixSetup(codeSetter.setCode(childNode.getChildNodes()));
            if (nodeName.equals("RISKPRIORITYNUMBER")) asset.setRiskPriorityNumber(countSetter.setCount(childNode.getChildNodes()));
            if (nodeName.equals("ORIGINALRECEIPTDATE")) asset.setOriginalReceiptDate(dateSetter.setDate(childNode.getChildNodes()));
            if (nodeName.equals("LATESTRECEIPTDATE")) asset.setLatestReceiptDate(dateSetter.setDate(childNode.getChildNodes()));
            if (nodeName.equals("ORIGINALINSTALLDATE")) asset.setOriginalInstallDateNew(dateSetter.setDate(childNode.getChildNodes()));
            if (nodeName.equals("LATESTINSTALLDATE")) asset.setLatestInstallDateNew(dateSetter.setDate(childNode.getChildNodes()));
            if (nodeName.equals("DOCUMOTOBOOKID")) asset.setDocuMotoBook(childNode.getTextContent());
            if (nodeName.equals("RESERVATIONCALENDAROWNER")) asset.setReservationCalendarOwner(codeSetter.setCode(childNode.getChildNodes()));

            if (nodeName.equals("SETPOSITION")) asset.setSetPosition(childNode.getTextContent());

            if (nodeName.equals("CONSISTPOSITION")) asset.setConsistPosition(childNode.getTextContent());
            if (nodeName.equals("URL")) asset.setUrl(childNode.getTextContent());

            if (nodeName.equals("CONDITIONSCORE")) asset.setConditionScore(countSetter.setCount(childNode.getChildNodes()));
            if (nodeName.equals("PROCESSERROR")) asset.setProcessError(childNode.getTextContent());
            if (nodeName.equals("LINEARUOMID")) asset.setLinearUom(codeSetter.setCode(childNode.getChildNodes()));
            if (nodeName.equals("EQUIPMENTLENGTHOVERRIDE")) asset.setEquipmentLengthOverride(childNode.getTextContent());
            if (nodeName.equals("TEMPMONITORED")) asset.setTempMonitored(childNode.getTextContent());

            if (nodeName.equals("PHONENUMBER")) asset.setPhoneNumber(childNode.getTextContent());
            if (nodeName.equals("ACCESSIBLE")) asset.setAccessible(childNode.getTextContent());
            if (nodeName.equals("NONSMOKING")) asset.setNonSmoking(childNode.getTextContent());
            if (nodeName.equals("HARDWAREVER")) asset.setHardwareVer(childNode.getTextContent());
            if (nodeName.equals("SOFTWAREVER")) asset.setSoftwareVer(childNode.getTextContent());
            if (nodeName.equals("PURCHASINGASSET")) asset.setPurchasingAsset(childNode.getTextContent());
            if (nodeName.equals("BIOMEDICALASSET")) asset.setBioMedicalAsset(childNode.getTextContent());
            if (nodeName.equals("UMDNS")) asset.setUmdns(codeSetter.setCode(childNode.getChildNodes()));
            if (nodeName.equals("OEMSITE")) asset.setOemSite(childNode.getTextContent());
            if (nodeName.equals("VENDOR")) asset.setVendor(childNode.getTextContent());
            if (nodeName.equals("COVERAGETYPE")) asset.setCoverageType(codeSetter.setCode(childNode.getChildNodes()));
            if (nodeName.equals("LOCKOUT")) asset.setLockout(childNode.getTextContent());
            if (nodeName.equals("PERSONALPROTECTIVEEQUIP")) asset.setPersonalProtectiveEquip(childNode.getTextContent());
            if (nodeName.equals("CONFINEDSPACE")) asset.setConfinedSpace(childNode.getTextContent());
            if (nodeName.equals("STATEMENTOFCOND")) asset.setStatementOfCondition(childNode.getTextContent());
            if (nodeName.equals("BUILDMAINTPROGRAM")) asset.setBuildMaintenanceProgram(childNode.getTextContent());
            if (nodeName.equals("HIPAACONFIDENTIALITY")) asset.setHipaaConfidentiality(childNode.getTextContent());
            if (nodeName.equals("OWNERSHIPTYPE")) asset.setOwnerShipType(codeSetter.setCode(childNode.getChildNodes()));
            if (nodeName.equals("PURCHASEORDERCODE")) asset.setPurchaseOrderCode(childNode.getTextContent());
            if (nodeName.equals("PURCHASEDATE")) asset.setPurchaseDateNew(dateSetter.setDate(childNode.getChildNodes()));
            if (nodeName.equals("PURCHASECOST")) asset.setPurchaseCost(currencySetter.setCurrency(childNode.getChildNodes()));
            if (nodeName.equals("PURCHASECURRENCY")) asset.setPurchaseCurrency(codeSetter.setCode(childNode.getChildNodes()));
            if (nodeName.equals("DISPOSALTYPE")) asset.setDisposalType(codeSetter.setCode(childNode.getChildNodes()));
            if (nodeName.equals("CHECKLISTFILTER")) asset.setCheckListFilter(childNode.getTextContent());
            if (nodeName.equals("TOLERANCESIZE")) asset.setToleranceSize(countSetter.setCount(childNode.getChildNodes()));
            if (nodeName.equals("FUELID")) asset.setFuelId(codeSetter.setCode(childNode.getChildNodes()));
            if (nodeName.equals("RISKPRIORITYCODE")) asset.setRiskPriorityCode(childNode.getTextContent());
            if (nodeName.equals("CRITICALITYSCORE")) asset.setCriticalityScore(countSetter.setCount(childNode.getChildNodes()));
            if (nodeName.equals("CORRECTIONCONDITIONSCORE")) asset.setCorrectionConditionScore(countSetter.setCount(childNode.getChildNodes()));
            if (nodeName.equals("CORRECTIONCONDITIONREASON")) asset.setCorrectionConditionReason(childNode.getTextContent());
            if (nodeName.equals("CORRECTIONCONDITIONDATE")) asset.setCorrectionConditionDate(dateSetter.setDate(childNode.getChildNodes()));
            if (nodeName.equals("CORRECTIONUSAGE")) asset.setCorrectionUsage(countSetter.setCount(childNode.getChildNodes()));
            if (nodeName.equals("CORRECTIONUSAGEUOM")) asset.setCorrectionUsageUom(codeSetter.setCode(childNode.getChildNodes()));
            if (nodeName.equals("ENDUSEFULLIFE")) asset.setEndUsefulLife(dateSetter.setDate(childNode.getChildNodes()));
            if (nodeName.equals("REMAININGUSEFULLIFE")) asset.setRemainingUsefulLife(countSetter.setCount(childNode.getChildNodes()));
            if (nodeName.equals("SERVICELIFEUSAGE")) asset.setServiceLifeUsage(countSetter.setCount(childNode.getChildNodes()));
            if (nodeName.equals("SERVICELIFEUSAGEUOM")) asset.setServiceLifeUsageUom(codeSetter.setCode(childNode.getChildNodes()));
            if (nodeName.equals("RISKCONSEQUENCECOST")) asset.setRiskConsequenceCost(currencySetter.setCurrency(childNode.getChildNodes()));
            if (nodeName.equals("FAILUREPROBPERCENTAGE")) asset.setFailureProbPercentage(countSetter.setCount(childNode.getChildNodes()));
            if (nodeName.equals("BLACKSWAN")) asset.setBlackSwan(childNode.getTextContent());
            if (nodeName.equals("BLACKSWANCOST")) asset.setBlackSwanCost(currencySetter.setCurrency(childNode.getChildNodes()));
            if (nodeName.equals("CURRENCYCODE")) asset.setCurrencyCode(childNode.getTextContent());
            if (nodeName.equals("UserDefinedFields")) asset.setUserDefinedFields(userDefinedFieldsSetter.setUserDefinedFields(childNode.getChildNodes()));
        }
        return asset;
    }
}
