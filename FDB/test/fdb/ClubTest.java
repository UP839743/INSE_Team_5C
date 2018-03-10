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
public class ClubTest {
    
    Club clubtst = clubtst = new Club(3333, "Totenham", "Chuck", 
            "arena", 2322);
    
    public ClubTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
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
        String expResult = "Totenham";
        String result = clubtst.getClubName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getManager method, of class Club.
     */
    @Test
    public void testGetManager() {
        System.out.println("getManager");
        String expResult = "Chuck";
        String result = clubtst.getManager();
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
