package View;

import formatMessage.PrintFormat;
import formatMessage.VerifyInputScanner;
import java.util.Scanner;

/**
 *
 * @author Sonja
 * 
 * AdresKeuzeView is part of the Adres MVC
 * 
 */
public class AdresKeuzeView {
    int select;
    
    public void keuze() {
        Scanner input = new Scanner(System.in);
        PrintFormat.printHeader("ADRESMENU");
        System.out.println("1: Maak een nieuw adres aan\n"
               + "\n"
            + "2: Pas een bestaand adres aan (met adres ID)\n"
                + "\n"
            + "3: Haal alle adresgegevens op\n"
            + "4: Haal een specifiek adres op (met adres ID)\n"
                + "\n"
            + "5: Verwijder een bestaand adres\n"
                + "\n"
            + "0: Keer terug naar het Hoofdmenu\n");
        this.select = VerifyInputScanner.verifyInt();
    }
    
    public void herhaalKeuze() {
        System.out.println("Maak een keuze: 1, 2, 3, 4, 5 of 0");    
    }
    
    public int getSelect() {
        return select;
    }
}
