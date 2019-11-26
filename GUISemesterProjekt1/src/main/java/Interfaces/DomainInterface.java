/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Domain.Interaction;
import Domain.Inventory;
import Domain.Item;
import Domain.NPC;
import Domain.Room;
import java.util.ArrayList;
import java.util.HashMap;


public interface DomainInterface {
    public int getTotalPoints();   //Returns the points that the player currently has. This should be shown in the points label
    //public Inventory getPlayerInventory(); //returns an inventory. These should be shown graphically based on the name.
    public int getRemainingTime(); //Returns the time that is remaining before game over. Should be shown graphically in the time Progress bar
    //public Room getCurrentRoom();    //Returns the the current room
    //public void setRoom(Room room);  //Changes the current room
    public HashMap<String, NPC> getNPCsInRoom(Room room);   //Returns the npc's in the room
    public Inventory getItemsInRoom(Room room);  //Returns the items in the room
    public Interaction getInteraction(NPC npc); // Get interaction node that is linked to NPC object.
    public void interact(NPC npc, Inventory playerInventory); // Start interaction
    public String getMessage(Interaction interaction); //Get message on an interaction node
    public ArrayList<Interaction> getChildren(Interaction interaction); //Get children of an interaction node
    public String getOption(Interaction interaction); // Get option message on interaction node  
    public HashMap<String, Room> getExits(Room room);    //Returns Exits of a room
    public void trash(Inventory playerInventory, Item item);    //removes the item from the inventory
    
    
    //Not sure if we need these or their functionality is covered by .interact();
    //public void give();  
    //public boolean treat(); 
    
}
