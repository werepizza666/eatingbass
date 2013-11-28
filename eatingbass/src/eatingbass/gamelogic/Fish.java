
package eatingbass.gamelogic;
/**
 * Fish-luokka kuvaa pelissä putoavaa kalaa
 * @author werepizza
 */
public class Fish{
    private int x;
    private int y;
    
    public Fish(int initialX) {
        this.x = initialX;
        this.y = 0;
    }
    /**
     * siirtää kalan sijainnin pykälän alemmas
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
