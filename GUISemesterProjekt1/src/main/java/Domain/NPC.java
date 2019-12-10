package Domain;

import Interfaces.IInteraction;
import Interfaces.IMedicineItem;
import Interfaces.INPC;
import Interfaces.IUtilityItem;
import java.util.Random;
import javafx.scene.image.Image;

public class NPC implements INPC{

    //Attributes
    private String name;
    private String illnessName;
    private boolean alive;
    private boolean treatAttempted;
    private Interaction interaction;
    private int points = 50;
    private int input;
    private Image npcImage;

    //Constructors
    /**
     *
     * @param name of the NPC.
     * @param illnessName of the NPC's disease
     */
    public NPC(String name, String illnessName) {
        this.name = name;
        this.illnessName = illnessName;
        this.alive = true;
        this.treatAttempted = false;
    }
    
    public NPC(String name) {
        this.name = name;
        this.alive = true;
        this.treatAttempted = false;
    }

    //Methods 
    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
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

    @Override
    public boolean isAlive() {
        return this.alive;
    }

    @Override
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setPoints(int points) {
        this.points = points;
    }
   
    @Override
    public int getPoints() {
        if (this.treatAttempted == true && this.alive == true) {
            return this.points;
        } else {
            return 0;
        }    
    }
    
    @Override
    public boolean isTreatAttempted() {
        return this.treatAttempted;
    }
    
    @Override
    public void kill(){
        this.setAlive(false);
    }

    public void setTreatAttempted(boolean treatAttempted) {
        this.treatAttempted = treatAttempted;
    }

    @Override
    public IInteraction getInteraction() {
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
    /*
    public void interact(Inventory playerInventory) {
        Scanner sc = new Scanner(System.in); //Make scanner
        Interaction interactionPointer = this.interaction; //Make interaction object to juggle through the conversation
        
        //Handles normal conversation without edgecases or treatment / giving of items.
        while ((!interactionPointer.getChildren().isEmpty())) { //Loop breaks when node with no children is reached 
            try {
                interactionPointer.printMessage(); //Prints message of object
                interactionPointer.printOptions(); //Prints options of children of objectnumber
                
                
                input = sc.nextInt(); //Take user input to decide which option to go for
                
                interactionPointer = (Interaction) interactionPointer.getChild(input); //Go to child which contained the option selected

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
        } 
        else if ("Give item".equals(interactionPointer.getOption())) {
            give(interactionPointer, playerInventory);
        }
        //Checks if you look for more symptoms. this is to subtract time if you do
        else if ("Look for more symptoms".equals(interactionPointer.getOption())) {
            Time.timeCounter -= Time.SYMPTOMSTIMECOST;
        } 
        else {
            System.out.println(interactionPointer.getMessage());
        }
    }
    */
    /**
     *
     * @param interactionPointer is the current node in the interaction (the
     * node that says treat)
     * @param playerInventory is the inventory of the player needed to check
     * which items are available. This method dynamically adds options for
     * treatment based on items in the inventory.
     */
    /*
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
                        interactionPointer = (Interaction) interactionPointer.getChild(input); //Set pointer to selected treatment  

                        //We give hashMap inventory name of the item.
                        //It gives us the object of the item.
                        var tempItem = playerInventory.getItemList().get(interactionPointer.getOption());

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
    */
    
    /**
     *
     * @param interactionPointer is the current node in the interaction (the
     * node that says treat)
     * @param playerInventory is the inventory of the player needed to check
     * which items are available. This method dynamically adds options for
     * treatment based on items in the inventory. - does basicly the same as
     * treat, just with UtilityItems instead og MedicineItems.
     */
    /*
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
                        interactionPointer = (Interaction) interactionPointer.getChild(input); //Set pointer to selected treatment  

                        //We give hashMap inventory name of the item.
                        //It gives us the object of the item.
                        var tempItem = playerInventory.getItemList().get(interactionPointer.getOption());

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
    */
    /**
     *
     * @param medicineItem is the item needed to check if the correct treatment
     * for the NPC. this method will decide what happens based on the outcome of
     * the treatment.
     */
    
    
    @Override
    public boolean correctTreatment(IMedicineItem medicineItem, boolean usedCleanSyringe) {
        Random random = new Random();
        this.treatAttempted = true;
        if (medicineItem.getCures().equals(this.illnessName)) {
            //If dirty syrringe was used
            if (!usedCleanSyringe) {
                int randomNumber = random.nextInt(100); //Random number between 0-100.
                //Kill the patient.
                if (randomNumber < 50)
                    this.alive = false;
            }
            
        } else {
            this.alive = false;
        }

        Evaluation.addPoints(this.getPoints());
        return this.alive;
    }
    
    /**
     * 
     * @param utilityItem is the Item needed to check if the correct Item for the NPC with a given illness.
     * this method decides wether it's a good item to give or not.
     */

    @Override
    public void correctItem(IUtilityItem utilityItem) {
        if(utilityItem.getHelps().equalsIgnoreCase(this.illnessName)){
            Evaluation.addPoints(utilityItem.getPoints());
        } 
    }

}
