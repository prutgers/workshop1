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
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KlantDAO {
     static Logger logger = LoggerFactory.getLogger(KlantDAO.class);
 
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
            logger.info("Klant bestaat al in Database");
            throw ex;         
        }
        catch(Exception ex){
            ex.printStackTrace();         
        }
        return klant;
    }
    
    public static Klant readKlant(int klant_id){
        Klant klant = new Klant();

        try (
            Connection connection = ConnectionPool.getConnection();
                ) {
            PreparedStatement readKlant = connection.prepareStatement(
                    "select * from klant where Klant_id = ?");
            readKlant.setString(1, Integer.toString(klant_id) );
                logger.info("Statement prepared.");

            ResultSet readKlantResult = readKlant.executeQuery();
                logger.info("Statement executed.");
            
            readKlantResult.next();
            klant.setKlant_id(readKlantResult.getInt("klant_id"));
            klant.setVoornaam(readKlantResult.getString("voornaam"));
            klant.setAchternaam(readKlantResult.getString("achternaam"));
            klant.setTussenvoegsel(readKlantResult.getString("tussenvoegsel"));
            klant.setEmail(readKlantResult.getString("email"));
            
                logger.info("POJO made.");
            
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
            Connection connection = ConnectionPool.getConnection();
                ) {
            
            PreparedStatement updateKlant = connection.prepareStatement(
                    "update klant set voornaam = ?,"    //1
                            + " achternaam = ?,"        //2
                            + " tussenvoegsel = ?,"     //3
                            + " email = ?"              //4
                            +"where Klant_id = ?");     //5
            
            updateKlant.setString(1, klant.getVoornaam() );
            updateKlant.setString(2, klant.getAchternaam() );
            updateKlant.setString(3, klant.getTussenvoegsel() );
            updateKlant.setString(4, klant.getEmail() );
            updateKlant.setInt(5, klant.getKlant_id() );
            
            updateKlant.executeUpdate();
            
            klantOut = readKlant(klant.getKlant_id());

        }
        catch(Exception ex){
            ex.printStackTrace();     
        }
        return klantOut;
    }

    public static void deleteKlant(int klant_id) throws com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException {
        try (
            Connection connection = ConnectionPool.getConnection();
                ) {
            PreparedStatement deleteKlant = connection.prepareStatement(
                    "delete from klant where Klant_id = ?");
            deleteKlant.setString(1, Integer.toString(klant_id) );

            deleteKlant.executeUpdate();
            
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
        int i = 0;
        try (
            Connection connection = ConnectionPool.getConnection();
                ) {
            PreparedStatement readKlant = connection.prepareStatement(
                    "select * from klant where "
                            + "Klant_id LIKE ? "           //1
                            + "and voornaam LIKE ? "       //2
                            + "and achternaam LIKE ? "     //3
                            + "and tussenvoegsel LIKE ? "  //4
                            + "and email LIKE ? ");        //5
            
            readKlant.setString(1, (klant.getKlant_id() == 0)?
                    "%" : Integer.toString( klant.getKlant_id() ) );
            readKlant.setString(2, ( klant.getVoornaam() == null  || klant.getVoornaam().equals("") )?
                    "%" : klant.getVoornaam() );
            readKlant.setString(3, ( klant.getAchternaam() == null  || klant.getAchternaam().equals("") )?
                    "%" : klant.getAchternaam() );
            readKlant.setString(4, ( klant.getTussenvoegsel() == null  || klant.getTussenvoegsel().equals("") )?
                    "%" : klant.getTussenvoegsel() );
            readKlant.setString(5, ( klant.getEmail() == null  || klant.getEmail().equals("") )?
                    "%" : klant.getEmail() );
            
            
            ResultSet readKlantResult = readKlant.executeQuery();
                logger.info("Statement executed.");
            
            while (readKlantResult.next()){
                i++;
                Klant klant4Array = new Klant();
                klant4Array.setKlant_id(readKlantResult.getInt("klant_id"));
                klant4Array.setVoornaam(readKlantResult.getString("voornaam"));
                klant4Array.setAchternaam(readKlantResult.getString("achternaam"));
                klant4Array.setTussenvoegsel(readKlantResult.getString("tussenvoegsel"));
                klant4Array.setEmail(readKlantResult.getString("email"));
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
