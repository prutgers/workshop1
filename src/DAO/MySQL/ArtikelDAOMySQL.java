/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MySQL;

/**
 *
 * @author Peter
 */

/**
 * ArtikelDAO doet momenteen nog alles het zou mooi zijn als ik de connectie lost weet te koppelen
 * @author Peter
 */

import java.sql.*;
import java.util.ArrayList;
import ConnectionPools.*;
import POJO.Artikel;
import interfaceDAO.ArtikelDAO;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS; 

public class ArtikelDAOMySQL implements ArtikelDAO {

   @Override
   public Artikel createArtikel(Artikel artikel){
        //Haal een connectie uit de ConnectiePool
        try(Connection connection = ConnectionPool.getConnection();) {
            String sql = "INSERT INTO artikel("
            + "artikel_naam,"
            + "artikel_voorraad,"
            + "artikel_prijs) "
            +  "VALUES(?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            // Ken de juiste waarden toe an de database variabelen
            pstmt.setString(1, artikel.getArtikel_naam());
            pstmt.setInt(2, artikel.getArtikel_voorraad());
            pstmt.setBigDecimal(3, artikel.getArtikel_prijs());
            // Voer het Prepared Statement uit
            pstmt.executeUpdate();
            // Haal de generated key op van nieuw toegevoegde artikel
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.isBeforeFirst()){
                rs.next();
                artikel.setArtikel_id(rs.getInt(1)); 
            }
            pstmt.close();
        } 
        catch (SQLException e){
                e.printStackTrace();
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(ArtikelDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
       }
        //Geef het nieuwe artikel terug inclusief de generated key
        return artikel;
    }
   
   @Override
   public ArrayList<Artikel> readArtikel(){
        ArrayList<Artikel> artikelLijst = new ArrayList<Artikel>();
        try(Connection connection = ConnectionPool.getConnection()){
           String query = "SELECT * FROM artikel";
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery(query);
            while (rs.next()) {
                Artikel artikel = new Artikel(); 
                artikel.setArtikel_id(rs.getInt("artikel_id"));
                artikel.setArtikel_naam(rs.getString("artikel_naam"));
                artikel.setArtikel_voorraad(rs.getInt("artikel_voorraad"));
                artikel.setArtikel_prijs(rs.getBigDecimal("artikel_prijs"));
                artikelLijst.add(artikel);
            }
            pstmt.close();
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("verdorie mislukt");
        } 
       return artikelLijst;
   }
   
   @Override
   public Artikel readArtikel(int artikel_id){
        Artikel artikel = new Artikel();
        try(Connection connection = ConnectionPool.getConnection();){
            String query = "SELECT * FROM artikel WHERE artikel_id = " + artikel_id;
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery(query);
            while (rs.next()) {
                artikel.setArtikel_id(rs.getInt("artikel_id"));
                artikel.setArtikel_naam(rs.getString("artikel_naam"));
                artikel.setArtikel_voorraad(rs.getInt("artikel_voorraad"));
                artikel.setArtikel_prijs(rs.getBigDecimal("artikel_prijs"));
                
                /**
                 * kan ook met artikelbuilder
                 */
                //artikel = new Artikel.ArtikelBuilder().artikel_naam(rs.getString("artikel_naam")).artikel_prijs(rs.getBigDecimal("artikel_prijs")).artikel_voorraad(rs.getInt("artikel_voorraad")).artikel_id(rs.getInt("artikel_id")).build();
            }
            pstmt.close();
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("verdorie mislukt");
        } 
       return artikel;
    }
   
   @Override
   public void updateArtikel(Artikel artikel){
        try(Connection connection = ConnectionPool.getConnection();){
            String update = "UPDATE artikel SET artikel_naam = ?, "
                      + " artikel_voorraad = ?, "
                      + " artikel_prijs = ? "
                        + "WHERE artikel_id = ? ";
            PreparedStatement pstmt = connection.prepareStatement(update);
            pstmt.setString(1, artikel.getArtikel_naam());
            pstmt.setInt(2, artikel.getArtikel_voorraad());
            pstmt.setBigDecimal(3, artikel.getArtikel_prijs());
            pstmt.setInt(4, artikel.getArtikel_id());
            pstmt.executeUpdate();
            pstmt.close();
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("verdorie mislukt");
        } 
    }
   
   @Override
   public void deleteArtikel(int artikel_ID) {
        
        try(Connection connection = ConnectionPool.getConnection();){
            String update = "DELETE FROM artikel WHERE artikel_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(update);
            pstmt.setInt(1, artikel_ID);
            pstmt.executeUpdate();
            pstmt.close();
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("verdorie mislukt");
        }  
   }
}
