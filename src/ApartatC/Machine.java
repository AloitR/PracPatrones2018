package ApartatC;

public class Machine extends MachineComponent 
{
    
    @Override
    public boolean isBroken() 
    { 
        return broken; 
    }
    
    @Override
    public void setBroken() 
    {        
        if (!isBroken()) 
        {
            super.setBroken();
            // We have to mark as changed the broken value
            setChanged();
            // Notify all the components that are observing
            notifyObservers();
        }
    }
    
    @Override
    public void repair() 
    {
        if (isBroken()) 
        {
            super.repair();
            // We have to mark as changed the broken value
            setChanged();
            // Notify all the components that are observing
            notifyObservers();
        }
    }
}