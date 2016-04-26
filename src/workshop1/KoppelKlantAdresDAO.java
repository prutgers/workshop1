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
    public static void createKlantAdresKoppel(KoppelKlantAdres koppel) throws com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException {
        try ( CachedRowSetImpl connection = new CachedRowSetImpl();
                ) {
            connection.setUrl("jdbc:mysql://localhost/workshopdb");
            connection.setUsername("rsvier");
            connection.setPassword("tiger");
            
            connection.setCommand("insert into koppelklantadres ("
                    + "klant_id, adres_id)"
                    + "values (?, ?)"); //1, 2
            connection.setInt(1, koppel.getKlant_id() );
            connection.setInt(2, koppel.getAdres_id() );
        }
        catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex){
            System.out.println("Dit klant_idadres_idKoppel bestaat al; Geen actie ondernomen.");         
        }
        catch(Exception ex){
            ex.printStackTrace();     
        }
    }
    
    public static ArrayList<Integer> readKlantID(int adres_id){
        ArrayList<Integer> allKlant_id = new ArrayList();
        int i = 0;
        try ( CachedRowSetImpl connection = new CachedRowSetImpl();
                ) {
            connection.setUrl("jdbc:mysql://localhost/workshopdb");
            connection.setUsername("rsvier");
            connection.setPassword("tiger");
            
            connection.setCommand(
                    "select klant_id from koppelklantadres "
                            + "where adres_id LIKE ? ");
            
            connection.setInt(1, adres_id );

            connection.execute();
            
            while (connection.next()){
                i++;
                allKlant_id.add( connection.getInt("klant_id") );
            }
        }
        catch(Exception ex){
            ex.printStackTrace();     
        }
        System.out.println("" + i +" klanten gevonden op dit adres.");
        return allKlant_id;
    }
    
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
        try ( CachedRowSetImpl connection = new CachedRowSetImpl();
                ) {
            connection.setUrl("jdbc:mysql://localhost/workshopdb");
            connection.setUsername("rsvier");
            connection.setPassword("tiger");
            
            connection.setCommand(
                    "delete from koppelklantadres where klant_id = ?");
            connection.setString(1, Integer.toString(klant_id) );

            connection.execute();
        }
        catch(Exception ex){
            ex.printStackTrace();            
        }
    }
    
    public static void deleteAdresKlantKoppel(int adres_id){
        try ( CachedRowSetImpl connection = new CachedRowSetImpl();
                ) {
            connection.setUrl("jdbc:mysql://localhost/workshopdb");
            connection.setUsername("rsvier");
            connection.setPassword("tiger");
            
            connection.setCommand(
                    "delete from koppelklantadres where adres_id = ?");
            connection.setString(1, Integer.toString(adres_id) );

            connection.execute();
        }
        catch(Exception ex){
            ex.printStackTrace();            
        }
    }
}
