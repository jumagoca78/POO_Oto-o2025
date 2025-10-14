public class Knight extends Character {

    //constructor
    public Knight() {
        weapon = new Sword();
        move = new Walk();
    }

    @Override
    public void display() {
        System.out.println("I am the Knight.");
    }
}

