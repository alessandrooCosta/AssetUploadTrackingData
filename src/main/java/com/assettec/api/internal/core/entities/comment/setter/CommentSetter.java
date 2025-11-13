package com.assettec.api.internal.core.entities.comment.setter;

import com.assettec.api.internal.core.entities.basic.setter.CodeSetter;
import com.assettec.api.internal.core.entities.basic.setter.DateSetter;
import com.assettec.api.internal.core.entities.comment.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class CommentSetter {

    private EntityCommentSetter entityCommentSetter;
    private DateSetter dateSetter;
    private CodeSetter codeSetter;

    public Comment setComment(NodeList childNodes) {
        Comment comment = new Comment();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeName().equals("ENTITYCOMMENTID")) comment.setEntityComment(entityCommentSetter.setEntityComment(childNode.getChildNodes()));
            if (childNode.getNodeName().equals("COMMENTTEXT")) comment.setCommentText(childNode.getTextContent());
            if (childNode.getNodeName().equals("PRINT")) comment.setPrint(childNode.getTextContent());
            if (childNode.getNodeName().equals("CREATEDDATE")) comment.setCreatedDate(dateSetter.setDate(childNode.getChildNodes()));
            if (childNode.getNodeName().equals("UPDATEDDATE")) comment.setUpdatedDate(dateSetter.setDate(childNode.getChildNodes()));
            if (childNode.getNodeName().equals("CREATEDBY")) comment.setCreatedBy(codeSetter.setCode(childNode.getChildNodes()));
            if (childNode.getNodeName().equals("UPDATEDBY")) comment.setUpdatedBy(codeSetter.setCode(childNode.getChildNodes()));
            if (childNode.getNodeName().equals("CATEGORYID")) comment.setCategory(codeSetter.setCode(childNode.getChildNodes()));
            if (childNode.getNodeName().equals("ORGANIZATIONID")) comment.setOrganization(codeSetter.setCode(childNode.getChildNodes()));
            if (childNode.getNodeName().equals("TRANSLATEDTEXT")) comment.setTranslatedText(childNode.getTextContent());
        }

        return comment;
    }
}
