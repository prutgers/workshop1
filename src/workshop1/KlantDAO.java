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
import java.util.ArrayList;

public class KlantDAO {
    
 
    public static Klant createKlant(Klant klant){
        Klant klantOut = klant;
        
        try (
            Connection connection = (new DBConnector()).getConnection();
                )
        {
            PreparedStatement createKlant = connection.prepareStatement(
                    "insert into klant (voornaam, achternaam,"
                            + " tussenvoegsel, email, adres_id)"
                            +"values (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            
            createKlant.setString(1, klant.getVoornaam() );
            createKlant.setString(2, klant.getAchternaam() );
            createKlant.setString(3, klant.getTussenvoegsel() );
            createKlant.setString(4, klant.getEmail() );
            createKlant.setString(5, Integer.toString(klant.getAdres().getAdres_id()) );
            
            createKlant.execute();
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
                    "select * from klant where Klant_id = ?");
            readKlant.setString(1, Integer.toString(klant_id) );

            ResultSet readKlantResult = readKlant.executeQuery();
            
            
            readKlantResult.next();
            klant.setKlant_id(readKlantResult.getInt(1));
            klant.setVoornaam(readKlantResult.getString(2));
            klant.setAchternaam(readKlantResult.getString(3));
            klant.setTussenvoegsel(readKlantResult.getString(4));
            klant.setEmail(readKlantResult.getString(5));
            klant.setAdres_id(readKlantResult.getInt(6));
            klant.setAdres( AdresDAO.readAdresByID(klant.getAdres_id() ) );
            
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        return klant;
    }
    
    public static Klant updateKlant(Klant klant){
        Klant klantOut = klant;
        try (
            Connection connection = (new DBConnector()).getConnection();
                )
        {
            PreparedStatement updateKlant = connection.prepareStatement(
                    "update klant set voornaam = ?, achternaam = ?,"
                            + "  tussenvoegsel = ?, email = ?, adres_id = ?"
                            +"where Klant_id = ?");
            
            updateKlant.setString(1, klant.getVoornaam() );
            updateKlant.setString(2, klant.getAchternaam() );
            updateKlant.setString(3, klant.getTussenvoegsel() );
            updateKlant.setString(4, klant.getEmail() );
            updateKlant.setString(5, Integer.toString(klant.getAdres().getAdres_id()) );
            updateKlant.setString(6, Integer.toString(klant.getKlant_id()) );
            updateKlant.executeUpdate();
            
            klantOut = readKlant(klant.getKlant_id());

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

            deleteKlant.executeUpdate();
            
        }
        catch(Exception ex){
            ex.printStackTrace();            
        }
    }
    
    public static ArrayList<Klant> readAllKlantByKlant(Klant klant){
        ArrayList<Klant> AllKlant = new ArrayList();
        int i = 0;
        try (
            Connection connection = (new DBConnector()).getConnection();
                )
        {
            PreparedStatement readKlant = connection.prepareStatement(
                    "select * from klant where "
                            + "Klant_id LIKE ? "           //1
                            + "and voornaam LIKE ? "       //2
                            + "and achternaam LIKE ? "     //3
                            + "and tussenvoegsel LIKE ? "  //4
                            + "and email LIKE ? "          //5
                            + "and adres_id LIKE ?");      //6
            
            readKlant.setString(1, (klant.getKlant_id() == 0)?
                    "%" : Integer.toString( klant.getKlant_id() ) );
            readKlant.setString(2, ( klant.getVoornaam() == null  || klant.getVoornaam().equals("") )?
                    "%" : klant.getVoornaam() );
            readKlant.setString(3, ( klant.getAchternaam() == null  || klant.getVoornaam().equals("") )?
                    "%" : klant.getAchternaam() );
            readKlant.setString(4, ( klant.getTussenvoegsel() == null  || klant.getVoornaam().equals("") )?
                    "%" : klant.getTussenvoegsel() );
            readKlant.setString(5, ( klant.getEmail() == null  || klant.getVoornaam().equals("") )?
                    "%" : klant.getEmail() );
            readKlant.setString(6, ( klant.getAdres().getAdres_id() == 0)?
                    "%" : Integer.toString( klant.getKlant_id() ) );

            ResultSet readKlantResult = readKlant.executeQuery();
            
            while (readKlantResult.next()){
                i++;
                Klant klant4Array = new Klant();
                klant4Array.setKlant_id(readKlantResult.getInt(1));
                klant4Array.setVoornaam(readKlantResult.getString(2));
                klant4Array.setAchternaam(readKlantResult.getString(3));
                klant4Array.setTussenvoegsel(readKlantResult.getString(4));
                klant4Array.setEmail(readKlantResult.getString(5));
                klant4Array.setAdres_id(readKlantResult.getInt(6));
                klant4Array.setAdres(AdresDAO.readAdresByID(klant4Array.getAdres_id()));
                AllKlant.add(klant4Array);
            }

        }
        
        catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("" + i +" Klants matched this inquiry.");
        return AllKlant;
    }
    
    public static ArrayList<Klant> readAllKlantByAdres_id(int adres_id){
        ArrayList<Klant> AllKlant = new ArrayList();
        int i = 0;
        try (
            Connection connection = (new DBConnector()).getConnection();
                )
        {
            PreparedStatement readKlant = connection.prepareStatement(
                    "select * from klant where "
                            + "adres_id = ?;");      //1
            readKlant.setString(1, Integer.toString( adres_id ) );

            ResultSet readKlantResult = readKlant.executeQuery();
            
            while (readKlantResult.next()){
                i++;
                Klant klant4Array = new Klant();
                klant4Array.setKlant_id(readKlantResult.getInt(1));
                klant4Array.setVoornaam(readKlantResult.getString(2));
                klant4Array.setAchternaam(readKlantResult.getString(3));
                klant4Array.setTussenvoegsel(readKlantResult.getString(4));
                klant4Array.setEmail(readKlantResult.getString(5));
                klant4Array.setAdres_id(readKlantResult.getInt(6));
                klant4Array.setAdres(AdresDAO.readAdresByID(klant4Array.getAdres_id()));
                AllKlant.add(klant4Array);
            }

        }
        
        catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("" + i +" Klants matched this inquiry.");
        return AllKlant;
    }
}
