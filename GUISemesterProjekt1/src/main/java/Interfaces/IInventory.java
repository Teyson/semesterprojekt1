package Interfaces;

import java.util.HashMap;

public interface IInventory {
    public void addItem(String name, IItem item);
    public void removeItem(String name);
    public HashMap<String, IItem> getItemList();
}
