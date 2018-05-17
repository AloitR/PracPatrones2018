package ApartatB;

import java.util.Observable;

public abstract class MachineComponent extends Observable
{
    protected boolean broken = false;
    
    public void setBroken() { broken = true; }
    public void repair() { broken = false; }
    public abstract boolean isBroken();
    public void notifyChanges() {
        // We have to mark as changed the broken value
        setChanged();
        // Notify all the components that are observing
        notifyObservers();
    }
}