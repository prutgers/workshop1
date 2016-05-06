package DAOFactory;

import interfaceDAO.*;
import DAO.MySQL.*;
import DAO.Firebird.*;
import DAO.JSON.*;
import DAO.XML.*;

/**
 *
 * @author Sonja
 */
public class DAOFactorySonja {
    
    private String database = "MySQL";
    
    public AdresDAO getAdresDAO() {
        if(database.equalsIgnoreCase("XML")) {
            return new AdresDAOXML();
        }
        else if(database.equalsIgnoreCase("FireBird")) {
            return new AdresDAOFirebird();
        }
        else if(database.equalsIgnoreCase("JSON")) {
            return new AdresDAOJSON();
        }
        else {
            return new AdresDAOMySQL();
        }
    }
    
    public ArtikelDAO getArtikelDAO() {
        if(database.equalsIgnoreCase("XML")) {
            return new ArtikelDAOXML();
        }
        else if(database.equalsIgnoreCase("FireBird")) {
            return new ArtikelDAOFirebird();
        }
        else if(database.equalsIgnoreCase("JSON")) {
            return new ArtikelDAOJSON();
        }
        else {
            return new ArtikelDAOMySQL();
        }
    }
    
    public BestellingDAO getBestellingDAO() {
        if(database.equalsIgnoreCase("XML")) {
            return new BestellingDAOXML();
        }
        else if(database.equalsIgnoreCase("FireBird")) {
            return new BestellingDAOFirebird();
        }
        else if(database.equalsIgnoreCase("JSON")) {
            return new BestellingDAOJSON();
        }
        else {
            return new BestellingDAOMySQL();
        }
    }
    
    public BestellingArtikelDAO getBestellingArtikelDAO() {
        if(database.equalsIgnoreCase("XML")) {
            return new BestellingArtikelDAOXML();
        }
        else if(database.equalsIgnoreCase("FireBird")) {
            return new BestellingArtikelDAOFirebird();
        }
        else if(database.equalsIgnoreCase("JSON")) {
            return new BestellingArtikelDAOJSON();
        }
        else {
            return new BestellingArtikelDAOMySQL();
        }
    }
    
    public KlantDAO getKlantDAO() {
        if(database.equalsIgnoreCase("XML")) {
            return new KlantDAOXML();
        }
        else if(database.equalsIgnoreCase("FireBird")) {
            return new KlantDAOFirebird();
        }
        else if(database.equalsIgnoreCase("JSON")) {
            return new KlantDAOJSON();
        }
        else {
            return new KlantDAOMySQL();
        }
    }
    
    /*
    public KlantAdresDAO getKlantAdresDAO() {
        if(database.equalsIgnoreCase("XML")) {
            return new KlantAdresDAOXML();
        }
        else if(database.equalsIgnoreCase("FireBird")) {
            return new KlantAdresDAOFirebird();
        }
        else if(database.equalsIgnoreCase("JSON")) {
            return new KlantAdresDAOJSON();
        }
        else {
            return new AdresDAOMySQL();
        }
    }
    */
}
