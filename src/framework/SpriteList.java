
package framework;

import java.awt.image.BufferedImage;

public class SpriteList {
    private BufferedImage image;
    
    public SpriteList(BufferedImage image){
        this.image = image;
    }
    
    //захват изображения
    public BufferedImage grabImage(int col, int row, int width, int height){
        BufferedImage img = image.getSubimage((col * width)-width, (row* height)-height, width, height); //Возвращает подызображение, определенное указанной прямоугольной областью. 
        return img;
    }
}
