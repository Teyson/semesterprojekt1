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
public class UtilityItem extends Item {
    
    private int points;
    
    /**
     * 
     * @param name name for item
     * @param description description for the item
     * @param itemSize the amount of space item take in inventory.
     * @param points the points the utilityItem can give from treatment. 
     */
    public UtilityItem(String name, String description, int itemSize, int points){
        super(name, description, itemSize);
        this.points = points;
    }
    
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
}
