/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author lucas
 */

import DAOFactory.KlantDAOFactory;
import POJO.Klant;
import java.util.ArrayList;
import formatMessage.VerifyInputScanner;

public class KlantView {
    private int klant_id;
    private String voornaam;
    private String achternaam;
    private String tussenvoegsel;
    private String email;
    
    public KlantView() {
    }
    
    public KlantView create(){
        System.out.print("\nVoer uw gegevens in.");
        System.out.print("\nUw voornaam:");
        this.setVoornaam( VerifyInputScanner.verifyString() );
        System.out.print("\nUw achternaam");
        this.setAchternaam( VerifyInputScanner.verifyString() );
        System.out.print("\nTussenvoegsels");
        this.setTussenvoegsel( VerifyInputScanner.verifyString() );
        System.out.print("\nYour email adress :");
        this.setEmail( VerifyInputScanner.verifyString() );
        
        return this;
    }
    
    public KlantView read(){
        System.out.print("\nKlant ID getal? : ");
        this.setKlant_id( VerifyInputScanner.verifyInt() );
        this.setVoornaam(null);
        this.setAchternaam(null);
        this.setTussenvoegsel(null);
        this.setEmail(null);
        return this;
    }
    
    public KlantView update(){        
        //select a Klant
        System.out.println("\nUpdate een Klant! \nWat is je Klant_id?");
        int klant_idlocal = VerifyInputScanner.verifyInt();
        
        System.out.println("Welkom terug "+ new KlantDAOFactory().getKlantDAO().readKlant( klant_idlocal ).getVoornaam() );
        
        //verkrijg de nieuwe data uit de commandline en zet in de Outputklant
        System.out.println("Please fill in your new infromation:"
                + " (If you don't want to update a field just leave it blank.)");
        System.out.print("Je nieuwe Voornaam :");
        String nieuweVoornaam = VerifyInputScanner.verifyString();
        if ( !nieuweVoornaam.equals("") ) {
            this.setVoornaam( nieuweVoornaam );
                }
        System.out.print("Je nieuwe Achternaam:");
        String nieuweAchternaam = VerifyInputScanner.verifyString();
        if ( !nieuweAchternaam.equals("") ) {
            this.setAchternaam( nieuweAchternaam );
                }
        System.out.print("Je nieuwe Toevoegingen:");
        String nieuweTussenvoegsel = VerifyInputScanner.verifyString();
        if ( !nieuweTussenvoegsel.equals("") ) {
            this.setTussenvoegsel( nieuweTussenvoegsel );
                }
        System.out.print("Je nieuwe Email adres:");
        String nieuwEmail = VerifyInputScanner.verifyString();
        if ( !nieuwEmail.equals("") ) {
            this.setEmail( nieuwEmail );
                }
        return this;
    }
    
    public KlantView delete(){
        System.out.print("\nKlant ID getal? : ");
        this.setKlant_id( VerifyInputScanner.verifyInt() );
        this.setVoornaam(null);
        this.setAchternaam(null);
        this.setTussenvoegsel(null);
        this.setEmail(null);
        return this;
    }
    
    public KlantView readAllByKlant(){
        System.out.print("\nVoer waar mogelijk de gegevens in.");
        System.out.print("\nUw klant ID getal: ");
        String klant_id = VerifyInputScanner.verifyString();
        if ( !klant_id.equals("") ) {
            this.setKlant_id( Integer.parseInt(klant_id) );
        }
        System.out.print("\nVoornaam:");
        String nieuweVoornaam = VerifyInputScanner.verifyString();
        if ( !nieuweVoornaam.equals("") ) {
            this.setVoornaam( nieuweVoornaam );
        }
        System.out.print("\nAchternaam");
        String nieuweAchternaam = VerifyInputScanner.verifyString();
        if ( !nieuweAchternaam.equals("") ) {
            this.setAchternaam( nieuweAchternaam );
        }
        System.out.print("\nTussenvoegsels");
        String nieuweTussenvoegsel = VerifyInputScanner.verifyString();
        if ( !nieuweTussenvoegsel.equals("") ) {
            this.setTussenvoegsel( nieuweTussenvoegsel );
        }
        System.out.print("\nEmail adress :");
        String nieuwEmail = VerifyInputScanner.verifyString();
        if ( !nieuwEmail.equals("") ) {
            this.setEmail( nieuwEmail );
        }
        
        return this;
    }
    
    public void print(ArrayList<Klant> klantLijst){
        System.out.println("\nLIJST MET ALLE KLANTEN \n"
                + "====");
        System.out.printf("%12s| %31s| %32s| %13s| %31s|\n", "Klant_id", "Voornaam", "Achternaam", "Tussenvoegsel", "Email");
        for(Klant e : klantLijst){
         System.out.printf("%12s| %31s| %32s| %13s| %31s|\n", e.getKlant_id(), e.getVoornaam(), e.getAchternaam(), e.getTussenvoegsel(), e.getEmail());
        }
    }
    
    public void print(Klant e){
        System.out.printf("%12s| %31s| %32s| %13s| %31s|\n", "Klant_id", "Voornaam", "Achternaam", "Tussenvoegsel", "Email");
        System.out.printf("%12s| %31s| %32s| %13s| %31s|\n", e.getKlant_id(), e.getVoornaam(), e.getAchternaam(), e.getTussenvoegsel(), e.getEmail());}

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
    
}
