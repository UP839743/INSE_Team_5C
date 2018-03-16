package fdb;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author INSE Team 5C
 */
public class ClubTest {
    
    Club clubtst = clubtst = new Club(3333, "Tottenham", "arena", 2322);
    /**
     * File to Test Club Class
     */ 
    public ClubTest() {
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
     * Test of getClubID method, of class Club.
     */
    @Test
    public void testGetClubID() {
        System.out.println("getClubID");
        int expResult = 3333;
        int result = clubtst.getClubID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClubName method, of class Club.
     */
    @Test
    public void testGetClubName() {
        System.out.println("getClubName");
        String expResult = "Tottenham";
        String result = clubtst.getClubName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClubStadium method, of class Club.
     */
    @Test
    public void testGetClubStadium() {
        System.out.println("getClubStadium");
        String expResult = "arena";
        String result = clubtst.getClubStadium();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClubPosititon method, of class Club.
     */
    @Test
    public void testGetClubPosititon() {
        System.out.println("getClubPosititon");
        int expResult = 2322;
        int result = clubtst.getClubPosititon();
        assertEquals(expResult, result);
    }
    
}
