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
import DAO.MySQL.ArtikelDAO;
import POJO.Artikel;


/**
 *
 * @author Peter
 */
public class ArtikelController {
    
    
    ArtikelView menu = new ArtikelView();
   
    public void createArtikelMenu(){
        menu.create();
        Artikel artikel = new Artikel();
        artikel.setArtikel_naam(menu.getArtikel_naam());
        ArtikelDAO.createNewArtikel(artikel);

    }
    
}
