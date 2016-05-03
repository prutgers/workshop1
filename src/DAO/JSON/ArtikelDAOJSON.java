/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.JSON;

import POJO.Artikel;
import interfaceDAO.ArtikelDAO;
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
public class ArtikelDAOJSON implements ArtikelDAO {

    
    @Override
    public Artikel createArtikel(Artikel artikel) {
        JSONArray artikelList = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            artikelList = (JSONArray)parser.parse(new FileReader("c:/data/test.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
	} catch (IOException e) {
            e.printStackTrace();
	} catch (ParseException ex) {
            Logger.getLogger(ArtikelDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        JSONObject json = (JSONObject) artikelList.get(artikelList.size()-1);
        //vindt het hoogste artikel_id
        int artikel_id = (int)(long)json.get("artikel_id") + 1;
        //Create het nieuwe artikel dat is meegegeven aan public Artikel createArtikel
        JSONObject obj = new JSONObject();
        obj.put("artikel_id", artikel_id);
        obj.put("artikel_naam", artikel.getArtikel_naam());
        obj.put("artikel_prijs", artikel.getArtikel_prijs());
        obj.put("artikel_voorraad", artikel.getArtikel_voorraad());
        artikelList.add(obj);
	try {
            FileWriter file = new FileWriter("c:/data/test.json");
            file.write(artikelList.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
	}
        return artikel;
    }
    
    @Override
    public Artikel readArtikel(int artikel_id) {
        JSONArray artikelList = new JSONArray();
        JSONParser parser = new JSONParser();
        Artikel artikel = new Artikel();
         try {
            artikelList = (JSONArray)parser.parse(new FileReader("c:/data/test.json"));
             for(int i = 0; i< artikelList.size();i++){
                 JSONObject json = (JSONObject)artikelList.get(i);
                 if((int)(long)json.get("artikel_id") == artikel_id){
                    artikel.setArtikel_id((int)(long)json.get("artikel_id"));
                    artikel.setArtikel_naam((String)json.get("artikel_naam"));
                    artikel.setArtikel_prijs(new BigDecimal((long)json.get("artikel_prijs")));
                    artikel.setArtikel_voorraad((int)(long)json.get("artikel_voorraad"));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
	} catch (IOException e) {
            e.printStackTrace();
	} catch (ParseException ex) {
            Logger.getLogger(ArtikelDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        return artikel;
    }

    @Override
    public ArrayList<Artikel> readArtikel() {
        JSONParser parser = new JSONParser();
        ArrayList<Artikel> artikelLijst = new ArrayList();
        try {
            JSONArray list = (JSONArray)parser.parse(new FileReader("c:/data/test.json"));
            for(Object o : list) {
                JSONObject json = (JSONObject)o;
                Artikel artikel = new Artikel();
                artikel.setArtikel_id((int)(long)json.get("artikel_id"));
                artikel.setArtikel_naam((String)json.get("artikel_naam"));
                artikel.setArtikel_prijs(new BigDecimal((long)json.get("artikel_prijs")));
                artikel.setArtikel_voorraad((int)(long)json.get("artikel_voorraad"));
                artikelLijst.add(artikel);
            }
        } catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}
        return artikelLijst;
    }

    @Override
    public void DeleteArtikel(int artikel_id) {
        JSONArray artikelList = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            artikelList = (JSONArray)parser.parse(new FileReader("c:/data/test.json"));
            for(int i = 0; i< artikelList.size();i++){
                JSONObject json = (JSONObject)artikelList.get(i);
                if((int)(long)json.get("artikel_id") == artikel_id){
                    artikelList.remove(i);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
	} catch (IOException e) {
            e.printStackTrace();
	} catch (ParseException ex) {
            Logger.getLogger(ArtikelDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Schrijf de aangepaste Array weer naar JSON
        try {
            FileWriter file = new FileWriter("c:/data/test.json");
            file.write(artikelList.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
	}
    }

    @Override
    public void updateArtikel(Artikel artikel) {
       JSONArray artikelList = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            artikelList = (JSONArray)parser.parse(new FileReader("c:/data/test.json"));
            for(int i = 0; i< artikelList.size();i++){
                JSONObject json = (JSONObject)artikelList.get(i);
                if((int)(long)json.get("artikel_id") == artikel.getArtikel_id()){
                    json.put("artikel_naam", artikel.getArtikel_naam());
                    json.put("artikel_prijs", artikel.getArtikel_prijs());
                    json.put("artikel_voorraad", artikel.getArtikel_voorraad());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
	} catch (IOException e) {
            e.printStackTrace();
	} catch (ParseException ex) {
            Logger.getLogger(ArtikelDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Schrijf de aangepaste Array weer naar JSON
        try {
            FileWriter file = new FileWriter("c:/data/test.json");
            file.write(artikelList.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
	}
    }
}
