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
    private int xOffset = 0;
    private int yOffset = 0;

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
            for (int x = 0; x < width; x++) {

                pixels[x + y * width] = Sprite.wall.pixels[(x % 20) + (y % 20) * Sprite.wall.SIZE];

//                if (y >= 160 && Level.level1.playerLocation() <= x && x < Level.level1.playerLocation() + 20) {
//                    if (!checkIfPixelEmpty(Sprite.player, ((x % 20) + (y % 20) * Sprite.player.SIZE))) {
//                        pixels[x + y * width] = Sprite.player.pixels[(x % 20) + (y % 20) * Sprite.player.SIZE];
//                    }
//                }



            }
        }
    }

    public void renderPlayer() {

        int w = Sprite.player.SIZE;
        int h = Sprite.player.SIZE;

        xOffset = Level.level1.playerLocation();
//        yPos -= yOffset;

        for (int y = 160; y < height; y++) {
//            if (yPos + y < 0 || yPos + y >= height) continue;
            for (int x = 0; x < width; x++) {
//                if (((x % 20) + (y % 20) * w - xOffset) < 0 || ((x % 20) + (y % 20) * w - xOffset) >= w) {
//                    continue;
//                }
                if (y >= 160 && Level.level1.playerLocation() <= x && x < Level.level1.playerLocation() + 20) {
                    if (!checkIfPixelEmpty(Sprite.player, (((x - xOffset) % 20) + (y % 20) * Sprite.player.SIZE))) {
                        pixels[x + y * width] = Sprite.player.pixels[((x - xOffset) % 20) + (y % 20) * Sprite.player.SIZE];
                    }
                }
            }
        }
    }

    public void renderFish() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                for (Fish f : Level.level1.getFishList()) {
                    yOffset = f.getY();
                    if ((f.getY()) <= y && y < ((f.getY()) + 20) && (f.getX()) <= x && x < ((f.getX()) + 20)) {
                        if (!checkIfPixelEmpty(Sprite.fish, ((x % 20) + ((y - yOffset) % 20) * Sprite.fish.SIZE))) {

                            pixels[x + y * width] = Sprite.fish.pixels[(x % 20) + ((y - yOffset) % 20) * Sprite.fish.SIZE];
                        }
                    }
                }
            }
        }
    }

    public void renderRocks() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                                for (Rock r : Level.level1.getRockList()) {
                                    yOffset = r.getY();
                    if ((r.getY()) <= y && y < ((r.getY()) + 20) && (r.getX()) <= x && x < ((r.getX()) + 20)) {
                        if (!checkIfPixelEmpty(Sprite.rock, ((x % 20) + ((y - yOffset) % 20) * Sprite.rock.SIZE))) {

                            pixels[x + y * width] = Sprite.rock.pixels[(x % 20) + ((y - yOffset) % 20) * Sprite.rock.SIZE];
                        }
                    }
                }
            }
        }
    }

    public void renderWater() {
        for (int y = 160; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (!checkIfPixelEmpty(Sprite.water, (x % 20) + (y % 20) * Sprite.water.SIZE)) {
                    pixels[x + y * width] = Sprite.water.pixels[(x % 20) + (y % 20) * Sprite.water.SIZE];
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

    /**
     * Tarkistaa Spriten yksittäisen pikselin värin arvon
     *
     * @param s Sprite, jonka pikselin väriarvo halutaan tietää
     * @param i pikselin väriarvo
     * @return Palauttaa true, jos pikselin väri arvo on -65281 eli magenta.
     * Muuuten palauttaa false
     */
    public boolean checkIfPixelEmpty(Sprite s, int i) {
        if (s.pixels[i] == -65281) {
            return true;
        }
        return false;
    }
}
