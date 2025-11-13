package com.assettec.api.integration.CLIENTES.Excel;

import javax.swing.*;
import java.awt.*;

public class StyledLabel extends JLabel {
    public StyledLabel(String text) {
        super(text);
        setFont(new Font("Poppins", Font.BOLD, 13)); // Defina a fonte em negrito e tamanho maior
    }
}
