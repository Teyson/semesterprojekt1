package semesterprojekt1;

import java.util.HashMap;

public class Game
{
    private Parser parser;
    private Room currentRoom;

    Interaction samtale1 = new Interaction("rod", "Hej jeg hedder samba");
    Interaction samtale2 = new Interaction("rodd", "Jeg er boomer mogens");
    NPC samba = new NPC("Samba", samtale1);
    NPC mogens = new NPC("Mogens", samtale2);
    MedicineItem kanyle = new MedicineItem("Kanyle", "testitem", 2, "cancer");
    
    
    public Game()
    {
        createRooms();
        parser = new Parser();
    }

    private void createRooms()
    {
        Room outside, theatre, pub, lab, office;

        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.addNPC(samba.getName(), samba);
        outside.addNPC(mogens.getName(), mogens);
        outside.addItem(kanyle.getName(), kanyle);
        
        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;
    }

    public void play()
    {
        printWelcome();


        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        else if (commandWord == CommandWord.INTERACT) {
            interactNPC(command);
        }
        else if (commandWord == CommandWord.TAKE) {
            takeItem(command);
        }
        return wantToQuit;
    }

    private void printHelp()
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }
    
    private void interactNPC(Command command) {
        try {
            String name = command.getSecondWord();
            NPC tempNPC = currentRoom.getNPC(name);

            tempNPC.getInteraction().start();
        }
        catch (NullPointerException e) {
            System.out.println("No NPC with that name here.");
        }
    }
    
    private void takeItem(Command command) {
        try {
            String name = command.getSecondWord();
            Item tempItem = currentRoom.getItem(name);
            System.out.println("You picked up: " + tempItem.getName());
        }
        catch (NullPointerException e) {
            System.out.println("No Item with that name here.");
        }
        
    }

    private boolean quit(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }

    public static void main(String[] args) {

        Game game = new Game();
        
        game.play();

    }

}
