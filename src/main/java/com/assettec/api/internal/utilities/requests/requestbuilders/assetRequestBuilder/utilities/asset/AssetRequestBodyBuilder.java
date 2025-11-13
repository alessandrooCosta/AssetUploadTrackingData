package com.assettec.api.internal.utilities.requests.requestbuilders.assetRequestBuilder.utilities.asset;

import com.assettec.api.internal.core.entities.asset.equipment.AssetEquipment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AssetRequestBodyBuilder {

    private AssetVerifier verifier;

    public String buildBody(AssetEquipment asset) {
        return  verifier.addAssetId(asset) +
                verifier.addType(asset) +
                verifier.addClassId(asset) +
                verifier.addStatus(asset) +
                verifier.addDepartment(asset) +
                verifier.addOperationalStatus(asset) +
                verifier.addLoanedToDepartment(asset) +
                verifier.addPmWoDepartment(asset) +
                verifier.addCategory(asset) +
                verifier.addProfileId(asset) +
                verifier.addInProductionSafetyOutOfService(asset) +
                verifier.addCostCode(asset) +
                verifier.addCommissionDate(asset) +
                verifier.addTransferDate(asset) +
                verifier.addWithdrawalDate(asset) +
                verifier.addAssetValue(asset) +
                verifier.addAssignedTo(asset) +
                verifier.addMeterUnit(asset) +
                verifier.addCriticality(asset) +
                verifier.addSoldDate(asset) +
                verifier.addDormant(asset) +
                verifier.addInventoryVerificationDate(asset) +
//                verifier.addPartAssociation(asset) +
                verifier.addManufacturerInfo(asset) +
                verifier.addFleetVehicleInfo(asset) +
                verifier.addCnId(asset) +
                verifier.addEquipmentStateId(asset) +
                verifier.addVmrsCode(asset) +
                verifier.addPartLocationCode(asset) +
                verifier.addPurchaseOrderInfo(asset) +
                verifier.addVariables(asset) +
                verifier.addPreventWoCompletion(asset) +
                verifier.addUserDefinedArea(asset) +
                verifier.addGisObjProfileCGMPLingGis(asset) +
                verifier.addGisMap(asset) +
                verifier.addGisLayer(asset) +
                verifier.addXYLocation(asset) +
//                verifier.addLinearReferenceDetails(asset) +
//                verifier.addCallCenterDetails(asset) +
//                verifier.addAssetParentHierarchy(asset) +
                verifier.addUserDefinedFields(asset) +
                verifier.addFacilityConditionIndex(asset) +

                verifier.addEquipmentAlias(asset) +
                verifier.addEnergyPerformance(asset) +
                verifier.addReviewRequiredBy(asset) +
                verifier.addLoto(asset) +
                verifier.addEquipmentConfiguration(asset) +
                verifier.addRcmLevel(asset) +
                verifier.addRisk(asset) +
                verifier.addReceiptInstallDate(asset) +
                verifier.addDocuReservationWorkSpace(asset) +
                verifier.addSet(asset) +
                verifier.addConsist(asset) +
                verifier.addURLCondition(asset) +
                verifier.addProcessErrortoDriver(asset) +
                verifier.addPhoneNumberToOwnerShipType(asset) +
                verifier.addPurchase(asset) +
                verifier.addDisposalTypeToRiskPriority(asset) +
                verifier.addCriticalityToCorrectionUseageUom(asset) +
                verifier.addLifeToProfile(asset)+

                verifier.addEnding(asset);
    }
}
