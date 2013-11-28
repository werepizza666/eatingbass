
package eatingbass.ui;
/**
 * Screen-luokka piirtää kuvan ruudulle
 * @author werepizza
 */
public class Screen {
    private int width, height;
    private int[] pixels;
    
    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width*height];
    }
    /**
     * päivittää peliruudun pikselit
     */
    public void render() {
        for (int y = 0; y < height; y++) {
//            
//            if (y < 0 || y >= height) {
//                break;
//            }
            for (int x = 0; x < width; x++) {
//                if (x < 0 || x >= width) {
//                    break;
//                }
               pixels[x+y*width] = Sprite.jee.pixels[(x % 20) + (y % 20) * Sprite.jee.SIZE];
  
            }
        }
    }
    /**
     * clear puhdistaa ruudun
     */
    public void clear() {
        for (int i = 0 ; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }
/**
 * Palauttaa yksittäisen pikselin arvon ruudulla
 * @param i on halutun pikselin indeksi pixels-taulukossa
 * @return palauttaa indeksissä i olevan pikselin heksadesimaaliarvon
 */
    public int getPixel(int i) {
        return pixels[i];
    }
    
}
