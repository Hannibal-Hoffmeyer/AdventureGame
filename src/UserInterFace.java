public class UserInterFace {

    public String command() {
        return IO.readln("Please input your first command: ");
    }

    public void welcomeToTheGame() {
        IO.println("Welcome to the adventure game!");
        IO.println();
        IO.println("Your inputs are N, S, E, and W, which corresponds to a compass. Additionally, you can type LOOK to observe your surroundings.");
        IO.println("You can also eat food to regain life if you lost some. Simply type EAT, followed by the object.");
        IO.println("but be careful! Not anything is good for you");
        IO.println();
    }

    public void errorMessage(String message) {
        IO.println(message);
    }
    public void printEatResult(EatResult eatResult, String itemName, int health) {
        if (eatResult.equals(EatResult.NOT_FOOD)) {
            IO.println("That is not a food item");
            return;
        }
        if (eatResult.equals(EatResult.NOT_FOUND)) {
            IO.println("This item does not exist");
            return;
        }
        if (eatResult.equals(EatResult.GOODFOOD)) {
            IO.println("You ate the " + itemName + " and you are now at " + health + " health. That was a good idea");
        }
        if(eatResult.equals(EatResult.BADFOOD)){
            IO.println("You ate the " + itemName + " and you are now at " + health + " health. That was a bad idea");

        }

    }

}

