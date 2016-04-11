/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

import java.sql.*;

public class DBConnector{
    String url = "jdbc:mysql://localhost/workshopdb";
    String user = "rsvier";
    String password = "tiger";
    Connection connection;
    public DBConnector() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Database connected");
        this.connection = connection;
    }
    public Connection getConnection(){
        return connection;
    }
}
