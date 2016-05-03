package View;

/**
 *
 * @author Sonja
 */

import formatMessage.VerifyInputScanner;

public class AdresView {
    private int adres_id;
    private String straatnaam;
    private int huisnummer;
    private String toevoeging;
    private String postcode;
    private String woonplaats;
    
    public void create() {
        //moet nog iets met de return_generated_key statement voor het adres_id
        //maar daar ben ik nog niet helemaal uit
        System.out.println("Voer de straatnaam in:");
        String straatnaam = VerifyInputScanner.verifyString();
        System.out.println("Voer het huisnummer in:");
        int huisnummer = VerifyInputScanner.verifyInt();
        System.out.println("Voer de toevoeging in:");
        String toevoeging = VerifyInputScanner.verifyString();
        System.out.println("Voer de postcode in:");
        String postcode = VerifyInputScanner.verifyString();
        System.out.println("Voer de woonplaats in:");
        String woonplaats = VerifyInputScanner.verifyString();
    }
    
    public void update() {
        System.out.println("Welk adres wilt u aanpassen? \n"
                + "Voer het adres ID in: ");
        int adres_id = VerifyInputScanner.verifyInt();

        System.out.println("Voer een nieuwe straatnaam in: ");
        String straatnaam = VerifyInputScanner.verifyString();
        System.out.println("Voer een nieuw huisnummer in: ");
        int huisnummer = VerifyInputScanner.verifyInt();
        System.out.println("Voer een nieuwe toevoeging in: ");
        String toevoeging = VerifyInputScanner.verifyString();
        System.out.println("Voer een nieuwe postcode in: ");
        String postcode = VerifyInputScanner.verifyString();
        System.out.println("Voer een nieuwe woonplaats in: ");
        String woonplaats = VerifyInputScanner.verifyString();
    }
    
    public void readAll() {
        System.out.println("ADRESGEGEVENS \n"
            + "----------------");
        System.out.printf("%15s %15s %15s %15s %15s %15s \n", 
                "Adres ID", "Straatnaam", "Huisnummer", "Toevoeging",
                "Postcode", "Woonplaats");
    }
    
    public void readAllByID() {
        //...
    }
    
    public void delete() {
        System.out.println("Welk adres wilt u verwijderen? \n"
                + "Voer het adres ID in: ");
        int adres_id = VerifyInputScanner.verifyInt();
        
        System.out.println("Het volgende adres is verwijderd: " + adres_id);
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
