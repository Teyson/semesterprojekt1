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
        
        //Initialising the items in the rooms, using the shown commented format
        //[ROOM].addItem([ITEM].getName(), [ITEM]);
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
        Henda = new NPC("Henda", "HIV");
        Yuran = new NPC("Yuran", "HIV");
        Kishor = new NPC("Kishor", "HIV");
        Kiri = new NPC("Kiri", "Tuberculosis");
        Ikbal = new NPC("Ikbal", "Tuberculosis");
        Jojo = new NPC("Jojo", "Malaria");
        Gani = new NPC("Gani", "Malaria");
        
        //Creating the NPCs (Male)
        Faizal = new NPC("Faizal", "HIV");
        Leonildo = new NPC("Leonildo", "HIV");
        Nelton = new NPC("Nelton", "Tuberculosis");
        Momed = new NPC("Momed", "Tuberculosis");
        Abubakar = new NPC("Abubakar", "Tuberculosis");
        Brayton = new NPC("Brayton", "Malaria");
        Kelven = new NPC("Kelven", "Malaria");
        Riyadh = new NPC("Riyadh", "Malaria");
        
        //Allocating the NPCs to a room
        spawn.addNPC("Maria Hoffmann", Maria);
        medHQ.addNPC("Maria Hoffmann", Maria);
        
        hut1.addNPC("Henda", Henda);
        hut1.addNPC("Kishor", Kishor);
        hut1.addNPC("Nelton", Nelton);
        hut1.addNPC("Momed", Momed);
        hut1.addNPC("Leonildo", Leonildo);
        
        hut2.addNPC("Yuran", Yuran);
        hut2.addNPC("Kishor", Kishor);
        hut2.addNPC("Riyadh", Riyadh);
        hut2.addNPC("Gani", Gani);
        
        hut3.addNPC("Kiri", Kiri);
        hut3.addNPC("Ikbal", Ikbal);
        hut3.addNPC("Jojo", Jojo);
        hut3.addNPC("Abubakar", Abubakar);
        hut3.addNPC("Brayton", Brayton);
        hut3.addNPC("Kelven", Kelven);
        
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
    
    public Time getTime() {
        return time;
    }
    
    //Setup
    public void setup() {
        makeRooms();
        makeItems();
        makeNPCS();
        eval = new Evaluation();
        playerInventory = new Inventory(10);
        time = new Time();
    }
}