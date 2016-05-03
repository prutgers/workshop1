/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import POJO.BestellingArtikel;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public interface BestellingArtikelDAO {
  
    public void createKoppelBestellingArtikel(BestellingArtikel koppelBestellingArtikel);
    
    public ArrayList<BestellingArtikel> readKoppelMetBestellingID(int bestelling_id);
    
    public ArrayList<BestellingArtikel> readKoppelMetArtikelID(int artikel_id);
    
    public BestellingArtikel readKoppel(int bestelling_id, int artikel_id);
    
    public void deleteKoppelMetBestellingID(int bestelling_id);
    
    // dit is waarschijnlijk onzin
    public void deleteKoppelMetArtikelID(int artikel_id);
    
    public void deleteKoppel(int bestellingID,int artikelID);
    
    public BestellingArtikel readKoppelById(int koppelID);
    
    public void updateKoppel(BestellingArtikel koppel);
}
