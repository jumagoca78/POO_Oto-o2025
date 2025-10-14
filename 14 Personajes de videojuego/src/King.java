public class King extends Character {

    //Constructor
    public King() {
        weapon = new Sword();
        move = new ChestWalk();
    }

    @Override
    public void display() {
        System.out.println("I am the King.");
    }
}


