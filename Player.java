import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{

    private final int DELTA = 5;
    
    public void act() 
    {
        checkKeyPress();
        Instrumentget();
    }    
    
    public void checkKeyPress() // movimento do actor
    {
        if(Greenfoot.isKeyDown("A"))
                setLocation(getX()-DELTA, getY());
        if(Greenfoot.isKeyDown("D"))
                setLocation(getX()+DELTA, getY());
    }
    
    private boolean detectInstrument; // boleano para que ser contado apenas a 1º interação
    /**
     * Método para detetar interseção com Instrumento e somar pontos
     */
    public void Instrumentget()
    {
           if(isTouching(Instrument.class))       {
               if (detectInstrument == false)
               {                                  
                    getWorldOfType(OnePlayer.class).sumPoints(10);   
                    detectInstrument = true;
               }   
           }
           else
                  detectInstrument = false;
    }
    
    
}