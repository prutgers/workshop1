/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS; // help mij hiermee :D
import javax.sql.RowSet;
import com.sun.rowset.*;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class KoppelBestellingArtikelDAO {
    
    
    // Toe te voegen is Statement.RETURN_GENERATED_KEYS zoals in KlantDAO
    
    public static void createKoppelBestellingArtikel(int bestelling_id, int artikel_id){
        String query = "INSERT INTO bestellingartikel (bestelling_id, artikel_id)"
                + " values (?, ?)";
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, bestelling_id);
            pstmt.setInt(2, artikel_id);
            pstmt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in createKoppelBestellingArtikel");
            e.printStackTrace();
        }
    }
    
    public static ArrayList<KoppelBestellingArtikel> readKoppelMetBestellingID(int bestelling_id){
        ArrayList<KoppelBestellingArtikel> lijst = new ArrayList<KoppelBestellingArtikel>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            RowSet rowSet = new JdbcRowSetImpl();
            rowSet.setUrl("jdbc:mysql://localhost/workshopdb");
            rowSet.setUsername("rsvier");
            rowSet.setPassword("tiger");
            rowSet.setCommand("SELECT * FROM bestellingartikel WHERE bestelling_id = " + bestelling_id);
            rowSet.execute();
            
            while(rowSet.next()){
                KoppelBestellingArtikel koppel = new KoppelBestellingArtikel();
                koppel.setBestelling_id(rowSet.getInt("bestelling_id"));
                koppel.setArtikel_id(rowSet.getInt("artikel_id"));
                lijst.add(koppel);
                // test voor mij te kijken of het werkt dit moet natuurlijk normaal in het menu gebeuren
                System.out.println("Bestelling en Artikkel ID " + rowSet.getInt("bestelling_id") + "  " + rowSet.getInt("artikel_id"));
            }
            
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in readKoppelMetBestelling");
            e.printStackTrace();
        }
        return lijst;
    }
    
    public static ArrayList<KoppelBestellingArtikel> readKoppelMetArtikelID(int artikel_id){
        ArrayList<KoppelBestellingArtikel> lijst = new ArrayList<KoppelBestellingArtikel>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            RowSet rowSet = new JdbcRowSetImpl();
            rowSet.setUrl("jdbc:mysql://localhost/workshopdb");
            rowSet.setUsername("rsvier");
            rowSet.setPassword("tiger");
            rowSet.setCommand("SELECT * FROM bestellingartikel WHERE artikel_id = " + artikel_id);
            rowSet.execute();
            
            while(rowSet.next()){
                KoppelBestellingArtikel koppel = new KoppelBestellingArtikel();
                koppel.setBestelling_id(rowSet.getInt("bestelling_id"));
                koppel.setArtikel_id(rowSet.getInt("artikel_id"));
                lijst.add(koppel);
                // test voor mij te kijken of het werkt dit moet natuurlijk normaal in het menu gebeuren
                System.out.println("Bestelling en Artikkel ID " + rowSet.getInt("bestelling_id") + "  " + rowSet.getInt("artikel_id"));
            }
            
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in readKoppelMetBestelling");
            e.printStackTrace();
        }
        return lijst;
    }
    
    public static void deleteKoppelMetBestellingID(int bestelling_id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            RowSet rowSet = new JdbcRowSetImpl();
            rowSet.setUrl("jdbc:mysql://localhost/workshopdb");
            rowSet.setUsername("rsvier");
            rowSet.setPassword("tiger");
            rowSet.setCommand("SELECT * FROM bestellingartikel WHERE bestelling_id = " + bestelling_id);
            rowSet.execute();
            
            while(rowSet.next()){
                rowSet.deleteRow();
                // test voor mij te kijken of het werkt dit moet natuurlijk normaal in het menu gebeuren
                System.out.println("ik ben aan het deleten");
            }
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in readKoppelMetBestelling");
            e.printStackTrace();
        }
    }
    
    public static void deleteKoppelMetArtikelID(int artikel_id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            RowSet rowSet = new JdbcRowSetImpl();
            rowSet.setUrl("jdbc:mysql://localhost/workshopdb");
            rowSet.setUsername("rsvier");
            rowSet.setPassword("tiger");
            rowSet.setCommand("SELECT * FROM bestellingartikel WHERE artikel_id= " + artikel_id);
            rowSet.execute();
            
            while(rowSet.next()){
                rowSet.deleteRow();
            }
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in readKoppelMetBestelling");
            e.printStackTrace();
        }
    }
    
    public static void deleteKoppelID(int koppel_id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            RowSet rowSet = new JdbcRowSetImpl();
            rowSet.setUrl("jdbc:mysql://localhost/workshopdb");
            rowSet.setUsername("rsvier");
            rowSet.setPassword("tiger");
            rowSet.setCommand("SELECT * FROM bestellingartikel WHERE bestellingartikel_id = " + koppel_id);
            rowSet.execute();
            
            while(rowSet.next()){
                rowSet.deleteRow();
             }
            
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in readKoppelMetBestelling");
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
}
