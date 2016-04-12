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
            
            System.out.println("Voor createAdres, kies 1\n"
            + "Voor readAdres, kies 2\n"
            + "Voor updateAdres, kies 3\n"
            + "Voor deleteAdres, kies 4\n"
            + "Om te stoppen, kies 5");
            
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
                        updateAdresMenu();
                        break;
                    case 4:
                        deleteAdresMenu();
                        break;
                    case 5:
                        HoofdMenu.startMenu();
                        break;
                    default:
                        System.out.println("Maak een keuze.");
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
        }
    }

    private static void createAdresMenu() throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Voer het adres ID in:");
        int adres_id = input.nextInt();
        System.out.println("Voer het klant ID in:");
        int klant_id = input.nextInt();
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
        
        adres.setKlant_id(klant_id); //fill'er up
        adres.setAdres_id(adres_id);
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
            + "--------------");
        for (Adres a : adresgegevens) {
            System.out.println("Klant ID: " + a.getKlant_id()
            + "Adres ID: " + a.getAdres_id()
            + "Straatnaam: " + a.getStraatnaam()
            + "Huisnummer: " + a.getHuisnummer()
            + "Toevoeging: " + a.getToevoeging()
            + "Postcode: " + a.getPostcode()
            + "Woonplaats: " + a.getWoonplaats());
        }
    }

    private static void updateAdresMenu() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Wiens adres wilt u updaten? \n"
                + "Voer klant ID in: ");
        int klant_id = input.nextInt();
        
        //voer nieuwe info in en update adres
        
        System.out.println("");
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
