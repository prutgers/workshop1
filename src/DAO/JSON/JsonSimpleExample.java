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

public class JsonSimpleExample {
 
     public static void main(String[] args) {

	JSONObject obj = new JSONObject();
	obj.put("name", "mkyong.cfom");
	obj.put("age", new Integer(100));

	JSONArray list = new JSONArray();
	list.add("msgf 1");
	list.add("msg 2");
	list.add("msg 3");

	obj.put("messages", list);
        


	try {

		FileWriter file = new FileWriter("c:\\data/test.json");
		file. (obj.toJSONString());
                file.flush();
		file.close();

	} catch (IOException e) {
		e.printStackTrace();
	}

	System.out.print(obj);

     }

}
