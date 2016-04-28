/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *safsdafsafas
 * @author Peter en Herman
 */
public class Artikel {
    
    private int artikel_id;
    private String artikel_naam;
    private int artikel_voorraad;
    private BigDecimal artikel_prijs;

  
    
    public Artikel(){
    }

    Artikel(ArtikelBuilder artikelBuilder) {
        this.artikel_naam = artikelBuilder.getArtikel_naam();
        this.artikel_voorraad = artikelBuilder.getArtikel_voorraad();
        this.artikel_prijs = artikelBuilder.getArtikel_prijs();
    }
   
    /**
     * @return the artikel_ID
     */
    public int getArtikel_id() {
        return artikel_id;
    }

    /**
     * @param artikel_id the artikel_ID to set
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

    public static class ArtikelBuilder{
        private String artikel_naam;
        private int artikel_voorraad;
        private BigDecimal artikel_prijs;
        private int artikel_id;
        
        public ArtikelBuilder(){
        }
        
        public ArtikelBuilder artikel_id(int artikel_id){
            this.artikel_id = artikel_id;
            return this;
        }
        
        public ArtikelBuilder artikel_naam(String artikel_naam){
            this.artikel_naam = artikel_naam;
            return this;
        }
         public ArtikelBuilder artikel_voorraad(int artikel_voorraad){
            this.artikel_voorraad = artikel_voorraad;
            return this;
        }
        public ArtikelBuilder artikel_prijs(BigDecimal artikel_prijs){
            this.artikel_prijs = artikel_prijs;
            return this;
        }
        public Artikel build(){
            return new Artikel(this);
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
    
}
