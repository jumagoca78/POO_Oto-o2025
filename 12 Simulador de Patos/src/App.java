public class App {
    public static void main(String[] args) throws Exception {
        Duck miPatito=new MallardDuck();
        miPatito.showDuck();

        System.out.println("**********");

        Duck miPatito2=new RedHeadDuck();
        miPatito2.showDuck();

        System.out.println("**********");

        Duck miPatito3=new RubberDuck();
        miPatito3.setFlyBehavior(new FlyRocketPowered());
        miPatito3.showDuck();

        System.out.println("**********");
        Duck miPatito4=new DecoyDuck();
        miPatito4.showDuck();

        System.out.println("**********");
        Duck miPatito5=new BallonDuck();
        miPatito5.showDuck();

    }
}
