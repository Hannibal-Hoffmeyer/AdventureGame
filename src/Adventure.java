public class Adventure {

    public void AdventureStart() {
        Map map = new Map();
        Player player = new Player(map.getFirstRoom());
        boolean chestOpened = false;
        Item treasure = new Item("treasure", "a large quantity of gold and jewels");


        boolean AdventureStart = true;
        UserInterFace userInterFace = new UserInterFace();

        userInterFace.welcomeToTheGame();

        while (AdventureStart) {

            if(player.getItem("treasure") !=null){
                IO.println("CONGRATULATIONS ON FINDING THE TREASURE, YOU WIN!");
                break;
            }

            if (player.getHealth() <= 0) {
                IO.println("GAME OVER");
                break;
            }

            String input = userInterFace.command();

            String[] parts = input.split(" ", 2);

            String kommando = parts[0].toUpperCase();

            switch (kommando) {
                case "LOOK" -> {
                    IO.println(player.getCurrentRoom().getDescription());
                    player.getCurrentRoom().printItems();
                    player.getCurrentRoom().printEnemy();
                }
                case "HEALTH" -> {
                    if (player.getHealth() >= 100) {
                        IO.println(player.getHealth() + " You are in good health");
                    } else
                        IO.println(player.getHealth() + " You are low health, eat some food to get your strengt back");
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
                case "EAT" -> {
                    if (parts.length < 2) {
                        IO.println("Please specify an item to eat.");
                        break;
                    }
                    String itemName = parts[1];
                    EatResult eatResult = player.eat(itemName);
                    if (eatResult == null) IO.println("ERROR");
                    userInterFace.printEatResult(eatResult, itemName, player.getHealth());
                }
                case "EQUIP" -> {
                    if (parts.length < 2) {
                        IO.println("Please specify an item to equip.");
                        break;
                    }
                    String itemName = parts[1];
                    EquipResult equipResult = player.equipWeapon(itemName);

                    if (EquipResult.EQUIPPED.equals(equipResult)) {
                        IO.println("You have equipped " + itemName);
                    }
                    if (EquipResult.NOT_FOUND.equals(equipResult)) {
                        IO.println("That weapon doesn't exist");

                    }
                    if (EquipResult.NOT_WEAPON.equals(equipResult)) {
                        IO.println(itemName + " is not a weapon");
                    }
                }
                case "AMMUNITION", "AMMO" -> {
                    Weapon weapon = player.getWeapon();
                    if (weapon == null) {
                        IO.println("You have no weapon");
                    } else if (weapon.outOfAmmunition()) {
                        IO.println("Out of ammo");
                    } else {
                        IO.println("Ammo left: " + weapon.remainingAmmunition());
                    }
                }
                case "ATTACK" -> {
                    if (parts.length < 2) {
                        IO.println("Please specify an enemy.");
                        break;
                    }

                    String enemyName = parts[1];

                    Enemy enemy = player.getCurrentRoom().getEnemy(enemyName);

                    if (enemy != null) {
                        player.attack(enemy);
                        if (enemy.getEnemyHp() <= 0) {

                            Weapon enemyWeapon = enemy.getEnemyWeapon();

                            if (enemyWeapon != null) {

                                player.getCurrentRoom().addItem(enemyWeapon);
                            }

                            player.getCurrentRoom().removeEnemy(enemy);

                            IO.println("you have slain the " + enemy.getShortName() + " it dropped " + enemyWeapon.getLongName());
                        }
                    } else {
                        IO.println("There is no such enemy here.");
                    }
                }
                    case "OPEN" -> {
                        if (parts.length < 2) {
                            IO.println("What do you want to open?");
                            break;
                        }

                        String object = parts[1];

                        if (object.equalsIgnoreCase("chest")) {

                            if (chestOpened) {
                                IO.println("The chest is already open.");
                            } else {
                                Item key = player.getItem("key");

                                if (key != null) {
                                    IO.println("You unlock the chest with the key.");
                                    IO.println("Inside the chest you find a large treasure!");

                                    player.getCurrentRoom().addItem(treasure);

                                    chestOpened = true;
                                } else {
                                    IO.println("The chest is locked. You need a key.");
                                }
                            }
                        }
                    }
                }

            }
        }
    }

