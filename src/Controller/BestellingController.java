/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MySQL.BestellingArtikelDAOMySQL;
import DAO.MySQL.BestellingDAOMySQL;
import static Menu.BestellingenMenu.createBestellingMetArtikelMenu;
import POJO.Bestelling;
import View.BestellingView;
import java.util.ArrayList;
import static Menu.BestellingenMenu.createBestellingMetArtikelMenu;
import POJO.BestellingArtikel;
import View.BestellingArtikelView;

/**
 *
 * @author Gebruiker
 */
public class BestellingController {
    public static void create(){
        BestellingView view = new BestellingView();
        view.readBestellingByKlantID();
        
        Bestelling bestelling = new Bestelling();
        bestelling.setKlantID(view.getKlandID());
        
        BestellingDAOMySQL dao = new BestellingDAOMySQL();
        Bestelling newBestelling =dao.createBestelling(bestelling);
        
        readKoppel(newBestelling.getBestellingID());
        
    }
    public static void update(){
        BestellingArtikelView view = new BestellingArtikelView();
        view.readAll();
        
        BestellingArtikelDAOMySQL dao = new BestellingArtikelDAOMySQL();    
        BestellingArtikel koppel = dao.readKoppel(view.getBestellingID(), view.getArtikelID());
        koppel.setAantal(view.getAantal());
       
        dao.updateKoppel(koppel);
    }
    public static void deleteBestelling(){
        BestellingView view = new BestellingView();
        view.readBestellingByID();
        
        BestellingArtikelDAOMySQL baDao = new BestellingArtikelDAOMySQL();
        baDao.deleteKoppelMetBestellingID(view.getBestellingID());
        
        BestellingDAOMySQL dao = new BestellingDAOMySQL(); 
        dao.deleteBestelling(view.getBestellingID());

    }
    public static void deleteArtikel(){
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
        view.readBestellingByID();
        BestellingDAOMySQL dao = new BestellingDAOMySQL();
        Bestelling bestelling = dao.getBestellingById(view.getBestellingID());
        view.print(bestelling);
    }
    public static void readByKlantID(){
        BestellingView view = new BestellingView();
        view.readBestellingByKlantID();
        BestellingDAOMySQL dao = new BestellingDAOMySQL();
        ArrayList<Bestelling> list = dao.getBestellingByKlantId(view.getKlandID());
        view.print(list);
    }
    public static void readKoppel(int bestellingID){
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
