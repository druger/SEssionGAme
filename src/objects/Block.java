package objects;

import framework.GameObject;
import framework.ObjectId;
import framework.Texture;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import sega.Game;

public class Block extends GameObject {
    
    Texture tex = Game.getInstance();
    private int type;

    public Block(float x, float y, int type, ObjectId id) {
        super(x, y, id);
        this.type = type;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        
    }

    @Override
    public void render(Graphics g) {
        
        if(type == 1) //дорога_иатэ
            g.drawImage(tex.block[0], (int)x, (int)y, null);
        if(type == 2) //дорога_кабинет
            g.drawImage(tex.block[1], (int)x, (int)y, null);
     
        /*g.setColor(Color.blue);
        //g.fillRect((int)x, (int)y, 32, 32);//заливка прямоугольника
        g.drawRect((int)x, (int)y, 32, 32);//Рисует контур заданного прямоугольника*/
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 96, 32);
    }
    
}
