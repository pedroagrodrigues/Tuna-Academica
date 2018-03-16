import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;   //(Screensize and Dimensions)
import java.awt.Dimension;
/**
 * Write a description of class OnePlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OnePlayer extends World
{

    /**
     * Constructor for objects of class OnePlayer.
     * 
     */
    public OnePlayer()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/6),
            (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.5), 1);
    }
}
