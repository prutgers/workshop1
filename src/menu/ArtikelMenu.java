/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import menu.KlantMenu;
import java.util.Scanner;
import workshop1.*;


/**
 *
 * @author Peter
 */
public class ArtikelMenu {
    
    //Herman ik push alleed dit
    
    public static void startMenu(){
    
        System.out.println("Kies 1 om een artikel toe te voegen; \n"
                + "kies 2 om een artikel up te daten \n"
                + "kies 3 om een artikel te verwijderen \n"
                + "kies 4 om de lijst van artikelen te bekijken \n"
                + "kies 5 quit, \n");
        Scanner input = new Scanner(System.in);
        int select = input.nextInt();
        
        switch (select) {
            case 1:
                KlantMenu.startMenu();
                break;
            case 2:
                updateArtikel();
                break;
            case 3:
                //ArtikelMenu.startMenu();
                break;            
            case 4:
                ArtikelDAO.readArtikel();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("kies 1, 2, 3, 4 of 5");
                break;
        }
    }
    
    
    public static void updateArtikel(){
        System.out.println("Wat is het artikel ID dat u wilt updaten");
        Scanner input = new Scanner(System.in);        
        int artikel_id = input.nextInt();       
        
        System.out.println("Artikel Naam");
        String artikel_naam = input.next();
        
        System.out.println("artieklen op voorraad");
        int artikel_voorraad = input.nextInt();
        
        System.out.println("artikel rpijs");
        double artikel_prijs = input.nextDouble();
        
        Artikel artikel = new Artikel();                      

        artikel.setArtikel_id(artikel_id);
        artikel.setArtikel_naam(artikel_naam);
        artikel.setArtikel_voorraad(artikel_voorraad);
        artikel.setArtikel_prijs(artikel_prijs);
        
        ArtikelDAO.updateArtikel(artikel);
        
        
    }
}
