public class Adventure {

    private Room currentRoom;

    public void AdventureStart() {
        Room room1 = new Room("Du vågner op i en mørk grotte.");
        Room room2 = new Room("Du bevæger dig dybere ned i grotten, der ligger en bjørn og sover...");
        Room room3 = new Room("Du bevæger dig ud af grotten, du ankommer til en lysning i en skov.");
        Room room4 = new Room("Du går videre og foran dig ser du grotten, hvor du vågnede. Gik du bare i en cirkel?");
        Room room5 = new Room("Du løser gåden og kommer ind. Indenfor er der kun en kiste; du åbner den. Inde i kisten ligger et kort, der viser vejen ud af skoven. Du finder endelig udgangen af her – tillykke!");
        Room room6 = new Room ("Mens du bevæger dig videre, finder du en bro i nærheden.");
        Room room7= new Room ("Der ligger en gammel hytte i nærheden, men det ser ikke ud til, at der er nogen; den har været forladt i lang tid.");
        Room room8 = new Room ("Foran tårn står en mand, løs hans gåde for at fortsætte.");
        Room room9 = new Room("Du forsætter over broen og ser et enormt tårn mød øst.");

        currentRoom = room1;
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
        boolean AdventureStart = true;
        IO.println("velkommen til Adventure spillet");
        IO.println();
        IO.println("Dine bevægelses knapper er N,S,E,W som svarer til et kompass, derudover kan du skrive LOOK for at observere dine omgivelser");
        IO.println();
        while(AdventureStart){

            String kommando = IO.readln().toUpperCase();
            switch(kommando){
                case "LOOK" -> {
                    IO.println(currentRoom);
                }
                case "N" ->{
                    IO.println("D fortsætter nordpå");
                }
                case "S" ->{
                    IO.println("Du fortsætter sydpå");
                }
                case "E" ->{
                    IO.println("Du fortsætter østpå");
                }
                case "W" ->{
                    IO.println("Du fortsætter vestpå");
                }

            }
        }


    }

}
