# 📄 AgregarRegistro.java

## Descripción
Esta clase implementa la funcionalidad para **agregar un nuevo registro** en la base de datos `direcciones.db` usando **SQLite** y Java Swing.

## Funcionamiento
- Recibe un arreglo de `JTextField`, uno por cada campo del formulario de dirección.
- Cuando el usuario hace clic en el botón de agregar, se ejecuta una consulta `INSERT INTO` usando `PreparedStatement`.
- La conexión a la base de datos se realiza usando `jdbc:sqlite:direcciones.db`.
- Se utiliza un bloque `try-with-resources` para asegurar que la conexión y el `PreparedStatement` se cierren automáticamente.

## Beneficios
- Seguridad frente a inyecciones SQL gracias al uso de `PreparedStatement`.
- Código limpio, moderno y fácil de mantener.

## Código Java
```java
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AgregarRegistro implements ActionListener {
    private JTextField[] campos;

    public AgregarRegistro(JTextField[] campos) {
        this.campos = campos;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:direcciones.db")) {
            String sql = "INSERT INTO addresses (firstname, lastname, address, city, stateorprovince, postalcode, country, emailaddress, homephone, faxnumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                for (int i = 0; i < campos.length; i++) {
                    stmt.setString(i + 1, campos[i].getText());
                }

                int filasInsertadas = stmt.executeUpdate();
                if (filasInsertadas > 0) {
                    JOptionPane.showMessageDialog(null, "✅ Registro agregado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "⚠️ No se pudo agregar el registro");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al agregar registro: " + e.getMessage());
        }
    }
}
```

## Uso
Este archivo debe conectarse al botón "Agregar" del panel principal. Cuando el usuario llena el formulario y hace clic en el botón, se agrega la nueva dirección a la base de datos.
