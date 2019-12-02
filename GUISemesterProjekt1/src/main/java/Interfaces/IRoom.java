package Interfaces;

import java.util.HashMap;

public interface IRoom {
    public HashMap<String, IRoom> getExits();
    public HashMap<String, INPC> getNPCS();
    public IInventory getItems();
}
