package Vista;

import javax.swing.*;
import java.awt.*;

public class PanelEstructuras extends JPanel {
    private String[] elementos;

    public void setElementos(String[] datos) {
        this.elementos = datos;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (elementos == null || elementos.length == 0) return;

        int n = elementos.length;

        // 🔹 Centro en 1/3 del ancho y centrado verticalmente
        int centroX = getWidth() / 3;
        int centroY = getHeight() / 2;

        // 🔹 Dibuja el círculo azul central
        int diametroCentro = 200;
        int radioCentro = diametroCentro / 2;

        g.setColor(new Color(200, 220, 255));
        g.fillOval(centroX - radioCentro, centroY - radioCentro, diametroCentro, diametroCentro);

        g.setColor(Color.BLACK);
        g.drawOval(centroX - radioCentro, centroY - radioCentro, diametroCentro, diametroCentro);

        // 🔹 Dibuja los nodos alrededor del círculo azul
        int radio = Math.min(getWidth(), getHeight()) / 3;
        int diametroNodo = 120; 
        int radioNodo = diametroNodo / 2;

        for (int i = 0; i < n; i++) {
            double angulo = 2 * Math.PI * i / n;
            int x = (int) (centroX + radio * Math.cos(angulo));
            int y = (int) (centroY + radio * Math.sin(angulo));

            // 🔹 Dibuja nodo gris
            g.setColor(Color.LIGHT_GRAY);
            g.fillOval(x - radioNodo, y - radioNodo, diametroNodo, diametroNodo);

            g.setColor(Color.BLACK);
            g.drawOval(x - radioNodo, y - radioNodo, diametroNodo, diametroNodo);

            // 🔹 Texto con múltiples líneas
            String[] lineas = elementos[i].split("\n");
            FontMetrics fm = g.getFontMetrics();
            int lineHeight = fm.getHeight();
            int totalHeight = lineHeight * lineas.length;

            int startY = y - totalHeight / 2 + fm.getAscent();
            for (int j = 0; j < lineas.length; j++) {
                int textWidth = fm.stringWidth(lineas[j]);
                g.drawString(lineas[j], x - textWidth / 2, startY + j * lineHeight);
            }
        }

        // 🔹 Rectángulo en 7/8 del ancho
        int rectWidth = 200;
        int rectHeight = 300;
        int rectX = (getWidth() * 7) / 8 - rectWidth / 2; // centro en 7/8
        int rectY = centroY - rectHeight / 2;             // centrado vertical

        g.setColor(new Color(220, 240, 220));
        g.fillRect(rectX, rectY, rectWidth, rectHeight);

        g.setColor(Color.BLACK);
        g.drawRect(rectX, rectY, rectWidth, rectHeight);
    }
}



