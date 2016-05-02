/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.JSON;

import POJO.Artikel;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Boolean.TRUE;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimpleExampleReaderHJ {
     public static void main(String[] args) {

	JSONParser parser = new JSONParser();

	try {

            JSONArray list = (JSONArray)parser.parse(new FileReader("c:/data/test.json"));
            ArrayList<Artikel> ArtikelLijst = new ArrayList();
            for(Object o : list) {
                JSONObject json = (JSONObject)o;
                Artikel artikel = new Artikel();
                artikel.setArtikel_id((int)(long)json.get("artikel_id"));
                artikel.setArtikel_naam((String)json.get("artikel_naam"));
                artikel.setArtikel_prijs(new BigDecimal((long)json.get("artikel_prijs")));
                artikel.setArtikel_voorraad((int)(long)json.get("artikel_voorraad"));
                ArtikelLijst.add(artikel);
            }

            for(Artikel a : ArtikelLijst){
                System.out.print(a.getArtikel_id() + " ");
                System.out.print(a.getArtikel_naam()+ " ");
                System.out.print(a.getArtikel_prijs()+ " ");
                System.out.print(a.getArtikel_voorraad() + " ");
                System.out.println();
            }

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}

     }

}