/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

/**
 *
 * @author lucas
 */

import POJO.Klant;
import java.util.ArrayList;

public interface KlantDAO {
    public Klant createKlant(Klant klant) throws com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
    public Klant readKlant(int klant_id);
    public Klant updateKlant(Klant klant);
    public void deleteKlant(int klant_id) throws com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
    public ArrayList<Klant> readAllKlantByKlant(Klant klant);
}
