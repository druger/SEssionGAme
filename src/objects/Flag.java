//флаг,для перехода на новый уровень

package objects;

import framework.GameObject;
import framework.ObjectId;
import framework.SpriteList;
import sega.BufferedImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

import static sega.Const.Sprite.NEXT_LEVEL;

public class Flag extends GameObject{

    private SpriteList fl;
    private BufferedImage flag;

    public Flag(float x, float y, ObjectId id) {
        super(x, y, id);
        
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            flag = loader.loadImage(NEXT_LEVEL);
        }catch(Exception e){
            e.printStackTrace();
        }
        fl = new SpriteList(flag);
        flag = fl.grabImage(1, 1, 100, 100);
    }

    @Override
    public void tick(List<GameObject> object) {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(flag, (int)x, (int)y, 100, 100, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 100, 100);
    }
    
}
