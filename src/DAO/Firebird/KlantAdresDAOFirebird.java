package DAO.Firebird;

import ConnectionPools.DBConnectorFirebird;
import POJO.Adres;
import POJO.KlantAdres;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import interfaceDAO.KlantAdresDAO;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Sonja
 */

public class KlantAdresDAOFirebird implements KlantAdresDAO {
    static Logger logger = LoggerFactory.getLogger(KlantAdresDAOFirebird.class);
    
    @Override
    public KlantAdres createKlantAdresKoppel(KlantAdres koppel) throws MySQLIntegrityConstraintViolationException{
        KlantAdres klantAdresKoppel = koppel;
        try (Connection connection = DBConnectorFirebird.getConnection()) {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            String sql = "INSERT INTO koppelklantadres (klant_id, adres_id) "
                    + "values (?, ?)";
            
            PreparedStatement stmntCKA = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS); //1, 2
            stmntCKA.setInt(1, koppel.getKlant_id() );
            stmntCKA.setInt(2, koppel.getAdres_id() );
            
            stmntCKA.executeUpdate();
            
            ResultSet resultSet = stmntCKA.getGeneratedKeys();
            if (resultSet.isBeforeFirst()){
                resultSet.next();
                //wijs een door de database gegenereerd id toe aan klant
                klantAdresKoppel.setKoppel_id(resultSet.getInt(1)); 
            } 
        }
        
        catch(Exception ex){
            System.out.println("Probeer opnieuw.\n\n");
            ex.printStackTrace();     
        }
        
        return klantAdresKoppel;
    }
    
    @Override
     public ArrayList<Integer> readKlantID(int adres_id){
        ArrayList<Integer> klantIDLijst = new ArrayList();
        int i = 0;
        try (Connection connection = DBConnectorFirebird.getConnection()) {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            PreparedStatement stmntRKID = connection.prepareStatement(
                    "SELECT klant_id FROM koppelklantadres "
                            + "WHERE adres_id LIKE ? ");
            
            stmntRKID.setInt(1, adres_id);

            ResultSet readKlantResult = stmntRKID.executeQuery();
                logger.info("Statement uitgevoerd.");
            
            while (readKlantResult.next()){
                i++;
                klantIDLijst.add(readKlantResult.getInt("klant_id"));
            }
        }
        
        catch(Exception ex){
            System.out.println("Probeer opnieuw.\n\n");
            ex.printStackTrace();     
        }
        
        System.out.println("Er zijn " + i + " klanten gevonden op dit adres.");
        return klantIDLijst;
    }
    
     
     //helemaal aangepast
    @Override
    public ArrayList<Adres> readAdresID(int klant_id){
        ArrayList<Adres> adresLijst = new ArrayList();
        
        try(Connection connection = DBConnectorFirebird.getConnection()){
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            String sql= "SELECT adres_id FROM koppelklantadres "
                            + "WHERE klant_id LIKE ?";
            
            PreparedStatement stmntRABID = connection.prepareStatement(sql);
            
            stmntRABID.setInt(1, klant_id );
            ResultSet rs = stmntRABID.executeQuery();
     
            while(rs.next()){
                Adres adres = (new AdresDAOFirebird()).readAdresByID(rs.getInt("adres_id"));
                adresLijst.add(adres);
            }
        }
        
        catch(Exception ex){
            System.out.println("Probeer opnieuw.\n\n");
            ex.printStackTrace();     
        }
        
        return adresLijst;
    }
    
    @Override
    public void updateKlantAdresKoppel(){
    }
            
            
    @Override
    public void deleteKlantAdresKoppel(int klant_id){
        try (Connection connection = DBConnectorFirebird.getConnection()) {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            PreparedStatement stmntDKID = connection.prepareStatement(
                    "DELETE FROM koppelklantadres WHERE klant_id=?");
            
            stmntDKID.setString(1, Integer.toString(klant_id));

            stmntDKID.executeUpdate();
        }
        catch(Exception ex){
            ex.printStackTrace();            
        }
    }
    
    @Override
    public void deleteAdresKlantKoppel(int adres_id){
        try (Connection connection = DBConnectorFirebird.getConnection()) {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            PreparedStatement stmntDAID = connection.prepareStatement(
                    "DELETE FROM koppelklantadres WHERE adres_id=?");
            stmntDAID.setString(1, Integer.toString(adres_id));

            stmntDAID.executeUpdate();
        }
        catch(Exception ex){
            System.out.println("Probeer opnieuw.\n\n");
            ex.printStackTrace();            
        }
    }
}

