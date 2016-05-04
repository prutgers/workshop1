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
    
    public KlantDAO getKlantDAO(String db){
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
    
    public ArtikelDAO getArtikelDAO(String db){
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
    
    public BestellingDAO getBestellingDAO(String db){
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
    
    public AdresDAO getAdresDAO(String db){
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
    
    public BestellingArtikelDAO getBestellingArtikelDAO(String db){
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
    
    
    public KlantAdresDAO getKlantAdresDAO(String db){
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
