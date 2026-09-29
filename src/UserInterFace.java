public class UserInterFace {

    public String command() {
        return IO.readln("Please input your first commando: ");
    }

    public void welcomeToTheGame() {
        IO.println("Welcome to the adventure game!");
        IO.println();
        IO.println("Your inputs are N, S, E, and W, which corresponds to a compass. Additionally, you can type LOOK to observe your surroundings.");
        IO.println();
    }

    public void errorMessage(String message) {
        IO.println(message);
    }

    public void printEatResult(EatResult eatResult, String itemName) {
        if(eatResult.equals(EatResult.EATEN)){
            IO.println("You ate the " + itemName);
        }
        if(eatResult.equals(EatResult.NOT_FOOD)){
            IO.println("That is not a food item");
        }
        if(eatResult.equals(EatResult.NOT_FOUND)){
           IO.println("This item does not exist");
        }

    }
}

