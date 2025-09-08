public class Perro {
    private String nombre;
    private String genero;
    private short edad; //entero corto
    private float peso; 
    private String color;
    //aquí van más atributos

    //Constructor
    public Perro(String nombre, String genero, short edad, float peso, String color) {
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

    //ladra
    private void ladrar() {
        System.out.println(nombre + " está ladrando.");
    }   

    //corre n distancia
    private void correr(float distancia) {  
        System.out.println(nombre + " está corriendo " + distancia + " metros.");
    }   
    //duerme n horas
    private void dormir(int horas) {   
        System.out.println(nombre + " está durmiendo durante " + horas + " horas.");
    }   
    //ejecutar funciones perro
    public void mostrarPerro(String comida, float distancia, int horas){    
        respirar();
        comer(comida);
        ladrar();
        correr(distancia);
        dormir(horas);
    }   


    //setters tienen como función asignar un valor a un atributos son necesarios cuando los atributos son privados
    //es una buena práctica de programación tener los atributos privados y usar setters y getters para manip
    //setters se escribe set + nombreAtributo con la primera letra en mayúscula
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
