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

    
    public static void createArtikel(){
        ArtikelView aView = new ArtikelView();
        aView.create();
        Artikel artikel = new Artikel();
        artikel.setArtikel_naam(aView.getArtikel_naam());
        
        ArtikelDAOMySQL aDAOMySql= new ArtikelDAOMySQL();
        aDAOMySql.createNewArtikel(artikel);
    }
    
    public static void updateArtikel(){
        ArtikelView aView = new ArtikelView();
        Artikel artikel = new Artikel();                      

        artikel.setArtikel_id(aView.getArtikel_id());
        artikel.setArtikel_naam(aView.getArtikel_naam());
        artikel.setArtikel_voorraad(aView.getArtikel_voorraad());
        artikel.setArtikel_prijs(aView.getArtikel_prijs());
        
        ArtikelDAOMySQL aDAOMySql= new ArtikelDAOMySQL();
        aDAOMySql.updateArtikel(artikel);
    }
    
    public static void deleteArtikel(){
        ArtikelView aView = new ArtikelView();
        aView.delete();
        
        ArtikelDAOMySQL aDAOMySql= new ArtikelDAOMySQL();
        aDAOMySql.deleteArtikel(aView.getArtikel_id());
    }
    
    public static void readArtikelByID(){
        ArtikelView aView = new ArtikelView();
        aView.readArtikelById();
        
        ArtikelDAOMySQL aDAOMySql= new ArtikelDAOMySQL();
        aDAOMySql.readArtikel(aView.getArtikel_id()));
        
        ArrayList<Artikel> artikelLijst;
        
    }
    
    
}
