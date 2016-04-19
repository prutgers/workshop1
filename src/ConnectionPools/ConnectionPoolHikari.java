/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionPools;

import com.zaxxer.hikari.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Gebruiker
 */

public class ConnectionPoolHikari {
    HikariDataSource ds;
    public ConnectionPoolHikari(){
        HikariConfig config = new HikariConfig();
        config.setMinimumIdle(1);
        config.setMaximumPoolSize(2);
        config.setInitializationFailFast(true);
        //config.setConnectionTestQuery("VALUES 1");
        config.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        config.addDataSourceProperty("serverName", "localhost");
        config.addDataSourceProperty("port", "3306");
        config.addDataSourceProperty("databaseName", "workshopdb");
        config.addDataSourceProperty("user", "rsvier");
        config.addDataSourceProperty("password", "tiger");
        
                this.ds = new HikariDataSource(config);
    }
    public Connection getConnection ()throws SQLException, ClassNotFoundException{
        return ds.getConnection();
    }
}
