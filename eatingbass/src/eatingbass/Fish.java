/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eatingbass;

public class Fish {
    private int x;
    private int y;
    
    public Fish(int initialX) {
        this.x = initialX;
        this.y = 0;
    }
    public void fall() {
        this.y += 1;
    }
    
}
