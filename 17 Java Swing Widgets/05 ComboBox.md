# Explicación de ComboBoxTest.java en Java Swing

## Descripción
Este programa demuestra el uso de `JComboBox` en una interfaz gráfica de usuario en **Java Swing**. Permite seleccionar una imagen de una lista desplegable y cambiar dinámicamente la imagen mostrada en la interfaz.
<img alt="Ejemplo de tipos de campos de texto" src="https://github.com/jumagoca78/POO/blob/main/20%20Java%20Swing%20Widgets/Todos%20codigos%20de%20los%20Widgets/imagenes/ComboBox.jpg">


## Funcionamiento
1. **Configuración de la interfaz gráfica (`JFrame`)**  
   - Se crea una ventana utilizando `JFrame`.
   - Se usa un diseño de `FlowLayout` para organizar los componentes.

2. **Creación del `JComboBox`**  
   - `JComboBox` almacena una lista de nombres de archivos de imágenes.
   - Se permite que el combo box muestre hasta 3 elementos a la vez (`setMaximumRowCount(3)`).

3. **Manejo de eventos (`ItemListener`)**  
   - Se usa un `ItemListener` anónimo para detectar cambios en la selección del `JComboBox`.
   - Cuando el usuario selecciona un elemento, se actualiza la imagen mostrada en el `JLabel`.

4. **Mostrar imágenes en un `JLabel`**  
   - Se inicializa un `JLabel` con una imagen predeterminada.
   - Al seleccionar una nueva imagen en el `JComboBox`, la imagen en el `JLabel` se actualiza.

## Código en Java Swing (original)
```java
// Fig. 13.13: ComboBoxTest.java
// Using a JComboBox to select an image to display.
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
} // end class ComboBoxTest

```

## Ejecución
Para ejecutar este programa, compílalo con `javac ComboBoxTest.java` y luego ejecútalo con `java ComboBoxTest`. **Asegúrate de que las imágenes existan en el mismo directorio del código.**

