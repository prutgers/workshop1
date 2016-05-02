/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.JSON;

/**
 *
 * @author Peter
 */
import DAO.MySQL.ArtikelDAO;
import POJO.Artikel;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * Array 1 
 *      Array 2 met artikelen
 * @author Peter
 */

public class JsonSimpleExample {
     public static void main(String[] args) {

	JSONObject objArtikel = new JSONObject();
        
        objArtikel.put("artikel_id", 1);
        objArtikel.put("artikel_naam", "koe");
        objArtikel.put("artikel_prijs", 2);
        objArtikel.put("artikel_voorraad", 15);
        
        JSONObject artikelLijst = new JSONObject();
        
        artikelLijst.put("test", objArtikel);
	

	/**ja
         ArrayList<Artikel> artikelLijst = ArtikelDAO.readArtikel();
         
       for(Artikel a : artikelLijst){
        JSONArray artikel = new JSONArray();
            
            artikel.add(a.getArtikel_id()); //artikel id
            artikel.add(a.getArtikel_naam()); //artikel naam
            artikel.add(a.getArtikel_prijs()); //artikel prijs
            artikel.add(a.getArtikel_voorraad()); //artikel voorraad
            
        
            obj.put(a.getArtikel_id(), artikel);
        
        }
        */
        
        for(int i = 1; i<5;i++){
            JSONArray artikel = new JSONArray();
            System.out.println("i " + i);
            artikel.add(i); //artikel id
            artikel.add("koe"); //artikel naam
            artikel.add("23"); //artikel prijs
            artikel.add("5"); //artikel voorraad
            
        
            obj.put(i, artikel);
        }
        
        
        
                

	try {

		FileWriter file = new FileWriter("c:\\data/test.json");
		file.write(obj.toJSONString());
		file.flush();
		file.close();

	} catch (IOException e) {
		e.printStackTrace();
	}

	System.out.print(obj);

     }

}
