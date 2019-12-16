package Domain;

import Interfaces.IItem;
import java.util.HashMap;
import Interfaces.IInventory;
import java.util.ArrayList;

public class Inventory implements IInventory{
    

    private int inventorySize;
    private int spaceUsed;
    private ArrayList<String> key;
    private ArrayList<Item> value;

    /**
     * Constructor to create inventory of limited size
     *
     * @param inventorySize determines the size of the inventory
     */
    public Inventory(int inventorySize) {
        this.key = new ArrayList<>();
        this.value = new ArrayList<>();
        this.inventorySize = inventorySize;
    }

    /**
     * Constructor of unlimited size to create an inventory for rooms
     */
    public Inventory() { //perhaps add spaceUsed to make it possible to see how many items are actually in this room-inventory?
        this.key = new ArrayList<>();
        this.value = new ArrayList<>();        
        this.inventorySize = 9999;
    }

    /**
     *
     * @param name
     * @param item added to the itemList
     */
    @Override
    public void addItem(String name, IItem item) {
        Item temp = (Item)item;
        if (spaceUsed + temp.getItemSize() <= inventorySize) {
            key.add(name);
            value.add(temp);
            spaceUsed += temp.getItemSize();
        } else {
            System.out.println("Your inventory is too full to contain this! Please remove some items to make room for others.");
        }
    }

    /**
     *
     * @param item removed from the itemList
     */
    @Override
    public void removeItem(String name) {
        int index = key.indexOf(name);
        spaceUsed -= value.get(index).getItemSize();
        key.remove(index);
        value.remove(index);
    }

    /**
     * method to print the itemList
     */
    public void printItemList() {
        if (key.isEmpty()) {
            System.out.println("Your inventory is empty");
        } else {
            System.out.println(key.toString());
        }
    }
    @Override
    public int getInventorySize() {
        return inventorySize;
    }

    public void setInventorySize(int newInventorySize) {
        this.inventorySize = newInventorySize;
    }
    @Override
    public int getSpaceUsed() {
        return spaceUsed;
    }

    public void setSpaceUsed(int newSpaceUsed) {
        this.spaceUsed = newSpaceUsed;
    }
    
    @Override
    public ArrayList<String> getKeys() {
        return this.key;
    }
    
    /**
     * The inventory is built like a hashMap but with arraylists.
     * @return the value part of the inventory.
     */
    @Override
    public ArrayList<IItem> getValues() {
        ArrayList<IItem> temp;
        temp = new ArrayList<IItem>(this.value); // Cast to IItem 
        return temp;
    }

    /**
     * Used to tell what amount of the inventory space is used
     * in the trucks inventory.
     */
    @Override
    public double calcPctUsed() {
        return (double)spaceUsed/(double)inventorySize;
    }
}
