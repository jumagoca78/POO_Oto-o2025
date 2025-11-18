package ComboBox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PruebaComboBox extends JFrame {
    @SuppressWarnings("FieldMayBeFinal")
    private JComboBox<String> comboImagenes;
    @SuppressWarnings("FieldMayBeFinal")
    private JLabel etiquetaImagen;

     private final String nombresImagenes[] = { "java", "java1","java2","java3"};
    private final Icon iconos[] = { new ImageIcon(getClass().getResource("/ComboBox/java.gif")),
                              new ImageIcon(getClass().getResource("/ComboBox/java1.gif")),
                              new ImageIcon(getClass().getResource("/ComboBox/java2.gif")),
                              new ImageIcon(getClass().getResource("/ComboBox/java3.gif")) };

    public PruebaComboBox() {
        super("Prueba de JComboBox");
        setLayout(new FlowLayout());

        // Configurar JComboBox y registrar su manejador de eventos
        comboImagenes = new JComboBox<>(nombresImagenes);
        comboImagenes.setMaximumRowCount(3);
        comboImagenes.addItemListener(new ManejadorComboBox());

        add(comboImagenes);

        // Configurar JLabel para mostrar imágenes
        etiquetaImagen = new JLabel(iconos[3]);
        add(etiquetaImagen);

        setSize(350, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ManejadorComboBox implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent evento) {
            if (evento.getStateChange() == ItemEvent.SELECTED) {
                etiquetaImagen.setIcon(iconos[comboImagenes.getSelectedIndex()]);
            }
        }
    }

    public static void main(String[] args) {
        new PruebaComboBox();
    }
}