public class Room {
    private String description;
    private Room roomNorth;
    private Room roomWest;
    private Room roomSouth;
    private Room roomEast;

    public Room(String description) {
        this.description = description;
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
