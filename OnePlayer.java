import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;   //Toolkit e Dimension obtem a resoluçao do ecran
import java.awt.Dimension;
import java.time.LocalDateTime; // gets time from system
/**
 * OnePlayer e uma subclass de world
 * esta class utiliza-se para "criar" o mundo para um jogador.
 */
public class OnePlayer extends World
{
    // Declaração de Variáveis
    private double[] spawnPositionX; // Variável Onde Guarda Possivel Quantidade de Objectos no Jogo.
    private int increment; // Variavel Para Estabelecer uma Distância Entre Objectos.
    private int type; //Tipo de Instrumento
    private GreenfootImage background = new GreenfootImage("Floor.png");
    private int imageCount,imageCount2;
    private final int SECONDS = 10; // marca quanto tempo demors para subir de nivel
    private int speed, nextLevel; // denota a velocidade actual e a quantos segundos sera o proximo nivel
    
    /**
     * OnePlayer() e o metodo construtor do mundo, este faz a organizaçao
     * inicial do mundo, define o tamanho do mundo, desenha o background inicial
     * e chama os metodos necessarios para colocar os objectos no mundo
     */
    public OnePlayer()
    {    
        // Define o Tamanho do super de Acordo com a Resolução do Ecrã.
        super((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/6),
            (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.5), 1);
        //variaveis
        spawnPositionX = new double[4];
        increment = 0;
        imageCount = 0;
        imageCount2 = background.getHeight();
        speed = 50;
        
        
        //Desenha o fundo
        getBackground().drawImage(background, 0, 0); 
        
        // Prioridade dos Objectos.    
        setPaintOrder(ScoreText.class, UIBar.class, Obstacle.class, Instrument.class, Player.class);
       
        // Cria as posiçoes em X onde podem ser colocados objectos
        for (int i = 0; i < 4; i++){
          spawnPositionX[i] = ((getWidth() *(i+i+1))/8);
        }
        //Speed inicial;
        nextLevel = LocalDateTime.now().getSecond() + SECONDS;
        Greenfoot.setSpeed(speed);
        // Alocação De Objectos no Estado Inicial do Mundo.
        objectSpawn();
               
    }  
    /**
     * This world act will make objects spawn on the top wich will then fall and interact with the player.
     * The functions defined here are:
     * levelControl to control the speed
     * moveBackground to move the background
     */
    public void act()
    {
        // Velocidade do jogo
        if (increment == 100){
            spawnObstacle();
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
       if (LocalDateTime.now().getSecond() >= nextLevel){
           
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
        getBackground().drawImage(background, 0, imageCount2);  
    }
    //-----------End BackGround-------------------------
    /**
     *  objectSpawn() - Cria Interface Inicial Do Utilizador
     *  colocando os objectos bem como a personagem no mundo
     */
    private void objectSpawn()
    {
        addObject(new UIBar(getWidth()), getWidth()/2, getHeight()- 7); // Barra De Pontuação/Informação.
        addObject(new ScoreText(), getWidth()/2, getHeight()- 5);
        addObject(new Player(getHeight(), 1), getWidth()/2, getHeight() - getHeight()/10);
    }
    
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
    }
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
        //Neste momento todos os instrumentos têm 25% de probabilidade de serem criados.
    }
    /**
     * spawnInstrument coloca objetos pontuaveis no mundo,
     * estes objetos sao escolhidos aleatoriamente pelo metodo makeType
     * e posteriormente colocados numa posiçao aleatoria defenida no array
     * spawnPosition[]
     */
    private void spawnInstrument()
    {
        for (int i = 0; i < Greenfoot.getRandomNumber(3); i++){
            if(Greenfoot.getRandomNumber(100) < 80){
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