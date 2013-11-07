package eatingbass;

import java.util.Scanner;
import java.util.logging.Logger;

public class Level {

    private Player player = new Player(4);
    private boolean gameRunning = true;
    String[] level1 = {".........",
        ".........",
        ".........",
        ".........",
        ".........",
        ".........",
        ".........",
        ".........",
        "........."};

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            this.draw();
            System.out.println("liiku vasemmalle tai oikealle (v/o):");
            input = scanner.nextLine();
            move(input);
//           try {
//                Thread.sleep(250);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//            }
        }
    }

    public void draw() {
        
        System.out.println("_________");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == player.getX() && i == player.getY()) {
                    System.out.print("P");
                } else {
                System.out.print(level1[i].charAt(j));
                }
            }
            System.out.println("");
        }
    }

    public void quit() {
        this.gameRunning = false;
    }
    
    public void move(String input) {
        int dx;
        if (input.equals("v")) {
            if (player.getX() == 0) {
                return;
            } 
            dx = -1;
            this.player.move(dx);
        }
        if (input.equals("o")) {
            if (player.getX() == 8) {
                return;
            }
        
            dx = 1;
            this.player.move(dx);
        }
    }
}