package eatingbass.gamelogic;

/**
 * Player kuvaa pelin pelaajaa
 *
 * @author werepizza
 */
public class Player {

    private int x;
    private int y;
    private boolean facingLeft = true;
    ;
    public static Player player1 = new Player();

    public Player() {
        this.x = 4 * 20;
        this.y = 8 * 20;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void move(int dx) {
        if (dx < 0 && this.x == 0) {
            return;
        }
        if (dx > 0 && this.x == 160) {
            return;
        }
        if (dx < 0) {
            facingLeft = true;
        }
        if (dx > 0) {
            facingLeft = false;
        }
        this.x = this.x + dx;
    }

    public void doMagic() {
        System.out.println("MAGIC!");
    }
    
    public boolean isThePlayerFacingLeft() {
        return facingLeft;
    }
}
