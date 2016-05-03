/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOFactory;

/**
 *
 * @author lucas
 */
import interfaceDAO.KlantDAO;
import DAO.MySQL.KlantDAOMySQL;

public class KlantDAOFactory {
    
    public KlantDAO getKlantDAO(){
        return new KlantDAOMySQL();
    }
}
