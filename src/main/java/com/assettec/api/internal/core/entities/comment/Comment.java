package com.assettec.api.internal.core.entities.comment;

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
public class Comment {
    private EntityComment entityComment;

    private String commentText;
    private String print;
    private InforEamDate createdDate;

    private InforEamDate updatedDate;
    private InforEamCode createdBy;
    private InforEamCode updatedBy;

    private InforEamCode category;
    private InforEamCode organization;
    private String translatedText;

}
