import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;   //(Screensize and Dimensions)
import java.awt.Dimension;
import java.time.LocalDateTime; // gets time from system

public class TwoPlayers extends World
{
    // Declaração de Variáveis
    private double[] spawnPositionX; // Variável Onde Guarda Possivel Quantidade de Objectos no Jogo.
    private int increment; // Variavel Para Estabelecer uma Distância Entre Objectos.
    private int type; //Tipo de Instrumento
    private GreenfootImage background;
    private int imageCount, imageCount2; //define a posiçao Y do background
    private int speed, nextLevel; // denota a velocidade actual e a quantos segundos sera o proximo nivel
    private final int SECONDS = 10; // marca quanto tempo demors para subir de nivel
    
     /**
     * TwoPlayers() e o metodo construtor do mundo, este faz a organizaçao
     * inicial do mundo, define o tamanho do mundo, desenha o background inicial
     * e chama os metodos necessarios para colocar os objectos no mundo
     */
    public TwoPlayers()
    {
        // Cria um Mundo Com Metade do Tamanho do Ecrã, Dinamicamente Para Qualquer Ecrã.
        super((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3,
        (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.5), 1);
        
        //Inicializaçao de variaveis
        spawnPositionX = new double[8];
        increment = 0;
        background = new GreenfootImage("Floor.png");
        imageCount = 0;
        imageCount2 = background.getHeight();
        speed = 50;
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
     * This world act will make objects spawn on the top wich 
     * will then fall and interact with the player.
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
        levelControl();
    }
    
    /**
     * levelControl pede ao Sistema os segundos 
     * recorrendo a funçao LocalDataTime.now().getSecond() que pertence
     * ao package java.time.LocalDateTime.
     * O resultado desta funçao e entao comparado com a variavel nextLevel
     * se esta comparaçao se verificar verdadeira incrementamos entao 
     * a velocidade do jogo
     */
    private void levelControl(){
       if (LocalDateTime.now().getSecond() == nextLevel){
           
           if ((nextLevel + SECONDS) > 60){
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
    
    //-------------------BackGround-----------------
    /**
     * imageIncrement simplesmente incrementa a variavel que postriormente 
     * e utilizada para fazer a posiçao do Background
     */
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
    /**
     * Coloca o background, com o auxilio do metodo anterior(imageIncrement),
     * ligeiramente a baixo da posiçao anterior, dando a aparencia que o 
     * fundo se desloca
     */
    private void moveBackground(){
        getBackground().drawImage(background, 0, imageCount);
        getBackground().drawImage(background, background.getWidth(), imageCount);
        getBackground().drawImage(background, 0, imageCount2); 
        getBackground().drawImage(background, background.getWidth(), imageCount2);
    }
    //-------------------End Background---------------
    
    //-------------------Spawn Objectos---------------
    /**
     *  objectSpawn() - Cria Interface Inicial Do Utilizador
     *  colocando os objectos bem como a personagem no mundo
     */
    public void objectSpawn()
    {
        // Adicionar UI no Mundo
        addObject(new UIBar(getWidth()), getWidth()/2, getHeight()- 7);
        addObject(new ScoreText(0), getWidth()/2, getHeight()- 5);
        //Coloca os players nas suas posiçoes
        addObject(new Player(getHeight(), 1), getWidth()/4, getHeight() - getHeight()/10);
        addObject(new Player(getHeight(), 2), getWidth()/2 + getWidth()/4, getHeight() - getHeight()/10);
        
        //Coloca a delimitaçao do espaço de cada jogador
        addObject(new Barrier(), getWidth()/2, getHeight()/2);
    }
    //-----------------------Obstaculos-------------
     /**
     * spawnObstacle, coloca obstaculos no mundo, numa das quatro
     * posiçoes pre-definidas no array spawnPosition[];
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
    //----------------------------Fim Obstaculos---------------
    //-----------------------------------------------Secção dos Instrumentos---------------------------------
    /**
     * makeType e o metodo responsavel pela escolha aleatoria de que tipo
     * de objeto vai ser colocado no mundo
     */
    private void makeType(){
        int rand = Greenfoot.getRandomNumber(100); // 0 - 99 
        //var provisória utilizada só para fazer os cálculos 
        //(podiamos utilizar a variável type para o mesmo efeito)
        if (rand < 40) type = 1;
        else if (rand > 40 && rand < 70) type = 2;
            else if (rand > 70 && rand < 80) type = 3;
        else type = 4;
    }
    /**
     * spawnInstrument coloca objetos pontuaveis no mundo,
     * estes objetos sao escolhidos aleatoriamente pelo metodo makeType
     * e posteriormente colocados numa posiçao aleatoria defenida no array
     * spawnPosition[]
     */
    private void spawnInstrument(){
          
        if(Greenfoot.getRandomNumber(100) < 80){   
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
    //--------------------Fim Instrumentos------------------  
}
