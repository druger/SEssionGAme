
package sega;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Menu {
    
    private BufferedImage bgmenu;
    private Font font;
    
    public static int currentChoice = 0;
    public static String[] options = {
        "Начать сессию",
        "Опции",
        "Покинуть универ"
            
    };
    
    public Menu(){

        loadImage();
    }

    private void loadImage() {
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            bgmenu = loader.loadImage("/res/Menu/menu.png");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void render(Graphics g){
        g.drawImage(bgmenu, 0, 0, null);

        font = new Font("Arial", Font.BOLD, 24);
        g.setFont(font);
        for(int i=0; i < options.length; i++){
            if(i == currentChoice){
                g.setColor(Color.black);
            }
            else{
                g.setColor(Color.orange);
            }
            g.drawString(options[i], Game.WIDTH/3, 255 + i*30);
        }
    }
}
