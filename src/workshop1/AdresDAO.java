package workshop1;

/**
 *
 * @author Sonja
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AdresDAO {
    
    //werkt in principe, zit alleen nog met de DBConnector te kloten
    
    static PreparedStatement stmnt;
    Connection connection;

    public void createAdres(Adres adres) throws SQLException {
        String query = "INSERT straatnaam, huisnummer, toevoeging, postcode,"
                + "woonplaats, adres_id INTO adres";
        try {
            Connection connection = DBConnector.getConnection();
            //connection werkt nog niet; non-static method cannot be referenced 
            //from static context, gruargh
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmnt = connection.prepareStatement(query);
            
            stmnt.setString(1, adres.getStraatnaam());
            stmnt.setInt(2, adres.getHuisnummer());
            stmnt.setString(3, adres.getToevoeging());
            stmnt.setString(4, adres.getPostcode());
            stmnt.setString(5, adres.getWoonplaats());
            stmnt.setInt(6, adres.getAdres_id());
            
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
                + "woonplaats, adres_id, klant_id FROM adres";
        ArrayList<Adres> lijst = new ArrayList<>();
        Adres adres;
        ResultSet rs;
        try {
            Connection connection = DBConnector.getConnection(); 
            //connection werkt nog niet; zie boven 
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmnt = connection.prepareStatement(query);
            rs = stmnt.executeQuery(query);
            while (rs.next()) {
                adres = new Adres();
                
                adres.setStraatnaam(rs.getString("straatnaam"));
                adres.setHuisnummer(rs.getInt("huisnummer"));
                adres.setToevoeging(rs.getString("toevoeging"));
                adres.setPostcode(rs.getString("postcode"));
                adres.setWoonplaats(rs.getString("woonplaats"));
                adres.setAdres_id(rs.getInt("adres_id"));
                adres.setKlant_id(rs.getInt("klant_id"));
                
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
    
    public void updateAdres(Adres adres) throws SQLException {
        String query = "UPDATE adres SET straatnaam, huisnummer, toevoeging"
                + "postcode, woonplaats";
        
        try {
            connection = DBConnector.getConnection();
            //connection werkt nog niet; zie boven
            PreparedStatement stmnt = connection.prepareStatement(query);
            
            stmnt.setString(1, adres.getStraatnaam());
            stmnt.setInt(2, adres.getHuisnummer());
            stmnt.setString(3, adres.getToevoeging());
            stmnt.setString(4, adres.getPostcode());
            stmnt.setString(5, adres.getWoonplaats());
            
        }
        catch (SQLException ex) {
            System.out.println("Probeer opnieuw.");
            }
        
        finally {
            stmnt.executeUpdate();
            stmnt.close();
        }
    }
    
    public void deleteAdres(int klant_id) {
        String query = "DELETE straatnaam, huisnummer, toevoeging, postcode,"
                + "woonplaats FROM adres WHERE klant_id=?";
        try {
            connection = DBConnector.getConnection();
            //connection werkt nog niet; zie boven
            stmnt = connection.prepareStatement(query);
            
            stmnt.setInt(1, klant_id);
            
        } catch (Exception ex) {
            System.out.println("Probeer opnieuw.");
        }
    }
    
    public Adres getAdres(Adres adres) {
        return adres.get(lijst);
        
        //is deze wel nodig eigenlijk? Geloof het niet he
    }
}
