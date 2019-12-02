package sp1.domain;

//package Domain;

public class DomainAdministration {
    Inventory playerInventory;
    Evaluation eval;
    Time time;
    MedicineItem hivMed;
    UtilityItem condom;
    Room spawn;
    Interaction MariaInfoI, MariaInfoI2, MariaInfoI3;
    NPC Maria;
    
    
    //Initializers
    public void makeItems() {
        hivMed = new MedicineItem("Hiv Medicine", "Appears to be fluent", 1, "HIV");
        spawn.addItem(hivMed.getName(), hivMed);
        condom = new UtilityItem("Condom", "This item can help the spreading of sexually transmitted diseases", 1, 5, "HIV");
        spawn.addItem(condom.getName(), condom);
    }
    
    public void makeRooms() {
        spawn = new Room("You're in the spawn.");
    }
    
    public void makeInteractions() {
        MariaInfoI = new Interaction("root", "You're on your way to Mozambique, it is therefore important you have some knowledge about the diseases you'll most likely be treating.");
        MariaInfoI2 = new Interaction("Which diseases will I encounter?", "You will encounter HIV, Tuberculosis and Malaria");
        MariaInfoI3 = new Interaction("I think I'm ready. Can I go now?", "No! Not before you have the Doctor's Handbook, grab one from the shelf before you leave");
        MariaInfoI.addChild(MariaInfoI2);
        MariaInfoI.addChild(MariaInfoI3);
        MariaInfoI2.addChild(MariaInfoI3);
        
        
    }
    
    public void makeNPCS() {
        Maria = new NPC("Maria", MariaInfoI);
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