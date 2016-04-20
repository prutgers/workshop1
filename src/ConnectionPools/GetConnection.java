/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionPools;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public interface GetConnection {
    public Connection getConnection() throws SQLException, ClassNotFoundException;
    
}
