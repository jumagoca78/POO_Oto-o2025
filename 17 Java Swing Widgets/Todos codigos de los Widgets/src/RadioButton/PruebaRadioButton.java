package RadioButton;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PruebaRadioButton extends JFrame {
    private JTextField campoTexto;
    private Font fuenteNormal, fuenteNegrita, fuenteCursiva, fuenteNegritaCursiva;
    private JRadioButton botonNormal, botonNegrita, botonCursiva, botonNegritaCursiva;
    private ButtonGroup grupoBotones;

    public PruebaRadioButton() {
        super("Prueba de JRadioButton");
        setLayout(new FlowLayout());

        // Campo de texto con fuente predeterminada
        campoTexto = new JTextField("Observa cómo cambia el estilo", 25);
        add(campoTexto);

        // Creación de botones de radio
        botonNormal = new JRadioButton("Normal", true);
        add(botonNormal);

        botonNegrita = new JRadioButton("Negrita", false);
        add(botonNegrita);

        botonCursiva = new JRadioButton("Cursiva", false);
        add(botonCursiva);

        botonNegritaCursiva = new JRadioButton("Negrita/Cursiva", false);
        add(botonNegritaCursiva);

        // Agrupar botones de radio para que solo uno pueda ser seleccionado
        grupoBotones = new ButtonGroup();
        grupoBotones.add(botonNormal);
        grupoBotones.add(botonNegrita);
        grupoBotones.add(botonCursiva);
        grupoBotones.add(botonNegritaCursiva);

        // Definir las fuentes
        fuenteNormal = new Font("Serif", Font.PLAIN, 14);
        fuenteNegrita = new Font("Serif", Font.BOLD, 14);
        fuenteCursiva = new Font("Serif", Font.ITALIC, 14);
        fuenteNegritaCursiva = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
        campoTexto.setFont(fuenteNormal);

        // Asignar eventos a los botones de radio
        botonNormal.addItemListener(new ManejadorRadioButton(fuenteNormal));
        botonNegrita.addItemListener(new ManejadorRadioButton(fuenteNegrita));
        botonCursiva.addItemListener(new ManejadorRadioButton(fuenteCursiva));
        botonNegritaCursiva.addItemListener(new ManejadorRadioButton(fuenteNegritaCursiva));

        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ManejadorRadioButton implements ItemListener {
        private Font fuente;

        public ManejadorRadioButton(Font f) {
            fuente = f;
        }

        public void itemStateChanged(ItemEvent evento) {
            campoTexto.setFont(fuente);
        }
    }

    public static void main(String[] args) {
        new PruebaRadioButton();
    }
}
