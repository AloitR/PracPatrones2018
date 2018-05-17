package ApartatB;

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
            notifyChanges();
        }
    }
    
    @Override
    public void repair() 
    {
        if (isBroken()) 
        {
            super.repair();
            notifyChanges();
        }
    }
}