public class BallonDuck extends Duck {
    
    public BallonDuck() {
        flyBehavior = new FlyWithBallon();
        quackBehavior = new Quack();
    }
    
    @Override
    public void display() {
        System.out.println("I'm a Ballon Duck");
    }
    
}
