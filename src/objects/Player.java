package objects;

import audio.AudioPlayer;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;
import sega.Animation;
import sega.Game;
import sega.Handler;

import java.awt.*;
import java.util.HashMap;
import java.util.List;

import static sega.Const.Game.JUMP_MUSIC;

public class Player extends GameObject {

    private float width = 55;
    private float height = 172;

    private float gravity = 0.4f;
    private static final float MAX_SPEED = 10;

    private Handler handler;

    private Texture tex = Game.getInstance();

    private Animation playerWalk;
    private Animation playerWalkLeft;
    private Animation playerGunWalk;
    private Animation playerGunWalkLeft;

    private HashMap<String, AudioPlayer> sfx;

    public Player(float x, float y, Handler handler, ObjectId id) {
        super(x, y, id);

        this.handler = handler;

        playerWalk = new Animation(10, tex.player[1], tex.player[2], tex.player[3]);
        playerWalkLeft = new Animation(10, tex.player[4], tex.player[5], tex.player[6]);

        playerGunWalk = new Animation(10, tex.playerGun[1], tex.playerGun[2], tex.playerGun[3]);
        playerGunWalkLeft = new Animation(10, tex.playerGun[4], tex.playerGun[5], tex.playerGun[6]);

        sfx = new HashMap<>();
        sfx.put("jump", new AudioPlayer(JUMP_MUSIC));
    }

    @Override
    public void tick(List<GameObject> object) {
        x += velX;
        y += velY;

        changeDirection();
        checkBorder();
        collision();
        runAnimation();
    }

    private void runAnimation() {
        playerWalk.runAnimation();
        playerWalkLeft.runAnimation();
        playerGunWalk.runAnimation();
        playerGunWalkLeft.runAnimation();
    }

    private void checkBorder() {
        if (x < 5) x = 5;
        if (x > 1885) x = 1885;

        if (falling || jumping) {
            velY += gravity;
            if (velY > MAX_SPEED)
                velY = MAX_SPEED;
        }
    }

    private void changeDirection() {
        if (velX < 0) direction = -1;
        else if (velX > 0) direction = 1;
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ObjectId.BLOCK) {
                checkCollisionDown(tempObject);
                checkCollisionRight(tempObject);
                checkCollisionLeft(tempObject);
            } else if (tempObject.getId() == ObjectId.FLAG) {
                switchLevel(tempObject);
            }
        }
    }

    private void switchLevel(GameObject tempObject) {
        if (getBounds().intersects(tempObject.getBounds())) {
            x = tempObject.getX() - 46;
            handler.switchLevel();
        }
    }

    private void checkCollisionLeft(GameObject tempObject) {
        if (getBoundsLeft().intersects(tempObject.getBounds())) {
            x = tempObject.getX() + 28;
        }
    }

    private void checkCollisionRight(GameObject tempObject) {
        if (getBoundsRight().intersects(tempObject.getBounds())) {
            x = tempObject.getX() - 46;
        }
    }

    private void checkCollisionDown(GameObject tempObject) {
        if (getBounds().intersects(tempObject.getBounds())) {
            y = tempObject.getY() - height;
            velY = 0;
            falling = false;
            jumping = false;
        } else
            falling = true;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        if (jumping) {
            playSound();
            drawJumpingPlayer(g);
        } else {
            if (velX != 0) {
                drawWalkingPlayer(g);
            } else {
                drawPlayer(g);
            }
        }
    }

    private void drawPlayer(Graphics g) {
        if (direction == 1 || direction == -1) {
            if (id == ObjectId.PLAYER) {
                g.drawImage(tex.player[0], (int) x, (int) y, 110, 172, null);
            }
            if (id == ObjectId.PLAYER_GUN) {
                g.drawImage(tex.playerGun[0], (int) x, (int) y, 130, 172, null);
            }
        }
    }

    private void drawWalkingPlayer(Graphics g) {
        if (direction == 1) {
            if (id == ObjectId.PLAYER) {
                playerWalk.drawAnimation(g, (int) x, (int) y);
            }
            if (id == ObjectId.PLAYER_GUN) {
                playerGunWalk.drawAnimation(g, (int) x, (int) y);
            }
        } else {
            if (id == ObjectId.PLAYER) {
                playerWalkLeft.drawAnimation(g, (int) x, (int) y);
            }
            if (id == ObjectId.PLAYER_GUN) {
                playerGunWalkLeft.drawAnimation(g, (int) x, (int) y);
            }
        }
    }

    private void drawJumpingPlayer(Graphics g) {
        if (direction == 1) {
            if (id == ObjectId.PLAYER) {
                g.drawImage(tex.playerJump[0], (int) x, (int) y, 90, 172, null);
            }
            if (id == ObjectId.PLAYER_GUN) {
                g.drawImage(tex.playerGunJump[0], (int) x, (int) y, 100, 168, null);
            }
        } else if (direction == -1) {
            if (id == ObjectId.PLAYER) {
                g.drawImage(tex.playerJump[1], (int) x, (int) y, 90, 172, null);
            }
            if (id == ObjectId.PLAYER_GUN) {
                g.drawImage(tex.playerGunJump[1], (int) x, (int) y, 100, 168, null);
            }
        }
    }

    private void playSound() {
        sfx.get("jump").play();
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) ((int) x + (width / 2) - (width / 2) / 2), (int) ((int) y + (height / 2)), (int) width / 2, (int) height / 2);
    }

    private Rectangle getBoundsRight() {
        return new Rectangle((int) ((int) x + width - 5), (int) y + 5, 5, (int) height - 10);
    }

    private Rectangle getBoundsLeft() {
        return new Rectangle((int) x, (int) y + 5, 5, (int) height - 10);
    }
}
