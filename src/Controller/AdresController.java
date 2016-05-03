package Controller;

/**
 *
 * @author Sonja
 */

import View.AdresView;
import DAO.MySQL.AdresDAO;
import POJO.Adres;
import java.util.ArrayList;

public class AdresController {
    
    public static void createAdresView() {
        AdresView menu = new AdresView();
        menu.create();
        Adres adres = new Adres();
        
        adres.setAdres_id(menu.getAdres_id());
        adres.setStraatnaam(menu.getStraatnaam());
        adres.setHuisnummer(menu.getHuisnummer());
        adres.setToevoeging(menu.getToevoeging());
        adres.setPostcode(menu.getPostcode());
        adres.setWoonplaats(menu.getWoonplaats());
        
        AdresDAO.createAdres(adres);
    }
    
    public static void updateAdresView() {
        AdresView menu = new AdresView();
        menu.update();
        Adres adres = new Adres();
        
        adres.setStraatnaam(menu.getStraatnaam()); 
        adres.setHuisnummer(menu.getHuisnummer());
        adres.setToevoeging(menu.getToevoeging());
        adres.setPostcode(menu.getPostcode());
        adres.setWoonplaats(menu.getWoonplaats());
        
        AdresDAO.updateAdres(adres);
    }
    
    /*
    Dit klopt nog niet
    */
    public static void readAllAdresView() {
        AdresView menu = new AdresView();
        menu.readAll();
        
        ArrayList<Adres> adresgegevens = AdresDAO.readAdres();
        
        for (Adres adres : adresgegevens) {
            System.out.printf("%15d %15s %15d %15s %15s %15s\n",
                adres.getAdres_id(), adres.getStraatnaam(), adres.getHuisnummer(), 
                adres.getToevoeging(), adres.getPostcode(), adres.getWoonplaats());
        }
    }
    
    public static void readAdresByIDView() {
        //...
    }
    
    public static void deleteAdresView() {
        AdresView menu = new AdresView();
        menu.delete();
  
        AdresDAO aDAO = new AdresDAO();
        AdresDAO.deleteAdres(menu.getAdres_id());
    }
}
