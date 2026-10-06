public class Enemy {

    private String shortName;
    private String enemyDescription;
    private int enemyHp;
    private Weapon enemyWeapon;
    private Room enemyRoom;


    public Enemy (String shortName, String enemyDescription, int enemyHp, Weapon enemyWeapon, Room enemyRoom){
       this.shortName = shortName;
       this.enemyDescription = enemyDescription;
       this.enemyHp = enemyHp;
       this.enemyWeapon = enemyWeapon;
       this.enemyRoom = enemyRoom;
    }
    public String getShortName(){
        return shortName;
    }

    public String getEnemyDescription() {
        return enemyDescription;
    }

    public int getEnemyHp() {
        return enemyHp;
    }

    public Weapon getEnemyWeapon() {
        return enemyWeapon;
    }

    public Room getEnemyRoom() {
        return enemyRoom;
    }
    public void setEnemyRoom(Room room){
        this.enemyRoom = room;
    }
}
