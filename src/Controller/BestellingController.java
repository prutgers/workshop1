/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MySQL.BestellingDAO;
import static Menu.BestellingenMenu.createBestellingMetArtikelMenu;
import POJO.Bestelling;
import View.BestellingView;
import java.util.ArrayList;

/**
 *
 * @author Gebruiker
 */
public class BestellingController {
    public static void createBestelling(){
        BestellingView view = new BestellingView();
        view.createBestelling();
        
        Bestelling bestelling = new Bestelling();
        bestelling.setKlantID(view.getKlandID());
        Bestelling newBestelling =BestellingDAO.createBestelling(bestelling);
        
        createBestellingMetArtikelMenu(newBestelling.getBestellingID()); 
    }
    public static void readBestelling(){
        BestellingView view = new BestellingView();
        ArrayList<Bestelling> list = BestellingDAO.getAllBestelling();
        view.readBestelling(list);
    }
    public static void readBestelling(int bestellingID){
        BestellingView view = new BestellingView();
        view.readBestelling();
        Bestelling bestelling = BestellingDAO.getBestellingById(BestellingId);
    }
                    
}
