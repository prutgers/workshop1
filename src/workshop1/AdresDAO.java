/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

/**
 *
 * @author Sonja
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AdresDAO {
    private Connection connection;
    private Statement statement;
    
    public AdresDAO() {
    }
    
    public Adres createAdres(Adres adres) {
        String query = "INSERT straatnaam, huisnummer, toevoeging, postcode,"
                + "woonplaats INTO klant";
    }
    
    public List<Adres> readAdres() throws SQLException {
        String query = "SELECT straatnaam, huisnummer, toevoeging, postcode,"
                + "woonplaats FROM klant";
        List<Adres> lijst = new ArrayList<>();
        Adres adres = null;
        ResultSet rs = null;
        try {
            connection = DBConnector.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                adres = new Adres();
                
                adres.setStraatnaam(rs.getString("straatnaam"));
                adres.setHuisnr(rs.getInt("huisnummer"));
                adres.setToevoeging(rs.getString("toevoeging"));
                adres.setPostcode(rs.getString("postcode"));
                adres.setWoonplaats(rs.getString("woonplaats"));
                
                lijst.add(adres);
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
            }
        
        finally {
            DBConnector.close(rs);
            DBConnector.close(statement);
            DBConnector.close(connection);
        }
        
        return lijst;
    }
    
    public boolean updateAdres() {
        String query = "UPDATE straatnaam, huisnummer, toevoeging, postcode," 
                + "woonplaats FROM klant";
    }
    
    public boolean deleteAdres() {
        String query = "DELETE straatnaam, huisnummer, toevoeging, postcode,"
                + "woonplaats FROM klant WHERE klant_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            
            //delete user-input klant_id adres something bla
            //boolean execute(String sql) ???
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void getAdres(Adres adres) {
        return adres.get(lijst);
    }
}
