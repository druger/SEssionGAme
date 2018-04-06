//атака игроком

package objects;

import framework.GameObject;
import framework.ObjectId;
import framework.SpriteList;
import sega.BufferedImageLoader;
import sega.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

import static sega.Const.Sprite.BULLET;

public class Bullet extends GameObject {

    private Handler handler;
    
    private SpriteList bul;
    
    private BufferedImage bullet_list;
    private BufferedImage[] bullet = new BufferedImage[2];

    public Bullet(float x, float y, Handler handler, ObjectId id, int velX) {
        super(x, y, id);
        this.velX = velX;
        
        this.handler = handler;
        
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            bullet_list = loader.loadImage(BULLET);
        }catch(Exception e){
            e.printStackTrace();
        }
        bul = new SpriteList(bullet_list);
        
        bullet[0] = bul.grabImage(1, 1, 50, 20);
        bullet[1] = bul.grabImage(2, 1, 50, 20);
    }

    @Override
    public void tick(List<GameObject> object) {
        x += velX;
        
        for(int i = 0; i<handler.object.size(); i++ ){
          GameObject tempObject = handler.object.get(i);

          if(tempObject.getId() == ObjectId.BULLET){
              if((tempObject.getX() < 0) || (tempObject.getX() > 2305)){
                  handler.removeObject(tempObject);
              }
          }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        if(direction == 1){
            g.drawImage(bullet[0], (int)x, (int)y, 35, 10, null); 
        }
        if(direction == -1){
              g.drawImage(bullet[1], (int)x, (int)y, 35, 10, null);  
        }  
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 50, 20);
    }
    
}
