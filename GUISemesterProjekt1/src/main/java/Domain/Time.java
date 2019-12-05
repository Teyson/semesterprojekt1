package Domain;

import Interfaces.ITime;

public class Time implements ITime {

    public static int startTime = 50;
    public static int timeCounter = 50;

    //Constants
    public static final int CHANGEROOMTIMECOST = 1;
    public static final int TREATTIMECOST = 1;
    public static final int GIVETIMECOST = 1;
    public static final int SYMPTOMSTIMECOST = 1;

    public static boolean timeHasRunOut() {
        if (timeCounter <= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getTime() {
        return timeCounter;
    }

    @Override
    public double getPercentTime() {
        double currentTimePct = (double)this.timeCounter / (double)this.startTime;
        return currentTimePct;
    }

}
