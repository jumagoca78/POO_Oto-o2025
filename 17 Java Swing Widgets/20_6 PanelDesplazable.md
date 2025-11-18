# 📄 PanelDesplazable.java

## Descripción
Este componente define un **panel con campos de texto** para ingresar o mostrar los datos de la libreta de direcciones. Está diseñado para integrarse en una interfaz principal con posibilidad de desplazamiento.

## Funcionamiento
- Utiliza un `GridLayout` para organizar las etiquetas y los campos en una cuadrícula de dos columnas.
- Cada etiqueta es un `JLabel`, y cada campo asociado es un `JTextField`.
- Contiene 10 campos correspondientes a la estructura de la tabla `addresses` en SQLite.

## Código Java
```java
import javax.swing.*;
import java.awt.*;

public class PanelDesplazable extends JPanel {
    private final JTextField[] campos;
    private final String[] etiquetas = {
        "Nombre:", "Apellido:", "Dirección:", "Ciudad:", "Estado/Provincia:",
        "Código Postal:", "País:", "Correo Electrónico:", "Teléfono de Casa:", "Fax:"
    };

    public PanelDesplazable() {
        setLayout(new GridLayout(etiquetas.length, 2, 5, 5));
        campos = new JTextField[etiquetas.length];

        for (int i = 0; i < etiquetas.length; i++) {
            add(new JLabel(etiquetas[i]));
            campos[i] = new JTextField(25);
            add(campos[i]);
        }
    }

    public JTextField[] obtenerCampos() {
        return campos;
    }
}
```

## Uso
Este panel puede ser insertado dentro de un `JScrollPane` para hacerlo desplazable. El método `obtenerCampos()` permite acceder a todos los campos del formulario desde otras clases como `AgregarRegistro`, `BuscarRegistro`, etc.
