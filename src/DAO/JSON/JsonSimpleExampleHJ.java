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
import POJO.Artikel;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * Array 1 
 *      Array 2 met artikelen
 * @author Peter
 */

public class JsonSimpleExampleHJ {
     public static void main(String[] args) {

         Artikel artikel = new Artikel();
         artikel.setArtikel_id(1);
         artikel.setArtikel_naam("kast");
         artikel.setArtikel_prijs(new BigDecimal(199));
         artikel.setArtikel_voorraad(10);
         
	JSONObject obj = new JSONObject();
        obj.put("artikel_id", artikel.getArtikel_id());
        obj.put("artikel_naam", artikel.getArtikel_naam());
        obj.put("artikel_prijs", artikel.getArtikel_prijs());
        obj.put("artikel_voorraad", artikel.getArtikel_voorraad());

	JSONArray artikelList = new JSONArray();
	artikelList.add(obj);
	artikelList.add(obj);
	artikelList.add(obj);
        
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
