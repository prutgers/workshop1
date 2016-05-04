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


import View.ArtikelView;
import DAO.MySQL.ArtikelDAOMySQL;
import DAOFactory.DAOFactory;
import POJO.Artikel;
import View.ArtikelKeuzeView;
import interfaceDAO.ArtikelDAO;

/**
 *
 * @author Peter
 */
public class ArtikelController {
       public static void startKeuze(){
       ArtikelKeuzeView view = new ArtikelKeuzeView();   
       view.keuze();
       int select = view.getSelect();
                   switch (select) {
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
                    break;
                default:
                    view.herhaalKeuze();
                    break;
            }
       }
    public static void create(){
        ArtikelView aView = new ArtikelView();
        aView.create();
        Artikel artikel = new Artikel();
        artikel.setArtikel_naam(aView.getArtikel_naam());
        artikel.setArtikel_prijs(aView.getArtikel_prijs());
        artikel.setArtikel_voorraad(aView.getArtikel_voorraad());
        ArtikelDAO dao = DAOFactory.getArtikelDAO();
        dao.createArtikel(artikel);
    }
    
    public static void update(){
        ArtikelView aView = new ArtikelView();
        Artikel artikel = new Artikel();                      

        artikel.setArtikel_id(aView.getArtikel_id());
        artikel.setArtikel_naam(aView.getArtikel_naam());
        artikel.setArtikel_voorraad(aView.getArtikel_voorraad());
        artikel.setArtikel_prijs(aView.getArtikel_prijs());
        
        ArtikelDAOMySQL dao= new ArtikelDAOMySQL();
        dao.updateArtikel(artikel);
    }
    
    public static void delete(){
        ArtikelView aView = new ArtikelView();
        aView.delete();
        
        ArtikelDAOMySQL dao = new ArtikelDAOMySQL();
        dao.deleteArtikel(aView.getArtikel_id());
    }
    
    public static void readByID(){
        ArtikelView aView = new ArtikelView();
        aView.readArtikelById();
        
        ArtikelDAOMySQL dao = new ArtikelDAOMySQL();
        aView.print(dao.readArtikel(aView.getArtikel_id()));
    }
    
    public static void readAll(){
        ArtikelView aView = new ArtikelView();
        ArtikelDAOMySQL dao= new ArtikelDAOMySQL();
        aView.print(dao.readArtikel(aView.getArtikel_id()));
    }
}
