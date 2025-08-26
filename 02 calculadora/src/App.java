  /*
     * Una calculadora simple con suma, resta multiplicacion y division
     * vamos a solicitar al usuario que ingrese los valores usando la terminal, y el método Scanner
     * 1- Solicitar al usuario los dos numeros y asignarlos a dos variables
     * 2- Solicitar al usuario la operacion a realizar (suma, resta, multiplicacion, division)
     * 3. Guardar en una variable opcion la opcion deseada
     */
import java.util.Scanner;

public class App {

     static Calculadora miCalculadora = new Calculadora(1,2);
     static Calculadora calculadoraPOO = new Calculadora();

     public static void main(String[] args) throws Exception {

       int numero1, numero2, opcion, resultado;
       
        
       Scanner entrada = new Scanner (System.in);

       do{
       System.out.println("Ingrese el primer número:");
       numero1 = entrada.nextInt();
       miCalculadora.setNumero1(numero1);

       System.out.println("Ingrese el segundo número:");
       numero2 = entrada.nextInt();
       miCalculadora.setNumero2(numero2);


       System.out.println(menu());
       opcion = entrada.nextInt();

       

       if (opcion != 5) {

            if (opcion==1||opcion==2||opcion==3||opcion==4){
                resultado = switchCalculadora(opcion);
                System.out.println("El resultado es: " + resultado);
            }

       }

       }while (opcion != 5);

       entrada.close();
    }

    public static int switchCalculadora (int opc){
        switch (opc) {
            case 1:
                return miCalculadora.suma();
            case 2:
            return miCalculadora.resta();
            case 3:
                return miCalculadora.multiplicar();
            case 4:
                return miCalculadora.dividir();
            default:
                System.out.println("Opción no válida");
                return 0;
        }
    }


    public static String menu(){
        String menu = "Seleccione la operación a realizar:\n";
        menu += "1. Sumar\n";
        menu += "2. Restar\n";
        menu += "3. Multiplicar\n";
        menu += "4. Raiz\n";
        menu += "5. Salir\n";
        return menu;
    }




}

