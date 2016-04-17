package workshop1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    /*@Test
    public void testCreateAdres() {
        System.out.println("createAdres");
        Adres adres = null;
        AdresDAO.createAdres(adres);
    }*/

    /**
     * Test of readAdres method, of class AdresDAO.
     */
    @Test
    public void testReadAdres() {
        System.out.println("readAdres");
        ArrayList<Adres> expResult = null;
        ArrayList<Adres> result = AdresDAO.readAdres();
        assertEquals(expResult, result);
        
        Adres adres = new Adres();
        adres.setAdres_id(1);
        adres.setStraatnaam("Obrechtstraat");
        adres.setHuisnummer(21);
        adres.setToevoeging("a");
        adres.setPostcode("3314EK");
        adres.setWoonplaats("Dordrecht");    
        
        AdresDAO.createAdres(adres);
        
        ArrayList<Adres> adresGegevens = new ArrayList<>(); 
        try(Connection connection = new DBConnector().getConnection();){
            PreparedStatement stmnt = connection.prepareStatement(
                    "select * from adres where adres_id = 1");
            ResultSet resultSet = stmnt.executeQuery();
       
        assertEquals(1, resultSet.getString("straatnaam"));
        assertEquals(1, resultSet.getInt("huisnummer"));
        assertEquals(1, resultSet.getString("postcode"));
        assertEquals(1, resultSet.getString("woonplaats"));
        }
        
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Probeer opnieuw.");
        }
    }

    /**
     * Test of readAdresByID method, of class AdresDAO.
     */
    @Test
    public void testReadAdresByID() {
        System.out.println("readAdresByID");
        int adresID = 0;
        Adres expResult = null;
        Adres result = AdresDAO.readAdresByID(adresID);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateAdres method, of class AdresDAO.
     */
    @Test
    public void testUpdateAdres() {
        System.out.println("updateAdres");
        Adres adres = null;
        AdresDAO.updateAdres(adres);
    }

    /**
     * Test of deleteAdres method, of class AdresDAO.
     */
    @Test
    public void testDeleteAdres() {
        System.out.println("deleteAdres");
        int adres_id = 0;
        AdresDAO.deleteAdres(adres_id);
    }
}
