/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionPools;

/**
 *
 * @author Gebruiker
 */
import java.sql.*; 
import java.util.*; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionPool implements java.io.Closeable {
    private static ConnectionPool connectionPool = new ConnectionPool();
    private static ConnectionType strategy;
    
    static Logger logger = LoggerFactory.getLogger(ConnectionPool.class);
    
    
    public ConnectionPool(){
        strategy = new ConnectionPoolHikari();
    }
    
  
    
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        return strategy.getConnection();
    }
    
    
    public void setConnectionSettings(int setting){
        if (setting == 1) {
            strategy = new ConnectionPoolHikari();
            logger.info("HikariCP ingesteld");
        }
        else if (setting == 2) {
            strategy = new ConnectionPoolC3P0();
            logger.info("C3P0 ingesteld");
        }
        else if (setting == 3) {
            strategy = new ConnectionJDBC();
            logger.info("JDBC Driver ingesteld (Waarschuwing, deze library implementeerd geen pool functie.)");
        }
        else {
            logger.info("Als je dit leest dan is er iets mis.");
        }
    }


    
    public void close(){
        try {
        strategy.close();
        }
        catch (Exception ex){
        }
    }
}