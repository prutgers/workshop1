/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.JSON;

import POJO.*;
import interfaceDAO.BestellingDAO;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author Gebruiker
 */
public class BestellingDAOJSON implements BestellingDAO{
    @Override
    public Bestelling createBestelling(Bestelling bestelling) {
        JSONArray list;
        JSONParser parser = new JSONParser();
        File file = new File("c:/data/json/bestellingen.json");
        int bestellingID;
        try {
            if(file.exists()){
                list = (JSONArray)parser.parse(new FileReader("c:/data/json/bestellingen.json"));
                JSONObject json = (JSONObject)list.get(list.size()-1);
                bestellingID = (int)(long)json.get("bestelling_id");
            }
            else{
                list= new JSONArray();
                bestellingID = 1;
            }
            //create newe JSONObject
            JSONObject obj = new JSONObject();
            obj.put("bestelling_id", bestellingID+1);
            obj.put("klant_id", bestelling.getKlantID());     

            //add new JSONObject to JSONArray
            list.add(obj);

            //write updated JSONArray to file
            FileWriter fileWriter = new FileWriter("c:/data/json/bestellingen.json");
            fileWriter.write(list.toJSONString());
            fileWriter.flush();
            fileWriter.close();
	} 
        catch (IOException | ParseException e) {
            e.printStackTrace();
	}
        return bestelling;
    }
    
    @Override
    public Bestelling getBestellingById(int bestellingID){
        JSONArray list = new JSONArray();
        JSONParser parser = new JSONParser();
        Bestelling bestelling = new Bestelling();
        File file = new File("c:/data/json/bestellingen.json");
        try{
            if(file.exists()){
                list = (JSONArray)parser.parse(new FileReader("c:/data/json/bestellingen.json"));
            }
            else{
                System.out.println("Er is nog geen data");
                System.exit(1);
            }     
            //get JSONObject by Id
            for(Object o : list){
                JSONObject json = (JSONObject)o;
                int tempBestellingID = ((int)(long)json.get("bestelling_id"));
                int tempKlantID = ((int)(long)json.get("klant_id"));
                
                if(bestellingID == tempBestellingID){
                    bestelling.setBestellingID(tempBestellingID);
                    bestelling.setKlantID(tempKlantID);
                }
            }
            FileWriter fileWriter = new FileWriter("c:/data/json/bestellingen.json");
            fileWriter.write(list.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
	}
        return bestelling;
    }

    @Override
    public ArrayList<Bestelling> getAllBestelling(){
        JSONParser parser = new JSONParser();
        JSONArray list = new JSONArray();
        File file = new File("c:/data/json/bestellingen.json");
        ArrayList<Bestelling> bestellingLijst = new ArrayList();
	try {
            if(file.exists()){
                list = (JSONArray)parser.parse(new FileReader("c:/data/json/bestellingen.json"));
            }
            else{
                System.out.println("Er is nog geen data");
                System.exit(1);
            }    

            list = (JSONArray)parser.parse(new FileReader("c:/data/json/bestellingen.json"));
            for(Object o : list) {
                JSONObject json = (JSONObject)o;
                Bestelling bestelling = new Bestelling();
                bestelling.setBestellingID((int)(long)json.get("bestelling_id"));
                bestelling.setKlantID((int)(long)json.get("klant_id"));
                bestellingLijst.add(bestelling);
            }
            FileWriter fileWriter = new FileWriter("c:/data/json/bestellingen.json");
            fileWriter.write(list.toJSONString());
            fileWriter.flush();
            fileWriter.close();
	} 
        catch (IOException | ParseException e) {
            e.printStackTrace();
	}
        return bestellingLijst;
    }
    
    @Override
    public ArrayList<Bestelling> getBestellingByKlantId(int klantID){
        JSONParser parser = new JSONParser();
        JSONArray list = new JSONArray();
        File file = new File("c:/data/json/bestellingen.json");
        ArrayList<Bestelling> bestellingLijst = new ArrayList();
	try {
            if(file.exists()){
                list = (JSONArray)parser.parse(new FileReader("c:/data/json/bestellingen.json"));
            }
            else{
                System.out.println("Er is nog geen data");
                System.exit(1);
            }  
             //get current data in JSONArray
            list = (JSONArray)parser.parse(new FileReader("c:/data/json/bestellingen.json"));
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
            FileWriter fileWriter = new FileWriter("c:/data/json/bestellingen.json");
            fileWriter.write(list.toJSONString());
            fileWriter.flush();
            fileWriter.close();
	} 
        catch (IOException | ParseException e) {
            e.printStackTrace();
	}
        return bestellingLijst;
    }

    @Override
    public void updateBestelling(Bestelling bestelling){
        JSONParser parser = new JSONParser();
        JSONArray list = new JSONArray();
        File file = new File("c:/data/json/bestellingen.json");
        try {
            if(file.exists()){
                list = (JSONArray)parser.parse(new FileReader("c:/data/json/bestellingen.json"));
            }
            else{
                System.out.println("Er is nog geen data");
                System.exit(1);
            }  
            //get current data in JSONArray
            list = (JSONArray)parser.parse(new FileReader("c:/data/json/bestellingen.json"));

            for(Object obj : list) {
                JSONObject json = (JSONObject)obj;
                int bestellingID = (int)(long)json.get("bestelling_id");   
                if(bestellingID == bestelling.getBestellingID()){
                    json.put("klant_id", bestelling.getKlantID());
                }
            }
            //write updated JSONArray to file
            FileWriter fileWriter = new FileWriter("c:/data/json/bestellingen.json");
            fileWriter.write(list.toJSONString());
            fileWriter.flush();
            fileWriter.close();
	} 
        catch (IOException | ParseException e) {
            e.printStackTrace();
	}
    }
    
    @Override
    public void deleteBestelling(int bestellingID){
        JSONArray list = new JSONArray();
        File file = new File("c:/data/json/bestellingen.json");
        JSONParser parser = new JSONParser();
        try {
            if(file.exists()){
                list = (JSONArray)parser.parse(new FileReader("c:/data/json/bestellingen.json"));
            }
            else{
                System.out.println("Er is nog geen data");
                System.exit(1);
            } 
            //get current data in JSONArray
            list = (JSONArray)parser.parse(new FileReader("c:/data/json/bestellingen.json"));
            for(int i = 0; i< list.size();i++){
                JSONObject json = (JSONObject)list.get(i);
                int tempestellingID = (int)(long)json.get("bestelling_id");   
                if(tempestellingID == bestellingID){
                    list.remove(i);
                }
            }
            FileWriter fileWriter = new FileWriter("c:/data/json/bestellingen.json");
            fileWriter.write(list.toJSONString());
            fileWriter.flush();
	}         
        catch (IOException | ParseException e) {
            e.printStackTrace();
	}
    }
}
