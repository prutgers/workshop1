/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.JSON;

import ConnectionPools.DBConnector;
import ConnectionPools.*;
import POJO.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author Gebruiker
 */

public class BestellingDAOJSON {
    public static Bestelling createBestelling(Bestelling bestelling) {
        JSONParser parser = new JSONParser();
        try {
            //get current data in JSONArray
            JSONArray list = (JSONArray)parser.parse(new FileReader("c:/data/json/bestellingen.json"));

            //get highest id
            JSONObject json = (JSONObject)list.get(list.size()-1);
            int bestellingID = (int)(long)json.get("bestelling_id");

            //create newe JSONObject
            JSONObject obj = new JSONObject();
            obj.put("bestelling_id", bestellingID+1);
            obj.put("klant_id", bestelling.getKlantID());     

            //add new JSONObject to JSONArray
            list.add(obj);

            //write updated JSONArray to file
            FileWriter file = new FileWriter("c:/data/json/bestellingen.json");
            file.write(list.toJSONString());
            file.flush();
            file.close();
	} 
        catch (IOException e) {
            e.printStackTrace();
	}
        catch (ParseException e) {
            e.printStackTrace();
	}
        return bestelling;
    }
    
    public static Bestelling getBestellingById(int BestellingId){
        JSONParser parser = new JSONParser();
        Bestelling bestelling = new Bestelling();
        try{
            //get current data in JSONArray
            JSONArray list = (JSONArray)parser.parse(new FileReader("c:/data/json/bestellingen.json"));

            //get JSONObject by Id
            JSONObject json = (JSONObject)list.get(BestellingId);
           //set bestelling Object with JSONObject
            bestelling.setBestellingID((int)(long)json.get("bestelling_id"));
            bestelling.setKlantID((int)(long)json.get("klant_id"));
            
            FileWriter file = new FileWriter("c:/data/json/bestellingen.json");
            file.write(list.toJSONString());
            file.flush();
            file.close();
        }
        catch (IOException e) {
            e.printStackTrace();
	}
        catch (ParseException e) {
            e.printStackTrace();
	}
        return bestelling;
    }

    public static ArrayList<Bestelling> getAllBestelling(){
        JSONParser parser = new JSONParser();
        ArrayList<Bestelling> bestellingLijst = new ArrayList();
	try {
             //get current data in JSONArray
            JSONArray list = (JSONArray)parser.parse(new FileReader("c:/data/json/bestellingen.json"));
            for(Object o : list) {
                JSONObject json = (JSONObject)o;
                Bestelling bestelling = new Bestelling();
                bestelling.setBestellingID((int)(long)json.get("bestelling_id"));
                bestelling.setKlantID((int)(long)json.get("klant_id"));
                bestellingLijst.add(bestelling);
            }
            FileWriter file = new FileWriter("c:/data/json/bestellingen.json");
            file.write(list.toJSONString());
            file.flush();
            file.close();
	} 
        catch (FileNotFoundException e) {
		e.printStackTrace();
	} 
        catch (IOException | ParseException e) {
		e.printStackTrace();
	}
        return bestellingLijst;
    }
    
    public  static ArrayList<Bestelling> getBestellingByKlantId(int klantID){
        JSONParser parser = new JSONParser();
        ArrayList<Bestelling> bestellingLijst = new ArrayList();
	try {
             //get current data in JSONArray
            JSONArray list = (JSONArray)parser.parse(new FileReader("c:/data/json/bestellingen.json"));
            for(Object o : list) {
                JSONObject json = (JSONObject)o;
                Bestelling bestelling = new Bestelling();
                
                int tempBestellingID = ((int)(long)json.get("bestelling_id"));
                int tempKlantID = ((int)(long)json.get("klant_id"));
                
                if(klantID == tempKlantID){
                    bestelling.setBestellingID(tempBestellingID);
                    bestelling.setKlantID(tempKlantID);
                    bestellingLijst.add(bestelling);
                }
            }
            FileWriter file = new FileWriter("c:/data/json/bestellingen.json");
            file.write(list.toJSONString());
            file.flush();
            file.close();
	} 
        catch (FileNotFoundException e) {
		e.printStackTrace();
	} 
        catch (IOException | ParseException e) {
		e.printStackTrace();
	}
        return bestellingLijst;
    }

    public static void updateBestelling(Bestelling bestelling){
        JSONParser parser = new JSONParser();
        try {
            //get current data in JSONArray
            JSONArray list = (JSONArray)parser.parse(new FileReader("c:/data/json/bestellingen.json"));

            for(Object obj : list) {
                JSONObject json = (JSONObject)obj;
                int bestellingID = (int)(long)json.get("bestelling_id");   
                if(bestellingID == bestelling.getBestellingID()){
                    json.put("klant_id", bestelling.getKlantID());
                }
            }
            //write updated JSONArray to file
            FileWriter file = new FileWriter("c:/data/json/bestellingen.json");
            file.write(list.toJSONString());
            file.flush();
            file.close();
	} 
        catch (IOException e) {
            e.printStackTrace();
	}
        catch (ParseException e) {
            e.printStackTrace();
	}
    }
    
    public static void deleteBestelling(int bestellingID){
        JSONParser parser = new JSONParser();
        try {
            //get current data in JSONArray
            JSONArray list = (JSONArray)parser.parse(new FileReader("c:/data/json/bestellingen.json"));
            for(Object obj : list) {
                JSONObject json = (JSONObject)obj;
                int tempestellingID = (int)(long)json.get("bestelling_id");   
                if(tempestellingID == bestellingID){
                    list.remove(obj);
                }
            }
            //write updated JSONArray to file
            FileWriter file = new FileWriter("c:/data/json/bestellingen.json");
            file.write(list.toJSONString());
            file.flush();
            file.close();
	} 
        catch (IOException e) {
            e.printStackTrace();
	}
        catch (ParseException e) {
            e.printStackTrace();
	}
    }
}
