# Explicación de CheckBoxTest.java en Java Swing

## Descripción
Este programa demuestra el uso de `JCheckBox` en una interfaz gráfica de usuario en **Java Swing**. Permite cambiar el estilo de fuente de un campo de texto seleccionando opciones de **negrita** o **cursiva**.

## Funcionamiento
- Se utiliza un campo de texto `JTextField` para mostrar el mensaje.
- Se crean dos casillas de verificación (`JCheckBox`):
  - **Negrita**: Cambia la fuente a negrita.
  - **Cursiva**: Cambia la fuente a cursiva.
- Se utiliza un **manejador de eventos** (`ItemListener`) para modificar dinámicamente el estilo de la fuente en función de la selección del usuario.

<img alt="Ejemplo de tipos de campos de texto" src="https://github.com/jumagoca78/POO/blob/main/20%20Java%20Swing%20Widgets/Todos%20codigos%20de%20los%20Widgets/imagenes/CheckBox.jpg">

## Código en Java Swing (actualizado en español)
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

```

## Ejecución
Para ejecutar este programa, compílalo con `javac PruebaCheckBox.java` y luego ejecútalo con `java PruebaCheckBox`. 

