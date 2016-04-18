/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDAO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import workshop1.Artikel;

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
        Artikel artikel = new Artikel();
        artikel.setArtikel_naam("testaap");
        artikel.setArtikel_prijs(2);
        artikel.setArtikel_voorraad(2);
        
        TestCreateReadArtikel instance = new TestCreateReadArtikel();
        String expResult = "testaap";
        String result = instance.testCreateRead(artikel);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of testUpdateRead method, of class TestCreateReadArtikel.
     */
    @Test
    public void testTestUpdateRead() {
        System.out.println("testUpdateRead");
        Artikel artikel = new Artikel();
        artikel.setArtikel_id(42);
        artikel.setArtikel_naam("vierkant");
        artikel.setArtikel_prijs(2);
        artikel.setArtikel_voorraad(2);
        TestCreateReadArtikel instance = new TestCreateReadArtikel();
        String expResult = "vierkant";
        String result = instance.testUpdateRead(artikel);
        assertEquals(expResult, result);
       
    }
    
}
