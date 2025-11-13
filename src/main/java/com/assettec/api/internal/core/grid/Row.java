package com.assettec.api.internal.core.grid;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.NodeList;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Row {
    private String id;
    private List<Field> fields;

    // Adicione este campo
    public String getDataByName(String name) {
        for (Field field : fields) {
            if (field.getName().equals(name)) {
                return field.getData();
            }
        }
        return null;
    }

    public String getDataByNodeName(String nodeName) {
        for (Field field : fields) {
            if (field.getName().equals(nodeName)) {
                return field.getData();
            }
        }
        return null;
    }


}











