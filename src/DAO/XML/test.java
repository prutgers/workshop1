/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.XML;

import POJO.Bestelling;
import java.beans.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Gebruiker
 */
public class test {
    public static void main(String[]args) throws Exception{
        try{
            write();
            read();
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
           
    }
    
    public static void read() throws Exception{
            FileInputStream fis = new FileInputStream("c:/data/xml/bestelling.xml");
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xmlDecoder = new XMLDecoder(bis);
            ArrayList<Bestelling> lijst = (ArrayList<Bestelling>) xmlDecoder.readObject();

            for (Bestelling bestelling : lijst) {
                    System.out.println(bestelling.getBestellingID());
                    System.out.println(bestelling.getKlantID());
            }

	}
    
    
    
    public static void write() throws Exception{
                Bestelling bestelling = new Bestelling();
		bestelling.setBestellingID(100);
                bestelling.setKlantID(2);
                ArrayList<Bestelling> lijst = new ArrayList<>();

                lijst.add(bestelling);
                lijst.add(bestelling);
                lijst.add(bestelling);
                
		FileOutputStream fos = new FileOutputStream("c:/data/xml/bestelling.xml");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		XMLEncoder xmlEncoder = new XMLEncoder(bos);
		//xmlEncoder.writeObject(bestelling);
		xmlEncoder.writeObject(lijst);
		xmlEncoder.close();
    }
    		
    
}
