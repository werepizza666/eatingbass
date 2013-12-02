package eatingbass.gamelogic;
/**
 * Rock kuvaa pelin kivi-ilmentymiä
 * @author werepizza
 */
public class Rock {

    private int x;
    private int y = 0;

    public Rock(int initialX) {
        this.x = initialX*20;
        this.y = this.y*20;
    }
/**
 * fall siirtää kiveä pykälän alemmas
 */
    public void fall() {
        this.y += 5;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
