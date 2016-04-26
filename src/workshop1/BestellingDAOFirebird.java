
package workshop1;

import ConnectionPools.DBConnectorFirebird;
import ConnectionPools.DBConnector;
import ConnectionPools.*;
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
    
    
    
    
    
    
    
    
    private static void rsToBestelling(ResultSet rs, Bestelling bestelling){
        try{
            bestelling.setKlantID(rs.getInt("klant_id"));
            bestelling.setBestellingID(rs.getInt("bestelling_id"));
            
            bestelling.setArtikelID_1(rs.getInt("artikel_id1"));
            bestelling.setArtikelID_2(rs.getInt("artikel_id2"));
            bestelling.setArtikelID_3(rs.getInt("artikel_id3"));
            bestelling.setArtikelNaam_1(rs.getString("artikel_naam1"));
            bestelling.setArtikelNaam_2(rs.getString("artikel_naam2"));
            bestelling.setArtikelNaam_3(rs.getString("artikel_naam3"));
            bestelling.setArtikelAantal_1(rs.getInt("artikel_aantal1"));
            bestelling.setArtikelAantal_2(rs.getInt("artikel_aantal2"));
            bestelling.setArtikelAantal_3(rs.getInt("artikel_aantal3"));
            bestelling.setArtikelPrijs_1(rs.getDouble("artikel_prijs1"));
            bestelling.setArtikelPrijs_2(rs.getDouble("artikel_prijs2"));
            bestelling.setArtikelPrijs_3(rs.getDouble("artikel_prijs3"));
            
         }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    private static void setStatement(PreparedStatement stmt, Bestelling bestelling) throws SQLException{
            stmt.setInt(1, bestelling.getKlantID());

            stmt.setInt(2, bestelling.getArtikelID_1());
            stmt.setDouble(3, bestelling.getArtikelPrijs_1());
            stmt.setString(4, bestelling.getArtikelNaam_1());            
            stmt.setInt(5, bestelling.getArtikelAantal_1());   

            stmt.setInt(6, bestelling.getArtikelID_2());
            stmt.setDouble(7, bestelling.getArtikelPrijs_2());
            stmt.setString(8, bestelling.getArtikelNaam_2());            
            stmt.setInt(9, bestelling.getArtikelAantal_2());   

            stmt.setInt(10, bestelling.getArtikelID_3());
            stmt.setDouble(11, bestelling.getArtikelPrijs_3());
            stmt.setString(12, bestelling.getArtikelNaam_3());            
            stmt.setInt(13, bestelling.getArtikelAantal_3());      
            
    }
}
