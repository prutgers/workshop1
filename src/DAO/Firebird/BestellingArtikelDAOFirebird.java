/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Firebird;

import ConnectionPools.DBConnectorFirebird;
import POJO.BestellingArtikel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS; // help mij hiermee :D
import javax.sql.RowSet;
import com.sun.rowset.*;
import interfaceDAO.BestellingArtikelDAO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class BestellingArtikelDAOFirebird implements BestellingArtikelDAO {
    
    
    // Toe te voegen is Statement.RETURN_GENERATED_KEYS zoals in KlantDAO
    
    @Override
    public void createKoppelBestellingArtikel(BestellingArtikel koppelBestellingArtikel){
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
    
    @Override
    public ArrayList<BestellingArtikel> readKoppelMetBestellingID(int bestelling_id){
        ArrayList<BestellingArtikel> lijst = new ArrayList<>();
        
        try (Connection connection = DBConnectorFirebird.getConnection()){
            String sql = "SELECT * FROM bestellingartikel WHERE bestelling_id = " + bestelling_id;
            
            Statement pstmt = connection.createStatement();
            ResultSet rs = pstmt.executeQuery(sql);
            
            while(rs.next()){
                BestellingArtikel koppel = new BestellingArtikel();
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
    
    @Override
    public ArrayList<BestellingArtikel> readKoppelMetArtikelID(int artikel_id){
        ArrayList<BestellingArtikel> lijst = new ArrayList<BestellingArtikel>();
        try (Connection connection = DBConnectorFirebird.getConnection()){
            String sql = "SELECT * FROM bestellingartikel WHERE artikel_id = " + artikel_id;
            Statement pstmt = connection.createStatement();
            ResultSet rs = pstmt.executeQuery(sql);
            
            while(rs.next()){
                BestellingArtikel koppel = new BestellingArtikel();
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
    
    @Override
    public BestellingArtikel readKoppel(int bestelling_id, int artikel_id){
        BestellingArtikel koppel = new BestellingArtikel();
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
    
    @Override
    public void deleteKoppelMetBestellingID(int bestelling_id){
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
    @Override
    public void deleteKoppelMetArtikelID(int artikel_id){
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
    
    
    
    @Override
    public void deleteKoppel(int bestellingID,int artikelID){
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
    
    
    @Override
    public BestellingArtikel readKoppelById(int koppelID){
       BestellingArtikel koppel = new BestellingArtikel();
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
    
    @Override
    public void updateKoppel(BestellingArtikel koppel){
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
