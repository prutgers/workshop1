/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import formatMessage.PrintFormat;
import java.util.Scanner;

/**
 *
 * @author Gebruiker
 */
public class BestellingKeuzeView {
    int select;

    public int getSelect() {
        return select;
    }

    public void keuzeView(){
        Scanner input = new Scanner(System.in);
        while(true){
            PrintFormat.printHeader("BESTELLINGMENU");        
            System.out.println("1: Maak een nieuwe bestelling aan\n"
                    + "\n"
                + "2: Voeg een artikel aan een bestelling toe (met bestelling ID) \n"
                + "3: Pas het aantal bestelde artikelen aan (met bestelling ID en artikel ID) \n"
                    + "\n"
                + "4: Haal alle bestellingen van alle klanten op \n"
                + "5: Haal een specifieke bestelling op (met bestelling ID) \n"
                + "6: Haal alle bestellingen van een specifieke klant op (met klant ID) \n"
                + "7: Haal alle artikelen van een specifieke bestelling op (met bestelling ID) \n"
                    + "\n"
                + "8: Verwijder één artikel uit een bestelling (met bestelling ID en artikel ID) \n"
                + "9: Verwijder een bestaande bestelling (met bestelling ID) \n"
                    + "\n"
                + "0: Keer terug naar het Hoofdmenu");
            select = input.nextInt();
        }
    }
    public void keuzeFout(){
        System.out.println("Maak een keuze: 1, 2, 3, 4, 5, "
                            + "6, 7, 8, 9 of 0");
    }
    
}
