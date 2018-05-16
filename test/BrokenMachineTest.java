/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ApartatC.GraphicInterface;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Yesid
 */
public class BrokenMachineTest {
    
    private GraphicInterface graphicInterface;

    @Before
    public void setUp() throws Exception {
        graphicInterface = new GraphicInterface();
    }
    
    @Test
    public void test_ObserverIsNotifiedWhenMachineBreak() {
        Machine machine = new Machine();
        machine.addObserver(this.graphicInterface);
        machine.setBroken();
        assertTrue(this.graphicInterface.notify);
        
    }
    
    @Test 
    public void test_ElObservador_esta_notificado_si_el_estado_NoCambia(){
        Machine brokenMachine = createBrokenMachine();
        brokenMachine.addObserver(this.graphicInterface);
        brokenMachine.setBroken();
        assertFalse(this.graphicInterface.notify);
      
    }
    
    
    @Test
    public void test_ElObservador_es_notificado_cuando_se_repara_una_maquinaRota(){
        Machine brokenMachine = createBrokenMachine();
        brokenMachine.addObserver(this.graphicInterface);
        brokenMachine.repair();
        assertTrue(this.graphicInterface.notify);
        
    }
    
     @Test
    public void test_ElObservador_no_es_notificado_cuando_se_repara_una_maquina_que_funciona(){
        Machine workingMachine = new Machine();
        workingMachine.addObserver(graphicInterface);
        workingMachine.repair();
        assertFalse(graphicInterface.notify);
    }
            
    
    
    private Machine createBrokenMachine() {
        Machine machine = new Machine();
        machine.setBroken();
        return machine;
    }
    
    
}
