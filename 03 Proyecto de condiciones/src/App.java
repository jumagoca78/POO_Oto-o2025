import javax.swing.JOptionPane; //JOptionpane
/* 
1 Solicitra al usuario su calificación
2 Asignar la calificacion ingresada por el usuario a un String
3 Convertir la String a número y asignarlo a una variable int
4 Comprobar si en numero es mayor a 60 
    4.1 Imprimir aprobado
    sino
    4.2 Imprimir reprobado
5 Cerrar el modo gráfico System.exit(0);
*/
public class App {
    public static void main(String[] args) throws Exception {
        do{
            String input = JOptionPane.showInputDialog("Ingrese su calificación:");
            int calificacion = Integer.parseInt(input);
            if (calificacion > 60) {
                JOptionPane.showConfirmDialog(null, "Buen alumno\n ¿Quieres continuar?",
                                                "Aprobado",
                                                JOptionPane.YES_NO_OPTION);
            } else if (calificacion == 59){
                JOptionPane.showMessageDialog(null, "Casi","Suerte para la otra",
                                                JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Mal alumno","Reprobado",
                                                JOptionPane.ERROR_MESSAGE);
        }
        String opcion = JOptionPane.showInputDialog("¿Desea continuar? (s/n)");
        if (opcion == null || opcion.equalsIgnoreCase("n")) {
            break;
        }
    } while (true);
    JOptionPane.showMessageDialog(null, "Gracias por usar el programa", "Salir",
                                    JOptionPane.QUESTION_MESSAGE);
    System.exit(0);
    }
}
