/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MySQL;

import ConnectionPools.ConnectionPool;
import POJO.Adres;
import POJO.KlantAdres;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import interfaceDAO.KlantAdresDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author lucas
 */
public class KlantAdresDAOMySQL implements KlantAdresDAO {
    static Logger logger = LoggerFactory.getLogger(KlantAdresDAOMySQL.class);
    
    @Override
    public KlantAdres createKlantAdresKoppel(KlantAdres koppel) throws MySQLIntegrityConstraintViolationException{
        KlantAdres koppelKlantAdresOut = koppel;
        try (
            Connection connection = ConnectionPool.getConnection();
                ) {
            
            String sql = "insert into koppelklantadres ("
                    + "klant_id, adres_id)"
                    + "values (?, ?)";
            
            PreparedStatement createKoppel = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS); //1, 2
            createKoppel.setInt(1, koppel.getKlant_id() );
            createKoppel.setInt(2, koppel.getAdres_id() );
            
            createKoppel.executeUpdate();
            
            ResultSet resultSet = createKoppel.getGeneratedKeys();
            if (resultSet.isBeforeFirst()){
                resultSet.next();
                //wijs een door de database gegenereerd id toe aan de klant
                koppelKlantAdresOut.setKoppel_id(resultSet.getInt(1)); 
            }
            
        }
        
        catch(Exception ex){
            System.out.println("\nProbeer opnieuw.\n");
            ex.printStackTrace();     
        }
        return koppelKlantAdresOut;
    }
    
    @Override
     public ArrayList<Integer> readKlantID(int adres_id){
        ArrayList<Integer> allKlant_id = new ArrayList();
        int i = 0;
        try (
            Connection connection = ConnectionPool.getConnection();
                ) {
            PreparedStatement readKlant_id = connection.prepareStatement(
                    "select klant_id from koppelklantadres "
                            + "where adres_id LIKE ? ");
            
            readKlant_id.setInt(1, adres_id );

            ResultSet readKlantResult = readKlant_id.executeQuery();
                logger.info("Statement executed.");
            
            while (readKlantResult.next()){
                i++;
                allKlant_id.add( readKlantResult.getInt("klant_id") );
            }
        }
        catch(Exception ex){
            System.out.println("\nProbeer opnieuw.\n");
            ex.printStackTrace();     
        }
        System.out.println("Er zijn " + i + " klanten gevonden op dit adres:");
        return allKlant_id;
    }
    
     
     //helemaal aangepast
    @Override
    public ArrayList<Adres> readAdresID(int klant_id){
        ArrayList<Adres> adresLijst = new ArrayList();
        
        try(Connection connection = ConnectionPool.getConnection()){
            
            String sql= "select adres_id from koppelklantadres "
                            + "where klant_id LIKE ? ";
            
            PreparedStatement pstmt = connection.prepareStatement(sql);
            
            pstmt.setInt(1, klant_id );
            ResultSet rs = pstmt.executeQuery();
            
            
            while(rs.next()){
                Adres adres = (new AdresDAOMySQL()).readAdresByID(rs.getInt("adres_id"));
                adresLijst.add(adres);
            }
        }
        catch(Exception ex){
            System.out.println("\nProbeer opnieuw.\n");
            ex.printStackTrace();     
        }
        
        return adresLijst;
    }
    
    @Override
    public void updateKlantAdresKoppel(){
    }
            
            
    @Override
    public void deleteKlantAdresKoppel(int klant_id){
        try (
            Connection connection = ConnectionPool.getConnection();
                ) {
            PreparedStatement deleteByKlant_id = connection.prepareStatement(
                    "delete from koppelklantadres where klant_id = ?");
            
            deleteByKlant_id.setString(1, Integer.toString(klant_id) );

            deleteByKlant_id.executeUpdate();
        }
        catch(Exception ex){
            System.out.println("\nProbeer opnieuw.\n");
            ex.printStackTrace();            
        }
    }
    
    @Override
    public void deleteAdresKlantKoppel(int adres_id){
        try (
            Connection connection = ConnectionPool.getConnection();
                ) {
            PreparedStatement deleteByAdres_id = connection.prepareStatement(
                    "delete from koppelklantadres where adres_id = ?");
            deleteByAdres_id.setString(1, Integer.toString(adres_id) );

            deleteByAdres_id.executeUpdate();
        }
        catch(Exception ex){
            System.out.println("\nProbeer opnieuw.\n");
            ex.printStackTrace();            
        }
    }
}
