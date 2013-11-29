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
public class LevelTest {

    public LevelTest() {
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
    public void toimiikoQuitMetodi() {
        Level level = new Level();
        level.quit();
        boolean vastaus = level.checkIfGameIsRunning();
        assertEquals(Boolean.toString(vastaus), "false");
    }

    @Test
    public void toimiikoNewFishMetodi() {
        Level level = new Level();

        level.newFish();

    }
}
