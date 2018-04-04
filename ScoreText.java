import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreText extends Actor
{
    private String text;
    private int[] score = new int[2];
    
    
    /**
     * Construtor no mundo OnePlayer 
     */
    public ScoreText(){
        score[0] = 0;
        text = "Score: " + score[0];
        setImage(new GreenfootImage(text, 18, new Color(255, 255, 255), new Color(0, 0, 0)));
        
    }
    
    /**
     * Construtor no mundo TwoPlayer 
     */
    
    public ScoreText(int secondWorld){
        score[0] = score[1] = 0;
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
        text = "Score: " + score[0]+ score[1];
        
        setImage(new GreenfootImage(text, 18, new Color(255, 255, 255), new Color(0, 0, 0)));
    } 
    
    /**
     * Devolve o score
     *//*
    public int getScore(){
        return score;
    }*/
}
