/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp1.domain;

/**
 *
 * @author aalbaek-nt
 */
public class MedicineItem extends Item {
    private String cures;
    
    
    public MedicineItem(String name, String description, int itemSize, String cures) {
        super(name, description, itemSize);
        this.cures = cures;
    }
    
    public String getCures() {
        return this.cures;
    }
    
}
