package com.assettec.api.internal.core.entities.signature;

import com.assettec.api.internal.core.entities.basic.objects.InforEamCode;
import com.assettec.api.internal.core.entities.basic.objects.InforEamDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ESignatureDetail {
    private InforEamCode eSigner;
    private InforEamDate eSignatureDate;
    private String signatureType;
    private String eRecordCode;
}
