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

public class ConnectionPool {
    private static ConnectionType strategy = new ConnectionPoolHikari();
    static Logger logger = LoggerFactory.getLogger(ConnectionPool.class);
        
    public ConnectionPool(){
    }
   
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        return strategy.getConnection();
    }
    
    public static void setConnectionSettings(ConnectionType connectionType){
        strategy = connectionType;
    }
}