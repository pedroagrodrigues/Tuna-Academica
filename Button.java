import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private World world; //saves the world the button should call
    private boolean mouseOver = false; //checks if the mouse is over the button
    
    /**
     * Button constructor defines the button acordingly with the type recieved
     */
    public Button(int type, double worldHeight){
        switch (type){
            case 0:
                setImage(new GreenfootImage("oneButton.png"));
                getImage().scale((int)(worldHeight/4),(int) (worldHeight/6));
                world = new OnePlayer();
                break;
            case 1:
                world = new TwoPlayers();
                setImage(new GreenfootImage("twoButton.png"));
                getImage().scale((int)(worldHeight/4),(int) (worldHeight/6));
                break;
            case 2:
                 setImage(new GreenfootImage("exitButton.png"));
                 getImage().scale((int)(worldHeight/7),(int) (worldHeight/7));      
                break;
                
        }
      
    }
   
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Makes the button size to scale down to 90% of it's size
        if(Greenfoot.mouseMoved(this) && !mouseOver){
            getImage().scale(getImage().getWidth()*90/100, getImage().getHeight()*90/100);
            mouseOver = true;
        }            
        //calls the world if button is clicked
        if(Greenfoot.mouseClicked(this))
            placeWorld();
        //make the button to get back to it's original size   
        if(Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this) && mouseOver){
            getImage().scale(getImage().getWidth()*100/90,getImage().getHeight()*100/90);
            mouseOver = false;
        }
        
        
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
