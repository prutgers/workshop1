/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import POJO.Adres;
import POJO.KlantAdres;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public interface KlantAdresDAO {
    public KlantAdres createKlantAdresKoppel(KlantAdres koppel) throws com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
        
    public ArrayList<Integer> readKlantID(int adres_id);
     
     //helemaal aangepast
    public ArrayList<Adres> readAdresID(int klant_id);
    
    public void updateKlantAdresKoppel();
            
    public void deleteKlantAdresKoppel(int klant_id);
    
    public void deleteAdresKlantKoppel(int adres_id);
}
