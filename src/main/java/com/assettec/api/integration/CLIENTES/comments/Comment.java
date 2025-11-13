package com.assettec.api.integration.CLIENTES.comments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

        private int id;
        private String entity;
        private String code;
        private String userCode;
        private String line;
        private String description;
        private String print;
        private String createdDate;
        private String languageCode;

}
