package eatingbass;

public class Player {

    private int x;
    private int y;

    public Player(int x) {
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
        this.x = this.x + dx;
    }
}
