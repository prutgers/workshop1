/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author lucas
 */

import View.KlantView;
import DAO.MySQL.KlantDAOMySQL;
import POJO.Klant;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import interfaceDAO.KlantDAO;
import DAOFactory.KlantDAOFactory;


public class KlantController {
    private KlantDAO klantDAO;
    private KlantView kView = new KlantView();
    
    public void create(){
        kView.create();
        Klant klant = new Klant();
        klant.setVoornaam(kView.getVoornaam());
        klant.setAchternaam(kView.getAchternaam());
        klant.setTussenvoegsel(kView.getTussenvoegsel());
        klant.setEmail(kView.getEmail());
        
        klantDAO = new KlantDAOFactory().getKlantDAO();
        try {
            klantDAO.createKlant(klant);
        }
        catch (MySQLIntegrityConstraintViolationException ex){
            System.out.print("Uw naam staat al in de database.");
        }

    }
    
    public void read(){
        kView.read();
        kView.print(
                new KlantDAOFactory().getKlantDAO().readKlant( kView.getKlant_id() )
        );
    }
    
    public void update(){
        Klant klant = klantViewToKlant( kView.update() );
        kView.print(
                new KlantDAOFactory().getKlantDAO().updateKlant(klant)
        );
    }
    
    public void delete(){
        kView.delete();
        kView.print(
                new KlantDAOFactory().getKlantDAO().readKlant( kView.getKlant_id() )
        );
    }
    
    public void readAllByObject(){}
    
    
    
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
