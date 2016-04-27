/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author Gebruiker
 */
public class Bestelling {
    private int bestellingID;
    private int klantID;
    private int artikelID_1;
    private int artikelID_2;
    private int artikelID_3;
    private String artikelNaam_1;
    private String artikelNaam_2;
    private String artikelNaam_3;
    private double artikelPrijs_1;
    private double artikelPrijs_2;
    private double artikelPrijs_3;
    private int artikelAantal_1;
    private int artikelAantal_2;
    private int artikelAantal_3;

    public int getArtikelAantal_1() {
        return artikelAantal_1;
    }

    public void setArtikelAantal_1(int artikelAantal_1) {
        this.artikelAantal_1 = artikelAantal_1;
    }

    public int getArtikelAantal_2() {
        return artikelAantal_2;
    }

    public void setArtikelAantal_2(int artikelAantal_2) {
        this.artikelAantal_2 = artikelAantal_2;
    }

    public int getArtikelAantal_3() {
        return artikelAantal_3;
    }

    public void setArtikelAantal_3(int artikelAantal_3) {
        this.artikelAantal_3 = artikelAantal_3;
    }

    public int getBestellingID() {
        return bestellingID;
    }

    public void setBestellingID(int bestellingID) {
        this.bestellingID = bestellingID;
    }

    public int getKlantID() {
        return klantID;
    }

    public void setKlantID(int klantID) {
        this.klantID = klantID;
    }

    public int getArtikelID_1() {
        return artikelID_1;
    }

    public void setArtikelID_1(int artikelID_1) {
        this.artikelID_1 = artikelID_1;
    }

    public int getArtikelID_2() {
        return artikelID_2;
    }

    public void setArtikelID_2(int artikelID_2) {
        this.artikelID_2 = artikelID_2;
    }

    public int getArtikelID_3() {
        return artikelID_3;
    }

    public void setArtikelID_3(int artikelID_3) {
        this.artikelID_3 = artikelID_3;
    }

    public String getArtikelNaam_1() {
        return artikelNaam_1;
    }

    public void setArtikelNaam_1(String artikelNaam_1) {
        this.artikelNaam_1 = artikelNaam_1;
    }

    public String getArtikelNaam_2() {
        return artikelNaam_2;
    }

    public void setArtikelNaam_2(String artikelNaam_2) {
        this.artikelNaam_2 = artikelNaam_2;
    }

    public String getArtikelNaam_3() {
        return artikelNaam_3;
    }

    public void setArtikelNaam_3(String artikelNaam_3) {
        this.artikelNaam_3 = artikelNaam_3;
    }

    public double getArtikelPrijs_1() {
        return artikelPrijs_1;
    }

    public void setArtikelPrijs_1(double artikelPrijs_1) {
        this.artikelPrijs_1 = artikelPrijs_1;
    }

    public double getArtikelPrijs_2() {
        return artikelPrijs_2;
    }

    public void setArtikelPrijs_2(double artikelPrijs_2) {
        this.artikelPrijs_2 = artikelPrijs_2;
    }

    public double getArtikelPrijs_3() {
        return artikelPrijs_3;
    }

    public void setArtikelPrijs_3(double artikelPrijs_3) {
        this.artikelPrijs_3 = artikelPrijs_3;
    }

}
