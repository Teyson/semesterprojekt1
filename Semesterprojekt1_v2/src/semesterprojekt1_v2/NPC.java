package semesterprojekt1_v2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NPC {

    

    //Attributes
    private String name;
    private String illnessName;
    private boolean alive;
    private boolean treatAttempted;
    private int points = 50;
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

    public void setPoints(int points) {
        this.points = points;
    }
   

    public int getPoints() {
        if (this.treatAttempted == true && this.alive == true) {
            return this.points;
        } else {
            return 0;
        }
        
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
     * @param playerInventory takes inventory of the player to check for
     * relevant items in an interaction. This method handles a normal
     * conversation and will dynamically add functionality for special cases
     * like treatment.
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
                
                interactionPointer = interactionPointer.getChild(input); //Go to child which contained the option selected

                //If the current note's option is to "Treat" meaning to treat the patient.
                if ("Treat".equals(interactionPointer.getOption()) || "Give item".equals(interactionPointer.getOption())) {
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
        } else if ("Give item".equals(interactionPointer.getOption())) {
            give(interactionPointer, playerInventory);
        }//Checks if you look for more symptoms. this is to subtract time if you do
        else if ("Look for more symptoms".equals(interactionPointer.getOption())) {
            Time.timeCounter -= Time.SYMPTOMSTIMECOST;
        } else {
            System.out.println(interactionPointer.getMessage());
        }

    }

    /**
     *
     * @param interactionPointer is the current node in the interaction (the
     * node that says treat)
     * @param playerInventory is the inventory of the player needed to check
     * which items are available. This method dynamically adds options for
     * treatment based on items in the inventory.
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
            System.out.println("You have no Medicine in your inventory.");
        } //If you do have MedicineItems in your inventory
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
                    } else { //Treats with the chosen item.
                        interactionPointer = interactionPointer.getChild(input); //Set pointer to selected treatment  

                        //We give hashMap inventory name of the item.
                        //It gives us the object of the item.
                        Item tempItem = playerInventory.getItemList().get(interactionPointer.getOption());

                        playerInventory.removeItem(tempItem.getName()); //Remove item from players inventory.
                        this.treatAttempted = true; //NPC has now been attempted treated

                        Time.timeCounter -= Time.TREATTIMECOST; //Treating a patient costs time, this is subtracted from the total time here

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
     * @param interactionPointer is the current node in the interaction (the
     * node that says treat)
     * @param playerInventory is the inventory of the player needed to check
     * which items are available. This method dynamically adds options for
     * treatment based on items in the inventory. - does basicly the same as
     * treat, just with UtilityItems instead og MedicineItems.
     */
    public void give(Interaction interactionPointer, Inventory playerInventory) {
        Scanner sc = new Scanner(System.in);

        for (String key : playerInventory.getItemList().keySet()) { //Iterate through players inventory.
            if (playerInventory.getItemList().get(key) instanceof UtilityItem && !"Handbook".equals(key)) { //Find all UtilityItems.
                interactionPointer.addChild(new Interaction(key, " ")); //Add them as options to give the Item.
            }
        }

        //If you have no MedicineItems in your inventory.
        if (interactionPointer.getChildren().isEmpty()) {
            System.out.println("You have no utilities in your inventory.");
        } //If you do have MedicineItems in your inventory
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
                    } else { //Treats with the chosen item.
                        interactionPointer = interactionPointer.getChild(input); //Set pointer to selected treatment  

                        //We give hashMap inventory name of the item.
                        //It gives us the object of the item.
                        Item tempItem = playerInventory.getItemList().get(interactionPointer.getOption());

                        

                        Time.timeCounter -= Time.GIVETIMECOST; //Giving an NPC an item costs time, this line subtracts that time from the total time.

                        System.out.println("Thank you for the " + tempItem.getName());
                        
                        correctItem((UtilityItem)tempItem);
                        
                        playerInventory.removeItem(tempItem.getName()); //Remove item from players inventory.
                        

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
     * @param medicineItem is the item needed to check if the correct treatment
     * for the NPC. this method will decide what happens based on the outcome of
     * the treatment.
     */
    public void correctTreatment(MedicineItem medicineItem) {
        if (medicineItem.getCures().equals(this.illnessName)) {
            this.illnessName = null;
            System.out.println("The patient has been cured!");
            System.out.println("You got " + this.getPoints() + " points");
        } else {
            this.alive = false;
            System.out.println("The patient died!!!! :(");
        }
        Evaluation.addPoints(this.getPoints());
    }
    /**
     * 
     * @param utilityItem is the Item needed to check if the correct Item for the NPC with a given illness.
     * this method decides wether it's a good item to give or not.
     */
    public void correctItem(UtilityItem utilityItem){
        if(utilityItem.getHelps().equalsIgnoreCase(this.illnessName)){
            System.out.println("You helped the further condition of this patient. Good job!");
            Evaluation.addPoints(utilityItem.getPoints());
            System.out.println("You got: " + utilityItem.getPoints() + " points");
        } else {
            System.out.println("You gave a wrong item to this patient...");
        }
    }
}
