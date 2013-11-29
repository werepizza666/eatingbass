package eatingbass.ui;

import eatingbass.gamelogic.Fish;
import eatingbass.gamelogic.Level;
import eatingbass.gamelogic.Rock;

/**
 * Screen-luokka piirtää kuvan ruudulle
 *
 * @author werepizza
 */
public class Screen {

    private int width, height;
    private int[] pixels;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
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
                pixels[x + y * width] = Sprite.wall.pixels[(x % 20) + (y % 20) * Sprite.wall.SIZE];
                if (y >= 160) {
                    if (!checkIfPixelEmpty(Sprite.water, (x % 20) + (y % 20) * Sprite.water.SIZE)) {
                        pixels[x + y * width] = Sprite.water.pixels[(x % 20) + (y % 20) * Sprite.water.SIZE];
                    }
//                    System.out.println(pixels[x + y * width]);
                }
                if (y >= 160 && Level.level1.playerLocation() <= x && x < Level.level1.playerLocation() + 20) {
                    if (!checkIfPixelEmpty(Sprite.player, ((x % 20) + (y % 20) * Sprite.player.SIZE))) {
                        pixels[x + y * width] = Sprite.player.pixels[(x % 20) + (y % 20) * Sprite.player.SIZE];
                    }
                }
                for (Fish f : Level.level1.getFishList()) {

                    if ((f.getY() * 20) <= y && y < ((f.getY() * 20) + 20) && (f.getX() * 20) <= x && x < ((f.getX() * 20) + 20)) {
                        if (!checkIfPixelEmpty(Sprite.fish, ((x % 20) + (y % 20) * Sprite.fish.SIZE))) {

                            pixels[x + y * width] = Sprite.fish.pixels[(x % 20) + (y % 20) * Sprite.fish.SIZE];
                        }
                    }
                }
                for (Rock r : Level.level1.getRockList()) {
                    if ((r.getY() * 20) <= y && y < ((r.getY() * 20) + 20) && (r.getX() * 20) <= x && x < ((r.getX() * 20) + 20)) {
                        if (!checkIfPixelEmpty(Sprite.rock, ((x % 20) + (y % 20) * Sprite.rock.SIZE))) {

                            pixels[x + y * width] = Sprite.rock.pixels[(x % 20) + (y % 20) * Sprite.rock.SIZE];
                        }
                    }
                }
            }
        }
    }

    /**
     * clear puhdistaa ruudun
     */
    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    /**
     * Palauttaa yksittäisen pikselin arvon ruudulla
     *
     * @param i on halutun pikselin indeksi pixels-taulukossa
     * @return palauttaa indeksissä i olevan pikselin heksadesimaaliarvon
     */
    public int getPixel(int i) {
        return pixels[i];
    }

    public boolean checkIfPixelEmpty(Sprite s, int i) {
        if (s.pixels[i] == -65281) {
            return true;
        }
        return false;
    }
}
