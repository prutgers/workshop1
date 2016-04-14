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
 * @author Gebruiker
 */
public class BestellingDAOTest {
    
    public BestellingDAOTest() {
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
     * Test of createBestelling method, of class BestellingDAO.
     */
    @Test
    public void testCreateBestelling() {
        System.out.println("createBestelling");
        Bestelling bestelling = null;
        BestellingDAO.createBestelling(bestelling);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBestellingById method, of class BestellingDAO.
     */
    @Test
    public void testGetBestellingById() {
        System.out.println("getBestellingById");
        int BestellingId = 0;
        Bestelling expResult = null;
        Bestelling result = BestellingDAO.getBestellingById(BestellingId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBestelling method, of class BestellingDAO.
     */
    @Test
    public void testGetAllBestelling() {
        System.out.println("getAllBestelling");
        ArrayList<Bestelling> expResult = null;
        ArrayList<Bestelling> result = BestellingDAO.getAllBestelling();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBestellingByKlantId method, of class BestellingDAO.
     */
    @Test
    public void testGetBestellingByKlantId() {
        System.out.println("getBestellingByKlantId");
        int klantId = 0;
        ArrayList<Bestelling> expResult = null;
        ArrayList<Bestelling> result = BestellingDAO.getBestellingByKlantId(klantId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateBestelling method, of class BestellingDAO.
     */
    @Test
    public void testUpdateBestelling() {
        System.out.println("updateBestelling");
        Bestelling bestelling = null;
        BestellingDAO.updateBestelling(bestelling);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBestelling method, of class BestellingDAO.
     */
    @Test
    public void testDeleteBestelling() {
        System.out.println("deleteBestelling");
        int bestelling_id = 0;
        BestellingDAO.deleteBestelling(bestelling_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
