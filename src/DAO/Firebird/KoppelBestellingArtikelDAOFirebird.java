/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Firebird;

import ConnectionPools.DBConnectorFirebird;
import POJO.KoppelBestellingArtikel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS; // help mij hiermee :D
import javax.sql.RowSet;
import com.sun.rowset.*;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class KoppelBestellingArtikelDAOFirebird {
    
    
    // Toe te voegen is Statement.RETURN_GENERATED_KEYS zoals in KlantDAO
    
    public static void createKoppelBestellingArtikel(KoppelBestellingArtikel koppelBestellingArtikel){
        String query = "INSERT INTO bestellingartikel (bestelling_id, artikel_id, aantal)"
                + " values (?, ?, ?)";
       try(Connection connection = DBConnectorFirebird.getConnection();){
            PreparedStatement pstmt = connection.prepareStatement(query);
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
    
    public static ArrayList<KoppelBestellingArtikel> readKoppelMetBestellingID(int bestelling_id){
        ArrayList<KoppelBestellingArtikel> lijst = new ArrayList<>();
        
        try (Connection connection = DBConnectorFirebird.getConnection()){
            String sql = "SELECT * FROM bestellingartikel WHERE bestelling_id = " + bestelling_id;
            
            Statement pstmt = connection.createStatement();
            ResultSet rs = pstmt.executeQuery(sql);
            
            while(rs.next()){
                KoppelBestellingArtikel koppel = new KoppelBestellingArtikel();
                koppel.setKoppel_id(rs.getInt("bestellingartikel_id"));
                koppel.setBestelling_id(rs.getInt("bestelling_id"));
                koppel.setArtikel_id(rs.getInt("artikel_id"));
                lijst.add(koppel);
                
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
        try (Connection connection = DBConnectorFirebird.getConnection()){
            String sql = "SELECT * FROM bestellingartikel WHERE artikel_id = " + artikel_id;
            Statement pstmt = connection.createStatement();
            ResultSet rs = pstmt.executeQuery(sql);
            
            while(rs.next()){
                KoppelBestellingArtikel koppel = new KoppelBestellingArtikel();
                koppel.setKoppel_id(rs.getInt("bestellingartikel_id"));
                koppel.setBestelling_id(rs.getInt("bestelling_id"));
                koppel.setArtikel_id(rs.getInt("artikel_id"));
                lijst.add(koppel);
            }
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in readKoppelMetBestelling");
            e.printStackTrace();
        }
        return lijst;
    }
    
    public static KoppelBestellingArtikel readKoppel(int bestelling_id, int artikel_id){
        KoppelBestellingArtikel koppel = new KoppelBestellingArtikel();
        try (Connection connection = DBConnectorFirebird.getConnection()){
            String sql = "SELECT * FROM bestellingartikel WHERE bestelling_id = " + bestelling_id + " AND artikel_id = " + artikel_id;
            Statement pstmt = connection.createStatement();
            ResultSet rs = pstmt.executeQuery(sql);

            while(rs.next()){
                koppel.setKoppel_id(rs.getInt("bestellingartikel_id"));
                koppel.setBestelling_id(rs.getInt("bestelling_id"));
                koppel.setArtikel_id(rs.getInt("artikel_id"));
                koppel.setAantal(rs.getInt("aantal"));
                
            }

        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in readKoppelMetBestelling");
            e.printStackTrace();
        }
        return koppel;
    }
    
    public static void deleteKoppelMetBestellingID(int bestelling_id){
        try(Connection connection = DBConnectorFirebird.getConnection()) {
            String sql = "DELETE FROM bestellingartikel WHERE bestelling_id = " + bestelling_id;
            Statement pstmt = connection.createStatement();
            pstmt.executeUpdate(sql);
            pstmt.close();
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in readKoppelMetBestelling");
            e.printStackTrace();
        }
    }
    
    // dit is waarschijnlijk onzin
    public static void deleteKoppelMetArtikelID(int artikel_id){
        try(Connection connection = DBConnectorFirebird.getConnection()) {
            String sql = "DELETE FROM bestellingartikel WHERE artikel_id = " + artikel_id;
            Statement pstmt = connection.createStatement();
            pstmt.executeUpdate(sql);
            pstmt.close();
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in readKoppelMetBestelling");
            e.printStackTrace();
        }
    }
    
    
    
    public static void deleteKoppel(int bestellingID,int artikelID){
        try(Connection connection = DBConnectorFirebird.getConnection()) {
            String sql = "DELETE FROM bestellingartikel WHERE bestelling_id = " + bestellingID + " AND artikel_id = " + artikelID;
            Statement pstmt = connection.createStatement();
            pstmt.executeUpdate(sql);
            pstmt.close();
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in readKoppelMetBestelling");
            e.printStackTrace();
        }
    }
    
    
    public static KoppelBestellingArtikel readKoppelById(int koppelID){
       KoppelBestellingArtikel koppel = new KoppelBestellingArtikel();
        try (Connection connection = DBConnectorFirebird.getConnection()){
            String sql = "SELECT * FROM bestellingartikel WHERE koppel_id = " + koppelID;
            Statement pstmt = connection.createStatement();
            ResultSet rs = pstmt.executeQuery(sql);

            while(rs.next()){
                koppel.setKoppel_id(rs.getInt("bestellingartikel_id"));
                koppel.setBestelling_id(rs.getInt("bestelling_id"));
                koppel.setArtikel_id(rs.getInt("artikel_id"));
                koppel.setAantal(rs.getInt("aantal"));
                
            }
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Fout in readKoppelMetBestelling");
            e.printStackTrace();
        }
        return koppel;
    }
    
    public static void updateKoppel(KoppelBestellingArtikel koppel){
       String query = "UPDATE bestellingartikel SET " 
                    + " bestelling_id = ?, "
                    + " artikel_id = ?, "
                    + " aantal = ? " 
                    + " WHERE bestellingartikel_id = ?;";

        try(Connection connection = DBConnectorFirebird.getConnection()){
            PreparedStatement pstmt = connection.prepareStatement(query);
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
 }
