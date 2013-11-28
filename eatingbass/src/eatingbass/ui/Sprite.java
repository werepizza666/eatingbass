
package eatingbass.ui;

import java.util.Random;

/**
 * Sprite-luokan ilmentymät ovat yksittäisiä spriteja taulukoituna pikseli-muodossa.
 * @author werepizza
 */
public class Sprite {
    
    public final int SIZE;
    private int x, y;
    public int[] pixels;
    private SpriteSheet sheet;   
    
    public static Sprite player = new Sprite(20, 0, 0, SpriteSheet.tiles);
    public static Sprite wall = new Sprite(20, 1, 2, SpriteSheet.tiles);
    
    Random r = new Random();
    int indeksi = r.nextInt(5);
    public Sprite jee = new Sprite(20, indeksi, 0, SpriteSheet.tiles);
    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        SIZE = size;
        this.x = x*size;
        this.y = y*size;
        this.sheet = sheet;
        pixels = new int[SIZE * SIZE];
        load();
    }
    /**
     * Lataa yksittäisen spriten SpriteSheetista ja tallentaa sen omaksi pikselitaulukoksi.
     */
    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    }
}
