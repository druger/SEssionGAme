package sega;

import java.awt.Dimension;
import javax.swing.JFrame;


public class Window extends javax.swing.JFrame {
    
    
    public Window(int w, int h, String title, Game game){
        game.setPreferredSize(new Dimension(w, h));
        game.setMaximumSize(new Dimension(w, h));
        game.setMinimumSize(new Dimension(w, h));
        
        JFrame window = new JFrame(title);
        window.add(game);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //задаёт параметр закрытия окна
        window.setResizable(false); //непозволяет изменить размер окна
        window.setLocationRelativeTo(null); //помещает окно в центре экрана
        window.setVisible(true); //делаем окно видимым
        
        
        game.start();
    }

}
