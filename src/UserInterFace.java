public class UserInterFace {

    public String command() {
        return IO.readln("Please input your first commando: ").toUpperCase();
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
}
