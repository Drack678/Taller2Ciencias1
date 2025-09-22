package Vista;

import java.awt.FlowLayout;
import javax.swing.*;

/**
 * La clase PanelOpciones representa un panel con dos botones de dirección ("Izquierda" y "Derecha").
 * Este panel se utiliza para que el usuario seleccione una dirección en la interfaz gráfica del juego.
 */
public class PanelOpciones extends JPanel {
    private JButton izquierdaButton;
    private JButton derechaButton;

    /**
     * Constructor de PanelOpciones.
     * Inicializa el panel con los botones "Izquierda" y "Derecha" y los agrega al panel con un FlowLayout.
     */
    public PanelOpciones() {
        this.izquierdaButton = new JButton("Izquierda");
        this.derechaButton = new JButton("Derecha");
        this.setLayout(new FlowLayout());
        this.add(izquierdaButton);
        this.add(derechaButton);
    }

    /**
     * Obtiene el botón de dirección izquierda.
     * @return el botón "Izquierda".
     */
    public JButton getIzquierdaButton() {
        return izquierdaButton;
    }

    /**
     * Obtiene el botón de dirección derecha.
     * @return el botón "Derecha".
     */
    public JButton getDerechaButton() {
        return derechaButton;
    }
    
}