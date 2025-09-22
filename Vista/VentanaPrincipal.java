package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private PanelOpciones panelOpciones;
    private PanelBotones panelBotones;
    private JPanel panelInferior; // contendrá los dos paneles con CardLayout
    private PanelEstructuras panelEstructuras; // el panel de la "mesa"

    public VentanaPrincipal(String[] datos) {

        setTitle("Juego de Pastores");
        setSize(1500, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 🔹 Panel superior con etiquetas
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Mesa redonda de iluminados de la sagrada orden del tío Sam", SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 22));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel idPastor = new JLabel("ID Pastor", SwingConstants.CENTER);
        idPastor.setFont(new Font("SansSerif", Font.PLAIN, 16));
        idPastor.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel turnos = new JLabel("Turnos", SwingConstants.CENTER);
        turnos.setFont(new Font("SansSerif", Font.PLAIN, 16));
        turnos.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelSuperior.add(titulo);
        panelSuperior.add(Box.createVerticalStrut(10)); // espacio entre labels
        panelSuperior.add(idPastor);
        panelSuperior.add(turnos);

        // 🔹 Panel de estructuras (centro)
        panelEstructuras = new PanelEstructuras();
        panelEstructuras.setElementos(datos);

        // 🔹 Paneles inferiores
        panelOpciones = new PanelOpciones();
        panelOpciones.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        panelBotones = new PanelBotones();
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        panelInferior = new JPanel(new CardLayout());
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));

        panelInferior.add(panelOpciones, "opciones");
        panelInferior.add(panelBotones, "botones");

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

        // 🔹 Agregar todo al Frame
        add(panelSuperior, BorderLayout.NORTH);
        add(panelEstructuras, BorderLayout.CENTER);
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
}

