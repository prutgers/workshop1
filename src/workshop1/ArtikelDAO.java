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

import java.sql.*;

public class ArtikelDAO {

   public void createNewArtikel(Artikel artikel){
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
   
   public Artikel readArtikel(){
        Artikel artikel = new Artikel();
       
        String user = "rsvier";
        String password = "tiger";
        String datbaseUrl = "jdbc:mysql://localhost/workshopdb";

        try(Connection connection = DriverManager.getConnection(datbaseUrl, user, password)){
            Class.forName("com.mysql.jdbc.Driver");
            
            String query = "SELECT * FROM artikel";
            
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery(query);
            
         System.out.format("%s, %s, %s, %s\n", "id", "artikel_naam", "artikel_prijs", "artikel_voorraad");
            while (rs.next())
      {
          
        int id = rs.getInt("artikel_id");
        String artikel_naam = rs.getString("artikel_naam");
        double artikel_prijs = rs.getDouble("artikel_prijs");
        int artikel_voorraad = rs.getInt("artikel_voorraad");
        
       
         
        // print the results
        //System.out.println("id " + id + " Artikel naam " + artikel_naam);
       
        System.out.format("%s, %s, %s, %s\n", id, artikel_naam, artikel_prijs, artikel_voorraad);
      }
      pstmt.close();
            
       
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("verdorie mislukt");
        } 
       return artikel;
   }
   
   public void updateArtikel(Artikel artikel){
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
   
   public void deleteArtikel(int artikel_ID) {
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
