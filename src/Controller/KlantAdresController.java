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
import POJO.KlantAdres;
import interfaceDAO.KlantAdresDAO;
import DAOFactory.DAOFactory;
import View.KlantAdresKeuzeView;
import View.KlantAdresView;
import View.AdresView;
import View.KlantView;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import POJO.Adres;
import POJO.Klant;

public class KlantAdresController {
    private KlantAdresDAO klantAdresDAO;
    private KlantAdresView kView = new KlantAdresView();
    
    public static void startKeuze(){
        KlantAdresController deze = new KlantAdresController();
        KlantAdresKeuzeView keuze = new KlantAdresKeuzeView();
        keuze.keuzeView();
      
        switch (keuze.getSelect()) {
            case 1:
                deze.create();
                break;
            case 2:
                deze.readByKlant();
                break;
            case 3:
                deze.readByAdres();
                break;
            case 4:
                deze.deleteByKlant();
                break;
            case 5:
                deze.deleteByAdres();
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
        KlantAdres klantAdres = new KlantAdres();
        klantAdres.setKlant_id( kView.getKlant_id() );
        klantAdres.setAdres_id( kView.getAdres_id() );
        
        
        klantAdresDAO = new DAOFactory().getKlantAdresDAO();
        try {
            klantAdresDAO.createKlantAdresKoppel(klantAdres);
        }
        catch (MySQLIntegrityConstraintViolationException ex){
        }
        
    }
    
    
    public void readByKlant(){
        kView.readByKlant();
        ArrayList<Adres> allAdres = (new DAOFactory().getKlantAdresDAO().readAdresID( kView.getKlant_id() ) );
        ( new AdresView() ).readAll(allAdres);
    }
    
    public void readByAdres(){
        kView.readByAdres();
        ArrayList<Integer> allKlant = (new DAOFactory().getKlantAdresDAO().readKlantID( kView.getAdres_id() ) );
        ArrayList<Klant> klantLijst = new ArrayList();
        KlantView klView = new KlantView();
        for (int e: allKlant){
            klantLijst.add(new DAOFactory().getKlantDAO().readKlant( e )
        );
            klView.print(klantLijst);
        }
    }
    
    
    public void deleteByKlant(){
        kView.deleteByKlant();
        klantAdresDAO = new DAOFactory().getKlantAdresDAO();
        klantAdresDAO.deleteKlantAdresKoppel( kView.getKlant_id() );
    }
    
    public void deleteByAdres(){
        kView.deleteByAdres();
        klantAdresDAO = new DAOFactory().getKlantAdresDAO();
        klantAdresDAO.deleteAdresKlantKoppel( kView.getAdres_id() );
    }
    
}
