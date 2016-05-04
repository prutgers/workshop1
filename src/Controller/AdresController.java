package Controller;

/**
 *
 * @author Sonja
 */

import View.AdresView;
import DAO.MySQL.AdresDAOMySQL;
import POJO.Adres;
import View.AdresKeuzeView;
import java.util.ArrayList;

public class AdresController {
    
    public static void startKeuze() {
        AdresKeuzeView view = new AdresKeuzeView();
        view.keuze();
        switch (view.getSelect()) {
            case 1:
                AdresController.create();
                break;
            case 2:
                AdresController.update();
                break;
            case 3:
                AdresController.readAll();
                break;
            case 4:
                AdresController.readByID();
                break;
            case 5: 
                AdresController.delete();
                break;
            case 0:
                MainController.hoofdMenu();
                break;
            default:
                view.herhaalKeuze();
                break;
        }
        if(view.getSelect() != 0) {
            startKeuze();
        }
    }
    
    public static void create() {
        AdresView adresView = new AdresView();
        adresView.create();
        Adres adres = new Adres();
        
        adres.setAdres_id(adresView.getAdres_id());
        adres.setStraatnaam(adresView.getStraatnaam());
        adres.setHuisnummer(adresView.getHuisnummer());
        adres.setToevoeging(adresView.getToevoeging());
        adres.setPostcode(adresView.getPostcode());
        adres.setWoonplaats(adresView.getWoonplaats());
        
        AdresDAOMySQL aDAO = new AdresDAOMySQL();
        aDAO.createAdres(adres);
    }
    
    public static void update() {
        AdresView adresView = new AdresView();
        adresView.update();
        Adres adres = new Adres();
        
        adres.setStraatnaam(adresView.getStraatnaam()); 
        adres.setHuisnummer(adresView.getHuisnummer());
        adres.setToevoeging(adresView.getToevoeging());
        adres.setPostcode(adresView.getPostcode());
        adres.setWoonplaats(adresView.getWoonplaats());
        
        AdresDAOMySQL aDAO = new AdresDAOMySQL();
        aDAO.updateAdres(adres);
    }
    
    public static void readAll() {
        AdresView adresView = new AdresView();
        AdresDAOMySQL aDAO = new AdresDAOMySQL();
        ArrayList<Adres> adresGegevens = aDAO.readAdres();
        adresView.readAll(adresGegevens);
    }
    
    public static void readByID() {
        AdresView adresView = new AdresView();
        adresView.readAdresByID();
        
        AdresDAOMySQL aDAO = new AdresDAOMySQL();
        Adres adres = aDAO.readAdresByID(adresView.getAdres_id());
        adresView.readAdresByID(adres);
    }
    
    public static void delete() {
        AdresView adresView = new AdresView();
        adresView.delete();
  
        AdresDAOMySQL aDAO = new AdresDAOMySQL();
        aDAO.deleteAdres(adresView.getAdres_id());
    }
}
