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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ConnectionPool{
    private static ConnectionPool connectionPool = new ConnectionPool();
    private ConnectionType strategy;
    
    static Logger logger = LoggerFactory.getLogger(ConnectionPool.class);
    
    
    private ConnectionPool(){
        strategy = ConnectionPoolHikari.getConnectionPoolHikari();
    }
    
    public static ConnectionPool getConnectionPool(){
        return connectionPool;
    }
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        return connectionPool.strategy.getConnection();
    }
    
    
    public static void setConnectionSettings(ConnectionType setting){
        //    logger.info("Nieuw connectie type: ");
        getConnectionPool().strategy = setting;
    }
    
    public static ConnectionType getConnectionSettings(){
        return getConnectionPool().strategy;
    }
}