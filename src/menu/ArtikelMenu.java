package menu;

import formatMessage.PrintFormat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import workshop1.*;


/**
 *
 * @author Peter
 */
public class ArtikelMenu {
    
    public static void startMenu(){
        Scanner input = new Scanner(System.in);        
        PrintFormat.printHeader("ARTIKELMENU"); 
            System.out.println("1: Maak een nieuw artikel aan \n"
                    + "\n"
                + "2: Pas een artikel aan (met artikel ID) \n"
                    + "\n"
                + "3: Haal een lijst met alle beschikbare artikelen op \n"
                + "4: Haal een specifiek artikel op (met artikel ID) \n"
                    + "\n"
                + "5: Verwijder een bestaand artikel (met artikel ID) \n"
                    + "\n"
                + "0: Keer terug naar het Hoofdmenu \n");
            int select = input.nextInt();

            switch (select) {
                case 1:
                    createNieuwArtikelMenu();
                    startMenu();
                    break;
                case 2:
                    updateArtikelMenu();
                    break;
                case 3:
                    readAllArtikelenMenu();
                    break;            
                case 4:
                    readArtikelByIdMenu();
                    break;
                case 5:
                   deleteArtikelMenu();
                    break;
                case 0:
                    HoofdMenu.startMenu();
                    break;
                default:
                    System.out.println("Maak een keuze: 1, 2, 3, 4, 5 of 0");
                    break;
            }
        
    }
    
    /*
    1. createNieuwArtikelMenu maakt een nieuw artikel aan
    */
    public static void createNieuwArtikelMenu(){
        System.out.println("Voer de artikelnaam in: ");
        String artikel_naam = VerifyInputScanner.verifyString();
        
        System.out.println("Voer het aantal dat van dit artikel op voorraad is in: ");
        int artikel_voorraad = input.nextInt();
        
        System.out.println("Voer de artikelprijs in: ");
        BigDecimal artikel_prijs = input.next();
        
        Artikel artikel = new Artikel();                      

        artikel.setArtikel_naam(artikel_naam);
        artikel.setArtikel_voorraad(artikel_voorraad);
        artikel.setArtikel_prijs(artikel_prijs);
        
        ArtikelDAO.createNewArtikel(artikel);
    }
    
    /*
    2. updateArtikelMenu kan een artikel aanpassen
    */
    private static void updateArtikelMenu() {
        System.out.println("Voer het artikel ID van het artikel"
                + "dat u wilt updaten: ");
        int artikel_id = VerifyInputScanner.verifyInt();
        
        System.out.println("Artikelnaam: ");
        String artikel_naam = VerifyInputScanner.verifyString();
        
        System.out.println("Aantal van dit artikel dat op voorraad is: ");
        int artikel_voorraad = VerifyInputScanner.verifyInt();
        
        System.out.println("Artikelprijs: ");
        BigDecimal artikel_prijs = input.next();
        
        Artikel artikel = new Artikel();                      

        artikel.setArtikel_id(artikel_id);
        artikel.setArtikel_naam(artikel_naam);
        artikel.setArtikel_voorraad(artikel_voorraad);
        artikel.setArtikel_prijs(artikel_prijs);
        
        ArtikelDAO.updateArtikel(artikel);
    }
    
    /*
    3. readAllArtikelenMenu geeft een ArrayList van alle beschikbare artikelen
    */
    private static void readAllArtikelenMenu() {
        System.out.format("%s, %s, %s, %s\n", 
                "Artikel ID", "Artikelnaam", "Artikelprijs", "Artikelvoorraad");
       ArrayList<Artikel> artikelLijst = ArtikelDAO.readArtikel();

       for(Artikel a : artikelLijst){
        System.out.format("%s, %s, %s, %s\n", a.getArtikel_id(), a.getArtikel_naam(), 
                a.getArtikel_prijs(), a.getArtikel_voorraad()); 
        }
    }
    
    /*
    4. readArtikelByIdMenu geeft de gegevens van een specifiek artikel terug
       op basis van het artikel ID
    */
    private static void readArtikelByIdMenu() {
        System.out.println("Voer het artikel ID in: ");
        int artikel_id = VerifyInputScanner.verifyInt();

        Artikel a = ArtikelDAO.readArtikel(artikel_id);
        System.out.format("%s, %s, %s, %s\n", 
                "Artikel ID", "Artikelnaam", "Artikelprijs", "Artikelvoorraad");
        System.out.format("%s, %s, %s, %s\n", a.getArtikel_id(), a.getArtikel_naam(), 
                a.getArtikel_prijs(), a.getArtikel_voorraad()); 
    }
    
    /*
    5. deleteArtikelMenu verwijdert een specifiek artikel op basis van artikel ID
    */
    public static void deleteArtikelMenu(){
        Scanner input = new Scanner(System.in); //wordt deze niet redundant door de VerifyInputScanner?       
        
        System.out.println("Voer het artikel ID van het "
                + "te verwijderen artikel in: ");
        int artikel_id = VerifyInputScanner.verifyInt();
        
        ArtikelDAO.deleteArtikel(artikel_id);
    }
}
