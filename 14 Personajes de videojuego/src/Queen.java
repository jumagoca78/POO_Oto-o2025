public class Queen extends Character {

    //constructor
    public Queen() {
        weapon = new BowAndArrow();
        move = new Run();
    }

    @Override
    public void display() {
        System.out.println("I am the Queen.");
    }
}

