/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sega;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import objects.Player;
import sega.BufferedImageLoader;

/**
 *
 * @author druger
 */
public class Hud {
    
    private Player player;
    
    private int health; //попытки
    private int helper; //помощник
    private int money;
    private int shpora;
    
    private BufferedImage liv, mon, shpr, help;
    public Font font;
    
    public Hud(Player p){
        player = p;
        
        health = 4;
        money = 0;
        helper = 0;
        shpora = 4;
       
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            liv = loader.loadImage("/res/HUD/live.png");
            mon = loader.loadImage("/res/HUD/money.png");
            shpr = loader.loadImage("/res/HUD/shpora.png");
            help = loader.loadImage("/res/HUD/helper.png");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public int getHealth(){ return health;}
    public int getHelper() { return helper;}
    public int getMoney() { return money;}
    public int getShpora() { return shpora;}

    public void render(Graphics g) {
        font = new Font("Arial", Font.PLAIN, 20);
        g.drawImage(mon, 760, 565, null);
        g.drawImage(liv, 10, 575, null);
        g.drawImage(shpr, 45, 50, null);
        g.drawImage(help, 40, 100, null);
        g.setFont(font);
        g.setColor(Color.blue);
        g.drawString( "x " + health, 45, 595);
        g.drawString("x " + helper, 95, 115);
        g.drawString("x " + shpora, 95, 75);
        g.drawString(money + " x", 730, 595);
    }

}
