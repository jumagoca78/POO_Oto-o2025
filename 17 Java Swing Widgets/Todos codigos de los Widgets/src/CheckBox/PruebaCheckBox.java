package CheckBox;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PruebaCheckBox extends JFrame {
    private JTextField campoTexto;
    private JCheckBox negrita, cursiva;

    public PruebaCheckBox() {
        super("Prueba de JCheckBox");
        setLayout(new FlowLayout());

        // Campo de texto con fuente predeterminada
        campoTexto = new JTextField("Observa cómo cambia el estilo", 20);
        campoTexto.setFont(new Font("Serif", Font.PLAIN, 14));
        add(campoTexto);

        // Casillas de verificación
        negrita = new JCheckBox("Negrita");
        add(negrita);

        cursiva = new JCheckBox("Cursiva");
        add(cursiva);

        // Registrar manejador de eventos
        ManejadorCheckBox manejador = new ManejadorCheckBox();
        negrita.addItemListener(manejador);
        cursiva.addItemListener(manejador);

        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ManejadorCheckBox implements ItemListener {
        private int estiloNegrita = Font.PLAIN;
        private int estiloCursiva = Font.PLAIN;

        public void itemStateChanged(ItemEvent evento) {
            if (evento.getSource() == negrita)
                estiloNegrita = negrita.isSelected() ? Font.BOLD : Font.PLAIN;
            if (evento.getSource() == cursiva)
                estiloCursiva = cursiva.isSelected() ? Font.ITALIC : Font.PLAIN;

            campoTexto.setFont(new Font("Serif", estiloNegrita + estiloCursiva, 14));
        }
    }

    public static void main(String[] args) {
        new PruebaCheckBox();
    }
}