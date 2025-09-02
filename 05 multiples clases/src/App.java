public class App {
    public static void main(String[] args) throws Exception {

        Gato misifu = new Gato("Misifu", "Macho", (short) 5, 4.5f, "Gris");
        misifu.mostrarGato("pescado", 100, 8);

        Gato otroGato = new Gato("Don Gato", "Ladrón", (short) 56, 6.8f, "amarillo");
        otroGato.mostrarGato("atún", 150, 10);

    }
}
