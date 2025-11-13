package com.assettec.api.integration.CLIENTES.comments;

import org.springframework.stereotype.Component;

import java.util.List;

import org.springframework.stereotype.Component;
import java.util.List;

public class CommentData {
    private String id;
    private String userCode;
    private String description;
    private String commentText;
    private boolean print;
    private String createdDate;
    private String languageCode;
    private String formattedCreatedTime;

    public String getId() { // Add the getter for the ID field
        return id;
    }

    public void setId(String id) { // Add the setter for the ID field
        this.id = id;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPrint() {
        return print;
    }

    public void setPrint(boolean print) {
        this.print = print;
    }

    public String getFormattedCreatedTime() {
        return formattedCreatedTime;
    }

    public void setFormattedCreatedTime(String formattedCreatedTime) {
        this.formattedCreatedTime = formattedCreatedTime;
    }
}
