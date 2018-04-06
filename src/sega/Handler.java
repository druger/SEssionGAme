package sega;

import framework.GameObject;
import framework.ObjectId;
import objects.Block;
import objects.Flag;
import objects.Player;
import objects.Prepod;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import static sega.Const.Level.*;

public class Handler {

    public List<GameObject> object = new LinkedList<>();

    private GameObject tempObject;

    private Camera cam;

    private BufferedImage level1;
    private BufferedImage level2;
    private BufferedImage level3;
    private BufferedImage level4;
    private BufferedImage level5;

    public Handler(Camera cam) {
        this.cam = cam;
        loadImages();
    }

    private void loadImages() {
        BufferedImageLoader loader = new BufferedImageLoader();
        try {
            level1 = loader.loadImage(LEVEL1);
            level2 = loader.loadImage(LEVEL2);
            level3 = loader.loadImage(LEVEL3);
            level4 = loader.loadImage(LEVEL4);
            level5 = loader.loadImage(LEVEL5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            tempObject = object.get(i);
            tempObject.tick(object);
        }
    }

    public void render(Graphics g) {

        for (GameObject anObject : object) {
            tempObject = anObject;
            tempObject.render(g);
        }
    }

    public void loadImageLevel(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();

        System.out.println("width, height: " + w + " " + h);

        for (int xx = 0; xx < h; xx++) {
            for (int yy = 0; yy < w; yy++) {
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if (red == 255 && green == 255 && blue == 255)
                    addObject(new Block(xx * 32, yy * 32, 1, ObjectId.BLOCK));//дорога_иатэ
                if (red == 255 && green == 0 && blue == 255)
                    addObject(new Block(xx * 32, yy * 32, 2, ObjectId.BLOCK));//дорога_кабинет

                if (red == 0 && green == 0 && blue == 255)
                    addObject(new Player(xx * 32, yy * 32, this, ObjectId.PLAYER));
                if (red == 0 && green == 127 && blue == 14)
                    addObject(new Player(xx * 32, yy * 32, this, ObjectId.PLAYER_GUN));


                if (red == 90 && green == 255 && blue == 240)
                    addObject(new Prepod(xx * 32, yy * 32, 1, ObjectId.TEACHER));//матан
                if (red == 0 && green == 255 && blue == 0)
                    addObject(new Prepod(xx * 32, yy * 32, 2, ObjectId.TEACHER));//прг
                if (red == 255 && green == 190 && blue == 0)
                    addObject(new Prepod(xx * 32, yy * 32, 3, ObjectId.TEACHER));//fizika
                if (red == 255 && green == 160 && blue == 60)
                    addObject(new Prepod(xx * 32, yy * 32, 4, ObjectId.TEACHER));//eng

                if (red == 255 && green == 255 && blue == 0) addObject(new Flag(xx * 32, yy * 32, ObjectId.FLAG));
            }
        }
    }

    public void switchLevel() {
        clearLevel();
        cam.setX(0);

        switch (Game.LEVEL) {
            case 0:
                loadImageLevel(level1);
                break;
            case 1:
                loadImageLevel(level2);
                break;
            case 2:
                loadImageLevel(level3);
                break;
            case 3:
                loadImageLevel(level4);
                break;
            case 4:
                loadImageLevel(level5);
                break;
        }
        Game.LEVEL++;
    }

    private void clearLevel() {
        object.clear();
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

}
