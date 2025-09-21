package Vista;

import Modelo.Pila;
import Modelo.Nodo;
import javax.swing.*;
import java.awt.*;

/**
 * PanelPila dibuja la pila de pastores eliminados.
 * Los muestra en forma de lista vertical (último eliminado arriba).
 */
public class PanelPila extends JPanel {

    private Pila pila;
    private Image imgPastor;

    public PanelPila(Pila pila) {
        this.pila = pila;
        this.imgPastor = new ImageIcon(getClass().getResource("/imagenes/pastor.png")).getImage();
        setPreferredSize(new Dimension(200, 0)); // ancho fijo
        setBackground(new Color(240, 240, 240));
    }

    public void setPila(Pila pila) {
        this.pila = pila;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (pila == null || pila.estaVacia()) {
            g.setColor(Color.DARK_GRAY);
            g.drawString("Pila vacía", 50, 20);
            return;
        }

        int x = 50;
        int y = 40;

        Nodo actual = pila.getCima(); // la cima está arriba
        while (actual != null) {
            // Dibujar imagen
            g.drawImage(imgPastor, x, y, 40, 40, this);

            // Dibujar oficio del pastor
            g.setColor(Color.BLACK);
            g.drawString(actual.getPastor().getOficio(), x + 50, y + 25);

            y += 60; // espacio entre pastores
            actual = actual.getSiguiente();
        }
    }
}
