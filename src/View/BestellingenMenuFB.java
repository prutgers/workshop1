/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import formatMessage.VerifyInputScanner;
import POJO.Artikel;
import DAO.MySQL.BestellingArtikelDAO;
import POJO.Bestelling;
import DAO.MySQL.ArtikelDAO;
import POJO.BestellingArtikel;
import DAO.Firebird.BestellingDAOFirebird;
import formatMessage.PrintFormat;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import static DAO.MySQL.BestellingArtikelDAO.readKoppelMetBestellingID;


/**
 *
 * @author Peter
 */
public class BestellingenMenuFB {
    
    public static void startMenu() {
        Scanner input = new Scanner(System.in);
        while(true){
            PrintFormat.printHeader("BESTELLINGEN-MENU");        
            System.out.println(
                  "1) Maak nieuwe bestelling aan\n"
                + "2) Voeg een artikel toe aan een bestelling (met bestelling ID) \n"
                + "3) Verander aantal bestelde artikellen (met bestelling en artikel ID) \n"
                + " \n"
                + "4) Haal specifieke bestelling op (met bestelling ID) \n"
                + "5) Haal alle bestelling van 1 klant op (met klant ID) \n"
                + "6) Haal alle artikelen van 1 bestelling op (met bestelling ID) \n"
                + "7) Haal alle bestelling van alle klanten op \n"
                + " \n"
                + "8) Verwijder 1 artikel uit een bestelling (met bestelling en artikel ID) \n"
                + "9) Verwijder gehele bestelling (met bestelling ID) \n"
                + " \n"
                + "10) Ga naar hoofdmenu");
            int select = input.nextInt();

            switch (select) {
                case 1:
                    createBestellingMenu();
                    break;
                case 2:
                    createBestelArtikelMenu();
                    break;
                case 3:
                    updateBestellingAantalMenu();
                    break;
                case 4:
                    getByIdMenu();
                    break;
                case 5:
                    getByKlantIdMenu();
                    break;
                case 6:
                    getBestelArtikelMenu();
                    break;
                case 7:
                    getAllMenu();
                    break;
                case 8:
                    deleteArtikelUitBestellingMenu();
                    break;
                case 9:
                    deleteByIdMenu();
                    break;
                case 10:
                    HoofdMenu.startMenu();
                    break;
                default:
                    System.out.println("kies 1, 2, 3, 4, 5, 6, 7, 8, 9  of 10");
                    break;
            }
            System.out.println("druk op enter om door te gaan");
            // iets invoegen zodat het programma even stopt
        }
    }
    
    /**
     *  1) createMenu maakt een nieuwe bestelling aan en roept de methode XXXX aan die
     * een bestaand artikel toevoeged aan deze bestelling
     * 
     * samenvatting: Maak een nieuwe bestelling + voeg een artikel toe aan de bestelling
     */
    public static void createBestellingMenu(){
        Scanner input = new Scanner(System.in);
        //maak nieuwe bestelling aan
        Bestelling bestelling = new Bestelling();   
        //vul klant id in
        System.out.print("Enter klant ID: ");    
        bestelling.setKlantID(input.nextInt());
        //Verstuur de bestelling naar de database
        Bestelling newBestelling = BestellingDAOFirebird.createBestelling(bestelling);
        
        
        //voegt besteling en artikel samen
        //createBestelArtikelMenu(newBestelling.getBestellingID());
    }
    
    /**
     * 2) createBestelArtikelMenu voegt een artikel toe aan een bestaande bestelling
     */
    public static void createBestelArtikelMenu() {
        Scanner input = new Scanner(System.in);
        BestellingArtikel bestellingArtikel = new BestellingArtikel();
        System.out.print("Enter bestellingID: ");
        bestellingArtikel.setBestelling_id(input.nextInt());
        System.out.print("Enter artikelID: ");
        bestellingArtikel.setArtikel_id(input.nextInt());
        System.out.print("Enter aantal: ");
        bestellingArtikel.setAantal(input.nextInt());
        BestellingArtikelDAO.createKoppelBestellingArtikel(bestellingArtikel);
    }
    
