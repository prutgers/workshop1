
package DAO.MySQL;

import ConnectionPools.*;
import POJO.*;
import interfaceDAO.BestellingDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BestellingDAOMySQL implements BestellingDAO{
    public Bestelling createBestelling(Bestelling bestelling) {

        String query = "INSERT INTO Bestelling (klant_id) values (?)";
      

        try(Connection con = ConnectionPool.getConnection();){
        
            PreparedStatement stmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            //set values vooor INSERT
                       
            stmt.setInt(1, bestelling.getKlantID());

           
            stmt.executeUpdate();
            ResultSet resultSet = stmt.getGeneratedKeys();
            if (resultSet.isBeforeFirst()){
                resultSet.next();
                //wijs een door de database gegenereerd id toe aan de klant
                bestelling.setBestellingID(resultSet.getInt(1)); 
            }
        }
        catch(SQLException | ClassNotFoundException e){
            System.out.println("\nProbeer opnieuw.\n");
            e.printStackTrace();
        }
        return bestelling;
    }
    
    public Bestelling getBestellingById(int BestellingId){
        
        Bestelling bestelling = new Bestelling();
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement stmt = con.prepareStatement("select * from Bestelling where bestelling_id = ?");
            stmt.setInt(1, BestellingId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                bestelling.setKlantID(rs.getInt("klant_id"));
                bestelling.setBestellingID(rs.getInt("bestelling_id"));
            }
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("\nProbeer opnieuw.\n");
            e.printStackTrace();
        }
        return bestelling;
    }

    public ArrayList<Bestelling> getAllBestelling(){
        ArrayList<Bestelling> bestellingLijst = new ArrayList<Bestelling>();
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement stmt = con.prepareStatement("select * from Bestelling");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                //Bestelling bestelling = new Bestelling.BestellingBuilder().bestellingID(rs.getInt("bestelling_id")).klantID(rs.getInt("klant_id")).build();
                Bestelling bestelling = new Bestelling();
                bestelling.setBestellingID(rs.getInt("bestelling_id"));
                bestelling.setKlantID(rs.getInt("klant_id"));
                bestellingLijst.add(bestelling);
            }
        }
        catch(Exception e){
            System.out.println("\nProbeer opnieuw.\n");
            e.printStackTrace();
        }
        return bestellingLijst;
    }
    public ArrayList<Bestelling> getBestellingByKlantId(int klantId){
        ArrayList<Bestelling> bestellingLijst = new ArrayList<Bestelling>();
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement stmt = con.prepareStatement("select * from bestelling where klant_id = ?");
            stmt.setInt(1, klantId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){    
                // Er is iets met deze builder dat niet klopt, bestelling_id wordt wel goed mee gegeven maar klant_id niet
                // Bestelling bestelling = new Bestelling.BestellingBuilder().bestellingID(rs.getInt("bestelling_id")).klantID(rs.getInt("klant_id")).build();
                Bestelling bestelling = new Bestelling();
                bestelling.setBestellingID(rs.getInt("bestelling_id"));
                bestelling.setKlantID(rs.getInt("klant_id"));
                bestellingLijst.add(bestelling);
            }
        }
        catch(Exception e){
            System.out.println("\nProbeer opnieuw.\n");
            e.printStackTrace();
        }
        return bestellingLijst;
    }

    public void updateBestelling(Bestelling bestelling){
        String query =  "UPDATE Bestelling SET klant_id=? WHERE bestelling_id = ?;";

        try(Connection con = new DBConnector().getConnection();){
   
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setInt(1, bestelling.getKlantID());
            stmt.setInt(2, bestelling.getBestellingID());
            
            stmt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("\nProbeer opnieuw.\n");
            e.printStackTrace();
        }
    }
    
    public void updateBestellingPrijs(Bestelling bestelling){
        String query =  "UPDATE Bestelling SET totaal_prijs = ? WHERE bestelling_id = ?;";

        try(Connection con = new DBConnector().getConnection();){
   
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setBigDecimal(1, bestelling.getTotaalPrijs());
            stmt.setInt(2, bestelling.getBestellingID());
            
            stmt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("\nProbeer opnieuw.\n");
            e.printStackTrace();
        }
    }
    
    public void deleteBestelling(int bestelling_id){
        String sql = "DELETE FROM bestelling WHERE bestelling_id=?";
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, bestelling_id);
            stmt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("\nProbeer opnieuw.\n");
            e.printStackTrace();
        }
    }
}
