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

import View.CreateKlantMenu;
import DAO.MySQL.KlantDAOMySQL;
import POJO.Klant;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


public class KlantController {
    
    public void createKlantMenu(){
        CreateKlantMenu menu = CreateKlantMenu.create();
        Klant klant = new Klant();
        klant.setVoornaam(menu.getVoornaam());
        klant.setAchternaam(menu.getAchternaam());
        klant.setTussenvoegsel(menu.getTussenvoegsel());
        klant.setEmail(menu.getEmail());
        try {
            (new KlantDAOMySQL() ).createKlant(klant);
        }
        catch (MySQLIntegrityConstraintViolationException ex){
            System.out.print("Uw naam staat al in de database.");
        }

    }
    
    public void readKlantMenu(){}
    public void updateKlantMenu(){}
    public void deleteKlantMenu(){}
    
}
