# Explicación de ListTest.java en Java Swing

## Descripción
Este programa demuestra cómo utilizar un componente `JList` en una interfaz gráfica de Java Swing para seleccionar colores.

<img alt="Ejemplo de tipos de campos de texto" src="https://github.com/jumagoca78/POO/blob/main/20%20Java%20Swing%20Widgets/Todos%20codigos%20de%20los%20Widgets/imagenes/Lista.jpg">    

## Funcionamiento
- Se define un arreglo de nombres de colores (`String[]`) y un arreglo de colores reales (`Color[]`).
- Se crea un `JList` que contiene los nombres de los colores.
- La lista solo permite seleccionar un color a la vez (`SINGLE_SELECTION`).
- Cuando el usuario selecciona un color de la lista, se detecta el evento con un `ListSelectionListener`, y se actualiza el color de fondo del panel principal (`Container`) al color seleccionado.

## Código en Java Swing (actualizado en español)
```java
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class PruebaLista extends JFrame {
    private JList<String> listaColores;
    private Container contenedor;

    private final String[] nombresColores = { "Negro", "Azul", "Cian",
        "Gris Oscuro", "Gris", "Verde", "Gris Claro", "Magenta",
        "Naranja", "Rosa", "Rojo", "Blanco", "Amarillo" };

    private final Color[] colores = { Color.BLACK, Color.BLUE, Color.CYAN,
        Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
        Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE,
        Color.YELLOW };

    public PruebaLista() {
        super("Prueba de JList");

        contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        listaColores = new JList<>(nombresColores);
        listaColores.setVisibleRowCount(5);
        listaColores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        contenedor.add(new JScrollPane(listaColores));

        listaColores.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evento) {
                contenedor.setBackground(colores[listaColores.getSelectedIndex()]);
            }
        });

        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PruebaLista();
    }
}

```

## Ejecución
Para ejecutar este programa, compílalo con `javac PruebaLista.java` y luego ejecútalo con `java PruebaLista`. Al seleccionar un color en la lista, verás cómo cambia el fondo de la ventana.
