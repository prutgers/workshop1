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

import DAOFactory.DAOFactory;
import POJO.KlantAdres;
import formatMessage.PrintFormat;
import java.util.ArrayList;
import formatMessage.VerifyInputScanner;

public class KlantAdresView {
    private int klant_id;
    private int adres_id;
    private int koppel_id;
    
    public KlantAdresView() {
    }
    
    public KlantAdresView create(){
        System.out.println("Voer uw gegevens in.");
        System.out.print("\nVoer het klant ID in: ");
        this.setKlant_id( VerifyInputScanner.verifyInt() );
        System.out.print("Voer het adres ID in: ");
        this.setKlant_id( VerifyInputScanner.verifyInt() );
        
        return this;
    }
    
    public KlantAdresView readByKlant(){
        this.resetKlantAdres();
        System.out.print("Voer het klant ID in: ");
        this.setKlant_id( VerifyInputScanner.verifyInt() );
        return this;
    }
    
    public KlantAdresView readByAdres(){
        this.resetKlantAdres();
        System.out.print("Voer het adres ID in: ");
        this.setKlant_id( VerifyInputScanner.verifyInt() );
        return this;
    }
    
        
    public KlantAdresView deleteByKlant(){
        this.resetKlantAdres();
        System.out.print("Voer het klant ID in: ");
        this.setKlant_id( VerifyInputScanner.verifyInt() );
        return this;
    }  
    
    public KlantAdresView deleteByAdres(){
        this.resetKlantAdres();
        System.out.print("Voer het adres ID in: ");
        this.setKlant_id( VerifyInputScanner.verifyInt() );
        return this;
    }
    
    
    public void print(ArrayList<KlantAdres> klantLijst){
        PrintFormat.printHeader("KLANTADRESKOPPELS");
        System.out.printf("%10s\t\t| %10s\t\t| %10s\t\t|\n", "Klant ID", "Adres ID", "Koppel ID");
        for(KlantAdres e : klantLijst){
         System.out.printf("%10d\t\t| %10d\t\t| %10d\t\t|\n", e.getKlant_id(), e.getAdres_id(), e.getKoppel_id());
        }
    }
    
    public void print(KlantAdres e){
        System.out.printf("%10s\t\t| %10s\t\t| %10s\t\t|\n", "Klant ID", "Adres ID", "Koppel ID");
        System.out.printf("%10d\t\t| %10d\t\t| %10d\t\t|\n", e.getKlant_id(), e.getAdres_id(), e.getKoppel_id());
    }
    
    public void printUpdate(KlantAdres e){
        System.out.println("De gegevens zijn aangepast.");
        this.print(e);
    }

    public void resetKlantAdres() {
        this.setKlant_id(0);
        this.setAdres_id(0);
        this.setKoppel_id(0);
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
     * @return the adres_id
     */
    public int getAdres_id() {
        return adres_id;
    }

    /**
     * @param adres_id the adres_id to set
     */
    public void setAdres_id(int adres_id) {
        this.adres_id = adres_id;
    }

    /**
     * @return the koppel_id
     */
    public int getKoppel_id() {
        return koppel_id;
    }

    /**
     * @param koppel_id the koppel_id to set
     */
    public void setKoppel_id(int koppel_id) {
        this.koppel_id = koppel_id;
    }
}
