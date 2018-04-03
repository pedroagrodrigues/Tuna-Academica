import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;   //(Screensize and Dimensions)
import java.awt.Dimension;

public class TwoPlayers extends World
{
     // Declaração de Variáveis
    private double[] spawnPositionX = new double[4]; // Variável Onde Guarda Possivel Quantidade de Objectos no Jogo.
    private int increment = 0; // Variavel Para Estabelecer uma Distância Entre Objectos.
    private int type; //Tipo de Instrumento
    private GreenfootImage background = new GreenfootImage("Floor.png");
    private int imageCount = 0;
    private int imageCount2 = background.getHeight();
    private int score = 0; // Variável Para somar pontos. 
    private int speed, level = 50;
        
    /**
     * Constructor Para Objectos da Classe MyWorld.
     */
    public TwoPlayers()
    {    
        // Cria um Mundo Com Metade do Tamanho do Ecrã, Dinamicamente Para Qualquer Ecrã.
        super((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3,
        (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.5), 1);
       
        //Desenha o fundo
        getBackground().drawImage(background, 0, 0);
        getBackground().drawImage(background, background.getWidth(), 0);
        // Prioridade dos Objectos.    
        setPaintOrder(ScoreText.class, UIBar.class, Barrier.class, Obstacle.class, Instrument.class, Player.class);
       
        // Cria as posiçoes em X onde podem ser colocados objectos
        for (int i = 0; i < 4; i++){
          spawnPositionX[i] = ((getWidth() *(i+i+1))/8);
        }
        
        //Speed inicial;
        speed = 50;
        
       
        // Alocação De Objectos no Estado Inicial do Mundo.
        objectSpawn();
               
    }
    
    /**
     *  Método Para Posicionar Objectos no Mundo.
     */
    public void objectSpawn()
    {
        // Adicionar "Barra" no Centro do Mundo
        addObject(new UIBar(getWidth()), getWidth()/2, getHeight()- 7); 
        //addObject(new ScoreText(score), getWidth()/7, getHeight()- 5);
        addObject(new Player(getHeight(), 1), getWidth()/2, getHeight() - getHeight()/10);
        addObject(new Barrier(), getWidth()/2, getHeight()/2);
    }
    
     /**
     * This world act will make objects spawn on the top wich will then fall and interact with the player.
     */
    public void act()
    {
        // Velocidade do jogo
        Greenfoot.setSpeed(speed);
        if (increment == 100){
            //spawnObstacle();
            //spawnBonus();
            //spawnInstrument();
            //increment=0;
        }
        else increment++;
        imageIncrement();
        moveBackground();
    }
     private void imageIncrement(){ 
        if (imageCount < background.getHeight()){
            imageCount += 2;
        }
        else {
            imageCount = -background.getHeight();
           
        }
        if (imageCount2 < background.getHeight()){
            imageCount2 += 2;
        }
        else {
            imageCount2 = -background.getHeight();
            
        }
    }
    private void moveBackground(){
        getBackground().drawImage(background, 0, imageCount);
        getBackground().drawImage(background, background.getWidth(), imageCount);
        getBackground().drawImage(background, 0, imageCount2); 
        getBackground().drawImage(background, background.getWidth(), imageCount2);
    }
}
