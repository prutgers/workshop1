/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAOFactory.DAOFactory;
import DAO.MySQL.BestellingDAOMySQL;
import POJO.*;
import Service.BestellingService;
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
        
        //maak een nieuwe bestellingview waarin je vraagt voor welke klant
        //de bestelling is
        BestellingView view = new BestellingView();
        view.readKlantID();
        
        //Maakt een nieuwe bestelling en zet de klantID
        Bestelling bestelling = new Bestelling();
        bestelling.setKlantID(view.getKlantID());
        
        BestellingService BS = new BestellingService();
        Bestelling newBestelling = BS.create(bestelling);
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
        BestellingService BS = new BestellingService();
        BS.createKoppel(koppel);
        
    }
    public static void update(){
        BestellingArtikelView view = new BestellingArtikelView();
        view.readUpdate();
        
          
        BestellingArtikel koppel = new BestellingArtikel();
        koppel.setArtikel_id(view.getArtikelID());
        koppel.setBestelling_id(view.getBestellingID());
        koppel.setAantal(view.getAantal());
       
        BestellingService BS = new BestellingService();
        BS.update(koppel);
        
    }
    public static void delete(){
        BestellingView view = new BestellingView();
        view.readBestellingID();

        BestellingService BS = new BestellingService();
        BS.deleteBestelling(view.getBestellingID());
    }
    public static void deleteKoppel(){
        BestellingArtikelView view = new BestellingArtikelView();
        view.readDelete();
        BestellingService BS = new BestellingService();
        BS.deleteKoppel(view.getBestellingID(),view.getArtikelID());
    }

    public static void readAll(){
        BestellingView view = new BestellingView();
        BestellingService BS = new BestellingService();
        view.print(BS.readAll());
    }
    public static void readByID(){
        BestellingView view = new BestellingView();
        view.readBestellingID();
        BestellingService BS = new BestellingService();
        view.print(BS.readByID(view.getBestellingID()));
    }
    public static void readByKlantID(){
        BestellingView view = new BestellingView();
        view.readKlantID();
        BestellingService BS = new BestellingService();
        view.print(BS.readByKlantID(view.getKlantID()));
    }
    public static void readKoppel(){
        BestellingView view = new BestellingView();
        view.readBestellingID();
        BestellingService BS = new BestellingService();
        view.printArtikelLijst(BS.readKoppel(view.getBestellingID()));
    }
    
    
    /**
     * Alleen automatisch 
     * createBestelArtikelMenu koppelt artikelen en bestellingen aan elkaar.
     * 1 methode met argumenten voor automatische invoer
     */
    public static void createKoppel(int bestellingID){
        BestellingArtikelView view  = new BestellingArtikelView();
        view.readCreate();

        BestellingArtikel koppel = new BestellingArtikel();
        koppel.setBestelling_id(bestellingID);
        koppel.setArtikel_id(view.getArtikelID());
        koppel.setAantal(view.getAantal());
        
        BestellingService BS = new BestellingService();
        BS.createKoppel(koppel);
    }
    
    
    //deze code wordtnog niet gebruikt
    public static BigDecimal getArtikelPrijs(int artikel_id){
        ArtikelDAO dao = DAOFactory.getArtikelDAO();
        Artikel artikel = dao.readArtikel(artikel_id);
        BigDecimal totaal = artikel.getArtikel_prijs(); // moet nog vermenigvuldien met het aantal
        return totaal;
    }
    
    
}
