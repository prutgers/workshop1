/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        PrintFormat.printHeader("HOOFD-MENU");
        System.out.println("Kies 1 voor klant menu; \n"
                + "kies 2 voor adres menu, \n"
                + "kies 3 voor artikel menu, \n"
                + "kies 4 voor bestelling menu, \n"
                + "kies 5 quit, \n");
        int select = input.nextInt();
        
        switch (select) {
            case 1:
                break;
            case 2:
                AdresMenu.startMenu();
                break;
            case 3:
                ArtikelMenu.startMenu();
                break;            
            case 4:
                BestellingenMenu.startMenu();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                //System.out.println("kies 1, 2, 3, 4 of 5);
                break;
        }
        
        
    }
    
}
