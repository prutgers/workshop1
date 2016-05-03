/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

import DAO.MySQL.BestellingDAOMySQL;
import POJO.Bestelling;
import ConnectionPools.DBConnector;
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
        Bestelling bestelling = new Bestelling();
        bestelling.setKlantID(999);
       
        Bestelling result = BestellingDAOMySQL.createBestelling(bestelling);
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement stmt = con.prepareStatement("select * from bestelling where bestelling_id = ?");
            stmt.setInt(1, result.getBestellingID());
            ResultSet expResult = stmt.executeQuery();
            assertEquals(result.getKlantID(),expResult.getInt("klant_id"));
            assertEquals(result.getBestellingID(),expResult.getString("bestelling_id"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Test of getBestellingById method, of class BestellingDAO.
     */
    @Test
    public void testGetBestellingById() {
        Bestelling bestelling = new Bestelling();
        bestelling.setKlantID(888);
        Bestelling newBestelling = BestellingDAOMySQL.createBestelling(bestelling);
        
        Bestelling result = BestellingDAOMySQL.getBestellingById(newBestelling.getBestellingID());
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement stmt = con.prepareStatement("select * from bestelling where bestelling_id = ?");
            stmt.setInt(1,result.getBestellingID());
            ResultSet expResult = stmt.executeQuery();
            assertEquals(result.getKlantID(),expResult.getInt("klant_id"));
            assertEquals(result.getBestellingID(),expResult.getString("bestelling_id"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Test of getAllBestelling method, of class BestellingDAO.
     */
    @Test
    public void testGetAllBestelling() {
        //get test result
        ArrayList<Bestelling> resultList = BestellingDAOMySQL.getAllBestelling();
        
        //get expected result
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement stmt = con.prepareStatement("select * from bestelling");
            ResultSet expResult = stmt.executeQuery();
            
            for(Bestelling result : resultList){
                assertEquals(result.getKlantID(),expResult.getInt("klant_id"));
                assertEquals(result.getBestellingID(),expResult.getString("bestelling_id"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Test of getBestellingByKlantId method, of class BestellingDAO.
     */
    @Test
    public void testGetBestellingByKlantId() {
        //get test result
        ArrayList<Bestelling> resultList = BestellingDAOMySQL.getBestellingByKlantId(0);
        
        //get expected result
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement stmt = con.prepareStatement("select * from bestelling");
            ResultSet expResult = stmt.executeQuery();
            
            for(Bestelling result : resultList){
                assertEquals(result.getKlantID(),expResult.getInt("klant_id"));
                assertEquals(result.getBestellingID(),expResult.getString("bestelling_id"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Test of updateBestelling method, of class BestellingDAO.
     */
    @Test
    public void testUpdateBestelling() {
        //create bestelling
        Bestelling bestelling = new Bestelling();
        bestelling.setKlantID(777);
        Bestelling updateBestelling = BestellingDAOMySQL.createBestelling(bestelling);
        
        //update bestelling
        updateBestelling.setKlantID(777);
        BestellingDAOMySQL.updateBestelling(updateBestelling);
    
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement stmt = con.prepareStatement("SELECT  * Bestelling WHERE bestelling_id = ?;");
            stmt.setInt(1, updateBestelling.getBestellingID());
            
            ResultSet expResult = stmt.executeQuery();
            assertEquals(777, expResult.getInt("klant_id"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Test of deleteBestelling method, of class BestellingDAO.
     */
    @Test
    public void testDeleteBestelling() {
        //create bestelling
        Bestelling bestelling = new Bestelling();
        bestelling.setKlantID(777);
        Bestelling deleteBestelling = BestellingDAOMySQL.createBestelling(bestelling);
        
        //delete bestelling
        BestellingDAOMySQL.deleteBestelling(deleteBestelling.getBestellingID());
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement stmt = con.prepareStatement("SELECT  * Bestelling WHERE bestelling_id = ?;");
            stmt.setInt(1, deleteBestelling.getBestellingID());
            ResultSet expResult = stmt.executeQuery();
            
            assertEquals(null, expResult.getInt("bestelling_id"));
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    
}
