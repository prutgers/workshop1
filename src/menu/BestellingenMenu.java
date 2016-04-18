/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import formatMessage.PrintFormat;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import workshop1.*;
import static workshop1.KoppelBestellingArtikelDAO.readKoppelMetBestellingID;


/**
 *
 * @author Peter
 */
public class BestellingenMenu {
    
    public static void startMenu() {
        Scanner input = new Scanner(System.in);
        while(true){
            PrintFormat.printHeader("BESTELLINGEN-MENU");        
            System.out.println(
                  "Kies 1 om een bestelling aan te maken \n"
                + " \n"
                + "kies 2 om een bestelling op te halen via bestellingID, \n"
                + "kies 3 om alle bestellingen op te halen van een klant, \n"
                + "kies 4 om alle bestellingen op te halen, \n"
                + " \n"
                + "kies 5 om naar bestelling artikelen menu te gaan\n"
                + "kies 6 om een artikel toe te voegen aan een bestelling, \n"
                + "kies x voor alle artikelen van een bestelling \n"
                + "kies x om een artikel aan te passen\n"
                + "kies x om een artikel te verwijderen"
                + " \n"
                + "kies 7 om een bestelling te verwijderen, \n"
                + "kies 8 om een voor overzicht van EEN bestelling, \n"
                + " \n"
                + "kies 9 om terug naar hoofdmenu te gaan");
            int select = input.nextInt();

            switch (select) {
                case 1:
                    createMenu();
                    break;
                case 2:
                    getByIdMenu();
                    break;
                case 3:
                    getByKlantIdMenu();
                    break;
                case 4:
                    getAllMenu();
                    break;
                case 5:
                    BestellingArtikelMenu.startMenu();
                    break;
                case 6:
                    createBestelArtikelMenu();
                    break;
                case 7:
                    deleteByIdMenu();
                    break;
                    case 8:
                    getBestelArtikelMenu();
                    break;
                case 9:
                    HoofdMenu.startMenu();
                    break;
                default:
                    System.out.println("kies 1, 2 of 3");
                    break;
            }
        }
    }
    
    /**
     * createMenu maakt een nieuwe bestelling aan en roept de methode XXXX aan die
     * een bestaand artikel toevoeged aan deze bestelling
     * @throws SQLException
     * @throws ClassNotFoundException 
     * 
     * samenvatting: Maak een nieuwe bestelling + voeg een artikel toe aan de bestelling
     */
    public static void createMenu(){
        Scanner input = new Scanner(System.in);
        //maak nieuwe bestelling aan
        Bestelling bestelling = new Bestelling();   
        //vul klant id in
        System.out.print("Enter klant ID: ");    
        bestelling.setKlantID(input.nextInt());
        //Verstuur de bestelling naar de database
        BestellingDAO.createBestelling(bestelling);
        
        //voegt besteling en artikel samen
        createBestelArtikelMenu(bestelling.getBestellingID());
    }
    
    //overzicht van alle bestellingen van alle bestelling van alle klanten
    public static void getAllMenu(){
        ArrayList<Bestelling> list = BestellingDAO.getAllBestelling();
        
        System.out.printf("%15s %15s\n", "BestellingID", "KlantID");
        for(Bestelling e : list){
            System.out.printf("%15d %15d\n",e.getBestellingID(), e.getKlantID());
        }
    }
    
    //Geeft voor een gegeven bestelling ID een de hele bestelling terug (KlantID, Totaal Prijs, etc]
    public static void getByIdMenu(){
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter bestelling ID :");
        int BestellingId = input.nextInt();
        
        Bestelling bestelling = BestellingDAO.getBestellingById(BestellingId);
        System.out.println("bestelID: " + bestelling.getBestellingID() + " " + "KlantID: " + bestelling.getKlantID());
        
    }
    
    //Geeft een lijst van bestellingen terug van een klant, op basis van klantID
    public static void getByKlantIdMenu(){
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter klant ID :");
        int klantId = input.nextInt();
        ArrayList<Bestelling> list = BestellingDAO.getBestellingByKlantId(klantId);
        System.out.println("\n"
                + "LIJST MET BESTELLININGEN VAN KLANT " + klantId + "\n");
        for(Bestelling e : list){
            System.out.println("BestellingID: " + e.getBestellingID() + " KlantID: " + e.getKlantID());
        }
    }   

    //verwijdert een bestelling op basis van bestellingID
    public static void deleteByIdMenu(){
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter bestelling ID :");
        int bestellingId = input.nextInt();
        
        //verwijdert alle artikelen die bij deze bestelling horen
        KoppelBestellingArtikelDAO.deleteKoppelMetBestellingID(bestellingId);
        
        //verwijdert de bestelling
        BestellingDAO.deleteBestelling(bestellingId);
    }
    
    //Geeft een lijst weer van artikelen in een specifieke bestelling op basis van bestelling ID
    
    
    
    
    /**
     * createBestelArtikelMenu voegt een artikel toe aan een bestaande bestelling
     */
    public static void createBestelArtikelMenu() {
        Scanner input = new Scanner(System.in);
        KoppelBestellingArtikel bestellingArtikel = new KoppelBestellingArtikel();
        System.out.print("Enter bestellingID: ");
        bestellingArtikel.setBestelling_id(input.nextInt());
        System.out.print("Enter artikelID: ");
        bestellingArtikel.setArtikel_id(input.nextInt());
        System.out.print("Enter aantal: ");
        bestellingArtikel.setAantal(input.nextInt());
        KoppelBestellingArtikelDAO.createKoppelBestellingArtikel(bestellingArtikel);
    }
    
    /**
     * createBestelArtikelMenu koppelt artikelen en bestellingen aan elkaar
     * en 1 methode met argumenten voor automatische invoer
     */
    public static void createBestelArtikelMenu(int bestellingID){
        Scanner input = new Scanner(System.in);
        KoppelBestellingArtikel bestellingArtikel = new KoppelBestellingArtikel();
        bestellingArtikel.setBestelling_id(bestellingID);
        System.out.print("Enter artikelID: ");
        bestellingArtikel.setArtikel_id(input.nextInt());
        System.out.print("Enter aantal: ");
        bestellingArtikel.setAantal(input.nextInt());
        KoppelBestellingArtikelDAO.createKoppelBestellingArtikel(bestellingArtikel);
        
    }
    
    //Geeft een lijst terug met artikelID op basis van bestelling ID
    public static void getBestelArtikelMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter bestellingID");
        ArrayList<KoppelBestellingArtikel> lijst = readKoppelMetBestellingID(input.nextInt());
        System.out.printf("%15s %15s %15s %15s %15s\n","KoppelID", "AtikelID", "Aantal", "artikel Naam", "Artikel Prijs");
        for(KoppelBestellingArtikel e : lijst){
             Artikel artikel = ArtikelDAO.readArtikel(e.getArtikel_id());
             System.out.printf("%15s %15d %15s %15s %15s\n",e.getKoppel_id(), e.getArtikel_id(), e.getAantal(), artikel.getArtikel_naam(), artikel.getArtikel_prijs());
             
        }
    } 
}

    

