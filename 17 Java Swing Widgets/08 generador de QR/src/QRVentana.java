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