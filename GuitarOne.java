import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GuitarOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuitarOne extends Instrument
{
    
    public GuitarOne(int worldHeight){
        getImage().scale(worldHeight/15, worldHeight/22);
    }     
}
