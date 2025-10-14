public class Cliente1 implements Observer {

    /*Este cliente esta interesado en los tres productos */
    private int cantP1;
    private int cantP2;
    private int cantP3;
    private Tienda tienda;

    public Cliente1(Subject tienda) {
        this.tienda = (Tienda) tienda;
        tienda.registerObserver(this);
    }

    @Override
    public void update(int cantP1, int cantP2, int cantP3) {
        this.cantP1 = cantP1;
        this.cantP2 = cantP2;
        this.cantP3 = cantP3;
        display();
    }

    public void display() {
        System.out.println("Hola Juan - Inventario actualizado:");
        System.out.println("IPad: " + cantP1);
        System.out.println("IPhone XVI: " + cantP2);
        System.out.println("Mouse: " + cantP3);
        System.out.println();
    }
    
}
