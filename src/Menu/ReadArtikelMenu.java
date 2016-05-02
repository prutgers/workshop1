/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;


import formatMessage.VerifyInputScanner;
import POJO.Artikel;
import DAO.MySQL.ArtikelDAO;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Peter
 */
public class ReadArtikelMenu {
    public static void startMenu(){
     Scanner input = new Scanner(System.in);
        
        System.out.println("Kies 1 een overzicht van alle artikelen, \n"
                + "kies voor een artikel met een specifiek ID, \n"
                + "kies 3 om terug te keren naar het hoofdmenu, \n"
                + "kies 4 om het programma te sluiten, \n");
        int select = input.nextInt();
        
        switch (select) {
            case 1:
                readMenuArtikel();
                break;
            case 2:
                readMenuArtikelMetID();
                break;
            case 3:
                HoofdMenu.startMenu();
                break;            
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("kies 1, 2, 3 of 4");
                break;
        }
    }

      

    public static void readMenuArtikelMetID(){
        System.out.println("Wat is het artikel ID dat u zoekt, \n");
        int artikel_id = VerifyInputScanner.verifyInt();

        Artikel a = ArtikelDAO.readArtikel(artikel_id);
        System.out.format("%s, %s, %s, %s\n", "id", "artikel_naam", "artikel_prijs", "artikel_voorraad");
        System.out.format("%s, %s, %s, %s\n", a.getArtikel_id(), a.getArtikel_naam(), a.getArtikel_prijs(), a.getArtikel_voorraad());    
    }

    public static void readMenuArtikel(){
       System.out.format("%s, %s, %s, %s\n", "id", "artikel_naam", "artikel_prijs", "artikel_voorraad");
       ArrayList<Artikel> artikelLijst = ArtikelDAO.readArtikel();

       for(Artikel a : artikelLijst){
        System.out.format("%s, %s, %s, %s\n", a.getArtikel_id(), a.getArtikel_naam(), a.getArtikel_prijs(), a.getArtikel_voorraad());
       }
    }
}
