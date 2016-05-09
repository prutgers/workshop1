/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.XML;

import POJO.Bestelling;
import interfaceDAO.BestellingDAO;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import org.json.simple.JSONObject;

/**
 *
 * @author Herman rules
 */
public class BestellingDAOXML implements BestellingDAO{

    @Override
    public Bestelling createBestelling(Bestelling bestelling) {
        ArrayList<Bestelling> lijst = new ArrayList<>();
        File file = new File("c:/data/xml/bestelling.xml");
        if(file.exists()){
            lijst = readFile();
            Bestelling tempBestelling = lijst.get(lijst.size()-1);
            bestelling.setBestellingID(tempBestelling.getBestellingID()+1);
        }
        else{
            bestelling.setBestellingID(1);
        }
        lijst.add(bestelling);
        writeFile(lijst);
        return bestelling;
    }

    @Override
    public Bestelling getBestellingById(int BestellingId) {
        ArrayList<Bestelling> lijst = readFile();
        Bestelling bestelling = new Bestelling();
        for(Bestelling b : lijst){
            if(b.getBestellingID() == BestellingId)
                bestelling = b;
        }
        return bestelling;
    }

    @Override
    public ArrayList<Bestelling> getAllBestelling() {
         ArrayList<Bestelling> lijst = readFile();
        return lijst;
    }

    @Override
    public ArrayList<Bestelling> getBestellingByKlantId(int klantId) {
        ArrayList<Bestelling> lijst = readFile();
        ArrayList<Bestelling> nieuweLijst = new ArrayList<Bestelling>();
        for(Bestelling b : lijst){
            if(b.getKlantID() ==  klantId)
                nieuweLijst.add(b);
        }
        return nieuweLijst;
    }

    @Override
    public void updateBestelling(Bestelling bestelling) {
        ArrayList<Bestelling> lijst = readFile();
        for(Bestelling b : lijst){
            if(b.getBestellingID() == bestelling.getBestellingID())
                b.setKlantID(bestelling.getKlantID());
        }
        writeFile(lijst);
    }

    @Override
    public void deleteBestelling(int bestellingID) {
        ArrayList<Bestelling> lijst = readFile();
        for(Bestelling b : lijst){
            if(b.getBestellingID() == bestellingID)
                lijst.remove(b);
        }
        writeFile(lijst);
    }
    
    private ArrayList<Bestelling> readFile() {
        ArrayList<Bestelling> lijst = new ArrayList<>();
        File file = new File("c:/data/xml/bestelling.xml");
        if(!file.exists()){
            System.out.println("Er is nog geen Data");
        }
        try{
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xmlDecoder = new XMLDecoder(bis);
            lijst = (ArrayList<Bestelling>) xmlDecoder.readObject();               
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return lijst;
    }
    private void writeFile (ArrayList<Bestelling> lijst) {
        try{
            FileOutputStream fos = new FileOutputStream("c:/data/xml/bestelling.xml");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            XMLEncoder xmlEncoder = new XMLEncoder(bos);
            //xmlEncoder.writeObject(bestelling);
            xmlEncoder.writeObject(lijst);
            xmlEncoder.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    
}
