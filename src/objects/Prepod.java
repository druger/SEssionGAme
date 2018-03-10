
package objects;

import framework.GameObject;
import framework.ObjectId;
import framework.Texture;
import sega.Animation;
import sega.Game;
import sega.Handler;

import java.awt.*;
import java.util.LinkedList;

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
        
        prepodPrgWalk = new Animation(10, tex.prepodPrg[0], tex.prepodPrg[1], tex.prepodPrg[2], tex.prepodPrg[3]);
        prepodPrgWalkLeft = new Animation(10, tex.prepodPrg[4], tex.prepodPrg[5], tex.prepodPrg[6], tex.prepodPrg[7]);
        
        prepodEngWalk = new Animation(10, tex.prepodEng[0], tex.prepodEng[1], tex.prepodEng[2], tex.prepodEng[3]);
        prepodEngWalkLeft = new Animation(10, tex.prepodEng[4], tex.prepodEng[5], tex.prepodEng[6], tex.prepodEng[7]);
        
        prepodMatWalk = new Animation(10, tex.prepodMatan[0], tex.prepodMatan[1], tex.prepodMatan[2], tex.prepodMatan[3], tex.prepodMatan[4]);
        prepodMatWalkLeft = new Animation(10, tex.prepodMatan[5], tex.prepodMatan[6], tex.prepodMatan[7], tex.prepodMatan[8], tex.prepodMatan[9]);
        
        prepodFizWalk = new Animation(10, tex.prepodFizika[0], tex.prepodFizika[1], tex.prepodFizika[2], tex.prepodFizika[3]);
        prepodFizWalkLeft = new Animation(10, tex.prepodFizika[4], tex.prepodFizika[5], tex.prepodFizika[6], tex.prepodFizika[7]);
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
        return new Rectangle((int)((int)x+width-5), (int)y+5, 5, (int)height-10);
    }
    public Rectangle getBoundsLeft() {
        return new Rectangle((int)x, (int)y+5, 5, (int)height-10);
    }
    
}
