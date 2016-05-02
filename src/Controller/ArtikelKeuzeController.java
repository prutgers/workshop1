/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.ArtikelKeuzeView;

/**
 *
 * @author Gebruiker
 */
public class ArtikelKeuzeController {
       public void artikelStart(){
       ArtikelKeuzeView view = new ArtikelKeuzeView();   
       int select = view.getSelect();
                   switch (select) {
                case 1:
                    ArtikelController.createArtikelView();
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
                    view.herhaalKeuze();
                    break;
            }
       }
}
