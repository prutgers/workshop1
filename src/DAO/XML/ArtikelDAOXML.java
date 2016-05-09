/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.XML;

import POJO.Artikel;
import interfaceDAO.ArtikelDAO;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.math.BigDecimal;

/**
 *
 * @author Peter
 */
public class ArtikelDAOXML implements ArtikelDAO{

    @Override
    public Artikel createArtikel(Artikel artikel) {
        ArrayList<Artikel> lijst = new ArrayList<>();
        File file = new File("c:/data/xml/artikel.xml");
        if(file.exists()){
            lijst = readFile();
            Artikel getHighestArtikelID = lijst.get(lijst.size()-1);
            artikel.setArtikel_id(getHighestArtikelID.getArtikel_id()+1);
        }
        else{
            artikel.setArtikel_id(1);
        }
        lijst.add(artikel);
        writeFile(lijst);
        return artikel;
    }

    @Override
    public Artikel readArtikel(int artikel_id) {
        ArrayList<Artikel> lijst = readFile();
        Artikel artikel = new Artikel();
        for(Artikel a : lijst){
            if(a.getArtikel_id()== artikel_id){
                artikel = a;
            }
        }
        return artikel;
    }

    @Override
     public ArrayList<Artikel> readArtikel() {
         ArrayList<Artikel> lijst = readFile();
        return lijst;
    }

    @Override
    public void updateArtikel(Artikel artikel) {
        ArrayList<Artikel> lijst = readFile();
        for(Artikel a : lijst){
            if(a.getArtikel_id() == artikel.getArtikel_id()){
                a.setArtikel_naam(artikel.getArtikel_naam());
                a.setArtikel_prijs(artikel.getArtikel_prijs());
                a.setArtikel_voorraad(artikel.getArtikel_voorraad());
                
            }
        }
        writeFile(lijst);
    }

    @Override
    public void deleteArtikel(int artikel_id) {
        ArrayList<Artikel> lijst = readFile();
        for(Artikel a : lijst){
            if(a.getArtikel_id() == artikel_id)
                lijst.remove(a);
        }
        writeFile(lijst);
    }
    
    private ArrayList<Artikel> readFile() {
        ArrayList<Artikel> lijst = new ArrayList<>();
        File file = new File("c:/data/xml/artikel.xml");
        if(!file.exists()){
            System.out.println("Er is nog geen Data");
            return lijst;
        }
        try{
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xmlDecoder = new XMLDecoder(bis);
            lijst = (ArrayList<Artikel>) xmlDecoder.readObject();               
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return lijst;
    }
    
    private void writeFile (ArrayList<Artikel> lijst) {
        
        try{
            FileOutputStream fos = new FileOutputStream("c:/data/xml/Artikel.xml");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            XMLEncoder xmlEncoder = new XMLEncoder(bos);
            xmlEncoder.setPersistenceDelegate(java.math.BigDecimal.class,  xmlEncoder.getPersistenceDelegate(Integer.class));
            xmlEncoder.writeObject(lijst);
            xmlEncoder.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    
}
