public class Cliente3 implements Observer 
    //Este cliente solo esta interesado en el producto 2
{
    private int cantP2;
    private Tienda tienda;

    public Cliente3(Subject tienda) {
        this.tienda = (Tienda) tienda;
        tienda.registerObserver(this);
    }

    @Override
    public void update(int cantP1, int cantP2, int cantP3) {
        this.cantP2 = cantP2;
        display();
    }

    public void display() {
        System.out.println("Hola Pedro - Inventario actualizado:");
        System.out.println("IPhone XVI: " + cantP2);
        System.out.println();
    }
    
}
