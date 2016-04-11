package workshop1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Workshop {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Scanner input = new Scanner(System.in);
        
        System.out.println("Kies 1 voor createBestelling; \n"
                + "kies 2 voor getBestellingById, \n"
                + "kies 3 voor getBestellingByKlandId, \n"
                + "kies 4 voor getAllBestelling, \n"
                + "kies 5 voor deleteByBestellingId");
        int select = input.nextInt();
        
        if(select == 1){
            createMenu();
        }
        else if (select == 2){
            getByIdMenu();
        }
        else if ( select == 3){
            getByKlantIdMenu();
        }
        else if ( select == 4){
            getAllMenu();
        }
        else if( select ==5){
            deleteByIdMenu();
        }
        else System.out.println("kies 1, 2 of 3");
        /*
        KlantDAO dao = new KlantDAO();
        Klant klant = new Klant();
        klant.setAchternaam("joost");
        klant.setVoornaam("Jos");
        */

        //dao.createKlant(klant);
        //Klant klant2 = new Klant();
        //klant2 = dao.getKlantById(1);
        //System.out.println(klant2.getAchternaam().toString() + " " + klant2.getVoornaam().toString());
        
    }
    public static void createMenu()throws SQLException, ClassNotFoundException{
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter klant ID :");
        int klantID = input.nextInt();
        System.out.println("Enter artikel ID :");
        int artikelID = input.nextInt();
        System.out.println("Enter artikel naam :");
        String artikelNaam = input.next();
        System.out.println("Enter artikel prijs:");
        double artikelPrijs = input.nextDouble();
        System.out.println("Enter artikel aantal:");
        int artikelAantal = input.nextInt();
 
        //maak nieuwe bestelling aan
        Bestelling bestelling = new Bestelling();       
        //vul de nieuwe bestelling
        bestelling.setKlantID(klantID);
        bestelling.setArtikelID_1(artikelID);
        bestelling.setArtikelNaam_1(artikelNaam);
        bestelling.setArtikelPrijs_1(artikelPrijs);
        bestelling.setArtikelAantal_1(artikelAantal);
        
        //Verstuur de bestelling naar de database
        BestellingDAO dao = new BestellingDAO();
        dao.createBestelling(bestelling);
    }
    public static void getAllMenu(){
        BestellingDAO dao = new BestellingDAO();
        ArrayList<Bestelling> list = dao.getAllBestelling();
        System.out.println("LIJST MET ALLE BESTELLININGEN \n"
                + "====");
        for(Bestelling e : list){
            System.out.println("BestellingID: " + e.getBestellingID() + " KlantID: " + e.getKlantID() + " ArtikelNaam: " + e.getArtikelNaam_1());
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
        
    }
    public static void getByKlantIdMenu()throws SQLException, ClassNotFoundException{
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter klant ID :");
        int klantId = input.nextInt();

        BestellingDAO dao = new BestellingDAO();
        ArrayList<Bestelling> list = dao.getBestellingByKlantId(klantId);
        System.out.println("LIJST MET BESTELLINING VAN KLANT " + klantId + "\n"
                + "====");
        for(Bestelling e : list){
            System.out.println("BestellingID: " + e.getBestellingID() + " KlantID: " + e.getKlantID() + " ArtikelNaam: " + e.getArtikelNaam_1());
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

    

