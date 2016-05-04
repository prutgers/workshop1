/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionPools;

import com.mchange.v2.c3p0.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Gebruiker
 */

/**
 * Hier kun je de zip file met daarin de nieuwste versie van C3P0 vinden:
 * https://sourceforge.net/projects/c3p0/files/latest/download
 * Voeg deze toe in je libraries:
    * Pak het c3p0-0.9.5.2.bin.zip
    * Ga naar libraries in netbeans rechtermuisknop workshop1 properties
    * Druk op libraries
    * add library
    * create
    * add the file /c3p0-0.9.5.2/lib/c3p0-0.9.5.2.jar in de classpath
    * 
    * verder heb je ook nog de slf4j-api nodig en de slf4j-simple
    * te vinden op http://www.slf4j.org/download.html
 * 
 */

public final class ConnectionPoolC3P0 implements ConnectionType{
    static Logger logger = LoggerFactory.getLogger(ConnectionPoolC3P0.class);
    
    private static ConnectionPoolC3P0 connectionPoolC3P0 = new ConnectionPoolC3P0();
    ComboPooledDataSource cpds;
    
    
    private ConnectionPoolC3P0(){
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
                logger.info("C3P0 Driver loaded");
            
            cpds.setJdbcUrl( "jdbc:mysql://localhost/workshopdb" );
            cpds.setUser(usernaam);
            cpds.setPassword(wachtwoord);
            cpds.setMaxStatements( 50 );
            cpds.setMaxPoolSize(5);
            
            
                logger.info("Database connected");
            
            this.cpds = cpds;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    public static ConnectionPoolC3P0 getConnectionPoolC3P0(){
            logger.info("C3P0 Connectie gehaalt.");
        return connectionPoolC3P0;
    }
    
    
    @Override
    public Connection getConnection() throws SQLException{
        return cpds.getConnection();
    }
}
