package semesterprojekt1;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    private int inventorySize;
    private int spaceUsed;
    private HashMap<String, Item> itemList;

    /**
     * Constructor to create inventory of limited size
     *
     * @param inventorySize determines the size of the inventory
     */
    public Inventory(int inventorySize) {
        this.itemList = new HashMap<>();
        this.inventorySize = inventorySize;
    }

    /**
     * Constructor of unlimited size to create an inventory for rooms
     */
    public Inventory() { //perhaps add spaceUsed to make it possible to see how many items are actually in this room-inventory?
        this.itemList = new HashMap<>();
        this.inventorySize = 9999;
    }

    /**
     *
     * @param name
     * @param item added to the itemList
     */
    public void addItem(String name, Item item) {
        if (spaceUsed + item.getItemSize() < inventorySize) {
            itemList.put(name, item);
            spaceUsed += item.getItemSize();
            //System.out.println(item.getName() + " was successfully added to inventory.");
        } else {
            System.out.println("Your inventory is too full to contain this! Please remove some items to make room for others.");
        }
    }

    /**
     *
     * @param item removed from the itemList
     */
    public void removeItem(String name) {
        spaceUsed -= itemList.get(name).getItemSize();
        itemList.remove(name);

        //System.out.println(name + " was successfully removed from inventory.");
    }

    /**
     * method to print the itemList
     */
    public void printItemList() {
        if (itemList.isEmpty()) {
            System.out.println("Your inventory is empty");
        } else {
            System.out.println(itemList.keySet());
        }
    }

    public int getInventorySize() {
        return inventorySize;
    }

    public void setInventorySize(int newInventorySize) {
        this.inventorySize = newInventorySize;
    }

    public int getSpaceUsed() {
        return spaceUsed;
    }

    public void setSpaceUsed(int newSpaceUsed) {
        this.spaceUsed = newSpaceUsed;
    }

    public HashMap<String, Item> getItemList() {
        return this.itemList;
    }
}
