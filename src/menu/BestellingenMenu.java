/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

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
                    
            System.out.println(""
                + "Kies 1 voor createBestelling; \n"
                + "kies 2 voor getBestellingById, \n"
                + "kies 3 voor getBestellingByKlandId, \n"
                + "kies 4 voor getAllBestelling, \n"
                + "kies 5 voor updateBestelling, \n"
                + "kies 6 voor deleteByBestellingId, \n"
                + "kies 7 ga naar hoofdmenu");
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
                        updateBestellingMenu();
                        break;
                    case 6:
                        deleteByIdMenu();
                        break;
                    case 7:
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
        System.out.print("*CREATE MENU*");

        //maak nieuwe bestelling aan
        Bestelling bestelling = new Bestelling();   
        
        //vul klant id in
        System.out.print("Enter klant ID: ");    
        bestelling.setKlantID(input.nextInt());
        //Verstuur de bestelling naar de database
        BestellingDAO.createBestelling(bestelling);

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
    }
    public static void getAllMenu(){
        BestellingDAO dao = new BestellingDAO();
        ArrayList<Bestelling> list = dao.getAllBestelling();
        System.out.println(""
                + "LIJST MET ALLE BESTELLININGEN \n "
                + "=============================");
        System.out.printf("%15s %15s\n", "BestellingID", "KlantID");
        for(Bestelling e : list){
            /*
            System.out.println("BestellingID: " + e.getBestellingID() + 
                    " KlantID: " + e.getKlantID() + 
                    " ArtikelNaam: " + e.getArtikelNaam_1() + 
                    " ArikelID: " + e.getArtikelID_1() + 
                    " Artikel pijs: " + e.getArtikelPrijs_1());
*/
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
        System.out.println("bestelID: " + bestelling.getBestellingID() + " " + "KlantID" + bestelling.getKlantID());
        KoppelBestellingArtikelDAO.readKoppelMetBestellingID(bestelling.getBestellingID());
        
    }
    public static void getByKlantIdMenu()throws SQLException, ClassNotFoundException{
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter klant ID :");
        int klantId = input.nextInt();

        BestellingDAO dao = new BestellingDAO();
        ArrayList<Bestelling> list = dao.getBestellingByKlantId(klantId);
        System.out.println(""
                + "LIJST MET BESTELLINING VAN KLANT " + klantId + "\n"
                + "=================");
        for(Bestelling e : list){
            System.out.println("BestellingID: " + e.getBestellingID() + " KlantID: " + e.getKlantID());
        }
    }   
    public static void updateBestellingMenu(){
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter bestelling ID :");
        int bestellingId = input.nextInt();
        
        Bestelling bestelling = BestellingDAO.getBestellingById(bestellingId);  
        
        System.out.println(bestelling.getKlantID() + ") Enter nieuw klant ID:");
        int klantID = input.nextInt();
        System.out.println(bestelling.getArtikelID_1() + ") Enter nieuw artikel ID :");
        int artikelID = input.nextInt();
        System.out.println(bestelling.getArtikelNaam_1() + ") Enter nieuw artikel naam :");
        String artikelNaam = input.next();
        System.out.println(bestelling.getArtikelPrijs_1() + ") Enter nieuw artikel prijs:");
        double artikelPrijs = input.nextDouble();
        System.out.println(bestelling.getArtikelPrijs_1() + ") Enter nieuw artikel aantal:");
        int artikelAantal = input.nextInt();
        
        //vul de nieuwe bestelling
        bestelling.setKlantID(klantID);
        bestelling.setArtikelID_1(artikelID);
        bestelling.setArtikelNaam_1(artikelNaam);
        bestelling.setArtikelPrijs_1(artikelPrijs);
        bestelling.setArtikelAantal_1(artikelAantal);
        
        BestellingDAO.updateBestelling(bestelling);
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

    

