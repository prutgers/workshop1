/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.JSON;

import POJO.Artikel;
import POJO.BestellingArtikel;
import interfaceDAO.BestellingArtikelDAO;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Peter
 */
public class BestellingArtikelDAOJSON implements BestellingArtikelDAO {
    private final String filePath = "c:/data/json/bestellingartikel.json";

    
    @Override
    public void createKoppelBestellingArtikel(BestellingArtikel bestellingArtikel) {
        JSONArray artikelList = new JSONArray();
        JSONParser parser = new JSONParser();
        
      //  File file = new File("c:/data/json/artikel.json");
     //   System.out.println("file exixsts " + file.exists());
        try {
            artikelList = (JSONArray)parser.parse(new FileReader(filePath));
        } catch (FileNotFoundException e) {
	} catch (IOException e) {
	} catch (ParseException ex) {
            Logger.getLogger(ArtikelDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Create het nieuwe artikel dat is meegegeven aan public Artikel createArtikel
        JSONObject obj = new JSONObject();
        obj.put("bestelling_id", bestellingArtikel.getBestelling_id());
        obj.put("artikel_id", bestellingArtikel.getArtikel_id());
        obj.put("artikel_aantal", bestellingArtikel.getAantal());
        
	try {
            FileWriter file = new FileWriter(filePath);
            file.write(artikelList.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
	}
    }

    @Override
    public ArrayList<BestellingArtikel> readKoppelMetBestellingID(int bestelling_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<BestellingArtikel> readKoppelMetArtikelID(int artikel_id) {
        JSONParser parser = new JSONParser();
        ArrayList<BestellingArtikel> koppelLijst = new ArrayList();
        try {
            JSONArray list = (JSONArray)parser.parse(new FileReader(filePath));
            for(Object o : list) {
                JSONObject json = (JSONObject)o;
                BestellingArtikel koppel = new BestellingArtikel();
                koppel.setBestelling_id((int)(long)json.get("bestelling_id"));
                koppel.setArtikel_id((int)(long)json.get("artikel_id"));
                koppel.setAantal((int)(long)json.get("artikel_aantal"));
                koppelLijst.add(koppel);
            }
        } catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}
        return koppelLijst;
    }

    @Override
    public BestellingArtikel readKoppel(int bestelling_id, int artikel_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteKoppelMetBestellingID(int bestelling_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteKoppelMetArtikelID(int artikel_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteKoppel(int bestellingID, int artikelID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BestellingArtikel readKoppelById(int koppelID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateKoppel(BestellingArtikel koppel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
