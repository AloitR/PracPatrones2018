
import ApartatC.GraphicInterface;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AloitR
 */
public class GraphicInterfaceTest 
{
    private GraphicInterface graphicInterface;
        
    @Before
    public void setUp() throws Exception 
    {
        graphicInterface = new GraphicInterface();
    }

    @Test
    public void testkMachine_DefaultBroken() 
    {
        Machine machine = new Machine();
        assertFalse(machine.isBroken());
    }
    
    @Test
    public void testMachine_NotifyWhenAMachineBreaks()
    {
        Machine machine = new Machine();
        machine.addObserver(graphicInterface);
        
        assertFalse(graphicInterface.notify);
        machine.setBroken();
        assertTrue(graphicInterface.notify);
    }
    
    @Test
    public void testMachine_AlreadyBrokenMachineDoesntNotify()
    {
        Machine machine = new Machine();
        machine.setBroken();
        
        machine.addObserver(graphicInterface);
        machine.setBroken();
        assertFalse(graphicInterface.notify);
    }
    
    @Test
    public void testMachine_BrokenMachineGetsRepairedNotify()
    {
        Machine machine = new Machine();
        machine.setBroken();
        
        machine.addObserver(graphicInterface);
        machine.repair();
        assertTrue(graphicInterface.notify);
    }
    
    @Test
    public void testMachine_NotBrokenGetsRepairedDoesntNotify() 
    {
        Machine machine = new Machine();
        
        machine.addObserver(graphicInterface);
        machine.repair();
        assertFalse(graphicInterface.notify);
    }
    
    
    @Test
    public void testMachineComposite_CompositeBreakingNotifies() 
    {
        MachineComposite machineComposite = new MachineComposite();
        machineComposite.addObserver(graphicInterface);
                
        machineComposite.setBroken();
        assertTrue(graphicInterface.notify);
    }
    
    @Test
    public void testMachineComposite_CompositeGetsRepairedAndNotify() 
    {
        MachineComposite machineComposite = new MachineComposite();
        machineComposite.addObserver(graphicInterface);
        machineComposite.setBroken();
        
        machineComposite.repair();
        assertTrue(graphicInterface.notify);
    }
    
    @Test
    public void testMachineComposite_WorkingMachinesAreNotBroken() 
    {
        MachineComposite machineComposite = new MachineComposite();
        List<Machine> machines = Arrays.asList(new Machine(), new Machine());
       
        for(Machine machine : machines) 
        { 
            machineComposite.addComponent(machine); 
        }
   
        assertFalse(machineComposite.isBroken());
    }
    
    @Test
    public void testMachineComposite_BrokenMachine() 
    {
        MachineComposite machineComposite = new MachineComposite();
        Machine machine = new Machine();
        machine.setBroken();
        
        machineComposite.addComponent(machine);
        assertTrue(machineComposite.isBroken());
    }

    
    @Test
    public void testMachineComposite_BrokenComponentNotify() 
    {
        MachineComposite machineComposite = new MachineComposite();
        machineComposite.addObserver(graphicInterface);
        
        Machine machine = new Machine();
        machine.setBroken();
        machineComposite.addComponent(machine);
        
        assertTrue(graphicInterface.notify);
    }
    
    
    @Test
    public void testMachineComposite_AddedComponentBreaksNotify() 
    {
        MachineComposite machineComposite = new MachineComposite();
        machineComposite.addObserver(graphicInterface);
        
        assertFalse(graphicInterface.notify);
        
        Machine machine = new Machine();
        machineComposite.addComponent(machine);
        
        assertFalse(graphicInterface.notify);
        machine.setBroken();
        assertTrue(graphicInterface.notify);
    }
}