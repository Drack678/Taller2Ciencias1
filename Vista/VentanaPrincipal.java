package Vista;

import javax.swing.*;
import java.awt.*;

/**
 * La clase VentanaPrincipal representa la ventana principal de la interfaz gráfica del juego de pastores.
 * Contiene los paneles superiores con información, el panel central para visualizar la estructura de la mesa,
 * y un panel inferior con opciones y botones de acción, gestionados mediante un CardLayout.
 */
public class VentanaPrincipal extends JFrame {

    private PanelOpciones panelOpciones;
    private PanelBotones panelBotones;
    private JPanel panelInferior;
    private PanelEstructuras panelEstructuras;

    /**
     * Constructor de VentanaPrincipal.
     * Inicializa la ventana, los paneles y organiza la disposición de los componentes.
     *
     * @param datos Arreglo de cadenas con la información de los elementos a mostrar en la mesa.
     */
    public VentanaPrincipal(String[] datos) {

        setTitle("Juego de Pastores");
        setSize(1500, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

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
        panelSuperior.add(Box.createVerticalStrut(10));
        panelSuperior.add(idPastor);
        panelSuperior.add(turnos);

        panelEstructuras = new PanelEstructuras();
        panelEstructuras.setElementos(datos);

        panelOpciones = new PanelOpciones();
        panelOpciones.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        panelBotones = new PanelBotones();
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        panelInferior = new JPanel(new CardLayout());
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));

        panelInferior.add(panelOpciones, "opciones");
        panelInferior.add(panelBotones, "botones");

        mostrarPanelOpciones();

        add(panelSuperior, BorderLayout.NORTH);
        add(panelEstructuras, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    /**
     * Muestra el panel de opciones en la parte inferior de la ventana.
     */
    public void mostrarPanelOpciones() {
        CardLayout cl = (CardLayout) panelInferior.getLayout();
        cl.show(panelInferior, "opciones");
    }

    /**
     * Muestra el panel de botones en la parte inferior de la ventana.
     */
    public void mostrarPanelBotones() {
        CardLayout cl = (CardLayout) panelInferior.getLayout();
        cl.show(panelInferior, "botones");
    }

    /**
     * Obtiene el panel de opciones.
     * @return el panel de opciones.
     */
    public PanelOpciones getPanelOpciones() {
        return panelOpciones;
    }

    /**
     * Obtiene el panel de botones.
     * @return el panel de botones.
     */
    public PanelBotones getPanelBotones() {
        return panelBotones;
    }

    /**
     * Obtiene el panel de estructuras (mesa).
     * @return el panel de estructuras.
     */
    public PanelEstructuras getPanelEstructuras() {
        return panelEstructuras;
    }

    /**
     * Método principal para ejecutar la ventana de prueba.
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        String[] datos = {"P1,10,5", "P2,15,3", "P3,8,7", "P4,20,2"};
        VentanaPrincipal ventana = new VentanaPrincipal(datos);
        ventana.setVisible(true);
    }
}