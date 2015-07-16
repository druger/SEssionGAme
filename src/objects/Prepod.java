
package objects;

import framework.GameObject;
import framework.ObjectId;
import framework.Texture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import sega.Animation;
import sega.Game;
import sega.Handler;

public class Prepod extends GameObject {
    
    private float width = 50, height = 80;
    
    private Handler handler;
    
    Texture tex = Game.getInstance();
    private int type;
    
    private Animation prepodPrgWalk, prepodPrgWalkLeft, prepodEngWalk, prepodEngWalkLeft, prepodMatWalk, prepodMatWalkLeft, prepodFizWalk, prepodFizWalkLeft ;

    public Prepod(float x, float y, Handler handler, int type, ObjectId id) {
        super(x, y, id);
        this.handler = handler;
        this.type = type;
        
        prepodPrgWalk = new Animation(10, tex.prepod_prg[0], tex.prepod_prg[1], tex.prepod_prg[2], tex.prepod_prg[3]);
        prepodPrgWalkLeft = new Animation(10, tex.prepod_prg[4], tex.prepod_prg[5], tex.prepod_prg[6], tex.prepod_prg[7]);
        
        prepodEngWalk = new Animation(10, tex.prepod_eng[0], tex.prepod_eng[1], tex.prepod_eng[2], tex.prepod_eng[3]);
        prepodEngWalkLeft = new Animation(10, tex.prepod_eng[4], tex.prepod_eng[5], tex.prepod_eng[6], tex.prepod_eng[7]);
        
        prepodMatWalk = new Animation(10, tex.prepod_matan[0], tex.prepod_matan[1], tex.prepod_matan[2], tex.prepod_matan[3], tex.prepod_matan[4]);
        prepodMatWalkLeft = new Animation(10, tex.prepod_matan[5], tex.prepod_matan[6], tex.prepod_matan[7], tex.prepod_matan[8], tex.prepod_matan[9]);
        
        prepodFizWalk = new Animation(10, tex.prepod_fizika[0], tex.prepod_fizika[1], tex.prepod_fizika[2], tex.prepod_fizika[3]);
        prepodFizWalkLeft = new Animation(10, tex.prepod_fizika[4], tex.prepod_fizika[5], tex.prepod_fizika[6], tex.prepod_fizika[7]);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        velX = 1;
        x = x + 1 * facing;
        
        //смена направления препода
        if((x > 1470) || (x<840)){
            facing *= -1;
        }
        
        prepodPrgWalk.runAnimation();
        prepodPrgWalkLeft.runAnimation();

        prepodEngWalk.runAnimation();
        prepodEngWalkLeft.runAnimation();
        
        prepodMatWalk.runAnimation();
        prepodMatWalkLeft.runAnimation();
        
        prepodFizWalk.runAnimation();
        prepodFizWalkLeft.runAnimation();
    }

    @Override
    public void render(Graphics g) {
        //g.setColor(Color.green);
        
        if(velX != 0){
            if(facing == 1){
                if(type == 1){
                   prepodMatWalk.drawAnimation(g, (int)x, (int)y/*, 69, 100*/);
                }
                if(type == 2){
                    prepodPrgWalk.drawAnimation(g, (int)x, (int)y/*, 70, 100*/);
                }
                if(type == 3){
                    prepodFizWalk.drawAnimation(g, (int)x, (int)y/*, 71, 100*/);
                }
                if(type == 4){
                    prepodEngWalk.drawAnimation(g, (int)x, (int)y/*, 71, 100*/);
                }
            }
            else{
                if(type ==1){
                     prepodMatWalkLeft.drawAnimation(g, (int)x, (int)y/*, 69, 100*/);
                }
                if(type == 2){
                    prepodPrgWalkLeft.drawAnimation(g, (int)x, (int)y/*, 70, 100*/);
                }
                if(type == 3){
                    prepodFizWalkLeft.drawAnimation(g, (int)x, (int)y/*, 71, 100*/);
                }
                if(type == 4){
                    prepodEngWalkLeft.drawAnimation(g, (int)x, (int)y/*, 70, 100*/);
                }
            }
        } 
    }
    

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)((int)x+(width/2)-(width/2)/2), (int)((int)y+(height/2)), (int)width/2, (int)height/2);
    }
    public Rectangle getBoundsTop() {
        return new Rectangle((int)((int)x+(width/2)-(width/2)/2), (int)y, (int)width/2, (int)height/2);
    }
    public Rectangle getBoundsRight() {
        return new Rectangle((int)((int)x+width-5), (int)y+5, (int)5, (int)height-10);
    }
    public Rectangle getBoundsLeft() {
        return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
    }
    
}
