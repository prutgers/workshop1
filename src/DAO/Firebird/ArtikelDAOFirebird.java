/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Firebird;

/**
 *
 * @author Peter
 */

/**
 * FIREBIRD EN JAYBIRD DOWNLOADEN ik heb de firebird 2.5.5 versie
 * FIREBIRD: http://sourceforge.net/projects/firebird/files/firebird-win64/2.5.5-Release/Firebird-2.5.5.26952_0_x64.exe/download
 * install met alle opties zoals ze standaard staan ik heb een super server aangevinkt
 * 
 * JAYBIRD: http://www.firebirdsql.org/en/jdbc-driver/
 * toevoegen aan library
 * 
 * extra documentatie voor de start http://www.firebirdsql.org/file/documentation/reference_manuals/user_manuals/html/qsg25.html
 * 
 */

/** Om allemaal de gelijke database te hebben doe het volgende
 * maak op c: een mapje data
 * zet in het mapje data input.sql en inputcreate.sql
 * start de firebird tool en type: INPUT C:\data\inputcreate.sql
 *      daarmee maak je hem aan en krijg je 1 database die TEST heeft met 1 tabel ARTIKEL
 *      de tabal heeft twee kolommen artikel_id (int) en artikel_naam (varchar)
 * mocht je later weer willen connecten naar de database type dan:
 *          INPUT C:\data\input.sql
 * 
*/



import ConnectionPools.DBConnectorFirebird;
import POJO.Artikel;
import java.sql.*;
import java.util.ArrayList;

public class ArtikelDAOFirebird {
        
    public Artikel createArtikelFirebirdDB(Artikel artikel){

        try(Connection connection = DBConnectorFirebird.getConnection()){
            
            String sql = "INSERT INTO ARTIKEL (artikel_naam, artikel_voorraad, artikel_prijs) VALUES (?,?,?) RETURNING artikel_id";
            
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, artikel.getArtikel_naam());
            pstmt.setInt(2, artikel.getArtikel_voorraad());
            pstmt.setBigDecimal(3, artikel.getArtikel_prijs());

            ResultSet resultSet = pstmt.executeQuery();
            if ( resultSet.next()){
                artikel.setArtikel_id(resultSet.getInt("artikel_id"));
            }

        } 
        catch (SQLException | ClassNotFoundException e){
                System.out.println("SQL fout");
                e.printStackTrace();
        }
        return artikel;
    }
    
    public Artikel readArtikelFirebirdDB(int artikel_id){
        Artikel artikel = new Artikel();
        try(Connection connection = DBConnectorFirebird.getConnection()){
            String sql = "SELECT * FROM artikel where artikel_id = " + artikel_id;
            Statement pstmt = connection.createStatement();
            ResultSet resultSet = pstmt.executeQuery(sql);

            while(resultSet.next()){
                
                artikel.setArtikel_id(resultSet.getInt("artikel_id"));
                artikel.setArtikel_naam(resultSet.getString("artikel_naam"));
                artikel.setArtikel_prijs(resultSet.getBigDecimal("artikel_prijs"));
                artikel.setArtikel_voorraad(resultSet.getInt("artikel_voorraad"));
                
            }
            pstmt.close();
            
        } 
        catch (SQLException e){
                System.out.println("SQL fout");
                e.printStackTrace();
        }
        catch(ClassNotFoundException p){
            System.out.println("verdorie mislukt");
        }
        return artikel;
    }

    public ArrayList<Artikel> readArtikelFirebirdDB(){
        ArrayList<Artikel> artikelLijst = new ArrayList<>();
        try(Connection connection = DBConnectorFirebird.getConnection()){
            String sql = "SELECT * FROM artikel";
            Statement pstmt = connection.createStatement();
            ResultSet resultSet = pstmt.executeQuery(sql);

            while(resultSet.next()){
                Artikel artikel = new Artikel();
                artikel.setArtikel_id(resultSet.getInt("artikel_id"));
                artikel.setArtikel_naam(resultSet.getString("artikel_naam"));
                artikel.setArtikel_prijs(resultSet.getBigDecimal("artikel_prijs"));
                artikel.setArtikel_voorraad(resultSet.getInt("artikel_voorraad"));
                artikelLijst.add(artikel);
            }
            pstmt.close();
            
        } 
        catch (SQLException e){
                System.out.println("SQL fout");
                e.printStackTrace();
        }
        catch(ClassNotFoundException p){
            System.out.println("verdorie mislukt");
        }
        return artikelLijst;
    }
    
    public static void DeleteArtikelFirebirdDB(int artikel_id){
        try(Connection connection = DBConnectorFirebird.getConnection()){
            String sql = "DELETE FROM artikel WHERE artikel_id = " + artikel_id;
            Statement pstmt = connection.createStatement();
            pstmt.executeUpdate(sql);
            pstmt.close();
        } 
        catch (SQLException e){
            System.out.println("SQL fout");
            e.printStackTrace();
        }
        catch(ClassNotFoundException p){
            System.out.println("verdorie mislukt");
        }
    }

    
    public static void updateArtikelFirebirdDB(Artikel artikel){
        try(Connection connection = DBConnectorFirebird.getConnection()){
            String sql = "UPDATE ARTIKEL set artikel_naam = ?, artikel_prijs = ?, artikel_voorraad = ? where artikel_id = ?;";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, artikel.getArtikel_naam());
            pstmt.setBigDecimal(2, artikel.getArtikel_prijs());
            pstmt.setInt(3, artikel.getArtikel_voorraad());
            pstmt.setInt(4, artikel.getArtikel_id());
            
            pstmt.executeUpdate();
            
            pstmt.close(); 
        } 
        catch (SQLException | ClassNotFoundException e){
            System.out.println("SQL Update fout");
            e.printStackTrace();
        }
    }
}


