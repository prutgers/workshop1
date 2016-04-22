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
 * FIREBIRD EN JAYBIRD DOWNLOADEN
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
    
    public static void testreadFirebirdDB(){
        String user = "SYSDBA";
        String password = "masterkey";
        String datbaseUrl;
        //Syntax URL jdbc:firebirdsql:[host[/port]:]<database>
        datbaseUrl = "jdbc:firebirdsql://localhost:3050/C://data\\test.FDB";
       //FirebirdConnection aap;
       
        try(Connection connection = DriverManager.getConnection(datbaseUrl, user, password)){
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            
            
            String sql = "SELECT * FROM artikel";
            Statement pstmt = connection.createStatement();
            /** waarom kan ik deze shit niet aanroepen op connectie?
             * http://www.firebirdsql.org/file/documentation/drivers_documentation/java/2.2.9/docs/org/firebirdsql/jdbc/FirebirdConnection.html#isUseFirebirdAutoCommit--
             * waarschijnlijk omdat dit niet ge-extend wordt maar dat zou wel handig zijn heb ik mijn library niet goed ofzo?
            */
            
            // Insert 
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
        //Syntax URL jdbc:firebirdsql:[host[/port]:]<database>
        datbaseUrl = "jdbc:firebirdsql://localhost:3050/C://data\\test.FDB";
       
        try(Connection connection = DriverManager.getConnection(datbaseUrl, user, password)){
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            
            
            String sql = "DELETE FROM artikel WHERE artikel_id = " + artikel_id;
                    //Zonder de returning geef die een foutmelding wtf
                    //   + "returning artikel_id, artikel_naam";
            Statement pstmt = connection.createStatement();
            /** waarom kan ik deze shit niet aanroepen op connectie?
             * http://www.firebirdsql.org/file/documentation/drivers_documentation/java/2.2.9/docs/org/firebirdsql/jdbc/FirebirdConnection.html#isUseFirebirdAutoCommit--
             * waarschijnlijk omdat dit niet ge-extend wordt maar dat zou wel handig zijn heb ik mijn library niet goed ofzo?
            */
            
           
            
            // Insert 
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
    
    public static void testCreateFirebirdDB(int artikel_id, String artikel_naam){
        String user = "SYSDBA";
        String password = "masterkey";
        String datbaseUrl;
        //Syntax URL jdbc:firebirdsql:[host[/port]:]<database>
        datbaseUrl = "jdbc:firebirdsql://localhost:3050/C://data\\test.FDB";
       
       
        try(Connection connection = DriverManager.getConnection(datbaseUrl, user, password)){
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            
            
            String sql = "INSERT INTO ARTIKEL("
            + "artikel_id, artikel_naam)"
            +  "VALUES(6, 'henk')";
            //+ "returning artikel_id, artikel_naam";
            Statement pstmt = connection.createStatement();
            // Set the values
            //int artikelID = 4;
            //pstmt.setInt(1, artikelID);
            
            // Insert 
            pstmt.executeUpdate(sql);
            
            //System.out.println("auto commit staat " + connection.commit());
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
    
    public static void testUpdateFirebirdDB(int artikel_id){
        String user = "SYSDBA";
        String password = "masterkey";
        String datbaseUrl;
        //Syntax URL jdbc:firebirdsql:[host[/port]:]<database>
        datbaseUrl = "jdbc:firebirdsql://localhost:3050/C://data\\test.FDB";
       
        try(Connection connection = DriverManager.getConnection(datbaseUrl, user, password)){
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            
            //String sql = "INSERT INTO ARTIKEL(artikel_id, artikel_naam) VALUES(13, 'juist')";
            String sql = "UPDATE ARTIKEL set artikel_naam = 'zone' where artikel_id = 5";
            //String sql = "UPDATE ARTIKEL(artikel_naam) VALUES('jolike') WHERE artikel_id = 5";
            System.out.println("bleh");
            Statement pstmt = connection.createStatement();
           
            
            pstmt.executeUpdate("UPDATE artikel SET artikel_naam = 1" 
                            + "WHERE artikel_id = 5");
            System.out.println("bleh2.2");
            // Insert 
            pstmt.execute(sql);
            //pstmt.executeUpdate(sql);
            System.out.println("blue3");
            
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
}


