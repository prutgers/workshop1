
package workshop1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BestellingDAO {
    public void createBestelling(Bestelling bestelling) {

        String query = "INSERT into Bestelling ("
                    + "klant_id, artikel_id1, artikel_id2, artikel_id3,"
                    + "artikel_aantal1, artikel_aantal2, artikel_aantal3, "
                    + "artikel_naam1, artikel_naam2, artikel_naam3) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection con = new DBConnector().getConnection();){
        
            PreparedStatement stmt = con.prepareStatement(query);

            //Set values for INSERT-part of the statement
            setStatement(stmt,bestelling);

            stmt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException  e){
            e.printStackTrace();
        }
    }

    public Bestelling getBestellingById(int BestellingId){
        //Class.forName("com.mysql.jdbc.Driver");
        Bestelling bestelling = new Bestelling();
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement stmt = con.prepareStatement("select * from Bestelling where bestelling_id = ?");
            stmt.setInt(1, BestellingId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                rsToBestelling(rs,bestelling);
            }
        }
        catch(SQLException | ClassNotFoundException  e){
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
                Bestelling bestelling = new Bestelling();
                rsToBestelling(rs,bestelling);
                bestellingLijst.add(bestelling);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return bestellingLijst;
    }
    public  ArrayList<Bestelling> getBestellingByKlantId(int klantId){
        ArrayList<Bestelling> bestellingLijst = new ArrayList<Bestelling>();
        try(Connection con = new DBConnector().getConnection();){
            PreparedStatement stmt = con.prepareStatement("select * from bestelling where klant_id = ?");
            stmt.setInt(1, klantId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Bestelling bestelling = new Bestelling();
                rsToBestelling(rs,bestelling);
                bestellingLijst.add(bestelling);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return bestellingLijst;
    }

    public void updateBestelling(Bestelling bestelling){
                String query = "Update Bestelling SET "
                    + "klant_id =?, artikel_id1=?, artikel_id2=?, artikel_id3=?,"
                    + "artikel_aantal1=?, artikel_aantal2=?, artikel_aantal3=?, "
                    + "artikel_naam1=?, artikel_naam2=?, artikel_naam3=? "
                    + "WHERE bestelling_id = ?";
        
        try(Connection con = new DBConnector().getConnection();){
        
            PreparedStatement stmt = con.prepareStatement(query);
            
            //Set values for SET-part of the statement
            setStatement(stmt,bestelling);
            
            //Set valuis for WHERE-part of the statement
            stmt.setInt(11, bestelling.getBestellingID());
            
            stmt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException  e){
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
            e.printStackTrace();
        } 
    }
    
    public void rsToBestelling(ResultSet rs, Bestelling bestelling){
        try{
            bestelling.setKlantID(rs.getInt("klant_id"));
            bestelling.setBestellingID(rs.getInt("bestelling_id"));
            bestelling.setArtikelAantal_1(rs.getInt("artikel_id1"));
            bestelling.setArtikelAantal_2(rs.getInt("artikel_id2"));
            bestelling.setArtikelAantal_3(rs.getInt("artikel_id3"));
            bestelling.setArtikelNaam_1(rs.getString("artikel_naam1"));
            bestelling.setArtikelNaam_2(rs.getString("artikel_naam2"));
            bestelling.setArtikelNaam_3(rs.getString("artikel_naam3"));
            bestelling.setArtikelAantal_1(rs.getInt("artikel_aantal1"));
            bestelling.setArtikelAantal_2(rs.getInt("artikel_aantal2"));
            bestelling.setArtikelAantal_3(rs.getInt("artikel_aantal3"));
            bestelling.setArtikelPrijs_1(rs.getInt("artikel_prijs1"));
            bestelling.setArtikelPrijs_2(rs.getInt("artikel_prijs2"));
            bestelling.setArtikelPrijs_3(rs.getInt("artikel_prijs3"));
         }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    private void setStatement(PreparedStatement stmt, Bestelling bestelling) throws SQLException{
        stmt.setInt(1, bestelling.getKlantID());
        stmt.setInt(2, bestelling.getArtikelID_1());
        stmt.setInt(3, bestelling.getArtikelID_2());
        stmt.setInt(4, bestelling.getArtikelID_3());
        stmt.setDouble(5, bestelling.getArtikelPrijs_1());
        stmt.setDouble(6, bestelling.getArtikelPrijs_2());
        stmt.setDouble(7, bestelling.getArtikelPrijs_3());
        stmt.setString(8, bestelling.getArtikelNaam_1());
        stmt.setString(9, bestelling.getArtikelNaam_2());
        stmt.setString(10, bestelling.getArtikelNaam_3());            
    }
}
