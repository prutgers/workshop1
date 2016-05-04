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
        System.out.println("Voer de straatnaam in:");
        this.straatnaam = VerifyInputScanner.verifyString();
        System.out.println("Voer het huisnummer in:");
        this.huisnummer = VerifyInputScanner.verifyInt();
        System.out.println("Voer de toevoeging in:");
        this.toevoeging = VerifyInputScanner.verifyString();
        System.out.println("Voer de postcode in:");
        this.postcode = VerifyInputScanner.verifyString();
        System.out.println("Voer de woonplaats in:");
        this.woonplaats = VerifyInputScanner.verifyString();
    }
    
    public void update() {
        System.out.println("Welk adres wilt u aanpassen? \n"
                + "Voer het adres ID in: ");
        int adres_id = VerifyInputScanner.verifyInt();

        System.out.println("Voer een nieuwe straatnaam in: ");
        this.straatnaam = VerifyInputScanner.verifyString();
        System.out.println("Voer een nieuw huisnummer in: ");
        this.huisnummer = VerifyInputScanner.verifyInt();
        System.out.println("Voer een nieuwe toevoeging in: ");
        this.toevoeging = VerifyInputScanner.verifyString();
        System.out.println("Voer een nieuwe postcode in: ");
        this.postcode = VerifyInputScanner.verifyString();
        System.out.println("Voer een nieuwe woonplaats in: ");
        this.woonplaats = VerifyInputScanner.verifyString();
    }
    
    public void readAll(ArrayList<Adres> adresGegevens) {
        System.out.format("%s, %s, %s, %s, %s, %s\n",
            "Adres ID", "Straatnaam", "Huisnummer", "Toevoeging",
                "Postcode", "Woonplaats");
        
        for(Adres a : adresGegevens) {
            System.out.format("%s, %s, %s, %s, %s, %s\n", a.getAdres_id(),
                    a.getStraatnaam(), a.getHuisnummer(), a.getToevoeging(),
                    a.getPostcode(), a.getWoonplaats());            
        }

    }
    
    public void readAdresByID() {
        System.out.println("Voer het adres ID in: ");
        adres_id = VerifyInputScanner.verifyInt();
    }
    
    public void delete() {
        System.out.println("Welk adres wilt u verwijderen? \n"
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
