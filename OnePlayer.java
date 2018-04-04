import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;   //Toolkit e Dimension obtem a resoluçao do ecran
import java.awt.Dimension;
import java.awt.Font;
/**
 * Write a description of class OnePlayer here.
 * 
 */
public class OnePlayer extends World
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
     * Constructor Para Objectos da Classe OnePlayer.
     */
    public OnePlayer()
    {    
        // Define o Tamanho do super de Acordo com a Resolução do Ecrã.
        super((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/6),
            (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.5), 1);
        //Desenha o fundo
        getBackground().drawImage(background, 0, 0);    
        // Prioridade dos Objectos.    
        setPaintOrder(ScoreText.class, UIBar.class, Obstacle.class, Instrument.class, Player.class);
       
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
     * This world act will make objects spawn on the top wich will then fall and interact with the player.
     */
    public void act()
    {
        // Velocidade do jogo
        Greenfoot.setSpeed(speed);
        if (increment == 100){
            spawnObstacle();
            //spawnBonus();
            spawnInstrument();
            increment=0;
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
        getBackground().drawImage(background, 0, imageCount2);  
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
        addObject(new UIBar(getWidth()), getWidth()/2, getHeight()- 7); // Barra De Pontuação/Informação.
        addObject(new ScoreText(score), getWidth()/7, getHeight()- 5);
        addObject(new Player(getHeight(), 1), getWidth()/2, getHeight() - getHeight()/10);
    }
    
    /**
     * Método Para Criação De Obstáculos e Posicionamento Random, Nas Colunas do Mundo.
     */
    private void spawnObstacle()
    {
        for (int i = 0; i < Greenfoot.getRandomNumber(4); i++){
            if(Greenfoot.getRandomNumber(100) < 70){
                addObject(new Obstacle(getHeight()), (int)(spawnPositionX[Greenfoot.getRandomNumber(4)]), 0);        
            }
        } 
    }
    //-----------------------------------------------Secção dos Instrumentos---------------------------------
    private void makeType(){
        int rand = Greenfoot.getRandomNumber(100); // 0 - 99 
        //var provisória utilizada só para fazer os cálculos 
        //(podiamos utilizar a variável type para o mesmo efeito)
        if (rand < 25) type = 1;
        else if (rand > 25 && rand < 50) type = 2;
            else if (rand > 50 && rand < 75) type = 3;
        else type = 4;
        //Neste momento todos os instrumentos têm 25% de probabilidade de serem criados.
    }
    /**
     * spawnInstrument coloca os Instrumentos no mundo
     */
    private void spawnInstrument()
    {
        for (int i = 0; i < Greenfoot.getRandomNumber(3); i++){
            if(Greenfoot.getRandomNumber(100) < 50){
                makeType();
                switch(type) {
                    case 1: 
                        addObject(new GuitarOne(getHeight()), (int)(spawnPositionX[Greenfoot.getRandomNumber(4)]), 0);
                        break;
                    case 2: 
                        addObject(new GuitarTwo(getHeight()), (int)(spawnPositionX[Greenfoot.getRandomNumber(4)]), 0);
                        break;
                    case 3: 
                        addObject(new Maracas(getHeight()), (int)(spawnPositionX[Greenfoot.getRandomNumber(4)]), 0);
                        break;  
                    case 4: 
                        addObject(new Castanets(getHeight()), (int)(spawnPositionX[Greenfoot.getRandomNumber(4)]), 0);
                        break;
                }
            }
        } 
        
    }
    //-----------------------------------------Fim da secção Instrumentos------------------------------------------------
   
    
    
}