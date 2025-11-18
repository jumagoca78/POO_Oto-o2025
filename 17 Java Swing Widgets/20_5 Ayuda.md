# 📄 Ayuda.java

## Descripción
Este archivo contiene una clase que muestra un cuadro de diálogo con **instrucciones de uso** de la libreta de direcciones cuando el usuario hace clic en el botón "Ayuda".

## Funcionamiento
- Implementa `ActionListener`.
- Al hacer clic en el botón de ayuda, se despliega una ventana con información básica sobre cómo agregar, buscar, actualizar y limpiar registros.
- Se utiliza `JOptionPane.showMessageDialog` para mostrar un cuadro de mensaje informativo.

## Código Java
```java
import java.awt.event.*;
import javax.swing.*;

public class Ayuda implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent evento) {
        String mensaje = "Instrucciones de Uso:\n\n" +
                         "1. Para AGREGAR un registro:\n" +
                         "   - Llene todos los campos del formulario.\n" +
                         "   - Haga clic en el botón 'Agregar'.\n\n" +
                         "2. Para BUSCAR un registro:\n" +
                         "   - Ingrese el nombre y apellido.\n" +
                         "   - Presione 'Buscar'.\n\n" +
                         "3. Para ACTUALIZAR un registro:\n" +
                         "   - Ingrese nombre y apellido para localizar al contacto.\n" +
                         "   - Actualice los demás campos y presione 'Actualizar'.\n\n" +
                         "4. Para LIMPIAR el formulario:\n" +
                         "   - Presione el botón 'Limpiar'.\n\n" +
                         "Todos los datos se almacenan en una base de datos SQLite llamada 'direcciones.db'.";
        JOptionPane.showMessageDialog(null, mensaje, "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }
}
```

## Uso
Este archivo debe conectarse al botón "Ayuda" del panel principal para ofrecer asistencia básica al usuario sobre cómo utilizar la aplicación.
