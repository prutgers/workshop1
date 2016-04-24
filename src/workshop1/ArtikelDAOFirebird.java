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



import java.sql.*;
import java.util.ArrayList;
import org.firebirdsql.jdbc.FirebirdConnection;

public class ArtikelDAOFirebird {
        
    public static void createFirebirdDB(Artikel artikel){

        try(Connection connection = DBConnectorFirebird.getConnection();){
            System.out.println("1");
            String sql = "INSERT INTO ARTIKEL (artikel_id, artikel_naam, artikel_voorraad, artikel_prijs) VALUES (?,?,?,?)";
            
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, artikel.getArtikel_id());
            pstmt.setString(2, artikel.getArtikel_naam());
            pstmt.setInt(3, artikel.getArtikel_voorraad());
            pstmt.setLong(4, artikel.getArtikel_prijs());

            pstmt.executeUpdate();

        } 
        catch (SQLException e){
                System.out.println("SQL fout");
                e.printStackTrace();
        }
    }

    public static void readFirebirdDB(){
        try(Connection connection = new DBConnectorFirebird().getConnection()){
            Class.forName("org.firebirdsql.jdbc.FBDriver");
     
            String sql = "SELECT * FROM artikel";
            Statement pstmt = connection.createStatement();

            ResultSet poef = pstmt.executeQuery(sql);

            while(poef.next()){
                System.out.println("artikel id " + poef.getInt("artikel_id") + "naam " + poef.getString("artikel_naam"));
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
        
    }
    
    public static void testDeleteFirebirdDB(int artikel_id){
        String user = "SYSDBA";
        String password = "masterkey";
        String datbaseUrl;
        datbaseUrl = "jdbc:firebirdsql://localhost:3050/C://data\\workshopdb.FDB";
       
        try(Connection connection = DriverManager.getConnection(datbaseUrl, user, password)){
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            
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

    
    public static void updateFirebirdDB(Artikel artikel){
        try(Connection connection = DBConnectorFirebird.getConnection();){

            String sql = "UPDATE ARTIKEL set artikel_naam = ?, artikel_prijs = ?, artikel_voorraad = ? where artikel_id = ?;";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, artikel.getArtikel_naam());
            pstmt.setInt(2, artikel.getArtikel_prijs());
            pstmt.setInt(3, artikel.getArtikel_voorraad());
            pstmt.setInt(4, artikel.getArtikel_id());

            pstmt.executeUpdate();

            pstmt.close(); 
        } 
        catch (SQLException e){
                System.out.println("SQL Update fout");
                e.printStackTrace();
        }
    }
    
    public static void testPrepUpdateFirebirdDB(int artikel_id){
        String user = "SYSDBA";
        String password = "masterkey";
        String datbaseUrl;
        datbaseUrl = "jdbc:firebirdsql://localhost:3050/C://data\\workshopdb.FDB";;

        try(Connection connection = DriverManager.getConnection(datbaseUrl, user, password)){
            Class.forName("org.firebirdsql.jdbc.FBDriver");

            String opdracht = "UPDATE artikel SET artikel_naam = ? WHERE artikel_id = ?";

            PreparedStatement statement = connection.prepareStatement(opdracht);

            statement.setString(1, "henk");
            statement.setInt(2, 5);
            statement.executeUpdate();


            // Insert 

            //pstmt.executeUpdate(sql);
            System.out.println("blue3");

            statement.close();

        } 
        catch (SQLException e){
                System.out.println("SQL fout");
                e.printStackTrace();
        }
        catch(ClassNotFoundException p){
            System.out.println("verdorie mislukt");
        }
    }
            
            
}


