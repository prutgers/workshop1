/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

import POJO.Artikel;
import POJO.TestCreateReadArtikel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter
 */
public class TestCreateReadArtikelTest {
    
    public TestCreateReadArtikelTest() {
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
     * Test of testCreateRead method, of class TestCreateReadArtikel.
     */
    @Test
    public void testTestCreateRead() {
        System.out.println("testCreateRead");
        Artikel artikel = null;
        TestCreateReadArtikel instance = new TestCreateReadArtikel();
        String expResult = "";
        String result = instance.testCreateRead(artikel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testUpdateRead method, of class TestCreateReadArtikel.
     */
    @Test
    public void testTestUpdateRead() {
        System.out.println("testUpdateRead");
        Artikel artikel = null;
        TestCreateReadArtikel instance = new TestCreateReadArtikel();
        String expResult = "";
        String result = instance.testUpdateRead(artikel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
