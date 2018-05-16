
import java.util.ArrayList;
import java.util.List;

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
{
    private List<MachineComponent> components = new ArrayList<>();
    
    public void addComponent(MachineComponent mc) 
    {
        components.add(mc);
    }
    
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
        }
        
        return false;
    }
}
