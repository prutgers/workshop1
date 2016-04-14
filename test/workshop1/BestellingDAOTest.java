/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import junit.framework.Assert;
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
        Bestelling dao = new Bestelling();
        dao.setKlantID(999);
        dao.setArtikelNaam_1("testNaam1");
        dao.setArtikelNaam_2("testNaam2");
        dao.setArtikelNaam_3("testNaam3");
        dao.setArtikelPrijs_1(999);
        dao.setArtikelPrijs_2(999);
        dao.setArtikelPrijs_3(999);
        dao.setArtikelAantal_1(999);
        dao.setArtikelAantal_2(999);
        dao.setArtikelAantal_3(999);
        BestellingDAO.createBestelling(dao);
        
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement stmt = con.prepareStatement("select * from bestelling where klant_id = 999");
            ResultSet rs = stmt.executeQuery();
            Assert.assertEquals(999,rs.getInt("klant_id"));
            Assert.assertEquals("testNaam1",rs.getString("artikel_naam1"));
            Assert.assertEquals("testNaam2",rs.getString("artikel_naam1"));
            Assert.assertEquals("testNaam3",rs.getString("artikel_naam1"));
            Assert.assertEquals(999,rs.getInt("artikel_prijs1"));
            Assert.assertEquals(999,rs.getInt("artikel_aantal1"));
            Assert.assertEquals(999,rs.getInt("artikel_aantal2"));
            Assert.assertEquals(999,rs.getInt("artikel_aantal3"));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
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
