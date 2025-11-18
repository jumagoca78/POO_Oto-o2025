# Explicación de TextFieldTest.java en Java Swing

<img alt="Ejemplo de tipos de campos de texto" src="https://github.com/jumagoca78/POO/blob/main/20%20Java%20Swing%20Widgets/Todos%20codigos%20de%20los%20Widgets/imagenes/JTextField.jpg">


## Descripción
Este programa demuestra el uso de `JTextField` y `JPasswordField` en una interfaz gráfica de usuario en **Java Swing**. Se pueden introducir textos en los campos y capturar el evento cuando el usuario presiona *Enter*.

## Funcionamiento
- Se utilizan cuatro campos de entrada:
  1. Un campo de texto vacío con un ancho de 10 caracteres.
  2. Un campo de texto con un mensaje predeterminado.
  3. Un campo de texto de solo lectura (no editable).
  4. Un campo de contraseña (`JPasswordField`) que oculta la entrada.
- Cuando el usuario presiona *Enter*, se captura el texto ingresado y se muestra en un cuadro de diálogo (`JOptionPane`).
- Se utiliza un **manejador de eventos** (`ActionListener`) para procesar la entrada del usuario.

## Código en Java Swing (actualizado en español)
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

```

## Ejecución
Para ejecutar este programa, compílalo con `javac PruebaCampoTexto.java` y luego ejecútalo con `java PruebaCampoTexto`. 

