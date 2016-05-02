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

   ArtikelView menu = new ArtikelView();
   
   public void artikelStart(){
       menu.startMenu();
       int select = menu.getSelect();
       
                   switch (select) {
                case 1:
                    createArtikelView();
                    break;
                case 2:
                    //updateArtikelMenu();
                    break;
                case 3:
                    //readAllArtikelenMenu();
                    break;            
                case 4:
                    //readArtikelByIdMenu();
                    break;
                case 5:
                   //deleteArtikelMenu();
                    break;
                case 0:
                    //HoofdMenu.startMenu();
                    break;
                default:
                    System.out.println("Maak een keuze: 1, 2, 3, 4, 5 of 0");
                    break;
            }
   }
    public void createArtikelView(){
        menu.create();
        Artikel artikel = new Artikel();
        artikel.setArtikel_naam(menu.getArtikel_naam());
        ArtikelDAOMySQL.createNewArtikel(artikel);

    }
    
}
