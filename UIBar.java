import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class UIBar extends Actor{
    /**
     * Constructor defines the shape of the user interface bar
     *
     **/
    public UIBar(int worldWidth){
        /**Placing a wall in the center of the world creating a division between both players*/
        getImage().scale(worldWidth, getImage().getHeight()/3);
    }
}
