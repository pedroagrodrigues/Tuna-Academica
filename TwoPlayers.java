import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;   //(Screensize and Dimensions)
import java.awt.Dimension;

public class TwoPlayers extends World
{

        
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
     //Dimension windowSize = window.getSize();
    public TwoPlayers()
    {    
        //Create a world that is half of the screen size, dynamic for every screen
        super((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3,
        (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.5), 1);
        objectSpawn();
    }
    
    /**
     *  Método Para Posicionar Objectos no Mundo
     */
 
    public void objectSpawn(){
        // Adicionar "Division" no Centro do Mundo
        addObject(new UIBar(getHeight()), getWidth()/2, getHeight()/2);
    }
}
