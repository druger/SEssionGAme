
package objects;

import framework.GameObject;
import framework.ObjectId;
import framework.Texture;
import sega.Animation;
import sega.Game;

import java.awt.*;
import java.util.List;

public class Prepod extends GameObject {

    private float width = 50;
    private float height = 80;

    private Texture tex = Game.getInstance();
    private int type;

    private Animation prepodPrgWalk;
    private Animation prepodPrgWalkLeft;
    private Animation prepodEngWalk;
    private Animation prepodEngWalkLeft;
    private Animation prepodMatWalk;
    private Animation prepodMatWalkLeft;
    private Animation prepodFizWalk;
    private Animation prepodFizWalkLeft;

    public Prepod(float x, float y, int type, ObjectId id) {
        super(x, y, id);
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
    public void tick(List<GameObject> object) {
        velX = 1;
        x = x + direction;

        changeDirection();
        runAnimation();
    }

    private void runAnimation() {
        prepodPrgWalk.runAnimation();
        prepodPrgWalkLeft.runAnimation();

        prepodEngWalk.runAnimation();
        prepodEngWalkLeft.runAnimation();

        prepodMatWalk.runAnimation();
        prepodMatWalkLeft.runAnimation();

        prepodFizWalk.runAnimation();
        prepodFizWalkLeft.runAnimation();
    }

    private void changeDirection() {
        if ((x > 1470) || (x < 840)) {
            direction *= -1;
        }
    }

    @Override
    public void render(Graphics g) {

        if (velX != 0) {
            if (direction == 1) {
                drawToRight(g);
            } else {
                drawToLeft(g);
            }
        }
    }

    private void drawToLeft(Graphics g) {
        if (type == 1) {
            prepodMatWalkLeft.drawAnimation(g, (int) x, (int) y);
        }
        if (type == 2) {
            prepodPrgWalkLeft.drawAnimation(g, (int) x, (int) y);
        }
        if (type == 3) {
            prepodFizWalkLeft.drawAnimation(g, (int) x, (int) y);
        }
        if (type == 4) {
            prepodEngWalkLeft.drawAnimation(g, (int) x, (int) y);
        }
    }

    private void drawToRight(Graphics g) {
        if (type == 1) {
            prepodMatWalk.drawAnimation(g, (int) x, (int) y);
        }
        if (type == 2) {
            prepodPrgWalk.drawAnimation(g, (int) x, (int) y);
        }
        if (type == 3) {
            prepodFizWalk.drawAnimation(g, (int) x, (int) y);
        }
        if (type == 4) {
            prepodEngWalk.drawAnimation(g, (int) x, (int) y);
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) ((int) x + (width / 2) - (width / 2) / 2), (int) ((int) y + (height / 2)), (int) width / 2, (int) height / 2);
    }
}
