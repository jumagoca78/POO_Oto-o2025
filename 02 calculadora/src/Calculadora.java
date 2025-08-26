public class Calculadora {

public     int numero1;
    public int numero2;
    

    //aqui escribimois los construrores, uno sin inicializar nuestras variable y otro que si las inicializa
    
    //Constructor por default
    public Calculadora (){
        numero1=0;
        numero2=0;
    }

    //Constructor inicializando las variables
    public Calculadora (int num1, int num2){
        numero1=num1;
        numero2=num2;
    }

    //setters
    public void setNumero1(int num1) {
        numero1 = num1;
    }

    public void setNumero2(int num2) {
        numero2 = num2;
    }

    

    public int suma (){
        return numero1 + numero2;
    }

    public int resta (){
        return numero1 - numero2;
    }

    public int multiplicar (){
        return numero1 * numero2;
    }

    public int dividir (){
        if (numero2 != 0) {
            return numero1 / numero2;
        } else {
            System.out.println("Error: División por cero no permitida.");
            return 0;
        }
    }

}
