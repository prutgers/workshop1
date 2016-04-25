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
import menu.*;



/**
 *
 * @author Peter
 */

public class Workshop1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HoofdMenu.startMenu();      
           
 
        
    }
}

/**
 *       // ArtikelDAOFirebird.testreadFirebirdDB();
       Artikel artikel = new Artikel();
       //artikel.setArtikel_id(5);
       artikel.setArtikel_naam("feest");

       artikel.setArtikel_prijs(new BigDecimal(14.8));
       artikel.setArtikel_voorraad(5);

       ArtikelDAOFirebird.createFirebirdDB(artikel);
       ArtikelDAOFirebird.readFirebirdDB();

       
       Artikel artikel2 = new Artikel();
       artikel2.setArtikel_naam("33");
        
       artikel2.setArtikel_prijs(new BigDecimal(16.44));
       artikel2.setArtikel_voorraad(5);

       //ArtikelDAOFirebird.updateFirebirdDB(artikel2);
       ArtikelDAOFirebird.createFirebirdDB(artikel2);
       ArtikelDAOFirebird.readFirebirdDB(); 
 */