/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author lucas
 * 
 * KlantKeuzeView is part of the Klant MVC
 * 
 */

import formatMessage.VerifyInputScanner;
import formatMessage.PrintFormat;

public class KlantKeuzeView {
    private int select;
    public void keuzeView(){
        PrintFormat.printHeader("KLANTMENU");        
        System.out.println("1: Maak een nieuwe klant aan\n"
                + "\n"
            + "2: Haal een specifieke klant op (met klant ID)\n"
                + "\n"
            + "3: Pas een bestaande klant aan (met klant ID)\n"
            + "4: Verwijder een bestaande klant (met klant ID)\n"
                + "\n"
            + "5: Haal specifieke klantgegevens op (met gedeeltelijke informatie)\n"
            + "6: Haal alle klantgegevens op\n"
                + "\n"
            + "7: Voeg een nieuw adres aan een bestaande klant toe (met klant ID)\n"
            + "8: Koppel een bestaand adres aan een bestaande klant (met klant ID)\n"
                + "\n"
            + "0: Keer terug naar het Hoofdmenu\n");
        this.select = VerifyInputScanner.verifyInt();
    }
    
    public int getSelect(){
        return select;
    }
}
