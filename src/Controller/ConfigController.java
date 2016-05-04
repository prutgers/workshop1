/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ConnectionPools.*;
import DAOFactory.DAOFactory;
import View.ConfigView;

/**
 *
 * @author Peter
 */
public class ConfigController {
    
    public static void setConnection(){
        ConfigView view = new ConfigView();
        view.readConnectionSettings();
        switch (view.getSelectConnection()) {
            case 1: ConnectionPool.setConnectionSettings(
                    ConnectionPoolHikari.getConnectionPoolHikari());
                break;
            case 2: ConnectionPool.setConnectionSettings(
                    ConnectionPoolC3P0.getConnectionPoolC3P0());
                break;
            case 3: ConnectionPool.setConnectionSettings(
                    ConnectionJDBC.getConnectionJDBC());
                break;
            case 0: MainController.hoofdMenu(); break;
            default:
                view.readConnectionSettings();
                break;
        }
    }
    
    public static void setDatabase(){
        ConfigView view = new ConfigView();
        view.readDatabaseSettings();
        switch (view.getSelectDatabase()) {
            case 1: 
                    DAOFactory.setDB("MySQL");
                break;
            case 2: DAOFactory.setDB("Firebird");
                break;
            case 3: DAOFactory.setDB("JSON");
                break;
            case 4: DAOFactory.setDB("XML");
                break;
            case 0: MainController.hoofdMenu(); break;
            default:
                view.readConnectionSettings();
                break;
        }
    }
        
}

