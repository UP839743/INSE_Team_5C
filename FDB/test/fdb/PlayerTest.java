/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import java.sql.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author up777361
 */
public class PlayerTest {
    
    java.sql.Date testDate = java.sql.Date.valueOf( "1950-01-31" );
    Player testPlr = testPlr = new Player(999, 999, "Testy", 
                        "Testil", 9999, "LeftBack", "9f9", 
                        "right", testDate, 9999, 999, "Mongolian",
                        9899, 878, 1000);;
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getPlayerID method, of class Player.
     */
    @Test
    public void testGetPlayerID() {
        System.out.println("getPlayerID");
        int expResult = 999;
        int result = testPlr.getPlayerID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getclubID method, of class Player.
     */
    @Test
    public void testGetclubID() {
        System.out.println("getclubID");
        int expResult = 999;
        int result = testPlr.getclubID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getfirstName method, of class Player.
     */
    @Test
    public void testGetfirstName() {
        System.out.println("getfirstName");
        String expResult = "Testy";
        String result = testPlr.getfirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Player.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "Testil";
        String result = testPlr.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSquadNumber method, of class Player.
     */
    @Test
    public void testGetSquadNumber() {
        System.out.println("getSquadNumber");
        Player instance = null;
        int expResult = 9999;
        int result = testPlr.getSquadNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPosition method, of class Player.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        String expResult = "LeftBack";
        String result = testPlr.getPosition();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHeight method, of class Player.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        String expResult = "9f9";
        String result = testPlr.getHeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrefFoot method, of class Player.
     */
    @Test
    public void testGetPrefFoot() {
        System.out.println("getPrefFoot");
        String expResult = "right";
        String result = testPlr.getPrefFoot();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDoB method, of class Player.
     */
    @Test
    public void testGetDoB() {
        System.out.println("getDoB");
        Date expResult = testDate;
        Date result = testPlr.getDoB();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClubApps method, of class Player.
     */
    @Test
    public void testGetClubApps() {
        System.out.println("getClubApps");
        int expResult = 9999;
        int result = testPlr.getClubApps();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSeasonApps method, of class Player.
     */
    @Test
    public void testGetSeasonApps() {
        System.out.println("getSeasonApps");
        int expResult = 999;
        int result = testPlr.getSeasonApps();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNationality method, of class Player.
     */
    @Test
    public void testGetNationality() {
        System.out.println("getNationality");
        String expResult = "Mongolian";
        String result = testPlr.getNationality();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClubGoals method, of class Player.
     */
    @Test
    public void testGetClubGoals() {
        System.out.println("getClubGoals");
        int expResult = 9899;
        int result = testPlr.getClubGoals();
        assertEquals(expResult, result);
    }

    /**
     * Test of getseasonGoals method, of class Player.
     */
    @Test
    public void testGetseasonGoals() {
        System.out.println("getseasonGoals");
        int expResult = 878;
        int result = testPlr.getseasonGoals();
        assertEquals(expResult, result);
    }

    /**
     * Test of getcleanSheets method, of class Player.
     */
    @Test
    public void testGetcleanSheets() {
        System.out.println("getcleanSheets");
        int expResult = 1000;
        int result = testPlr.getcleanSheets();
        assertEquals(expResult, result);
    }
    
}
