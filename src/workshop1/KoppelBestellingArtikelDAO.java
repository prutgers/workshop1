/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import javax.sql.RowSet;

/**
 *
 * @author Peter
 */
public class KoppelBestellingArtikelDAO {
    
    
    // Toe te voegen is Statement.RETURN_GENERATED_KEYS zoals in KlantDAO
    
    public static void createKoppelBestellingArtikel(int bestelling_id, int artikel_id){
        String query = "INSERT INTO bestellingartikel (bestelling_id, artikel_id)"
                + " values (?, ?)";
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, bestelling_id);
            pstmt.setInt(2, artikel_id);
            pstmt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in createKoppelBestellingArtikel");
            e.printStackTrace();
        }
    }
    
    public void readKoppelMetBestellingID(int bestelling_id){
        RowSet rowSet = new JdbcRowSetImpl();
        
    }
    
    public void readKoppelMetArtikelID(int artikel_id){
        
    }
    
    public void deleteKoppelMetBestellingID(int bestelling_id){
        
    }
    
    public void deleteKoppelMetArtikelID(int artikel_id){
        
    }
    public void deleteKoppelID(int koppel_id){
        
    }
    
    
    
    
    
    
}
