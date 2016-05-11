
package DAO.Firebird;


import ConnectionPools.*;
import POJO.Bestelling;
import interfaceDAO.BestellingDAO;
import java.sql.*;
import java.util.ArrayList;

public class BestellingDAOFirebird implements BestellingDAO {
    
    @Override
    public Bestelling createBestelling(Bestelling bestelling) {
        String query = "INSERT INTO Bestelling (klant_id) values (?) RETURNING bestelling_id";
        try(Connection connection = DBConnectorFirebird.getConnection();){
            PreparedStatement pstmt = connection.prepareStatement(query);
      
            pstmt.setInt(1, bestelling.getKlantID());

            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()){
                //wijs een door de database gegenereerd id toe aan bestelling
                bestelling.setBestellingID(resultSet.getInt("bestelling_id")); 
                
            }
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Probeer opnieuw.\n\n");
            e.printStackTrace();
        }
        return bestelling;
    }

    @Override
    public Bestelling getBestellingById(int BestellingId){
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
            System.out.println("Probeer opnieuw.\n\n");
            e.printStackTrace();
        }
        return bestelling;
    }

    @Override
    public ArrayList<Bestelling> getAllBestelling(){
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
            System.out.println("Probeer opnieuw.\n\n");
            e.printStackTrace();
        }
        return bestellingLijst;
    }
    @Override
    public ArrayList<Bestelling> getBestellingByKlantId(int klantId){
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
            System.out.println("Probeer opnieuw.\n\n");
            e.printStackTrace();
        }
        return bestellingLijst;
    }

    @Override
    public void updateBestelling(Bestelling bestelling){
        String query =  "UPDATE Bestelling SET klant_id=? WHERE bestelling_id = ?;";
    
        try(Connection con = new DBConnector().getConnection();){
   
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setInt(1, bestelling.getKlantID());
            stmt.setInt(2, bestelling.getBestellingID());
            
            stmt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Probeer opnieuw.\n\n");
            e.printStackTrace();
        }
    }
    
    @Override
    public void deleteBestelling(int bestelling_id){
        String sql = "DELETE FROM bestelling WHERE bestelling_id=?";
        try(Connection connection = DBConnectorFirebird.getConnection();){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, bestelling_id);
            stmt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException  e){
            System.out.println("Probeer opnieuw.\n\n");
            e.printStackTrace();
        }
    }
}
