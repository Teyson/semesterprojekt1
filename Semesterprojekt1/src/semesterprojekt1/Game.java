package semesterprojekt1;

public class Game {

    private Parser parser;
    private Room currentRoom;
    private Inventory playerInventory;

    private String playerName;

    private Room spawn, info, testRoom;
    private Interaction MariaI, MariaI2, MariaInfoI, MariaInfoI2, MariaInfoI3, HandbookI, HandbookHIV, HandbookTUB, HandbookMAL, PatientI, PatientI2, PatientI3, PatientI4;
    private NPC Maria, MariaInfo, Patient;
    private UtilityItem Handbook;
    private MedicineItem medicine;
    private UtilityItem condom;
    private boolean interactedMaria = false; //boolean for checking if you have interacted with Maria in spawn

    public Game() {
        createRooms();
        createInteraction();
        createNPC();
        createItem();
        playerInventory = new Inventory(10);
        parser = new Parser();
    }

    private void createRooms() {
        // rooms
        spawn = new Room("in the 'WHO' training facilities in Genéva");
        info = new Room("in the information center");
        testRoom = new Room("in the test facility. Here you will try to cure a patient");

        // exists
        spawn.setExit("west", info);
        info.setExit("west", testRoom);
        info.setExit("east", spawn);
        testRoom.setExit("east", testRoom);

        currentRoom = spawn;
    }

    private void createInteraction() {
        //Spawn
        MariaI = new Interaction("root", "Hello my name is Maria, and thank you so much for volunteering! I'll be your guide.");
        MariaI2 = new Interaction("What do I do now?", "Please go to the information center to the west, to learn more about your role in this operation.");
        MariaI.addChild(MariaI2);

        //Information center
        MariaInfoI = new Interaction("root", "You're on your way to Mozambique, it is therefore important you have some knowledge about the diseases you'll most likely be treating.");
        MariaInfoI2 = new Interaction("Which diseases will I encounter?", "You will encounter HIV, Tuberculosis and Malaria");
        MariaInfoI3 = new Interaction("I think I'm ready. Can I go now?", "No! Not before you have the Doctor's Handbook, grab one from the shelf before you leave");
        MariaInfoI.addChild(MariaInfoI2);
        MariaInfoI.addChild(MariaInfoI3);
        MariaInfoI2.addChild(MariaInfoI3);

        //Handbook
        HandbookI = new Interaction("root", "Table of contents:");
        HandbookHIV = new Interaction("HIV", "People with HIV usually have the following symptoms: headache and fatigue.");
        HandbookTUB = new Interaction("Tuberculosis", "People with Tuberculosis usually have the following symptoms: coughing and chest pain.");
        HandbookMAL = new Interaction("Malaria", "People with Malaria usually have the following symptoms: fever and nausea.");
        HandbookI.addChild(HandbookHIV);
        HandbookI.addChild(HandbookTUB);
        HandbookI.addChild(HandbookMAL);

        //TestRoom
        PatientI = new Interaction("root", "Please help me! My body is very warm and my skin is red");
        PatientI2 = new Interaction("Look for more symptoms", "You see that the patient's throat is red, she has a high fever and a red rash all over her body");
        PatientI3 = new Interaction("Treat", "What would you like to treat the patient with?");
        PatientI4 = new Interaction("Give item", "Which item would you like to give the patient?");
        PatientI.addChild(PatientI2);
        PatientI.addChild(PatientI3);
        PatientI2.addChild(PatientI3);
        PatientI2.addChild(PatientI4);
        PatientI.addChild(PatientI4);

    }

    private void createNPC() {
        //Spawn 
        Maria = new NPC("Maria", MariaI);
        spawn.addNPC(Maria.getName(), Maria);

        //Information center
        MariaInfo = new NPC("Maria", MariaInfoI);
        info.addNPC(MariaInfo.getName(), MariaInfo);

        //TestRoom
        Patient = new NPC("Patient", "HIV", PatientI);
        testRoom.addNPC(Patient.getName(), Patient);
    }

