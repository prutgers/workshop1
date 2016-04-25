/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.util.Scanner;
import static menu.ArtikelMenu.createArtikel;
import static menu.ArtikelMenu.deleteArtikel;
import workshop1.Artikel;
import workshop1.ArtikelDAO;

/**
 *
 * @author Peter
 */
public class TestVerify {
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
                    createArtikel();
                    break;
                case 2:
                    UpdateArtikelMenu.startMenu();
                    break;
                case 3:
                    deleteArtikel();
                    break;            
                case 4:
                   ReadArtikelMenu.startMenu();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("kies 1, 2, 3, 4 of 5");
                    break;
            }
        
    }
    
    
    
    public static void createArtikel(){
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("Artikel Naam");
        String artikel_naam = VerifyInputScanner.verifyString();
        
        System.out.println("artikelen op voorraad");
        while(!verified)
            String verify
        if(VerifyInputScanner.verifyInt(input.next())){
            String artikel_voorraad = input.next();
        }
        
            
        
        
        
        System.out.println("artikel prijs");
        double artikel_prijs = VerifyInputScanner.verifyDouble();
        
        
        
    }
    
}
