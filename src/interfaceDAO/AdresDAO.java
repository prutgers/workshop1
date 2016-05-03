package interfaceDAO;

/**
 *
 * @author Sonja
 */

import POJO.Adres;
import java.util.ArrayList; 

public interface AdresDAO {
    
    Adres createAdres(Adres adres);
    
    ArrayList<Adres> readAdres();
    
    Adres readAdresByID(int adresID);
        
    void updateAdres(Adres adres);
    
    void deleteAdres(int adres_id);
}
