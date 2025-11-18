package CampoDeTexto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PruebaCampoTexto extends JFrame {
    private JTextField campoTexto1, campoTexto2, campoTexto3;
    private JPasswordField campoContrasena;

    public PruebaCampoTexto() {
        super("Prueba de JTextField y JPasswordField");
        setLayout(new FlowLayout());

        // Campo de texto simple
        campoTexto1 = new JTextField(10);
        add(campoTexto1);

        // Campo de texto con mensaje predeterminado
        campoTexto2 = new JTextField("Escriba aquí");
        add(campoTexto2);

        // Campo de texto no editable con mensaje predeterminado
        campoTexto3 = new JTextField("Campo de solo lectura", 20);
        campoTexto3.setEditable(false);
        add(campoTexto3);

        // Campo de contraseña con texto oculto
        campoContrasena = new JPasswordField("Texto oculto");
        add(campoContrasena);

        // Registrar el manejador de eventos
        ManejadorCampoTexto manejador = new ManejadorCampoTexto();
        campoTexto1.addActionListener(manejador);
        campoTexto2.addActionListener(manejador);
        campoTexto3.addActionListener(manejador);
        campoContrasena.addActionListener(manejador);

        setSize(325, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ManejadorCampoTexto implements ActionListener {
        public void actionPerformed(ActionEvent evento) {
            String mensaje = "";

            if (evento.getSource() == campoTexto1)
                mensaje = "Campo 1: " + evento.getActionCommand();
            else if (evento.getSource() == campoTexto2)
                mensaje = "Campo 2: " + evento.getActionCommand();
            else if (evento.getSource() == campoTexto3)
                mensaje = "Campo 3: " + evento.getActionCommand();
            else if (evento.getSource() == campoContrasena)
                mensaje = "Contraseña: " + new String(campoContrasena.getPassword());

            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    public static void main(String[] args) {
        new PruebaCampoTexto();
    }
}