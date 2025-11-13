package com.assettec.api.internal.core.entities.comment.setter;

import com.assettec.api.internal.core.entities.basic.setter.CodeSetter;
import com.assettec.api.internal.core.entities.comment.EntityComment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
@AllArgsConstructor
public class EntityCommentSetter {

    private CodeSetter codeSetter;

    public EntityComment setEntityComment(NodeList childNodes) {
        EntityComment entityComment = new EntityComment();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);

            if (childNode.getNodeName().equals("ENTITY")) entityComment.setEntity(childNode.getTextContent());
            if (childNode.getNodeName().equals("COMMENTTYPE")) entityComment.setCommentType(codeSetter.setCode(childNode.getChildNodes()));
            if (childNode.getNodeName().equals("ENTITYKEYCODE")) entityComment.setEntityKeyCode(childNode.getTextContent());
            if (childNode.getNodeName().equals("LANGUAGEID")) entityComment.setLanguage(codeSetter.setCode(childNode.getChildNodes()));
            if (childNode.getNodeName().equals("LINENUM")) entityComment.setLineNum(childNode.getTextContent());

        }

        return entityComment;
    }
}
