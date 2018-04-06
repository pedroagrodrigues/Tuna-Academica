import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class UIBar extends Actor{
    /**
     * Cria uma barra justa ao mundo para aspecto visual do jogo.
     */
    public UIBar(int worldWidth){
        getImage().scale(worldWidth, getImage().getHeight()/3);
    }
}
