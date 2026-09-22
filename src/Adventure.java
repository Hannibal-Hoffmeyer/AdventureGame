public class Adventure {

    private Room currentRoom;

    public Adventure() {
        Room room1 = new Room("Du vågner op i en mørk grotte");
        Room room2 = new Room("Du bevæger dig dybere ned i grotten, der ligger en bjørn og sover...");
        Room room3 = new Room("du bevæger dig ud af grotten, du ankommer til en lysning i en skov");

        currentRoom = room1;
    }
}
