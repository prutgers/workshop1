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
        
                
        //Haal de huidige lijst van artikel op uit het JSON bestand en stop al deze 
        // artikelen in een array okey dat is misschien waar dus dan moet je het hier hndmatig doen 
        
        ArrayList<Artikel> artikelLijst = readArtikel();
        for(Artikel a: artikelLijst){
            JSONObject oudArtikel = new JSONObject();
            oudArtikel.put("artikel_id", a.getArtikel_id());
            oudArtikel.put("artikel_naam", a.getArtikel_naam());
            oudArtikel.put("artikel_prijs", a.getArtikel_prijs());
            oudArtikel.put("artikel_voorraad", a.getArtikel_voorraad());
            artikelList.add(oudArtikel);
        }
        
        
        //vindt het hoogste artikel_id
        int artikel_id = artikelLijst.get(artikelLijst.size()-1).getArtikel_id() + 1;
        artikel.setArtikel_id(artikel_id);
        
        //Create het niet artikel dat is meegegeven aan public Artikel createArtikel
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateArtikel(Artikel artikel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
