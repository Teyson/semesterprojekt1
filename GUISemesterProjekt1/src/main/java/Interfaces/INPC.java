package Interfaces;

public interface INPC {
    public String getName();
    public String getIllnessName();
    public boolean isAlive();
    public int getPoints();
    public boolean isTreatAttempted();
    public IInteraction getInteraction();
    public void kill();
    public boolean correctTreatment(IMedicineItem medicineItem, boolean usedCleanSyringe);
    public void correctItem(IUtilityItem utilityItem);
    public void setAlive(boolean alive);
}
