/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Peter
 */


import DAO.MySQL.BestellingArtikelDAOMySQL;
import View.ArtikelView;
import DAOFactory.DAOFactory;
import POJO.Artikel;
import Service.ArtikelService;
import View.ArtikelKeuzeView;
import interfaceDAO.ArtikelDAO;
import interfaceDAO.BestellingArtikelDAO;

/**
 *
 * @author Peter
 */
public class ArtikelController {
        
    public static void startKeuze(){
        ArtikelKeuzeView view = new ArtikelKeuzeView();   
        view.keuze();
        switch (view.getSelect()) {
            case 1:
                ArtikelController.create();
                break;
            case 2:
                ArtikelController.update();
                break;
            case 3:
                ArtikelController.readAll();
                break;            
            case 4:
                ArtikelController.readByID();
                break;
            case 5:
                ArtikelController.delete();
                break;
            case 0:
                MainController.hoofdMenu();
                break;
            default:
                view.herhaalKeuze();
                break;
        }
        if(view.getSelect() != 0){
            startKeuze();
        }
    }
    
    public static void create(){
        ArtikelView aView = new ArtikelView();
        aView.create();
        Artikel artikel = new Artikel();
        artikel.setArtikel_naam(aView.getArtikel_naam());
        artikel.setArtikel_prijs(aView.getArtikel_prijs());
        artikel.setArtikel_voorraad(aView.getArtikel_voorraad());
        
        ArtikelService AS = new ArtikelService();
        AS.create(artikel);
    }
    
    public static void update(){
        ArtikelView aView = new ArtikelView();
        aView.update();
        Artikel artikel = new Artikel();                      

        artikel.setArtikel_id(aView.getArtikel_id());
        artikel.setArtikel_naam(aView.getArtikel_naam());
        artikel.setArtikel_voorraad(aView.getArtikel_voorraad());
        artikel.setArtikel_prijs(aView.getArtikel_prijs());
         
        
        ArtikelService AS = new ArtikelService();
        AS.update(artikel);
        
    }
    
    public static void delete(){
        ArtikelView aView = new ArtikelView();
        aView.delete();
        
        ArtikelService AS = new ArtikelService();
        AS.delete(aView.getArtikel_id());
     }
    
    public static void readByID(){
        ArtikelView aView = new ArtikelView();
        aView.readArtikelById();
        
        ArtikelService AS = new ArtikelService();
        aView.print(AS.readByID(aView.getArtikel_id()));
    }
    
    public static void readAll(){
        //nodig om de print functie aan te roepen
        ArtikelView aView = new ArtikelView();
        
        ArtikelService AS = new ArtikelService();
        aView.print(AS.readAll());
    }
}
