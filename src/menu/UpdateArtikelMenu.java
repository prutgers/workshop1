/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import formatMessage.VerifyInputScanner;
import POJO.Artikel;
import DAO.MySQL.ArtikelDAO;
import java.math.BigDecimal;
import java.util.Scanner;

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
                updateArtikelMenu();
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
     
     
     public static void updateArtikelMenu(){
        System.out.println("Wat is het artikel ID dat u wilt updaten");
        int artikel_id = VerifyInputScanner.verifyInt();
        
        System.out.println("Artikel Naam");
        String artikel_naam = VerifyInputScanner.verifyEmail();
        
        System.out.println("artikelen op voorraad");
        int artikel_voorraad = VerifyInputScanner.verifyInt();
        
        System.out.println("artikel rpijs");
        BigDecimal artikel_prijs = VerifyInputScanner.verifyBigDecimal();
        
        Artikel artikel = new Artikel();                      

        artikel.setArtikel_id(artikel_id);
        artikel.setArtikel_naam(artikel_naam);
        artikel.setArtikel_voorraad(artikel_voorraad);
        artikel.setArtikel_prijs(artikel_prijs);
        
        ArtikelDAO.updateArtikel(artikel);
    }
     
     public static void updateArtikelPrijs(){
        System.out.println("Wat is het artikel ID dat u wilt updaten");
        int artikel_id = VerifyInputScanner.verifyInt();
        
        Artikel artikel = ArtikelDAO.readArtikel(artikel_id);
        
        System.out.println("artikel prijs");
         BigDecimal artikel_prijs = VerifyInputScanner.verifyBigDecimal();
        artikel.setArtikel_prijs(artikel_prijs);
        
        ArtikelDAO.updateArtikel(artikel);
    }
}
