import java.util.ArrayList;

public class Room {
    private String description;
    private Room roomNorth;
    private Room roomWest;
    private Room roomSouth;
    private Room roomEast;

    private ArrayList<Item> items;

    private ArrayList<Enemy> enemies;


    public Room(String description) {
        this.description = description;
        this.items = new ArrayList<>();
        this.enemies = new ArrayList<>();

    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void printItems() {
        for (Item item : items) {
            IO.println("You see: " + item.getLongName());
        }
    }

    public Item getItem(String shortName) {
        for (Item item : items) {
            if (item.getShortName().equalsIgnoreCase(shortName)) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }
    public void removeEnemy(Enemy enemy){
        enemies.remove(enemy);
    }
    public void printEnemy(){
        for(Enemy enemy : enemies){
            IO.println("you see " + enemy.getEnemyDescription());
        }
    }
    public Enemy getEnemy(String shortName) {
        for (Enemy enemy : enemies) {
            if (enemy.getShortName().equalsIgnoreCase(shortName)) {
                return enemy;
            }
        }
        return null;
    }

    public String getDescription() {
        return description;
    }

    public Room getRoomNorth() {
        return roomNorth;
    }

    public Room getRoomWest() {
        return roomWest;
    }

    public Room getRoomSouth() {
        return roomSouth;
    }

    public Room getRoomEast() {
        return roomEast;
    }

    public void setRoomNorth(Room roomNorth) {
        this.roomNorth = roomNorth;
    }

    public void setRoomWest(Room roomWest) {
        this.roomWest = roomWest;
    }

    public void setRoomSouth(Room roomSouth) {
        this.roomSouth = roomSouth;
    }

    public void setRoomEast(Room roomEast) {
        this.roomEast = roomEast;
    }
}