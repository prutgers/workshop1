/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

import ConnectionPools.ConnectionPool;
import ConnectionPools.ConnectionPoolHikari;
import formatMessage.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import menu.*;



/**
 *
 * @author Peter1
 */

public class Workshop1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
   HoofdMenu.startMenu();

    

        
       //testArtikelFirebird();
      // KlantAdresMenu.readKlantByIDMenu();
   }
    
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