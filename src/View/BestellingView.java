/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import POJO.Bestelling;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gebruiker
 */
public class BestellingView {
    int klandID;

    public int getKlandID() {
        return klandID;
    }

    public void setKlandID(int klandID) {
        this.klandID = klandID;
    }

    public int getBestellingID() {
        return bestellingID;
    }

    public void setBestellingID(int bestellingID) {
        this.bestellingID = bestellingID;
    }
    int bestellingID;
    
    public void readKlantID(){
        Scanner input = new Scanner(System.in);
        System.out.print("Voer het klant ID in: ");    
        this.klandID = input.nextInt();
    }
    public void readBestellingID(){
        Scanner input = new Scanner(System.in);
        System.out.println("Voer het bestelling ID in: ");
        this.bestellingID = input.nextInt();
    }
    
    public void print(ArrayList<Bestelling> list){
        System.out.printf("%15s %15s\n", "Bestelling ID", "Klant ID");
        for(Bestelling e : list){
            System.out.printf("%15d %15d\n",e.getBestellingID(), e.getKlantID());
        }
    }
    public void print(Bestelling bestelling){
        System.out.println("Bestelling ID: " + bestelling.getBestellingID());
        System.out.println("Klant ID: " + bestelling.getKlantID());
    }
}
