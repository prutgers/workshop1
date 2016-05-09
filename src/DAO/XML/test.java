/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.XML;

import POJO.*;
import java.beans.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Gebruiker
 */
public class test {
    public static void main(String[]args) throws Exception{
        try{
            writeArtikel();
            readArtikel();
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
           
    }
    
    public static void readArtikel() throws Exception{
            FileInputStream fis = new FileInputStream("c:/data/xml/artikel.xml");
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xmlDecoder = new XMLDecoder(bis);
            ArrayList<Artikel> lijst = (ArrayList<Artikel>) xmlDecoder.readObject();

            for (Artikel artikel : lijst) {
                    System.out.println("//////");
                    System.out.println(artikel.getArtikel_id());
                    System.out.println(artikel.getArtikel_naam());
                    System.out.println(artikel.getArtikel_prijs());
                    System.out.println(artikel.getArtikel_voorraad());
            }
            xmlDecoder.close();

            System.out.println("read");
	}
    
    
    
    public static void writeArtikel() throws Exception{
                Artikel artikel = new Artikel();
		artikel.setArtikel_id(1);
                artikel.setArtikel_naam("test");
                artikel.setArtikel_prijs(new BigDecimal(100));
                artikel.setArtikel_voorraad(999);
                ArrayList<Artikel> lijst = new ArrayList<>();

                lijst.add(artikel);
                lijst.add(artikel);
                lijst.add(artikel);
                
		FileOutputStream fos = new FileOutputStream("c:/data/xml/artikel.xml");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		XMLEncoder xmlEncoder = new XMLEncoder(bos);
                
      
                xmlEncoder.setPersistenceDelegate(BigDecimal.class,  xmlEncoder.getPersistenceDelegate(Integer.class));


                
		//xmlEncoder.writeObject(bestelling);
		xmlEncoder.writeObject(lijst);
		xmlEncoder.close();
                System.out.println("written");
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
            xmlDecoder.close();

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
