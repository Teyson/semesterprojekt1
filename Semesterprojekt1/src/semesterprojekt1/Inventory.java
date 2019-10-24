/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt1;

import java.util.ArrayList;

/**
 *
 * @author marku
 */
public class Inventory {
    ArrayList<Item> itemList = new ArrayList<>();
    int inventorySize;
    
    public Inventory(int inventorySize){
        this.inventorySize = inventorySize;
    }
    
}
