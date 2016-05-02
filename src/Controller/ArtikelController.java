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
import static Menu.ArtikelMenu.createNieuwArtikelMenu;
import static Menu.ArtikelMenu.deleteArtikelMenu;
import Menu.HoofdMenu;
import POJO.Artikel;

/**
 *
 * @author Peter
 */
public class ArtikelController {

    
    public static void createArtikelView(){
        ArtikelView menu = new ArtikelView();
        menu.create();
        Artikel artikel = new Artikel();
        artikel.setArtikel_naam(menu.getArtikel_naam());
        ArtikelDAOMySQL.createNewArtikel(artikel);

    }
    
}
