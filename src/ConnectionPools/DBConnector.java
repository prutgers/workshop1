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

//This class is legacy code, avoid use if possible

public class DBConnector implements java.io.Closeable {
    Connection connection;
    
    public DBConnector() throws SQLException, ClassNotFoundException {
        this.connection = ConnectionPool.getConnection();
    }
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        return ConnectionPool.getConnection();
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
