package semesterprojekt1;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Room 
{
    private String description;
    private HashMap<String, NPC> npcs;
    private HashMap<String, Room> exits;
    private Inventory inventory;
            
    public Room(String description) 
    {
        this.description = description;
        this.exits = new HashMap<String, Room>();
        this.npcs = new HashMap<String, NPC>();
        this.inventory = new Inventory();
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public void addNPC(String name, NPC npc) {
        npcs.put(name, npc);
    }
    
    public void addItem(String name, Item item) {
        inventory.addItem(name, item);
    }
    
    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        String returnString = "You are " + description + ".\n" + getExitString();
        
        if (!npcs.isEmpty()) {
            returnString += ".\n";
            returnString += getNPCString();
        }
                
        if (!inventory.getItemList().isEmpty()) {
            returnString += ".\n";
            returnString += getItemString();
        }

        return returnString;
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    private String getNPCString() {
        String returnString = "People: ";

        for (String key : npcs.keySet()) {
            returnString += (key + ", ");
        }
        
        return returnString;
    }
    
    private String getItemString() {
        String returnString = "Items: ";
          
        for (String key : inventory.getItemList().keySet()) {
            returnString += (key + ", ");
        }
        
        return returnString;
    }
    

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    public NPC getNPC(String name) {
        return npcs.get(name);
    }
    
    public Item getItem(String name) {
        Item returnItem = inventory.getItemList().get(name);
        inventory.removeItem(name);
        return returnItem;
    }
}

