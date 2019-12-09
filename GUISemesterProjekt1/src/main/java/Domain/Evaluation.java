package Domain;

public class Evaluation implements Interfaces.IEvaluation {
    //Attributes
    private boolean milestoneMet;
    private final int milestone = 1500;
    private static int totalPoints;
    
    //Constructors
    public Evaluation() {
        this.totalPoints = 0;
    }
    
    //Methods

    /**
     * 
     * @param points - adds points to the total amount of points that the player has obtained.
     */
    public static void addPoints(int points) {
        totalPoints += points;
    }
    
    /**
     * Prints the score the player has obtained.
     */
    public void printScore() {
        System.out.println(totalPoints);
    }

    public boolean isMilestoneMet() {
        return milestoneMet;
    }

    public void setMilestoneMet(boolean milestoneMet) {
        this.milestoneMet = milestoneMet;
    }

    public static void setTotalPoints(int totalPoints) {
        Evaluation.totalPoints = totalPoints;
    }

    public static int getTotalPoints() {
        return totalPoints;
    }  
    
    @Override
    public int getPoints() {
        return getTotalPoints();
    }
    
    @Override
    public void addToPoints(int points) {
        addPoints(points);
    }
    
    
}
