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
import ConnectionPools.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.sql.rowset.JdbcRowSet;
import com.sun.rowset.CachedRowSetImpl;
import formatMessage.PrintFormat;
import java.sql.Statement;
import java.util.ArrayList;

public class KlantDAO {
    
 
    public static Klant createKlant(Klant klant) throws com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException {
        try(Connection connection = ConnectionPool.getConnection()){
             String sql = "insert into klant ("
                            + "voornaam,"       //1
                            + " achternaam,"    //2
                            + " tussenvoegsel," //3
                            + " email)"         //4
                            + "values (?, ?, ?, ?)" ;
            
            PreparedStatement pstmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, klant.getVoornaam() );
            pstmt.setString(2, klant.getAchternaam() );
            pstmt.setString(3, klant.getTussenvoegsel() );
            pstmt.setString(4, klant.getEmail() );
            
            pstmt.executeUpdate();
            ResultSet resultSet = pstmt.getGeneratedKeys();
            if (resultSet.next()){
                klant.setKlant_id(resultSet.getInt(1)); 
            }
            
        }
        catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex){
            throw ex;         
        }
        catch(Exception ex){
            ex.printStackTrace();         
        }
        return klant;
    }
    
    public static Klant readKlant(int klant_id){
        Klant klant = new Klant();
        try ( CachedRowSetImpl connection = new CachedRowSetImpl();
                ) {
            connection.setUrl("jdbc:mysql://localhost/workshopdb");
            connection.setUsername("rsvier");
            connection.setPassword("tiger");
            connection.setCommand("select * from klant where klant_id = ?");
            connection.setString(1, Integer.toString(klant_id) );

            
            connection.execute();
            
            connection.next();
            klant.setKlant_id(connection.getInt("klant_id"));
            klant.setVoornaam(connection.getString("voornaam"));
            klant.setAchternaam(connection.getString("achternaam"));
            klant.setTussenvoegsel(connection.getString("tussenvoegsel"));
            klant.setEmail(connection.getString("email"));
            
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        return klant;
    }
    
    public static Klant updateKlant(Klant klant){
        Klant klantOut = klant;
        try ( CachedRowSetImpl connection = new CachedRowSetImpl();
                ) {
            connection.setUrl("jdbc:mysql://localhost/workshopdb");
            connection.setUsername("rsvier");
            connection.setPassword("tiger");
            
            connection.setCommand(
                    "update klant set voornaam = ?,"    //1
                            + " achternaam = ?,"        //2
                            + " tussenvoegsel = ?,"     //3
                            + " email = ?"              //4
                            +"where Klant_id = ?");     //5
            
            CachedRowSetImpl updateKlant = connection;
            
            updateKlant.setString(1, klant.getVoornaam() );
            updateKlant.setString(2, klant.getAchternaam() );
            updateKlant.setString(3, klant.getTussenvoegsel() );
            updateKlant.setString(4, klant.getEmail() );
            updateKlant.setInt(5, klant.getKlant_id() );
            updateKlant.execute();
            
            klantOut = readKlant(klant.getKlant_id());

        }
        catch(Exception ex){
            ex.printStackTrace();     
        }
        return klantOut;
    }

    public static void deleteKlant(int klant_id) throws com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException {
        try ( CachedRowSetImpl connection = new CachedRowSetImpl();
                ) {
            connection.setUrl("jdbc:mysql://localhost/workshopdb");
            connection.setUsername("rsvier");
            connection.setPassword("tiger");
            
            connection.setCommand(
                    "delete from klant where Klant_id = ?");
            connection.setString(1, Integer.toString(klant_id) );

            connection.execute();
            
        }
        catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex){
            throw ex;         
        }
        catch(Exception ex){
            ex.printStackTrace();     
        }
    }
    
    public static ArrayList<Klant> readAllKlantByKlant(Klant klant){
        ArrayList<Klant> AllKlant = new ArrayList();
        
        try ( CachedRowSetImpl connection = new CachedRowSetImpl();
                ) {
            connection.setUrl("jdbc:mysql://localhost/workshopdb");
            connection.setUsername("rsvier");
            connection.setPassword("tiger");
            connection.setCommand(
                    "select * from klant where "
                            + "Klant_id LIKE ? "           //1
                            + "and voornaam LIKE ? "       //2
                            + "and achternaam LIKE ? "     //3
                            + "and tussenvoegsel LIKE ? "  //4
                            + "and email LIKE ? ");        //5
            
            connection.setString(1, (klant.getKlant_id() == 0)?
                    "%" : Integer.toString( klant.getKlant_id() ) );
            connection.setString(2, ( klant.getVoornaam() == null  || klant.getVoornaam().equals("") )?
                    "%" : klant.getVoornaam() );
            connection.setString(3, ( klant.getAchternaam() == null  || klant.getAchternaam().equals("") )?
                    "%" : klant.getAchternaam() );
            connection.setString(4, ( klant.getTussenvoegsel() == null  || klant.getTussenvoegsel().equals("") )?
                    "%" : klant.getTussenvoegsel() );
            connection.setString(5, ( klant.getEmail() == null  || klant.getEmail().equals("") )?
                    "%" : klant.getEmail() );

            connection.execute();
            
            while (connection.next()){
        
                Klant klant4Array = new Klant(); //maakt nieuwe klant aan
                klant4Array.setKlant_id(connection.getInt("klant_id")); //stopt data in klant die niet voor de array is
                klant4Array.setVoornaam(connection.getString("voornaam")); //stopt data in klant die niet voor de array is
                klant4Array.setAchternaam(connection.getString("achternaam")); //stopt data in klant die niet voor de array is
                klant4Array.setTussenvoegsel(connection.getString("tussenvoegsel")); //stopt data in klant die niet voor de array is
                klant4Array.setEmail(connection.getString("email")); //stopt data in klant die niet voor de array is
                AllKlant.add(klant4Array); //stopt nieuwe klant LEGE KLANT DUS in array
                
            }

        }
        
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        return AllKlant;
    }
    
    /*public static ArrayList<Klant> readAllKlantByAdres_id(int adres_id){
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
                AllKlant.add(klant4Array);
            }

        }
        
        catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("" + i +" Klants matched this inquiry.");
        return AllKlant;
    }*/
}
