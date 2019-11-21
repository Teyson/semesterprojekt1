/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;

/**
 *
 * @author aalbaek-nt
 */
public interface DomainInterface {
    public int getTotalPoints();   //Returns the points that the player currently has. This should be shown in the points label
    public ArrayList<String> getPlayerInventory(); //returns an ArrayList of Strings that gives the names of the items in the inventory. These should be shown graphically based on the name.
    public int getRemainingTime(); //Returns the time that is remaining before game over. Should be shown graphically in the time Progress bar
    public String getCurrentRoomName();    //Retursn the name of the current room
    public void setRoom(String roomName);  //Gives the domain the name of the room that is switched to.
    public ArrayList<String> getNPCsInRoom(String roomName);   //Returns an ArrayList of strings representing the names of the npc's in the room
    public ArrayList<String> getItemsInRoom(String roomName);  //Returns an ArrayList of string representing the names of the items in the room
    public String getInteractionMessage(String npcName);   //Returns the message of the interaction on the NPC with the name npcName.
    public ArrayList<String> getInteractionOptions(String interactionMessage); //Returns an ArrayList of strings with the interactionOptions
    public ArrayList<String> getExits(String roomName);    //Returns an arrayList of strings representing the Exits
    public void trash(String itemName);    //removes the item from the inventory
    public void give(String utilityItemName, String npcName);  //gives the utilityItem to the NPC
    public boolean treat(String medicineItemName, String npcName);
    
}
