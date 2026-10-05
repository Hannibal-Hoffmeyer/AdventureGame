public abstract class Weapon extends Item {

    private int damage;

    public Weapon(String shortName, String longName, int damage) {
        super(shortName, longName);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public abstract int attack();

    public abstract int remainingAmmunition();

    public boolean outOfAmmunition() {
        return remainingAmmunition() == 0;
    }

    public abstract boolean canUse();

    public abstract int use();
}