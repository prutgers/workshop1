/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAOFactory.DAOFactory;
import POJO.Artikel;
import View.ArtikelView;
import interfaceDAO.ArtikelDAO;
import interfaceDAO.BestellingArtikelDAO;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class ArtikelService {
    
    public void create(Artikel artikel){
        ArtikelDAO dao = DAOFactory.getArtikelDAO();
        dao.createArtikel(artikel);
        
    }
    
    public void update(Artikel artikel){
        ArtikelDAO dao = DAOFactory.getArtikelDAO();
        dao.updateArtikel(artikel);
    }
    
    public void delete(int artikel_id){
        BestellingArtikelDAO baDAO = DAOFactory.getBestellingArtikelDAO();
        baDAO.deleteKoppelMetArtikelID(artikel_id);
        
        ArtikelDAO dao = DAOFactory.getArtikelDAO();
        dao.deleteArtikel(artikel_id);
    }
    
    public Artikel readByID(int artikel_id){
        ArtikelView aView = new ArtikelView();
        aView.readArtikelById();
        
        ArtikelDAO dao = DAOFactory.getArtikelDAO();
        Artikel artikel = dao.readArtikel(aView.getArtikel_id());
        return artikel;
    }
    
    public ArrayList<Artikel> readAll(){
        
        ArtikelDAO dao = DAOFactory.getArtikelDAO();
        ArrayList<Artikel> artikelLijst = dao.readArtikel();
        return artikelLijst;
    }
    
}
