# 📄 ActualizarRegistro.java

## Descripción
Esta clase permite **actualizar los datos de una persona** en la base de datos SQLite `direcciones.db`. La búsqueda se realiza por nombre y apellido.

## Funcionamiento
- Toma los campos ingresados en el formulario (`JTextField[] campos`).
- Los campos `[0]` y `[1]` corresponden a **nombre** y **apellido**, utilizados como criterios de búsqueda.
- Si existe un registro que coincide con estos datos, se actualizan los campos restantes.
- Usa `PreparedStatement` para garantizar seguridad y evitar errores SQL.

## Requisitos
- El usuario debe completar los campos de nombre y apellido.
- Los demás campos pueden ser actualizados según lo deseado.

## Código Java
```java
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ActualizarRegistro implements ActionListener {
    private JTextField[] campos;

    public ActualizarRegistro(JTextField[] campos) {
        this.campos = campos;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        String nombre = campos[0].getText();
        String apellido = campos[1].getText();

        if (nombre.isEmpty() || apellido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar nombre y apellido para actualizar.");
            return;
        }

        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:direcciones.db")) {
            String sql = "UPDATE addresses SET "
                       + "address = ?, "
                       + "city = ?, "
                       + "stateorprovince = ?, "
                       + "postalcode = ?, "
                       + "country = ?, "
                       + "emailaddress = ?, "
                       + "homephone = ?, "
                       + "faxnumber = ? "
                       + "WHERE firstname = ? AND lastname = ?";

            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                for (int i = 2; i < campos.length; i++) {
                    stmt.setString(i - 1, campos[i].getText());
                }
                stmt.setString(9, nombre);
                stmt.setString(10, apellido);

                int filasActualizadas = stmt.executeUpdate();
                if (filasActualizadas > 0) {
                    JOptionPane.showMessageDialog(null, "✅ Registro actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "⚠️ No se encontró el registro para actualizar.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al actualizar registro: " + e.getMessage());
        }
    }
}
```

## Uso
Conecta esta clase al botón "Actualizar" del formulario. Asegúrate de que el usuario rellene al menos los campos de nombre y apellido para identificar correctamente el registro que se desea modificar.
