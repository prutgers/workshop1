/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import static formatMessage.PrintFormat.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import workshop1.*;
import static workshop1.KoppelBestellingArtikelDAO.*;

/**
 *
 * @author Gebruiker
 */
public class BestellingArtikelMenu {
    public static void startMenu() {
        Scanner input = new Scanner(System.in);
        while(true){
            printHeader("BESTELLING-ARIKELEN MENU");
            System.out.println(
                    "Kies 1 om een bestllingartikel toe te voegen \n"
                + "kies 2 voor alle bestllingartikels van een bestelling \n"
                + "kies 3 om een bestllingartikel aan te passen\n"
                + "kies 4 om een bestllingartikel te verwijderen");
            int select = input.nextInt();
            try{
                switch (select) {
                    case 1:
                        createBestelArtikelMenu();
                        break;
                    case 2:
                        getBestelArtikelMenu();
                        break;
                    case 3:
                        updateBestelArtikelMenu();
                        break;
                    case 4:
                        deleteBestelArtikelMenu();
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

    private static void createBestelArtikelMenu() {
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
    
    public static void getBestelArtikelMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter bestellingID");
        ArrayList<KoppelBestellingArtikel> lijst = readKoppelMetBestellingID(input.nextInt());
        System.out.printf("%15s %15s %15s\n","KoppelID", "AtikelID", "Aantal");
        for(KoppelBestellingArtikel e : lijst){
             System.out.printf("%15s %15d %15d\n",e.getKoppel_id(), e.getArtikel_id(), e.getAantal());
        }
    }
    
    private static void updateBestelArtikelMenu() {
       Scanner input = new Scanner(System.in);
        System.out.println("Enter koppelID");
        KoppelBestellingArtikel koppel = readKoppelById(input.nextInt());
        System.out.println("Enter aantal");
        koppel.setAantal(input.nextInt());
        System.out.println("Enter artikelID");
        koppel.setArtikel_id(input.nextInt());
        updateKoppel(koppel);
    }

    private static void deleteBestelArtikelMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
