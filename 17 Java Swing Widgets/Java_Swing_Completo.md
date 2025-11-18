# Explicación Detallada de los Archivos Java Swing

## 1. LabelTest.java - Demostración de JLabel

### Descripción
Este programa muestra el uso de etiquetas (`JLabel`) en una interfaz gráfica. Permite agregar etiquetas con o sin íconos y establecer su posición relativa.

### Código
```java
import javax.swing.*;
import java.awt.*;

public class LabelTest extends JFrame {
    private JLabel etiqueta1, etiqueta2, etiqueta3;

    public LabelTest() {
        super("Prueba de JLabel");
        setLayout(new FlowLayout());

        etiqueta1 = new JLabel("Etiqueta con texto");
        etiqueta1.setToolTipText("Esta es la etiqueta 1");
        add(etiqueta1);

        Icon icono = new ImageIcon("imagen.png");
        etiqueta2 = new JLabel("Etiqueta con texto e imagen", icono, SwingConstants.LEFT);
        etiqueta2.setToolTipText("Esta es la etiqueta 2");
        add(etiqueta2);

        etiqueta3 = new JLabel();
        etiqueta3.setText("Etiqueta con imagen y texto debajo");
        etiqueta3.setIcon(icono);
        etiqueta3.setHorizontalTextPosition(SwingConstants.CENTER);
        etiqueta3.setVerticalTextPosition(SwingConstants.BOTTOM);
        etiqueta3.setToolTipText("Esta es la etiqueta 3");
        add(etiqueta3);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LabelTest();
    }
}
```

---

## 2. TextFieldTest.java - Uso de JTextField y JPasswordField

### Descripción
Este programa muestra cómo utilizar `JTextField` para ingresar texto y `JPasswordField` para ingresar contraseñas ocultas.

### Código
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFieldTest extends JFrame {
    private JTextField campoTexto1, campoTexto2, campoTexto3;
    private JPasswordField campoContrasena;

    public TextFieldTest() {
        super("Prueba de JTextField y JPasswordField");
        setLayout(new FlowLayout());

        campoTexto1 = new JTextField(10);
        add(campoTexto1);

        campoTexto2 = new JTextField("Ingrese texto aquí");
        add(campoTexto2);

        campoTexto3 = new JTextField("Campo de solo lectura", 20);
        campoTexto3.setEditable(false);
        add(campoTexto3);

        campoContrasena = new JPasswordField("Texto oculto");
        add(campoContrasena);

        ManejadorTexto manejador = new ManejadorTexto();
        campoTexto1.addActionListener(manejador);
        campoTexto2.addActionListener(manejador);
        campoTexto3.addActionListener(manejador);
        campoContrasena.addActionListener(manejador);

        setSize(325, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ManejadorTexto implements ActionListener {
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
        new TextFieldTest();
    }
}
```

---

## 3. ButtonTest.java - Creación de JButton

### Descripción
Este programa crea botones (`JButton`) con texto e imágenes, además de manejar eventos de clic.

### Código
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonTest extends JFrame {
    private JButton botonSimple, botonConImagen;

    public ButtonTest() {
        super("Prueba de Botones");
        setLayout(new FlowLayout());

        botonSimple = new JButton("Botón Simple");
        add(botonSimple);

        Icon icono1 = new ImageIcon("icono1.png");
        Icon icono2 = new ImageIcon("icono2.png");
        botonConImagen = new JButton("Botón con Imagen", icono1);
        botonConImagen.setRolloverIcon(icono2);
        add(botonConImagen);

        ManejadorBoton manejador = new ManejadorBoton();
        botonSimple.addActionListener(manejador);
        botonConImagen.addActionListener(manejador);

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ManejadorBoton implements ActionListener {
        public void actionPerformed(ActionEvent evento) {
            JOptionPane.showMessageDialog(ButtonTest.this, "Presionaste: " + evento.getActionCommand());
        }
    }

    public static void main(String[] args) {
        new ButtonTest();
    }
}
```

---

Este archivo incluye explicaciones y código en español para **LabelTest.java, TextFieldTest.java y ButtonTest.java**. 

Ahora lo guardaré como un archivo Markdown. 🚀
