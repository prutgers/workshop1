/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author lucas
 */
import formatMessage.VerifyInputScanner;

public class KlantAdresKeuzeView {
    private int select;
    public void keuzeView(){
        System.out.println("KlantAdres Management Menu");        
        System.out.println("1: Koppel een Klant aan een Adres\n"
            + "2: Haal alle woningen van een Klant op\n"
            + "3: Haal bewoners van een Adres op\n"
            + "4: Verwijder een Klant van alle zijn Adressen\n"
            + "5: Verwijder een Adres van alle bewoners\n"
                + "\n"
            + "0: Keer terug naar het Hoofdmenu");
        this.select = VerifyInputScanner.verifyInt();
    }
    
    public int getSelect(){
        return select;
    }
    
}
