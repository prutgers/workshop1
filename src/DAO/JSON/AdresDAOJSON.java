package DAO.JSON;

import POJO.Adres;
import interfaceDAO.AdresDAO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Sonja
 */
public class AdresDAOJSON implements AdresDAO {
    
    @Override
    public Adres createAdres(Adres adres) {
        JSONArray adresGegevens = new JSONArray();
        JSONParser parser = new JSONParser();
        File file = new File("C:/data/JSON/adresgegevens.json");
        int adresID;
        
        try {
            adresGegevens = (JSONArray)parser.parse(new FileReader("C:/data/JSON/adresgegevens.json"));    
        
            if(adresGegevens.isEmpty()) {
                adresID = 1;
            }
            else {
                JSONObject adresJSON = (JSONObject)adresGegevens.get(adresGegevens.size()-1);
                adresID = (int)(long)adresJSON.get("adresID") + 1;
            } 
          
            JSONObject adresObject = new JSONObject();
            adresObject.put("adres_id", adresID);
            adresObject.put("straatnaam", adres.getStraatnaam());
            adresObject.put("huisnummer", adres.getHuisnummer());
            adresObject.put("toevoeging", adres.getToevoeging());
            adresObject.put("postcode", adres.getPostcode());
            adresObject.put("woonplaats", adres.getWoonplaats());
            adresGegevens.add(adresObject);
        }
        
        catch (ParseException | IOException ex) {
            java.util.logging.Logger.getLogger(AdresDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try (FileWriter fileWriter = new FileWriter(
                "C:/data/JSON/adresgegevens.json")) {
            fileWriter.write(adresGegevens.toJSONString());
            fileWriter.flush();
        }
        
        catch (IOException ex) {
        } 
        
        return adres;
    }

    @Override
    public ArrayList<Adres> readAdres() {
        JSONArray adresGegevens = new JSONArray();
        JSONParser parser = new JSONParser();
        File file = new File("C:/data/JSON/adresgegevens.json");
        ArrayList<Adres> adressenLijst = new ArrayList();
        
        try {
            adresGegevens = (JSONArray)parser.parse(new FileReader("C:/data/JSON/adresgegevens.json"));
            
            for (Object a : adresGegevens) {
                JSONObject adresObject = (JSONObject)a;
                Adres adres = new Adres();
                adres.setAdres_id((int)(long)adresObject.get("adres_id"));
                adres.setStraatnaam((String)adresObject.get("straatnaam"));
                adres.setHuisnummer((int)(long)adresObject.get("huisnummer"));
                adres.setToevoeging((String)adresObject.get("toevoeging"));
                adres.setPostcode((String)adresObject.get("postcode"));
                adres.setWoonplaats((String)adresObject.get("woonplaats"));
            }
            
            try (FileWriter fileWriter = new FileWriter(
                    "C:/data/JSON/adresgegevens.json")) {
                fileWriter.write(adresGegevens.toJSONString());
                fileWriter.flush();
            }
        }
        
        catch (IOException | ParseException ex) {
            java.util.logging.Logger.getLogger(AdresDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return adressenLijst;
    }

    @Override
    public Adres readAdresByID(int adresID) {
        JSONArray adresGegevens = new JSONArray();
        JSONParser parser = new JSONParser();
        File file = new File("C:/data/JSON/adresgegevens.json");
        Adres adres = new Adres();
        
        try {
            adresGegevens = (JSONArray)parser.parse(new FileReader("C:/data/JSON/adresgegevens.json"));
            
            for (Object a : adresGegevens) {
                JSONObject adresObject = (JSONObject)a;
            
                if((int)(long)adresObject.get("adres_id") == adresID) {
                    adres.setAdres_id((int)(long)adresObject.get("adres_id"));
                    adres.setStraatnaam((String)adresObject.get("straatnaam"));
                    adres.setHuisnummer((int)(long)adresObject.get("huisnummer"));
                    adres.setToevoeging((String)adresObject.get("toevoeging"));
                    adres.setPostcode((String)adresObject.get("postcode"));
                    adres.setWoonplaats((String)adresObject.get("woonplaats"));
                }    
            }
            
            try (FileWriter fileWriter = new FileWriter(
                    "C:/data/JSON/adresgegevens.json")) {
                fileWriter.write(adresGegevens.toJSONString());
                fileWriter.flush();
            }
        }
        
        catch (FileNotFoundException ex) {
        }        
        catch (IOException | ParseException ex) {
        }
        
        return adres;
    }

    @Override
    public void updateAdres(Adres adres) {
        JSONArray adresGegevens = new JSONArray();
        JSONParser parser = new JSONParser();
        File file = new File("C:/data/JSON/adresgegevens.json");
        
        try {
            adresGegevens = (JSONArray)parser.parse(new FileReader("C:/data/JSON/adresgegevens.json"));
            
            for (Object a : adresGegevens) {
                JSONObject adresObject = (JSONObject)a;
                int adresID = (int)(long)adresObject.get("adres_id");                
                
                if(adresID == adres.getAdres_id()) {
                    adresObject.put("straatnaam", adres.getStraatnaam());
                    adresObject.put("huisnummer", adres.getHuisnummer());
                    adresObject.put("toevoeging", adres.getToevoeging());
                    adresObject.put("postcode", adres.getPostcode());
                    adresObject.put("woonplaats", adres.getWoonplaats());
                }
            }
            
            try (FileWriter fileWriter = new FileWriter(
                    "C:/data/JSON/adresgegevens.json")) {
                fileWriter.write(adresGegevens.toJSONString());
                fileWriter.flush();
            }
        }
        
        catch (FileNotFoundException ex) {
        }
        catch (IOException | ParseException ex) {
        }
    }

    @Override
    public void deleteAdres(int adres_id) {
        JSONArray adresGegevens = new JSONArray();
        JSONParser parser = new JSONParser();
        File file = new File("C:/data/JSON/adresgegevens.json");
        
        try {
            adresGegevens = (JSONArray)parser.parse(new FileReader("C:/data/JSON/adresgegevens.json"));
            
            if(!adresGegevens.isEmpty()) {
                for(int i = 0; i < adresGegevens.size(); i++) {
                    JSONObject adresObject = (JSONObject)adresGegevens.get(i);
                    if((int)(long)adresObject.get("adres_id") == adres_id) {
                        adresGegevens.remove(i);
                    }
                }
            }
            
            try (FileWriter fileWriter = new FileWriter(
                    "C:/data/JSON/adresgegevens.json")) {
                fileWriter.write(adresGegevens.toJSONString());
                fileWriter.flush();
            }
        }
        
        catch (FileNotFoundException ex) {
        }
        catch (IOException | ParseException ex) {
        }
    }
}
