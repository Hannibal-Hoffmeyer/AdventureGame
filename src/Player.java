import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();

    public void pickUp(Item item, Room room) {
        room.removeItem(item);
        inventory.add(item);

    }

    public void dropItem(Item item, Room room) {
        inventory.remove(item);
        room.addItem(item);

    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }
}
