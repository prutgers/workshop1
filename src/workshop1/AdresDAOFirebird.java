package workshop1;

/**
 *
 * @author Sonja
 */

import java.sql.*;
import java.util.ArrayList; 

public class AdresDAOFirebird {
    
    static PreparedStatement stmnt;

    public static void createFirebirdDBAdres(Adres adres) {
        try (Connection connection = new DBConnectorFirebird().getConnection()) {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            String query = "INSERT INTO adres (straatnaam, huisnummer, "
                    + "toevoeging, postcode, woonplaats) "
                + "values (?, ?, ?, ?, ?) RETURNING adres_id";
            PreparedStatement stmntCA = connection.prepareStatement(query);
            
            stmntCA.setInt(1, adres.getAdres_id());
            stmntCA.setString(2, adres.getStraatnaam());
            stmntCA.setInt(3, adres.getHuisnummer());
            stmntCA.setString(4, adres.getToevoeging());
            stmntCA.setString(5, adres.getPostcode());
            stmntCA.setString(6, adres.getWoonplaats());

            stmntCA.executeUpdate();
            }
        
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex + "\nProbeer opnieuw.");
        }
    }            
    
    public static ArrayList<Adres> readFireBirdDBAdres() {
        ArrayList<Adres> adresGegevens = new ArrayList<>();
        try (Connection connection = new DBConnectorFirebird().getConnection()) { 
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            PreparedStatement stmntRA = connection.prepareStatement(
                    "SELECT * FROM adres ");
            ResultSet rs = stmntRA.executeQuery();
            while (rs.next()) {
                
                System.out.println("Adres ID: " + rs.getInt("adres_id") 
                        + "Straatnaam: " + rs.getString("straatnaam")
                        + "Huisnummer: " + rs.getInt("huisnummer")
                        + "Toevoeging: " + rs.getString("toevoeging")
                        + "Postcode: " + rs.getString("postcode")
                        + "Woonplaats: " + rs.getString("woonplaats"));
                
               /* Adres adres = new Adres();
                
                adres.setStraatnaam(rs.getString("straatnaam"));
                adres.setHuisnummer(rs.getInt("huisnummer"));
                adres.setToevoeging(rs.getString("toevoeging"));
                adres.setPostcode(rs.getString("postcode"));
                adres.setWoonplaats(rs.getString("woonplaats"));
                adres.setAdres_id(rs.getInt("adres_id"));
                
                adresGegevens.add(adres);
                */
            }
            stmntRA.close();
        }
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex + "Probeer opnieuw.");
            }
        return adresGegevens;
    }
    
    public static Adres readFirebirdDBAdresByID(int adresID) {
        Adres adres = new Adres();
    
        try (Connection connection = new DBConnectorFirebird().getConnection();) {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            PreparedStatement stmntRAID = connection.prepareStatement(
                    "SELECT * FROM adres WHERE adres_id=?");
            
            stmntRAID.setInt(1, adresID);     
            
            ResultSet rs = stmntRAID.executeQuery();
            rs.next();
                adres.setStraatnaam(rs.getString("straatnaam"));
                adres.setHuisnummer(rs.getInt("huisnummer"));
                adres.setToevoeging(rs.getString("toevoeging"));
                adres.setPostcode(rs.getString("postcode"));
                adres.setWoonplaats(rs.getString("woonplaats"));       
        }
            catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex + "Probeer opnieuw.");
            }
                
        return adres;
    }
    
    public static void updateFirebirdDBAdres(Adres adres) {
        try (Connection connection = new DBConnectorFirebird().getConnection();) {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            
            String query = "UPDATE adres SET "
                + "straatnaam=?,"
                + "huisnummer=?,"
                + "toevoeging=?,"
                + "postcode=?,"
                + "woonplaats=?"
                + "WHERE adres_id=?";
            
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
            System.out.println(ex + "Probeer opnieuw.");
        }
    }
    
    public static void deleteAdres(int adres_id) {
        String query = "DELETE FROM adres WHERE adres_id=?";
        try (Connection connection = new DBConnectorFirebird().getConnection();) {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            
            stmnt = connection.prepareStatement(query);
            stmnt.setInt(1, adres_id);
            stmnt.executeUpdate();
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Probeer opnieuw.");
        }
    }
}
