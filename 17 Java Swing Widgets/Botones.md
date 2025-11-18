## **1️⃣ JButton - Botón de Acción**
Un **JButton** permite que los usuarios realicen una acción al hacer clic en él.

### **📌 Código Ejemplo**
```java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonEjemplo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JButton");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton boton = new JButton("¡Haz clic!");
        boton.setBounds(100, 70, 120, 30);

        JLabel etiqueta = new JLabel("Esperando...");
        etiqueta.setBounds(110, 110, 150, 30);

        // Acción al hacer clic
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText("¡Botón presionado!");
            }
        });

        frame.add(boton);
        frame.add(etiqueta);
        frame.setVisible(true);
    }
}
```

---
