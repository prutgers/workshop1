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
import static workshop1.KoppelBestellingArtikelDAO.createKoppelBestellingArtikel;

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
                + "kies 5 om naar bestelling artikelen te gaan\n"
                + " \n"
                + "kies 6 om een bestelling te verwijderen, \n"
                + " \n"
                + "kies 7 om een artikel toe te voegen aan een bestelling, \n"
                + " \n"
                + "kies 9 om terug naar hoofdmenu te gaan");
            int select = input.nextInt();
            try{
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
                        deleteByIdMenu();
                        break;
                    case 7:
                        createBestelArtikelMenu();
                        break;
                    case 9:
                        HoofdMenu.startMenu();
                        break;
                    default:
                        System.out.println("kies 1, 2 of 3");
                        break;
                }
            }
            catch(SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
            

    }
    
    /**
     * createMenu maakt een nieuwe bestelling aan en roept de methode XXXX aan die
     * een bestaand artikel toevoeged aan deze bestelling
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    
    public static void createMenu()throws SQLException, ClassNotFoundException{
        Scanner input = new Scanner(System.in);
        System.out.print("\n"
                + "*CREATE MENU*\n");
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
    
    public static void getAllMenu(){
        BestellingDAO dao = new BestellingDAO();
        ArrayList<Bestelling> list = dao.getAllBestelling();
        System.out.println("\n"
                + "LIJST MET ALLE BESTELLININGEN \n "
                + "=============================");
        System.out.printf("%15s %15s\n", "BestellingID", "KlantID");
        for(Bestelling e : list){
            System.out.printf("%15d %15d\n",e.getBestellingID(), e.getKlantID());
        }
    }
    public static void getByIdMenu()throws SQLException, ClassNotFoundException{
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter bestelling ID :");
        int BestellingId = input.nextInt();

        BestellingDAO dao = new BestellingDAO();
        Bestelling bestelling = dao.getBestellingById(BestellingId);
        System.out.println("bestelID: " + bestelling.getBestellingID() + " " + "KlantID: " + bestelling.getKlantID());
        
    }
    public static void getByKlantIdMenu()throws SQLException, ClassNotFoundException{
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter klant ID :");
        int klantId = input.nextInt();

        BestellingDAO dao = new BestellingDAO();
        ArrayList<Bestelling> list = dao.getBestellingByKlantId(klantId);
        System.out.println("\n"
                + "LIJST MET BESTELLININGEN VAN KLANT " + klantId + "\n"
                + "================================");
        for(Bestelling e : list){
            System.out.println("BestellingID: " + e.getBestellingID() + " KlantID: " + e.getKlantID());
        }
    }   

    public static void deleteByIdMenu(){
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter bestelling ID :");
        int bestellingId = input.nextInt();

        BestellingDAO dao = new BestellingDAO();
        dao.deleteBestelling(bestellingId);
    }
    
    /**
     * createBeestelArtikelMenu koppeld artikelen en bestellingen aan elkaar
     * er is 1 methode zonder argumenten voor handmatige invoer
     * en 1 methode met argumenten voor automatische invoer
     */
    
    public static void createBestelArtikelMenu() {
        Scanner input = new Scanner(System.in);
        KoppelBestellingArtikel bestellingArtikel = new KoppelBestellingArtikel();
        System.out.println("Enter bestellingID");
        bestellingArtikel.setBestelling_id(input.nextInt());
        System.out.println("Enter artikelID");
        bestellingArtikel.setArtikel_id(input.nextInt());
        System.out.println("Enter aantal");
        bestellingArtikel.setAantal(input.nextInt());
        createKoppelBestellingArtikel(bestellingArtikel);
    }
    
    public static void createBestelArtikelMenu(int bestellingID){
        Scanner input = new Scanner(System.in);
        KoppelBestellingArtikel bestellingArtikel = new KoppelBestellingArtikel();
        bestellingArtikel.setBestelling_id(bestellingID);
        System.out.println("Enter artikelID");
        bestellingArtikel.setArtikel_id(input.nextInt());
        System.out.println("Enter aantal");
        bestellingArtikel.setAantal(input.nextInt());
        createKoppelBestellingArtikel(bestellingArtikel);
        
    }
    
    
}

    

