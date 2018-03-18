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
     * 
     */
    public StartMenu()
    {    
        // Create a new world with 800*600 cells with a cell size of 1x1 pixels.
        super((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3,
        (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.5), 1);
        
        objectSpawn();
    }
    
    private void objectSpawn(){
        addObject(new Button(0), getWidth()/2, getHeight()/2-50);
        showText("One Player",getWidth()/2, getHeight()/2-50);
        addObject(new Button(1), getWidth()/2, getHeight()/2+50);
        showText("Two Players",getWidth()/2, getHeight()/2+50);
        addObject(new Button(2), getWidth()/30, getHeight()-getHeight()/30);
    }
}
