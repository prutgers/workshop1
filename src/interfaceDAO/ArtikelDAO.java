/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import POJO.Artikel;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public interface ArtikelDAO {
    Artikel createArtikel(Artikel artikel);
    
    Artikel readArtikel(int artikel_id);

    ArrayList<Artikel> readArtikel();
    
    void DeleteArtikel(int artikel_id);

    void updateArtikel(Artikel artikel);
}
