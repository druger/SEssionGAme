
package sega;

import framework.GameObject;

public class Camera {
    private float x;
    private float y;

    public Camera(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void tick(GameObject player) {
        x = -player.getX() + 226;
        if (x > 0) x = 0;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
