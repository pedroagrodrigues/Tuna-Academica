import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;   //(Screensize and Dimensions)
import java.awt.Dimension;

public class StartMenu extends World
{
    // Declaração de Variáveis
    GreenfootImage background;
    /**
     * Cria um mundo onde vamos ter as opçoes de jogo
     */
    public StartMenu()
    {    
       // Define o Tamanho do super de Acordo com a Resolução do Ecrã.
        super((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3,
        (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.5), 1);
        background = new GreenfootImage("MenuBackground.png");
        background.scale(getWidth(), getHeight());
        getBackground().drawImage(background, 0,0);
                
        objectSpawn();
    }
    
    /**
     * Posiciona Opções "Clicáveis" no Mundo.
     */
    private void objectSpawn()
    {
        addObject(new Button(0, getHeight()), (int)(getWidth()/4), 100);
        addObject(new Button(1, getHeight()), (int) ((getWidth()/2)+(getWidth()/3)), 100);
        addObject(new Button(2, getHeight()), (int) (getWidth()/5), (int)(getHeight()-100));
    }
}
