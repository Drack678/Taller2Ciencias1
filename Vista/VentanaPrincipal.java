package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private PanelOpciones panelOpciones;
    private PanelBotones panelBotones;
    private JPanel panelInferior; // contendrá los dos paneles con CardLayout

    public VentanaPrincipal() {
       
        setTitle("Juego de Pastores");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear paneles
        panelOpciones = new PanelOpciones();
        panelOpciones.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40)); // margen interno

        panelBotones = new PanelBotones();
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40)); // margen interno

        // Contenedor con CardLayout para intercambiar paneles
        panelInferior = new JPanel(new CardLayout());
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10)); // espacio con el borde de la ventana

        // Agregar los dos paneles al CardLayout
        panelInferior.add(panelOpciones, "opciones");
        panelInferior.add(panelBotones, "botones");

        // Mostrar primero las opciones
        mostrarPanelOpciones();

        // Listeners para alternar visibilidad
        panelOpciones.getComponent(0).addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarPanelBotones();
            }
        });

        panelOpciones.getComponent(1).addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarPanelBotones();
            }
        });

        panelBotones.getBtnRevivir().addActionListener(e -> mostrarPanelOpciones());
        panelBotones.getBtnEliminar().addActionListener(e -> mostrarPanelOpciones());
        panelBotones.getBtnRobar().addActionListener(e -> mostrarPanelOpciones());

        // Agregar panel inferior en el SUR
        add(panelInferior, BorderLayout.SOUTH);
        
    }

    private void mostrarPanelOpciones() {
        CardLayout cl = (CardLayout) panelInferior.getLayout();
        cl.show(panelInferior, "opciones");
    }

    private void mostrarPanelBotones() {
        CardLayout cl = (CardLayout) panelInferior.getLayout();
        cl.show(panelInferior, "botones");
    }

    // Para pruebas rápidas
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}
