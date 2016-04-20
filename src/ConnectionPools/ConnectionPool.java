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

public class ConnectionPool implements java.io.Closeable, ConnectionSettings {
    private static ConnectionPool connectionPool = new ConnectionPool();
    private int connectionSettings = HIKARI;
    private static Connection strategy;
    
    
    static Logger logger = LoggerFactory.getLogger(ConnectionPool.class);
    
    
    private ConnectionPool(){
        try {
            this.strategy = (new ConnectionPoolHikari() ).getConnection();
        }
        catch (Exception ex){
        }
    }
    
    public static ConnectionPool getConnectionPool(){
        return connectionPool;
    }
    
    public static Connection getConnection(){
        return strategy;
    }

    public void setConnectionSettings(int setting)throws SQLException, ClassNotFoundException{
        if (setting == HIKARI) {
            this.connectionSettings = HIKARI;
            this.strategy = (new ConnectionPoolHikari() ).getConnection();
            logger.info("HikariCP ingesteld");
        }
        if (setting == C3P0) {
            this.connectionSettings = C3P0;
            this.strategy = (new ConnectionPoolC3P0() ).getConnection();
            logger.info("C3P0 ingesteld");
        }
        if (setting == JDBCDRIVER) {
            this.connectionSettings = JDBCDRIVER;
            this.strategy = (new ConnectionJDBC() ).getConnection();
            logger.info("JDBC Driver ingesteld (Waarschuwing, deze library implementeerd geen pool functie.)");
        }
        if (setting == NILL) {
            this.connectionSettings = NILL;
            System.out.println("Als je dit leest dan is er iets mis.");
        }
    }
    
    public int getConnectionSettings(int setting){
        return connectionSettings;
    }
    
    public void close(){
        try {
        strategy.close();
        }
        catch (Exception ex){
            System.out.println("Er ging iets mis bij het sluiten van de verbinding.");
        }
    }
}