import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;   //(Screensize and Dimensions)
import java.awt.Dimension;
/**
 * Write a description of class OnePlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OnePlayer extends World
{
    // Declaração de Variáveis
    private double[] spawnPositionX = new double[4]; // Variável Onde Guarda Possivel Quantidade de Objectos no Jogo.
    private int increment = 0; // Variavel Para Estabelecer uma Distância Entre Objectos.
    
    /**
     * Constructor Para Objectos da Classe OnePlayer.
     */
    public OnePlayer()
    {    
        // Define o Tamanho do super de Acordo com a Resolução do Ecrã.
        super((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/6),
            (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.5), 1);
            
        // Prioridade dos Objectos.    
        setPaintOrder(UIBar.class, Obstacle.class, Instrument.class);
       
        // Random da Coluna Para Colocação de Objectos.
        for (int i = 0; i < 4; i++){
          spawnPositionX[i] = ((getWidth() *(i+i+1))/8);
        }
        
        // Atribuição De uma Velocidade Inicial "Standard" ao Mundo.
        Greenfoot.setSpeed(50);
       
        // Alocação De Objectos no Estado Inicial do Mundo.
        objectSpawn();
        
        // Adicionar Player ao Mundo.
        playerCriation();
    }
    
    /**
     * This world act will make objects spawn on the top wich will then fall and interact with the player.
     */
    public void act()
    {
        if (increment == 50){
            spawnObstacle();
            //spawnBonus();
            spawnInstrument();
            increment=0;
        }
        else increment++;
    }
    
    /**
     * Tipos de Objectos:
     *  objectSpawn() - Cria Interface Inicial Do Utilizador.
     *  spawnObstacle() - Cria 3 ou menos Obstáculos Alinhados.
     *  spawnInstrument() - Cria um Instrumento.
     *  spawnBonus() - Cria um Bónus Que Poderá ser Utilizado Futuramente (Se For Capturado).
     */
    private void objectSpawn()
    {
        addObject(new UIBar(getWidth()), getWidth()/2, getHeight()- 5); // Barra De Pontuação/Informação.
    }
    
    /**
     * Método Para Criação De Obstáculos e Posicionamento Random, Nas Colunas do Mundo.
     */
    private void spawnObstacle()
    {
        for (int i = 0; i < Greenfoot.getRandomNumber(4); i++){
            if( Greenfoot.getRandomNumber(100) < 40){
                addObject(new Obstacle(getHeight()), (int)(spawnPositionX[Greenfoot.getRandomNumber(4)]), 0);        
            }
        } 
    }
    
    /**
     * Método Para Criação De Instrumentos e Posicionamento Random, Nas Colunas do Mundo.
     */
    private void spawnInstrument()
    {
        if( Greenfoot.getRandomNumber(100) < 20){
            addObject(new Instrument(getHeight()), (int)(spawnPositionX[Greenfoot.getRandomNumber(4)]), 0);        
        }
    }
   
    /**
     * Método Para Criação do Player no Mundo.
     */
    public void playerCriation()
    {
        Player player1 = new Player();
        addObject(player1, getWidth()/2, getHeight() - 50);
    }
    
}
