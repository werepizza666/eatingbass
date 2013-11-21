package eatingbass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class Level {

    private Player player = new Player();
    private List<Fish> fishList = new ArrayList<Fish>();
    private List<Rock> rockList = new ArrayList<Rock>();
    private boolean gameRunning;
    private int score;
    private int timeSinceLastFish;
    private int timeSinceLastCastOfRocks;
    private int timeSinceMassDestruction;
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
//        Scanner scanner = new Scanner(System.in);
//        String input;
        this.gameRunning = true;
        this.timeSinceLastFish = 0;
        this.timeSinceMassDestruction = 0;
        this.score = 0;
        newFish();
        while (gameRunning) {
            this.draw();
//            System.out.println("liiku vasemmalle, oikealle tai pysy paikallaan(v/o/p):");
//            input = scanner.nextLine();
            updateGame();

            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {
                Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }

    public void draw() {
        System.out.println("_________basses eaten:" + this.score);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == player.getX() && i == player.getY()) {
                    System.out.print("P");
                } else if (checkForFish(j, i)) {
                    System.out.print("F");
                } else if (checkForRock(j, i)) {
                    System.out.print("R");
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

    public void updateGame() {

        checkIfPlayerIsHitByARock();
        
        if (whereToMove() < 0) {
            player.move(-1);
        }
        if (whereToMove() > 0) {
            player.move(1);
        }
        for (Fish f : fishList) {
            f.fall();
        }
        for (Rock r : rockList) {
            r.fall();
        }
        timeSinceLastCastOfRocks++;
        if (timeSinceLastCastOfRocks == 16) {
            castRocks();
        }
        checkIfFishIsEaten();
        if (checkIfFishHitTheGround()) {
            quit();
        }
        timeSinceMassDestruction++;
        if (timeSinceMassDestruction == 28) {
            massDestruction();
        }
        timeSinceLastFish++;
        if (timeSinceLastFish == 5 || timeSinceMassDestruction == 0) {
            newFish();

        }
    }

    public boolean checkIfFishIsEaten() {
        for (Fish f : fishList) {
            if (this.player.getX() == f.getX()) {
                if (this.player.getY() == f.getY()) {
                    this.score += 1;
                    fishList.remove(f);
                    return true;
                }
            }
        }
        return false;
    }

    public void newFish() {
        Random random = new Random();
        fishList.add(new Fish(random.nextInt(8)));
        if (fishList.size() >= 2) {
            while (!isPreviousFishCloseEnough(fishList.get(fishList.size() - 2), fishList.get(fishList.size() - 1))) {
                fishList.remove(fishList.get(fishList.size() - 1));
                fishList.add(new Fish(random.nextInt(8)));
            }
        }
        this.timeSinceLastFish = 0;

    }

    public boolean isPreviousFishCloseEnough(Fish previousFish, Fish newFish) {
        double distance;
        if (previousFish.getX() < newFish.getX()) {
            distance = ((double) (newFish.getX() - previousFish.getX()) / (double) (previousFish.getY() - newFish.getY()));
        } else if (newFish.getX() < previousFish.getX()) {
            distance = ((double) (previousFish.getX() - newFish.getX()) / (double) (previousFish.getY() - newFish.getY()));
        } else {
            return true;
        }
        if (distance < 1) {
            return true;
        }
        return false;
    }

    public boolean checkForFish(int x, int y) {
        for (Fish f : fishList) {
            if (f.getX() == x && f.getY() == y) {
                return true;
            }
        }
        return false;
    }

    public int whereToMove() {
        Fish lowestFish = new Fish(fishList.size() - 1);
        for (Fish f : fishList) {
            if (f.getY() > lowestFish.getY()) {
                lowestFish = f;
            }
        }
        return lowestFish.getX() - player.getX();
    }

    public boolean checkIfFishHitTheGround() {
        for (Fish f : fishList) {
            if (f.getY() == 8) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfGameIsRunning() {
        if (gameRunning) {
            return true;
        }
        return false;
    }

    public void massDestruction() {
        if (!fishList.isEmpty()) {
            try {
                for (Fish f : fishList) {
                    fishList.remove(f);
                    this.timeSinceMassDestruction = 0;
                }
            } catch (Exception e) {
                System.out.println("Barf");
            }
        }
    }

    public void castRocks() {
        for (int i = 0; i < 5; i++) {
            rockList.add(new Rock(i * 2));
        }
        this.timeSinceLastCastOfRocks = 0;
    }

    public boolean checkForRock(int x, int y) {
        for (Rock r : rockList) {
            if (r.getX() == x && r.getY() == y) {
                return true;
            }
        }
        return false;
    }

    public void checkIfPlayerIsHitByARock() {
        for (Rock r : rockList) {
            if (this.player.getX() == r.getX()) {
                if (this.player.getY() == r.getY()) {
                    System.out.println("you choked on a rock");
                    this.quit();
                }
            }
        }
        
    }
}
