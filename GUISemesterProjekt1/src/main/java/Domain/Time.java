package Domain;

import Interfaces.ITime;

public class Time implements ITime {

    public static int startTime = 50;
    public static int timeCounter = startTime + 1;

    //Constants
    public static final int CHANGEROOMTIMECOST = 1;
    public static final int TREATTIMECOST = 1;
    public static final int GIVETIMECOST = 1;
    public static final int SYMPTOMSTIMECOST = 1;

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
