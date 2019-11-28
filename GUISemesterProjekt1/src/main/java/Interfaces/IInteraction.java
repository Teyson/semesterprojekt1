package Interfaces;

import java.util.ArrayList;

public interface IInteraction {
    public String getOption();
    public String getMessage();
    public ArrayList<IInteraction> getChildren();
    public IInteraction getChild(int index);
}
