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
import static workshop1.KoppelBestellingArtikelDAO.createKoppelBestellingArtikel;
import static workshop1.KoppelBestellingArtikelDAO.readKoppelMetArtikelID;


/**
 *
 * @author Gebruiker
 */
public class BestellingMenu {
    public static void startMenu() {
        Scanner input = new Scanner(System.in);
        while(true){
                    
            System.out.println("\n"
                    + "**BESTELREGEL-MENU** \n" 
                + "Kies 1 om een besteleegel toe te voegen \n"
                + "kies 2 voor alle bestelregels van een bestelling \n"
                + "kies 3 om een bestelregel aan te passen"
                + "kies 4 om een bestelregel te verwijderen");
            int select = input.nextInt();
            try{
                switch (select) {
                    case 1:
                        createBestelRegelsMenu();
                        break;
                    case 2:
                        getBestelRegelsMenu();
                        break;
                    case 3:
                        updateBestelRegelsMenu();
                        break;
                    case 4:
                        deleteBestelRegelsMenu();
                        break;
                    default:
                        System.out.println("kies 1, 2 of 3");
                        break;
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private static void createBestelRegelsMenu() {
        Scanner input = new Scanner(System.in);
        KoppelBestellingArtikel bestelRegel = new KoppelBestellingArtikel();
        System.out.println("Enter bestellingID");
        bestelRegel.setBestelling_id(input.nextInt());
        System.out.println("Enter artikelID");
        bestelRegel.setArtikel_id(input.nextInt());
        System.out.println("Enter aantal");
        bestelRegel.setAantal(input.nextInt());
        createKoppelBestellingArtikel(bestelRegel);
    }
    
    public static void getBestelRegelsMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter bestellingID");
        ArrayList<KoppelBestellingArtikel> lijst = readKoppelMetArtikelID(input.nextInt());
        System.out.println("**BESTELREGELS**");
        for(KoppelBestellingArtikel e : lijst){
            System.out.println(e.getKoppel_id() + "-" + e.getArtikel_id() + "-" + e.getAantal());
        }
    }
    
    private static void updateBestelRegelsMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void deleteBestelRegelsMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
