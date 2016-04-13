/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

import java.util.ArrayList;
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
public class ArtikelDAOTest {
    
    public ArtikelDAOTest() {
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
     * Test of createNewArtikel method, of class ArtikelDAO.
     */
    @Test
    public void testCreateNewArtikel() {
        System.out.println("createNewArtikel");
        Artikel artikel = new Artikel();
        artikel.setArtikel_id(1);
        artikel.setArtikel_naam("artikelnaam");
        artikel.setArtikel_prijs(2);
        artikel.setArtikel_voorraad(3);
        ArtikelDAO.createNewArtikel(artikel);
        
    }

    /**
     * Test of readArtikel method, of class ArtikelDAO.
     */
    @Test
    public void testReadArtikel_0args() {
        System.out.println("readArtikel");
        ArrayList<Artikel> expResult = null;
        ArrayList<Artikel> result = ArtikelDAO.readArtikel();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of readArtikel method, of class ArtikelDAO.
     */
    @Test
    public void testReadArtikel_int() {
        System.out.println("readArtikel");
        int artikel_id = 0;
        Artikel expResult = null;
        Artikel result = ArtikelDAO.readArtikel(artikel_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateArtikel method, of class ArtikelDAO.
     */
    @Test
    public void testUpdateArtikel() {
        System.out.println("updateArtikel");
        Artikel artikel = null;
        ArtikelDAO.updateArtikel(artikel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteArtikel method, of class ArtikelDAO.
     */
    @Test
    public void testDeleteArtikel() {
        System.out.println("deleteArtikel");
        int artikel_ID = 0;
        ArtikelDAO.deleteArtikel(artikel_ID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
