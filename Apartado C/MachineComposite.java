package ApartatC;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD:src/MachineComposite.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author srblimp
 */
public class MachineComposite extends MachineComponent 
=======
public class MachineComposite extends MachineComponent implements Observer 
>>>>>>> 6f3cb291d21692cb331360ab7e922fa5e7f82b27:Apartado C/MachineComposite.java
{
    private List<MachineComponent> components = new ArrayList<>();
    
    public void addComponent(MachineComponent mc) 
    {
        components.add(mc);
    }
    
<<<<<<< HEAD:src/MachineComposite.java
    @Override
    public boolean isBroken() 
    {
        if (broken) 
        { 
            return true; 
        }
        
        for (MachineComponent mc: components) 
        {
            if (mc.isBroken()) { return true; }
=======
    public void setBroken() 
    {
        if (!isBroken()) 
        {
            super.setBroken();
            setChanged();
            notifyObservers();
        }
    }
    
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
        // Añadimos el component a la lista de componentes rotos
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
>>>>>>> 6f3cb291d21692cb331360ab7e922fa5e7f82b27:Apartado C/MachineComposite.java
        }
        
        return false;
    }
}