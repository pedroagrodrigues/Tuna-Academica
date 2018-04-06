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
    private int animeCounter; //conta interacções para fazer a animação 
    private String playerL, playerR;
    private int type; // Player 1 ou player2

    /**
     * Define o Player formatando a imagem e defenindo que tipo de jogador se trata (1 ou 2)
     */
    public Player(int worldHeight, int type){
        animeCounter = 0;
        // Manipulação da Imagem Player Para Um Formato Mais Adequado.
        getImage().scale(worldHeight/15, worldHeight/9);
        this.type =  type - 1;
        keyDefine();        
    }
    /**
     * Define as teclas de deslocamento
     */
    private void keyDefine(){
         if (type == 0){
            playerL = "A";
            playerR = "D";
        }
        else{
            playerL = "left";
            playerR = "right";
        }
        
    }
    
    /**
     * Define o comportamento do jogador atravez da referencia
     * de outros metodos.
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
     * Método Para defenir como o objecto se vai mover
     */
    private void checkKeyPress(){
         if(Greenfoot.isKeyDown(playerL))
            if((!isTouching(Barrier.class) && type == 1) || type == 0) setLocation(getX()-DELTA, getY());
         if(Greenfoot.isKeyDown(playerR))
            if((!isTouching(Barrier.class) && type == 0) || type == 1) setLocation(getX()+DELTA, getY());
    }
    
    /**
     * Método Para as Interações do Player com outros objectos.
     */
    private void playerInteraction()
    {
        //-----------------Instrumentos----------------------
        if (isTouching(GuitarOne.class))
        {
            ((ScoreText)getWorld().getObjects(ScoreText.class).get(0)).sumPoints(5, type);            
            removeTouching(GuitarOne.class);
            Greenfoot.playSound("instrument.wav");
        }
         
        if (isTouching(GuitarTwo.class))
        {
            ((ScoreText)getWorld().getObjects(ScoreText.class).get(0)).sumPoints(15, type);            
            removeTouching(GuitarTwo.class);
            Greenfoot.playSound("instrument.wav");
        }
        
        if (isTouching(Castanets.class))
        {
            ((ScoreText)getWorld().getObjects(ScoreText.class).get(0)).sumPoints(25, type);            
            removeTouching(Castanets.class);
            Greenfoot.playSound("instrument.wav");       
        }
        
        if (isTouching(Maracas.class))
        {
            ((ScoreText)getWorld().getObjects(ScoreText.class).get(0)).sumPoints(50, type);            
            removeTouching(Maracas.class);
            Greenfoot.playSound("instrument.wav");
        }
        //------------Fim Instrumentos-----------------------        
          
        //colisao com obstaculo
        if (isTouching(Obstacle.class))
        {
            
            Greenfoot.playSound("noo.wav");
            ((ScoreText)getWorld().getObjects(ScoreText.class).get(0)).playerAlive(type);
            
            getWorld().removeObject(this);

        }
    
    }

}       
    

