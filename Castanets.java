import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;
 
public class Castanets extends Instrument
{
    private boolean inRange = false;
    public Castanets(int worldHeight){
        getImage().scale(worldHeight/15, worldHeight/22);
    }   
    
    public void act(){
        super.act();
        isClose();
    }
    /**
     * isClose e um metodo que apaga o objecto devez em quando
     * inRange obriga a que o so haja uma tentativa de remover o objeto
     * 
     */
    public void isClose(){
        if(getWorld() != null) //evitar erros de colocaçao no mundo
            if (getObjectsInRange(300, Player.class).size() >= 1 && !inRange){
                inRange = true;
                if(Greenfoot.getRandomNumber(10) < 4){
                    getWorld().removeObject(this);
                } 
            }
    }
}