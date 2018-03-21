import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    /**
     * Act - do whatever the Obstacle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       setLocation(getX(), getY() + 2);
       destroyInstrument();
    }    
    private void  destroyInstrument(){
        if (getY() == getWorld().getHeight()-1 || isTouching(Instrument.class) || isTouching(Obstacle.class))
            getWorld().removeObject(this);
    }
}
