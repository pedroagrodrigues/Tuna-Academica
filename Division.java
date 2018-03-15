import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Division extends Actor{
    /**
     * Constructor defines the shape of the wall
     *
     **/
    public Division(int worldHeight) //recieve worldHeight because we cant use getWorld() since the object is being created 
    {
        /**Placing a wall in the center of the world creating a division between both players*/
        getImage().scale(getImage().getWidth()/2, worldHeight);
    }
    /**
     * Act - do whatever the Division wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        
    }   
    /**
     * Placing a wall in the center of the world creating a division between players
     */
   
}
