package eatingbass;

public class Rock {

    private int x;
    private int y;

    public Rock(int initialX) {
        this.x = initialX;
        this.y = 0;
    }

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
