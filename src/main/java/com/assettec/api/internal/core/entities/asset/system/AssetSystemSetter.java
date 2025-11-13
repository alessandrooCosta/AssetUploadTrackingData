package com.assettec.api.internal.core.entities.asset.system;

import com.assettec.api.internal.core.entities.basic.setter.*;

import com.assettec.api.internal.core.user.info.area.UserDefinedAreaSetter;
import com.assettec.api.internal.core.user.info.fields.UserDefinedFieldsSetter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class AssetSystemSetter {


    private DateSetter dateSetter;
    private CodeSetter codeSetter;
    private CountSetter countSetter;

    private CurrencySetter currencySetter;

    private UserDefinedAreaSetter userDefinedAreaSetter;

    private UserDefinedFieldsSetter userDefinedFieldsSetter;


    public void setSystem(AssetSystem system, NodeList nodes) {

        for (int i = 0; i < nodes.getLength(); i++) {
            Node childNode = nodes.item(i);
            String name = childNode.getNodeName();


            if (name.equals("TYPE")) system.setType(codeSetter.setCode(childNode.getChildNodes()));

            if (name.equals("CATEGORYID")) system.setCategoryId(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("STATUS")) system.setStatus(codeSetter.setCode(childNode.getChildNodes()));

            if (name.equals("OPERATIONALSTATUS")) system.setOperationalStatus(codeSetter.setCode(childNode.getChildNodes()));


            if (name.equals("INPRODUCTION")) system.setInProduction(childNode.getTextContent());
            if (name.equals("SAFETY")) system.setSafety(childNode.getTextContent());
            if (name.equals("OUTOFSERVICE")) system.setOutOfService(childNode.getTextContent());

            if (name.equals("COMMISSIONDATE")) system.setCommissionDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("TRANSFERDATE")) system.setTransferDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("WITHDRAWALDATE")) system.setWithdrawalDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("ASSIGNEDTO")) system.setAssignedTo(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("METERUNIT")) system.setMeterUnit(childNode.getTextContent());
            if (name.equals("CRITICALITYID")) system.setCriticalityId(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("SOLDDATE")) system.setSoldDate(dateSetter.setDate(childNode.getChildNodes()));

            if (name.equals("PREVENTWOCOMPLETION")) system.setPreventWoCompletion(childNode.getTextContent());
            if (name.equals("USERDEFINEDAREA") && childNode.getFirstChild() != null) system.setUserDefinedArea(userDefinedAreaSetter.setUserDefinedArea(childNode.getFirstChild().getChildNodes()));
            if (name.equals("GISOBJID")) system.setGisObjId(childNode.getTextContent());
            if (name.equals("GISPROFILE")) system.setGisProfile(childNode.getTextContent());
            if (name.equals("CGMP")) system.setCgMp(childNode.getTextContent());
            if (name.equals("LINKGISWO")) system.setLinkGisWo(childNode.getTextContent());
            if (name.equals("VMRSCODE") && childNode.getFirstChild() != null) system.setSystemLevelId(codeSetter.setCode(childNode.getFirstChild().getChildNodes()));
            if (name.equals("PARTLOCATIONCODE")) system.setPartLocationCode(childNode.getTextContent());

            if (name.equals("GISLAYER")) system.setGisLayer(childNode.getTextContent());
            if (name.equals("XLOCATION")) system.setXLocation(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("YLOCATION")) system.setYLocation(countSetter.setCount(childNode.getChildNodes()));

            if (name.equals("UserDefinedFields")) system.setUserDefinedFields(userDefinedFieldsSetter.setUserDefinedFields(childNode.getChildNodes()));

            if (name.equals("RESOURCEENABLED")) system.setResourceEnabled(childNode.getTextContent());

            if (name.equals("EQUIPMENTALIAS")) system.setEquipmentAlias(childNode.getTextContent());

            if (name.equals("LOCKOUT")) system.setLockout(childNode.getTextContent());
            if (name.equals("PERSONALPROTECTIVEEQUIP")) system.setPersonalProtectiveEquipment(childNode.getTextContent());
            if (name.equals("CONFINEDSPACE")) system.setConfinedSpace(childNode.getTextContent());
            if (name.equals("STATEMENTOFCOND")) system.setStatementOfCondition(childNode.getTextContent());
            if (name.equals("BUILDMAINTPROGRAM")) system.setBuildMaintenanceProgram(childNode.getTextContent());
            if (name.equals("HIPAACONFIDENTIALITY")) system.setHipaaConfidentiality(childNode.getTextContent());
            if (name.equals("OWNERSHIPTYPE")) system.setOwnershipType(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("INVENTORYVERIFICATIONDATE")) system.setInventoryVerificationDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("ASSETVALUE")) system.setAssetValue(currencySetter.setCurrency(childNode.getChildNodes()));
            if (name.equals("PURCHASEORDERCODE")) system.setPurchaseOrderCode(childNode.getTextContent());
            if (name.equals("PURCHASEDATE")) system.setPurchaseDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("PURCHASECOST")) system.setPurchaseCost(currencySetter.setCurrency(childNode.getChildNodes()));
            if (name.equals("PURCHASECURRENCY")) system.setPurchaseCurrency(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("DISPOSALTYPE")) system.setDisposalType(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("SAFETYDATEREVIEWREQUIRED")) system.setSafetyReviewRequired(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("SAFETYREVIEWEDBY")) system.setSafetyReviewedBy(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("PERMITDATEREVIEWREQUIRED")) system.setPermitDateReviewRequired(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("PERMITREVIEWEDBY")) system.setPermitReviewedBy(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("LOTODATEREVIEWREQUIRED")) system.setLotoDateReviewRequired(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("LOTOREVIEWEDBY")) system.setLotoReviewedBy(codeSetter.setCode(childNode.getChildNodes()));

            if (name.equals("RISKMATRIXSETUPID")) system.setRiskMatrixSetupId(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("RISKPRIORITYNUMBER")) system.setRiskPriorityNumber(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("ORIGINALRECEIPTDATE")) system.setOriginalReceiptDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("LATESTRECEIPTDATE")) system.setLatestReceiptDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("ORIGINALINSTALLDATE")) system.setOriginalInstallDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("LATESTINSTALLDATE")) system.setLatestInstallDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("DOCUMOTOBOOKID")) system.setDocuMotoBookId(childNode.getTextContent());



            if (name.equals("SETPOSITION")) system.setSetPosition(childNode.getTextContent());

            if (name.equals("CONSISTPOSITION")) system.setConsistPosition(childNode.getTextContent());
            if (name.equals("URL")) system.setUrl(childNode.getTextContent());

            if (name.equals("CONDITIONSCORE")) system.setConditionScore(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("PROCESSERROR")) system.setProcessError(childNode.getTextContent());
            if (name.equals("LINEARUOMID")) system.setLinearUomId(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("EQUIPMENTLENGTHOVERRIDE")) system.setEquipmentLengthOverride(childNode.getTextContent());
            if (name.equals("CHECKLISTFILTER")) system.setCheckListFilter(childNode.getTextContent());
            if (name.equals("TOLERANCESIZE")) system.setToleranceSize(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("TEMPMONITORED")) system.setTempMonitored(childNode.getTextContent());
            if (name.equals("FUELID")) system.setFuelId(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("RISKPRIORITYCODE")) system.setRiskPriorityCode(childNode.getTextContent());
            if (name.equals("CRITICALITYSCORE")) system.setCriticalityScore(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("CORRECTIONCONDITIONSCORE")) system.setCorrectionConditionScore(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("CORRECTIONCONDITIONREASON")) system.setCorrectionConditionReason(childNode.getTextContent());
            if (name.equals("CORRECTIONCONDITIONDATE")) system.setCorrectionConditionDate(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("CORRECTIONUSAGE")) system.setCorrectionUsage(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("CORRECTIONUSAGEUOM")) system.setCorrectionUsageUom(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("ENDUSEFULLIFE")) system.setEndUsefulLife(dateSetter.setDate(childNode.getChildNodes()));
            if (name.equals("REMAININGUSEFULLIFE")) system.setRemainingUsefulLife(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("SERVICELIFEUSAGE")) system.setServiceLifeUsage(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("SERVICELIFEUSAGEUOM")) system.setServiceLifeUsageUom(codeSetter.setCode(childNode.getChildNodes()));

            if (name.equals("RISKCONSEQUENCECOST")) system.setRiskConsequenceCost(currencySetter.setCurrency(childNode.getChildNodes()));
            if (name.equals("FAILUREPROBPERCENTAGE")) system.setFailureProbabilityPercentage(countSetter.setCount(childNode.getChildNodes()));
            if (name.equals("BLACKSWANCOST")) system.setBlackSwanCost(currencySetter.setCurrency(childNode.getChildNodes()));
            if (name.equals("BLACKSWAN")) system.setBlackSwan(childNode.getTextContent());
            if (name.equals("CURRENCYCODE")) system.setCurrencyCode(childNode.getTextContent());

            if (name.equals("HARDWAREVER")) system.setHardwareVersion(childNode.getTextContent());
            if (name.equals("SOFTWAREVER")) system.setSoftwareVersion(childNode.getTextContent());
            if (name.equals("PURCHASINGASSET")) system.setPurchasingAsset(childNode.getTextContent());
            if (name.equals("BIOMEDICALASSET")) system.setBioMedicalAsset(childNode.getTextContent());
            if (name.equals("UMDNS")) system.setUdmNs(codeSetter.setCode(childNode.getChildNodes()));
            if (name.equals("OEMSITE")) system.setOemSite(childNode.getTextContent());
            if (name.equals("VENDOR")) system.setVendor(childNode.getTextContent());
            if (name.equals("COVERAGETYPE")) system.setCoverageType(codeSetter.setCode(childNode.getChildNodes()));
        }

    }
}
