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

        boolean AdventureStart = true;

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
