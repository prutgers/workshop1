/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionPools;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author lucas
 */
public class ConnectionJDBC implements ConnectionType, java.io.Closeable {
    static Logger logger = LoggerFactory.getLogger(ConnectionJDBC.class);
    
    Connection connection;
    
    
    public ConnectionJDBC() {
        try {
        // Load the JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
            logger.info("Driver loaded");
        // Connect to a database
        Connection connection = DriverManager.getConnection
                 ("jdbc:mysql://localhost/workshopdb" , usernaam, wachtwoord);
            logger.info("Database connected");
        this.connection = connection;
        }
        catch(ClassNotFoundException ex){
            logger.info("Driver failed to load, controleer of je alle libraries hebt die in de dependancies vermeld zijn.");
            ex.printStackTrace();
            
        }
        catch(SQLException ex){
            logger.info("Probleem met het verbinden met de Database.");
            ex.printStackTrace();
        }
    }
    
    /**
     * De ConnectionJDBC class is niet een Singleton class.
     * Deze get() is er alleen om compatibiliteit te bieden met de andere ConnectionType classen.
     * 
     */
    public static ConnectionJDBC getConnectionJDBC(){
        return new ConnectionJDBC();
    }
    
    /**
     * De JDBC driver ondersteunt geen Pool functionaliteit.
     * Dit betekend dat als een methode de connectie gebruikt en dan sluit
     * (bv dmv een try-with-resources blok) alle daarop volgende
     * connectiepogingen een 'connection closed' error geven.
     * Om toch een autoclose functie mogelijk te maken wordt er voor iedere
     * connectie een nieuw ConnectionJDBC-object aangemaakt.
     */
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        return ( new ConnectionJDBC() ).connection;
    }
    
    @Override
    public void close(){
          // Close the connection
          try{
              connection.close();
          }
          catch (SQLException ex){
            ex.printStackTrace();
              
          }
          catch (Exception ex){
            ex.printStackTrace();              
          }
    }
}