     //3) update het aantal bestellen artikelen van een bestelling
    public static void updateBestellingAantalMenu(){
        System.out.println("Enter bestelling ID :");
        int bestellingId = VerifyInputScanner.verifyInt();
        System.out.println("Enter artikellen ID :");
        int artikelId = VerifyInputScanner.verifyInt();
        BestellingArtikel koppel = BestellingArtikelDAO.readKoppel(bestellingId, artikelId);
        
        System.out.println("aantal dat u wilt bestellen :");
        koppel.setAantal(VerifyInputScanner.verifyInt());
        
        BestellingArtikelDAO.updateKoppel(koppel);
        
        
    }
    
     //4) Geeft voor een gegeven bestelling ID een de hele bestelling terug (KlantID, Totaal Prijs, etc]
    public static void getByIdMenu(){
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter bestelling ID :");
        int BestellingId = input.nextInt();
        
        Bestelling bestelling = BestellingDAOFirebird.getBestellingById(BestellingId);
        System.out.println("bestelID: " + bestelling.getBestellingID() + " " + "KlantID: " + bestelling.getKlantID());
        
    }
    
    //5)Geeft een lijst van bestellingen terug van een klant, op basis van klantID
    public static void getByKlantIdMenu(){
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter klant ID :");
        int klantId = input.nextInt();
        ArrayList<Bestelling> list = BestellingDAOFirebird.getBestellingByKlantId(klantId);
        System.out.println("\n"
                + "LIJST MET BESTELLININGEN VAN KLANT " + klantId + "\n");
        for(Bestelling e : list){
            System.out.println("BestellingID: " + e.getBestellingID() + " KlantID: " + e.getKlantID());
        }
    }   
   
    //6) Geeft een lijst terug met bestelde artikelen van 1 bestelling op basis van bestelling ID
    public static void getBestelArtikelMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter bestellingID");
        ArrayList<BestellingArtikel> lijst = readKoppelMetBestellingID(input.nextInt());
        System.out.printf("%15s %15s %15s %15s %15s\n","KoppelID", "AtikelID", "Aantal", "artikel Naam", "Artikel Prijs");
        for(BestellingArtikel e : lijst){
             Artikel artikel = ArtikelDAO.readArtikel(e.getArtikel_id());
             System.out.printf("%15s %15d %15s %15s %15s\n",e.getKoppel_id(), e.getArtikel_id(), e.getAantal(), artikel.getArtikel_naam(), artikel.getArtikel_prijs());
             
        }
    } 
    
    //7) overzicht van alle bestellingen van alle bestelling van alle klanten
    public static void getAllMenu(){
        ArrayList<Bestelling> list = BestellingDAOFirebird.getAllBestelling();
        
        System.out.printf("%15s %15s\n", "BestellingID", "KlantID");
        for(Bestelling e : list){
            System.out.printf("%15d %15d\n",e.getBestellingID(), e.getKlantID());
        }
    }
    
    //8) verwijdert een artikel uit een bestelling
    public static void deleteArtikelUitBestellingMenu(){
        System.out.println("Enter bestelling ID :");
        int bestellingId = VerifyInputScanner.verifyInt();
        System.out.println("Enter atikel ID :");
        int artikelId = VerifyInputScanner.verifyInt();
        BestellingArtikelDAO.deleteKoppel(bestellingId,artikelId);
    }

    //9) verwijdert een bestelling op basis van bestellingID
    public static void deleteByIdMenu(){
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter bestelling ID :");
        int bestellingId = input.nextInt();
        
        //verwijdert alle artikelen die bij deze bestelling horen
        BestellingArtikelDAO.deleteKoppelMetBestellingID(bestellingId);
        
        //verwijdert de bestelling
        BestellingDAOFirebird.deleteBestelling(bestellingId);
    }
    
        
    /**
     * Alleen automatisch 
     * createBestelArtikelMenu koppelt artikelen en bestellingen aan elkaar
     * en 1 methode met argumenten voor automatische invoer
     */
    public static void createBestelArtikelMenu(int bestellingID){
        Scanner input = new Scanner(System.in);
        BestellingArtikel bestellingArtikel = new BestellingArtikel();
        bestellingArtikel.setBestelling_id(bestellingID);
        System.out.print("Enter artikelID: ");
        bestellingArtikel.setArtikel_id(input.nextInt());
        System.out.print("Enter aantal: ");
        bestellingArtikel.setAantal(input.nextInt());
        BestellingArtikelDAO.createKoppelBestellingArtikel(bestellingArtikel);
    }
}

    

