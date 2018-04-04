import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreText extends Actor
{
    private String text;
    private int[] score = new int[2];
    private Boolean[] alive = new Boolean[2];
    
    /**
     * Construtor no mundo OnePlayer 
     */
    public ScoreText(){
        score[0] = 0;
        alive[0] = false;
        text = "Score: " + score[0];
        setImage(new GreenfootImage(text, 18, new Color(255, 255, 255), new Color(0, 0, 0)));
        
    }
    
    /**
     * Construtor no mundo TwoPlayer 
     */
    
    public ScoreText(int secondWorld){
        score[0] = score[1] = 0;
        alive[0] = alive[1] = false;
        if (secondWorld == 0){
            text = "Score: " + score[0];
            setImage(new GreenfootImage(text, 18, new Color(255, 255, 255), new Color(0, 0, 0)));
        }
        else if(secondWorld == 1){
            text = "Score: " + score[1];
            setImage(new GreenfootImage(text, 18, new Color(255, 255, 255), new Color(0, 0, 0)));
        }
        else return;
    }
    
    
    /**
    * sumPoints(int points) serve para somar pontos, ao apanhar instrumentos.
    */
    public void sumPoints(int points, int player){ 
        score[player] += points;
        text = "Score: " + score[player];
        setImage(new GreenfootImage(text, 18, new Color(255, 255, 255), new Color(0, 0, 0)));
    }
    
    private void endGame ()
    {
        if(score[0] > score[1])
        {
            text = "Player 1 WIN!/n " + score[0];
            setImage(new GreenfootImage(text, 18, new Color(255, 255, 255), new Color(0, 0, 0))); 
            setLocation(getWorld().getWidth()/2,getWorld().getHeight()/2);
        }
        else if(score[0] == score[1])
            {
                text = "EMPATE!";
                setImage(new GreenfootImage(text, 18, new Color(255, 255, 255), new Color(0, 0, 0))); 
                setLocation(getWorld().getWidth()/2,getWorld().getHeight()/2);
            }
        else
        {
           text = "Player 2 WIN!/n " + score[1];
            setImage(new GreenfootImage(text, 18, new Color(255, 255, 255), new Color(0, 0, 0))); 
            setLocation(getWorld().getWidth()/2,getWorld().getHeight()/2);
        }
    }
    
    public void act ()
    {

        System.out.println(alive[0] + "         " + alive[1]);   
    }
    
    public void setAlive(int player)
    {
        System.out.println("setting 2");   
        alive[player] = true;
    }
    
  
}
