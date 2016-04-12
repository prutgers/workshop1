package workshop1;

/**
 *
 * @author Sonja
 */
public class Adres {
     String straatnaam;
     int huisnummer;
     String toevoeging;
     String postcode;
     String woonplaats;
     int adres_id;
     private int klant_id;

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
     * @param huisnummer the huisnr to set
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
    
}

