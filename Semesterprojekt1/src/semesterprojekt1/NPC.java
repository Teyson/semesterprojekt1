package semesterprojekt1;

public class NPC {
    //Attributes
    private String name;
    private String illnessName;
    private boolean alive;
    private int points;
    private boolean treatAttempted;
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
        this.points = 0;
        this.treatAttempted = false;
        this.interaction = interaction;
    }
    
    //Methods
    /**
     * 
     * @param points is the value wanted to be added to the total points.
     */
    public void addPoints(int points) {
        this.points += points;
    }
    
    /*
    public boolean treat(MedicineItem medicine) {
        this.treatAttempted = true;
        if (this.illnessName.equals(medicine.getName())) { //Correct treatment
            this.addPoints(10);
            this.illnessName = null;
        }
        else 
            this.alive = false;   
    }
    */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIllnessName() {
        return illnessName;
    }

    public void setIllnessName(String illnessName) {
        this.illnessName = illnessName;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isTreatAttempted() {
        return treatAttempted;
    }

    public void setTreatAttempted(boolean treatAttempted) {
        this.treatAttempted = treatAttempted;
    }
    
    public Interaction getInteraction() {
        return interaction;
    }

    public void setInteraction(Interaction interaction) {
        this.interaction = interaction;
    }
}
