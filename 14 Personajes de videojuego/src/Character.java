public abstract class Character {
    protected WeaponBehavior weapon;
    protected MoveBehavior move;

    public void performMove() {
        if (move != null) move.move();
    }

    public void performAttack() {
        if (weapon != null) weapon.attack();
    }

    public void setMoveBehavior(MoveBehavior m) {
        this.move = m;
    }

    public void setWeaponBehavior(WeaponBehavior w) {
        this.weapon = w;
    }

    public void showCharacter() {
        display();
    }

    public abstract void display();
}
