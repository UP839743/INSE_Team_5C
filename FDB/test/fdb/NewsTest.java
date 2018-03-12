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
//News(int nNewsId, int nClubId, String nTitle, String nContent)
public class NewsTest {
    
    News testNws = testNws = new News(5678, 4354, "TestTitle", "TestContent", "TestAuthor");
    
    public NewsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getNewsId method, of class News.
     */
    @Test
    public void testGetNewsId() {
        System.out.println("getNewsId");
        int expResult = 5678;
        int result = testNws.getNewsId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClubId method, of class News.
     */
    @Test
    public void testGetClubId() {
        System.out.println("getClubId");
        int expResult = 4354;
        int result = testNws.getClubId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class News.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        String expResult = "TestTitle";
        String result = testNws.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getContent method, of class News.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        String expResult = "TestContent";
        String result = testNws.getContent();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getAuthor method, of class News.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        String expResult = "TestAuthor";
        String result = testNws.getAuthor();
        assertEquals(expResult, result);
    }
}

