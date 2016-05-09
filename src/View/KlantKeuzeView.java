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
import formatMessage.PrintFormat;

public class KlantKeuzeView {
    private int select;
    public void keuzeView(){
        PrintFormat.printHeader("Klant Management Menu");        
        System.out.println("1: Maak een nieuwe klant aan\n"
            + "2: Haal klant gegevens op met een ID nummer\n"
            + "3: Update klant gegevens met een ID nummer\n"
            + "4: Verwijder een klant uit de geslecteerde Database met een ID nummer\n"
            + "5: Toon alle klanten die aan de kriteria voldoen\n"
            + "6: Toon alle klanten in deze database\n"
                + "\n"
            + "0: Keer terug naar het Hoofdmenu");
        this.select = VerifyInputScanner.verifyInt();
    }
    
    public int getSelect(){
        return select;
    }
}
