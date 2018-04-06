import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/*
 * A class Instrument tem como objectivo definir tudo o que é comum entre os insturmentos
 * bem como a probabilidade de cada um ser criado.
 */

public class Instrument extends Actor{
    /**
     * Desloca o objeto na vertical e destoi-o no fim do mundo
     */
    public void act(){
       setLocation(getX(), getY() + 2);
       destruction();
    } 
    /**
     * destruction elemina o Instrumento no Fim do Mundo, e Eliminação de Sobreposições Entre Intrumentos.
     */
    private void destruction()
    {
        if (getY() == getWorld().getHeight()-1 || isTouching(Instrument.class))
            getWorld().removeObject(this);
        
    }
}
