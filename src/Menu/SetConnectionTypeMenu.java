/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

/**
 *
 * @author lucas
 */
import ConnectionPools.*;
import java.util.Scanner;

public class SetConnectionTypeMenu {
        
    public static void startMenu(){
        Scanner input = new Scanner(System.in);
        
        while(true){
            System.out.println("Welkom in het Connectie Type Menu.\n"
                    + "Selecteer een setting:\n"
                    + "Kies 1 voor Hikari; \n"
                    + "Kies 2 voor C3P0; \n"
                    + "Kies 3 voor een directe JDBC connectie \n"
                    + "       (Waarschuwing, deze ondersteund geen pools, gebruik op eigen risico); \n"
                    + "kies 0 ga naar hoofdmenu.");
            int select = input.nextInt();
            //VerifyInputScanner.verifyInt(select);
            
            switch (select) {
                case 1: ConnectionPool.setConnectionSettings(
                        ConnectionPoolHikari.getConnectionPoolHikari());
                    break;
                case 2: ConnectionPool.setConnectionSettings(
                        ConnectionPoolC3P0.getConnectionPoolC3P0());
                    break;
                case 3: ConnectionPool.setConnectionSettings(
                        ConnectionJDBC.getConnectionJDBC());
                    break;
                case 0: HoofdMenu.startMenu(); break;
                default:
                    System.out.println("kies 1, 2, 3 of 0");
                    break;
            }
        }
        
    }
    
}
