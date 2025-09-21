package Controlador;

import Modelo.*;
import Vista.*;
import javax.swing.*;

/**
 * JuegoController conecta el modelo (Mesa, Pila, Generador)
 * con la vista (VentanaPrincipal, PanelMesa, PanelPila).
 */
public class JuegoControler {

    private Mesa mesa;
    private Pila pila;
    private Generador generador;
    private VentanaPrincipal ventana;

    public JuegoControler(int cantidadPastores) {
        mesa = new Mesa(null, null, 0);
        pila = new Pila();
        generador = new Generador();

        // Generar pastores iniciales
        for (int i = 0; i < cantidadPastores; i++) {
            mesa.addPastor(generador.generarPastor());
        }

        // Crear ventana principal con los paneles
        ventana = new VentanaPrincipal(mesa, pila);

        // Conectar botones
        conectarEventos();

        ventana.setVisible(true);
    }

    private void conectarEventos() {

        // Botón eliminar pastor (ejemplo: elimina el head)
        ventana.getBtnEliminar().addActionListener(e -> {
            if (mesa.getTamannio() > 0) {
                // Eliminar el primero de la mesa (head)
                Pastor eliminado = mesa.getHead().getPastor();
                mesa.deletePastor(eliminado);
                pila.push(eliminado);

                // Refrescar vistas
                ventana.getPanelMesa().repaint();
                ventana.getPanelPila().repaint();
            } else {
                JOptionPane.showMessageDialog(ventana, "No quedan pastores en la mesa.");
            }
        });
    }
}
