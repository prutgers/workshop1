/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class Klant {
    private int klant_id;
    private String voornaam;
    private String achternaam;
    private String tussenvoegsel;
    private String email;
    private int adres_id;
    private Adres adres;
    
    public Klant(){
    }
    
    public Klant(int klant_id){
        this.klant_id = klant_id;
        Scanner input = new Scanner(System.in);
        System.out.println("Create a new Klant!");
        System.out.print("Your first name :");
        voornaam = input.next();
        System.out.print("Your last name :");
        achternaam = input.next();
        System.out.print("Additieves :");
        tussenvoegsel = input.next();
        System.out.print("Your email adress :");
        email = input.next();
        adres = new Adres();
    }
    
    public Klant(ResultSet klantData) throws SQLException{
        klantData.next();
        klant_id = klantData.getInt(1);
        voornaam = klantData.getString(2);
        achternaam = klantData.getString(3);
        tussenvoegsel = klantData.getString(4);
        email = klantData.getString(5);
        adres = new Adres();
    }
    
    public String toString(){
        return "" + getKlant_id() + ", " + getVoornaam() + ", " + getAchternaam() + ", "
                + getTussenvoegsel() + ", " + getEmail()+ ", " + getAdres().toString();
    }

    /**
     * @return the klant_id
     */
    public int getKlant_id() {
        return klant_id;
    }

    /**
     * @param klant_id the klant_id to set
     */
    public void setKlant_id(int klant_id) {
        this.klant_id = klant_id;
    }

    /**
     * @return the voornaam
     */
    public String getVoornaam() {
        return voornaam;
    }

    /**
     * @param voornaam the voornaam to set
     */
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    /**
     * @return the achternaam
     */
    public String getAchternaam() {
        return achternaam;
    }

    /**
     * @param achternaam the achternaam to set
     */
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    /**
     * @return the tussenvoegsel
     */
    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    /**
     * @param tussenvoegsel the tussenvoegsel to set
     */
    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the adres_id
     */
    public int getAdres_id() {
        return adres_id;
    }

    /**
     * @param adres_id the adres_id to set
     */
    public void setAdres_id(int klant_id) {
        this.adres_id = klant_id;
    }
    
    /**
     * @return the adres
     */
    public Adres getAdres() {
        return adres;
    }

    /**
     * @param adres the adres to set
     */
    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}
