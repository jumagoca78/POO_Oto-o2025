package Etiquetas;

import java.awt.*;
import javax.swing.*;

public class PruebaEtiqueta extends JFrame {
    private JLabel etiqueta1, etiqueta2, etiqueta3;

    public PruebaEtiqueta() {
        super("Prueba de JLabel");
        setLayout(new FlowLayout());

        // Primera etiqueta con solo texto
        etiqueta1 = new JLabel("Etiqueta con texto");
        etiqueta1.setToolTipText("Esta es la etiqueta 1");
        add(etiqueta1);

        // Segunda etiqueta con texto e ícono
        //getResource() busca el archivo dentro del classpath y devuelve una URL si lo encuentra. Si el recurso no existe, devuelve null
        Icon icono = new ImageIcon(getClass().getResource("/Etiquetas/java.GIF")); 
        etiqueta2 = new JLabel("Etiqueta con texto e imagen a la izquierda", icono, SwingConstants.LEFT);// Posición de la imagen con respecto al texto
        etiqueta2.setToolTipText("Esta es la etiqueta 2");
        add(etiqueta2);

        // Tercera etiqueta con solo imagen y texto debajo
        etiqueta3 = new JLabel();
        etiqueta3.setText("Etiqueta con imagen y texto debajo");
        etiqueta3.setIcon(icono);
        etiqueta3.setHorizontalTextPosition(SwingConstants.CENTER);// Posición horizontal del texto con respecto a la imagen
        etiqueta3.setVerticalTextPosition(SwingConstants.BOTTOM);// Posición vertical del texto con respecto a la imagen
        etiqueta3.setToolTipText("Esta es la etiqueta 3");// Mensaje que aparece al pasar el mouse sobre la etiqueta
        add(etiqueta3);

        setSize(320, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PruebaEtiqueta();
    }
}