
package DAO.Firebird;

import ConnectionPools.DBConnectorFirebird;
import ConnectionPools.DBConnector;
import ConnectionPools.*;
import POJO.Bestelling;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BestellingDAOFirebird {
    public static Bestelling createBestelling(Bestelling bestelling) {
        String query = "INSERT INTO Bestelling (klant_id) values (?) RETURNING bestelling_id";
        try(Connection connection = DBConnectorFirebird.getConnection();){
            PreparedStatement pstmt = connection.prepareStatement(query);
      
            pstmt.setInt(1, bestelling.getKlantID());

            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()){
                bestelling.setBestellingID(resultSet.getInt("bestelling_id")); //wijs door db gegenereerde id toe aan bestelling
            }
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("createBestelling error");
            e.printStackTrace();
        }
        return bestelling;
    }

    public static Bestelling getBestellingById(int BestellingId){
        Bestelling bestelling = new Bestelling();
        try(Connection connection = DBConnectorFirebird.getConnection();){
            PreparedStatement stmt = connection.prepareStatement("select * from Bestelling where bestelling_id = ?");
            stmt.setInt(1, BestellingId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                bestelling.setKlantID(rs.getInt("klant_id"));
                bestelling.setBestellingID(rs.getInt("bestelling_id"));
            }
        }
        catch(SQLException | ClassNotFoundException  e){
            e.printStackTrace();
        }
        return bestelling;
    }

    public static ArrayList<Bestelling> getAllBestelling(){
        ArrayList<Bestelling> bestellingLijst = new ArrayList<Bestelling>();
        try(Connection connection = DBConnectorFirebird.getConnection();){
            PreparedStatement stmt = connection.prepareStatement("select * from Bestelling");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Bestelling bestelling = new Bestelling();
                bestelling.setKlantID(rs.getInt("klant_id"));
                bestelling.setBestellingID(rs.getInt("bestelling_id"));
                bestellingLijst.add(bestelling);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return bestellingLijst;
    }
    public  static ArrayList<Bestelling> getBestellingByKlantId(int klantId){
        ArrayList<Bestelling> bestellingLijst = new ArrayList<Bestelling>();
        try(Connection connection = DBConnectorFirebird.getConnection();){
            PreparedStatement stmt = connection.prepareStatement("select * from bestelling where klant_id = ?");
            stmt.setInt(1, klantId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Bestelling bestelling = new Bestelling();
                
                bestelling.setKlantID(rs.getInt("klant_id"));
                bestelling.setBestellingID(rs.getInt("bestelling_id"));
                
                bestellingLijst.add(bestelling);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return bestellingLijst;
    }

    public static void updateBestelling(Bestelling bestelling){
        String query =  "UPDATE Bestelling SET klant_id=? WHERE bestelling_id = ?;";
    
        try(Connection con = new DBConnector().getConnection();){
   
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setInt(1, bestelling.getKlantID());
            stmt.setInt(2, bestelling.getBestellingID());
            
            stmt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException  e){
            e.printStackTrace();
        }
    }
    
    public static void deleteBestelling(int bestelling_id){
        String sql = "DELETE FROM bestelling WHERE bestelling_id=?";
        try(Connection connection = DBConnectorFirebird.getConnection();){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, bestelling_id);
            stmt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException  e){
            e.printStackTrace();
        }
    }
}
