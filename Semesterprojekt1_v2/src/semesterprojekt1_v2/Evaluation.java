package semesterprojekt1;

public class Evaluation {
    //Attributes
    private boolean milestoneMet;
    private final int milestone = 50;
    private static int totalPoints;
    
    //Constructors
    Evaluation() {
    }
    
    //Methods

    /**
     * 
     * @param points - adds points to the total amount of points that the player has obtained.
     */
    public void addPoints(int points) {
        totalPoints += points;
    }
    
    /**
     * 
     * @return - true if milestone is met (player performed well enough to continue the game). Otherwise returns false. 
     */
    private boolean milestoneMet() {
        if (totalPoints > milestone)
            return true;
        gameOver();
        return false;
    }
    
    /**
     * Ends the game.
     */
    private void gameOver() {
        System.out.println("Game Over");
        //STOP THE GAME
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
    
    
    
    

    
}
