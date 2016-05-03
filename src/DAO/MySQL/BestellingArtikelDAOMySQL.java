/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MySQL;

import ConnectionPools.DBConnector;
import POJO.BestellingArtikel;
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
public class BestellingArtikelDAOMySQL {
    
    
    // Toe te voegen is Statement.RETURN_GENERATED_KEYS zoals in KlantDAO
    
    public void createKoppelBestellingArtikel(BestellingArtikel koppelBestellingArtikel){
        String query = "INSERT INTO bestellingartikel (bestelling_id, artikel_id, aantal)"
                + " values (?, ?, ?)";
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, koppelBestellingArtikel.getBestelling_id());
            pstmt.setInt(2, koppelBestellingArtikel.getArtikel_id());
            pstmt.setInt(3, koppelBestellingArtikel.getAantal());
            pstmt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in createKoppelBestellingArtikel");
            e.printStackTrace();
        }
    }
    
    public ArrayList<BestellingArtikel> readKoppelMetBestellingID(int bestelling_id){
        ArrayList<BestellingArtikel> lijst = new ArrayList<BestellingArtikel>();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            RowSet rowSet = new JdbcRowSetImpl();
            rowSet.setUrl("jdbc:mysql://localhost/workshopdb");
            rowSet.setUsername("rsvier");
            rowSet.setPassword("tiger");
            rowSet.setCommand("SELECT * FROM bestellingartikel WHERE bestelling_id = " + bestelling_id);
            rowSet.execute();
            
            while(rowSet.next()){
                BestellingArtikel koppel = new BestellingArtikel();
                koppel.setAantal(rowSet.getInt("aantal"));
                koppel.setBestelling_id(rowSet.getInt("bestelling_id"));
                koppel.setArtikel_id(rowSet.getInt("artikel_id"));
                lijst.add(koppel);
                
            }
            
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in readKoppelMetBestelling");
            e.printStackTrace();
        }
        return lijst;
    }
    
    public ArrayList<BestellingArtikel> readKoppelMetArtikelID(int artikel_id){
        ArrayList<BestellingArtikel> lijst = new ArrayList<BestellingArtikel>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            RowSet rowSet = new JdbcRowSetImpl();
            rowSet.setUrl("jdbc:mysql://localhost/workshopdb");
            rowSet.setUsername("rsvier");
            rowSet.setPassword("tiger");
            rowSet.setCommand("SELECT * FROM bestellingartikel WHERE artikel_id = " + artikel_id);
            rowSet.execute();
            
            while(rowSet.next()){
                BestellingArtikel koppel = new BestellingArtikel();
                koppel.setKoppel_id(rowSet.getInt("bestellingartikel_id"));
                koppel.setBestelling_id(rowSet.getInt("bestelling_id"));
                koppel.setArtikel_id(rowSet.getInt("artikel_id"));
                lijst.add(koppel);
                
            }
            
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in readKoppelMetBestelling");
            e.printStackTrace();
        }
        return lijst;
    }
    
    public BestellingArtikel readKoppel(int bestelling_id, int artikel_id){
        BestellingArtikel koppel = new BestellingArtikel();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            RowSet rowSet = new JdbcRowSetImpl();
            rowSet.setUrl("jdbc:mysql://localhost/workshopdb");
            rowSet.setUsername("rsvier");
            rowSet.setPassword("tiger");
            rowSet.setCommand("SELECT * FROM bestellingartikel WHERE bestelling_id = " + bestelling_id + " AND artikel_id = " + artikel_id);
            rowSet.execute();

            while(rowSet.next()){
                koppel.setKoppel_id(rowSet.getInt("bestellingartikel_id"));
                koppel.setBestelling_id(rowSet.getInt("bestelling_id"));
                koppel.setArtikel_id(rowSet.getInt("artikel_id"));
                koppel.setAantal(rowSet.getInt("aantal"));
                
            }

        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in readKoppelMetBestelling");
            e.printStackTrace();
        }
        return koppel;
    }
    
    public void deleteKoppelMetBestellingID(int bestelling_id){
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
                
            }
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in readKoppelMetBestelling");
            e.printStackTrace();
        }
    }
    
    // dit is waarschijnlijk onzin
    public void deleteKoppelMetArtikelID(int artikel_id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            RowSet rowSet = new JdbcRowSetImpl();
            rowSet.setUrl("jdbc:mysql://localhost/workshopdb");
            rowSet.setUsername("rsvier");
            rowSet.setPassword("tiger");
            rowSet.setCommand("SELECT * FROM bestellingartikel WHERE artikel_id = " + artikel_id);
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
    
    
    
    public void deleteKoppel(int bestellingID,int artikelID){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            RowSet rowSet = new JdbcRowSetImpl();
            rowSet.setUrl("jdbc:mysql://localhost/workshopdb");
            rowSet.setUsername("rsvier");
            rowSet.setPassword("tiger");
            rowSet.setCommand("SELECT * FROM bestellingartikel WHERE bestelling_id = " + bestellingID + " AND artikel_id = " + artikelID);
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
    
    
    public BestellingArtikel readKoppelById(int koppelID){
        BestellingArtikel koppel = new BestellingArtikel();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            RowSet rowSet = new JdbcRowSetImpl();
            rowSet.setUrl("jdbc:mysql://localhost/workshopdb");
            rowSet.setUsername("rsvier");
            rowSet.setPassword("tiger");
            rowSet.setCommand("SELECT * FROM bestellingartikel WHERE koppel_id = " + koppelID);
            rowSet.execute();

            koppel.setBestelling_id(rowSet.getInt("bestelling_id"));
            koppel.setArtikel_id(rowSet.getInt("artikel_id"));
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in readKoppelMetBestelling");
            e.printStackTrace();
        }
        return koppel;
    }
    
    public void updateKoppel(BestellingArtikel koppel){
       String query = "UPDATE bestellingartikel SET " 
                    + " bestelling_id = ?, "
                    + " artikel_id = ?, "
                    + " aantal = ? " 
                    + " WHERE bestellingartikel_id = ?;";

        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1,koppel.getBestelling_id());
            pstmt.setInt(2,koppel.getArtikel_id());
            pstmt.setInt(3,koppel.getAantal());
            pstmt.setInt(4,koppel.getKoppel_id());
            pstmt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in createKoppelBestellingArtikel");
            e.printStackTrace();
        }
    }
        
    /**
     * 
     * dit werk niet maar waarom is nog onbekend gelukkig is er ook een werkende versie hoera voor Herman!!!!!
    public static void updateKoppel2(KoppelBestellingArtikel koppel){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            RowSet rowSet = new JdbcRowSetImpl();
            rowSet.setUrl("jdbc:mysql://localhost/workshopdb");
            rowSet.setUsername("rsvier");
            rowSet.setPassword("tiger");
            
            rowSet.setCommand("SELECT bestellingartikel SET " 
                    + " bestelling_id = " + koppel.getBestelling_id()
                    + " ,artikel_id= " + koppel.getArtikel_id() 
                    + " ,aantal = " + koppel.getAantal() 
                    + " WHERE bestellingartikel_id = " + koppel.getKoppel_id() + ";");
            rowSet.execute();
            
            while(rowSet.next()){
                rowSet.updateRow();
             }
            
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in readKoppelMetBestelling");
            e.printStackTrace();
        }
    }  
    */    
        
        
}
