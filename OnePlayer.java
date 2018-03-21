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
    //Variable where we save the possible object spawn in the game
    private double[] spawnPositionX = new double[4];
    private int increment = 0; //variable to set distance between objects
    /**
     * Constructor for objects of class OnePlayer.
     * 
     */
    public OnePlayer()
    {    
        //Sets the super size acordingly with the screen resolution
        super((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/6),
            (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.5), 1);
            
        setPaintOrder(UIBar.class, Obstacle.class, Instrument.class); //object priority
        
        for (int i = 0; i < 4; i++){
          spawnPositionX[i] = ((getWidth() *(i+i+1))/8);
        }
        
        Greenfoot.setSpeed(50);
        objectSpawn();  //default objects
    }
    
   
    /**
     * This world act will make objects spawn on the top wich will then fall and interact with the player
     */
    public void act(){
        if (increment == 50){
            spawnObstacle();
            //spawnBonus();
            spawnInstrument();
            increment=0;
        }
        else increment++;
    }
    
    /**
     * Kinds of spawn
     *  objectSpawn() - Creates the initial user interface. 
     *  spawnObstacle() - Creates three or less obstacles allined.
     *  spawnInstrument() - Creates one instrument.
     *  spawnBonus() - Creates a bonus that can be used at will (if catched).
     */
    
    private void objectSpawn(){
        addObject(new UIBar(getWidth()), getWidth()/2, getHeight()- 5); //interface bar
    }
    
    private void spawnObstacle(){
        for (int i = 0; i < Greenfoot.getRandomNumber(4); i++){
            if( Greenfoot.getRandomNumber(100) < 40){
                addObject(new Obstacle(getHeight()), (int)(spawnPositionX[Greenfoot.getRandomNumber(4)]), 0);        
            }
        } 
    }
   
    private void spawnInstrument(){
        if( Greenfoot.getRandomNumber(100) < 20){
            addObject(new Instrument(getHeight()), (int)(spawnPositionX[Greenfoot.getRandomNumber(4)]), 0);        
        }
    }
   
}
