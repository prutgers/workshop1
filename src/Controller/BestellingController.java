/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MySQL.BestellingArtikelDAOMySQL;
import DAO.MySQL.BestellingDAOMySQL;
import POJO.Bestelling;
import View.BestellingView;
import java.util.ArrayList;

import Menu.HoofdMenu;
import POJO.BestellingArtikel;
import View.BestellingArtikelView;
import View.BestellingKeuzeView;

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
                create();
                startKeuze();
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
                HoofdMenu.startMenu();
                break;
            default:
                view.keuzeFout();
                break;
            }
        
    }
    public static void create(){
        BestellingView view = new BestellingView();
        view.readKlantID();
        
        Bestelling bestelling = new Bestelling();
        bestelling.setKlantID(view.getKlandID());
        
        BestellingDAOMySQL dao = new BestellingDAOMySQL();
        Bestelling newBestelling =dao.createBestelling(bestelling);
        
        createKoppel(newBestelling.getBestellingID());
        
    }
    //maakt nieuw koppel aan voor bestaande bestelling
    public static void createKoppel(){
        BestellingArtikelView view  = new BestellingArtikelView();
        view.readAll();

        BestellingArtikel koppel = new BestellingArtikel();
        koppel.setBestelling_id(view.getBestellingID());
        koppel.setArtikel_id(view.getArtikelID());
        koppel.setAantal(view.getAantal());
        
        BestellingArtikelDAOMySQL baDAO = new BestellingArtikelDAOMySQL();      
        baDAO.createKoppelBestellingArtikel(koppel);
    }
    public static void update(){
        BestellingArtikelView view = new BestellingArtikelView();
        view.readAll();
        
        BestellingArtikelDAOMySQL dao = new BestellingArtikelDAOMySQL();    
        BestellingArtikel koppel = dao.readKoppel(view.getBestellingID(), view.getArtikelID());
        koppel.setAantal(view.getAantal());
       
        dao.updateKoppel(koppel);
    }
    public static void delete(){
        BestellingView view = new BestellingView();
        view.readBestellingID();
        
        BestellingArtikelDAOMySQL baDao = new BestellingArtikelDAOMySQL();
        baDao.deleteKoppelMetBestellingID(view.getBestellingID());
        
        BestellingDAOMySQL dao = new BestellingDAOMySQL(); 
        dao.deleteBestelling(view.getBestellingID());

    }
    public static void deleteKoppel(){
        BestellingArtikelView view = new BestellingArtikelView();
        view.readAll();
        
        BestellingArtikelDAOMySQL dao = new BestellingArtikelDAOMySQL();
        dao.deleteKoppel(view.getBestellingID(), view.getArtikelID());
    }

    public static void readAll(){
        BestellingView view = new BestellingView();
        BestellingDAOMySQL dao = new BestellingDAOMySQL();
        ArrayList<Bestelling> list = dao.getAllBestelling();
        view.print(list);
    }
    public static void readByID(){
        BestellingView view = new BestellingView();
        view.readBestellingID();
        BestellingDAOMySQL dao = new BestellingDAOMySQL();
        Bestelling bestelling = dao.getBestellingById(view.getBestellingID());
        view.print(bestelling);
    }
    public static void readByKlantID(){
        BestellingView view = new BestellingView();
        view.readKlantID();
        BestellingDAOMySQL dao = new BestellingDAOMySQL();
        ArrayList<Bestelling> list = dao.getBestellingByKlantId(view.getKlandID());
        view.print(list);
    }
    public static void readKoppel(){
        BestellingView view = new BestellingView();
        view.readBestellingID();
        BestellingArtikelDAOMySQL dao = new BestellingArtikelDAOMySQL();
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
        view.read();

        BestellingArtikel koppel = new BestellingArtikel();
        koppel.setBestelling_id(bestellingID);
        koppel.setArtikel_id(view.getArtikelID());
        koppel.setAantal(view.getAantal());
        
        BestellingArtikelDAOMySQL baDAO = new BestellingArtikelDAOMySQL();      
        baDAO.createKoppelBestellingArtikel(koppel);
    }
    
                    
}
