package com.assettec.api.internal.core.entities.asset.equipment.utilities;


import com.assettec.api.internal.core.entities.asset.equipment.AssetEquipment;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AssetEquipmentSetter {

    private AssetUpdaterNew assetSetterNew;

    public AssetEquipment setAssetData(AssetEquipment asset, Document xmlData) {
        if (xmlData.getElementsByTagName("AssetEquipment").getLength() != 0) asset.setUpdatedCount(Integer.parseInt(xmlData.getElementsByTagName("AssetEquipment").item(0).getAttributes().getNamedItem("recordid").getTextContent()));
        if (xmlData.getElementsByTagName("PositionEquipment").getLength() != 0) asset.setUpdatedCount(Integer.parseInt(xmlData.getElementsByTagName("PositionEquipment").item(0).getAttributes().getNamedItem("recordid").getTextContent()));

        asset.setCode(xmlData.getElementsByTagName("EQUIPMENTCODE").item(0).getTextContent());
        if (xmlData.getElementsByTagName("AssetEquipment").getLength() != 0) asset.setOrganization(xmlData.getElementsByTagName("ASSETID").item(0).getChildNodes().item(1).getFirstChild().getTextContent());
        if (xmlData.getElementsByTagName("AssetEquipment").getLength() != 0) asset.setDescription(xmlData.getElementsByTagName("ASSETID").item(0).getLastChild().getTextContent());

        if (xmlData.getElementsByTagName("PositionEquipment").getLength() != 0) asset.setOrganization(xmlData.getElementsByTagName("POSITIONID").item(0).getChildNodes().item(1).getFirstChild().getTextContent());
        if (xmlData.getElementsByTagName("PositionEquipment").getLength() != 0) asset.setDescription(xmlData.getElementsByTagName("POSITIONID").item(0).getLastChild().getTextContent());

        asset.setType(xmlData.getElementsByTagName("TYPECODE").item(0).getTextContent());
        asset.setStatus(xmlData.getElementsByTagName("STATUSCODE").item(0).getTextContent());
        asset.setDepartment(xmlData.getElementsByTagName("DEPARTMENTCODE").item(0).getTextContent());

        asset.setInProduction(xmlData.getElementsByTagName("INPRODUCTION").getLength() != 0 ? xmlData.getElementsByTagName("INPRODUCTION").item(0).getTextContent() : "");
        asset.setSafety(xmlData.getElementsByTagName("SAFETY").getLength() != 0 ? xmlData.getElementsByTagName("SAFETY").item(0).getTextContent() : "");
        asset.setOutOfService(xmlData.getElementsByTagName("OUTOFSERVICE").getLength() != 0 ? xmlData.getElementsByTagName("OUTOFSERVICE").item(0).getTextContent() : "");

        Node commissionDate = xmlData.getElementsByTagName("COMMISSIONDATE").getLength() != 0 ? xmlData.getElementsByTagName("COMMISSIONDATE").item(0) : null;

        String year = commissionDate != null ? commissionDate.getFirstChild().getTextContent() : "";
        String month = commissionDate != null ? commissionDate.getChildNodes().item(1).getTextContent() : "";
        String day = commissionDate != null ? commissionDate.getChildNodes().item(2).getTextContent() : "";
        String hour = commissionDate != null ? commissionDate.getChildNodes().item(3).getTextContent() : "";
        String minute = commissionDate != null ? commissionDate.getChildNodes().item(4).getTextContent() : "";
        String second = commissionDate != null ? commissionDate.getChildNodes().item(5).getTextContent() : "";
        String nano = commissionDate != null ? commissionDate.getChildNodes().item(6).getTextContent() : "";
        String timeZone = commissionDate != null ? commissionDate.getLastChild().getTextContent() : "";

        if (commissionDate != null) {
            asset.setCommissionDate(LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), Integer.parseInt(nano)));
            asset.setCommissionDateTimeZone(timeZone);
        }

        asset.setValue(xmlData.getElementsByTagName("ASSETVALUE").getLength() != 0 ? xmlData.getElementsByTagName("ASSETVALUE").item(0).getFirstChild().getTextContent() : "");
        asset.setValueDecimals(xmlData.getElementsByTagName("ASSETVALUE").getLength() != 0 ? xmlData.getElementsByTagName("ASSETVALUE").item(0).getChildNodes().item(1).getTextContent() : "");

        asset.setDormantReuse(xmlData.getElementsByTagName("DORMANT").getLength() != 0 ? xmlData.getElementsByTagName("DORMANT").item(0).getTextContent() : "");
        asset.setSerialnumber(xmlData.getElementsByTagName("SERIALNUMBER").getLength() != 0 ? xmlData.getElementsByTagName("SERIALNUMBER").item(0).getTextContent() : "");
        asset.setModel(xmlData.getElementsByTagName("MODEL").getLength() != 0 ? xmlData.getElementsByTagName("MODEL").item(0).getTextContent() : "");

        asset.setIsVehicle(xmlData.getElementsByTagName("ISVEHICLE").getLength() != 0 ? xmlData.getElementsByTagName("ISVEHICLE").item(0).getTextContent() : "");
        asset.setIsRental(xmlData.getElementsByTagName("ISRENTAL").getLength() != 0 ? xmlData.getElementsByTagName("ISRENTAL").item(0).getTextContent() : "");
        asset.setIsContract(xmlData.getElementsByTagName("ISCONTRACT").getLength() != 0 ? xmlData.getElementsByTagName("ISCONTRACT").item(0).getTextContent() : "");

        asset.setCgMp(xmlData.getElementsByTagName("CGMP").getLength() != 0 ? xmlData.getElementsByTagName("CGMP").item(0).getTextContent() : "");

        asset.setLinkGisWo(xmlData.getElementsByTagName("LINKGISWO").getLength() != 0 ? xmlData.getElementsByTagName("LINKGISWO").item(0).getTextContent() : "");
        asset.setUtilityBillLevel(xmlData.getElementsByTagName("UTILITYBILLLEVEL").getLength() != 0 ? xmlData.getElementsByTagName("UTILITYBILLLEVEL").item(0).getTextContent() : "");

        asset.setGasTracked(xmlData.getElementsByTagName("GASTRACKED").getLength() != 0 ? xmlData.getElementsByTagName("GASTRACKED").item(0).getTextContent() : "");
        asset.setIsFacility(xmlData.getElementsByTagName("ISFACILITY").getLength() != 0 ? xmlData.getElementsByTagName("ISFACILITY").item(0).getTextContent() : "");
        asset.setResourceEnabled(xmlData.getElementsByTagName("RESOURCEENABLED").getLength() != 0 ? xmlData.getElementsByTagName("RESOURCEENABLED").item(0).getTextContent() : "");

        asset.setReliabilityRankingLocked(xmlData.getElementsByTagName("RELIABILITYRANKINGLOCKED").getLength() != 0 ? xmlData.getElementsByTagName("RELIABILITYRANKINGLOCKED").item(0).getTextContent() : "");
        asset.setProcessError(xmlData.getElementsByTagName("PROCESSERROR").getLength() != 0 ? xmlData.getElementsByTagName("PROCESSERROR").item(0).getTextContent() : "");
        asset.setEquipmentLengthOverride(xmlData.getElementsByTagName("EQUIPMENTLENGTHOVERRIDE").getLength() != 0 ? xmlData.getElementsByTagName("EQUIPMENTLENGTHOVERRIDE").item(0).getTextContent() : "");

        asset.setTempMonitored(xmlData.getElementsByTagName("TEMPMONITORED").getLength() != 0 ? xmlData.getElementsByTagName("TEMPMONITORED").item(0).getTextContent() : "");
        asset.setAccessible(xmlData.getElementsByTagName("ACCESSIBLE").getLength() != 0 ? xmlData.getElementsByTagName("ACCESSIBLE").item(0).getTextContent() : "");
        asset.setNonSmoking(xmlData.getElementsByTagName("NONSMOKING").getLength() != 0 ? xmlData.getElementsByTagName("NONSMOKING").item(0).getTextContent() : "");

        asset.setLockout(xmlData.getElementsByTagName("LOCKOUT").getLength() != 0 ? xmlData.getElementsByTagName("LOCKOUT").item(0).getTextContent() : "");
        asset.setPersonalProtectiveEquip(xmlData.getElementsByTagName("PERSONALPROTECTIVEEQUIP").getLength() != 0 ? xmlData.getElementsByTagName("PERSONALPROTECTIVEEQUIP").item(0).getTextContent() : "");
        asset.setConfinedSpace(xmlData.getElementsByTagName("CONFINEDSPACE").getLength() != 0 ? xmlData.getElementsByTagName("CONFINEDSPACE").item(0).getTextContent() : "");

        asset.setStatementOfCond(xmlData.getElementsByTagName("STATEMENTOFCOND").getLength() != 0 ? xmlData.getElementsByTagName("STATEMENTOFCOND").item(0).getTextContent() : "");
        asset.setBuildMainTProgram(xmlData.getElementsByTagName("BUILDMAINTPROGRAM").getLength() != 0 ? xmlData.getElementsByTagName("BUILDMAINTPROGRAM").item(0).getTextContent() : "");
        asset.setHipaaConfidentiality(xmlData.getElementsByTagName("HIPAACONFIDENTIALITY").getLength() != 0 ? xmlData.getElementsByTagName("HIPAACONFIDENTIALITY").item(0).getTextContent() : "");

        Node purchaseDate = xmlData.getElementsByTagName("PURCHASEDATE").getLength() != 0 ? xmlData.getElementsByTagName("PURCHASEDATE").item(0) : null;

        year = purchaseDate != null ? purchaseDate.getFirstChild().getTextContent() : "";
        month = purchaseDate != null ? purchaseDate.getChildNodes().item(1).getTextContent() : "";
        day = purchaseDate != null ? purchaseDate.getChildNodes().item(2).getTextContent() : "";
        hour = purchaseDate != null ? purchaseDate.getChildNodes().item(3).getTextContent() : "";
        minute = purchaseDate != null ? purchaseDate.getChildNodes().item(4).getTextContent() : "";
        second = purchaseDate != null ? purchaseDate.getChildNodes().item(5).getTextContent() : "";
        nano = purchaseDate != null ? purchaseDate.getChildNodes().item(6).getTextContent() : "";
        timeZone = purchaseDate != null ? purchaseDate.getLastChild().getTextContent() : "";

        if (purchaseDate != null) {
            asset.setPurchaseDate(LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), Integer.parseInt(nano)));
            asset.setPurchaseDateTimeZone(timeZone);
        }

        Node transferDate = xmlData.getElementsByTagName("TRANSFERDATE").getLength() != 0 ? xmlData.getElementsByTagName("TRANSFERDATE").item(0) : null;

        year = transferDate != null ? transferDate.getFirstChild().getTextContent() : "";
        month = transferDate != null ? transferDate.getChildNodes().item(1).getTextContent() : "";
        day = transferDate != null ? transferDate.getChildNodes().item(2).getTextContent() : "";
        hour = transferDate != null ? transferDate.getChildNodes().item(3).getTextContent() : "";
        minute = transferDate != null ? transferDate.getChildNodes().item(4).getTextContent() : "";
        second = transferDate != null ? transferDate.getChildNodes().item(5).getTextContent() : "";
        nano = transferDate != null ? transferDate.getChildNodes().item(6).getTextContent() : "";
        timeZone = transferDate != null ? transferDate.getLastChild().getTextContent() : "";

        if (transferDate != null) {
            asset.setTransferDate(LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), Integer.parseInt(nano)));
            asset.setTransferDateTimeZone(timeZone);
        }

        Node withdrawalDate = xmlData.getElementsByTagName("WITHDRAWALDATE").getLength() != 0 ? xmlData.getElementsByTagName("WITHDRAWALDATE").item(0) : null;

        year = withdrawalDate != null ? withdrawalDate.getFirstChild().getTextContent() : "";
        month = withdrawalDate != null ? withdrawalDate.getChildNodes().item(1).getTextContent() : "";
        day = withdrawalDate != null ? withdrawalDate.getChildNodes().item(2).getTextContent() : "";
        hour = withdrawalDate != null ? withdrawalDate.getChildNodes().item(3).getTextContent() : "";
        minute = withdrawalDate != null ? withdrawalDate.getChildNodes().item(4).getTextContent() : "";
        second = withdrawalDate != null ? withdrawalDate.getChildNodes().item(5).getTextContent() : "";
        nano = withdrawalDate != null ? withdrawalDate.getChildNodes().item(6).getTextContent() : "";
        timeZone = withdrawalDate != null ? withdrawalDate.getLastChild().getTextContent() : "";

        if (withdrawalDate != null) {
            asset.setWithdrawalDate(LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), Integer.parseInt(nano)));
            asset.setWithdrawalDateTimeZone(timeZone);
        }

        asset.setPurchaseCostValue(xmlData.getElementsByTagName("PURCHASECOST").getLength() != 0 ? xmlData.getElementsByTagName("PURCHASECOST").item(0).getFirstChild().getTextContent() : "");
        asset.setPurchaseCostDecimals(xmlData.getElementsByTagName("PURCHASECOST").getLength() != 0 ? xmlData.getElementsByTagName("PURCHASECOST").item(0).getChildNodes().item(1).getTextContent() : "");

