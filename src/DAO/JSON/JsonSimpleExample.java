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

public class JsonSimpleExample {
     public static void main(String[] args) {

	JSONObject obj = new JSONObject();
	

	JSONArray artikelList = new JSONArray();
        //JSONArray artikel = new JSONArray();
        
        
        //obj.put("artikel_naam", artikel);
        
	
	//artikelList.add(artikel);
        
        

	//obj.put("artikelList", artikelList);
        
        
        for(int i = 1; i<5;i++){
            JSONArray artikel = new JSONArray();
            System.out.println("i " + i);
            artikel.add(i); //artikel id
            artikel.add("koe"); //artikel naam
            artikel.add("23"); //artikel prijs
            artikel.add("5"); //artikel voorraad
            
            System.out.println("artikel " + artikel);
            //obj.put(i, obj.put("artikel ", artikel));
            obj.put(i, artikel);
        }
        
        //obj.put("artikel", artikel);
        
                

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
