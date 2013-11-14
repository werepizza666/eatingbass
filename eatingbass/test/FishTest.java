/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import eatingbass.Fish;
import eatingbass.Level;
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
public class FishTest {

    public FishTest() {
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
    public void syntyykoKala() {
        try {
            Fish fish = new Fish(0);
        } catch (Exception e) {
        }
    }

    @Test
    public void syntyykoKalaYlareunaan() {
        Fish fish = new Fish(0);
        assertEquals(Integer.toString(fish.getY()), "0");
    }
}
