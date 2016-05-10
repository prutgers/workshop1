package DAO.MySQL;

/**
 *
 * @author Sonja
 */

import ConnectionPools.*;
import POJO.Adres;
import interfaceDAO.AdresDAO;
import java.sql.*;
import java.util.ArrayList; 
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement; 

public class AdresDAOMySQL implements AdresDAO {
    
    static PreparedStatement stmnt;

    @Override
    public Adres createAdres(Adres adres) {
        String query = "INSERT INTO adres ("
                + "straatnaam,"
                + "huisnummer,"
                + "toevoeging,"
                + "postcode,"
                + "woonplaats)"
                + "values (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection()){
            
            PreparedStatement stmntCA = connection.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
            
            
            stmntCA.setString(1, adres.getStraatnaam());
            stmntCA.setInt(2, adres.getHuisnummer());
            stmntCA.setString(3, adres.getToevoeging());
            stmntCA.setString(4, adres.getPostcode());
            stmntCA.setString(5, adres.getWoonplaats());
            
            stmntCA.executeUpdate();
            
            ResultSet generatedKey = stmntCA.getGeneratedKeys();
            if(generatedKey.isBeforeFirst()){
                generatedKey.next();
                adres.setAdres_id(generatedKey.getInt(1));
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex + "\nProbeer opnieuw.");
            
            Logger.getLogger(AdresDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);            
            }
        
        return adres;
    }
    
    @Override
    public ArrayList<Adres> readAdres() {
        ArrayList<Adres> adresGegevens = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();) { 

            PreparedStatement stmntRA = connection.prepareStatement(
                    "SELECT * FROM adres ");
            ResultSet rs = stmntRA.executeQuery();
            while (rs.next()) {
                Adres adres = new Adres();
                
                adres.setStraatnaam(rs.getString("straatnaam"));
                adres.setHuisnummer(rs.getInt("huisnummer"));
                adres.setToevoeging(rs.getString("toevoeging"));
                adres.setPostcode(rs.getString("postcode")); 
                adres.setWoonplaats(rs.getString("woonplaats"));
                adres.setAdres_id(rs.getInt("adres_id"));
                
                /* ADRESBUILDER VERSIE
                
                Adres adres = new Adres.AdresBuilder().straatnaam(rs.getString("straatnaam")).huisnummer(rs.getInt("huisnummer")).toevoeging(rs.getString("toevoeging")).postcode(rs.getString("postcode")).woonplaats(rs.getString("woonplaats")).adres_id(rs.getInt("adres_id")).build();
                */
                
                adresGegevens.add(adres);
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex + "\nProbeer opnieuw.");
            }
        
        return adresGegevens;
    }
    
    @Override
    public Adres readAdresByID(int adresID) {
        Adres adres = new Adres();
    
        try (Connection connection = ConnectionPool.getConnection();) {

            PreparedStatement stmntRAID = connection.prepareStatement(
                    "SELECT * FROM adres " 
                + "WHERE adres_id=?");
            stmntRAID.setInt(1, adresID);     
            
            ResultSet rs = stmntRAID.executeQuery();
            rs.next();
            
                adres.setStraatnaam(rs.getString("straatnaam"));
                adres.setHuisnummer(rs.getInt("huisnummer"));
                adres.setToevoeging(rs.getString("toevoeging"));
                adres.setPostcode(rs.getString("postcode"));
                adres.setWoonplaats(rs.getString("woonplaats"));
                adres.setAdres_id(rs.getInt("adres_id"));
        }
            catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex + "\nProbeer opnieuw.");
            }
        
        return adres;
    }
    
    @Override
    public void updateAdres(Adres adres) {
        String query = "UPDATE adres SET "
                + "straatnaam=?,"
                + "huisnummer=?,"
                + "toevoeging=?,"
                + "postcode=?,"
                + "woonplaats=?"
                + "WHERE adres_id=?";
        
        try (Connection connection = ConnectionPool.getConnection();) {
            
            PreparedStatement stmntUA = connection.prepareStatement(query);
            
            stmntUA.setString(1, adres.getStraatnaam()); 
            stmntUA.setInt(2, adres.getHuisnummer());
            stmntUA.setString(3, adres.getToevoeging());
            stmntUA.setString(4, adres.getPostcode());
            stmntUA.setString(5, adres.getWoonplaats());
            stmntUA.setInt(6, adres.getAdres_id());
            
            stmntUA.executeUpdate();          
        }
        
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex + "\nProbeer opnieuw.");
        }
    }
    
    @Override
    public void deleteAdres(int adres_id) {
        String query = "DELETE FROM adres WHERE adres_id=?";
        try (Connection connection = ConnectionPool.getConnection();) {
            
            stmnt = connection.prepareStatement(query);
            stmnt.setInt(1, adres_id);
            stmnt.executeUpdate();    
        } 
        
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex + "\nProbeer opnieuw.");
        }
    }
}