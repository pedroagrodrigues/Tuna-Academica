import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreText extends Actor
{
    private String text; 
    public ScoreText(int score){
        text = "Score: " + score;
        setImage(new GreenfootImage(text, 18, new Color(255, 255, 255), new Color(0, 0, 0)));
        
    }
    
    
    public void act(){
        
        text = "Score: " + getWorldOfType(OnePlayer.class).getScore();
        setImage(new GreenfootImage(text, 18, new Color(255, 255, 255), new Color(0, 0, 0)));
    }
}
