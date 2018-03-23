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
    private boolean detetaInstrument; // Booleano Para Que Seja Repoduzido 1 vez o Som (Instrumento Capturado).
    private boolean detetaObstacle; // Booleano Para Que Seja Repoduzido 1 vez o Som (Game Over).
    
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
    public Player()
    {
        // Manipulação da Imagem Player Para Um Formato Mais Adequado.
        imagemPlayer = getImage();
        int larguraActual = imagemPlayer.getWidth();
        int alturaActual = imagemPlayer.getHeight();
        imagemPlayer.scale(larguraActual/10, alturaActual/10);
    }
    
    /**
     * Método Para Movimentações do Player.
     */
    public void checkKeyPress()
    {
     if(Greenfoot.isKeyDown("Left"))
        setLocation(getX()-DELTA, getY());
     if(Greenfoot.isKeyDown("Right"))
        setLocation(getX()+DELTA, getY());
    }
    
    /**
     * Método Para as Interações do Player.
     */
    public void playerInteraction()
    {
        // Reprodução do Som De Instrumentos Capturados.
        if (isTouching(Instrument.class))
        {
            if(detetaInstrument == false)
            {
                Greenfoot.playSound("instrument.wav");
                detetaInstrument = true; // Só Reproduz 1 Vez o Som.
            }
        }
        else
            detetaInstrument = false;
        //Reprodução Som de Obstáculo Capturado (Game Over).
        if (isTouching(Obstacle.class))
        {
            if(detetaObstacle == false)
            {
                Greenfoot.playSound("gameover.wav");
                detetaObstacle = true; // Só Reproduz 1 Vez o Som.
                Greenfoot.stop();
            }
        }
        else
            detetaObstacle = false;
    }

    }       
    

