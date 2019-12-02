/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp1.domain;

import Interfaces.ITime;

public class Time implements ITime{

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
    
}
