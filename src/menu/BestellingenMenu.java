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
                + "kies 2 om een bestelling op te halen via bestellingID, \n"
                + "kies 3 om alle bestellingen op te halen van een klant, \n"
                + "kies 4 om alle bestellingen op te halen, \n"
                + "kies 5 om naar bestelling artikelen te gaan\n"
                + "kies 6 om een bestelling te verwijderen, \n"
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
        
        
        
        

           /*     
        boolean doorgaan = true;
        while(doorgaan){        
            //maakt een nieuwe bestelregel aan met het id van de bestelling
            KoppelBestellingArtikel bestellingRegel = new KoppelBestellingArtikel();
            bestellingRegel.setBestelling_id(bestelling.getBestellingID()); 
            
            //Vul gegevens bestelregel in
            System.out.print("Enter artikel ID: ");
            bestellingRegel.setArtikel_id(input.nextInt());
            System.out.print("Enter artikel aantal: ");
            bestellingRegel.setAantal(input.nextInt());
            
            //voeg bestelregel toe aan de database
            KoppelBestellingArtikelDAO.createKoppelBestellingArtikel(bestellingRegel);
            
            System.out.print( "nog een artikel? kies 1 ");
            if(input.nextInt()==1) 
                doorgaan=true;
            else doorgaan = false;
        }
        */
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
}

    

