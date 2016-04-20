/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionPools;

/**
 *
 * @author lucas
 */
import java.sql.*;

public class DBConnector implements java.io.Closeable, ConnectionSettings {
    Connection connection;
    
    public DBConnector() throws SQLException, ClassNotFoundException {
        // Load the JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        // Connect to a database
        Connection connection = DriverManager.getConnection
                 ("jdbc:mysql://localhost/workshopdb" , "rsvier", "tiger");
        System.out.println("Database connected");
        this.connection = connection;
    }
    
    public Connection getConnection(){
        return connection;
    }
    
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
