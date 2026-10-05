public class RangedWeapon extends Weapon {
    private int ammunition = 5;
    public RangedWeapon(String shortName, String longName, int damage, int ammunition){
        super(shortName, longName, damage);
        this.ammunition = ammunition;


    }

    @Override
    public int attack() {
        ammunition = ammunition -1;
        return getDamage();
    }

    @Override
    public int remainingAmmunition() {
        return ammunition;
    }
}
