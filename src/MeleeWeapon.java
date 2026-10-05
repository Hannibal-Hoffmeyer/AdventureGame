public class MeleeWeapon extends Weapon {


    public MeleeWeapon(String shortName, String longName, int damage) {
        super(shortName, longName, damage);
    }

    @Override
    public int attack() {
        return getDamage();
    }

    @Override
    public int remainingAmmunition() {
        return -1;
    }
}
