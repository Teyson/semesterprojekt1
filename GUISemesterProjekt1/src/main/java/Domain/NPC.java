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
     * Method that is used to treat patients.
     * @param medicineItem is the medicine used to treat the NPC.
     * @param usedCleanSyringe is a boolean which tells weather a clean syringe was used or not.
     * @return a boolean with the state of the persons life.
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
     * This method gives points if the item is useful for the NPC according to which decease they have.
     */
    @Override
    public void correctItem(IUtilityItem utilityItem) {
        if(utilityItem.getHelps().equalsIgnoreCase(this.illnessName)){
            Evaluation.addPoints(utilityItem.getPoints());
        } 
    }

}
