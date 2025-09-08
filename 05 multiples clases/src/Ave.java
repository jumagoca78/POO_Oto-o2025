public class Ave {
    private String nombre;
    private String genero;
    private short edad; //entero corto
    private float peso; 
    private String color;
    //aquí van más atributos

    //Constructor
    public Ave(String nombre, String genero, short edad, float peso, String color) {
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
    //canta
    private void cantar() {
        System.out.println(nombre + " está cantando.");
    }   

    //vuela n distancia
    private void volar(float distancia) {
        System.out.println(nombre + " está volando " + distancia + " metros.");
    }   
    //duerme n horas
    private void dormir(int horas) {
        System.out.println(nombre + " está durmiendo durante " + horas + " horas.");
    }   
    //ejecutar funciones ave
    public void mostrarAve(String comida, float distancia, int horas){
        respirar();
        comer(comida);
        cantar();
        volar(distancia);
        dormir(horas);
    }           


    //setters tienen como función asignar un valor a un atributos son necesarios cuando los atributos son privados
    //es una buena práctica de programación tener los atributos privados y usar setters y getters para manipularlos
    //setters se escribe set + nombreAtributo con la primera letra en mayúsc
    //además podemos validar el valor que se va a asignar al atributo
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //getters tienen como función obtener el valor de un atributo son necesarios cuando los atributos son privados
    //getters se escribe get + nombreAtributo con la primera letra en mayúsc
    public String getNombre() {
        return nombre;
    }
}
