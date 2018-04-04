import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;   //(Screensize and Dimensions)
import java.awt.Dimension;
import java.time.LocalDateTime; // gets time from system
public class TwoPlayers extends World
{
     // Declaração de Variáveis
    private double[] spawnPositionX = new double[8]; // Variável Onde Guarda Possivel Quantidade de Objectos no Jogo.
    private int increment = 0; // Variavel Para Estabelecer uma Distância Entre Objectos.
    private int type; //Tipo de Instrumento
    private GreenfootImage background = new GreenfootImage("Floor.png");
    private int imageCount = 0;
    private int imageCount2 = background.getHeight();
    private int score = 0; // Variável Para somar pontos. 
    private int speed = 50, nextLevel; // denota a velocidade actual e a quantos segundos sera o proximo nivel
    private final int SECONDS = 1; // marca quanto tempo demors para subir de nivel
    
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
        for (int i = 0; i < 8; i++){
          spawnPositionX[i] = ((getWidth() *(i+i+1))/16);
        }
        
        //Speed inicial;
        nextLevel = LocalDateTime.now().getSecond() + SECONDS;
        Greenfoot.setSpeed(speed);
        
        // Alocação De Objectos no Estado Inicial do Mundo.
        objectSpawn();
               
    }
    
     /**
     * This world act will make objects spawn on the top wich will then fall and interact with the player.
     */
    public void act()
    {
       
        // Velocidade do jogo
        levelControl();
        
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
    
    private void levelControl(){
       if (LocalDateTime.now().getSecond() == nextLevel){
           
           if (nextLevel + SECONDS > 60){
               nextLevel += SECONDS - 60;
               speed++;
            }
            else{
                nextLevel += SECONDS;
                speed++;
            }
           Greenfoot.setSpeed(speed);
        }
       
    }
    //-------------------BackGround--------------
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
    //------------------------------------------------
    //-------------------Spawn Objectos---------------
    /**
    *  Método Para Posicionar Objectos no Mundo.
    */
    public void objectSpawn()
    {
        // Adicionar UI no Mundo
        addObject(new UIBar(getWidth()), getWidth()/2, getHeight()- 7); 
       
        addObject(new ScoreText(0), getWidth()/7, getHeight()- 5);
        addObject(new ScoreText(1), getWidth()/7 + getWidth()/2, getHeight()- 5);
        
        //Coloca os players nas suas posiçoes
        addObject(new Player(getHeight(), 1), getWidth()/4, getHeight() - getHeight()/10);
        addObject(new Player(getHeight(), 2), getWidth()/2 + getWidth()/4, getHeight() - getHeight()/10);
        
        //Coloca a delimitaçao do espaço de cada jogador
        addObject(new Barrier(), getWidth()/2, getHeight()/2);
    }
    //--------Instrumentos
    /**
     * spawnInstrument coloca os Instrumentos no mundo
     */
    private void spawnInstrument()
    {
          
        if(Greenfoot.getRandomNumber(100) < 50){   
            for (int i = 0; i < Greenfoot.getRandomNumber(2); i++){
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
        if(Greenfoot.getRandomNumber(100) < 50){   
            for (int i = 0; i < Greenfoot.getRandomNumber(2); i++){
                makeType();
                switch(type) {
                            case 1: 
                                addObject(new GuitarOne(getHeight()), (int)(spawnPositionX[Greenfoot.getRandomNumber(4) + 4]), 0);
                                break;
                            case 2: 
                                addObject(new GuitarTwo(getHeight()), (int)(spawnPositionX[Greenfoot.getRandomNumber(4) + 4]), 0);
                                break;
                            case 3: 
                                addObject(new Maracas(getHeight()), (int)(spawnPositionX[Greenfoot.getRandomNumber(4) + 4]), 0);
                                break;  
                            case 4: 
                                addObject(new Castanets(getHeight()), (int)(spawnPositionX[Greenfoot.getRandomNumber(4) + 4]), 0);
                                break;
                }
            }
        } 
    }
    //--------------------Fim Instrumentos
    //-----------------------Obstaculos
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
        for (int i = 0; i < Greenfoot.getRandomNumber(4); i++){
            if(Greenfoot.getRandomNumber(100) < 70){
                addObject(new Obstacle(getHeight()), (int)(spawnPositionX[Greenfoot.getRandomNumber(4) + 4]), 0);        
            }
        } 
    }
    //----------------------------Fim Obstaculos
    /**
     * makeType faz a decisao de que instrumento sera colocado no mundo
     */
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
        
}
