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
public class StadiumTest {
    
    java.sql.Date testDate = java.sql.Date.valueOf( "1950-01-31" );
    Stadium testStad = testStad = new Stadium("TestStad", 9991, "TestAddress", "TestPost", 12000, testDate);
    /**
     * File to Test Stadium Class
     */ 
    public StadiumTest() {
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
     * Test of getName method
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "TestStad";
        String result = testStad.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClubID method, of class Stadium.
     */
    @Test
    public void testGetClubID() {
        System.out.println("getClubID");
        int expResult = 9991;
        int result = testStad.getClubID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddress method, of class Stadium.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        String expResult = "TestAddress";
        String result = testStad.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostcode method, of class Stadium.
     */
    @Test
    public void testGetPostcode() {
        System.out.println("getPostcode");
        String expResult = "TestPost";
        String result = testStad.getPostcode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCapacity method, of class Stadium.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        int expResult = 12000;
        int result = testStad.getCapacity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateBuilt method, of class Stadium.
     */
    @Test
    public void testGetDateBuilt() {
        System.out.println("getDateBuilt");
        Date expResult = testDate;
        Date result = testStad.getDateBuilt();
        assertEquals(expResult, result);
    }
    
}
