package eatingbass.gamelogic;
/**
 * Player kuvaa pelin pelaajaa
 * @author werepizza
 */
public class Player {

    private int x;
    private int y;
    public static Player player1 = new Player();
    
    public Player() {
        this.x = 4;
        this.y = 8;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return 8;
    }

    public void move(int dx) {
        if (dx < 0 && this.x == 0) {
            return;
        }
        if (dx > 0 && this.x == 8) {
            return;
        }
        this.x = this.x + dx;
    }
    
    public void doMagic() {
        System.out.println("MAGIC!");
    }
}
