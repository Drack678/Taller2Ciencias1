package Vista;

import Modelo.*;
import java.awt.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    
    private PanelMesa panelMesa;
    private PanelPila panelPila;
    private JButton btnReordenar;
    private JButton btnEliminar;
    
    public VentanaPrincipal(Mesa mesa, Pila pila) {
        setTitle("Juego de los Pastores");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelMesa = new PanelMesa(mesa);
        panelPila = new PanelPila(pila);
        add(panelMesa, BorderLayout.CENTER);
        add(panelPila, BorderLayout.EAST);

        // Botones abajo
        JPanel panelBotones = new JPanel();
        JButton btnReordenar = new JButton("Reordenar Mesa");
        JButton btnEliminar = new JButton("Eliminar Pastor");
        panelBotones.add(btnReordenar);
        panelBotones.add(btnEliminar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    public PanelMesa getPanelMesa() {
        return panelMesa;
    }

    public PanelPila getPanelPila() {
        return panelPila;
    }

    public JButton getBtnReordenar() {
        return btnReordenar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

}




