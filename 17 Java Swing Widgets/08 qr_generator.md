
# Generación y Visualización de Códigos QR en Java Swing (Sin Maven)

Este documento explica el proceso para generar un código QR usando la biblioteca ZXing, mostrarlo dentro de una ventana Swing y proporcionar la opción de guardarlo como archivo de imagen. No se utiliza Maven, únicamente archivos JAR agregados manualmente al proyecto.

---

## 1. Descargar las bibliotecas necesarias

Es necesario descargar dos archivos JAR de la biblioteca ZXing:

- core-3.5.3.jar  
  https://repo1.maven.org/maven2/com/google/zxing/core/3.5.3/core-3.5.3.jar

- javase-3.5.3.jar  
  https://repo1.maven.org/maven2/com/google/zxing/javase/3.5.3/javase-3.5.3.jar

Los archivos deben colocarse en una carpeta dentro del proyecto, por ejemplo:

```
/libs/zxing/
```

---

## 2. Agregar los archivos JAR al proyecto en Visual Studio Code

1. Crear la carpeta llamada `libs` dentro del proyecto.
2. Colocar los JAR descargados en esa carpeta.
3. En Visual Studio Code, hacer clic derecho sobre cada archivo JAR.
4. Seleccionar la opción **Add to Java Build Path**.

Con esto, las clases de ZXing estarán disponibles para ser importadas.

---

## 3. Código de ejemplo para generar, mostrar y guardar un código QR

El siguiente código crea una ventana Swing donde se muestra un código QR y se permite guardarlo como imagen PNG.

```java
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

public class QRVentana extends JFrame {

    private BufferedImage qrImage;

    public QRVentana() {
        super("QR Code Swing");
        setSize(350, 420);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String texto = "https://www.google.com";

        qrImage = generarQR(texto, 250, 250);

        JLabel lblQR = new JLabel(new ImageIcon(qrImage));
        lblQR.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblQR, BorderLayout.CENTER);

        JButton btnGuardar = new JButton("Guardar QR");
        btnGuardar.addActionListener(e -> guardarQR());
        add(btnGuardar, BorderLayout.SOUTH);

        setVisible(true);
    }

    private BufferedImage generarQR(String texto, int ancho, int alto) {
        try {
            BitMatrix matrix = new MultiFormatWriter().encode(
                    texto,
                    BarcodeFormat.QR_CODE,
                    ancho,
                    alto
            );
            return MatrixToImageWriter.toBufferedImage(matrix);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error generando QR\n" + e.getMessage());
            return null;
        }
    }

    private void guardarQR() {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(new File("qr.png"));
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                ImageIO.write(qrImage, "png", chooser.getSelectedFile());
                JOptionPane.showMessageDialog(this, "QR guardado correctamente.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar\n" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new QRVentana();
    }
}
```

---

## 4. Explicación del proceso

1. Se genera una imagen QR usando la clase `MultiFormatWriter`.
2. La matriz resultante se convierte en imagen mediante `MatrixToImageWriter`.
3. Se muestra la imagen dentro de un `JLabel` colocado en un `JFrame`.
4. Para guardar la imagen, se utiliza `JFileChooser` y `ImageIO.write`.

---

## 5. Verificación del funcionamiento

1. Ejecutar la clase `QRVentana`.
2. Verificar que aparece la ventana con el código QR generado.
3. Presionar el botón de guardado y elegir una ubicación.
4. Confirmar que el archivo PNG se haya generado correctamente.

---

## 6. Posibles extensiones

- Permitir al usuario ingresar el texto a codificar.
- Ajustar el tamaño del QR según la entrada.
- Guardar automáticamente con fecha y hora.
- Integrar el módulo en una interfaz más grande del proyecto.

---

Fin del documento.
