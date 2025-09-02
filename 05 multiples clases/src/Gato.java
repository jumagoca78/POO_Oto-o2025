public class Gato {

    private String nombre;
    private String genero;
    private short edad; //entero corto
    private float peso; 
    private String color;
    //aquí van más atributos

    //Constructor
    public Gato(String nombre, String genero, short edad, float peso, String color) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.peso = peso;
        this.color = color;
    }


    //respira
    private void respirar() {
        System.out.println(nombre + " está respirando.");
    }

    //come con nombre de comida
    private void comer(String comida) {
        System.out.println(nombre + " está comiendo " + comida + ".");
    }

    //maulla
    private void maullar() {
        System.out.println(nombre + " está maullando.");
    }

    //corre n distancia
    private void correr(float distancia) {
        System.out.println(nombre + " está corriendo " + distancia + " metros.");
    }

    //duerme n horas
    private void dormir(int horas) {
        System.out.println(nombre + " está durmiendo durante " + horas + " horas.");
    }

    //ejecutar funciones gato
    public void mostrarGato(String comida, float distancia, int horas){
        respirar();
        comer("comida");
        maullar();
        correr(100);
        dormir(8);
    }

}
