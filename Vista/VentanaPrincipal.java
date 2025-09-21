package Vista;

import Modelo.*;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private PanelMesa panelMesa;
    private PanelPila panelPila;

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

    public static void main(String[] args) {
        // Demo con 5 pastores
        Mesa mesa = new Mesa(null, null, 0);
        Pila pila = new Pila();
        Generador gen = new Generador();

        for (int i = 0; i < 5; i++) {
            mesa.addPastor(gen.generarPastor());
        }

        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal(mesa, pila).setVisible(true);
        });
    }
}
