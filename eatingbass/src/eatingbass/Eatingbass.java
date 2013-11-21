package eatingbass;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Eatingbass {

    public static void main(String[] args) {

        JFrame container = new JFrame("Like Eating Bass");
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        container.getContentPane().add(panel);      
        container.setPreferredSize(new Dimension(180, 320));
        
        container.pack();
        container.setVisible(true);
        
        Graphics graphics = panel.getGraphics();
        graphics.setColor(Color.BLACK);
        graphics.drawRect(0, 0, 66, 66);
        
        

        Level peli = new Level();
        peli.run();
    }
}
