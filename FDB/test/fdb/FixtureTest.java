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
public class FixtureTest {
    
    Fixture testFix = testFix = new Fixture(6767, "2012-08-12", "Fulham", 
            "Raiders", 7, 3);
            
    public FixtureTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getMatchID method, of class Fixture.
     */
    @Test
    public void testGetMatchID() {
        System.out.println("getMatchID");
        int expResult = 6767;
        int result = testFix.getMatchID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMatchDate method, of class Fixture.
     */
    @Test
    public void testGetMatchDate() {
        System.out.println("getMatchDate");
        String expResult = "2012-08-12";
        String result = testFix.getMatchDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHomeTeam method, of class Fixture.
     */
    @Test
    public void testGetHomeTeam() {
        System.out.println("getHomeTeam");
        String expResult = "Fulham";
        String result = testFix.getHomeTeam();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAwayTeam method, of class Fixture.
     */
    @Test
    public void testGetAwayTeam() {
        System.out.println("getAwayTeam");
        String expResult = "Raiders";
        String result = testFix.getAwayTeam();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHomeTeamScore method, of class Fixture.
     */
    @Test
    public void testGetHomeTeamScore() {
        System.out.println("getHomeTeamScore");
        int expResult = 7;
        int result = testFix.getHomeTeamScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAwayTeamScore method, of class Fixture.
     */
    @Test
    public void testGetAwayTeamScore() {
        System.out.println("getAwayTeamScore");
        int expResult = 3;
        int result = testFix.getAwayTeamScore();
        assertEquals(expResult, result);
    }
    
}