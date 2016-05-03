package Controller;

/**
 *
 * @author Sonja
 */

import View.AdresView;
import DAO.MySQL.AdresDAO;
import Menu.HoofdMenu;
import POJO.Adres;

public class AdresController {
    
    public static void createAdresView() {
        AdresView menu = new AdresView();
        menu.create();
        Adres adres = new Adres();
        adres.setAdres_id(menu.getAdres_id());
        AdresDAO.createAdres(adres);
    }
    
    public static void updateAdresView() {
        //...
    }
    
    public static void readAllAdresView() {
        //...
    }
    
    public static void readAdresByIDView() {
        //...
    }
    
    public static void deleteAdresView() {
        //...
    }
}
