package com.assettec.api.internal.core.entities.comment;

import com.assettec.api.internal.core.entities.basic.objects.InforEamCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntityComment {
    private String entity;
    private InforEamCode commentType;
    private String entityKeyCode;
    private InforEamCode language;
    private String lineNum;
}
