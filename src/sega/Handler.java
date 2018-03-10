package sega;

import framework.GameObject;
import framework.ObjectId;
import objects.Block;
import objects.Flag;
import objects.Player;
import objects.Prepod;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 *
 * обработчик объектов
 */
public class Handler {
    
    public LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    private GameObject tempObject;
    
    private Camera cam;
    
    private BufferedImage level1 = null, level2 = null, level3 = null, level4 = null, level5 = null;
    
    public Handler(Camera cam){
        this.cam = cam;
        
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
        level1 = loader.loadImage("/res/Levels/level1.png");
        level2 = loader.loadImage("/res/Levels/level2.png");
        level3 = loader.loadImage("/res/Levels/level3.png");
        level4 = loader.loadImage("/res/Levels/level4.png");
        level5 = loader.loadImage("/res/Levels/level5.png");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void tick(){ 
        for(int i=0; i<object.size(); i++){
            tempObject = object.get(i);
            
            tempObject.tick(object);
        }
    }
    
    public void render(Graphics g){
        
         for(int i=0; i<object.size(); i++){
            tempObject = object.get(i);
           
            tempObject.render(g);
            }
           
    }
    
    public void LoadImageLevel(BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();
        
        System.out.println("width, height: " +w +" " +h);
        
        //получаем каждый пиксель изображения
        for(int xx=0; xx<h; xx++){
            for(int yy=0; yy<w; yy++){
               int pixel = image.getRGB(xx, yy);
               int red = (pixel >> 16) & 0xff;
               int green = (pixel >> 8) & 0xff;
               int blue = (pixel) & 0xff;
               
               //получаем дороги
               if(red == 255 && green == 255 && blue == 255) addObject(new Block(xx*32, yy*32, 1, ObjectId.BLOCK));//дорога_иатэ
               if(red == 255 && green == 0 && blue == 255) addObject(new Block(xx*32, yy*32, 2, ObjectId.BLOCK));//дорога_кабинет
               //получаем игрока
               if(red == 0 && green == 0 && blue == 255) addObject(new Player(xx*32, yy*32, /*1,*/ this, cam, ObjectId.PLAYER));
               if(red == 0 && green == 127 && blue == 14) addObject(new Player(xx*32, yy*32, /*2,*/ this, cam, ObjectId.PLAYER_GUN));//игрок с автоматом
               //получаем препода
               if(red == 90 && green == 255 && blue == 240) addObject(new Prepod(xx*32, yy*32, this, 1, ObjectId.TEACHER));//матан
               if(red == 0 && green == 255 && blue == 0) addObject(new Prepod(xx*32, yy*32, this, 2, ObjectId.TEACHER));//прг
               if(red == 255 && green == 190 && blue == 0) addObject(new Prepod(xx*32, yy*32, this, 3, ObjectId.TEACHER));//fizika
               if(red == 255 && green == 160 && blue == 60) addObject(new Prepod(xx*32, yy*32, this, 4, ObjectId.TEACHER));//eng
             
               if(red == 255 && green == 255 && blue == 0) addObject(new Flag(xx*32, yy*32, ObjectId.FLAG));
                   
            }
        }
    }
    
    public void switchLevel(){
        clearLevel();
        cam.setX(0);
        
        switch(Game.LEVEL){
            case 0:
                LoadImageLevel(level1);
                break;
            case 1:
               LoadImageLevel(level2);
               break;
            case 2:
                LoadImageLevel(level3);
                break;
            case 3:
                LoadImageLevel(level4);
                break;
            case 4:
                LoadImageLevel(level5);
                break;
        }
        Game.LEVEL++;
    }
    
    private void clearLevel(){
        object.clear();
    }
    
    public void addObject(GameObject object){
        this.object.add(object);
    }
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
   
}
