package semesterprojekt1;

public class NPC {
    //Attributes
    private String name;
    private String illnessName;
    private boolean alive;
    private boolean treatAttempted;
    private final int points = 50;
    private Interaction interaction;
    
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
    
    /*
    public boolean treat(MedicineItem medicine) {
        this.treatAttempted = true;
        if (this.illnessName.equals(medicine.getName())) { //Correct treatment
            Evaluation.addPoints(this.points);
            this.illnessName = null;
        }
        else 
            this.alive = false;   
    }
    */

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIllnessName() {
        if (this.illnessName == null)
            return "none";
        else
            return this.illnessName;
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
}
