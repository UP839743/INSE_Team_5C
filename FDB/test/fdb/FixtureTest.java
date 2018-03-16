package fdb;

import java.sql.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author INSE Team 5C
 */
public class FixtureTest {
    
    java.sql.Date testDate = java.sql.Date.valueOf( "1950-01-31" );
    Fixture testFix = testFix = new Fixture(6767, testDate , "Fulham", 
            "Raiders", 7, 3);
    /**
     * File to Test Fixture Class
     */        
    public FixtureTest() {
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
        Date expResult = testDate;
        Date result = testFix.getMatchDate();
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
