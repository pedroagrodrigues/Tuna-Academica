import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreText extends Actor
{
    private String text;
    private int[] score = {0, 0};
    private boolean[] alive = {true, true};
    private int world;
    private boolean mouseOver = true, worldEnd = false;
    
    /**
     * Construtor no mundo OnePlayer 
     */
    public ScoreText(){
        text = "Score: " + score[0];
        world = 1;
        setImage(new GreenfootImage(text, 18, new Color(255, 255, 255), new Color(0, 0, 0)));
        
    }
    
    /**
     * Construtor no mundo TwoPlayer 
     */
    
    public ScoreText(int secondWorld){
        world = 2;
        text = "Score: " + score[0] + "                 Score: " + score[1];
        setImage(new GreenfootImage(text, 18, new Color(255, 255, 255), new Color(0, 0, 0)));
    }
    
    /**
    * sumPoints(int points, int player) serve para somar pontos, ao apanhar instrumentos.
    */
    public void sumPoints(int points, int player){ 
        score[player] += points;
        if (world == 1) text = "Score: " + score[0];
        else text = "Score: " + score[0] + "                 Score: " + score[1];
        setImage(new GreenfootImage(text, 18, new Color(255, 255, 255), new Color(0, 0, 0)));
    }
    
    /**
     * Verifica quando acaba o jogo para devolver a pontuaçao
     */
    public void act(){
       if ((!alive[0] && score[1] > score[0]) || (!alive[1] && score[0] > score[1]) || (!alive[1]  && !alive[0]) || (!alive[0] && world == 1)){
           endGame();
        }
        lastInteraction();
    }
    
    /**
     * atribui o valor falso a variavel correspondente ao player que acabou de perder
     */
    public void playerAlive(int player){
        alive[player] = false;
    }
    
    /**
     * Volta para menu inicial
     */
     // Reajusta Tamanho da Opção para 90% do Seu Tamanho Original.
    private void lastInteraction(){
         if(Greenfoot.mouseClicked(this) && worldEnd)
            Greenfoot.setWorld(new StartMenu());
    }
    
    /**
     * Acaba o jogo devolvendo a pontuaçao do vencedor
     */
    private void endGame()
    {
        if (world == 1) text = "Game Over! " + "\n" + score[0];
        else if(score[0] > score[1]) text = "Player 1 WIN! " + "\n" + score[0];
        else if(score[0] == score[1]) text = "DRAW!" + "\n" + score[0];
        else text = "Player 2 WIN! " + "\n" + score[1];
        text += " points!\n\nClick to go back!";
        setImage(new GreenfootImage(text, 18, new Color(255, 255, 255), new Color(0, 0, 0))); 
        setLocation(getWorld().getWidth()/2,getWorld().getHeight()/2);
        worldEnd=true;
    }
  
}
