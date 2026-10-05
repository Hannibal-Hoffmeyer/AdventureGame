abstract public class  Weapon extends Item{
    private int damage;
   public Weapon (String shortName, String longName, int damage){
       super(shortName, longName);
       this.damage = damage;
   }
abstract int attack();

abstract int remainingAmmunition();

public boolean outOfAmmunition() {
    return remainingAmmunition() == 0;
}

public int getDamage(){
    return damage;
}

}
