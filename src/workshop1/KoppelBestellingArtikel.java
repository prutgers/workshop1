/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

/**
 *
 * @author Peter
 */
public class KoppelBestellingArtikel {
    
    private int bestelling_id;
    private int artikel_id;

    /**
     * @return the bestelling_id
     */
    public int getBestelling_id() {
        return bestelling_id;
    }

    /**
     * @param bestelling_id the bestelling_id to set
     */
    public void setBestelling_id(int bestelling_id) {
        this.bestelling_id = bestelling_id;
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
    
}
