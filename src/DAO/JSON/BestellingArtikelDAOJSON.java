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
        //Haal de JSONFile op
        JSONArray koppel = this.readFromFile();
        //Create het nieuwe artikel dat is meegegeven aan public Artikel createArtikel
        JSONObject obj = new JSONObject();
        obj.put("bestelling_id", bestellingArtikel.getBestelling_id());
        obj.put("artikel_id", bestellingArtikel.getArtikel_id());
        obj.put("artikel_aantal", bestellingArtikel.getAantal());
        koppel.add(obj);
        //Schrijf de geupdate JSON file weg
        this.writeToFile(koppel);
	}

    @Override
    public ArrayList<BestellingArtikel> readKoppelMetBestellingID(int bestelling_id) {
        ArrayList<BestellingArtikel> koppelLijst = new ArrayList();
        JSONArray list = this.readFromFile();
        for(Object o : list) {
            JSONObject json = (JSONObject)o;
            if(bestelling_id == (int)(long)json.get("bestelling_id")){
                BestellingArtikel koppel = new BestellingArtikel();
                koppel.setBestelling_id((int)(long)json.get("bestelling_id"));
                koppel.setArtikel_id((int)(long)json.get("artikel_id"));
                koppel.setAantal((int)(long)json.get("artikel_aantal"));
                koppelLijst.add(koppel);
            }
        }
        return koppelLijst;
    }

    @Override
    public ArrayList<BestellingArtikel> readKoppelMetArtikelID(int artikel_id) {
        ArrayList<BestellingArtikel> koppelLijst = new ArrayList();
        JSONArray list = this.readFromFile();
        for(Object o : list) {
            JSONObject json = (JSONObject)o;
            if(artikel_id == (int)(long)json.get("artikel_id")){
                BestellingArtikel koppel = new BestellingArtikel();
                koppel.setBestelling_id((int)(long)json.get("bestelling_id"));
                koppel.setArtikel_id((int)(long)json.get("artikel_id"));
                koppel.setAantal((int)(long)json.get("artikel_aantal"));
                koppelLijst.add(koppel);
            }
        }
        return koppelLijst;
    }

    @Override
    public BestellingArtikel readKoppel(int bestelling_id, int artikel_id) {
        BestellingArtikel bestellingArtikel = new BestellingArtikel();
        JSONArray list = this.readFromFile();
        for(Object o : list) {
            JSONObject json = (JSONObject)o;
            if((bestelling_id == (int)(long)json.get("bestelling_id")) && (artikel_id == (int)(long)json.get("artikel_id"))) {
                bestellingArtikel.setBestelling_id((int)(long)json.get("bestelling_id"));
                bestellingArtikel.setArtikel_id((int)(long)json.get("artikel_id"));
                bestellingArtikel.setAantal((int)(long)json.get("artikel_aantal"));
                
            }
        }
        return bestellingArtikel;
    }

    @Override
    public void deleteKoppelMetBestellingID(int bestelling_id) {
        JSONArray koppelList = this.readFromFile();
        if(!koppelList.isEmpty()){
            for(int i = 0; i< koppelList.size();i++){
                JSONObject json = (JSONObject)koppelList.get(i);
                if((int)(long)json.get("bestelling_id") == bestelling_id){
                    koppelList.remove(i);
                    i--;
                }
            }
        }
        this.writeToFile(koppelList);
    }

    @Override
    public void deleteKoppelMetArtikelID(int artikel_id) {
       JSONArray koppelList = this.readFromFile();
        if(!koppelList.isEmpty()){
            for(int i = 0; i< koppelList.size();i++){
                JSONObject json = (JSONObject)koppelList.get(i);
                if((int)(long)json.get("artikel_id") == artikel_id){
                    koppelList.remove(i);
                    i--;
                }
            }
        }
        this.writeToFile(koppelList);
    }

    @Override
    public void deleteKoppel(int bestellingID, int artikelID) {
       JSONArray koppelList = this.readFromFile();
        if(!koppelList.isEmpty()){
            for(int i = 0; i< koppelList.size();i++){
                JSONObject json = (JSONObject)koppelList.get(i);
                if(((int)(long)json.get("artikel_id") == artikelID) && ((int)(long)json.get("bestelling_id") == bestellingID))  {
                    koppelList.remove(i);
                    i--;
                }
            }
        }
        this.writeToFile(koppelList);
    }

    @Override
    public void updateKoppel(BestellingArtikel koppel) {
       
       JSONArray koppelList = this.readFromFile();
        if(!koppelList.isEmpty()){
            for(int i = 0; i< koppelList.size();i++){
                JSONObject json = (JSONObject)koppelList.get(i);
                if(((int)(long)json.get("artikel_id") == koppel.getArtikel_id()) && ((int)(long)json.get("bestelling_id") == koppel.getBestelling_id()))  {
                    json.put("artikel_aantal", koppel.getAantal());
                }
            }
        }
        this.writeToFile(koppelList);
    }
    
    private JSONArray readFromFile(){
        JSONArray jsonArray = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            jsonArray = (JSONArray)parser.parse(new FileReader(filePath));
        } catch (FileNotFoundException e) {
	} catch (IOException e) {
	} catch (ParseException ex) {
            Logger.getLogger(ArtikelDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonArray;
    }
    
    private void writeToFile(JSONArray jsonArray){
         try {
            FileWriter file = new FileWriter(filePath);
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
	}
    }
    
    
    //wordt niet meer gebruikt
    @Override
    public BestellingArtikel readKoppelById(int koppelID) {
        //wordt niet meer gebruikt als het goed is
        System.out.println("Ik ben een niet werkende methode");
        return new BestellingArtikel();
    }
    
}
