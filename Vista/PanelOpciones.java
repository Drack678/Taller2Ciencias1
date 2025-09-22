package Vista;

import java.awt.FlowLayout;
import javax.swing.*;

public class PanelOpciones extends JPanel {
    private JButton izquierdaButton;
    private JButton derechaButton;

    public PanelOpciones() {
        this.izquierdaButton = new JButton("Izquierda");
        this.derechaButton = new JButton("Derecha");
        this.setLayout(new FlowLayout());
        this.add(izquierdaButton);
        this.add(derechaButton);
    }

    /**
     * @return the izquierdaButton
     */
    public JButton getIzquierdaButton() {
        return izquierdaButton;
    }

    /**
     * @return the derechaButton
     */
    public JButton getDerechaButton() {
        return derechaButton;
    }
    
}
