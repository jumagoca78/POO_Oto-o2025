# Explicación de LabelTest.java en Java Swing

<img alt="Ejemplo de uso de eqtiquetas" src="https://github.com/jumagoca78/POO/blob/main/20%20Java%20Swing%20Widgets/Todos%20codigos%20de%20los%20Widgets/imagenes/JLabel.jpg">

## Descripción
Este programa demuestra el uso del componente `JLabel` en una interfaz gráfica de usuario en **Java Swing**. Permite la creación de etiquetas con diferentes configuraciones:

1. Una etiqueta con solo texto.
2. Una etiqueta con texto e imagen.
3. Una etiqueta con una imagen y texto alineado debajo.

Cada `JLabel` tiene una descripción emergente (*tooltip*) que se muestra cuando el usuario pasa el mouse sobre ella.

## Funcionamiento
- Se utiliza **FlowLayout** para organizar los elementos en la ventana.
- Se crean tres etiquetas (`JLabel`):
  - La primera etiqueta tiene solo texto.
  - La segunda etiqueta tiene texto e imagen alineada a la izquierda.
  - La tercera etiqueta contiene una imagen con el texto alineado en la parte inferior.
- Se configura el `setToolTipText` para mostrar información adicional al pasar el mouse sobre cada etiqueta.

## Código en Java Swing 
```java
import javax.swing.*;
import java.awt.*;

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
        etiqueta2 = new JLabel("Etiqueta con texto e imagen", icono, SwingConstants.LEFT);
        etiqueta2.setToolTipText("Esta es la etiqueta 2");
        add(etiqueta2);

        // Tercera etiqueta con solo imagen y texto debajo
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
        new PruebaEtiqueta();
    }
}

```

## Ejecución
Para ejecutar este programa, compílalo con `javac PruebaEtiqueta.java` y luego ejecútalo con `java PruebaEtiqueta`. Asegúrate de tener una imagen llamada **JAVA.GIF** en el mismo directorio.

