/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.util.Scanner;
import workshop1.*;

/**
 *
 * @author Peter
 */
public class UpdateArtikelMenu {
     public static void startMenu(){
         Scanner input = new Scanner(System.in);
        ;
        System.out.println("Kies 1 voor updaten van een artikel, \n"
                + "kies 2 voor alleen artikel prijs updaten, \n"
                + "kies 3 om terug te keren naar het hoofdmenu, \n"
                + "kies 4 om af te sluiten, \n");
        int select = input.nextInt();
        
        switch (select) {
            case 1:
                updateArtikel();
                break;
            case 2:
                updateArtikelPrijs();
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
     
     
     public static void updateArtikel(){
        System.out.println("Wat is het artikel ID dat u wilt updaten");
        Scanner input = new Scanner(System.in);        
        int artikel_id = input.nextInt();       
        
        System.out.println("Artikel Naam");
        String artikel_naam = input.next();
        
        System.out.println("artikelen op voorraad");
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
     
     public static void updateArtikelPrijs(){
        System.out.println("Wat is het artikel ID dat u wilt updaten");
        Scanner input = new Scanner(System.in);        
        int artikel_id = input.nextInt();       
        
        Artikel artikel = ArtikelDAO.readArtikel(artikel_id);
        
        System.out.println("artikel naam: in updateMENU" + artikel.getArtikel_naam());
        System.out.println("artikel prijs" + artikel.getArtikel_prijs());
        
        
        System.out.println("artikel rpijs");
        double artikel_prijs = input.nextDouble();
        
        artikel.setArtikel_prijs(artikel_prijs);
        
        ArtikelDAO.updateArtikel(artikel);
        
        
    }
}
