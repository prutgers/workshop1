/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOFactory;

import DAO.Firebird.*;
import DAO.JSON.*;
import DAO.MySQL.*;
import DAO.XML.*;
import interfaceDAO.*;

/**
 *
 * @author Peter
 */
public class DAOFactory {
    
    private static String db = "MySQL";

    public static void setDB(String database){
        db = database;
    }
    
    public static interfaceDAO.KlantDAO getKlantDAO(){
        if(db.equals("Firebird")) {
            return new KlantDAOFirebird();
        } else if(db.equals("JSON")) {
            return new KlantDAOJSON();
        } else if(db.equals("XML")) {
            return new KlantDAOXML();
        } else {
            return new KlantDAOMySQL();
        }
    }
    
    public static interfaceDAO.ArtikelDAO getArtikelDAO(){
        if(db.equals("Firebird")) {
            return new ArtikelDAOFirebird();
        } else if(db.equals("JSON")) {
            return new ArtikelDAOJSON();
        } else if(db.equals("XML")) {
            return new ArtikelDAOXML();
        } else {
            return new ArtikelDAOMySQL();
        }
    }
    
    public static interfaceDAO.BestellingDAO getBestellingDAO(){
        if(db.equals("Firebird")) {
            return new BestellingDAOFirebird();
        } else if(db.equals("JSON")) {
            return new BestellingDAOJSON();
        } else if(db.equals("XML")) {
            return new BestellingDAOXML();
        } else {
            return new BestellingDAOMySQL();
        }
    }
    
    public static interfaceDAO.AdresDAO getAdresDAO(){
        if(db.equals("Firebird")) {
            return new AdresDAOFirebird();
        } else if(db.equals("JSON")) {
            return new AdresDAOJSON();
        } else if(db.equals("XML")) {
            return new AdresDAOXML();
        } else {
            return new AdresDAOMySQL();
        }
    }
    
    public static interfaceDAO.BestellingArtikelDAO getBestellingArtikelDAO(){
        if(db.equals("Firebird")) {
            return new BestellingArtikelDAOFirebird();
        } else if(db.equals("JSON")) {
            return new BestellingArtikelDAOJSON();
        } else if(db.equals("XML")) {
            return new BestellingArtikelDAOXML();
        } else {
            return new BestellingArtikelDAOMySQL();
        }
    }
    
    
    public static interfaceDAO.KlantAdresDAO getKlantAdresDAO(){
        /* Werkt pas als alle klasses er zijn
        if(db.equals("Firebird")) {
            return new KlantAdresDAOFirebird();
        } else if(db.equals("JSON")) {
            return new KlantAdresDAOJSON();
        } else if(db.equals("XML")) {
            return new KlantAdresDAOXML();
        } else {
            return new KlantAdresDAOMySQL();
        }
        */
        return new KlantAdresDAOMySQL();
    }
    
}
