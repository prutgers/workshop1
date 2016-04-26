/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionPools;

import java.sql.*;

public class DBConnectorFirebird{
    static String user = "SYSDBA";
    static String password = "masterkey";
    static String url = "jdbc:firebirdsql://localhost:3050/C://data\\workshopdb.FDB";
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("org.firebirdsql.jdbc.FBDriver");
        return DriverManager.getConnection(url, user, password);
    }
}
