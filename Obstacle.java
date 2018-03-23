import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Obstacle extends Actor
{
    // Declaração de Variáveis

    /**
     * Construtor: Cria Os Obstáculos a Serem Colocados no Mundo.
     */
    public Obstacle(int worldWidth)
    {
        defineObstacle(setType(), worldWidth);
    }
    
     /**
     * Act - do whatever the Obstacle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       setLocation(getX(), getY() + 2);
       destroyObstacle();
    }
    
    /**
     * Criação Obstáculo: Definição de Imagem e Pontuação.
     */
    private void defineObstacle(int type, int worldWidth)
    {
        switch (type){
            case 1: 
                setImage(new GreenfootImage("Box.png"));
                getImage().scale(worldWidth/15, worldWidth/25);
                break;
            case 2: 
                setImage(new GreenfootImage("Chair.png"));
                getImage().scale(worldWidth/17, worldWidth/12);
                break;
            case 3: 
                setImage(new GreenfootImage("Table.png"));
                getImage().scale(worldWidth/14, worldWidth/20);
                break;  
            
       }
    }
    
    /**
     *  Método que Define a Probalidade para Cada Tipo De Obstáculo Criado.
     */
    private int setType()
    {
        int result = Greenfoot.getRandomNumber(100);
        if (result < 25) result = 1;
        else if (result > 25 && result < 50) result = 2;
             else result = 3;
        return result;
    }
    
    /**
     * Eliminação do Obstáculo no Fim do Mundo, e Eliminação de Sobreposições Entre Intrumentos e Obstáculos.
     */
    private void destroyObstacle()
    {
        if (getY() == getWorld().getHeight()-1 || isTouching(Instrument.class) || isTouching(Obstacle.class))
            getWorld().removeObject(this);
    }
}
