package Domain;

import java.util.ArrayList;
import java.util.HashMap;


public class DomainAdministration implements Interfaces.DomainInterface{

    @Override
    public int getTotalPoints() {
        return Evaluation.getTotalPoints();
    }

    /* playerInventory is currently stored in the class Game which is completely commented out.
    @Override
    public Inventory getPlayerInventory() {
        return Game.getInventory();
    }
    */

    @Override
    public int getRemainingTime() {
        return Time.getTime();
    }

    /* currentRoom is currenly stored in the class Game which is completely commented out.
    @Override
    public Room getCurrentRoom() {
        return Game.getRoom();
    }
    */

    /* goRoom is currently in the class Game which is completely commented out.
    @Override
    public void setRoom(Room room) {
        Game.goRoom(room);
    }
    */

    @Override
    public HashMap<String, NPC> getNPCsInRoom(Room room) {
        return room.getNPCS();
    }

    @Override
    public Inventory getItemsInRoom(Room room) {
        return room.getItems();
    }

    @Override
    public Interaction getInteraction(NPC npc) {
        return npc.getInteraction();
    }

    @Override
    public void interact(NPC npc, Inventory playerInventory) {
        npc.interact(playerInventory);
    }

    @Override
    public String getMessage(Interaction interaction) {
        return interaction.getMessage();
    }

    @Override
    public ArrayList<Interaction> getChildren(Interaction interaction) {
        return interaction.getChildren();
    }

    @Override
    public String getOption(Interaction interaction) {
        return interaction.getOption();
    }

    @Override
    public HashMap<String, Room> getExits(Room room) {
        return room.getExits();
    }

    @Override
    public void trash(Inventory playerInventory, Item item) {
        playerInventory.removeItem(item.getName());
    }
}
    