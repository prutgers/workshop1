/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import POJO.Artikel;
import formatMessage.PrintFormat;
import formatMessage.VerifyInputScanner;
import java.math.BigDecimal;
import java.util.ArrayList;


/**
 *
 * @author Peter
 * 
 * dit is een echte view volgens het view model principe
 */
public class ArtikelView {
    private int artikel_id;
    private String artikel_naam;
    private int artikel_voorraad;
    private BigDecimal artikel_prijs;
    

    public void create(){
        System.out.print("Voer de artikelnaam in: ");
        this.artikel_naam = VerifyInputScanner.verifyString();
        
        System.out.print("Voer het aantal dat van dit artikel op voorraad is in: ");
        this.artikel_voorraad = VerifyInputScanner.verifyInt();
        
        System.out.print("Voer de artikelprijs in: ");
        this.artikel_prijs = VerifyInputScanner.verifyBigDecimal();
        
      
    }
    
    public  void update(){
        System.out.print("Voer het artikel ID van het artikel "
                + "dat u wilt aanpassen in: ");
        this.artikel_id = VerifyInputScanner.verifyInt();
        
        System.out.print("Voer de artikelnaam in: ");
        this.artikel_naam = VerifyInputScanner.verifyString();
        
        System.out.print("Aantal van dit artikel dat op voorraad is: ");
        this.artikel_voorraad = VerifyInputScanner.verifyInt();
        
        System.out.print("Voer de artikelprijs in: ");
        this.artikel_prijs = VerifyInputScanner.verifyBigDecimal();
    }
    
    public void readArtikelById(){
        System.out.print("Voer het artikel ID in: ");
        artikel_id = VerifyInputScanner.verifyInt();
    }
    
    public void delete(){
        System.out.print("Voer het artikel ID van het "
                + "te verwijderen artikel in: ");
        this.artikel_id = VerifyInputScanner.verifyInt();
    }
    
    public void print(ArrayList<Artikel> artikelLijst){
        PrintFormat.printHeader("ARTIKELGEGEVENS");
        System.out.format("%12s\t\t| %30s\t\t| %14s\t\t| %17s\t\t|\n", 
                "Artikel ID", "Artikelnaam", "Artikelprijs", "Artikelvoorraad");
        
        for(Artikel a : artikelLijst){
            System.out.format("%12d\t\t| %30s\t\t| %14.2f\t\t| %17d\t\t|\n", a.getArtikel_id(), a.getArtikel_naam(), 
            a.getArtikel_prijs(), a.getArtikel_voorraad()); 
        }
    }
    
    public void print(Artikel artikel){
        PrintFormat.printHeader("Artikel met artikel ID " + artikel.getArtikel_id());
        System.out.println("Artikel ID: " + artikel.getArtikel_id());
        System.out.println("Artikelnaam: " + artikel.getArtikel_naam());
        System.out.println("Artikelprijs: " + artikel.getArtikel_prijs());
        System.out.println("Artikelvoorraad: " + artikel.getArtikel_voorraad());
        
    }
    
    /**
     * @return the artikel_id
     */
    public int getArtikel_id() {
        return artikel_id;
    }

    /**
     * @return the artikel_naam
     */
    public String getArtikel_naam() {
        return artikel_naam;
    }

    /**
     * @return the artikel_voorraad
     */
    public int getArtikel_voorraad() {
        return artikel_voorraad;
    }

    /**
     * @return the artikel_prijs
     */
    public BigDecimal getArtikel_prijs() {
        return artikel_prijs;
    }
}
