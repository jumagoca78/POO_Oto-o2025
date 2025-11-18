# 📄 PanelControl.java

## Descripción
Este componente contiene los **botones de acción** principales de la aplicación de libreta de direcciones. Cada botón está asociado a una clase específica que realiza una operación sobre la base de datos o el formulario.

## Funcionamiento
- Usa un `GridLayout` de 1 fila por 5 columnas para colocar los botones:
  - `Agregar`
  - `Buscar`
  - `Actualizar`
  - `Limpiar`
  - `Ayuda`
- Cada botón activa un `ActionListener` que ejecuta una clase ya desarrollada:
  - `AgregarRegistro`, `BuscarRegistro`, `ActualizarRegistro`, `LimpiarCampos`, `Ayuda`
- Todos los botones reciben los campos del formulario como argumento (excepto Ayuda).

## Código Java
```java
import javax.swing.*;
import java.awt.*;

public class PanelControl extends JPanel {
    public PanelControl(JTextField[] campos) {
        setLayout(new GridLayout(1, 5, 5, 5));

        JButton botonAgregar = new JButton("Agregar");
        botonAgregar.addActionListener(new AgregarRegistro(campos));
        add(botonAgregar);

        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.addActionListener(new BuscarRegistro(campos));
        add(botonBuscar);

        JButton botonActualizar = new JButton("Actualizar");
        botonActualizar.addActionListener(new ActualizarRegistro(campos));
        add(botonActualizar);

        JButton botonLimpiar = new JButton("Limpiar");
        botonLimpiar.addActionListener(new LimpiarCampos(campos));
        add(botonLimpiar);

        JButton botonAyuda = new JButton("Ayuda");
        botonAyuda.addActionListener(new Ayuda());
        add(botonAyuda);
    }
}
```

## Uso
Este panel debe colocarse en la parte inferior de la ventana principal (`AgendaDirecciones`) para permitir al usuario interactuar con el sistema.

