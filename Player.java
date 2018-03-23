import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    // Declaração de Variáveis
    private final int DELTA = 5; // Descolamento do Player.
    private GreenfootImage imagemPlayer; // Variável Para Ajustamento do Tamanho do Player.
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeyPress();
        playerInteraction();
    }
    
    /**
     * Constructor Para Objectos da Classe Player.
     */
    public Player(int worldWidth)
    {
        // Manipulação da Imagem Player Para Um Formato Mais Adequado.
        getImage().scale(worldWidth/6, worldWidth/3);
    }
    
    /**
     * Método Para Movimentações do Player.
     */
    private void checkKeyPress()
    {
     if(Greenfoot.isKeyDown("Left"))
        setLocation(getX()-DELTA, getY());
     if(Greenfoot.isKeyDown("Right"))
        setLocation(getX()+DELTA, getY());
    }
    
    /**
     * Método Para as Interações do Player.
     */
    private void playerInteraction()
    {
        // Reprodução do Som De Instrumentos Capturados.
        if (isTouching(Instrument.class))
        {
            removeTouching(Instrument.class);
            Greenfoot.playSound("instrument.wav");
        }
        
        //Reprodução Som de Obstáculo Capturado (Game Over).
        if (isTouching(Obstacle.class))
        {
            Greenfoot.playSound("noo.wav");
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }

}       
    

