/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author up777361
 */

public class TrophyTest {
    
    Trophy testTphy = testTphy = new Trophy("TestCup", 2011, 4555);
    /**
     * File to Test Trophy Class
     */ 
    public TrophyTest() {
    }
    /**
     * Tear down setUp objects in class
     */
    @BeforeClass
    public static void setUpClass() {
    }
    /**
     * Tear down tearDown objects in class
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getCompetition method, of class Trophy.
     */
    @Test
    public void testGetCompetition() {
        System.out.println("getCompetition");
        String expResult = "TestCup";
        String result = testTphy.getCompetition();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class Trophy.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        int expResult = 2011;
        int result = testTphy.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClubId method, of class Trophy.
     */
    @Test
    public void testGetClubId() {
        System.out.println("getClubId");
        int expResult = 4555;
        int result = testTphy.getClubId();
        assertEquals(expResult, result);
    }
    
}
