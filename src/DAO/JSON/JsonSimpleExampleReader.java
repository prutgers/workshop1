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
            System.out.println("ik ben");
		JSONObject jsonObject = (JSONObject) obj;
                
                System.out.println("ik ben hier");

		String name = (String) jsonObject.get("name");
		System.out.println(name);

		

		// loop array
		JSONArray msg = (JSONArray) jsonObject.get("messages");
		Iterator<String> iterator = msg.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
                
               
                
                lapply(readLines(filename), fromJSON, flatten = TRUE);

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}

     }

}