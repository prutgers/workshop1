package View;

/**
 *
 * @author Sonja
 */

import POJO.Adres;
import formatMessage.VerifyInputScanner;
import java.util.ArrayList;

public class AdresView {
    private int adres_id;
    private String straatnaam;
    private int huisnummer;
    private String toevoeging;
    private String postcode;
    private String woonplaats;
    
    public void create() {
        System.out.print("Voer de straatnaam in: ");
        this.straatnaam = VerifyInputScanner.verifyString();
        System.out.print("Voer het huisnummer in: ");
        this.huisnummer = VerifyInputScanner.verifyInt();
        System.out.print("Voer de toevoeging in: ");
        this.toevoeging = VerifyInputScanner.verifyString();
        System.out.print("Voer de postcode in: ");
        this.postcode = VerifyInputScanner.verifyString();
        System.out.print("Voer de woonplaats in: ");
        this.woonplaats = VerifyInputScanner.verifyString();
    }
    
    public void update() {
        System.out.print("Welk adres wilt u aanpassen? \n"
                + "Voer het adres ID in: ");
        this.adres_id = VerifyInputScanner.verifyInt();

        System.out.print("Voer een nieuwe straatnaam in: ");
        this.straatnaam = VerifyInputScanner.verifyString();
        System.out.print("Voer een nieuw huisnummer in: ");
        this.huisnummer = VerifyInputScanner.verifyInt();
        System.out.print("Voer een nieuwe toevoeging in: ");
        this.toevoeging = VerifyInputScanner.verifyString();
        System.out.print("Voer een nieuwe postcode in: ");
        this.postcode = VerifyInputScanner.verifyString();
        System.out.print("Voer een nieuwe woonplaats in: ");
        this.woonplaats = VerifyInputScanner.verifyString();
    }
    
    public void readAll(ArrayList<Adres> adresGegevens) {
        System.out.println("ADRESGEGEVENS\n"
                         + "-------------");
        System.out.format("%s| %s| %s| %s| %s| %s|\n",
            "Adres ID", "Straatnaam", "Huisnummer", "Toevoeging",
                "Postcode", "Woonplaats");
        
        for(Adres a : adresGegevens) {
            System.out.format("%d| %s| %d| %s| %s| %s|\n", 
                    a.getAdres_id(), a.getStraatnaam(), a.getHuisnummer(), 
                    a.getToevoeging(), a.getPostcode(), a.getWoonplaats());            
        }

    }
    
    public void readAdresByID() {
        System.out.print("Voer het adres ID in: ");
        this.adres_id = VerifyInputScanner.verifyInt();
    }
    
    public void readAdresByID(Adres adres) {
        System.out.println("Adres ID: " + adres.getAdres_id());
        System.out.println("Straatnaam: " + adres.getStraatnaam());
        System.out.println("Huisnummer: " + adres.getHuisnummer());
        System.out.println("Toevoeging: " + adres.getToevoeging());
        System.out.println("Postcode: " + adres.getPostcode());
        System.out.println("Woonplaats: " + adres.getWoonplaats());
    }
    
    public void delete() {
        System.out.print("Welk adres wilt u verwijderen? \n"
                + "Voer het adres ID in: ");
        this.adres_id = VerifyInputScanner.verifyInt();
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
     * @return the straatnaam
     */
    public String getStraatnaam() {
        return straatnaam;
    }

    /**
     * @param straatnaam the straatnaam to set
     */
    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    /**
     * @return the huisnummer
     */
    public int getHuisnummer() {
        return huisnummer;
    }

    /**
     * @param huisnummer the huisnummer to set
     */
    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    /**
     * @return the toevoeging
     */
    public String getToevoeging() {
        return toevoeging;
    }

    /**
     * @param toevoeging the toevoeging to set
     */
    public void setToevoeging(String toevoeging) {
        this.toevoeging = toevoeging;
    }

    /**
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * @return the woonplaats
     */
    public String getWoonplaats() {
        return woonplaats;
    }

    /**
     * @param woonplaats the woonplaats to set
     */
    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }
    
    
}
