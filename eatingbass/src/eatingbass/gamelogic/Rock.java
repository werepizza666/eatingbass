package eatingbass.gamelogic;
/**
 * Rock kuvaa pelin kivi-ilmentymiä
 * @author werepizza
 */
public class Rock {

    private int x;
    private int y;

    public Rock(int initialX) {
        this.x = initialX;
        this.y = 0;
    }
/**
 * fall siirtää kiveä pykälän alemmas
 */
    public void fall() {
        this.y += 1;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
