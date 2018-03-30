import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/*
 * A class Instrument tem como objectivo definir tudo o que é comum entre os insturmentos
 * bem como a probabilidade de cada um ser criado.
 */

public class Instrument extends Actor{
    /**
     * Contrutor de Instrumentos, a altura recebida é comum em todos os mundos
     * e com esta conseguimos formatar as imagens para o tamanho pretendido.
     */
    
    public void act(){
       setLocation(getX(), getY() + 2);
       destruction();
    }
    /*
     * makeType gera um numero entre 1 e 4 e guarda-o na nossa variável type
     */
   
    
    
    /**
     * destruction elemina o Instrumento no Fim do Mundo, e Eliminação de Sobreposições Entre Intrumentos.
     */
    private void destruction()
    {
        if (getY() == getWorld().getHeight()-1 || isTouching(Instrument.class))
            getWorld().removeObject(this);
        
    }
}
