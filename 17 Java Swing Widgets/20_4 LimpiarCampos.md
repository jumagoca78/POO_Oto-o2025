# 📄 LimpiarCampos.java

## Descripción
Esta clase implementa la funcionalidad para **limpiar todos los campos del formulario** de la libreta de direcciones.

## Funcionamiento
- Recibe un arreglo de objetos `JTextField[]`.
- Cuando el usuario hace clic en el botón "Limpiar", se borra el contenido de todos los campos de texto.
- Se muestra un mensaje de confirmación indicando que los campos han sido limpiados.

## Código Java
```java
import java.awt.event.*;
import javax.swing.*;

public class LimpiarCampos implements ActionListener {
    private JTextField[] campos;

    public LimpiarCampos(JTextField[] campos) {
        this.campos = campos;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
        JOptionPane.showMessageDialog(null, "🧹 Todos los campos han sido limpiados.");
    }
}
```

## Uso
Conecta esta clase al botón "Limpiar" del formulario para permitir que el usuario borre fácilmente todo el contenido ingresado antes de realizar otra acción como buscar, agregar o actualizar un registro.

