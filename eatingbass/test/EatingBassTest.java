/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import eatingbass.Level;
import eatingbass.Player;
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
public class EatingBassTest {

    public EatingBassTest() {
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
    public void kaynnistyykoPeli() {
        try {
            Level level = new Level();
        } catch (Exception e) {
        }
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
}
