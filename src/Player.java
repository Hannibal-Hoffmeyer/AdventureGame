import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int health = 100;


    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
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

    public EatResult eat(String itemName){
      for (Item item : inventory) {
          if(item.getShortName().equals(itemName)){
            if(item instanceof Food){
               health += ((Food) item).getHealthPoints();
               inventory.remove(item);
               return EatResult.EATEN;
              }
              return EatResult.NOT_FOOD;
          }

      }
      for (Item item : currentRoom.getItems()){
          if(item.getShortName().equals(itemName)){
              if(item instanceof Food){
                  health += ((Food) item).getHealthPoints();
                  inventory.remove(item);
                  return EatResult.EATEN;
              }
              return EatResult.NOT_FOOD;
          }
          

      }
      return EatResult.NOT_FOUND;
    }
}