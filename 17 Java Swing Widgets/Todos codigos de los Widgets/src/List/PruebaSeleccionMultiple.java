package List;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PruebaSeleccionMultiple extends JFrame {
    private JList<String> listaColores, listaCopia;
    private JButton botonCopiar;

    private final String[] nombresColores = {
        "Negro", "Azul", "Cian", "Gris Oscuro", "Gris",
        "Verde", "Gris Claro", "Magenta", "Naranja",
        "Rosa", "Rojo", "Blanco", "Amarillo"
    };

    public PruebaSeleccionMultiple() {
        super("Listas con Selección Múltiple");

        Container contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        listaColores = new JList<>(nombresColores);
        listaColores.setVisibleRowCount(5);
        listaColores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        contenedor.add(new JScrollPane(listaColores));

        botonCopiar = new JButton("Copiar >>>");
        botonCopiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                listaCopia.setListData(listaColores.getSelectedValuesList().toArray(new String[0]));
            }
        });
        contenedor.add(botonCopiar);

        listaCopia = new JList<>();
        listaCopia.setVisibleRowCount(5);
        listaCopia.setFixedCellWidth(100);
        listaCopia.setFixedCellHeight(15);
        listaCopia.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        contenedor.add(new JScrollPane(listaCopia));

        setSize(300, 130);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        PruebaSeleccionMultiple lista = new PruebaSeleccionMultiple();
        
    }
}