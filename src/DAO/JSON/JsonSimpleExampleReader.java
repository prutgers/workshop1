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
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimpleExampleReader {
     public static void main(String[] args) {

	JSONParser parser = new JSONParser();

	try {

		Object obj = parser.parse(new FileReader("c:\\data/test.json"));

		JSONObject jsonObject = (JSONObject) obj;

		          System.out.println("size " + jsonObject.size());

		// loop array
                for(int i = 0; i<jsonObject.size()+1; i++){
                    
                    JSONArray msg = (JSONArray) jsonObject.get(Integer.toString(i));
                  
                    
                    for(int j = 0;j<4;j++){
//                        System.out.println("artikel id " + msg.get(j));
                    }
                    
                    //if(msg.isEmpty())"woot"
		          System.out.println("Artikel ID " + i + " " + msg);
                         
                    
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