package sp1.domain;

import sp1.domain.Time;
public class DomainAdministration {
    //Declaring the important elements of the game
    Inventory playerInventory;
    Evaluation eval;
    Time time;
    
    //Declaring the items
    MedicineItem hivMed;
    UtilityItem condom;
    MedicineItem malMed;
    UtilityItem mosquitoSpray;
    MedicineItem tbMed;
    UtilityItem faceMask;
    
    //Declaring the Rooms
    Room spawn;
    Room medHQ;
    Room village;
    Room hut1;
    Room hut2;
    Room hut3;
    Room tent;
    
    //Declaring the NPCs
    NPC Maria;
    
    Interaction mariaI;
    
    //Initializers
    public void makeItems() {
        //Creating the relevant items
        hivMed = new MedicineItem("HIV Medicine", "Appears to be a pink-ish liquid", 1, "HIV");
        condom = new UtilityItem("Condom", "This can prevent the spread of sexually transmitted diseases", 1, 5, "HIV");
        
        malMed = new MedicineItem("Malaria Medicine", "Appears to be a green-ish liquid", 1, "Malaria");
        mosquitoSpray = new UtilityItem("Mosquito Spray", "This can keep mosquitos away at night", 1, 5, "Malaria");
        
        tbMed = new MedicineItem("Tuberculosis Medicine", "Appears to be a blue-ish liquid", 1, "Tuberculosis");
        faceMask = new UtilityItem("Face Mask", "This can keep Tuberculosis patients from infecting others", 1, 5, "Tuberculosis");
        
        //Assigning the items to the rooms
        spawn.addItem(hivMed.getName(), hivMed);
        spawn.addItem(condom.getName(), condom);
    }
    
    public void makeRooms() {
        spawn = new Room("You're in the WHO Headquarters in Geneva.");
        medHQ = new Room("You're in the medicine storage facility in the WHO warehouse in Mozambique");
        village = new Room("You're in a small village in eastern Mozambique");
        hut1 = new Room("You're in one of the village's few huts");
        hut2 = new Room("You're in one of the village's few huts");
        hut3 = new Room("You're in one of the village's few huts");
        tent = new Room("You're in your remote location WHO tent, used for storing medicine");
        
    }
    
    
    public void makeInteractions() {
        mariaI = new Interaction("root", "Hello, my name is Maria!");
    }
    
    
    public void makeNPCS() {
        Maria = new NPC("Maria", mariaI);
        spawn.addNPC("Maria", Maria);
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
    
    public int getTime() {
        return time.getTime();
    }
    
    //Setup
    public void setup() {
        makeRooms();
        makeItems();
        makeInteractions();
        makeNPCS();
        eval = new Evaluation();
        playerInventory = new Inventory(10);
        time = new Time();
    }
}