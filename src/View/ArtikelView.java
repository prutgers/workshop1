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
import java.util.Scanner;

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
        System.out.println("Voer de artikelnaam in: ");
        this.artikel_naam = VerifyInputScanner.verifyString();
        
        System.out.println("Voer het aantal dat van dit artikel op voorraad is in: ");
        this.artikel_id = VerifyInputScanner.verifyInt();
        
        System.out.println("Voer de artikelprijs in: ");
        this.artikel_prijs = VerifyInputScanner.verifyBigDecimal();

    }
    
    public  void update(){
        System.out.println("Voer het artikel ID van het artikel "
                + "dat u wilt aanpassen in: ");
        this.artikel_id = VerifyInputScanner.verifyInt();
        
        System.out.println("Artikelnaam: ");
        this.artikel_naam = VerifyInputScanner.verifyString();
        
        System.out.println("Aantal van dit artikel dat op voorraad is: ");
        this.artikel_voorraad = VerifyInputScanner.verifyInt();
        
        System.out.println("Artikelprijs: ");
        this.artikel_prijs = VerifyInputScanner.verifyBigDecimal();
    }
    
    public void readAllArtikelen(){
        
    }
    
    public void readArtikelById(){
        System.out.println("Voer het artikel ID in: ");
        artikel_id = VerifyInputScanner.verifyInt();
    }
    
    public void delete(){
        System.out.println("Voer het artikel ID van het "
                + "te verwijderen artikel in: ");
        this.artikel_id = VerifyInputScanner.verifyInt();
    }
    
    public void printArtikel(ArrayList<Artikel> artikelLijst){
        //is het mooi om hier alleen artikel view
    }
    
    
    /**
     * @return the artikel_id
     */
    public int getArtikel_id() {
        return artikel_id;
    }

    /**
     * @param artikel_id the artikel_id to set
     */
    public void setArtikel_id(int artikel_id) {
        this.artikel_id = artikel_id;
    }

    /**
     * @return the artikel_naam
     */
    public String getArtikel_naam() {
        return artikel_naam;
    }

    /**
     * @param artikel_naam the artikel_naam to set
     */
    public void setArtikel_naam(String artikel_naam) {
        this.artikel_naam = artikel_naam;
    }

    /**
     * @return the artikel_voorraad
     */
    public int getArtikel_voorraad() {
        return artikel_voorraad;
    }

    /**
     * @param artikel_voorraad the artikel_voorraad to set
     */
    public void setArtikel_voorraad(int artikel_voorraad) {
        this.artikel_voorraad = artikel_voorraad;
    }

    /**
     * @return the artikel_prijs
     */
    public BigDecimal getArtikel_prijs() {
        return artikel_prijs;
    }

    /**
     * @param artikel_prijs the artikel_prijs to set
     */
    public void setArtikel_prijs(BigDecimal artikel_prijs) {
        this.artikel_prijs = artikel_prijs;
    }
}
