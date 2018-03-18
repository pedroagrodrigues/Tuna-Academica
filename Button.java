import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private World world;
    /**
     * Button constructor
     */
    public Button(int type){
        switch (type){
            case 0:
                setImage(new GreenfootImage("button.png"));
                world = new OnePlayer();
                break;
            case 1:
                world = new TwoPlayers();
                setImage(new GreenfootImage("button.png"));
                break;
            case 2:
                setImage(new GreenfootImage("exit.png"));
                getImage().scale(50,50);
                
                break;
                
        }
      
    }
   
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
            placeWorld();
    }    
    /**
     * This funcion defines the funcion of the button
     */
    private void placeWorld(){
        if(world != null){
            Greenfoot.setWorld(world);
        }
        else
            Greenfoot.stop();
    }
}
