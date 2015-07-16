
package sega;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Menu {
    
    private BufferedImage bgmenu;
    public Font font1, font2;
    
    public static int currentChoice = 0;
    public static String[] options = {
        "Начать сессию",
        "Опции",
        "Покинуть универ"
            
    };
    
    public Menu(){
    
    BufferedImageLoader loader = new BufferedImageLoader(); 
        try{
            bgmenu = loader.loadImage("/res/Menu/menu.png"); 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void render(Graphics g){
        g.drawImage(bgmenu, 0, 0, null);
        
        /*font1 = new Font("Arial", Font.BOLD, 50); 
        g.setFont(font1);
        g.setColor(Color.black);
        g.drawString("SEssion", Game.WIDTH/3, 100);
        g.drawString("GAme", Game.WIDTH/3, 400);*/
        
        //draw menu options
        font2 = new Font("Arial", Font.BOLD, 24);  
        g.setFont(font2);
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
