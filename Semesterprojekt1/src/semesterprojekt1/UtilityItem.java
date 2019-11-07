package semesterprojekt1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UtilityItem extends Item {
    private Interaction interaction;
    private int points;
    private int input;
    
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
    
    public UtilityItem(String name, String description, int itemSize, int points, Interaction interaction) {
        super(name, description, itemSize);
        this.points = points;
        this.interaction = interaction;
    }
    
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    /**
     * method that handles interaction with an item ex. the Handbook
     * works like the interaction with NPC's but without added edge-cases like treatments.
     */
    public void interactItem() {
        Scanner sc = new Scanner(System.in); //Make scanner
        Interaction interactionPointer = this.interaction; //Make interaction object to juggle through the conversation
        
        //Loop with interaction through pages
        try {
            while ((!interactionPointer.getChildren().isEmpty())) { //Loop breaks when node with no children is reached 
                try {
                    interactionPointer.printMessage(); //Prints message of object
                    interactionPointer.printOptions(); //Prints options of children of objectnumber
                    input = sc.nextInt(); //Take user input to decide which option to go for
                    
                    //Checks if input size is single digit
                    if (String.valueOf(input).length() == 1) {
                        interactionPointer = interactionPointer.getChild(input); //Go to child which contained the option selected
                    }
                } 
                catch (IndexOutOfBoundsException | InputMismatchException e) { //Handles exceptions for invalid inputs
                    System.out.println("Invalid input.");
                    sc.nextLine(); //Skips the invalid input to clear the scanner.
                }
            }
            System.out.println(interactionPointer.getMessage()); //Prints message on last "page".
        }
        catch(NullPointerException e) {
            System.out.println("Item has no interaction associated with it.");
        }
    }
}
