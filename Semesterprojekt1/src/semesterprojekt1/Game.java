package semesterprojekt1;


public class Game
{
    private Parser parser;
    private Room currentRoom;
    private Inventory playerInventory;
    
    private String playerName;
    
    private Room spawn, info, testRoom;
    private Interaction MariaI, MariaI2, MariaInfoI, MariaInfoI2, MariaInfoI3, HandbookI, HandbookHIV, HandbookTUR, HandbookMAL, PatientI, PatientI2, PatientI3;
    private NPC Maria, MariaInfo, Patient;
    private UtilityItem Handbook;
    private MedicineItem medicine;
    
    public Game() {
        createRooms();
        createInteraction();
        createNPC();
        createItem();
        playerInventory = new Inventory(10);
        parser = new Parser();
    }

    private void createRooms() {
        spawn = new Room("in the 'WHO' training facilities in Genéva");
        info = new Room("in the information center");
        testRoom = new Room("in a test facility. Here you will try to cure a patient");

        spawn.setExit("west", info);
        info.setExit("west", testRoom);
        
        currentRoom = spawn;
    }
    
    private void createInteraction() {
        //Spawn
        MariaI = new Interaction("root", "Hello my name is Maria, thank you for volunteering, i'll be your guide.");
        MariaI2 = new Interaction("What do i do now?", "Go to the information center to the west to learn more about your role in the operation.");
        MariaI.addChild(MariaI2);
        
        //Information center
        MariaInfoI = new Interaction("root", "You're on your way to Mozambique, it is therefore important you have some knowledge about the diseases you'll have to deal with.");
        MariaInfoI2 = new Interaction("Which diseases will I encounter?", "You will encounter HIV, Tuberculosis and Malaria");
        MariaInfoI3 = new Interaction("I think I'm ready can I go now?", "No! Not before you have the Doctor's Handbook, grab one from the shelf before you leave");
        MariaInfoI.addChild(MariaInfoI2);
        MariaInfoI.addChild(MariaInfoI3);
        MariaInfoI2.addChild(MariaInfoI3);
        
        //Handbook
        HandbookI = new Interaction("root", "Table of contents:");
        HandbookHIV = new Interaction("HIV", "People with HIV usually have these symptoms headache and fatigue.");
        HandbookTUR = new Interaction("Tuberculosis", "People with Turberculosis usually have these symptoms coughing and chest pain.");
        HandbookMAL = new Interaction("Malaria", "People with Malaria usually have these symptoms fever and nausea.");
        HandbookI.addChild(HandbookHIV);
        HandbookI.addChild(HandbookTUR);
        HandbookI.addChild(HandbookMAL);
        
        //TestRoom
        PatientI = new Interaction("root", "Please help me! My body is very warm and my skin is red");
        PatientI2 = new Interaction("Look for more Symptoms", "You see that the patient's throat is red, she has a high fever and a red rash all over her body");
        PatientI3 = new Interaction("Treat", "What would you like to treat the patient with?");
        PatientI.addChild(PatientI2);
        PatientI.addChild(PatientI3);
        PatientI2.addChild(PatientI3);
                
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
        Handbook = new UtilityItem("Handbook", "You can use this book to gain knowledge about diseases you might not know yet or have forgotten.", 0, 0, HandbookI);
        info.addItem(Handbook.getName(), Handbook);
        
        //TestRoom
        medicine = new MedicineItem("Medicine", "This will treat the patient.", 1, "HIV");
        testRoom.addItem(medicine.getName(), medicine);
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
        System.out.println("Welcome to Kill the Killers!");
        System.out.println("Where your job is to stop the spread of some of the biggest epidemics.");
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

        if (null != commandWord) switch (commandWord) {
            case HELP:
                printHelp();
                break;
            case GO:
                goRoom(command);
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
                if ("Inventory".equals(command.getSecondWord()))
                    playerInventory.printItemList();
                else if ("Handbook".equals(command.getSecondWord()))
                    Handbook.interactItem();
                else
                    System.out.println("Can't open " + command.getSecondWord());
            case INFO:
                System.out.println(currentRoom.getLongDescription());
            default:
                break;
        }
        return wantToQuit;
    }

    private void printHelp()
    {
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

            tempNPC.interact(playerInventory);
        }
        catch (NullPointerException e) {
            System.out.println("No NPC with that name here.");
        }
    }
    
    private void takeItem(Command command) {
        try {
            String name = command.getSecondWord();
            Item tempItem = currentRoom.getItem(name);
            playerInventory.addItem(tempItem.getName(), tempItem);
            System.out.println(tempItem.getName() + " was added to the inventory.");
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
        System.out.println("hello world");

    }

}
