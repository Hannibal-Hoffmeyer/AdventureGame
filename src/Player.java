import java.util.ArrayList;
import java.util.Locale;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int health = 100;


    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getHealth() {
        return health;
    }

    public void take(Item item, Room room) {
        room.removeItem(item);
        inventory.add(item);
    }

    public void dropItem(Item item, Room room) {
        inventory.remove(item);
        room.addItem(item);
    }

    public void printInventory() {
        if (inventory.isEmpty()) {
            IO.println("Your inventory is empty.");
            return;
        }

        for (Item item : inventory) {
            IO.println("You have: " + item.getLongName());
        }
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public Item getItem(String itemName) {
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public EatResult eat(String itemName) {
        Item item = getItem(itemName);
        if (item != null) {
                if (item instanceof Food) {
                    health += ((Food) item).getHealthPoints();
                    inventory.remove(item);
                    return isGood((Food) item);
                }
                return EatResult.NOT_FOOD;

        }
        Item roomItem = currentRoom.getItem(itemName);
        if (roomItem != null) {
            if (roomItem instanceof Food) {
                health += ((Food) roomItem).getHealthPoints();
                currentRoom.removeItem(roomItem);
                return isGood((Food) roomItem);
            }
            return EatResult.NOT_FOOD;
        }

        return EatResult.NOT_FOUND;
    }

    EatResult isGood(Food food) {
        if (food.getHealthPoints() > 0) return EatResult.GOODFOOD;
        else return EatResult.BADFOOD;
    }
}