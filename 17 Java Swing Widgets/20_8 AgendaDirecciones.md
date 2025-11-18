# 📄 AgendaDirecciones.java

## Descripción
Este archivo representa la **clase principal** de la libreta de direcciones. Es la responsable de mostrar la ventana de la aplicación e integrar todos los componentes visuales: campos de entrada (`PanelDesplazable`) y botones de acción (`PanelControl`).

## Funcionamiento
- Se crea una ventana principal con `JFrame` y título.
- Se añade un `PanelDesplazable` dentro de un `JScrollPane` en el centro.
- Se añade un `PanelControl` (botones) en la parte inferior (`South`).
- Se obtiene el arreglo de campos del panel de entrada para pasárselo al panel de botones.

## Código Java
```java
import javax.swing.*;

public class AgendaDirecciones {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("📘 Agenda de Direcciones (SQLite)");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 300);

        // Crear panel desplazable (campos de texto)
        PanelDesplazable panelDatos = new PanelDesplazable();
        JScrollPane scrollPane = new JScrollPane(panelDatos);
        ventana.add(scrollPane, "Center");

        // Crear panel de control (botones)
        PanelControl panelBotones = new PanelControl(panelDatos.obtenerCampos());
        ventana.add(panelBotones, "South");

        ventana.setVisible(true);
    }
}
```

## Uso
Este es el **punto de entrada** de la aplicación. Para ejecutar el sistema de libreta de direcciones, simplemente compila y ejecuta este archivo.

