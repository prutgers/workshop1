package DAO.XML;

import POJO.Adres;
import interfaceDAO.AdresDAO;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sonja
 */
public class AdresDAOXML implements AdresDAO {

    @Override
    public Adres createAdres(Adres adres) {
        ArrayList<Adres> adresGegevens = new ArrayList<>();
        File file = new File("C:/data/XML/adres.xml");
        if(file.exists()) {
            adresGegevens = readAdresFile();
            Adres tAdres = adresGegevens.get(adresGegevens.size()-1);
            adres.setAdres_id(tAdres.getAdres_id()+1);
        }
        else {
            adres.setAdres_id(1);
        }
        adresGegevens.add(adres);
        writeAdresFile(adresGegevens);
        return adres;
    }

    @Override
    public ArrayList<Adres> readAdres() {
        ArrayList<Adres> adresGegevens = readAdresFile();
        return adresGegevens;
    }

    @Override
    public Adres readAdresByID(int adresID) {
        ArrayList<Adres> adresGegevens = readAdres();
        Adres adres = new Adres();
        for(Adres a : adresGegevens) {
            if(a.getAdres_id() == adresID) {
                adres = a;
            }
        }
        
        return adres;
    }

    @Override
    public void updateAdres(Adres adres) {
        ArrayList<Adres> adresGegevens = readAdresFile();
        for(Adres a : adresGegevens) {
            if (a.getAdres_id() == adres.getAdres_id()) {
                a.setStraatnaam(adres.getStraatnaam());
                a.setHuisnummer(adres.getHuisnummer());
                a.setToevoeging(adres.getToevoeging());
                a.setPostcode(adres.getPostcode());
                a.setWoonplaats(adres.getWoonplaats());
            }
        }
    }

    @Override
    public void deleteAdres(int adres_id) {
        ArrayList<Adres> adresGegevens = readAdresFile();
        for(Adres a : adresGegevens) {
            if(a.getAdres_id() == adres_id)
                adresGegevens.remove(a);
        }
        
        writeAdresFile(adresGegevens);
    }
    
    private ArrayList<Adres> readAdresFile() {
        ArrayList<Adres> adresGegevens = new ArrayList<>();
        File file = new File("C:/data/XML/adresgegevens.xml");
        if(!file.exists()) {
            System.out.println("Het bestand bestaat nog niet. Probeer opnieuw.");
            return adresGegevens;
        }
        try {
            FileInputStream fileInput = new FileInputStream(file);
            BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);
            XMLDecoder xmlDecoder = new XMLDecoder(bufferedInput);
            adresGegevens = (ArrayList<Adres>)xmlDecoder.readObject();
        } 
        
        catch (FileNotFoundException ex) {
            Logger.getLogger(AdresDAOXML.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex + "\n\nHet bestand kon niet worden gevonden. Probeer opnieuw.");
        }
        
        return adresGegevens;
    }
    
    private void writeAdresFile (ArrayList<Adres> adresGegevens) {
        try {
            FileOutputStream fileOutput = new FileOutputStream("C:/data/XML/adresgegevens.xml");
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
            XMLEncoder xmlEncoder = new XMLEncoder(bufferedOutput);
            xmlEncoder.writeObject(adresGegevens);
            xmlEncoder.close();
        } 
        
        catch (FileNotFoundException ex) {
            Logger.getLogger(AdresDAOXML.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex + "\n\nHet bestand kon niet worden gevonden. Probeer opnieuw.");
        }
    }
}
