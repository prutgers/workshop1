package menu;
/**
 *
 * @author Sonja
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import workshop1.*;

public class AdresMenu {
    public static void startMenu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            
            System.out.println("Om een adres aan te maken, kies 1\n"
            + "Om alle adresgegevens op te vragen, kies 2\n"
            + "Om adresgegevens met behulp van het adres ID op te vragen, kies 3\n"
            + "Om een adres aan te passen, kies 4\n"
            + "Om een adres te verwijderen, kies 5\n"
            + "Om te stoppen, kies 6");
            
            int select = input.nextInt();
            try {
                switch (select) {
                    case 1:
                        createAdresMenu();
                        break;
                    case 2:
                        readAdresMenu();
                        break;
                    case 3:
                        readAdresByIDMenu();
                        break;
                    case 4:
                        updateAdresMenu();
                        break;
                    case 5:
                        deleteAdresMenu();
                        break;
                    case 6:
                        HoofdMenu.startMenu();
                        break;
                    default:
                        System.out.println("Maak een keuze.");
                }
            }
            catch(SQLException | ClassNotFoundException ex){
                System.out.println(ex);
            }
        }
    }

    private static void createAdresMenu() throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Voer het adres ID in:");
        int adres_id = input.nextInt();
        System.out.println("Voer de straatnaam in:");
        String straatnaam = input.next();
        System.out.println("Voer het huisnummer in:");
        int huisnummer = input.nextInt();
        System.out.println("Voer de toevoeging in:");
        String toevoeging = input.next();
        System.out.println("Voer de postcode in:");
        String postcode = input.next();
        System.out.println("Voer de woonplaats in:");
        String woonplaats = input.next();
        
        Adres adres = new Adres(); //nieuw adres
        
        adres.setAdres_id(adres_id);  //fill'er up
        adres.setStraatnaam(straatnaam);
        adres.setHuisnummer(huisnummer);
        adres.setToevoeging(toevoeging);
        adres.setPostcode(postcode);
        adres.setWoonplaats(woonplaats);
        
        AdresDAO aDAO = new AdresDAO(); 
        aDAO.createAdres(adres);
    }

    private static void readAdresMenu() throws SQLException {
        
        AdresDAO aDAO = new AdresDAO();
        ArrayList<Adres> adresgegevens = aDAO.readAdres();
        System.out.println("ADRESGEGEVENS \n"
            + "----------------");
        System.out.printf("%15s %15s %15s %15s %15s %15s", 
                "Adres ID", "Straatnaam", "Huisnummer", "Toevoeging",
                "Postcode", "Woonplaats");
        for (Adres a : adresgegevens) {
        /*    System.out.println("Adres ID: " + a.getAdres_id()
            + "Straatnaam: " + a.getStraatnaam()
            + "Huisnummer: " + a.getHuisnummer()
            + "Toevoeging: " + a.getToevoeging()
            + "Postcode: " + a.getPostcode()
            + "Woonplaats: " + a.getWoonplaats());
        */
            System.out.printf("%15d %15s %15d %15s %15s %15s\n",
                    a.getAdres_id(), a.getStraatnaam(), a.getHuisnummer(), 
                    a.getToevoeging(), a.getPostcode(), a.getWoonplaats());
        }
    }
    
    private static void readAdresByIDMenu() throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Voer het adres ID in: ");
        int adresID = input.nextInt();
        
        AdresDAO aDAO = new AdresDAO();
        Adres adresGegevens = aDAO.readAdresByID(adresID);
            System.out.println("Adres ID: " + adresGegevens.getAdres_id() + "\n"
            + "Straatnaam: " + adresGegevens.getStraatnaam() + "\n"
            + "Huisnummer: " + adresGegevens.getHuisnummer() + "\n"
            + "Toevoeging: " + adresGegevens.getToevoeging() + "\n"
            + "Postcode: " + adresGegevens.getPostcode() + "\n"
            + "Woonplaats: " + adresGegevens.getWoonplaats() + "\n");
    }

    private static void updateAdresMenu() throws SQLException {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welk adres wilt u updaten? \n"
                + "Voer adres ID in: ");
        int adres_id = input.nextInt();
        
        Adres adres = AdresDAO.readAdresByID(adres_id);  
        
        System.out.println("Huidig adres ID: " + adres.getAdres_id() + "\n"
                + "Voer een nieuw adres ID in:");
        int adresID = input.nextInt();
        System.out.println("Huidige straanaam: " + adres.getStraatnaam() + "\n"
                + "Voer een nieuwe straatnaam in:");
        String straatnaam = input.next();
        System.out.println("Huidig huisnummer: " + adres.getHuisnummer() + "\n"
                + "Voer een nieuw huisnummer in:");
        int huisnummer = input.nextInt();
        System.out.println("Huidige toevoeging: " + adres.getToevoeging() + "\n"
                + "Voer een nieuwe toevoeging in:");
        String toevoeging = input.next();
        System.out.println("Huidige postcode: " + adres.getPostcode() + "\n"
                + "Voer een nieuwe postcode in:");
        String postcode = input.next();
        System.out.println("Huidige woonplaats: " + adres.getWoonplaats() + "\n"
                + "Voer een nieuwe woonplaats in:");
        String woonplaats = input.next();

        adres.setAdres_id(adresID);
        adres.setStraatnaam(straatnaam);
        adres.setHuisnummer(huisnummer);
        adres.setToevoeging(toevoeging);
        adres.setPostcode(postcode);
        adres.setWoonplaats(woonplaats);
        
        AdresDAO.updateAdres(adres);
        
        System.out.println("Het adres is aangepast.");  //terugkoppeling gebruiker
    }

    private static void deleteAdresMenu() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welk adres wilt u verwijderen? \n"
                + "Voer adres ID in: ");
        int adres_id = input.nextInt();
        
        AdresDAO aDAO = new AdresDAO();
        aDAO.deleteAdres(adres_id);
    }
}
