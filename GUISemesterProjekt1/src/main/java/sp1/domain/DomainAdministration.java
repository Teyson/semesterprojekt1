package sp1.domain;

import sp1.domain.Time;
public class DomainAdministration {
    Inventory playerInventory;
    Evaluation eval;
    Time time;
    MedicineItem hivMed;
    UtilityItem condom;
    Room spawn;
    Interaction mariaI;
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