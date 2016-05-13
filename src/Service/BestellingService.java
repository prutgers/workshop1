/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAOFactory.DAOFactory;
import POJO.Artikel;
import POJO.Bestelling;
import POJO.BestellingArtikel;
import View.BestellingArtikelView;
import View.BestellingView;
import interfaceDAO.ArtikelDAO;
import interfaceDAO.BestellingArtikelDAO;
import interfaceDAO.BestellingDAO;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class BestellingService {
    
    public Bestelling create(Bestelling bestelling){
        BestellingDAO dao = DAOFactory.getBestellingDAO();
        Bestelling newBestelling = dao.createBestelling(bestelling);
        return newBestelling;
        
    }
    //maakt nieuw koppel aan voor bestaande bestelling
    public void createKoppel(BestellingArtikel koppel){
        BestellingArtikelDAO dao = DAOFactory.getBestellingArtikelDAO();
        dao.createKoppelBestellingArtikel(koppel);
    }
    
    public void update(BestellingArtikel koppel){
        BestellingArtikelDAO dao = DAOFactory.getBestellingArtikelDAO(); 
        dao.updateKoppel(koppel);
    }
    
    
    public void deleteBestelling(int bestellingID){
        //Belangrijk om eerst het koppel te verwijderen voor de bestelling anders
        //gaat MySQL zeuren over contraints
        deleteKoppelMetBestellingID(bestellingID);
        
        BestellingArtikelDAO baDAO = DAOFactory.getBestellingArtikelDAO();
        baDAO.deleteKoppelMetBestellingID(bestellingID);
    }
    
    public void deleteKoppelMetBestellingID(int bestellingID){
        BestellingDAO dao = DAOFactory.getBestellingDAO();
        dao.deleteBestelling(bestellingID);       
    }
    public void deleteKoppel(int bestellingID, int artikelID){
        BestellingArtikelDAO dao = DAOFactory.getBestellingArtikelDAO();
        dao.deleteKoppel(bestellingID, artikelID);
    }

    public ArrayList<Bestelling>readAll(){
        BestellingDAO dao = DAOFactory.getBestellingDAO();
        return dao.getAllBestelling();
    }
    public Bestelling readByID(int bestellingID){
        BestellingDAO dao = DAOFactory.getBestellingDAO();
        return dao.getBestellingById(bestellingID);
    }
    
    public ArrayList<Bestelling> readByKlantID(int klantID){
        BestellingDAO dao = DAOFactory.getBestellingDAO();
        return dao.getBestellingByKlantId(klantID);
    }
    
    public ArrayList<BestellingArtikel> readKoppel(int bestellingID){
        BestellingArtikelDAO dao = DAOFactory.getBestellingArtikelDAO();
        return dao.readKoppelMetBestellingID(bestellingID);
    }
    
    
  
    
    
    //deze code wordtnog niet gebruikt
    public BigDecimal getArtikelPrijs(int artikel_id){
        ArtikelDAO dao = DAOFactory.getArtikelDAO();
        Artikel artikel = dao.readArtikel(artikel_id);
        BigDecimal totaal = artikel.getArtikel_prijs(); // moet nog vermenigvuldien met het aantal
        return totaal;
    }
    
}
