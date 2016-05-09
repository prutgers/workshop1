/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import formatMessage.PrintFormat;
import formatMessage.VerifyInputScanner;
import java.util.Scanner;

/**
 *
 * @author Peter
 */
public class MainView {
    private int select;
    
    public void readMain(){
        PrintFormat.printHeader("HOOFDMENU");
        System.out.println("1: Ga naar het klantmenu \n"
            + "2: Ga naar het bestellingmenu \n"
            + "3: Ga naar het artikelmenu \n"
            + "4: Ga naar het adresmenu \n"
                + "\n"
            + "5: Ga naar de applicatie configuratie \n"
                + "\n"
            + "0: Stop de applicatie \n");
        this.select = VerifyInputScanner.verifyInt();
    }

    public int getSelect() {
        return select;
    }
}
