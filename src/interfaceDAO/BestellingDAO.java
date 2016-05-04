/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import ConnectionPools.ConnectionPool;
import ConnectionPools.DBConnector;
import POJO.Bestelling;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Gebruiker
 */
public interface BestellingDAO {
    public Bestelling createBestelling(Bestelling bestelling);
    
    public Bestelling getBestellingById(int BestellingId);
    
    public ArrayList<Bestelling> getAllBestelling();
    
    public ArrayList<Bestelling> getBestellingByKlantId(int klantId);
    
    public void updateBestelling(Bestelling bestelling);
    
    public void deleteBestelling(int bestelling_id);
}
