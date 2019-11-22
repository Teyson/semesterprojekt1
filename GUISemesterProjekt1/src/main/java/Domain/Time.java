/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author aalbaek-nt
 */
public class Time {

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
    
    public static int getTime() {
        return timeCounter;
    }
    
}
