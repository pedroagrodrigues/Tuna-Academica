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
    private int animeCounter = 0; //conta interacções para fazer a animação 
    private String playerL, playerR;
    private int type;
    /**
     * Constructor Para Objectos da Classe Player.
     */
    public Player(int worldHeight, int type){
        // Manipulação da Imagem Player Para Um Formato Mais Adequado.
        getImage().scale(worldHeight/15, worldHeight/9);
        this.type = type;
        keyDefine();
    }
    
    private void keyDefine(){
         if (type == 1){
            playerL = "A";
            playerR = "D";
        }
        else{
            playerL = "J";
            playerR = "L";
        }
        
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeyPress();
        playerInteraction();
        animation();
    }
    /**
     * animation(), anima o player
     */
    public void animation(){
        if (animeCounter == 9){
            animeCounter = 0;
            getImage().mirrorHorizontally();
        } else animeCounter++;
    }
    
    
    /**
     * Método Para Movimentações do Player.
     */
    private void checkKeyPress(){
         if(Greenfoot.isKeyDown(playerL))
            if((!isTouching(Barrier.class) && type == 2) || type == 1) setLocation(getX()-DELTA, getY());
         if(Greenfoot.isKeyDown(playerR))
            if((!isTouching(Barrier.class) && type == 1) || type == 2) setLocation(getX()+DELTA, getY());
    }
    
    /**
     * Método Para as Interações do Player.
     */
    private void playerInteraction()
    {
        //-----------------Instrumentos-----------------------
        if (isTouching(GuitarOne.class))
        {
            getWorldOfType(OnePlayer.class).sumPoints(20); 
            removeTouching(GuitarOne.class);
            Greenfoot.playSound("instrument.wav");
        }
         if (isTouching(GuitarTwo.class))
        {
            getWorldOfType(OnePlayer.class).sumPoints(15); 
            removeTouching(GuitarTwo.class);
            Greenfoot.playSound("instrument.wav");
        }
         if (isTouching(Castanets.class))
        {
            getWorldOfType(OnePlayer.class).sumPoints(10); 
            removeTouching(Castanets.class);
            Greenfoot.playSound("instrument.wav");
        }
         if (isTouching(Maracas.class))
        {
            getWorldOfType(OnePlayer.class).sumPoints(5); 
            removeTouching(Maracas.class);
            Greenfoot.playSound("instrument.wav");
        }
        //------------Fim Instrumentos-----------------------        
        
        
        //Reprodução Som de Obstáculo Capturado (Game Over).
        if (isTouching(Obstacle.class))
        {
            Greenfoot.playSound("noo.wav");
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }

}       
    

