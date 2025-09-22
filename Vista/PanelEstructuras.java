package Vista;

import javax.swing.*;
import java.awt.*;

/**
 * PanelEstructuras es un panel personalizado que representa gráficamente una estructura circular
 * con nodos alrededor de un círculo central y un rectángulo lateral. 
 * Cada nodo muestra información textual proporcionada en el arreglo de elementos.
 */
public class PanelEstructuras extends JPanel {
    private String[] elementos;

    /**
     * Establece los elementos que serán representados como nodos en el panel.
     * @param datos Arreglo de cadenas con la información de cada nodo.
     */
    public void setElementos(String[] datos) {
        this.elementos = datos;
        repaint();
    }

    /**
     * Dibuja la estructura circular con los nodos y el rectángulo lateral.
     * Cada nodo se posiciona equidistantemente alrededor de un círculo central y muestra su información.
     * @param g El contexto gráfico utilizado para dibujar.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (elementos == null || elementos.length == 0) return;

        int n = elementos.length;

        // Calcula el centro del círculo principal
        int centroX = getWidth() / 3;
        int centroY = getHeight() / 2;

        // Dibuja el círculo central
        int diametroCentro = 200;
        int radioCentro = diametroCentro / 2;

        g.setColor(new Color(200, 220, 255));
        g.fillOval(centroX - radioCentro, centroY - radioCentro, diametroCentro, diametroCentro);

        g.setColor(Color.BLACK);
        g.drawOval(centroX - radioCentro, centroY - radioCentro, diametroCentro, diametroCentro);

        // Dibuja los nodos alrededor del círculo central
        int radio = Math.min(getWidth(), getHeight()) / 3;
        int diametroNodo = 120; 
        int radioNodo = diametroNodo / 2;

        for (int i = 0; i < n; i++) {
            double angulo = 2 * Math.PI * i / n;
            int x = (int) (centroX + radio * Math.cos(angulo));
            int y = (int) (centroY + radio * Math.sin(angulo));

            g.setColor(Color.LIGHT_GRAY);
            g.fillOval(x - radioNodo, y - radioNodo, diametroNodo, diametroNodo);

            g.setColor(Color.BLACK);
            g.drawOval(x - radioNodo, y - radioNodo, diametroNodo, diametroNodo);

            // Dibuja el texto de cada nodo, permitiendo múltiples líneas
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

        // Dibuja el rectángulo lateral derecho
        int rectWidth = 200;
        int rectHeight = 300;
        int rectX = (getWidth() * 7) / 8 - rectWidth / 2;
        int rectY = centroY - rectHeight / 2;

        g.setColor(new Color(220, 240, 220));
        g.fillRect(rectX, rectY, rectWidth, rectHeight);

        g.setColor(Color.BLACK);
        g.drawRect(rectX, rectY, rectWidth, rectHeight);
    }
}