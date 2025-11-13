package com.assettec.api.internal.core.entities.asset.common.objects;

import com.assettec.api.internal.core.entities.basic.objects.InforEamCode;
import com.assettec.api.internal.core.entities.basic.objects.InforEamCount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerInfo {
    private String manufacturerCode;
    private String serialNumber;
    private String model;
    private String modelRevision;
    private String hardwareVersion;
    private String softwareVersion;
    private String purchasingAsset;
    private String bioMedicalAsset;
    private InforEamCode umdNs;
    private String oemSite;
    private String vendor;
    private InforEamCode coverageType;
    private InforEamCount xCoordinate;
    private InforEamCount yCoordinate;
    private InforEamCount zCoordinate;
}
