//флаг,для перехода на новый уровень

package objects;

import framework.GameObject;
import framework.ObjectId;
import framework.SpriteList;
import framework.Texture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import sega.BufferedImageLoader;
import sega.Game;

public class Flag extends GameObject{
    
    SpriteList fl;
    //Texture tex = Game.getInstance();
    
    private BufferedImage flag = null;

    public Flag(float x, float y, ObjectId id) {
        super(x, y, id);
        
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            flag = loader.loadImage("/res/Sprites/next.png");
        }catch(Exception e){
            e.printStackTrace();
        }
        fl = new SpriteList(flag);
        flag = fl.grabImage(1, 1, 100, 100);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        
    }

    @Override
    public void render(Graphics g) {
        //g.setColor(Color.yellow);
        //g.fillRect((int)x, (int)y, 32, 32);
        //g.drawImage(tex.flag[0], (int)x, (int)y, 100, 100, null);
        g.drawImage(flag, (int)x, (int)y, 100, 100, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 100, 100);
    }
    
}
