package Vista;

import javax.swing.*;
import java.awt.*;

/**
 * VentanaInicio permite al usuario ingresar la cantidad de pastores
 * para iniciar el juego.
 */

public class PanelBotones extends JPanel {

    private JButton btnRevivir;
    private JButton btnEliminar;
    private JButton btnRobar;

    public PanelBotones() {
        setLayout(new BorderLayout(20, 0)); // separación horizontal de 20px
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Crear botones
        btnRevivir = new JButton("Revivir");
        btnEliminar = new JButton("Eliminar");
        btnRobar = new JButton("Robar");

        // Inicialmente ocultar botón "Robar"
        btnRobar.setVisible(false);

        // Añadir a las posiciones
        add(btnRevivir, BorderLayout.WEST);
        add(btnRobar, BorderLayout.CENTER);
        add(btnEliminar, BorderLayout.EAST);
    }
    /**
     * Muestra el botón "Robar" solo si el tesoro del pastor
     * seleccionado es menor que todos los demás.
     */
    public void validarBotonRobar(boolean esMenor) {
        btnRobar.setVisible(esMenor);
    }
    
    /**
     * @return the btnRevivir
     */
    public JButton getBtnRevivir() {
        return btnRevivir;
    }
    /**
     * @return the btnEliminar
     */
    public JButton getBtnEliminar() {
        return btnEliminar;
    }
    /**
     * @return the btnRobar
     */
    public JButton getBtnRobar() {
        return btnRobar;
    }

    

}
