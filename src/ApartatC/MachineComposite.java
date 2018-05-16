package ApartatC;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MachineComposite extends MachineComponent implements Observer 
{
    private List<MachineComponent> components = new ArrayList<>();
    // BrokenComponents list to save if we have any components broken
    private List<MachineComponent> brokenComponents = new ArrayList<>();
    
    public void addComponent(MachineComponent mc) 
    {
        components.add(mc);
        mc.addObserver(this);
    }
    
    @Override
    public void setBroken() 
    {
        if (!isBroken()) 
        {
            super.setBroken();
            setChanged();
            notifyObservers();
        }
    }
    
    @Override
    public void repair() 
    {
        if (isBroken()) 
        {
            for (MachineComponent mc: brokenComponents) 
            {
                mc.repair();
            }
            super.repair();
            setChanged();
            notifyObservers();
        }
    }
    
    @Override
    public boolean isBroken() 
    {
        // Update list of broken components
        updateSubComponentsBroken();
        return broken && brokenComponents.size() > 0;
    }

    @Override
    public void update(Observable o, Object arg) 
    {
        MachineComponent mc = (MachineComponent) o;
        if (mc.isBroken()) 
        {
            setBrokenSubComponent(mc);
        } 
        else 
        {
            repairBrokenSubComponent(mc);
        }
    }
    
    /**
     * Update list of brokenComponents to be up to date of the 
     * broken components
     */
    private void updateSubComponentsBroken() 
    {
        for (MachineComponent mc: components) 
        {
            if (mc.isBroken()) 
            {
                brokenComponents.add(mc);
            }
        }
    }
    
    /**
     * Set broken the subComponent passed by parameter and check
     * if the component is not broken to notify the observers
     * @param mc 
     */
    private void setBrokenSubComponent(MachineComponent mc) 
    {
        // Add the component to the broken components list
        brokenComponents.add(mc);
        // Check if the component is broken, if component is not broken notify
        // the observers
        if (!mc.isBroken()) 
        {
            setChanged();
            notifyObservers();
        }
    }
    
    /**
     * Repair the subComponent passed by parameter and check
     * if the component is not broken to notify the observers
     * @param mc 
     */
    private void repairBrokenSubComponent(MachineComponent mc) 
    {
        // Remove component from the list of brokenComponents
        brokenComponents.remove(mc);
        // Check if the component is broken, if component is not broken notify
        // the observers
        if (!mc.isBroken()) 
        {
            setChanged();
            notifyObservers();
        }
    }
}