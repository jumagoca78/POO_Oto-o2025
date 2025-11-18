## **2️⃣ JToggleButton - Botón de Alternancia**
Un **JToggleButton** funciona como un interruptor que cambia entre dos estados: activado y desactivado.

### **📌 Código Ejemplo**
```java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToggleButtonEjemplo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JToggleButton");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JToggleButton toggleButton = new JToggleButton("Apagado");
        toggleButton.setBounds(100, 70, 120, 30);

        JLabel etiqueta = new JLabel("Estado: Apagado");
        etiqueta.setBounds(100, 110, 150, 30);

        // Acción al alternar
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toggleButton.isSelected()) {
                    toggleButton.setText("Encendido");
                    etiqueta.setText("Estado: Encendido");
                } else {
                    toggleButton.setText("Apagado");
                    etiqueta.setText("Estado: Apagado");
                }
            }
        });

        frame.add(toggleButton);
        frame.add(etiqueta);
        frame.setVisible(true);
    }
}
```

---