# 🗃️ Modernización de la Libreta de Direcciones Java usando SQLite

## Paso 1: Agregar el Driver JDBC para SQLite

Utiliza el siguiente archivo `.jar`:  
👉 [https://github.com/xerial/sqlite-jdbc/releases](https://github.com/xerial/sqlite-jdbc/releases)

### Ejemplo de compilación:
```bash
javac -cp ".:sqlite-jdbc-3.36.0.3.jar" AddressBookSQLite.java
java -cp ".:sqlite-jdbc-3.36.0.3.jar" AddressBookSQLite
```

---

##  Paso 2: Crear la base de datos en SQLLite `direcciones.db`

```sql
CREATE TABLE addresses (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  firstname TEXT NOT NULL,
  lastname TEXT NOT NULL,
  address TEXT,
  city TEXT,
  stateorprovince TEXT,
  postalcode TEXT,
  country TEXT,
  emailaddress TEXT,
  homephone TEXT,
  faxnumber TEXT
);
```

---

##  Paso 3: Código Java de conexión usando SQLite

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLite {
    public static Connection conectar() {
        Connection conexion = null;
        try {
            // Cargar el driver JDBC para SQLite
            Class.forName("org.sqlite.JDBC");
            // Ruta a la base de datos SQLite
            String url = "jdbc:sqlite:direcciones.db";
            conexion = DriverManager.getConnection(url);
            System.out.println("✅ Conexión exitosa a SQLite");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Error: No se encontró el driver SQLite");
        } catch (SQLException e) {
            System.err.println("❌ Error de conexión a la base de datos");
            e.printStackTrace();
        }
        return conexion;
    }

    public static void main(String[] args) {
        conectar();
    }
}
```


