import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;   //(Screensize and Dimensions)

public class MyWorld extends World
{

        
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
     //Dimension windowSize = window.getSize();
    public MyWorld()
    {    
        //Create a world that is half of the screen size, dynamic for every screen (TO TEST)
        super((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,
        (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2, 1);
              
        //Debug
        System.out.println("Debug: World Dimensiions = (" + getWidth()+","+ getHeight()+")");
      
        
        //super(Dimension.window.getSize().getWidth(), GraphicsConfiguration.getBounds().getWidth(), 1);
        objectSpawn();
    }
    /**
     *  Método Para Posicionar Objectos no Mundo
     */
 
    public void objectSpawn()
    {
        // Adicionar "Division" no Centro do Mundo
        addObject(new Division(getHeight()), getWidth()/2, getHeight()/2);
    }
}
