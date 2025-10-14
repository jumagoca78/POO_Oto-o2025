public class App {
    public static void main(String[] args) throws Exception {
        Character king = new King();
        king.setWeaponBehavior(new Sword());
        king.setMoveBehavior(new ChestWalk());

        king.showCharacter();
        king.performAttack();
        king.performMove();

        System.out.println("---");

        Character troll = new Troll();
        troll.setWeaponBehavior(new Axe());
        troll.setMoveBehavior(new SquatWalk());

        troll.showCharacter();
        troll.performAttack();
        troll.performMove();
    }
}
