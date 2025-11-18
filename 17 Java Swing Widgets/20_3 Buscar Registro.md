# 📄 BuscarRegistro.java

## Descripción
Esta clase permite buscar registros en una base de datos SQLite a partir del **nombre y apellido** proporcionados. Si el registro existe, los campos se llenan automáticamente con la información encontrada.

## Funcionamiento
- El usuario debe llenar los campos de nombre y apellido.
- Se realiza una consulta SQL con `PreparedStatement` para evitar inyecciones.
- Si se encuentra un resultado, se llenan los campos restantes del formulario (`JTextField[]`).
- El índice de las columnas en la base de datos empieza en 1, pero `campos[i]` empieza desde el índice 2 porque nombre y apellido ya están capturados.

## Código Java
```java
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BuscarRegistro implements ActionListener {
    private JTextField[] campos;

    public BuscarRegistro(JTextField[] campos) {
        this.campos = campos;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        String nombre = campos[0].getText();
        String apellido = campos[1].getText();

        if (nombre.isEmpty() || apellido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar nombre y apellido para buscar.");
            return;
        }

        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:direcciones.db")) {
            String sql = "SELECT * FROM addresses WHERE firstname = ? AND lastname = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setString(1, nombre);
                stmt.setString(2, apellido);
                ResultSet resultado = stmt.executeQuery();

                if (resultado.next()) {
                    for (int i = 2; i < campos.length; i++) {
                        campos[i].setText(resultado.getString(i + 1));
                    }
                    JOptionPane.showMessageDialog(null, "✅ Registro encontrado.");
                } else {
                    JOptionPane.showMessageDialog(null, "⚠️ No se encontró ningún registro con ese nombre y apellido.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al buscar registro: " + e.getMessage());
        }
    }
}
```

## Uso
Vincula esta clase al botón "Buscar". Asegúrate de que los campos de nombre y apellido estén presentes al inicio del arreglo de campos `JTextField[]`.

