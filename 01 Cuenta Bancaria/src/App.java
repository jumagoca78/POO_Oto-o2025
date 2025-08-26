public class App {
    public static void main(String[] args) throws Exception {
        // Aquí podrías crear instancias de Cuenta y probar sus métodos
        Cuenta fred, sam, eva, profesor;

        fred = new Cuenta (100, 2000);
        sam = new Cuenta (101, 3000);
        eva = new Cuenta (102, 4000);
        profesor = new Cuenta (103, 50000);

        System.out.println("El saldo de fred es: " + fred.consultarSaldo());
    

        
    }
}
