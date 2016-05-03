/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.JSON;

/**
 *
 * @author lucas
 */

import interfaceDAO.KlantDAO;
import java.util.ArrayList;
import POJO.Klant;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileWriter;

public class KlantDAOJSON implements KlantDAO{
    static Logger logger = LoggerFactory.getLogger(KlantDAOJSON.class);
 
    private String fileLocation = "c:/data/json/klant.json";
    
    @Override
    public Klant createKlant(Klant klant){
        boolean klantAlreadyInDB = false;        
        JSONArray klantLijst = this.readFile();
        
        //check for dubs!
        for(Object o : klantLijst) {
            JSONObject klantJson = (JSONObject)o;
            if (   (
                    klant.getKlant_id() == 0 ||
                    klant.getKlant_id() == (int)(long)klantJson.get("klant_id")
                    ) || ( (
                            klant.getVoornaam().equals( (String)klantJson.get("voornaam") )
                            ) && (
                            klant.getAchternaam().equals( (String)klantJson.get("achternaam") )
                            ) && (
                            klant.getTussenvoegsel().equals( (String)klantJson.get("tussenvoegsel") )
                            ) )
                  ) {
                    klantAlreadyInDB = true;
                    System.out.print("Klant staat al in Database");
                    break;
                }
        }
        
        //Schrijf de klant in de JSONArray
        if (!klantAlreadyInDB){
            
            //vind hoogste klant_id ; moet eigelijk met Collections.max(JSONObject) maar dat duurt veel te lang
            JSONObject lastKlant = (JSONObject)klantLijst.get( klantLijst.size()-1 );
            int klant_id = (int)(long)lastKlant.get("klant_id")+1;
            klant.setKlant_id(klant_id);
            
            // Converteer klant naar JSONObject en voeg toe aan JSONArray
            JSONObject obj = new JSONObject();
            obj.put("klant_id", klant.getKlant_id());
            obj.put("voornaam", klant.getVoornaam());
            obj.put("achternaam", klant.getAchternaam());
            obj.put("tussenvoegsel", klant.getTussenvoegsel());
            obj.put("email", klant.getEmail());
            klantLijst.add(obj);
        }
        
        //sla JSONArray op
        this.JSONArrayToJSONFile( klantLijst );
        
        return klant;        
    }
    
    @Override
    public Klant readKlant(int klant_id){
        Klant outputKlant = new Klant();
        boolean klantFound = false;
        
        JSONArray klantLijst = this.readFile();
        for(Object o : klantLijst) {
            JSONObject klantJson = (JSONObject)o;
            if (   (
                    klant_id == 0 ||
                    klant_id == (int)(long)klantJson.get("klant_id")
                    )
                 ){
                outputKlant.setVoornaam((String)klantJson.get("voornaam"));
                outputKlant.setAchternaam((String)klantJson.get("achternaam"));
                outputKlant.setTussenvoegsel((String)klantJson.get("tussenvoegsel"));
                outputKlant.setEmail((String)klantJson.get("email"));
                klantFound = true;
                break;
            }
        }
        if (klantFound == false){
            System.out.print("Geen klant gevonden!");
        }
        
        return outputKlant;
    }
    
    @Override
    public Klant updateKlant(Klant klant){  
        JSONArray klantLijst = this.readFile();
        
        //vind de klant
        for(Object o : klantLijst) {
            JSONObject klantJsonObj = (JSONObject)o;
            if (klant.getKlant_id() == (int)(long)klantJsonObj.get("klant_id")
                  ){
                //klant gevonden; updaten
                klantJsonObj.put("klant_id", klant.getKlant_id());
                klantJsonObj.put("voornaam", klant.getVoornaam());
                klantJsonObj.put("achternaam", klant.getAchternaam());
                klantJsonObj.put("tussenvoegsel", klant.getTussenvoegsel());
                klantJsonObj.put("email", klant.getEmail());
            }
        }
        
        //sla JSONArray op
        this.JSONArrayToJSONFile( klantLijst );
        
        return klant; 
    }
    
    @Override
    public void deleteKlant(int klant_id){
        JSONArray klantLijst = this.readFile();
        for(Object o : klantLijst) {
            JSONObject klantJson = (JSONObject)o;
            if (   (
                    klant_id == 0 ||
                    klant_id == (int)klantJson.get("klant_id")
                    )
                 ){
                    klantLijst.remove(o); 
                    break;
                }
        }
        //coverteer allKlant naar JSON en sla die op
        this.JSONArrayToJSONFile( klantLijst );
        
    }
    
    @Override
    public ArrayList<Klant> readAllKlantByKlant(Klant klant){
        ArrayList<Klant> klantLijst = new ArrayList();
        int i = 0;
        JSONArray list = this.readFile();
        for(Object o : list) {
            JSONObject klantJson = (JSONObject)o;
            if (    (
                    klant.getKlant_id() == 0 ||
                    klant.getKlant_id() == (int)(long)klantJson.get("klant_id")
                    ) && (
                    klant.getVoornaam() == null ||
                    klant.getVoornaam().equals( (String)klantJson.get("voornaam") )
                    ) && (
                    klant.getAchternaam() == null ||
                    klant.getAchternaam().equals( (String)klantJson.get("achternaam") )
                    ) && (
                    klant.getTussenvoegsel() == null ||
                    klant.getTussenvoegsel().equals( (String)klantJson.get("tussenvoegsel") )
                    ) && (
                    klant.getEmail() == null ||
                    klant.getEmail().equals( (String)klantJson.get("email") )
                    )
                 ){
                Klant outputKlant = new Klant();
                outputKlant.setKlant_id((int)(long)klantJson.get("klant_id"));
                outputKlant.setVoornaam((String)klantJson.get("voornaam"));
                outputKlant.setAchternaam((String)klantJson.get("achternaam"));
                outputKlant.setTussenvoegsel((String)klantJson.get("tussenvoegsel"));
                outputKlant.setEmail((String)klantJson.get("email"));
                i++;
                klantLijst.add(outputKlant);
                }
            }
        System.out.println("" + i +" Klants matched this inquiry.");
        return klantLijst;
    }
    
//    private JSONArray outputToJSONArray(ArrayList<Klant> allKlant){
//	JSONArray klantJSONArray = new JSONArray();
//        for (Klant o : allKlant){
//            JSONObject obj = new JSONObject();
//            obj.put("klant_id", o.getKlant_id());
//            obj.put("voornaam", o.getVoornaam());
//            obj.put("achternaam", o.getAchternaam());
//            obj.put("tussenvoegsel", o.getTussenvoegsel());
//            obj.put("email", o.getEmail());
//            klantJSONArray.add(obj);
//        }
//        return klantJSONArray;
//    }
    
    private JSONArray readFile(){
        JSONParser parser = new JSONParser();
        JSONArray list;
        try {
            list = (JSONArray)parser.parse(new FileReader(fileLocation));
        }
        catch (IOException ex){
            logger.error("Input/Output Exception!");
            ex.printStackTrace();
            list = null;
        }
        catch (ParseException ex){
            logger.error("Parse Exception!");
            ex.printStackTrace();
            list = null;
        }
        return list;
    }
    
    private void JSONArrayToJSONFile(JSONArray klantList){
	try {
            FileWriter file = new FileWriter(fileLocation);
            file.write(klantList.toJSONString());
            file.flush();
            file.close();

	} catch (IOException e) {
            e.printStackTrace();
	}
    }
}
