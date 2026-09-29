public class Adventure {


    public void AdventureStart() {
        Map map = new Map();
        Player player = new Player(map.getFirstRoom());


        boolean AdventureStart = true;
        UserInterFace userInterFace = new UserInterFace();

        userInterFace.welcomeToTheGame();

        while (AdventureStart) {

            String input = userInterFace.command();

            String[] parts = input.split(" ", 2);

            String kommando = parts[0].toUpperCase();

            switch (kommando) {
                case "LOOK" -> {
                    IO.println(player.getCurrentRoom().getDescription());
                    player.getCurrentRoom().printItems();
                }
                case "INVENTORY", "INV", "I" -> {
                    player.printInventory();
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
                        Room roomWest = player.getCurrentRoom().getRoomWest();
                        player.setCurrentRoom(roomWest);
                        IO.println(player.getCurrentRoom().getDescription());
                    } else {
                        userInterFace.errorMessage("You cannot go west.");
                    }

                }
                case "TAKE" -> {
                    if (parts.length < 2) {
                        IO.println("Please specify an item.");
                        break;
                    }

                    String itemName = parts[1];

                    Item item = player.getCurrentRoom().getItem(itemName);

                    if (item != null) {
                        player.take(item, player.getCurrentRoom());
                        IO.println("You picked up the " + item.getShortName() + ".");
                    } else {
                        IO.println("There is no such item here.");
                    }
                }
                case "DROP" -> {
                    if (parts.length < 2) {
                        IO.println("Please specify an item.");
                        break;
                    }

                    String itemName = parts[1];
                    Item item = player.getItem(itemName);

                    if (item != null) {
                        player.dropItem(item, player.getCurrentRoom());
                        IO.println("You dropped the " + item.getShortName() + ".");
                    } else {
                        IO.println("You are not carrying that item.");
                    }
                }
            }

        }

    }
}
