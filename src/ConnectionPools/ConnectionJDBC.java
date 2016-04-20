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
public class ConnectionJDBC implements GetConnection, java.io.Closeable {
    Connection connection;
    
    static Logger logger = LoggerFactory.getLogger(ConnectionJDBC.class);
    
    public ConnectionJDBC() throws SQLException, ClassNotFoundException {
        // Load the JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
        logger.info("Driver loaded");
        // Connect to a database
        Connection connection = DriverManager.getConnection
                 ("jdbc:mysql://localhost/workshopdb" , "rsvier", "tiger");
        logger.info("Database connected");
        this.connection = connection;
    }
    
    @Override
    public Connection getConnection(){
        return connection;
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
