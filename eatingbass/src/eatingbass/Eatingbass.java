package eatingbass;

import eatingbass.gamelogic.Level;
import eatingbass.gamelogic.Player;
import eatingbass.ui.Keylistener;
import eatingbass.ui.Screen;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * Luokka vastaa tällä hetkellä pelin logiikasta
 * 
 */

public class Eatingbass extends Canvas implements Runnable {

    public final int width = 200;
    public final int height = width / 4 * 3;
    public static int scale = 4;
    
//    private Thread thread;
//    
//    
    private JFrame container;
    private Keylistener keyboard = new Keylistener();
    private Level peli;
    private Player player;
    private boolean gameRunning = false;
    
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    
    private Screen screen;

    public Eatingbass() {

        gameRunning = true;
        setPreferredSize(new Dimension(width * scale, height * scale));
        screen = new Screen(width, height);
        container = new JFrame("Like Eating Bass");
        container.addKeyListener(keyboard);
        player = new Player();
        peli = new Level(player);
        peli.run();
//
//        container.setResizable(false);
//        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        container.add();
//        container.pack();
//        container.setVisible(true);

//        JPanel panel = new JPanel();
//        container.getContentPane().add(panel);



//        Graphics graphics = panel.getGraphics();
//        graphics.setColor(Color.BLACK);


    }
//    
//    public synchronized void start() {
//        thread = new Thread();
//        thread.start();
//    }
//    
//    public synchronized void stop() {
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
/**
 * Pelin loop
 * 
 */
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        final double nanosecond = 1000000000.0 / 60.0;
        double delta = 0;

        while (gameRunning) {
            peli.updateGame();
            long now = System.nanoTime();
            delta += (now - lastTime) / nanosecond;
            lastTime = now;
            while (delta >= 1) {
            update();
            delta--;
            }
            render();
            peli.draw();
            
        try {
            Thread.sleep(400);
        } catch (InterruptedException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//            System.out.println("running");
        }
    }
/**
 * Ruudun päivitys
 * 
 */
    public void render() {
        BufferStrategy strategy = getBufferStrategy();
        if (strategy == null) {
            createBufferStrategy(3);
            return;
        }
        screen.clear();
        screen.render();
        
        for (int i = 0 ; i < pixels.length; i++) {
            pixels[i] = screen.getPixel(i);
        }
        Graphics g = strategy.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
//        g.setColor(Color.BLACK);
//        g.fillRect(0, 0, getWidth(), getHeight());
        g.dispose();
        strategy.show();

    }
/**
 * Pelaajan, kalojen ja kivien sijainnin päivitys
 */
    public void update() {
        if (keyboard.moveLeft()) {
            player.move(-1);
        }
        if (keyboard.moveRight()) {
            player.move(1);
        }
        if (keyboard.doMagic()) {
            player.doMagic();
        }
    }

    public static void main(String[] args) {
        Eatingbass game = new Eatingbass();

        game.container.setResizable(false);
        game.container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.container.add(game);
        game.container.pack();
        game.container.setVisible(true);

        game.run();
    }
}