    private void createItem() {
        //Information center
        Handbook = new UtilityItem("Handbook", "A Doctor's Handbook giving fundamental knowledge about infectious diseases and their symptoms", 0, 0, HandbookI);
        info.addItem(Handbook.getName(), Handbook);

        //TestRoom
        medicine = new MedicineItem("Medicine", "This will treat the test Patient.", 1, "HIV");
        testRoom.addItem(medicine.getName(), medicine);
        
        condom = new UtilityItem("Condom", "This will protect you and your sexual partner from Sexually Transmitted Infections (STIs)", 1, 5);
        testRoom.addItem(condom.getName(), condom);
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to Kill the Killers!");
        System.out.println("Where your job is to stop the spread of some of the biggest infectious diseases in vulnerable countries!");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (null != commandWord) {
            OUTER:
            switch (commandWord) {
                case HELP:
                    if (command.hasSecondWord()) {
                        switch (command.getSecondWord()) {
                            case "go":
                                System.out.println("'go' - Makes you move to a specific room.");
                                break OUTER;
                            case "interact":
                                System.out.println("'interact' - Starts a conversation with a NPC.");
                                break OUTER;
                            case "take":
                                System.out.println("'take' - Takes an item and stores it in your inventory.");
                                break OUTER;
                            case "open":
                                System.out.println("'open' - Opens the Handbook & the Inventory.");
                                break OUTER;
                            default:
                                System.out.println("I don't get that");
                                break;
                        }
                    }
                    printHelp();
                    break;
                case GO:
                    goRoomNPCRequirements(command);
                    break;
                case QUIT:
                    wantToQuit = quit(command);
                    break;
                case INTERACT:
                    interactNPC(command);
                    break;
                case TAKE:
                    takeItem(command);
                    break;
                case OPEN:
                    if ("Inventory".equals(command.getSecondWord())) {
                        playerInventory.printItemList();
                    } else if ("Handbook".equals(command.getSecondWord())) {
                        Handbook.interactItem();
                    } else {
                        System.out.println("Can't open " + command.getSecondWord());
                    }
                    case INFO:
                    if (command.getSecondWord() == null) {
                        System.out.println(currentRoom.getLongDescription());
                    } else {
                        System.out.println("The info command has no second words.");
                    }
                default:
                    break;
            }
                
        }
        return wantToQuit;
    }

    private void printHelp() {
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoomNPCRequirements(Command command) {
        if (currentRoom.equals(spawn)) { //if you are in spawn this if statement checks if you have talked with Maria.
            if (interactedMaria == true) {
                goRoom(command);
            } else {  //if the player dont have interacted with Maria, they cant continue. 
                System.out.println("You can't continue without talking to Maria");
            }
        } //else if-statement checks, if you are inside the infoRoom.
        else if (currentRoom.equals(info)) {
            //if the player has the handbook the Player can continue and go to the next room
            if (playerInventory.getItemList().containsKey(Handbook.getName())) {
                goRoom(command);
            } else {  //if the player dont have the Handbook in inventory, they cant continue. 
                System.out.println("You can't continue without the Handbook");
            }
        } else { // normal goRoom method, when the current room or spawn isnt infoRoom
            goRoom(command);
        }

    }

    private void interactNPC(Command command) {
        try {
            if (command.getSecondWord() != null) {

                String name = command.getSecondWord();
                if (name.equals(Maria.getName())) {
                    this.interactedMaria = true;
                }

                NPC tempNPC = currentRoom.getNPC(name);

                tempNPC.interact(playerInventory);
            } else {
                System.out.println("Interact with who?");
            }
        } catch (NullPointerException e) {
            System.out.println("No NPC with that name here.");
        }
    }

    private void takeItem(Command command) {
        try {
            if (command.getSecondWord() != null) {
                String name = command.getSecondWord();
                Item tempItem = currentRoom.getItem(name);
                playerInventory.addItem(tempItem.getName(), tempItem);
                System.out.println(tempItem.getName() + " was added to the inventory.");
            } else {
                System.out.println("Take what?");
            }
        } catch (NullPointerException e) {
            System.out.println("No Item with that name here.");
        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
    public void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }
        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    public static void main(String[] args) {

        Game game = new Game();

        game.play();

    }

    
}
