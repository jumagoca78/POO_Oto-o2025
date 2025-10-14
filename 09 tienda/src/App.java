public class App {
    public static void main(String[] args) throws Exception {
        Tienda tienda = new Tienda();
        Cliente1 cliente1 = new Cliente1(tienda);
        Cliente2 cliente2 = new Cliente2(tienda);
        Cliente3 cliente3 = new Cliente3(tienda);

        tienda.setCantP1(10);
        tienda.setCantP2(20);
        tienda.setCantP3(30);

        tienda.setCantP1(5);
    }
}
