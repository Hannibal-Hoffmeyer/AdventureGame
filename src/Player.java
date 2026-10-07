import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int health = 100;
    private Weapon weapon;

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
        if (weapon == item) {
            weapon = null;
        }
        room.addItem(item);
    }

    public void printInventory() {
        if (inventory.isEmpty()) {
            IO.println("Your inventory is empty.");
        } else {
            for (Item item : inventory) {
                IO.println("You have: " + item.getLongName());
            }
        }

        if (weapon == null) {
            IO.println("Equipped weapon: none");
        } else {
            IO.println("Equipped weapon: " + weapon.getLongName());
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
        if (food.getHealthPoints() > 0) {
            return EatResult.GOODFOOD;
        } else {
            return EatResult.BADFOOD;
        }
    }

    public EquipResult equipWeapon(String itemName) {
        Item item = getItem(itemName);

        if (item == null) {
            return EquipResult.NOT_FOUND;
        }

        if (item instanceof Weapon) {
            weapon = (Weapon) item;
            return EquipResult.EQUIPPED;
        }

        return EquipResult.NOT_WEAPON;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void attack(Enemy enemy) {

        if (weapon == null) {
            IO.println("You don't have a weapon equipped.");
            return;
        }

        if (weapon.canUse()) {
            int damage = weapon.attack();
            enemy.takeDamage(damage);

            IO.println("You attacked the " + enemy.getShortName()
                    + " for " + damage + " damage.");
            if(enemy.getEnemyHp() > 0){
                int enemyDamage = enemy.attack();
                takeDamage(enemyDamage);

                IO.println("the " + enemy.getShortName() + " retaliates and attacks you for " + enemyDamage + " damage");
                IO.println("youre at " + health + " health");
            }

        }
        else {
            IO.println("You cannot use the weapon.");
        }
    }

    public void takeDamage(int damage) {
        health -= damage;

        if (health < 0) {
            health = 0;
        }

    }
}