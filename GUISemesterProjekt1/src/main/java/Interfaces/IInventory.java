package Interfaces;

import java.util.ArrayList;

public interface IInventory {
    public void addItem(String name, IItem item);
    public void removeItem(String name);
    //public HashMap<String, IItem> getItemList();
    public ArrayList<String> getKeys();
    public ArrayList<IItem> getValues();
    public double calcPctUsed();
    public int getSpaceUsed();
    public int getInventorySize();
}
