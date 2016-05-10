/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAOFactory.DAOFactory;
import POJO.*;
import View.*;
import interfaceDAO.*;
import java.math.BigDecimal;
import java.util.ArrayList;


/**
 *
 * @author Gebruiker
 */
public class BestellingController {
    public static void startKeuze(){
        BestellingKeuzeView view = new BestellingKeuzeView();
        view.keuzeView();
        
      
        switch (view.getSelect()) {
            case 1:
                BestellingController.create();
                break;
            case 2:
                createKoppel();
                break;
            case 3:
                update();
                break;
            case 4:
                readAll();
                break;
            case 5:
                readByID();
                break;
            case 6:
                readByKlantID();
                break;
            case 7:
                readKoppel();
                break;
            case 8:
                deleteKoppel();
                break;
            case 9:
                delete();
                break;
            case 0:
                MainController.hoofdMenu();
                break;
            default:
                view.keuzeFout();
                break;
            }
        if(view.getSelect() != 0){
            startKeuze();
        }
        
    }
    public static void create(){
        BestellingView view = new BestellingView();
        view.readKlantID();
        
        Bestelling bestelling = new Bestelling();
        bestelling.setKlantID(view.getKlandID());
        
        BestellingDAO dao = DAOFactory.getBestellingDAO();
        Bestelling newBestelling = dao.createBestelling(bestelling);
        createKoppel(newBestelling.getBestellingID());
        
    }
    //maakt nieuw koppel aan voor bestaande bestelling
    public static void createKoppel(){
        BestellingArtikelView view  = new BestellingArtikelView();
        view.readUpdate();

        BestellingArtikel koppel = new BestellingArtikel();
        koppel.setBestelling_id(view.getBestellingID());
        koppel.setArtikel_id(view.getArtikelID());
        koppel.setAantal(view.getAantal());
        
        BestellingArtikelDAO dao = DAOFactory.getBestellingArtikelDAO();
        dao.createKoppelBestellingArtikel(koppel);
    }
    public static void update(){
        BestellingArtikelView view = new BestellingArtikelView();
        view.readUpdate();
        
        BestellingArtikelDAO dao = DAOFactory.getBestellingArtikelDAO();   
        BestellingArtikel koppel = dao.readKoppel(view.getBestellingID(), view.getArtikelID());
        koppel.setAantal(view.getAantal());
       
        dao.updateKoppel(koppel);
    }
    public static void delete(){
        BestellingView view = new BestellingView();
        view.readBestellingID();
        
        BestellingArtikelDAO baDAO = DAOFactory.getBestellingArtikelDAO();
        baDAO.deleteKoppelMetBestellingID(view.getBestellingID());
        
        BestellingDAO dao = DAOFactory.getBestellingDAO();
        dao.deleteBestelling(view.getBestellingID());

    }
    public static void deleteKoppel(){
        BestellingArtikelView view = new BestellingArtikelView();
        view.readDelete();
        
        BestellingArtikelDAO dao = DAOFactory.getBestellingArtikelDAO();
        dao.deleteKoppel(view.getBestellingID(), view.getArtikelID());
    }

    public static void readAll(){
        BestellingView view = new BestellingView();
        BestellingDAO dao = DAOFactory.getBestellingDAO();
        ArrayList<Bestelling> list = dao.getAllBestelling();
        view.print(list);
    }
    public static void readByID(){
        BestellingView view = new BestellingView();
        view.readBestellingID();
        BestellingDAO dao = DAOFactory.getBestellingDAO();
        Bestelling bestelling = dao.getBestellingById(view.getBestellingID());
        view.print(bestelling);
    }
    public static void readByKlantID(){
        BestellingView view = new BestellingView();
        view.readKlantID();
        BestellingDAO dao = DAOFactory.getBestellingDAO();
        ArrayList<Bestelling> list = dao.getBestellingByKlantId(view.getKlandID());
        view.print(list);
    }
    public static void readKoppel(){
        BestellingView view = new BestellingView();
        view.readBestellingID();
        BestellingArtikelDAO dao = DAOFactory.getBestellingArtikelDAO();
        ArrayList<BestellingArtikel> list = dao.readKoppelMetBestellingID(view.getBestellingID());
        view.printArtikelLijst(list);
    }
    
    
    /**
     * Alleen automatisch 
     * createBestelArtikelMenu koppelt artikelen en bestellingen aan elkaar
     * en 1 methode met argumenten voor automatische invoer
     */
    public static void createKoppel(int bestellingID){
        BestellingArtikelView view  = new BestellingArtikelView();
        view.readCreate();

        BestellingArtikel koppel = new BestellingArtikel();
        koppel.setBestelling_id(bestellingID);
        koppel.setArtikel_id(view.getArtikelID());
        koppel.setAantal(view.getAantal());
        
      
        
        BestellingArtikelDAO baDAO = DAOFactory.getBestellingArtikelDAO();      
        baDAO.createKoppelBestellingArtikel(koppel);
        
    }
    
    
    //deze code wordtnog niet gebruikt
    public static BigDecimal getArtikelPrijs(int artikel_id){
        ArtikelDAO dao = DAOFactory.getArtikelDAO();
        Artikel artikel = dao.readArtikel(artikel_id);
        BigDecimal totaal = artikel.getArtikel_prijs(); // moet nog vermenigvuldien met het aantal
        return totaal;
    }
    
    
}
