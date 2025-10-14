public abstract class Duck {

    //el unico metodo abstracto es
    //display
    public abstract void display();

    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;

    public Duck() {
    }
    
    public void swim() {
        System.out.println("I'm swimming");
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void showDuck (){
        display();
        swim();
        performQuack();
        performFly();
    }
}
