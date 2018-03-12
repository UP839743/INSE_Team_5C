/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author accou
 */
public class PosHistTest {
    
    PosHist pshstTest = new PosHist(3333, "Test League", 192000, 100);
    
    public PosHistTest() {
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
    
    /**
     * Test of getClubID method, of class PosHist.
     */
    @Test
    public void testGetClubID() {
        System.out.println("getClubID");
        int expResult = 3333;
        int result = pshstTest.getClubID();
        assertEquals(expResult, result);
    }
 
    /**
     * Test of getCompetition method, of class PosHist.
     */
    @Test
    public void testGetCompetition() {
        System.out.println("getCompetition");
        String expResult = "Test League";
        String result = pshstTest.getCompetition();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of getYear method, of class PosHist.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        int expResult = 192000;
        int result = pshstTest.getYear();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of getPosition method, of class PosHist.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        int expResult = 100;
        int result = pshstTest.getPosition();
        assertEquals(expResult, result);
    }
    
}
