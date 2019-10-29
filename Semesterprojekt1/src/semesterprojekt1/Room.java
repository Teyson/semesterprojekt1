package semesterprojekt1;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class Room {

    private String description;
    private HashMap<String, Room> exits;
    private HashMap<String, NPC> NPCs;
    private Inventory items;
    private Inventory truckInventory;

    /**
     *  contructor to room with the truck inside
     * @param description Description of the room
     * @param truckSize Size of the trucks inventory
     */
    public Room(String description, int truckSize) {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.items = new Inventory();
        //this.truckInventory = new Inventory(truckSize);
        // Will work in master
        this.NPCs = new HashMap<String, NPC>();
    }
/**
 * contructor to room without the truck inside.
 * @param description  Description of the room
 */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.items = new Inventory();
        this.NPCs = new HashMap<String, NPC>();
    }

    /*public void setNPC(NPC npc) {
        if (npc instanceof NPC) {
            this.NPCs.put(npc.getName(), npc);
        } else {
            System.out.println("Not an NPC");
        }

    }*/
    // will work in master

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getShortDescription() {
        return description;
    }

    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public HashMap<String, NPC> getNPCs() {
        return NPCs;
    }

    public Inventory getItems() {
        return items;
    }

    public Inventory getTruckInventory() {
        return truckInventory;
    }

}
