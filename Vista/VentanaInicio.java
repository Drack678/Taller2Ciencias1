package Vista;

import Controlador.JuegoControler;
import java.awt.*;
import javax.swing.*;

/**
 * VentanaInicio permite al usuario ingresar la cantidad de pastores
 * para iniciar el juego.
 */
public class VentanaInicio extends JFrame {

    private JTextField txtCantidad;
    private JButton btnIniciar;

    public VentanaInicio() {
        setTitle("Inicio del Juego - Pastores");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel lbl = new JLabel("Ingrese la cantidad de pastores:");
        txtCantidad = new JTextField(10);
        btnIniciar = new JButton("Iniciar Juego");

        gbc.gridx = 0; gbc.gridy = 0; add(lbl, gbc);
        gbc.gridx = 1; gbc.gridy = 0; add(txtCantidad, gbc);
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2; add(btnIniciar, gbc);

        // Acción del botón
        btnIniciar.addActionListener(e -> iniciarJuego());
    }

    private void iniciarJuego() {
        try {
            int n = Integer.parseInt(txtCantidad.getText().trim());
            if (n <= 0) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un número positivo.");
                return;
            }

            // Crear controlador que se encarga de iniciar el juego
            new JuegoControler(n);
            dispose(); // cerrar ventana de inicio

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaInicio().setVisible(true);
        });
    }
}
