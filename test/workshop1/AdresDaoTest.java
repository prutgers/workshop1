package workshop1;

import POJO.Adres;
import DAO.MySQL.AdresDAOMySQL;
import ConnectionPools.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sonja
 */
public class AdresDaoTest {
    
    public AdresDaoTest() {
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
     * Test of createAdres method, of class AdresDAO.
     */
    @Test
    public void testCreateAdres() {
        Adres adres = new Adres();
        adres.setAdres_id(11);
        
        Adres adresResultaat = null; 
        AdresDAOMySQL.createAdres(adresResultaat);
        
        try (Connection connection = new DBConnector().getConnection();) {
            PreparedStatement stmnt = connection.prepareStatement(
                    "SELECT * FROM adres WHERE adres_id=?");
            stmnt.setInt(1, adresResultaat.getAdres_id());
            ResultSet resultaat = stmnt.executeQuery();
            assertEquals(adresResultaat.getAdres_id(), resultaat.getInt("adres_id"));
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Test of readAdres method, of class AdresDAO.
     */
    @Test
    public void testReadAdres() {
        
        ArrayList<Adres> adresGegevens = AdresDAOMySQL.readAdres(); 
        try(Connection connection = new DBConnector().getConnection();){
            PreparedStatement stmnt = connection.prepareStatement(
                    "select * from adres");
            ResultSet expResultaat = stmnt.executeQuery();
            
            for(Adres resultaat : adresGegevens) {
        assertEquals(resultaat.getStraatnaam(), expResultaat.getString("straatnaam"));
        assertEquals(resultaat.getHuisnummer(), expResultaat.getInt("huisnummer"));
        assertEquals(resultaat.getPostcode(), expResultaat.getString("postcode"));
        assertEquals(resultaat.getWoonplaats(), expResultaat.getString("woonplaats"));
            }
        }
        
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex + "\nProbeer opnieuw.");
        }
    }

    /**
     * Test of readAdresByID method, of class AdresDAO.
     */
    @Test
    public void testReadAdresByID() {
        
        Adres adresTest = AdresDAOMySQL.readAdresByID(0);
        //get expected result
        try(Connection connection = new DBConnector().getConnection();){
            PreparedStatement stmnt = connection.prepareStatement("select * from adres");
            ResultSet resultaat = stmnt.executeQuery();
            
                assertEquals(adresTest.getAdres_id(),resultaat.getInt("adres_id"));
            } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdresDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of updateAdres method, of class AdresDAO.
     */
    @Test
    public void testUpdateAdres() {
        Adres adres = new Adres();
        adres.setAdres_id(22);
        Adres updateAdres = null; 
        AdresDAOMySQL.createAdres(adres);
        
        updateAdres.setAdres_id(22);
        AdresDAOMySQL.updateAdres(updateAdres);
        
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement stmnt = con.prepareStatement(
                    "SELECT * FROM adres WHERE adres_id=?");
            stmnt.setInt(1, updateAdres.getAdres_id());
            
            ResultSet expResultaat = stmnt.executeQuery();
            assertEquals(22, expResultaat.getInt("adres_id"));
        }
        catch(SQLException | ClassNotFoundException ex){
            System.out.println(ex);
        }
    }

    /**
     * Test of deleteAdres method, of class AdresDAO.
     */
    @Test
    public void testDeleteAdres() {
        Adres adres = new Adres();
        adres.setAdres_id(33);
        Adres deleteAdres = null; 
        AdresDAOMySQL.createAdres(adres);
        
        AdresDAOMySQL.deleteAdres(deleteAdres.getAdres_id());
        
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement stmnt = con.prepareStatement(
                    "SELECT * FROM adres WHERE adres_id=?");
            stmnt.setInt(1, deleteAdres.getAdres_id());
            
            ResultSet expResultaat = stmnt.executeQuery();
            assertEquals(null, expResultaat.getInt("adres_id"));
        }
        catch(SQLException | ClassNotFoundException ex){
            System.out.println(ex);
        }
    }
}
