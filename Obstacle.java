import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Obstaculos criados para que o jogador tenha que se desviar
 * o jogador perde se tocar num destes
 */

public class Obstacle extends Actor
{
    /**
     * Construtor: Cria Os Obstáculos a Serem Colocados no Mundo.
     */
    public Obstacle(int worldWidth)
    {
        defineObstacle(setType(), worldWidth);
    }
    
     /**
     * Faz o objecto se deslocar e ser destruido quando este chega
     * ao fim do mundo. 
     */
    public void act() 
    {
       setLocation(getX(), getY() + 2);
       destroyObstacle();
    }
    
    /**
     * defineObstacle define qual a imagem a colocar no objecto criado
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
        if (result < 33) result = 1;
        else if (result > 33 && result < 66) result = 2;
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
