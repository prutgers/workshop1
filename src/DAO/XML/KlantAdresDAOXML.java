/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.XML;

/**
 *
 * @author lucas
 */
import DAOFactory.DAOFactory;
import interfaceDAO.AdresDAO;
import POJO.Adres;
import POJO.KlantAdres;
import interfaceDAO.KlantAdresDAO;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Closeable;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KlantAdresDAOXML implements KlantAdresDAO {
    static Logger logger = LoggerFactory.getLogger(KlantAdresDAOXML.class);
    private String fileLocation = "/home/lucas/Documents/Java/workshopdbKlantAdres.xml";
     
    @Override
    public KlantAdres createKlantAdresKoppel(KlantAdres koppel){
        ArrayList<KlantAdres> klantAdresLijst = this.readFile();
        
            //vind hoogste klant_id 
            //moet eigelijk met Collections.max(JSONObject) maar dat duurt te lang
        int klant_id = 0;
        if (!klantAdresLijst.isEmpty()){
            KlantAdres lastKoppel = klantAdresLijst.get( klantAdresLijst.size()-1 );
            klant_id = lastKoppel.getKlant_id()+1;
        }
        koppel.setKoppel_id(klant_id);
        klantAdresLijst.add(koppel);
        
        //sla ArrayList op
        this.writeFile( klantAdresLijst );
        
        return koppel;  
    }
    
    @Override
    public ArrayList<Integer> readKlantID(int adres_id){
        ArrayList<KlantAdres> klantAdresLijst = this.readFile();
        ArrayList<Integer> allKlant_id = new ArrayList();
        boolean koppelFound = false;
        
        for(KlantAdres o : klantAdresLijst) {
            if ( adres_id == o.getAdres_id() ){
                allKlant_id.add( o.getAdres_id() );
            }
        }
        if (koppelFound == false){
            System.out.print("Deze klant bestaat niet. Probeer opnieuw.");
        }
        return allKlant_id;
    }
    
    @Override
    public ArrayList<Adres> readAdresID(int klant_id){
        ArrayList<KlantAdres> klantAdresLijst = this.readFile();
        ArrayList<Adres> allAdresLijst = new ArrayList();
        boolean koppelFound = false;
        
        for(KlantAdres o : klantAdresLijst) {
            if ( klant_id == o.getKlant_id() ){
                Adres adres = DAOFactory.getAdresDAO().readAdresByID( o.getAdres_id() );
                allAdresLijst.add(adres);
            }
        }
        if (koppelFound == false){
            System.out.print("Deze klant bestaat niet. Probeer opnieuw.");
        }
        
        return allAdresLijst;
    }
    
    @Override
    public void updateKlantAdresKoppel(){
        throw new UnsupportedOperationException("Deze taak heeft geen functie."); 
    }
    
    @Override
    public void deleteKlantAdresKoppel(int klant_id){
        ArrayList<KlantAdres> klantAdresLijst = this.readFile();
        for(KlantAdres o : klantAdresLijst) {
            if ( klant_id == o.getKlant_id() ){
                    klantAdresLijst.remove(o); 
                    break;
                }
        }
        this.writeFile( klantAdresLijst );
    }
    
    @Override
    public void deleteAdresKlantKoppel(int adres_id){
        ArrayList<KlantAdres> klantAdresLijst = this.readFile();
        for(KlantAdres o : klantAdresLijst) {
            if ( adres_id == o.getAdres_id() ){
                    klantAdresLijst.remove(o); 
                    break;
                }
        }
        this.writeFile( klantAdresLijst );
    }
   
    private ArrayList<KlantAdres> readFile(){
        ArrayList<KlantAdres> klantList = new ArrayList();
        try (
                FileInputStream fis = new FileInputStream(fileLocation);
                BufferedInputStream bis = new BufferedInputStream(fis);
                XMLDecoder xmlDecoder = new XMLDecoder(bis);
                ) {
            klantList = (ArrayList)xmlDecoder.readObject();
        }
        catch(IOException ex){
            logger.error("/nInput/Output Exception. Probeer opnieuw.");
        }
        return klantList;
    }
    
    private void writeFile(ArrayList<KlantAdres> klantList){
        try (
                FileOutputStream fos = new FileOutputStream(fileLocation);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                XMLEncoder xmlEncoder = new XMLEncoder(bos);
                ) {
            xmlEncoder.writeObject(klantList);}
        catch(IOException ex){
            logger.error("/nInput/Output Exception. Probeer opnieuw.");
        }
    }
}