//        Part associatedPart = new Part();
//        Store store = new Store();

        NodeList partId = xmlData.getElementsByTagName("PARTID");
        NodeList storeLocation = xmlData.getElementsByTagName("STORELOCATION");

//        associatedPart.setCode(partId.getLength() != 0 ? partId.item(0).getFirstChild().getTextContent() : "");
//        associatedPart.setOrganization(partId.getLength() != 0 ? partId.item(0).getChildNodes().item(1).getFirstChild().getTextContent() : "");
//        associatedPart.setDescription(partId.getLength() != 0 ? partId.item(0).getLastChild().getTextContent() : "");
////        associatedPart.setBin(storeLocation.getLength() != 0 ? storeLocation.item(0).getChildNodes().item(1).getTextContent() : "");
////        associatedPart.setLot(storeLocation.getLength() != 0 ? storeLocation.item(0).getLastChild().getTextContent() : "");
//
//        store.setCode(storeLocation.getLength() != 0 ? storeLocation.item(0).getFirstChild().getFirstChild().getTextContent() : "");
//        store.setOrganization(storeLocation.getLength() != 0 ? storeLocation.item(0).getFirstChild().getChildNodes().item(1).getFirstChild().getTextContent() : "");
//        store.setDescription(storeLocation.getLength() != 0 ? storeLocation.item(0).getFirstChild().getLastChild().getTextContent() : "");
//
//        asset.setAssociatedPart(associatedPart);
//        asset.setStoreLocation(store);

        Node originalInstallDate = xmlData.getElementsByTagName("ORIGINALINSTALLDATE").getLength() != 0 ? xmlData.getElementsByTagName("WITHDRAWALDATE").item(0) : null;

        year = originalInstallDate != null ? originalInstallDate.getFirstChild().getTextContent() : "";
        month = originalInstallDate != null ? originalInstallDate.getChildNodes().item(1).getTextContent() : "";
        day = originalInstallDate != null ? originalInstallDate.getChildNodes().item(2).getTextContent() : "";
        hour = originalInstallDate != null ? originalInstallDate.getChildNodes().item(3).getTextContent() : "";
        minute = originalInstallDate != null ? originalInstallDate.getChildNodes().item(4).getTextContent() : "";
        second = originalInstallDate != null ? originalInstallDate.getChildNodes().item(5).getTextContent() : "";
        nano = originalInstallDate != null ? originalInstallDate.getChildNodes().item(6).getTextContent() : "";
        timeZone = originalInstallDate != null ? originalInstallDate.getLastChild().getTextContent() : "";

        if (originalInstallDate != null) {
            asset.setOriginalInstallDate(LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), Integer.parseInt(nano)));
            asset.setOriginalInstallDateTimeZone(timeZone);
        }

        Node latestInstallDate = xmlData.getElementsByTagName("LATESTINSTALLDATE").getLength() != 0 ? xmlData.getElementsByTagName("WITHDRAWALDATE").item(0) : null;

        year = latestInstallDate != null ? latestInstallDate.getFirstChild().getTextContent() : "";
        month = latestInstallDate != null ? latestInstallDate.getChildNodes().item(1).getTextContent() : "";
        day = latestInstallDate != null ? latestInstallDate.getChildNodes().item(2).getTextContent() : "";
        hour = latestInstallDate != null ? latestInstallDate.getChildNodes().item(3).getTextContent() : "";
        minute = latestInstallDate != null ? latestInstallDate.getChildNodes().item(4).getTextContent() : "";
        second = latestInstallDate != null ? latestInstallDate.getChildNodes().item(5).getTextContent() : "";
        nano = latestInstallDate != null ? latestInstallDate.getChildNodes().item(6).getTextContent() : "";
        timeZone = latestInstallDate != null ? latestInstallDate.getLastChild().getTextContent() : "";

        if (originalInstallDate != null) {
            asset.setOriginalInstallDate(LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), Integer.parseInt(nano)));
            asset.setOriginalInstallDateTimeZone(timeZone);
        }

        NodeList resultDataChildNodes = xmlData.getElementsByTagName("ResultData").item(0).getChildNodes();
        return assetSetterNew.updateAsset(asset, resultDataChildNodes);
    }
}
