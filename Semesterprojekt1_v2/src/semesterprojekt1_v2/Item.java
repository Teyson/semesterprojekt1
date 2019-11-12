/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt1;

/**
 *
 * @author aalbaek-nt
 */
public abstract class Item {

    private int itemSize;
    private String name;
    private String description;
    
    /**
     * Constructor for child classes to inherit from, in sub-item constructors via super(....)
     * @param name name on Item
     * @param description the description of the Item.
     * @param itemSize the the amount of spaces take in inventory.
     */

   public Item(String name, String description, int itemSize){
       this.name = name;
       this.description = description;
       this.itemSize = itemSize;
   }

    public int getItemSize() {
        return itemSize;
    }

    public void setItemSize(int itemSize) {
        this.itemSize = itemSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
