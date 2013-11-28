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
        assertEquals(Integer.toString(pelaaja.getY()), "8");
    }

    @Test
    public void pelaajaSyntyyKeskelle() {
        Player pelaaja = new Player();
        assertEquals(Integer.toString(pelaaja.getX()), "4");
    }

    @Test
    public void pelaajaLiikkuuVasemmalle() {
        Player pelaaja = new Player();
        pelaaja.move(-4);
        assertEquals(Integer.toString(pelaaja.getX()), "0");
    }

    @Test
    public void pelaajaLiikkuuOikealle() {
        Player pelaaja = new Player();
        pelaaja.move(2);
        assertEquals(Integer.toString(pelaaja.getX()), "6");
    }

    @Test
    public void pelaajaEiMeneReunanYliVasemmalle() {
        Player pelaaja = new Player();
        for (int i = 0; i < 8; i++) {
            pelaaja.move(-1);
        }
        assertEquals(Integer.toString(pelaaja.getX()), "0");
    }

    @Test
    public void pelaajaEiMeneReunanYliOikealle() {
        Player pelaaja = new Player();
        for (int i = 0; i < 8; i++) {
            pelaaja.move(1);
        }
        assertEquals(Integer.toString(pelaaja.getX()), "8");
    }
}
