package fdb;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author INSE Team 5C
 */
public class NewsTest {
    
    News testNws = testNws = new News(5678, 4354, "TestTitle", "TestContent", "TestAuthor");
    /**
     * File to Test News Class
     */ 
    public NewsTest() {
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
     * Test of getNewsId method, of class News.
     */
    @Test
    public void testGetNewsId() {
        System.out.println("getNewsId");
        int expResult = 5678;
        int result = testNws.getNewsID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClubId method, of class News.
     */
    @Test
    public void testGetClubId() {
        System.out.println("getClubId");
        int expResult = 4354;
        int result = testNws.getClubID();
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

