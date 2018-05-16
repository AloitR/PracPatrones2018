package ApartatB;

<<<<<<< HEAD:src/Machine.java
/**
 *
 * @author srblimp
 */
=======
>>>>>>> 6f3cb291d21692cb331360ab7e922fa5e7f82b27:Apartado B/Machine.java
public class Machine extends MachineComponent 
{
    
    @Override
    public boolean isBroken() 
    { 
        return broken; 
    }
    
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