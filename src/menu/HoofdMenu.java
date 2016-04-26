package menu;

import formatMessage.PrintFormat;
import java.util.Scanner;
import workshop1.*;

/**
 *
 * @author Peter
 */
public class HoofdMenu {
    public static void startMenu() {
        Scanner input = new Scanner(System.in);
        PrintFormat.printHeader("HOOFDMENU");
        System.out.println("1: Ga naar het klant-adresmenu \n"
            + "2: Ga naar het bestellingmenu \n"
            + "3: Ga naar het artikelmenu \n"
            + "4: Ga naar het adresmenu \n"
                + "\n"
            + "0: Stop de applicatie\n");
        int select = input.nextInt();
        
        switch (select) {
            case 1:
                KlantAdresMenu.startMenu();
                break;
            case 2:
                BestellingenMenu.startMenu();
                break;
            case 3:
                ArtikelMenu.startMenu();
                break;            
            case 4:
                AdresMenu.startMenu();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Maak een keuze: 1, 2, 3, 4 of 0");
                break;
        }
    }
}
