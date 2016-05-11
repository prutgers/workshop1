package View;

import formatMessage.PrintFormat;
import java.util.Scanner;

/**
 *
 * @author Sonja
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
            + "0: Keer terug naar het Hoofdmenu"
                + "\n");
        select = input.nextInt();
    }
    
    public void herhaalKeuze() {
        System.out.println("Maak een keuze: 1, 2, 3, 4, 5 of 0");    
    }
    
    public int getSelect() {
        return select;
    }
}
