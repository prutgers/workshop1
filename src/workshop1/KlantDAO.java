/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

/**
 *
 * @author lucas
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import workshop1.Adres;
import workshop1.AdresDAO;
import workshop1.DBConnector;

public class KlantDAO {
    
 
    public static Klant createKlant(Klant klant){
        Klant klantOut = klant;
        
        try (
            Connection connection = (new DBConnector()).getConnection();
                )
        {
            PreparedStatement createKlant = connection.prepareStatement(
                    "insert into Klant (voornaam, achternaam,"
                            + " tussenvoegsel, email, adres_id"
                            +"values (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            
            createKlant.setString(1, klant.getVoornaam() );
            createKlant.setString(2, klant.getAchternaam() );
            createKlant.setString(3, klant.getTussenvoegsel() );
            createKlant.setString(4, klant.getEmail() );
            createKlant.setString(5, Integer.toString(klant.getAdres().getAdres_id()) );
            
            ResultSet klant_idData = createKlant.getGeneratedKeys();
            klant_idData.next();
            klantOut.setKlant_id( klant_idData.getInt(1) );
            
        }
        catch(Exception ex){
            ex.printStackTrace();         
        }
        return klantOut;
    }
    
    public static Klant readKlant(int klant_id){
        Klant klant = new Klant();
        try (
            Connection connection = (new DBConnector()).getConnection();
                )
        {
            PreparedStatement readKlant = connection.prepareStatement(
                    "select * from Klant where Klant_id = ?");
            readKlant.setString(1, Integer.toString(klant_id) );

            ResultSet readKlantResult = readKlant.executeQuery();
            
            
            readKlantResult.next();
            klant.setKlant_id(readKlantResult.getInt(1));
            klant.setVoornaam(readKlantResult.getString(2));
            klant.setAchternaam(readKlantResult.getString(3));
            klant.setTussenvoegsel(readKlantResult.getString(4));
            klant.setEmail(readKlantResult.getString(5));
            klant.setAdres_id(readKlantResult.getInt(6));
            klant.setAdres( new Adres (AdresDAO.readAdres( klant.getAdres_id() )) );
            
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        return klant;
    }
    
    public static Klant updateKlant(Klant klant){
        try (
            Connection connection = (new DBConnector()).getConnection();
                )
        {
            PreparedStatement updateKlant = connection.prepareStatement(
                    "update Klant set voornaam = ?, achternaam = ?,"
                            + "  tussenvoegsel = ?, email = ?, adres_id = ?"
                            +"where Klant_id = ?");
            
            updateKlant.setString(1, klant.getVoornaam() );
            updateKlant.setString(2, klant.getAchternaam() );
            updateKlant.setString(3, klant.getTussenvoegsel() );
            updateKlant.setString(4, klant.getEmail() );
            updateKlant.setString(5, Integer.toString(klant.getAdres().getAdres_id()) );
            updateKlant.setString(6, Integer.toString(klant.getKlant_id()) );
            updateKlant.executeUpdate();
            
            Klant klantOut = readKlant(klant.getKlant_id());
            return klantOut;
            
        }
        catch(Exception ex){
            ex.printStackTrace();     
        }
        return klantOut;
    }

    public static void deleteKlant(int klant_id){
        try (
            Connection connection = (new DBConnector()).getConnection();
                )
        {
            PreparedStatement deleteKlant = connection.prepareStatement(
                    "delete from klant where Klant_id = ?");
            deleteKlant.setString(1, Integer.toString(klant_id) );

            deleteKlant.executeQuery();
            
        }
        catch(Exception ex){
            ex.printStackTrace();            
        }
    }
}
