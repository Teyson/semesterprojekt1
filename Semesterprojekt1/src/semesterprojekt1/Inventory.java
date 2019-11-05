package semesterprojekt1;

import java.util.ArrayList;

/**
 *
 * @author sarahmanon
 */

public class Inventory {

    private int inventorySize;
    private int spaceUsed; 
    private ArrayList<Item> itemList;

    /**
     * Constructor to create inventory of limited size
     *
     * @param inventorySize determines the size of the inventory
     */
    public Inventory(int inventorySize) {
        this.itemList = new ArrayList<>();
        this.inventorySize = inventorySize;
    }

    /**
     * Constructor of unlimited size to create an inventory for rooms
     */
    public Inventory() { //perhaps add spaceUsed to make it possible to see how many items are actually in this room-inventory?
        this.itemList = new ArrayList<>();
        this.inventorySize = 9999;
    }

    /**
     *
     * @param item added to the itemList
     */
    public void addItem(Item item) {
        if (spaceUsed + item.getItemSize() < inventorySize){
            itemList.add(item);
            spaceUsed += item.getItemSize();
            System.out.println(item + " was successfully added.");
        }
        else{
            System.out.println("Your inventory is too full to contain this! Please remove some items to make room for others.");
        }
    }
    
    /**
     *
     * @param item removed from the itemList
     */
    public void removeItem(Item item) {
        itemList.remove(item);
        spaceUsed -= item.getItemSize();
        System.out.println(item + " was successfully removed.");
    }

    /**
     * method to print the itemList
     */
    public void printItemList() {
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(itemList);
        }
    }
    
    public int getInventorySize(){
        return inventorySize;
    }
    
    public void setInventorySize(int newInventorySize){
        this.inventorySize = newInventorySize;
    }
    
    public int getSpaceUsed(){
        return spaceUsed;
    }
    
    public void setSpaceUsed(int newSpaceUsed){
        this.spaceUsed = newSpaceUsed;
    }
}
