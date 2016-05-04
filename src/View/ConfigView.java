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
        PrintFormat.printHeader("Connection Settings");
        System.out.println("Selecteer een setting:\n"
                    + "Kies 1 voor Hikari; \n"
                    + "Kies 2 voor C3P0; \n"
                    + "Kies 3 voor een directe JDBC connectie \n");
        this.selectConnection = VerifyInputScanner.verifyInt();
    }
    
    public void readDatabaseSettings(){
        PrintFormat.printHeader("DataBase Settings");
        System.out.println("Selecteer een setting:\n"
                    + "Kies 1 MySQL; \n"
                    + "Kies 2 Firebird; \n"
                    + "Kies 3 JSON \n"
                    + "Kies 4 XML  \n");
        this.selectDatabase = VerifyInputScanner.verifyInt();
    }
}
