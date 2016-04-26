/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

import ConnectionPools.ConnectionPool;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class KoppelKlantAdresDAO {
    public static KoppelKlantAdres createKlantAdresKoppel(KoppelKlantAdres koppel) throws com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException {
        KoppelKlantAdres koppelKlantAdresOut = koppel;
        try (
            Connection connection = ConnectionPool.getConnection();
                ) {
            PreparedStatement createKoppel = connection.prepareStatement("insert into koppelklantadres ("
                    + "klant_id, adres_id)"
                    + "values (?, ?)"); //1, 2
            createKoppel.setInt(1, koppel.getKlant_id() );
            createKoppel.setInt(2, koppel.getAdres_id() );
            
            createKoppel.execute();
            
            ResultSet koppelData = createKoppel.getGeneratedKeys();
            koppelData.next();
            koppelKlantAdresOut.setKoppel_id( koppelData.getInt(1) );
            
        }
        catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex){
            System.out.println("Dit klant_idadres_idKoppel bestaat al; Geen actie ondernomen.");         
        }
        catch(Exception ex){
            ex.printStackTrace();     
        }
        return koppelKlantAdresOut;
    }
    
     public static ArrayList<Integer> readKlantID(int adres_id){
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
            ex.printStackTrace();     
        }
        System.out.println("" + i +" klanten gevonden op dit adres.");
        return allKlant_id;
    }
    
     
     //helemaal aangepast
    public static ArrayList<Adres> readAdresID(int klant_id){
        ArrayList<Adres> adresLijst = new ArrayList();
        
        try(Connection connection = ConnectionPool.getConnection()){
            
            String sql= "select adres_id from koppelklantadres "
                            + "where klant_id LIKE ? ";
            
            PreparedStatement pstmt = connection.prepareStatement(sql);
            
            pstmt.setInt(1, klant_id );
            ResultSet rs = pstmt.executeQuery();
            
            
            while(rs.next()){
                Adres adres = AdresDAO.readAdresByID(rs.getInt("adres_id"));
                adresLijst.add(adres);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();     
        }
        
        return adresLijst;
    }
    
    private static void updateKlantAdresKoppel(){
    }
            
            
    public static void deleteKlantAdresKoppel(int klant_id){
        try (
            Connection connection = ConnectionPool.getConnection();
                ) {
            PreparedStatement deleteByKlant_id = connection.prepareStatement(
                    "delete from koppelklantadres where klant_id = ?");
            
            deleteByKlant_id.setString(1, Integer.toString(klant_id) );

            deleteByKlant_id.executeUpdate();
        }
        catch(Exception ex){
            ex.printStackTrace();            
        }
    }
    
    public static void deleteAdresKlantKoppel(int adres_id){
        try (
            Connection connection = ConnectionPool.getConnection();
                ) {
            PreparedStatement deleteByAdres_id = connection.prepareStatement(
                    "delete from koppelklantadres where adres_id = ?");
            deleteByAdres_id.setString(1, Integer.toString(adres_id) );

            deleteByAdres_id.executeUpdate();
        }
        catch(Exception ex){
            ex.printStackTrace();            
        }
    }
}
