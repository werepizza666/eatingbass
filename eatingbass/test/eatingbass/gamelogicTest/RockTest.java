package eatingbass.gamelogicTest;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import eatingbass.gamelogic.Rock;
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
public class RockTest {
    
    public RockTest() {
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
    public void syntyykoKiviYlareunaan() {
        Rock r = new Rock(0);
        assertEquals(Integer.toString(r.getY()), "-20");
    }
    
    @Test
    public void toimiikoFallMetodi() {
        Rock r = new Rock(0);
        r.fall();
        assertEquals(Integer.toString(r.getY()), "-10");
    }
}
