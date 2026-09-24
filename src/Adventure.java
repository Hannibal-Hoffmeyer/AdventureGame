public class Adventure {



    public void AdventureStart() {
    Map map = new Map();
    Player player = new Player(map.getFirstRoom());


        boolean AdventureStart = true;
        UserInterFace userInterFace = new UserInterFace();

        userInterFace.welcomeToTheGame();

        while (AdventureStart) {

            String kommando = userInterFace.command();
            switch (kommando) {
                case "LOOK" -> {
                    IO.println(player.getCurrentRoom().getDescription());
                }
                case "N" -> {
                    if (player.getCurrentRoom().getRoomNorth() != null) {
                        Room northRoom = player.getCurrentRoom().getRoomNorth();
                        player.setCurrentRoom(northRoom);
                        IO.println(player.getCurrentRoom().getDescription());
                    } else {
                        userInterFace.errorMessage("You cannot go north.");
                    }
                }
                case "S" -> {
                    if (player.getCurrentRoom().getRoomSouth() != null) {
                        Room roomSouth = player.getCurrentRoom().getRoomSouth();
                        player.setCurrentRoom(roomSouth);
                        IO.println(player.getCurrentRoom().getDescription());
                    } else {
                        userInterFace.errorMessage("You cannot go south.");
                    }
                }
                case "E" -> {
                    if (player.getCurrentRoom().getRoomEast() != null) {
                        Room roomEast = player.getCurrentRoom().getRoomEast();
                        player.setCurrentRoom(roomEast);
                        IO.println(player.getCurrentRoom().getDescription());
                    } else {
                        userInterFace.errorMessage("You cannot go East");
                    }

                }
                case "W" -> {
                    if (player.getCurrentRoom().getRoomWest() != null) {
                        Room roomWest= player.getCurrentRoom().getRoomWest();
                        player.setCurrentRoom(roomWest);
                        IO.println(player.getCurrentRoom().getDescription());
                    } else {
                        userInterFace.errorMessage("You cannot go west.");
                    }
                }
            }
        }
    }
}