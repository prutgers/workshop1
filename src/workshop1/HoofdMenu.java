/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

import java.sql.SQLException;
import java.util.Scanner;
import static workshop1.BestellingMenu.createMenu;
import static workshop1.BestellingMenu.deleteByIdMenu;
import static workshop1.BestellingMenu.getAllMenu;
import static workshop1.BestellingMenu.getByIdMenu;
import static workshop1.BestellingMenu.getByKlantIdMenu;

/**
 *
 * @author Peter
 */
public class HoofdMenu {
    public static void startMenu() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Kies 1 voor klant menu; \n"
                + "kies 2 voor adres menu, \n"
                + "kies 3 voor artikel menu, \n"
                + "kies 4 voor bestelling menu, \n"
                + "kies 5 quit, \n");
        int select = input.nextInt();
        
        switch (select) {
            case 1:
                System.out.println("klant menu nog niet gemaakt");
                break;
            case 2:
                System.out.println("adres menu wordt aan gewerkt");
                break;
            case 3:
                System.out.println("artikel menu nog niet gemaakt");
                Artikel artikel = new Artikel();
            artikel.setArtikel_id(27);

            artikel.setArtikel_voorraad(2);
            artikel.setArtikel_prijs(1677);
            artikel.setArtikel_naam("koe");

            ArtikelDAO test = new ArtikelDAO();
            //test.createNewArtikel(artikel);
           // int delete = 24;
            //test.readArtikel();
            //  test.deleteArtikel(delete);
            
          
            test.readArtikel();
            
            HoofdMenu.startMenu();
                break;
            case 4:
                BestellingMenu.startMenu();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("kies 1, 2 of 3 of 4");
                break;
        }
        
        
    }
    
}
