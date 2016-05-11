/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.XML;

import POJO.Klant;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import interfaceDAO.KlantDAO;

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

/**
 *
 * @author Peter
 */
public class KlantDAOXML implements KlantDAO {
    static Logger logger = LoggerFactory.getLogger(KlantDAOXML.class);
 
    private String fileLocation = "/home/lucas/Documents/Java/workshopdbKlant.xml";

    @Override
    public Klant createKlant(Klant klant){
        ArrayList<Klant> klantLijst = this.readFile();
        boolean klantAlreadyInDB = false;
        
        //check voor duplicaten
        if (!klantLijst.isEmpty()){
            for(Klant o : klantLijst) {
                if (   (
                        klant.getKlant_id() == 0 ||
                        klant.getKlant_id() == o.getKlant_id()
                        ) || ( (
                            klant.getVoornaam().equals( o.getVoornaam() )
                            ) && (
                            klant.getAchternaam().equals( o.getAchternaam() )
                            ) && (
                            klant.getTussenvoegsel().equals( o.getTussenvoegsel() )
                            ) )
                    ) {
                        klantAlreadyInDB = true;
                        System.out.print("Deze klant bestaat al. Probeer opnieuw.");
                        break;
                }
            }
        }
        //Schrijf de klant in de ArrayList
        if (!klantAlreadyInDB){
            
            //vind hoogste klant_id ; 
            //moet eigelijk met Collections.max(JSONObject) maar dat duurt te lang
            
            int klant_id = 0;
            if (!klantLijst.isEmpty()){
                Klant lastKlant = klantLijst.get( klantLijst.size()-1 );
                klant_id = lastKlant.getKlant_id()+1;
            }
            klant.setKlant_id(klant_id);
            klantLijst.add(klant);
        }
        
        //sla ArrayList op
        this.writeFile( klantLijst );
        
        return klant;  
    }

    @Override
    public Klant readKlant(int klant_id) {
        ArrayList<Klant> klantLijst = this.readFile();
        Klant outputKlant = new Klant();
        boolean klantFound = false;
        
        for(Klant o : klantLijst) {
            if ( klant_id == o.getKlant_id() ){
                outputKlant.setVoornaam( o.getVoornaam() );
                outputKlant.setAchternaam( o.getAchternaam() );
                outputKlant.setTussenvoegsel( o.getTussenvoegsel() );
                outputKlant.setEmail( o.getEmail() );
                klantFound = true;
                break;
            }
        }
        if (klantFound == false){
            System.out.print("Deze klant bestaat niet. Probeer opnieuw.");
        }
        
        return outputKlant;
    }

    @Override
    public Klant updateKlant(Klant klant) {  
        ArrayList<Klant> klantLijst = this.readFile();
        
        //vind de klant
        for(Klant o : klantLijst) {
            if (klant.getKlant_id() == o.getKlant_id()
                  ){
                o.setVoornaam( klant.getVoornaam() );
                o.setAchternaam( klant.getAchternaam() );
                o.setTussenvoegsel( klant.getTussenvoegsel() );
                o.setEmail( klant.getEmail() );
                break;
            }
        }
        this.writeFile( klantLijst );
        
        return klant;
    }

    @Override
    public void deleteKlant(int klant_id) {
        ArrayList<Klant> klantLijst = this.readFile();
        for(Klant o : klantLijst) {
            if ( klant_id == o.getKlant_id() ){
                    klantLijst.remove(o); 
                    break;
                }
        }
        this.writeFile( klantLijst );
    }

    @Override
    public ArrayList<Klant> readAllKlantByKlant(Klant klant) {
        ArrayList<Klant> klantLijst = this.readFile();
        int i = 0;
        for(Klant o : klantLijst) {
            if (    (
                    klant.getKlant_id() == 0 ||
                        klant.getKlant_id() == o.getKlant_id()
                    ) && (
                    klant.getVoornaam() == null ||
                        klant.getVoornaam().equals( o.getVoornaam() )
                    ) && (
                    klant.getAchternaam() == null ||
                    klant.getAchternaam().equals( o.getAchternaam() )
                    ) && (
                    klant.getTussenvoegsel() == null ||
                    klant.getTussenvoegsel().equals( o.getTussenvoegsel() )
                    ) && (
                    klant.getEmail() == null ||
                    klant.getEmail().equals( o.getEmail() )
                    )
                 ){
                Klant outputKlant = new Klant();
                outputKlant.setKlant_id( o.getKlant_id() );
                outputKlant.setVoornaam( o.getVoornaam() );
                outputKlant.setAchternaam( o.getAchternaam() );
                outputKlant.setTussenvoegsel( o.getTussenvoegsel() );
                outputKlant.setEmail( o.getEmail() );
                i++;
                klantLijst.add(outputKlant);
                }
            }
        System.out.println("Er zijn " + i + " klanten die met de zoekopdracht overeenkomen:");
        return klantLijst;
    }
   
    private ArrayList<Klant> readFile(){
        ArrayList<Klant> klantList = new ArrayList();
        try (
                FileInputStream fis = new FileInputStream(fileLocation);
                BufferedInputStream bis = new BufferedInputStream(fis);
                XMLDecoder xmlDecoder = new XMLDecoder(bis);
                ) {
            klantList = (ArrayList)xmlDecoder.readObject();
        }
        catch(IOException ex){
            logger.error("\nInput/Output Exception. Probeer opnieuw.");
        }
        return klantList;
    }
    
    private void writeFile(ArrayList<Klant> klantList){
        try (
                FileOutputStream fos = new FileOutputStream(fileLocation);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                XMLEncoder xmlEncoder = new XMLEncoder(bos);
                ) {
            xmlEncoder.writeObject(klantList);}
        catch(IOException ex){
            logger.error("\nInput/Output Exception. Probeer opnieuw.");
        }
    }
}
