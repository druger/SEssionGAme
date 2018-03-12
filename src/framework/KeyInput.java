/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package framework;

import objects.Bullet;
import sega.Game;
import sega.Game.STATE;
import sega.Handler;
import sega.Menu;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static sega.Game.State;

/**
 * @author druger
 */
public class KeyInput extends KeyAdapter {

    Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyTyped(KeyEvent key) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (State == STATE.GAME) {
                if ((tempObject.getId() == ObjectId.PLAYER) || (tempObject.getId() == ObjectId.PLAYER_GUN)) {
                    if ((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_D)) tempObject.setVelX(5);
                    if ((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_A)) tempObject.setVelX(-5);
                    if (((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_W)) && !tempObject.isJumping()) {
                        tempObject.setJumping(true);
                        tempObject.setVelY(-5);
                    }
                }
                if (tempObject.getId() == ObjectId.PLAYER_GUN) {
                    if (key == KeyEvent.VK_SPACE) {
                        handler.addObject(new Bullet(tempObject.getX() + 77, tempObject.getY() + 92, handler, ObjectId.BULLET, tempObject.getDirection() * 5));
                    }
                }
            }

            if (State == STATE.MENU) {
                if ((key == KeyEvent.VK_SPACE) || (key == KeyEvent.VK_ENTER))
                    select();
                if (key == KeyEvent.VK_UP) {
                    Menu.currentChoice--;
                    if (Menu.currentChoice == -1)
                        Menu.currentChoice = Menu.options.length - 1;
                }
                if (key == KeyEvent.VK_DOWN) {
                    Menu.currentChoice++;
                    if (Menu.currentChoice == Menu.options.length)
                        Menu.currentChoice = 0;
                }
                if (key == KeyEvent.VK_ESCAPE)
                    System.exit(0);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if ((tempObject.getId() == ObjectId.PLAYER) || (tempObject.getId() == ObjectId.PLAYER_GUN)) {
                if ((key == KeyEvent.VK_RIGHT) || (key == KeyEvent.VK_D)) tempObject.setVelX(0);
                if ((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_A)) tempObject.setVelX(0);
            }
        }
    }

    private void select() {
        if (Menu.currentChoice == 0) {
            Game.State = Game.STATE.GAME;
        }
        if (Menu.currentChoice == 1) {

        }
        if (Menu.currentChoice == 2) {
            System.exit(0);
        }
    }
}
