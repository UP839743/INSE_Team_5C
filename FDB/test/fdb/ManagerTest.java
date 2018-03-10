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

public class ManagerTest {
    
    Manager testMng = testMng = new Manager(7878, 3457, "Fred", 
            "Perry", "1979-02-20", "2013-12-01", "Romanian");
    
    public ManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getManagerID method, of class Manager.
     */
    @Test
    public void testGetManagerID() {
        System.out.println("getManagerID");
        int expResult = 7878;
        int result = testMng.getManagerID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getclubID method, of class Manager.
     */
    @Test
    public void testGetclubID() {
        System.out.println("getclubID");
        int expResult = 3457;
        int result = testMng.getclubID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getfirstName method, of class Manager.
     */
    @Test
    public void testGetfirstName() {
        System.out.println("getfirstName");
        String expResult = "Fred";
        String result = testMng.getfirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Manager.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "Perry";
        String result = testMng.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDoB method, of class Manager.
     */
    @Test
    public void testGetDoB() {
        System.out.println("getDoB");
        String expResult = "1979-02-20";
        String result = testMng.getDoB();
        assertEquals(expResult, result);
    }

    /**
     * Test of getJoinedClub method, of class Manager.
     */
    @Test
    public void testGetJoinedClub() {
        System.out.println("getJoinedClub");
        String expResult = "2013-12-01";
        String result = testMng.getJoinedClub();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNationality method, of class Manager.
     */
    @Test
    public void testGetNationality() {
        System.out.println("getNationality");
        String expResult = "Romanian";
        String result = testMng.getNationality();
        assertEquals(expResult, result);
    }
    
}
