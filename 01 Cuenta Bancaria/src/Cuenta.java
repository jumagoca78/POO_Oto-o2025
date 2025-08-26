/*Esta clase representa una cuenta de banco
tiene como atributos el numero de cuenta  y el saldo de la cuenta
tiene como metodos depositar, retirar y consultar saldo*/

public class Cuenta {
    private int numeroCuenta; //atributo que representa el numero de cuenta
    private double saldo;     //atributo que representa el saldo de la cuenta
    
    //Constructor de la clase
    public Cuenta(int numeroCuenta, double saldo){
        this.numeroCuenta = numeroCuenta;//inicializa el numero de cuenta
        this.saldo = saldo;//inicializa el saldo
    }
    
    public void depositar(double cantidad){
        saldo += cantidad; //suma la cantidad al saldo
    }
    
    public void retirar(double cantidad){
        //VERIFICAR QUE EL SALDO SEA SUFICIENTE
        if(saldo < cantidad){
            System.out.println("Saldo insuficiente");
            return;
        }
        else {
            saldo -= cantidad;
        }
    }
    
    public double consultarSaldo(){
        return saldo;
    }
}