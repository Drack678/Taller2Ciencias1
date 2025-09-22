package Vista;

import java.awt.FlowLayout;

import javax.swing.*;

public class PanelOpciones extends JPanel {
    private JButton izquierdaButton;
    private JButton derechaButton;

    public PanelOpciones() {
        this.izquierdaButton = new JButton("Izquierda");
        this.derechaButton = new JButton("Derecha");
        this.add(izquierdaButton);
        this.add(derechaButton);
        this.setLayout(new FlowLayout());
    }
}
