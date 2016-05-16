/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author lucas
 * 
 * KlantController is part of the Klant MVC
 * 
 */

import View.KlantView;
import View.KlantKeuzeView;
import View.AdresView;
import DAO.MySQL.KlantDAOMySQL;
import POJO.Klant;
import POJO.Adres;
import POJO.KlantAdres;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import interfaceDAO.KlantDAO;
import interfaceDAO.AdresDAO;
import interfaceDAO.KlantAdresDAO;
import DAOFactory.DAOFactory;


public class KlantController {
    private KlantDAO klantDAO;
    private KlantView kView = new KlantView();
    
    public static void startKeuze(){
        KlantController deze = new KlantController();
        KlantKeuzeView keuze = new KlantKeuzeView();
        keuze.keuzeView();
      
        switch (keuze.getSelect()) {
            case 1:
                deze.create();
                break;
            case 2:
                deze.read();
                break;
            case 3:
                deze.update();
                break;
            case 4:
                deze.delete();
                break;
            case 5:
                deze.readAllByObject();
                break;
            case 6:
                deze.readAll();
                break;
            case 0:
                MainController.hoofdMenu();
                return;
            default:
                break;
        }
        startKeuze();
    }
    
    public void create(){
        kView.create();
        Klant klant = new Klant();
        klant.setVoornaam(kView.getVoornaam());
        klant.setAchternaam(kView.getAchternaam());
        klant.setTussenvoegsel(kView.getTussenvoegsel());
        klant.setEmail(kView.getEmail());
        
        klantDAO = new DAOFactory().getKlantDAO();
        try {
            klantDAO.createKlant(klant);
        }
        catch (MySQLIntegrityConstraintViolationException ex){
            kView.KlantBestaatAl();
        }
        
        //maak een nieuw adres
        AdresView adresView = new AdresView();
        adresView.create();
        
        Adres adres = new Adres();
        adres.setAdres_id(adresView.getAdres_id());
        adres.setStraatnaam(adresView.getStraatnaam());
        adres.setHuisnummer(adresView.getHuisnummer());
        adres.setToevoeging(adresView.getToevoeging());
        adres.setPostcode(adresView.getPostcode());
        adres.setWoonplaats(adresView.getWoonplaats());
        
        AdresDAO aDAO = DAOFactory.getAdresDAO();
        aDAO.createAdres(adres);
        
        //koppel de klant aan het adres
        KlantAdres klantAdres = new KlantAdres();
        klantAdres.setKlant_id( klant.getKlant_id() );
        klantAdres.setAdres_id( adres.getAdres_id() );
        
        
        KlantAdresDAO klantAdresDAO = new DAOFactory().getKlantAdresDAO();
        try {
            klantAdresDAO.createKlantAdresKoppel(klantAdres);
        }
        catch (MySQLIntegrityConstraintViolationException ex){
        }

    }
    
    public void read(){
        kView.read();
        kView.print(new DAOFactory().getKlantDAO().readKlant( kView.getKlant_id() )
        );
    }
    
    public void update(){
        Klant klant = klantViewToKlant( kView.update() );
        kView.printUpdate(new DAOFactory().getKlantDAO().updateKlant(klant)
        );
    }
    
    public void delete(){
        kView.delete();
        KlantAdresDAO klantAdresDAO = new DAOFactory().getKlantAdresDAO();
        klantAdresDAO.deleteKlantAdresKoppel( kView.getKlant_id() );
        try {
        new DAOFactory().getKlantDAO().deleteKlant( kView.getKlant_id() );
        }
        catch (MySQLIntegrityConstraintViolationException ex){
            kView.KlantInKlantAdresTabel();
        }
    }
    
    public void readAllByObject(){
        kView.readAllByKlant();
        kView.print(new DAOFactory().getKlantDAO().readAllKlantByKlant( klantViewToKlant( kView ) )
        );
    }
    
    public void readAll(){
        kView.print(new DAOFactory().getKlantDAO().readAllKlantByKlant( new Klant() )
        );
    }
    
    
    public static Klant klantViewToKlant(KlantView kview){
        Klant klant = new Klant();
        klant.setKlant_id(kview.getKlant_id());
        klant.setVoornaam(kview.getVoornaam());
        klant.setAchternaam(kview.getAchternaam());
        klant.setTussenvoegsel(kview.getTussenvoegsel());
        klant.setEmail(kview.getEmail());
        
        return klant;
    }
    
}
