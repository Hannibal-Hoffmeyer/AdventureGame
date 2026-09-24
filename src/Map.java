public class Map {
    private final Room room1 = new Room("You are inside a dark cave. There are two ways out: to the east and to the south.");
   private final Room room2 = new Room("You move deeper into the cave and find a bear lying there asleep...");
   private final Room room3 = new Room("You find yourself outside the cave; you arrive at a clearing in a forest.");
   private final Room room4 = new Room("You find yourself outside of the grotto. Nearby of it there's a deer drinking from a river and a steep mountain.");
   private final Room room5 = new Room("Inside the castle there is only a chest and an old skeleton sitting in a chair; you decide to open the chest. Inside of it is a map showing the way out of this forest. You can finally find your way out of here — congratulations!");
   private final Room room6 = new Room("As you move on, you find a bridge nearby, it seems safe to walk.");
   private final Room room7 = new Room("You find an old hut nearby, but it doesn't look like anyone is there; it has been abandoned for a long time.");
   private final Room room8 = new Room("At the tower you see there's no one guarding it and the door is half-open. Maybe someone's inside?");
   private final Room room9 = new Room("You continue across the bridge and see a huge tower to the east.");
public Map() {

    room1.setRoomEast(room2);
    room1.setRoomSouth(room4);
    room2.setRoomEast(room3);
    room2.setRoomWest(room1);
    room3.setRoomWest(room2);
    room3.setRoomSouth(room6);
    room4.setRoomNorth(room1);
    room4.setRoomSouth(room7);
    room6.setRoomNorth(room3);
    room6.setRoomSouth(room9);
    room7.setRoomNorth(room4);
    room7.setRoomEast(room8);
    room8.setRoomNorth(room5);
    room8.setRoomWest(room7);
    room8.setRoomEast(room9);
    room9.setRoomWest(room8);
    room9.setRoomNorth(room6);
}

    public Room getFirstRoom() {
        return room1;
    }
}
