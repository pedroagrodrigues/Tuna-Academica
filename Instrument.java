import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instrument here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instrument extends Actor
{
    /**
     * Act - do whatever the Instrument wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       setLocation(getX(), getY() + 2);
       destroyInstrument();
    }    
    private void  destroyInstrument(){
        if (getY() == getWorld().getHeight()-1 || isTouching(Instrument.class))
            getWorld().removeObject(this);
        
    }
}
