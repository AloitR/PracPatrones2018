
import java.util.Observable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author srblimp
 */
public abstract class MachineComponent extends Observable
{
    protected boolean broken = false;
    
    public void setBroken() { broken = true; }
    public void repair() { broken = false; }
    public abstract boolean isBroken();
}
