import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;   //(Screensize and Dimensions)
import java.awt.Dimension;

public class TwoPlayers extends World
{
    // Declaração de Variáveis 
        
    /**
     * Constructor Para Objectos da Classe MyWorld.
     */
    public TwoPlayers()
    {    
        // Cria um Mundo Com Metade do Tamanho do Ecrã, Dinamicamente Para Qualquer Ecrã.
        super((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3,
        (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.5), 1);
        objectSpawn();
    }
    
    /**
     *  Método Para Posicionar Objectos no Mundo.
     */
    public void objectSpawn()
    {
        // Adicionar "Barra" no Centro do Mundo.
        addObject(new UIBar(getHeight()), getWidth()/2, getHeight()/2);
    }
}
