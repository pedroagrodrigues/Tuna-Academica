import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;   //(Screensize and Dimensions)
import java.awt.Dimension;
/**
 * Write a description of class StartMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartMenu extends World
{

    /**
     * Constructor for objects of class StartMenu.
     */
    public StartMenu()
    {    
        //Sets the super size acordingly with the screen resolution
        super((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3,
        (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.5), 1);
        
        objectSpawn();
    }
    
    /**
     * Places clickable buttons in the world.
     */
    private void objectSpawn(){
        addObject(new Button(0, getHeight()), (int)(getWidth()/3), (int)(getHeight()/2.5));
        addObject(new Button(1, getHeight()), (int) (getWidth()*2/3), (int)(getHeight()/2.5));
        addObject(new Button(2, getHeight()), (int) (getWidth()/2), (int)(getHeight()-getHeight()/3));
    }
}
