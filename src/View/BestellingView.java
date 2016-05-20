/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.MySQL.ArtikelDAOMySQL;
import POJO.Artikel;
import POJO.Bestelling;
import POJO.BestellingArtikel;
import formatMessage.PrintFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gebruiker
 */
public class BestellingView {
    int klantID;

    public int getKlantID() {
        return klantID;
    }

    public void setKlantID(int klantID) {
        this.klantID = klantID;
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
        this.klantID = input.nextInt();
    }
    public void readBestellingID(){
        Scanner input = new Scanner(System.in);
        System.out.print("Voer het bestelling ID in: ");
        this.bestellingID = input.nextInt();
    }
    
    public void print(ArrayList<Bestelling> list){
        PrintFormat.printHeader("BESTELLINGGEGEVENS");
        System.out.printf("%15s\t\t| %15s\t\t|\n", "Bestelling ID", "Klant ID");
        for(Bestelling e : list){
            System.out.printf("%15d\t\t| %15d\t\t|\n",e.getBestellingID(), e.getKlantID());
        }
    }
    public void printArtikelLijst(ArrayList<BestellingArtikel> list){
        Scanner input = new Scanner(System.in);
        PrintFormat.printHeader("ARTIKELLIJST");
        System.out.printf("%15s\t\t| %15s\t\t|\n", "Artikel ID", 
                "Aantal");
        for(BestellingArtikel e : list){
             System.out.printf("%15d\t\t| %15d\t\t|\n",e.getArtikel_id(), e.getAantal());  
        }
    }
    public void print(Bestelling bestelling){
        System.out.println("Bestelling ID: " + bestelling.getBestellingID());
        System.out.println("Klant ID: " + bestelling.getKlantID());
    }
}
