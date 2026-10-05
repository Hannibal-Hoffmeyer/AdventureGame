public class RangedWeapon extends Weapon {

    private int ammunition;

    public RangedWeapon(String shortName, String longName, int damage, int ammunition) {
        super(shortName, longName, damage);
        this.ammunition = ammunition;
    }

    @Override
    public int attack() {
        if (ammunition > 0) {
            ammunition--;
            return getDamage();
        }

        return 0;
    }

    @Override
    public int remainingAmmunition() {
        return ammunition;
    }

    @Override
    public boolean canUse() {
        return ammunition > 0;
    }

    @Override
    public int use() {
        return ammunition;
    }
}