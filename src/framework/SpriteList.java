
package framework;

import java.awt.image.BufferedImage;

public class SpriteList {
    private BufferedImage image;

    public SpriteList(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage grabImage(int col, int row, int width, int height) {
        return image.getSubimage((col * width) - width, (row * height) - height, width, height);
    }
}
