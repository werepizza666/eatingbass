package eatingbass.gamelogic;

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

    public final int width = 180;
    public final int height = 180;
    public static int scale = 4;
//    private Thread thread;
//    
//    
    private JFrame container;
    private Keylistener keyboard = new Keylistener();
    private Player player;
    private boolean gameRunning = false;
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    private Screen screen;

    public Eatingbass() {

        gameRunning = true;
        setPreferredSize(new Dimension(width * scale, height * scale));
        screen = new Screen(width, height);
        container = new JFrame("Like Eating Bass");
        addKeyListener(keyboard);
        player = new Player();
        Level.level1.run();
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
            Level.level1.updateGame();
            Level.level1.draw();
            long now = System.nanoTime();
            delta += (now - lastTime) / nanosecond;
            lastTime = now;
            while (delta >= 1) {
                update();
                delta--;
            }
            render();


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

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.getPixel(i);
        }
        Graphics g = strategy.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
        strategy.show();

    }

    /**
     * Pelaajan, kalojen ja kivien sijainnin päivitys
     */
    public void update() {
        if (keyboard.moveLeft()) {
            Level.level1.updatePlayerLocation(-1);
        }
        if (keyboard.moveRight()) {
            Level.level1.updatePlayerLocation(1);
        }
        if (keyboard.doMagic()) {
            Level.level1.tryDoMagic();
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