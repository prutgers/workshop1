/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

/**
 *
 * @author Peter
 */

/**
 * ArtikelDAO doet momenteen nog alles het zou mooi zijn als ik de connectie lost weet te koppelen
 * @author Peter
 */

/**
 * Deze firebird downloaden
 * http://sourceforge.net/projects/firebird/files/firebird-win64/2.5.5-Release/Firebird-2.5.5.26952_0_x64.exe/download
 * install met alle opties zoals ze standaard staan ik heb een super server aangevinkt
 * 
 * extra documentatie voor de start http://www.firebirdsql.org/file/documentation/reference_manuals/user_manuals/html/qsg25.html
 * 
 */

import java.sql.*;
import java.util.ArrayList;

public class ArtikelDAOFirebird {

   public static void createNewArtikel(Artikel artikel){
        //Connect to database
        String user = "rsvier";
        String password = "tiger";
        String datbaseUrl = "jdbc:mysql://localhost/workshopdb";
        try(Connection connection = DriverManager.getConnection(datbaseUrl, user, password)){
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "INSERT INTO artikel("
            + "artikel_naam,"
            + "artikel_voorraad,"
            + "artikel_prijs) "
            +  "VALUES(?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            // Set the values
            pstmt.setString(1, artikel.getArtikel_naam());
            pstmt.setInt(2, artikel.getArtikel_voorraad());
            pstmt.setDouble(3, artikel.getArtikel_prijs());
            // Insert 
            pstmt.executeUpdate();
            pstmt.close();
        } 
        catch (ClassNotFoundException | SQLException e){
                System.out.println("verdorie mislukt");
        }
    }
   
   public static ArrayList<Artikel> readArtikel(){
        ArrayList<Artikel> artikelLijst = new ArrayList<Artikel>();
        String user = "rsvier";
        String password = "tiger";
        String datbaseUrl = "jdbc:mysql://localhost/workshopdb";
        try(Connection connection = DriverManager.getConnection(datbaseUrl, user, password)){
            Class.forName("com.mysql.jdbc.Driver");
            String query = "SELECT * FROM artikel";
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery(query);
            while (rs.next()) {
                Artikel artikel = new Artikel(); 
                artikel.setArtikel_id(rs.getInt("artikel_id"));
                artikel.setArtikel_naam(rs.getString("artikel_naam"));
                artikel.setArtikel_voorraad(rs.getInt("artikel_voorraad"));
                artikel.setArtikel_prijs(rs.getDouble("artikel_prijs"));
                artikelLijst.add(artikel);
            }
            pstmt.close();
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("verdorie mislukt");
        } 
       return artikelLijst;
   }
   
   public static Artikel readArtikel(int artikel_id){
        Artikel artikel = new Artikel();
        String user = "rsvier";
        String password = "tiger";
        String datbaseUrl = "jdbc:mysql://localhost/workshopdb";

        try(Connection connection = DriverManager.getConnection(datbaseUrl, user, password)){
            Class.forName("com.mysql.jdbc.Driver");
            String query = "SELECT * FROM artikel WHERE artikel_id = " + artikel_id;
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery(query);
            while (rs.next()) {
                artikel.setArtikel_id(rs.getInt("artikel_id"));
                artikel.setArtikel_naam(rs.getString("artikel_naam"));
                artikel.setArtikel_voorraad(rs.getInt("artikel_voorraad"));
                artikel.setArtikel_prijs(rs.getDouble("artikel_prijs"));
            }
            pstmt.close();
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("verdorie mislukt");
        } 
       return artikel;
    }
   
   public static void updateArtikel(Artikel artikel){
        String user = "rsvier";
        String password = "tiger";
        String datbaseUrl = "jdbc:mysql://localhost/workshopdb";
        try(Connection connection = DriverManager.getConnection(datbaseUrl, user, password)){
            Class.forName("com.mysql.jdbc.Driver");
            String update = "UPDATE artikel SET artikel_naam = ?, "
                      + " artikel_voorraad = ?, "
                      + " artikel_prijs = ? "
                        + "WHERE artikel_id = ? ";
            PreparedStatement pstmt = connection.prepareStatement(update);
            pstmt.setString(1, artikel.getArtikel_naam());
            pstmt.setInt(2, artikel.getArtikel_voorraad());
            pstmt.setDouble(3, artikel.getArtikel_prijs());
            pstmt.setInt(4, artikel.getArtikel_id());
            pstmt.executeUpdate();
            pstmt.close();
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("verdorie misluktFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
        } 
    }
   
   public static void deleteArtikel(int artikel_ID) {
        String user = "rsvier";
        String password = "tiger";
        String datbaseUrl = "jdbc:mysql://localhost/workshopdb";
        try(Connection connection = DriverManager.getConnection(datbaseUrl, user, password)){
            Class.forName("com.mysql.jdbc.Driver");
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
