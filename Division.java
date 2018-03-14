import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Division here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Division extends Actor
{
    /**
     * Act - do whatever the Division wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }   
    
    /**
     * Método Para "Comprimir" de Maneira a ter uma Divisão Adequeada
     */
    
 
    public Division() //fazer uma imagem que se parece mais com uma barreira fina
    {
        //imageBrick = getImage();
        //int larguraAtual = imageBrick.getWidth();
        //int alturaAtual = imageBrick.getHeight();
        // int height = getWorld().getHeight() - 100;
        getImage().scale(getImage().getWidth()/6, 600); // Falar com a prof de maneira a obter a altura do mundo
    }
}
