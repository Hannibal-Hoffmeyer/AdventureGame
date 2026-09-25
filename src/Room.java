import java.util.ArrayList;



public class Room {
    private String description;
    private Room roomNorth;
    private Room roomWest;
    private Room roomSouth;
    private Room roomEast;

    private ArrayList<Item> items;

    public Room(String description) {
        this.description = description;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public Item findItem(String name){
        for (Item item : items){
            if (item.getShortName().equals(name)) {
                return item;
            }
        }
        return null;
    }
    public void removeItem(Item item){
        items.remove(item);
    }

    public String getDescription() {
        return description;
    }

   public Room getRoomNorth(){
        return roomNorth;
   }
   public Room getRoomWest(){
        return roomWest;
   }

    public Room getRoomSouth() {
        return roomSouth;
    }

    public Room getRoomEast() {
        return roomEast;
    }
    public void setRoomNorth (Room roomNorth){
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