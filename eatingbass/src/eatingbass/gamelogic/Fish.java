
package eatingbass.gamelogic;
/**
 * Fish-luokka kuvaa pelissä putoavaa kalaa
 * @author werepizza
 */
public class Fish{
    private int x;
    private int y = 0;
    
    public Fish(int initialX) {
        this.x = initialX*20;
        this.y = y*20;
    }
    /**
     * siirtää kalan sijainnin pykälän alemmas
     */
    public void fall() {
        this.y += 1*5;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }   
}
