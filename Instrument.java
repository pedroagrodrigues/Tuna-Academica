import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instrument here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instrument extends Actor
{
    // Declaração de Variáveis
    
    /**
     * Método que Cria um Instrumento a Ser Colocado no Mundo.
     */
    public Instrument(int worldWidth)
    {
        defineInstrument(setType(), worldWidth);
    }
    
     /**
     * Act - do whatever the Instrument wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       setLocation(getX(), getY() + 2);
       destroyInstrument();
    }
    
    /**
     * Criação Instrumentos: Definição de Imagem e Pontuação.
     */
    private void defineInstrument(int type, int worldWidth)
    {
        switch (type){
            case 1: 
                setImage(new GreenfootImage("Guitar.png"));
                getImage().scale(worldWidth/15, worldWidth/22);
                break;
            case 2: 
                setImage(new GreenfootImage("Guitar2.png"));
                getImage().scale(worldWidth/15, worldWidth/22);
                break;
            case 3: 
                setImage(new GreenfootImage("Castanets.png"));
                getImage().scale(worldWidth/14, worldWidth/20);
                break;  
            case 4: 
                setImage(new GreenfootImage("Maracas.png"));
                getImage().scale(worldWidth/14, worldWidth/20);
                break;
           
       }
    }
    
    /**
     * Método que Define a Probalidade para Cada Tipo De Instrumento Criado.
     */
    private int setType()
    {
        int result = Greenfoot.getRandomNumber(100);
        if (result < 25) result = 1;
        else if (result > 25 && result < 50) result = 2;
             else if (result > 50 && result < 75) result = 3;
        else result = 4;
        return result;
    }
    
    /**
     * Eliminação do Instrumento no Fim do Mundo, e Eliminação de Sobreposições Entre Intrumentos.
     */
    private void destroyInstrument()
    {
        if (getY() == getWorld().getHeight()-1 || isTouching(Instrument.class))
            getWorld().removeObject(this);
        
    }
}
