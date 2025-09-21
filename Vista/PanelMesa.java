package Vista;

import Modelo.Mesa;
import Modelo.Nodo;
import javax.swing.*;
import java.awt.*;

/**
 * PanelMesa se encarga de dibujar gráficamente la mesa circular
 * con los pastores alrededor. Cada pastor se representa con una
 * imagen y su oficio debajo.
 */
public class PanelMesa extends JPanel {

    private Mesa mesa;
    private Image imgPastor;

    public PanelMesa(Mesa mesa) {
        this.mesa = mesa;
        // Imagen genérica para representar a los pastores
        this.imgPastor = new ImageIcon(getClass().getResource("/imagenes/pastor.png")).getImage();
        setBackground(Color.WHITE);
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (mesa == null || mesa.getTamannio() == 0) return;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radio = 200;
        int n = mesa.getTamannio();

        Nodo actual = mesa.getHead();
        for (int i = 0; i < n; i++) {
            double angle = 2 * Math.PI * i / n;
            int x = (int) (centerX + radio * Math.cos(angle));
            int y = (int) (centerY + radio * Math.sin(angle));

            // Dibujar imagen del pastor
            g.drawImage(imgPastor, x - 25, y - 25, 50, 50, this);

            // Dibujar oficio
            g.setColor(Color.BLACK);
            g.drawString(actual.getPastor().getOficio(), x - 30, y + 40);

            actual = actual.getSiguiente();
        }

        // Dibujar círculo de la mesa
        g.setColor(Color.GRAY);
        g.drawOval(centerX - radio, centerY - radio, radio * 2, radio * 2);
    }
}
