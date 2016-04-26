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
public interface ConnectionType{
    public final String usernaam = "rsvier";
    public final String wachtwoord = "tiger";
    
    public Connection getConnection() throws SQLException, ClassNotFoundException;
}
