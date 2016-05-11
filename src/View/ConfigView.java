/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import formatMessage.PrintFormat;
import formatMessage.VerifyInputScanner;

/**
 *
 * @author Peter
 */
public class ConfigView {
    private int selectConnection;
    private int selectDatabase;

    public int getSelectConnection() {
        return selectConnection;
    }

    public int getSelectDatabase() {
        return selectDatabase;
    }
    
    
    public void readConnectionSettings(){
        PrintFormat.printHeader("CONNECTIESETTINGS");
        System.out.println("Selecteer een setting:\n\n"
                    + "1: Hikari\n"
                    + "2: C3P0\n"
                    + "3: JDBC direct\n");
        this.selectConnection = VerifyInputScanner.verifyInt();
    }
    
    public void readDatabaseSettings(){
        PrintFormat.printHeader("DATABASESETTINGS");
        System.out.println("Selecteer een setting:\n\n"
                    + "1: MySQL\n"
                    + "2: Firebird\n"
                    + "3: JSON\n"
                    + "4: XML\n");
        this.selectDatabase = VerifyInputScanner.verifyInt();
    }
}
