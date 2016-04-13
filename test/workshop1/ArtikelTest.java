/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

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
public class ArtikelTest {
    
    public ArtikelTest() {
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
     * Test of getArtikel_id method, of class Artikel.
     */
    @Test
    public void testGetArtikel_id() {
        System.out.println("getArtikel_id");
        Artikel instance = new Artikel();
        int expResult = 0;
        int result = instance.getArtikel_id();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArtikel_id method, of class Artikel.
     */
    @Test
    public void testSetArtikel_id() {
        System.out.println("setArtikel_id");
        int artikel_id = 0;
        Artikel instance = new Artikel();
        instance.setArtikel_id(artikel_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArtikel_naam method, of class Artikel.
     */
    @Test
    public void testGetArtikel_naam() {
        System.out.println("getArtikel_naam");
        Artikel instance = new Artikel();
        String expResult = null;
        String result = instance.getArtikel_naam();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setArtikel_naam method, of class Artikel.
     */
    @Test
    public void testSetArtikel_naam() {
        System.out.println("setArtikel_naam");
        String artikel_naam = "";
        Artikel instance = new Artikel();
        instance.setArtikel_naam(artikel_naam);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArtikel_voorraad method, of class Artikel.
     */
    @Test
    public void testGetArtikel_voorraad() {
        System.out.println("getArtikel_voorraad");
        Artikel instance = new Artikel();
        int expResult = 0;
        int result = instance.getArtikel_voorraad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArtikel_voorraad method, of class Artikel.
     */
    @Test
    public void testSetArtikel_voorraad() {
        System.out.println("setArtikel_voorraad");
        int artikel_voorraad = 0;
        Artikel instance = new Artikel();
        instance.setArtikel_voorraad(artikel_voorraad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArtikel_prijs method, of class Artikel.
     */
    @Test
    public void testGetArtikel_prijs() {
        System.out.println("getArtikel_prijs");
        Artikel instance = new Artikel();
        double expResult = 0.0;
        double result = instance.getArtikel_prijs();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArtikel_prijs method, of class Artikel.
     */
    @Test
    public void testSetArtikel_prijs() {
        System.out.println("setArtikel_prijs");
        double artikel_prijs = 0.0;
        Artikel instance = new Artikel();
        instance.setArtikel_prijs(artikel_prijs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
