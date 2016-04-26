/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionPools;

import java.sql.*;

public class DBConnector{
    final String url = "jdbc:mysql://localhost/workshopdb";
    final String user = "rsvier";
    final String password = "tiger";
    Connection connection;
    public DBConnector() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("Database connected");
        this.connection = con;
    }
    public Connection getConnection(){
        return connection;
    }
}
