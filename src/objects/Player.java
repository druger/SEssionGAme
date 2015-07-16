package objects;

import audio.AudioPlayer;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.LinkedList;
import sega.Animation;
import sega.Camera;
import sega.Game;
import sega.Handler;

public class Player extends GameObject {

    private float width = 55, height = 172;//расположение игрока
    
    //hud
    /*private int health; //попытки
    private int helper; //помощник
    private int money;
    private int shpora;*/
    //
    
    private float gravity = 0.4f;//скорость падения
    private final float MAX_SPEED = 10;
   
    private Handler handler;
    private Camera cam;
   
    Texture tex = Game.getInstance();
    private int type;
    
    private Animation playerWalk, playerWalkLeft, playerGunWalk, playerGunWalkLeft;
    
    private HashMap<String, AudioPlayer> sfx;
    
    public Player(float x, float y, /*int type,*/ Handler handler, Camera cam, ObjectId id) {
        super(x, y, id);
        this.type = type;
        /*this.shpora = 4;
        this.money = 0;
        this.helper = 0;
        this.health = 4;*/
      
        this.handler = handler;
        this.cam = cam;
        
        playerWalk = new Animation(10, tex.player[1], tex.player[2], tex.player[3]);
        playerWalkLeft = new Animation(10, tex.player[4], tex.player[5], tex.player[6]);
        
        playerGunWalk = new Animation(10, tex.playerGun[1], tex.playerGun[2], tex.playerGun[3]);
        playerGunWalkLeft = new Animation(10, tex.playerGun[4], tex.playerGun[5], tex.playerGun[6]);
        
        sfx = new HashMap<String, AudioPlayer>();
        sfx.put("jump", new AudioPlayer("/res/SFX/jump.mp3"));
    }
    
    /*public int getHealth(){ return health;}
    public int getHelper() { return helper;}
    public int getMoney() { return money;}
    public int getShpora() { return shpora;}*/

    @Override
    public void tick(LinkedList<GameObject> object) {
        x+= velX;//движение
        y+= velY;//падение
        
        // напраление
        if(velX < 0) facing = -1;
        else if(velX > 0) facing =1;
        
        //проверка ухода за пределы игровой области
        if(x < 5) x = 5;
        if(x > 1885) x = 1885;
        
        if(falling || jumping){
            velY+= gravity;
            if(velY > MAX_SPEED)
                velY = MAX_SPEED;
        }
        
        Collision(object);
        
        playerWalk.runAnimation();
        playerWalkLeft.runAnimation();
        playerGunWalk.runAnimation();
        playerGunWalkLeft.runAnimation();
    }
    
    public void Collision(LinkedList<GameObject> object){
        for(int i=0; i<handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId()==ObjectId.Block){
                //столкновение с объектом сверху
               /* if(getBoundsTop().intersects(tempObject.getBounds())){ //intersect-Определяет, пересекаются ли этот Прямоугольник и указанный Прямоугольник. Два прямоугольника пересекаются, если их пересечение не пусто.
                    y = tempObject.getY() + 35; 
                    velY = 0;
              
                }*/
                //столкновение с объектом снизу
                if(getBounds().intersects(tempObject.getBounds())){ 
                    y = tempObject.getY() - height;
                    velY = 0;
                    falling = false;
                    jumping = false;
                }else 
                    falling = true;
                
                //столкновение с объектом справа
                if(getBoundsRight().intersects(tempObject.getBounds())){ 
                    x = tempObject.getX() - 46; 
                }
                //столкновение с объектом слева
                if(getBoundsLeft().intersects(tempObject.getBounds())){ 
                    x = tempObject.getX() + 28;
                }
            } else if(tempObject.getId() == ObjectId.Flag){
                //switch level
                if(getBounds().intersects(tempObject.getBounds())){
                    x = tempObject.getX() - 46;
                    handler.switchLevel();
                }
                
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        if(jumping){
            sfx.get("jump").play();
            if(facing == 1){
                if(id == ObjectId.Player){
                    g.drawImage(tex.player_jump[0], (int)x, (int)y, 90, 172, null);
                }
                if(id == ObjectId.PlayerGun){
                    g.drawImage(tex.playerGun_jump[0], (int)x, (int)y, 100, 168, null);
                }
            }
            else 
                if(facing == -1){
                    if(id == ObjectId.Player){
                        g.drawImage(tex.player_jump[1], (int)x, (int)y, 90, 172, null);
                    }
                    if(id == ObjectId.PlayerGun){
                        g.drawImage(tex.playerGun_jump[1], (int)x, (int)y, 100, 168, null);
                    }
                }
        }else{
            //если игрок движется, изображение меняется, иначе неменяется
        if(velX != 0){
            if(facing ==1){
                if(id == ObjectId.Player){
                    playerWalk.drawAnimation(g, (int)x, (int)y/*, 90, 172*/);
                }
                if(id == ObjectId.PlayerGun){
                   playerGunWalk.drawAnimation(g, (int)x, (int)y/*, 140, 172*/); 
                }
            }
            else{
                if(id == ObjectId.Player){
                    playerWalkLeft.drawAnimation(g, (int)x, (int)y/*, 90, 172*/);
                }
                if(id == ObjectId.PlayerGun){
                   playerGunWalkLeft.drawAnimation(g, (int)x, (int)y/*, 115, 172*/); 
                }
            }
        }else{
            if(facing ==1){
                if(id == ObjectId.Player){
                    g.drawImage(tex.player[0],(int) x, (int)y, 110, 172, null);
                }
                if( id == ObjectId.PlayerGun){
                    g.drawImage(tex.playerGun[0], (int)x, (int)y, 130, 172, null);
                }
            }
            else
                if(facing == -1){
                    if(id == ObjectId.Player){
                        g.drawImage(tex.player[0],(int) x, (int)y, 110, 172, null);
                    }
                    if(id == ObjectId.PlayerGun){
                        g.drawImage(tex.playerGun[0], (int)x, (int)y, 130, 172, null);
                    }
                }
            }
        }
        
        //границы игрока
        /*Graphics2D g2d = (Graphics2D)g;
        g.setColor(Color.red);
        g2d.draw(getBounds());
        g2d.draw(getBoundsRight());
        g2d.draw(getBoundsLeft());
        g2d.draw(getBoundsTop());*/
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
