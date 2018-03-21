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
    private double[] spawnPositionX;
    private int increment = 0; //variable to set distance between objects
    private int score;
    /**
     * Constructor for objects of class OnePlayer.
     * 
     */
    public OnePlayer()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/6),
            (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.5), 1);
        spawnPositionX = new double[4];
        
        for (int i = 0; i < 4; i++){
          spawnPositionX[i] = ((getWidth() *(i+i+1))/8);
        }
        Greenfoot.setSpeed(50);
        
        // mostrar o score 
        score = 0;
        showText("Score: " +score, (getWidth()/10)+10,getHeight()-getHeight()/99);
        
        // timer
    }
    
    public void act(){

        if (increment == 50){
            spawnObstacle();
            //spawnBonus();
            spawnInstrument();
            increment=0;
        }
        else increment++;
    }
    private void spawnObstacle(){
        for (int i = 0; i < Greenfoot.getRandomNumber(4); i++){
            if( Greenfoot.getRandomNumber(100)+1 < 50){
                addObject(new Obstacle(), (int)(spawnPositionX[Greenfoot.getRandomNumber(4)]), 0);        
            }
        }
        
    }
    
    private void spawnInstrument(){
        if( Greenfoot.getRandomNumber(100)+1 < 15){
            addObject(new Instrument(), (int)(spawnPositionX[Greenfoot.getRandomNumber(4)]), 0);        
        }
    }
    
    public void sumPoints(int points){
        score = score + points;
        showText("Score: " +score, (getWidth()/10)+10,getHeight()-getHeight()/99);
    }

}

//  spawnPositionX[i] = (int)((getWidth() *(i+i+1))/8);