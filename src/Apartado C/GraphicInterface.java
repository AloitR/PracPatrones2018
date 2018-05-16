package ApartatC;


import java.util.Observable;
import java.util.Observer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AloitR
 */
public class GraphicInterface implements Observer 
{

    public boolean notify = false;

    @Override
    public void update(Observable o, Object arg) 
    {
        notify = true;
    }

}