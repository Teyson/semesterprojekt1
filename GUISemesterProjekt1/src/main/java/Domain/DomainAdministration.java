package Domain;

public class DomainAdministration {
    //Setting the important non-changing elements
    Inventory playerInventory;
    Evaluation eval;
    Time time;
    
    //Setting the different items
    MedicineItem hivMed;
    UtilityItem condom;
    MedicineItem tbMed;
    UtilityItem faceMask;
    MedicineItem malMed;
    UtilityItem mosquitoSpray;
    
    //Setting the rooms
    Room currentRoom;
    Room spawn;
    Room medHQ;
    Room village;
    Room hut1;
    Room hut2;
    Room hut3;
    Room tent;
    
    //Creating interactions
    Interaction empty;
    
    //Creating the NPCs (Male)
    NPC Faizal;
    NPC Leonildo;
    NPC Nelton;
    NPC Momed;
    NPC Abubakar;
    NPC Brayton;
    NPC Kelven;
    NPC Riyadh;
    
    //Creating the NPCs (Female)
    NPC Maria;
    NPC Henda;
    NPC Yuran;
    NPC Kishor;
    NPC Kiri;
    NPC Ikbal;
    NPC Jojo;
    NPC Gani;
    
    //Initializers
    public void makeItems() {
        //Creating the HIV Items
        hivMed = new MedicineItem("HIV Medicine", "Appears to be a pinkish liquid", 1, "HIV");
        condom = new UtilityItem("Condom", "Condoms prevent the spread of sexually transmitted diseases", 1, 5, "HIV");
        
        //Creating the Malaria Items
        malMed = new MedicineItem("Malaria Medicine", "Appears to be a greenish liquid", 1, "Malaria");
        mosquitoSpray = new UtilityItem("Mosquito Spray", "Spray that keeps the mosquitos away during the night", 1, 5, "Malaria");
        
        //Creating the TB Items
        tbMed = new MedicineItem("Tuberculosis Medicine", "Appears to be a blueish liquid", 1, "Tuberculosis");
        faceMask = new UtilityItem("Face Mask", "Mask to cover mouth and nose, keeping TB Patients from spreading the infection", 1, 5, "Tuberculosis");

        spawn.addItem(condom.getName(), condom);
    }
    
    public void makeRooms() {
        spawn = new Room("You're in WHO Facilities in Geneva.");
        medHQ = new Room("You're in the WHO Outpost in Mozambique.");
        village = new Room("You're in a village in the eastern Mozambique.");
        hut1 = new Room("You're in one of the village's few huts.");
        hut2 = new Room("You're in one of the village's few huts.");
        hut3 = new Room("You're in one of the village's few huts.");
        tent = new Room("You're in the WHO storage tent that you set up.");
    }
    
    public void makeNPCS() {
        //Creating the NPCs (Female)
        Maria = new NPC("Maria");
        Henda = new NPC("Henda");
        Yuran = new NPC("Yuran");
        Kishor = new NPC("Kishor");
        Kiri = new NPC("Kiri");
        Ikbal = new NPC("Ikbal");
        Jojo = new NPC("Jojo");
        Gani = new NPC("Gani");
        
        //Creating the NPCs (Male)
        Faizal = new NPC("Faizal", empty);
        Leonildo = new NPC("Leonildo", empty);
        Nelton = new NPC("Nelton", empty);
        Momed = new NPC("Momed", empty);
        Abubakar = new NPC("Abubakar", empty);
        Brayton = new NPC("Brayton", empty);
        Kelven = new NPC("Kelven", empty);
        Riyadh = new NPC("Riyadh", empty);
        
        //Allocating them to a 
        spawn.addNPC("Maria Hoffmann", Maria);
        medHQ.addNPC("Maria Hoffmann", Maria);
    }
    
    //Getters
    public Evaluation getEvaluation() {
        return eval;
    }
    
    public Inventory getInventory() {
        return playerInventory;
    }
    
    public Room getRoom() {
        return spawn;
    }   
    
    public void setRoom(Room room) {
        currentRoom = room;
    }
    
    public int getTime() {
        return time.getTime();
    }
    
    //Setup
    public void setup() {
        currentRoom = spawn;
        makeRooms();
        makeItems();
        makeNPCS();
        eval = new Evaluation();
        playerInventory = new Inventory(7);
        playerInventory.addItem(condom.getName(), condom);
        playerInventory.addItem("HIV Medication", hivMed);
        time = new Time();
    }
}