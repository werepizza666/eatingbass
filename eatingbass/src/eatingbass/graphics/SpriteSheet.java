package eatingbass.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * SpriteSheet hallinnoi pelin spritesheetia
 * @author werepizza
 */
public class SpriteSheet {

    private String path;
    public final int SIZE;
    public int[] pixels;
    public static SpriteSheet tiles = new SpriteSheet("/spritesheet1.png", 200);

    public SpriteSheet(String path, int size) {
        this.path = path;
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        
        System.out.println(SpriteSheet.class.getResource(path));
        load();
        
    }

    private void load() {
        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, pixels, 0, w);
        } catch (IOException e) {
            System.out.println("not found" + e);
        }
    }

    public int getPixel(int i) {
        return pixels[i];
    }

    public int getSize() {
        return SIZE;
    }
}
