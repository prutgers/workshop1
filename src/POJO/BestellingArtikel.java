/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author Peter
 */
public class BestellingArtikel {
    
    private int bestelling_id;
    private int artikel_id;
    private int koppel_id;
    private int aantal;


    public int getBestelling_id() {
        return bestelling_id;
    }
    
    public void setBestelling_id(int bestelling_id) {
        this.bestelling_id = bestelling_id;
    }
    
    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public int getArtikel_id() {
        return artikel_id;
    }
    
    public void setArtikel_id(int artikel_id) {
        this.artikel_id = artikel_id;
    }

    public int getKoppel_id() {
        return koppel_id;
    }

    public void setKoppel_id(int Koppel_id) {
        this.koppel_id = Koppel_id;
    }
    
}
