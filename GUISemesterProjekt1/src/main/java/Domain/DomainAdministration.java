package Domain;

import Interfaces.IUtilityItem;
import java.util.HashMap;
import sp1.guisemesterprojekt1.App;

public class DomainAdministration {

    //Setting the important non-changing elements
    Inventory playerInventory;
    Inventory truckInventory;
    Evaluation eval;
    Time time;

    //Setting the different items
    MedicineItem hivMed;
    UtilityItem condom;
    MedicineItem tbMed;
    UtilityItem faceMask;
    MedicineItem malMed;
    UtilityItem mosquitoSpray;
    UtilityItem syringeC;
    UtilityItem syringeD;

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

    //win/loss
    boolean hasWon;

    private HashMap<String, Room> roomMap;

    //Initializers
    public void makeItems() {
        //Creating the HIV Items
        hivMed = new MedicineItem("HIV Medication", "Appears to be a pinkish liquid", 1, "HIV");
        condom = new UtilityItem("Condom", "Condoms prevent the spread of sexually transmitted diseases", 1, 5, "HIV");

        //Creating the Malaria Items
        malMed = new MedicineItem("Malaria Medication", "Appears to be a greenish liquid", 1, "Malaria");
        mosquitoSpray = new UtilityItem("Mosquito Spray", "Spray that keeps the mosquitos away during the night", 1, 5, "Malaria");

        //Creating the TB Items
        tbMed = new MedicineItem("Tuberculosis Medication", "Appears to be a blueish liquid", 1, "Tuberculosis");
        faceMask = new UtilityItem("Mask", "Mask to cover mouth and nose, keeping TB Patients from spreading the infection", 1, 5, "Tuberculosis");

        //Create syringes
        syringeC = new UtilityItem("Clean Syringe", "This syringe is clean.", 1, 0, "None");
        syringeD = new UtilityItem("Dirty Syringe", "This syringe is not clean.", 1, 0, "None");

        spawn.addItem(condom.getName(), condom);
                
                
        medHQ.addItem(hivMed.getName(), hivMed);
        medHQ.addItem(condom.getName(), condom);
        medHQ.addItem(malMed.getName(), malMed);
        medHQ.addItem(tbMed.getName(), tbMed);
        medHQ.addItem(faceMask.getName(), faceMask);
        medHQ.addItem(mosquitoSpray.getName(), mosquitoSpray);
        medHQ.addItem(syringeC.getName(), syringeC);
        medHQ.addItem(syringeD.getName(), syringeD);
    }

    public void makeRooms() {
        spawn = new Room("You're in WHO Facilities in Geneva.");
        medHQ = new Room("You're in the WHO Outpost in Mozambique.");
        village = new Room("You're in a village in the eastern Mozambique.");
        hut1 = new Room("You're in one of the village's few huts.");
        hut2 = new Room("You're in one of the village's few huts.");
        hut3 = new Room("You're in one of the village's few huts.");
        tent = new Room("You're in the WHO storage tent that you set up.");
        roomMap = new HashMap<>();
        roomMap.put("spawn", spawn);
        roomMap.put("medHQ", medHQ);
        roomMap.put("village", village);
        roomMap.put("hut1", hut1);
        roomMap.put("hut2", hut2);
        roomMap.put("hut3", hut3);
        roomMap.put("tent", tent);

    }

    public void makeNPCS() {
        //Creating the NPCs (Female)
        Maria = new NPC("Maria Hoffmann");

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
        hut2.addNPC("Riyadh", Riyadh);
        hut2.addNPC("Gani", Gani);
        hut2.addNPC("Abubakar", Abubakar);

        hut3.addNPC("Kiri", Kiri);
        hut3.addNPC("Ikbal", Ikbal);
        hut3.addNPC("Jojo", Jojo);
        hut3.addNPC("Brayton", Brayton);
        hut3.addNPC("Kelven", Kelven);
        hut3.addNPC("Faizal", Faizal);

    }

    public void makeInventories() {
        playerInventory = new Inventory(8);
        truckInventory = new Inventory(40); //size can change
    }

    //Getters
    public UtilityItem getDirtySyringe() {
        return syringeD;
    }

    public boolean getWinCondition() {
        return this.hasWon;
    }

    public Evaluation getEvaluation() {
        return eval;
    }

    public Inventory getInventory() {
        return playerInventory;
    }

    public Inventory getTruckInventory() {
        return truckInventory;
    }

    public Room getRoom() {
        return currentRoom;
    }

    public Time getTime() {
        return time;
    }

    public void setRoom(Room room) {
        currentRoom = room;

        if (eval.getPoints() >= 380) {
            this.hasWon = true;
        } else {
            this.hasWon = false;
        }
        Time.timeCounter -= Time.CHANGEROOMTIMECOST;
    }

    public HashMap<String, Room> getRoomMap() {
        return roomMap;
    }

    //Setup
    public void setup() {
        currentRoom = spawn;
        makeRooms();
        makeItems();
        makeNPCS();
        eval = new Evaluation();
        makeInventories();
        time = new Time();
        hasWon = false;
    }
}
