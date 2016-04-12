package workshop1;

/**
 *
 * @author Sonja
 */

import java.sql.*;
import java.util.ArrayList;

public class AdresDAO {
    
    static PreparedStatement stmnt;

    public void createAdres(Adres adres) throws SQLException {
        String query = "INSERT straatnaam, huisnummer, toevoeging, postcode,"
                + "woonplaats, adres_id INTO adres";
        try {
            Connection connection = new DBConnector().getConnection();
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmntCA = connection.prepareStatement(query);
            
            stmntCA.setString(1, adres.getStraatnaam());
            stmntCA.setInt(2, adres.getHuisnummer());
            stmntCA.setString(3, adres.getToevoeging());
            stmntCA.setString(4, adres.getPostcode());
            stmntCA.setString(5, adres.getWoonplaats());
            stmntCA.setInt(6, adres.getAdres_id());
            
        }
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Probeer opnieuw.");
            }
        
        finally {
            stmnt.executeUpdate();
            stmnt.close();
        }
    }
    
    public ArrayList<Adres> readAdres() throws SQLException {
        String query = "SELECT straatnaam, huisnummer, toevoeging, postcode,"
                + "woonplaats, adres_id FROM adres";
        ArrayList<Adres> lijst = new ArrayList<>();
        Adres adres;
        ResultSet rs;
        try {
            Connection connection = new DBConnector().getConnection(); 
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmntRA = connection.prepareStatement(query);
            rs = stmntRA.executeQuery(query);
            while (rs.next()) {
                adres = new Adres();
                
                adres.setStraatnaam(rs.getString("straatnaam"));
                adres.setHuisnummer(rs.getInt("huisnummer"));
                adres.setToevoeging(rs.getString("toevoeging"));
                adres.setPostcode(rs.getString("postcode"));
                adres.setWoonplaats(rs.getString("woonplaats"));
                adres.setAdres_id(rs.getInt("adres_id"));
                
                lijst.add(adres);
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Probeer opnieuw.");
            }
        
        finally {
            stmnt.executeUpdate();
            stmnt.close();
        }
        
        return lijst;
    }
    
    public ArrayList<Adres> readAdresByID(int adresID) throws SQLException {
        String query = "SELECT * FROM adres WHERE adres_id=?";
        ArrayList<Adres> adresGegevens = new ArrayList<>();
    
        try {
            Connection connection = new DBConnector().getConnection(); 
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmntRAID = connection.prepareStatement(query);
            stmntRAID.setInt(1, adresID);     
            ResultSet rs = stmntRAID.executeQuery(query);
            while (rs.next()) {
                Adres adres = new Adres();
                
                adres.setStraatnaam(rs.getString("straatnaam"));
                adres.setHuisnummer(rs.getInt("huisnummer"));
                adres.setToevoeging(rs.getString("toevoeging"));
                adres.setPostcode(rs.getString("postcode"));
                adres.setWoonplaats(rs.getString("woonplaats"));
                adres.setAdres_id(rs.getInt("adres_id"));
                
                adresGegevens.add(adres);
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Probeer opnieuw.");
            }
        
        finally {
            stmnt.executeUpdate();
            stmnt.close();
        }
        
        return adresGegevens;
    }
    
    public void updateAdres(Adres adres) throws SQLException {
        String query = "UPDATE adres SET straatnaam, huisnummer, toevoeging"
                + "postcode, woonplaats";
        
        try {
            Connection connection = new DBConnector().getConnection();
            PreparedStatement stmntUA = connection.prepareStatement(query);
            
            stmntUA.setString(1, adres.getStraatnaam());
            stmntUA.setInt(2, adres.getHuisnummer());
            stmntUA.setString(3, adres.getToevoeging());
            stmntUA.setString(4, adres.getPostcode());
            stmntUA.setString(5, adres.getWoonplaats());
            
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Probeer opnieuw.");
            }
        
        finally {
            stmnt.executeUpdate();
            stmnt.close();
        }
    }
    
    public void deleteAdres(int adres_id) {
        String query = "DELETE straatnaam, huisnummer, toevoeging, postcode,"
                + "woonplaats FROM adres WHERE adres_id=?";
        try {
            Connection connection = new DBConnector().getConnection();
            stmnt = connection.prepareStatement(query);
            
            stmnt.setInt(1, adres_id);
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Probeer opnieuw.");
        }
    }
}
