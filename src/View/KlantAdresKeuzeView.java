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
        System.out.println("KLANTADRESMENU");        
        System.out.println("1: Koppel een klant aan een adres\n"
                + "\n"
            + "2: Haal alle adressen van een klant op\n"
            + "3: Haal alle bewoners van een adres op\n"
                + "\n"
            + "4: Verwijder een klant van al zijn adressen\n"
            + "5: Verwijder een adres voor alle klanten gekoppeld aan dat adres\n"
                + "\n"
            + "0: Keer terug naar het Hoofdmenu\n");
        this.select = VerifyInputScanner.verifyInt();
    }
    
    public int getSelect(){
        return select;
    }
    
}
