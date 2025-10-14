public class Cliente2 implements Observer 
/*Este cliente solo esta interesado en los productos 1 y 3 */
{
    private int cantP1;
    private int cantP3;
    private Tienda tienda;

    public Cliente2(Subject tienda) {
        this.tienda = (Tienda) tienda;
        tienda.registerObserver(this);
    }

    @Override
    public void update(int cantP1, int cantP2, int cantP3) {
        this.cantP1 = cantP1;
        this.cantP3 = cantP3;
        display();
    }

    public void display() {
        System.out.println("Hola Maria - Inventario actualizado:");
        System.out.println("IPad: " + cantP1);
        System.out.println("Mouse: " + cantP3);
        System.out.println();
    }
}
