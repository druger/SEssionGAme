package sega;

import javax.swing.*;
import java.awt.*;


public class Window extends javax.swing.JFrame {
    
    
    public Window(int w, int h, String title, Game game){
        game.setPreferredSize(new Dimension(w, h));
        game.setMaximumSize(new Dimension(w, h));
        game.setMinimumSize(new Dimension(w, h));

        setupWindow(title, game);

        game.start();
    }

    private void setupWindow(String title, Game game) {
        JFrame window = new JFrame(title);
        window.add(game);
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
