package Domain;

import java.util.ArrayList;

public class Interaction {

    //Attributes
    private String option;
    private String message;
    private ArrayList<Interaction> children;

    //Constructors
    public Interaction() {
    }

    public Interaction(String option, String message) {
        this.option = option;
        this.message = message;
        this.children = new ArrayList<>();
    }

    //Methods
    /**
     * 
     * @param child adds child to the current object.
     */
    public void addChild(Interaction child) {
        this.children.add(child);
    }

    /**
     * Removes all children of the node.
     */
    public void deleteChildren() {
        this.children.clear();
    }
    
    /**
     * 
     * @return the option (which is what the player makes disicions based on).
     */
    public String getOption() {
        return this.option;
    }
    
    /**
     * 
     * @return all children for this object of the class.
     */
    public ArrayList<Interaction> getChildren() {
        return this.children;
    }

    /**
     * Prints the message of the current node.
     */
    public void printMessage() {
        System.out.println(this.message);
    }
    
    /**
     * Prints the options of the children of the current node.
     */
    public void printOptions() {
        if (children == null) {
            System.out.println("No children found");
        } else {
            for (int i = 0; i < this.children.size(); i++) {
                System.out.println(i + ") " + this.children.get(i).getOption());
            }
        }
    }

    /**
     * 
     * @return the message of the current node.
     */
    public String getMessage() {
        return this.message;
    }
    
    /**
     * 
     * @param index in an integer used to decide which item in the ArrayList of children you wish to get.
     * @return the child on the position index in ArrayList children.
     */
    public Interaction getChild(int index) {
        return this.children.get(index);
    }
}
