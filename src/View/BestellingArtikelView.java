/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;

/**
 *
 * @author Gebruiker
 */
public class BestellingArtikelView {
    int bestellingID;
    int artikelID;
    int aantal;

    public int getBestellingID() {
        return bestellingID;
    }
    public int getArtikelID() {
        return artikelID;
    }

    public int getAantal() {
        return aantal;
    }

    public void readCreate(){
        Scanner input = new Scanner(System.in);
        System.out.print("Voer het artikel ID in: ");
        artikelID = input.nextInt();
        System.out.print("Voer het aantal artikelen in: ");
        aantal = input.nextInt();
    }
    public void readUpdate(){
        Scanner input = new Scanner(System.in);
        System.out.print("Voer het bestelling ID in: ");
        bestellingID = input.nextInt();
        System.out.print("Voer het artikel ID in: ");
        artikelID = input.nextInt();
        System.out.print("Voer het aantal artikelen in: ");
        aantal = input.nextInt();
    }
    
    public void readDelete(){
        Scanner input = new Scanner(System.in);
        System.out.print("Voer het bestelling ID in: ");
        bestellingID = input.nextInt();
        System.out.print("Voer het artikel ID in: ");
        artikelID = input.nextInt();
        System.out.print("Voer het aantal artikelen in: ");
        aantal = input.nextInt();
    }
}
