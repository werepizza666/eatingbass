package eatingbass.gamelogicTest;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import eatingbass.gamelogic.Level;
import eatingbass.gamelogic.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author werepizza
 */
public class PlayerTest {

    public PlayerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void syntyykoPelaaja() {
        try {
            Player pelaaja = new Player();
        } catch (Exception e) {
        }
    }

    @Test
    public void pelaajaSyntyyAlareunaan() {
        Player pelaaja = new Player();
        assertEquals(Integer.toString(pelaaja.getY()), "160");
    }

    @Test
    public void pelaajaSyntyyKeskelle() {
        Player pelaaja = new Player();
        assertEquals(Integer.toString(pelaaja.getX()), "80");
    }

    @Test
    public void pelaajaLiikkuuVasemmalle() {
        Player pelaaja = new Player();
        for (int i = 0 ; i < 20; i++) {
        pelaaja.move(-5);
        }
        assertEquals(Integer.toString(pelaaja.getX()), "0");
    }

    @Test
    public void pelaajaLiikkuuOikealle() {
        Player pelaaja = new Player();
        pelaaja.move(10);
        assertEquals(Integer.toString(pelaaja.getX()), "90");
    }

    @Test
    public void pelaajaEiMeneReunanYliVasemmalle() {
        Player pelaaja = new Player();
        for (int i = 0; i < 20; i++) {
            pelaaja.move(-5);
        }
        assertEquals(Integer.toString(pelaaja.getX()), "0");
    }

    @Test
    public void pelaajaEiMeneReunanYliOikealle() {
        Player pelaaja = new Player();
        for (int i = 0; i < 20; i++) {
            pelaaja.move(5);
        }
        assertEquals(Integer.toString(pelaaja.getX()), "160");
    }
}
