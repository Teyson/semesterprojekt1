package Domain;

import Interfaces.ITime;

public class Time implements ITime {

    public static int startTime = 50;
    public static int timeCounter = startTime + 2;

    //Constants
    public static final int CHANGEROOMTIMECOST = 2;
    public static final int TREATTIMECOST = 3;
    public static final int GIVETIMECOST = 1;
    public static final int SYMPTOMSTIMECOST = 1;

    @Override
    public int getTime() {
        return timeCounter;
    }

    @Override
    /**
     * Used for the timebar. Calculates the percentage of time that has passed.
     */
    public double getPercentTime() {
        double currentTimePct = (double)this.timeCounter / (double)this.startTime;
        return currentTimePct;
    }

}
