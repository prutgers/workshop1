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
import POJO.Artikel;

/**
 *
 * @author Peter
 */
public class ArtikelController {

    
    public static void create(){
        ArtikelView aView = new ArtikelView();
        aView.create();
        Artikel artikel = new Artikel();
        artikel.setArtikel_naam(aView.getArtikel_naam());
        
        ArtikelDAOMySQL dao = new ArtikelDAOMySQL();
        dao.createNewArtikel(artikel);
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
