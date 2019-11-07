package semesterprojekt1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NPC {

    //Attributes
    private String name;
    private String illnessName;
    private boolean alive;
    private boolean treatAttempted;
    private static int points = 50;
    private Interaction interaction;
    private int input;

    //Constructors
    /**
     *
     * @param name of the NPC.
     * @param illnessName that the NPC holds.
     * @param interaction - root of the interaction the NPC holds.
     */
    public NPC(String name, String illnessName, Interaction interaction) {
        this(name, interaction);
        this.illnessName = illnessName;
    }

    /**
     *
     * @param name of the NPC.
     * @param interaction - root of interaction the NPC holds.
     */
    public NPC(String name, Interaction interaction) {
        this.name = name;
        this.illnessName = null;
        this.alive = true;
        this.treatAttempted = false;
        this.interaction = interaction;
    }

    //Methods    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIllnessName() {
        if (this.illnessName == null) {
            return "none";
        } else {
            return this.illnessName;
        }
    }

    public void setIllnessName(String illnessName) {
        this.illnessName = illnessName;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getPoints() {
        return this.points;
    }

    public boolean isTreatAttempted() {
        return this.treatAttempted;
    }

    public void setTreatAttempted(boolean treatAttempted) {
        this.treatAttempted = treatAttempted;
    }

    public Interaction getInteraction() {
        return this.interaction;
    }

    public void setInteraction(Interaction interaction) {
        this.interaction = interaction;
    }

    /**
     *
     * @param playerInventory takes inventory of the player to check for relevant items in an interaction. 
     * This method handles a normal conversation and will dynamically add functionality for special cases like treatment.
     */
    public void interact(Inventory playerInventory) {
        Scanner sc = new Scanner(System.in); //Make scanner
        Interaction interactionPointer = this.interaction; //Make interaction object to juggle through the conversation

        //Handles normal conversation without edgecases or treatment / giving of items.
        while ((!interactionPointer.getChildren().isEmpty())) { //Loop breaks when node with no children is reached 
            try {
                interactionPointer.printMessage(); //Prints message of object
                interactionPointer.printOptions(); //Prints options of children of objectnumber
                
                input = sc.nextInt(); //Take user input to decide which option to go for

                //Checks if input size is single digit
                if (String.valueOf(input).length() == 1) {
                    interactionPointer = interactionPointer.getChild(input); //Go to child which contained the option selected
                }
                
                //If the current note's option is to "Treat" meaning to treat the patient.
                if ("Treat".equals(interactionPointer.getOption())) {
                    break;
                }
                
            } catch (IndexOutOfBoundsException | InputMismatchException e) { //Handles exceptions for invalid inputs
                System.out.println("Invalid input.");
                sc.nextLine(); //Skips the invalid input to clear the scanner.
            }
        }

        //If the current notes option was to "Treat" meaning to treat the patient.
        if ("Treat".equals(interactionPointer.getOption())) {
            treat(interactionPointer, playerInventory);
        }
        else {       
            System.out.println(interactionPointer.getMessage());
        }
    }

    /**
     *
     * @param interactionPointer is the current node in the interaction (the node that says treat)
     * @param playerInventory is the inventory of the player needed to check which items are available.
     * This method dynamically adds options for treatment based on items in the inventory.
     */
    public void treat(Interaction interactionPointer, Inventory playerInventory) {
        Scanner sc = new Scanner(System.in);
        
        for (String key : playerInventory.getItemList().keySet()) { //Iterate through players inventory.
            if (playerInventory.getItemList().get(key) instanceof MedicineItem) { //Find all MedicineItems.
                interactionPointer.addChild(new Interaction(key, " ")); //Add them as options for treatment.
            }
        }

        //If you have no MedicineItems in your inventory.
        if (interactionPointer.getChildren().isEmpty()) {
            System.out.println("You have no medicine in your inventory.");
        } 
        //If you do have MedicineItems in your inventory
        else {
            //Add the posibility to not treat the patient.
            interactionPointer.addChild(new Interaction("Stop interaction", ""));
            while (true) {
                try {
                    interactionPointer.printMessage(); //Prints message of object
                    interactionPointer.printOptions(); //Prints options of children of object

                    input = sc.nextInt(); //Take user input to decide which option to go for

                    //Checks if input is to leave conversation
                    if ("Stop interaction".equals(interactionPointer.getChild(input).getOption())) { 
                        System.out.println("You left the patient.");
                        interactionPointer.deleteChildren(); //Removes children (options) when leaving conversation
                        break; //Breaks loop
                    } 
                    else { //Treats with the chosen item.
                        interactionPointer = interactionPointer.getChild(input); //Set pointer to selected treatment  

                        //We give hashMap inventory name of the item.
                        //It gives us the object of the item.
                        Item tempItem = playerInventory.getItemList().get(interactionPointer.getOption());

                        playerInventory.removeItem(tempItem.getName()); //Remove item from players inventory.
                        this.treatAttempted = true; //NPC has now been attempted treated
                        
                        correctTreatment((MedicineItem) tempItem); //Checks if correct medication

                        break; //Breaks loop
                    }
                } catch (IndexOutOfBoundsException | InputMismatchException e) {
                    System.out.println("That is not an option");
                    sc.nextLine();
                }
            }
        }
    }
    
    /**
     * 
     * @param medicineItem is the item needed to check if the correct treatment for the NPC.
     * this method will decide what happens based on the outcome of the treatment.
     */
    public void correctTreatment(MedicineItem medicineItem) {
        if (medicineItem.getCures().equals(this.illnessName)) {
            this.illnessName = null;
            System.out.println("The patient has been cured!");
        } else {
            this.alive = false;
            System.out.println("The patient died!!!! :(");
        }
    }
}
