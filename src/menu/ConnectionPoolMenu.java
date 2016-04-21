/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import ConnectionPools.ConnectionJDBC;
import ConnectionPools.ConnectionPoolC3P0;
import ConnectionPools.ConnectionPoolHikari;

/**
 *
 * @author Peter
 */
public class ConnectionPoolMenu {
    
    
    
    public static void startMenu() {
        
        public static final int NILL = 0;
    public static final int HIKARI = 1;
    public static final int C3P0 = 2;
    public static final int JDBCDRIVER = 3;
        Scanner input = new Scanner(System.in);
        while(true){
            PrintFormat.printHeader("BESTELLINGEN-MENU");        
            System.out.println(
                  "1) Maak nieuwe bestelling aan\n"
                + "2) Voeg een artikel toe aan een bestelling (met bestelling ID) \n"
                + "3) Verander aantal bestelde artikellen (met bestelling en artikel ID) \n"
                + " \n"
                + "4) Haal specifieke bestelling op (met bestelling ID) \n"
                + "5) Haal alle bestelling van 1 klant op (met klant ID) \n"
                + "6) Haal alle artikelen van 1 bestelling op (met bestelling ID) \n"
                + "7) Haal alle bestelling van alle klanten op \n"
                + " \n"
                + "8) Verwijder 1 artikel uit een bestelling (met bestelling en artikel ID) \n"
                + "9) Verwijder gehele bestelling (met bestelling ID) \n"
                + " \n"
                + "10) Ga naar hoofdmenu");
            int select = input.nextInt();

            switch (select) {
                case 1:
                    setHikari();
                    break;
                case 2:
                    createBestelArtikelMenu();
                    break;
                case 3:
                    updateBestellingAantalMenu();
                    break;
                case 10:
                    HoofdMenu.startMenu();
                    break;
                default:
                    System.out.println("kies 1, 2, 3, 4, 5, 6, 7, 8, 9  of 10");
                    break;
            }
            System.out.println("druk op enter om door te gaan");
            // iets invoegen zodat het programma even stopt
        }
    }
    
    
    public void setHikari(){
        strategy = new ConnectionPoolHikari();
    }
    
     if (setting == 1) {
            
            logger.info("HikariCP ingesteld");
        }
        else if (setting == 2) {
            strategy = new ConnectionPoolC3P0();
            logger.info("C3P0 ingesteld");
        }
        else if (setting == 3) {
            strategy = new ConnectionJDBC();
            logger.info("JDBC Driver ingesteld (Waarschuwing, deze library implementeerd geen pool functie.)");
        }
        else {
            logger.info("Als je dit leest dan is er iets mis.");
        }
}
