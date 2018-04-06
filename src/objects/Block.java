package objects;

import framework.GameObject;
import framework.ObjectId;
import framework.Texture;
import sega.Game;

import java.awt.*;
import java.util.List;

public class Block extends GameObject {

    private Texture tex = Game.getInstance();
    private int type;

    public Block(float x, float y, int type, ObjectId id) {
        super(x, y, id);
        this.type = type;
    }

    @Override
    public void tick(List<GameObject> object) {
        
    }

    @Override
    public void render(Graphics g) {
        
        if(type == 1) {
            g.drawImage(tex.block[0], (int) x, (int) y, null);
        }
        if(type == 2) {
            g.drawImage(tex.block[1], (int) x, (int) y, null);
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 96, 32);
    }
    
}
