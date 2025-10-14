public class Troll extends Character {

    //Constructor
    public Troll() {
        weapon = new Axe();
        move = new SquatWalk();
    }

    @Override
    public void display() {
        System.out.println("I am the Troll.");
    }
}

