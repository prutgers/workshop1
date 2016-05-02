package Menu;

import DAO.Firebird.ArtikelDAOFirebird;
import DAO.JSON.ArtikelDAOJSON;
import POJO.Artikel;
import formatMessage.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Peter
 */

public class HoofdMenu {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        startMenu();
        
       
    }
 
    
    public static void testArtikelJSON(){
        ArtikelDAOJSON test = new ArtikelDAOJSON();
        Artikel a = new Artikel();
        a.setArtikel_naam("VoorHerman");
        a.setArtikel_prijs(new BigDecimal(2));
        a.setArtikel_voorraad(5);
        test.createArtikel(a);
        
       ArrayList<Artikel> artikelLijst = test.readArtikel();
       for(Artikel b : artikelLijst){
        System.out.format("%s, %s, %s, %s\n", b.getArtikel_id(), b.getArtikel_naam(), 
                b.getArtikel_prijs(), b.getArtikel_voorraad()); 
        }
        
        
    }
    
    public static void startMenu() {
        Scanner input = new Scanner(System.in);
        PrintFormat.printHeader("HOOFDMENU");
        System.out.println("1: Ga naar het klant-adresmenu \n"
            + "2: Ga naar het bestellingmenu \n"
            + "3: Ga naar het artikelmenu \n"
            + "4: Ga naar het adresmenu \n"
                + "\n"
            + "5: Ga naar de connection settings \n"
                + "\n"
            + "0: Stop de applicatie \n");
        int select = input.nextInt();
        
        switch (select) {
            case 1:
                KlantAdresMenu.startMenu();
                break;
            case 2:
                BestellingenMenu.startMenu();
                break;
            case 3:
                ArtikelMenu.startMenu();
                break;            
            case 4:
                AdresMenu.startMenu();
                break;
            case 5:
                SetConnectionTypeMenu.startMenu();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Maak een keuze: 1, 2, 3, 4, 5 of 0");
                break;
        }
    }
    
    
    //test zodat je niet helemaal door het menu heen hoeft
    public static void testArtikelFirebird(){
        Artikel artikel = new Artikel();
        artikel.setArtikel_naam("bonookey");
        artikel.setArtikel_prijs(new BigDecimal(14.8));
        artikel.setArtikel_voorraad(5);
        Artikel woeps = ArtikelDAOFirebird.createArtikelFirebirdDB(artikel);
        System.out.println("geef me het artikel ID en de Naam " + woeps.getArtikel_naam() + " " + woeps.getArtikel_id());
        ArrayList<Artikel> artikelLijst = ArtikelDAOFirebird.readArtikelFirebirdDB();
        for(Artikel a : artikelLijst){
            System.out.println("woop woop " + a.getArtikel_naam() + " " + a.getArtikel_id());
        }
        
        Artikel aTest = ArtikelDAOFirebird.readArtikelFirebirdDB(7);
        System.out.println("1 artikel " + aTest.getArtikel_naam());
        
        //ArtikelDAOFirebird.DeleteArtikelFirebirdDB(5);
        
        
        
        Artikel artikel2 = new Artikel();
        artikel2.setArtikel_naam("hihahupsakee");
        artikel2.setArtikel_prijs(new BigDecimal(14.8));
        artikel2.setArtikel_voorraad(5);
        artikel2.setArtikel_id(7);
        //ArtikelDAOFirebird.testPrepUpdateFirebirdDB(artikel2);
        ArtikelDAOFirebird.updateArtikelFirebirdDB(artikel2);
        
        System.out.println("*************************************");
        ArrayList<Artikel> artikelLijst2 = ArtikelDAOFirebird.readArtikelFirebirdDB();
        for(Artikel a : artikelLijst2){
            System.out.println("woop woop " + a.getArtikel_naam() + " " + a.getArtikel_id());
        }
    }
    
}