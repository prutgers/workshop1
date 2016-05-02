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
public class ArtikelKeuzeView {
    private int select;
    public void keuze(){
        Scanner input = new Scanner(System.in);        
        PrintFormat.printHeader("ARTIKELMENU"); 
        System.out.println("1: Maak een nieuw artikel aan \n"
                + "\n"
            + "2: Pas een artikel aan (met artikel ID) \n"
                + "\n"
            + "3: Haal een lijst met alle beschikbare artikelen op \n"
            + "4: Haal een specifiek artikel op (met artikel ID) \n"
                + "\n"
            + "5: Verwijder een bestaand artikel (met artikel ID) \n"
                + "\n"
            + "0: Keer terug naar het Hoofdmenu \n");
        setSelect(input.nextInt());
        }
    public void herhaalKeuze(){
        System.out.println("Maak een keuze: 1, 2, 3, 4, 5 of 0");
    }

    /**
     * @return the select
     */
    public int getSelect() {
        return select;
    }

    /**
     * @param select the select to set
     */
    public void setSelect(int select) {
        this.select = select;
    }
}
